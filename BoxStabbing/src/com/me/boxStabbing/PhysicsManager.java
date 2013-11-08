package com.me.boxStabbing;

import java.util.ArrayList;

public class PhysicsManager {
	private static ArrayList<PhysicsObject> objList = new ArrayList<PhysicsObject>();
	
	public static void register(PhysicsObject obj) {
		objList.add(obj);
	}
	
	
}
