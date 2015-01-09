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
        position = new Vector2(0, 0);
        spriteSheet = new Texture (Gdx.files.internal("img/aliens.png"));

    }
}
