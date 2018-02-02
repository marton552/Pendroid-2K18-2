package com.hakkatoreinbukuma.game.Screens.End;

import com.badlogic.gdx.Gdx;
import com.hakkatoreinbukuma.game.GlobalMusic;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyScreen;
import com.hakkatoreinbukuma.game.MyGdxGame;

import jdk.nashorn.internal.objects.Global;

public class EndScreen extends MyScreen {

    EndStage endStage;

    public EndScreen(MyGdxGame game, int score, int stars) {
        super(game);

        endStage = new EndStage(spriteBatch, game, score, stars);

        Gdx.input.setInputProcessor(endStage);

        GlobalMusic.stopGameMusic();
        GlobalMusic.startMenuMusic();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        endStage.act(delta);
        endStage.draw();

    }

    @Override
    public void init() {

    }
}
