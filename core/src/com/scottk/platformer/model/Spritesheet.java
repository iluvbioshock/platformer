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
    public  Animation createAnimation(int startFrame, int lastFrame, float animationSpeed){
        int counter = (lastFrame + 1) - startFrame;
        TextureRegion[] animationFrames = new TextureRegion[counter];

        for(int index = lastFrame; index >= startFrame; index--){
            animationFrames[--counter] = spriteFrames[index];
        }

       return new Animation(animationSpeed, animationFrames);


    }
    public Animation flipAnimation(Animation originalAnimation, boolean flipX, boolean flipY){
        int frameCount = originalAnimation.getKeyFrames().length;
        TextureRegion[] flippedFrames = new TextureRegion[frameCount];

        for(int index = 0; index <= frameCount - 1 ; index++){
            flippedFrames[index] = new TextureRegion(originalAnimation.getKeyFrames() [index]);
            flippedFrames[index].flip(flipX,false);
            flippedFrames[index].flip(flipY,false);

        }
        return new Animation(originalAnimation.getFrameDuration(), flippedFrames);
    }
}