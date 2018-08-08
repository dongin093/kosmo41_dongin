package com.study.pattern04.factory_method1;

import java.util.List;

import com.study.pattern04.factory_method1.factory.PatternAGenerator;
import com.study.pattern04.factory_method1.factory.PatternBGeberator;
import com.study.pattern04.factory_method1.factory.UnitGenerator;
import com.study.pattern04.factory_method1.unit.Unit;

public class Main {

	public static void main(String[] args) {
		// 타입이 두가지 있다는것만 안다.
		UnitGenerator[] unitgenerators = new UnitGenerator[2];
		unitgenerators[0] = new PatternAGenerator();
		unitgenerators[1] = new PatternBGeberator();
		
//		DoMakeType(unitgenerators[0]);
		DoMakeType(unitgenerators[1]);
		
	}
	public static void DoMakeType(UnitGenerator ug)
	{
		// 무엇이 만들어질지 여기서는 모른다.
		ug.createUnits();
		
		List<Unit> units = ug.getUnits();
		for(Unit unit : units)
		{
			unit.attack();
		}
		
	}

}
