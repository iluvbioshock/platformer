package com.scottk.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameScreen implements Screen {
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;
    public GameScreen() {

        map = new TmxMapLoader().load("map/Level01.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(14f, 14f * (height / width));
        camera.position.set(camera.viewportWidth/ 2f, camera.viewportHeight/ 2f, 0);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void render(float delta) {
     camera.update();
        renderer.setView(camera);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {

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
