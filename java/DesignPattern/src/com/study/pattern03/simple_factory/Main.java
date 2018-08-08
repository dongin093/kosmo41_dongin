package com.study.pattern03.simple_factory;

public class Main {

	public static void main(String[] args) {
		
		//구체적인 생성 방법은 몰라도 된다.
		//타입 지정만 하면 생성이 된다.
		Unit unit1 = UnitFactory.createUnit(UnitType.Marine);
		Unit unit2 = UnitFactory.createUnit(UnitType.Firebat);
		Unit unit3 = UnitFactory.createUnit(UnitType.Medic);
		
		unit1.move();
		unit2.move();
		unit3.move();
	}

}
