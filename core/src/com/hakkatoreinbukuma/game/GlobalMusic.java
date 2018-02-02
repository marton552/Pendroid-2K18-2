package com.hakkatoreinbukuma.game;


import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;

import java.util.Random;

public class GlobalMusic {

    static Music menu;
    static boolean menuPlaying = false;
    static Music game;
    static Random r = new Random();
    static int lastsong = 4;
    static boolean gameMusic = false;

    public static void startMenuMusic() {
        if(!menuPlaying) {
            System.out.println("PLAY MENU MUSIC");
            menu = Assets.manager.get(Assets.MENU_MUSIC);
            menu.play();
            menu.setLooping(true);
            menuPlaying = true;
        }
    }

    public static void stopMenuMusic() {
        if (menuPlaying) {
            menu.stop();
            //menu.dispose();
            menuPlaying = false;
            System.out.println("STOP MENU MUSIC");

        }
    }

    public static void playGameMusic() {
        playMusic();
        gameMusic = true;
        System.out.println("PLAY GAME MUSIC");

        game.setOnCompletionListener(new Music.OnCompletionListener() {
            @Override
            public void onCompletion(Music music) {
                game.stop();
                playMusic();
            }
        });
    }

    public static void stopGameMusic() {
        if(gameMusic)  {
            System.out.println("PLAY GAME MUSIC");
            gameMusic = false;
            game.stop();
            game.dispose();
        }
    }

    private static void playMusic(){
        int rand = r.nextInt(4);

        while(rand == lastsong) rand = r.nextInt(2);

        if(rand == 0){
            game = Assets.manager.get(Assets.MUSIC_1);
        } else if(rand == 1){
            game = Assets.manager.get(Assets.MUSIC_2);
        }else if(rand == 2){
            game = Assets.manager.get(Assets.MUSIC_3);
        }else if(rand == 3) {
            game = Assets.manager.get(Assets.MUSIC_4);
        }else{
            game = Assets.manager.get(Assets.MUSIC_5);
        }

        System.out.println("Next song");

        lastsong = rand;

        game.play();

    }
}
