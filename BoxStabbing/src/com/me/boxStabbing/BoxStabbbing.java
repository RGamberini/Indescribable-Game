package com.me.boxStabbing;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class BoxStabbbing implements ApplicationListener {
    private BitmapFont font;
    
    private static final int VIRTUAL_WIDTH = 1600;
    private static final int VIRTUAL_HEIGHT = 900;
    private static final float ASPECT_RATIO =
        (float)VIRTUAL_WIDTH/(float)VIRTUAL_HEIGHT;
    
    private Camera camera;
    private Rectangle viewport;
    private SpriteBatch sb;
    private Player player;
    private StaticImage background;
    
	@Override
	public void create() {
		Texture.setEnforcePotImages(false);
		sb = new SpriteBatch();
		background = new StaticImage("Backround.png", new Vector2(0,0));
		font = new BitmapFont(Gdx.files.internal("data/Impact.fnt"),false);
        font.setColor(Color.RED);
        camera = new OrthographicCamera(VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
        player = new Player(new Vector2(300, 300));
	}

	@Override
	public void dispose() {
		sb.dispose();
        font.dispose();
	}

	@Override
	public void render() {
		camera.update();
        camera.apply(Gdx.gl10);
 
        // set viewport
        Gdx.gl.glViewport((int) viewport.x, (int) viewport.y,
                          (int) viewport.width, (int) viewport.height);
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
        //screenQuad.render(GL10.GL_TRIANGLE_STRIP, 0, 4);
        
        sb.begin();
        DrawingManager.draw(sb);
        font.draw(sb, "Hello World", 800, 450);
        sb.end();
	}

	@Override
	public void resize(int width, int height) {
		float aspectRatio = (float)width/(float)height;
        float scale = 1f;
        Vector2 crop = new Vector2(0f, 0f);
        
        if(aspectRatio > ASPECT_RATIO)
        {
            scale = (float)height/(float)VIRTUAL_HEIGHT;
            crop.x = (width - VIRTUAL_WIDTH*scale)/2f;
        }
        else if(aspectRatio < ASPECT_RATIO)
        {
            scale = (float)width/(float)VIRTUAL_WIDTH;
            crop.y = (height - VIRTUAL_HEIGHT*scale)/2f;
        }
        else
        {
            scale = (float)width/(float)VIRTUAL_WIDTH;
        }
 
        float w = (float)VIRTUAL_WIDTH*scale;
        float h = (float)VIRTUAL_HEIGHT*scale;
        viewport = new Rectangle(crop.x, crop.y, w, h);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
