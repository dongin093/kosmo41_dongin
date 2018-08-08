import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.print.DocFlavor.STRING;

public class MultiServer {

	ServerSocket serverSocket = null;
	Socket socket = null;
	Map<String, PrintWriter> clientMap;
	boolean check = false;

	// 생성자
	public MultiServer() {
		// 클라이언트의 출력 스트림을 저장할 해쉬맵 생성.
		clientMap = new HashMap<String, PrintWriter>();
		// 해쉬맵 동기화 설정.
		Collections.synchronizedMap(clientMap);
	}

	public void init() {
		try {
			serverSocket = new ServerSocket(9999); // 9999포트로 서버소켓 객체생성
			System.out.println("서버가 시작되었습니다.");
			while (true) {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + ":" + socket.getPort());

				Thread msr = new MultiServerT(socket); // 쓰레드 생성
				msr.start(); // 쓰레드 시동
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 접속된 모든 클라이언트들에게 메시지를 전달.
	public void sendAllMsg(String msg) {
		// 출력스트림을 순차적으로 얻어와서 해당 메시지를 출력한다.
		Iterator it = clientMap.keySet().iterator();

		while (it.hasNext()) {
			try {
				PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
				it_out.println(msg);
			} catch (Exception e) {
				System.out.println("예외 :" + e);
			}
		}
	}

	// 서버관련
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	// 메인
	public static void main(String[] args) {

		// 서버객체 생성
		MultiServer ms = new MultiServer();
		ms.init();

	}

	////////////////////////////////////////////////////////
	// 내부클래스
	// 클라이언트로 부터 읽어온 메시지를 다른 클라이언틑(socket)에 보내는 역할을 하는 메서드
	class MultiServerT extends Thread {
		Socket socket;
		PrintWriter out = null;
		BufferedReader in = null;
		Connection con = null;
		PreparedStatement pstmt = null;

		public void out() {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 생성자.
		public MultiServerT(Socket socket) {
			this.socket = socket;
			try {
				out = new PrintWriter(this.socket.getOutputStream(), true);
				in = new BufferedReader((new InputStreamReader(this.socket.getInputStream())));
			} catch (Exception e) {
				System.out.println("예외 : " + e);
			}
		}

		// 서버인원 list up
		public void showList(String name) {
			Set<String> set = clientMap.keySet();
			// System.out.println(set); // Server출력
			PrintWriter pr = clientMap.get(name);
			pr.println("현재사용자는 " + clientMap.size() + "명 입니다.");
			pr.println(set);
		}

		// 귓속말
		public void showString(String name, String s) {
			String[] str = s.split(" ");
			PrintWriter pr = clientMap.get(str[1]);
			pr.println(name + " (귓속말) " + s.substring(str[0].length() + str[1].length() + 2));

		}

		// 방만들기
		public void Room_Make(String name) {
			try {
				String s = "";
				out.println("공개방은 open , 비공개방는 secret 으로 선택해주세요");
				s = in.readLine();
				String[] str = s.split(" ");
				if (str[0].equals("[" + name + "]" + ":" + "open") || str[0].equals("[" + name + "]" + ":" + "OPEN")) {
					out.println("방제목을 설정해 주세요");

					s = in.readLine();
					String[] str1 = s.split(":");
					try {
						String sql = "insert into room values(?,?)";
						con = DriverManager.getConnection(
								"jdbc:oracle:thin:@ec2-52-79-228-239.ap-northeast-2.compute.amazonaws.com:1521:xe",
								"scott", "tiger");
						pstmt = con.prepareStatement(sql);
						// 방번호 어케...??
						// String i = "1";
						// pstmt.setString(1, i);

						pstmt.setString(1, str1[1]);
						pstmt.setString(2, name);
						int updateCount = pstmt.executeUpdate();
						System.out.println(str1[1]);

						sql = "update list set r_name = '" + str1[1] + "' where name = '" + name + "'";
						pstmt = con.prepareStatement(sql);
						updateCount = pstmt.executeUpdate();

					} catch (SQLException sqle) {
						System.out.println("Connection Error");
						sqle.printStackTrace();
					} finally {
						pstmt.close();
						con.close();
					}
				} else if (str[0].equals("[" + name + "]" + ":" + "secret")
						|| str[0].equals("[" + name + "]" + ":" + "SECRET")) {

				}
			} catch (Exception e) {
				System.out.println("예외 : " + e);
			}

		}

		// 방리스트 확인
		public void Room_Check(String name) {

			try {
				try {

					String sql = "select * from room ";
					con = DriverManager.getConnection(
							"jdbc:oracle:thin:@ec2-52-79-228-239.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
							"tiger");

					pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						PrintWriter pr = clientMap.get(name);
						pr.println(rs.getString(1));
					}
					rs.close();
					pstmt.close();
					con.close();
				} catch (SQLException sqle) {
					System.out.println("Connection Error");
					sqle.printStackTrace();
				}
			} catch (Exception e) {

			}
		}

		// 방입장
		public void Room_Join(String name, String s) {
			try {
				try {
					con = DriverManager.getConnection(
							"jdbc:oracle:thin:@ec2-52-79-228-239.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
							"tiger");

					String[] str = s.split(" ");
					String sql = "update list set r_name = '" + str[1] + "' where name = '" + name + "'";
					pstmt = con.prepareStatement(sql);
					int updateCount = pstmt.executeUpdate();

					pstmt.close();
					con.close();
				} catch (SQLException sqle) {
					System.out.println("Connection Error");
					sqle.printStackTrace();
				}
			} catch (Exception e) {

			}
		}

		// 공지사항
		public void Notice(String s) {
			Iterator it = clientMap.keySet().iterator();
			String[] str = s.split("e");
			while (it.hasNext()) {
				try {
					PrintWriter it_out = (PrintWriter) clientMap.get(it.next());
					it_out.println("[공지사항] : " + str[1]);
				} catch (Exception e) {
					System.out.println("예외 :" + e);
				}
			}

		}

		// 방멤버끼리 대화
		public void talk(String name, String s) {
			try {
				String r_name1 = "";
				String r_name2 = "";

				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@ec2-52-79-228-239.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
						"tiger");
				String sql = "select r_name from list where name = '" + name + "'";
				pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					r_name1 = rs.getString(1);
				}
				rs.close();
				pstmt.close();
				// 출력스트림을 순차적으로 얻어와서 해당 메시지를 출력한다.
				Iterator<String> it = clientMap.keySet().iterator();
				while (it.hasNext()) {
					String nname = it.next();
					sql = "select r_name from list where name = '" + nname + "'";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						r_name2 = rs.getString(1);
					}
					if (r_name1.equals(r_name2)) {
						try {
							PrintWriter it_out = (PrintWriter) clientMap.get(nname);
							it_out.println(s);
						} catch (Exception e) {
							System.out.println("예외 :" + e);
						}

					} else {
						continue;
					}

				}

				pstmt.close();
				con.close();
			} catch (SQLException sqle) {
				System.out.println("Connection Error");
				sqle.printStackTrace();
			}
		}

