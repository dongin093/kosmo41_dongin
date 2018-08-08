//import java.io.PrintWriter;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class Sender extends Thread
//{
//	Socket socket;
//	PrintWriter out = null;
//	String name;
//	boolean check = false;
//	String name2;
//	
//	public Sender(Socket socket,String name)
//	{
//		this.socket = socket;
//		try {
//			out = new PrintWriter(this.socket.getOutputStream(),true);
//			this.name = name;
//		}catch (Exception e) {
//			System.out.println("예외S3 : " + e);
//		}
//	}
//	
//	@Override
//	public void run() {
//		Scanner s =new Scanner(System.in);
//		try { 
//			out.println(name);
//			
//			while(out!=null) {
//				try {
//					String s2 = s.nextLine();
//					if(s2.equals("q") || s2.equals("Q")) {
//						out.println(s2);
//						break;
//					}else {
//						String[] stt = s2.split(" ");
//						
////					귓속말
//						
//					if(stt[0].equals("/to")&& stt.length>2&&!check) {
//						out.println("["+name+"]"+":" +s2);
//					}
//					else if (stt[0].equals("/to")&& stt.length==2&&!check) {
//						check = true;
//						name2 = stt[1];
//					}
//					else if (stt[0].equals("/to")&& stt.length==2&&check) {
//						check = false;
//					}
//					else if (check) {
//						out.println("["+name+"]"+":"+"/to "+name2+" "+s2);
//					}
//					
////					일반 채팅
//					
//					else {
//						out.println("["+name+"]"+":"+s2);
//					}
//					}
//				} catch (Exception e) {
//					System.out.println("예외S1 : "+e);
//				}
//			}
//			out.close();
//			socket.close();
//			} catch(Exception e) {
//				System.out.println("예외S2 : "+e);
//			}
//	}
//}