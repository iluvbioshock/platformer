package com.scottk.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.scottk.platformer.model.Player;

public class GameScreen implements Screen {
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;
    public Player player;
    public SpriteBatch spriteBatch;
    public GameScreen() {

        map = new TmxMapLoader().load("image/map01.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(14f, 14f * (height / width));
        camera.position.set(camera.viewportWidth/ 2f, camera.viewportHeight/ 2f, 0);

        spriteBatch = new SpriteBatch();
        player = new Player();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.64f, 0.28f, 0.21f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        renderer.setView(camera);
        renderer.render();

        player.update(delta);

        spriteBatch.begin();
        player.draw(spriteBatch);
        spriteBatch.end();

    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = 14f;
        camera.viewportHeight= 14f * height / width;
        camera.update();
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
