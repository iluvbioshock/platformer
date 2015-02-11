package com.scottk.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.scottk.platformer.model.Player;

/**
 * Created by Student on 1/26/2015.
 */
public class PlayerController {
    public static Player player;

    public static void initializeController(){
        player = new Player(new Vector2(3,3),70, 100);


    }

    public static void update(float deltaTime){
        player.update(deltaTime);
    }
        public  static void draw(Batch spriteBatch){
            player.draw(spriteBatch);

    }
}


