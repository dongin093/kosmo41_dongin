package com.study.pattern.stretegy2;

public class GameCharacter {
	
	//접근점 (인터페이스가 각종 무기의 단일통로)
	private Weapon weapon;
	
	//무기교환이 가능하게~
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	//기능사용
	public void fire() {
		if (weapon ==null) {
			System.out.println("무기를 먼저 착용하세요.");
		}else {
			weapon.shoot();
		}
	}
}