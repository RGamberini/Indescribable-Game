package com.me.boxStabbing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class StaticImage implements DrawableObject {
	
	private Texture texture;
	private Sprite sprite;
	
	public StaticImage(String imageName, Vector2 Pos) {
		texture = new Texture(Gdx.files.internal("data/" + imageName));
        sprite = new Sprite(texture);
        sprite.setPosition(Pos.x, Pos.y);
        DrawingManager.register(this);
	}

	@Override
	public void draw(SpriteBatch sb) {
		sprite.draw(sb);
	}

	@Override
	public void dispose() {
		texture.dispose();

	}

}
