package com.study.pattern04.factory_method1.factory;

import com.study.pattern04.factory_method1.unit.Marine;

/// <summary>
/// A 'ConcreateCreator' class
/// </summary>

public class PatternAGenerator extends UnitGenerator{

	@Override
	public void createUnits() {
		units.add(new Marine());
		units.add(new Marine());
		units.add(new Marine());
		units.add(new Marine());
		units.add(new Marine());
		units.add(new Marine());
		units.add(new Marine());
		units.add(new Marine());
	}
}
