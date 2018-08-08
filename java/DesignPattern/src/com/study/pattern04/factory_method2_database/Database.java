package com.study.pattern04.factory_method2_database;

// The 'Product' abstract class

public abstract class Database {
	public String name;
	public double rows;
	
	// 데이터베이스마다 접속 방식이 다르다.
	public abstract void connectDatabase();
	
	// 표준 SQL문으르 사용한다.(업무처리 방식이 같다.)
	public void insertData()
	{
		System.out.println(name + "에 데이터를 추가했습니다.");
	}
	
	public void selectData()
	{
		System.out.println(name + "에서 데이터를 " + rows +"게 조회했습니다.");
	}
	
}
