package com.scottk.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.scottk.platformer.model.Player;

/**
 * Created by Student on 1/26/2015.
 */
public class PlayerController {
    public static Player player;

    public static final float VELOCITY = 1f;
    public static final float MAX_VELOCITY = 5f;

    public static void initializeController(){

        player = new Player(new Vector2(3,3),70, 100);
    }

    public static void update(float deltaTime){
        handleInput();
        player.update(deltaTime);
    }
        public  static void draw(Batch spriteBatch){
            player.draw(spriteBatch);

    }
    private static void handleInput(){
        Vector2 velocity = player.physicsBody.getLinearVelocity();
        Vector2 position = player.physicsBody.getPosition();

        if(Math.abs(velocity.x) > MAX_VELOCITY){
            velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
        player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.physicsBody.applyLinearImpulse(VELOCITY, 0, position.x, position.y, true);
        }
    }
}


