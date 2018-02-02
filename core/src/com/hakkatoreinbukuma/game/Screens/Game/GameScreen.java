package com.hakkatoreinbukuma.game.Screens.Game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.hakkatoreinbukuma.game.GlobalMusic;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyScreen;
import com.hakkatoreinbukuma.game.MyGdxGame;

import jdk.nashorn.internal.objects.Global;

public class GameScreen extends MyScreen{

    GameStage gameStage;
    HUD hud;
    public boolean paused = false;

    public GameScreen(MyGdxGame game) {
        super(game);

        gameStage = new GameStage(spriteBatch, game);
        hud = new HUD(spriteBatch, game, gameStage, this);

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(hud);
        inputMultiplexer.addProcessor(gameStage);

        Gdx.input.setInputProcessor(inputMultiplexer);

        GlobalMusic.stopMenuMusic();
        GlobalMusic.playGameMusic();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        if(paused == false)
            gameStage.act(delta);

        gameStage.draw();

        hud.act(delta);
        hud.draw();

    }

    @Override
    public void init() {

    }
}
