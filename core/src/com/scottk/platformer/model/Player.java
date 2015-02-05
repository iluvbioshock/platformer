package com.scottk.platformer.model;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.scottk.platformer.view.GameScreen;

import java.util.HashMap;

/**
 * Created by Student on 12/11/2014.
 */
public class Player {
    public Vector2 position;
    public Spritesheet spriteSheet;
    private float stateTime;
    public int width;
    public int height;
    public String currentAnimation;
    private HashMap<String, Animation> animations;



    public Player() {
        position = new Vector2(2, 2);
        width = 70;
        height = 100;
        spriteSheet = new Spritesheet("image/aliens (1).png", 70, 100);
        animations = new HashMap<String, Animation>();

        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);

         Body playerBody = GameScreen.gameWorld.createBody(bodyDefinition);
        playerBody.setUserData(this);

        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(width / 2f, height / 2f, new Vector2(width / 2f, height / 2f), 0f);

        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

        playerBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();

        animations.put("walkRight", spriteSheet.createAnimation(9, 10, 0.25f));
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walkRight"), true, false));

        animations.put("climbRight", spriteSheet.createAnimation(1, 2, 0.25f));
        animations.put("climbLeft", spriteSheet.flipAnimation(animations.get("climbRight"), true, false));

        animations.put("duckRight", spriteSheet.createAnimation(3, 3, 0.25f));
        animations.put("duckLeft", spriteSheet.flipAnimation(animations.get("duckRight"), true, false));

        animations.put("hurtRight", spriteSheet.createAnimation(4, 4, 0.25f));
        animations.put("hurtLeft", spriteSheet.flipAnimation(animations.get("hurtRight"), true, false));

        currentAnimation = "walkRight";

        stateTime = 0f;
    }

    public void draw(Batch spriteBatch){
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width * (1/70f), height * (1/70f));
    }

    public void update(float deltaTime){
        //position.x += deltaTime;
        stateTime += deltaTime;
    };
}
