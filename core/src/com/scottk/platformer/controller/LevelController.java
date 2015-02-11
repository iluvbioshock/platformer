package com.scottk.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.scottk.platformer.model.Level;
import com.scottk.platformer.model.Player;
import com.scottk.platformer.model.Sprite;

/**
 * Created by Student on 1/26/2015.
 */
public class LevelController {
    public static final float UNIT_SCALE = 1/70f;

   public static Level level;
    public static TiledMap map;
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;

    public static World gameWorld;
    public static Array<Body> worldbodies;
    private  static Box2DDebugRenderer debugRenderer;

    public static void  initializedController(){
        level = new Level("image/map01.tmx");
        renderer = new OrthogonalTiledMapRenderer(level.map, UNIT_SCALE);

        gameWorld = new World(new Vector2(0, 0), true);
        worldbodies = new Array<Body>();
        debugRenderer = new Box2DDebugRenderer();

        spriteBatch =  renderer.getSpriteBatch();

        PlayerController.initializeController();
    }

    public static void draw(){
        spriteBatch.begin();
        PlayerController.draw(spriteBatch);
        spriteBatch.end();
        debugRenderer.render(gameWorld, CameraController.camera.combined);

    }

    public static void update( float deltaTime) {
        renderer.setView(CameraController.camera);
        renderer.render();
        PlayerController.update(deltaTime);
        gameWorld.step(1/100f, 1, 1);

    }

    private static void updateWorldBodies(){
        worldbodies.clear();
        gameWorld.getBodies(worldbodies);

        for (Body body : worldbodies) {
            Sprite spriteBody = (Sprite)body.getUserData();

            if (spriteBody != null){
                spriteBody.position = body.getPosition();
            }
        }
    }
}

