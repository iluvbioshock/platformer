package com.scottk.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.scottk.platformer.controller.CameraController;
import com.scottk.platformer.controller.LevelController;
import com.scottk.platformer.controller.PlayerController;
import com.scottk.platformer.model.Player;

public class GameScreen implements Screen {




    public GameScreen() {

        LevelController.initializedController();
        CameraController.initializeController();
        PlayerController.initializeController();

     LevelController.draw();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.64f, 0.28f, 0.21f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        CameraController.update();
        LevelController.update(delta);
        PlayerController.update(delta);


        LevelController.draw();

    }

    @Override
    public void resize(int width, int height) {
        CameraController.resize(width, height );
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
