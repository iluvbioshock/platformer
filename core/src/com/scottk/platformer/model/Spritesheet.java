package com.scottk.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

/**
 * Created by Student on 1/21/2015.
 */
public class Spritesheet {
    public Texture spriteSheet;
    public Animation animation;
    public TextureRegion[] spriteFrames;

    public Spritesheet(String pathToFile, int width, int height) {
        spriteSheet = new Texture(Gdx.files.internal(pathToFile));

        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, width, height);

        int counter = 0;
        for (int row = 0; row < spriteSheetFrames.length; row++) {
            for (int column = 0; column < spriteSheetFrames[row].length; column++) {
                counter++;
            }
        }

        spriteFrames = new TextureRegion[counter];

        counter = 0;
        for (TextureRegion[] row : spriteSheetFrames) {
            for (TextureRegion sprite : row) {
                spriteFrames[counter++] = sprite;
            }
        }

    }
    public  Animation createAnimation(){
        TextureRegion[] animationFrames = new TextureRegion[2];
        animationFrames[0] = spriteFrames[9];
        animationFrames[1] = spriteFrames[10];
        animation = new Animation(0.25f, animationFrames);
        return animation;

    }
}