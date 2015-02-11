package com.scottk.platformer.model;

import com.badlogic.gdx.Gdx;


import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.scottk.platformer.controller.LevelController;
import com.scottk.platformer.view.GameScreen;

import java.util.HashMap;

/**
 * Created by Student on 12/11/2014.
 */
public class Player extends Sprite {



    public Player(Vector2 position, int width, int height) {
        super(position, width, height);
        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);

         physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
        physicsBody.setUserData(this);

        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width / 2, this.height / 2, new Vector2(this.width / 2, this.height / 2), 0f);

        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

       physicsBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();

        animations.put("walkRight", spriteSheet.createAnimation(9, 10, 0.25f));
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walkRight"), true, false));

        animations.put("climbRight", spriteSheet.createAnimation(1, 2, 0.25f));
        animations.put("climbLeft", spriteSheet.flipAnimation(animations.get("climbRight"), true, false));

        animations.put("duckRight", spriteSheet.createAnimation(3, 3, 0.25f));
        animations.put("duckLeft", spriteSheet.flipAnimation(animations.get("duckRight"), true, false));

        animations.put("hurtRight", spriteSheet.createAnimation(4, 4, 0.25f));
        animations.put("hurtLeft", spriteSheet.flipAnimation(animations.get("hurtRight"), true, false));

        animations.put("jumpRight", spriteSheet.createAnimation(5, 5, 0.25f));
        animations.put("jumpLeft", spriteSheet.flipAnimation(animations.get("jumpRight"), true, false));

        animations.put("idleRight", spriteSheet.createAnimation(6, 6, 0.25f));
        animations.put("idleLeft", spriteSheet.flipAnimation(animations.get("idleRight"), true, false));

        animations.put("swimRight", spriteSheet.createAnimation(7, 8, 0.5f));
        animations.put("swimLeft", spriteSheet.flipAnimation(animations.get("swimRight"), true, false));


        currentAnimation = "hurtRight";


    }

    public void draw(Batch spriteBatch){
        super.draw(spriteBatch);
    }

    public void update(float deltaTime){
        super.update(deltaTime);
    };
}
