package com.scottk.platformer.model;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Student on 12/11/2014.
 */
public class Player {
    public Vector2 position;
    public Texture spriteSheet;
    public float width;
    public float height;
    public String currentAnimation;

    private float

    public Player() {
        public Animation animation;
        position = new Vector2(2, 2);
        spriteSheet = new Texture (Gdx.files.internal("img/aliens.png"));

        TextureRegion [][] animationFrames = TextureRegion.split(spriteSheet, 70, 100);

        int counter = 0;
        for(int row = 0; row < spriteSheetFrame.length; row++){
            for(int column = 0; column < spriteSheetFrames[row].length; column++){
                counter++;
            }
        }

        spriteFrame = new TextureRegion[counter];

        counter = 0;
        for (TextureRegion[] row : spriteSheetframes){
            for(TextureRegion sprite : row){
                spriteFrames[counter++] = sprite;
            }
        }
        TextureRegion[] animationFrame = new TextureRegion[2];
        animationFrames[0]= spriteFrames[9];
        animationFrames[1]= spriteFrames[10];
        animation = new Anmation(1f, animationFrames);
        staetTime = 0f;
    }

    public void draw(Batch spriteBatch){
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, 70 * (1/70f), 100 * (1/70f);
    }

    public void update(float deltaTime){
        stateTime += deltaTime;
    };
}
