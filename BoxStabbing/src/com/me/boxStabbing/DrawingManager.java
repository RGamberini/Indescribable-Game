package com.me.boxStabbing;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DrawingManager {
	private static ArrayList<DrawableObject> objList = new ArrayList<DrawableObject>();
	
	public static void register(DrawableObject obj) {
		objList.add(obj);
	}
	
	public static void draw(SpriteBatch sb) {
		for (int i = 0; i < objList.size(); i++)
			objList.get(i).draw(sb);			
	}
	
	public static void dispose() {
		for (int i = 0; i < objList.size(); i++)
			objList.get(i).dispose();
	}
}
