package com.scottk.platformer;


import com.badlogic.gdx.Game;
import com.scottk.platformer.view.GameScreen;

public class Platformer extends Game{

    @Override
    public void create() {
    setScreen(new GameScreen());
    }
}
