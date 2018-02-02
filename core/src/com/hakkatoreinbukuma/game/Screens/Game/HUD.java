package com.hakkatoreinbukuma.game.Screens.Game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.MyLabel;
import com.hakkatoreinbukuma.game.MyGdxGame;

public class HUD extends MyStage {

    MyLabel scoreCount;

    GameStage gameStage;

    public HUD(Batch batch, MyGdxGame game, GameStage gameStage) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);

        this.gameStage = gameStage;

        scoreCount = new MyLabel("0", game.getLabelStyle());
        scoreCount.setFontScale(1.5f);

        scoreCount.setX(getViewport().getWorldWidth() / 2 - scoreCount.getWidth() / 2 -(scoreCount.getWidth() / 2 / 2));
        scoreCount.setY(getViewport().getWorldHeight() - scoreCount.getHeight() - 20);


        addActor(scoreCount);

    }


    @Override
    public void act(float delta) {
        super.act(delta);

        scoreCount.setText(""+gameStage.SCORE);
        scoreCount.setX(getViewport().getWorldWidth() / 2 - scoreCount.getWidth() / 2 -(scoreCount.getWidth() / 2 / 2));

        //scoreCount.setX();

    }

    @Override
    public void init() {

    }
}
