package com.scottk.platformer.controller;

import com.scottk.platformer.model.Player;

/**
 * Created by Student on 1/26/2015.
 */
public class PlayerController {
    public Player player;

    public static void initializeController(){
        player = new Player(70, 100);


    }
    public static void update(float deltaTime){
        player.update(deltaTime);
    }

}


