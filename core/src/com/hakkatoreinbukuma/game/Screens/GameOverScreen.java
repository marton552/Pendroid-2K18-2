package com.hakkatoreinbukuma.game.Screens;

import com.badlogic.gdx.Gdx;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyScreen;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import com.hakkatoreinbukuma.game.MyGdxGame;
import com.hakkatoreinbukuma.game.Screens.Copyright.CopyrightScreen;
import com.hakkatoreinbukuma.game.Screens.End.EndScreen;

/**
 * Created by tanulo on 2018. 02. 02..
 */

public class GameOverScreen extends MyScreen {
    private OneSpriteAnimatedActor title = new OneSpriteAnimatedActor(Assets.manager.get(Assets.OVER_ATLAS));

    int score = 0;

    public GameOverScreen(MyGdxGame game, int score) {
        super(game);
        title.setSize(Gdx.graphics.getWidth()/1.2f, Gdx.graphics.getHeight()/1.2f);
        title.setLooping(false);
        title.setFps(10);


        this.score = score;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        title.draw(spriteBatch, 1);
        title.act(delta);
        spriteBatch.end();
        if(!title.isRunning()){
            game.setScreen(new EndScreen(game, score, 0));
        }

    }

    @Override
    public void init() {

    }
}