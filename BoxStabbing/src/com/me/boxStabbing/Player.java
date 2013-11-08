package com.me.boxStabbing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player implements DrawableObject, PhysicsObject{
	private static final String PLAYERIMAGE = "Player.png";
	
    private Texture texture;
    private Sprite sprite;
	
	public Player() {
        texture = new Texture(Gdx.files.internal("data/" + PLAYERIMAGE));
        sprite = new Sprite(texture);
        DrawingManager.register(this);
	}
	
	public Player(Vector2 Pos) {
        texture = new Texture(Gdx.files.internal("data/" + PLAYERIMAGE));
        sprite = new Sprite(texture);
        DrawingManager.register(this);
        this.setPos(Pos);
	}
	
	@Override
	public void draw(SpriteBatch sb) {
		sprite.setColor(Color.RED);
		sprite.draw(sb);
		
	}
	@Override
	public void dispose() {
        texture.dispose();
	}
	
	public void setX(int X) {
		sprite.setX(X);
	}
	
	public void setY(int Y) {
		sprite.setY(Y);
	}
	
	public void setPos(Vector2 Pos) {
		sprite.setPosition(Pos.x, Pos.y);
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		
	}
}
