package com.scottk.platformer.model;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Student on 12/11/2014.
 */
public class Player {
    public Vector2 position;
    public Animation animation;
    public Spritesheet spriteSheet;
    private float stateTime;
    public int width;
    public int height;



    public Player() {
        position = new Vector2(2, 2);
        width = 70;
        height = 100;
        spriteSheet = new Spritesheet("image/aliens (1).png", 70, 100);
        animation = spriteSheet.createAnimation(9, 10, 0.25f);
        animation= spriteSheet.flipAnimation(animation);
        stateTime = 0f;
    }

    public void draw(Batch spriteBatch){
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, width * (1/70f), height * (1/70f));
    }

    public void update(float deltaTime){
        position.x += deltaTime;
        stateTime += deltaTime;
    };
}
