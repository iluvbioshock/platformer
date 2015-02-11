package com.scottk.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.scottk.platformer.controller.LevelController;

import java.util.HashMap;

public class Sprite {
    public Vector2 position;
    public Spritesheet spriteSheet;
    private float stateTime;
    public float width;
    public float height;
    public String currentAnimation;
    protected HashMap<String, Animation> animations;


    public Sprite(Vector2 position, int width, int height){
        this.position = position;
        this.width = width * LevelController.UNIT_SCALE;
        this.height = height * LevelController.UNIT_SCALE;
        spriteSheet = new Spritesheet("image/aliens (1).png", width, height);
        animations = new HashMap<String, Animation>();
        stateTime = 0f;
    }

    public void draw(Batch spriteBatch){
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);
    }

    public void update(float deltaTime){
        //position.x += deltaTime;
        stateTime += deltaTime;
    }
}
