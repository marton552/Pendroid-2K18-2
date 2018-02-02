package com.hakkatoreinbukuma.game.Screens.Game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyScreen;
import com.hakkatoreinbukuma.game.MyGdxGame;

public class GameScreen extends MyScreen{

    GameStage gameStage;
    HUD hud;

    public GameScreen(MyGdxGame game) {
        super(game);

        gameStage = new GameStage(spriteBatch, game);
        hud = new HUD(spriteBatch, game, gameStage);

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(gameStage);
        inputMultiplexer.addProcessor(hud);

        Gdx.input.setInputProcessor(inputMultiplexer);

    }

    @Override
    public void render(float delta) {
        super.render(delta);

        gameStage.act(delta);
        gameStage.draw();

        hud.act(delta);
        hud.draw();

    }

    @Override
    public void init() {

    }
}
