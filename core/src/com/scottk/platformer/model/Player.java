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
    public Texture spriteSheet;
    public Animation animation;
    public TextureRegion[] spriteFrames;
    private float stateTime;



    public Player() {

        position = new Vector2(2, 2);
        spriteSheet = new Texture (Gdx.files.internal("image/aliens (1).png"));

        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, 70, 100);

        int counter = 0;
        for(int row = 0; row < spriteSheetFrames.length; row++){
            for(int column = 0; column < spriteSheetFrames[row].length; column++){
                counter++;
            }
        }

        spriteFrames = new TextureRegion[counter];

        counter = 0;
        for (TextureRegion[] row : spriteSheetFrames){
            for(TextureRegion sprite : row){
                spriteFrames[counter++] = sprite;
            }
        }
        TextureRegion[] animationFrames = new TextureRegion[2];
        animationFrames[0]= spriteFrames[9];
        animationFrames[1]= spriteFrames[10];
        animation = new Animation(0.25f, animationFrames);
        stateTime = 0f;
    }

    public void draw(Batch spriteBatch){
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, 70 * (1/70f), 100 * (1/70f));
    }

    public void update(float deltaTime){
        position.x += deltaTime;
        stateTime += deltaTime;
    };
}
