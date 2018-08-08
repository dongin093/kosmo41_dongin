package com.study.pattern04.factory_method2_factory;

import com.study.pattern04.factory_method2_database.Database;
import com.study.pattern04.factory_method2_database.Informix;
import com.study.pattern04.factory_method2_database.MySQL;
import com.study.pattern04.factory_method2_database.Oracle;

public class DatabaseFactoryUse extends DatabaseFactory {
	
	// 이번에 사용할 데이터베이스는 Oracle이다
	// 데이터베이스 변경시 여기서 타입을 변경한다.
	public DBType dbType = DBType.Oracle;
	
	@Override
	public Database setDatabase() {
		// 회사 사정에 의해 어떤 데이터베이스를 다시 사용할지 모른다.
		// 그래서 구축한 정보를 지우지 않고 재사용시를 대비한다.
		if(dbType == DBType.MySQL)
		{
			System.out.println("MySQL use...");
			return new MySQL();
		}
		else if (dbType == DBType.Oracle)
		{
			System.out.println("Oracle use...");
			return new Oracle();
		}
		else if (dbType == DBType.Informix)
		{
			System.out.println("Informix use...");
			return new Informix();
		}
		return null;
	}

}
