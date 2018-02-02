package com.hakkatoreinbukuma.game.Screens.Game;


import com.badlogic.gdx.Gdx;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyScreen;
import com.hakkatoreinbukuma.game.MyGdxGame;

public class GameScreen extends MyScreen{

    GameStage gameStage;

    public GameScreen(MyGdxGame game) {
        super(game);

        gameStage = new GameStage(spriteBatch, game);

        Gdx.input.setInputProcessor(gameStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        gameStage.act(delta);
        gameStage.draw();

    }

    @Override
    public void init() {

    }
}