		// 대기실 멤버 확인
		public void WaitList(String name) {
			try {
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@ec2-52-79-228-239.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
						"tiger");
				String sql = "select name from list where r_name = '대기실'";
				pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				sql = "select count(*) from list where r_name = '대기실'";
				PreparedStatement pstmt1 = con.prepareStatement(sql);
				ResultSet rs1 = pstmt1.executeQuery();
				PrintWriter it_out = (PrintWriter) clientMap.get(name);
				while (rs1.next()) {
					it_out.println("현재 대기실 인원은 : " + rs1.getString(1) + " 명입니다.");
				}
				while (rs.next()) {
					it_out.print(rs.getString(1));
					it_out.print(" ");
				}
				it_out.println();
				rs.close();
				pstmt.close();
				rs1.close();
				pstmt1.close();
				con.close();
			} catch (SQLException sqle) {
				System.out.println("Connection Error");
				sqle.printStackTrace();
			}
		}

		// 룸멤버 확인
		public void WaitRoomList(String name) {
			try {
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@ec2-52-79-228-239.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
						"tiger");
				String sql = "select name from list where r_name in (select r_name from list where name = '" + name
						+ "')";
				pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				sql = "select count(*) from list where r_name in (select r_name from list where name = '" + name + "')";
				PreparedStatement pstmt1 = con.prepareStatement(sql);
				ResultSet rs1 = pstmt1.executeQuery();
				PrintWriter it_out = (PrintWriter) clientMap.get(name);
				while (rs1.next()) {
					it_out.println("현재 속한 방 인원은 : " + rs1.getString(1) + " 명 입니다.");
				}
				while (rs.next()) {
					it_out.print(rs.getString(1));
					it_out.print(" ");
				}
				it_out.println();
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException sqle) {
				System.out.println("Connection Error");
				sqle.printStackTrace();
			}
		}

		// 룸나가기
		public void RoomOut(String name) {
			try {
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@ec2-52-79-228-239.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
						"tiger");
				String sql = "select name from list where r_name in (select r_name from list where name = '" + name
						+ "')";
				PreparedStatement pstmt1 = con.prepareStatement(sql);
				ResultSet rs1 = pstmt1.executeQuery();

				while (rs1.next()) {
					PrintWriter it_out = (PrintWriter) clientMap.get(rs1.next());
					it_out.println("[" + name + "] 님이 퇴장하셨습니다.");
				}
				sql = "update list set r_name = '대기실' where name = '" + name + "'";
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate();

				pstmt.close();
				con.close();
			} catch (SQLException sqle) {
				System.out.println("Connection Error");
				sqle.printStackTrace();
			}
		}

		// 방장바꾸기
		public void ChangeBoss(String name, String s) {
			try {
				String v1 = "";
				String v2 = "";
				String v3 = "";
				String[] str = s.split(" ");
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@ec2-52-79-228-239.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
						"tiger");
				// 채팅친사람 위치
				String sql = "select r_name from list where name = '" + name + "'";
				PreparedStatement pstmt1 = con.prepareStatement(sql);
				ResultSet rs1 = pstmt1.executeQuery();
				while (rs1.next()) {
					v1 = rs1.getString(1);
				}
				// 변경하려고 하는사람 위치
				sql = "select r_name from list where name = '" + str[1] + "'";
				pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					v2 = rs.getString(1);
				}

				// 채팅친사람 반장 여부
				sql = "select r_boss from room";
				PreparedStatement pstmt3 = con.prepareStatement(sql);
				ResultSet rs2 = pstmt3.executeQuery();
				while (rs2.next()) {
					if (name.equals(rs2.getString(1))) {
						v3 = rs2.getString(1);
					} else {
						try {
							PrintWriter it_out = (PrintWriter) clientMap.get(name);
							it_out.println("당신은 권한이 없습니다.");
						} catch (Exception e) {
							System.out.println("예외 :" + e);
						}
						v3 = v2;
					}

				}
				if (v1.equals(v2) && v3.equals(name)) {
					sql = "update room set r_boss = '" + str[1] + "' where r_boss = '" + name + "'";
					PreparedStatement pstmt2 = con.prepareStatement(sql);
					pstmt2.executeUpdate();
					pstmt2.close();
				} else if (!v1.equals(v2)){

					try {
						PrintWriter it_out = (PrintWriter) clientMap.get(name);
						it_out.println("상대방이 당신과 같의방에 있지 않습니다.");
					} catch (Exception e) {
						System.out.println("예외 :" + e);
					}
				}

				rs.close();
				rs1.close();
				rs2.close();
				pstmt1.close();
				pstmt.close();
				pstmt3.close();
				con.close();
			} catch (SQLException sqle) {
				System.out.println("Connection Error");
				sqle.printStackTrace();
			}
		}

		// 강퇴하기
		public void Ban(String name, String s) {
			try {
				String v1 = "";
				String v2 = "";
				String v3 = "";
				String[] str = s.split(" ");
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@ec2-52-79-228-239.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
						"tiger");
				// 채팅친사람 위치
				String sql = "select r_name from list where name = '" + name + "'";
				PreparedStatement pstmt1 = con.prepareStatement(sql);
				ResultSet rs1 = pstmt1.executeQuery();
				while (rs1.next()) {
					v1 = rs1.getString(1);
				}
				// 변경하려고 하는사람 위치
				sql = "select r_name from list where name = '" + str[1] + "'";
				pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					v2 = rs.getString(1);
				}
				// 채팅친사람 반장 여부
				sql = "select r_boss from room";
				PreparedStatement pstmt3 = con.prepareStatement(sql);
				ResultSet rs2 = pstmt3.executeQuery();
				while (rs2.next()) {
					if (name.equals(rs2.getString(1))) {
						v3 = rs2.getString(1);
					} else {
						try {
							PrintWriter it_out = (PrintWriter) clientMap.get(name);
							it_out.println("당신은 권한이 없습니다.");
						} catch (Exception e) {
							System.out.println("예외 :" + e);
						}
						v3 = v2;
					}

				}
				if (v1.equals(v2) && v3.equals(name)) {
					sql = "update list set r_name = '대기실' where name = '" + str[1] + "'";
					PreparedStatement pstmt2 = con.prepareStatement(sql);
					pstmt2.executeUpdate();
					pstmt2.close();
				} else if(!v1.equals(v2)) {
					try {
						PrintWriter it_out = (PrintWriter) clientMap.get(name);
						it_out.println("상대방이 당신과 같은방에 있지 않습니다.");
					} catch (Exception e) {
						System.out.println("예외 :" + e);
						e.printStackTrace();
					}

				}
				rs.close();
				rs1.close();
				rs2.close();
				pstmt1.close();
				pstmt.close();
				pstmt3.close();
				con.close();
			} catch (SQLException sqle) {
				System.out.println("Connection Error");
				sqle.printStackTrace();
			}
		}

		// 방 폭파
		public void Boom(String name) {
			try {
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@ec2-52-79-228-239.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
						"tiger");
				String sql = "select r_boss from room";
				pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					if (name.equals(rs.getString(1))) {
						sql = "select name,r_name from list where r_name in (select r_name from list where name = '"
								+ name + "')";
						PreparedStatement pstmt = con.prepareStatement(sql);
						ResultSet rs1 = pstmt.executeQuery();
						PreparedStatement pstmt1 = null;
						while (rs1.next()) {
							String nname = rs1.getString(1);
							String loc = rs1.getString(2);
							PrintWriter it_out = (PrintWriter) clientMap.get(nname);
							it_out.println("방이 폭파됐습니다. 대기실로 이동합니다.");
							sql = "update list set r_name = '대기실' where name = '" + nname + "'";
							pstmt1 = con.prepareStatement(sql);
							pstmt1.executeUpdate();
						}
						rs1.close();
						pstmt1.close();
						sql = "delete room where r_boss = '" + name + "'";
						pstmt1 = con.prepareStatement(sql);
						pstmt1.executeUpdate();
						pstmt1.close();

					} else {
						try {
							PrintWriter it_out = (PrintWriter) clientMap.get(name);
							it_out.println("당신은 권한이 없습니다.");
						} catch (Exception e) {
							System.out.println("예외 :" + e);
						}
					}

				}

				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException sqle) {
				System.out.println("Connection Error");
				sqle.printStackTrace();
			}

		}

		// 쓰레드를 사용하기 위해서 run()메서드 재정의
		@Override
		public void run() {
			String name = ""; // 클라이언트로 부터 받은 이름을 저장할 변수.

			try {
				name = in.readLine(); // 클라이언트에서 처음으로 보내는 메시지는
										// 클라이언트가 사용할 이름이다.

				try {
					con = DriverManager.getConnection(
							"jdbc:oracle:thin:@ec2-52-79-228-239.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
							"tiger");
					// 이름 & 블랙리스트 체크
					// Check_Name(name);

					Statement stmt = con.createStatement();
					StringBuffer sb = new StringBuffer();

					sb.append("insert into list (name,r_name) values ('");
					sb.append(name);
					sb.append("','");
					sb.append("대기실");
					sb.append("')");
					ResultSet rs = stmt.executeQuery(sb.toString());

					// Connection con = ConnectionPool.getConnection();

					rs.close();
					stmt.close();
					con.close();
				} catch (SQLException sqle) {
					System.out.println("Connection Error");
					sqle.printStackTrace();
				}
				//
				sendAllMsg(name + "님이 입장하셨습니다.");
				// 현재 객체가 가지고있는 소켓을 제외하고 다른 소켓(클라이언트)들에게 접속을 알림.
				clientMap.put(name, out);
				System.out.println("현재 접속자 수는 " + clientMap.size() + "명 입니다.");
				// 입력스트림이 null이 아니면 반복.
				String s = "";

				while (in != null) {
					s = in.readLine();
					System.out.println(s);
					String[] str = s.split(" ");
					// if(s.equals("q")||s.equals("Q"))
					// break;
					if (str[0].equals("[" + name + "]" + ":" + "/list")
							|| str[0].equals("[" + name + "]" + ":" + "/LIST"))
						showList(name);
					else if (str[0].equals("[" + name + "]" + ":" + "/to")
							|| str[0].equals("[" + name + "]" + ":" + "/TO"))
						showString(name, s);
					else if (str[0].equals("[" + name + "]" + ":" + "/room")
							|| str[0].equals("[" + name + "]" + ":" + "/ROOM"))
						Room_Make(name);
					else if (str[0].equals("[" + name + "]" + ":" + "/roomlist")
							|| str[0].equals("[" + name + "]" + ":" + "/ROOMLIST"))
						Room_Check(name);
					else if (str[0].equals("[" + name + "]" + ":" + "/go")
							|| str[0].equals("[" + name + "]" + ":" + "/GO"))
						Room_Join(name, s);
					else if (str[0].equals("[" + name + "]" + ":" + "/notice")
							|| str[0].equals("[" + name + "]" + ":" + "/NOTICE"))
						Notice(s);
					else if (str[0].equals("[" + name + "]" + ":" + "/wlist")
							|| str[0].equals("[" + name + "]" + ":" + "/WLIST"))
						WaitList(name);
					else if (str[0].equals("[" + name + "]" + ":" + "/wroomlist")
							|| str[0].equals("[" + name + "]" + ":" + "/WROOMLIST"))
						WaitRoomList(name);
					else if (str[0].equals("[" + name + "]" + ":" + "/out")
							|| str[0].equals("[" + name + "]" + ":" + "/OUT"))
						RoomOut(name);
					else if (str[0].equals("[" + name + "]" + ":" + "/change")
							|| str[0].equals("[" + name + "]" + ":" + "/CHANGE"))
						ChangeBoss(name, s);
					else if (str[0].equals("[" + name + "]" + ":" + "/ban")
							|| str[0].equals("[" + name + "]" + ":" + "/BAN"))
						Ban(name, s);
					else if (str[0].equals("[" + name + "]" + ":" + "/boom")
							|| str[0].equals("[" + name + "]" + ":" + "/BOOM"))
						Boom(name);
					else
						talk(name, s);

				}
				// System.out.println("Bye...");
			} catch (Exception e) {
				System.out.println("예외 : " + e);
			} finally {
				// 예외가 발생하때 퇴장. 해쉬맵에서 해당데이터 제거
				// 보통 종료하거나 나가면 kava.net.SocketException:예외발생
				clientMap.remove(name);
				sendAllMsg(name + "님이 퇴장하셨습니다.");
				System.out.println("현재 접속자 수는" + clientMap.size() + "명 입니다.");
				out();
			}
		}

	}

}