package com.study.pattern04.factory_method2_factory;

import com.study.pattern04.factory_method2_database.Database;

enum DBType
{
	MySQL,
	Oracle,
	Informix
}

public abstract class DatabaseFactory {

	// Factory Method
	public abstract Database setDatabase();
}
