package com.hakkatoreinbukuma.game.Screens.Menu;

import com.badlogic.gdx.Gdx;
import com.hakkatoreinbukuma.game.GlobalMusic;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyScreen;
import com.hakkatoreinbukuma.game.MyGdxGame;

public class MenuScreen extends MyScreen{

    MenuStage menuStage;

    public MenuScreen(MyGdxGame game) {
        super(game);
        //setBackGroundColor(1, 1, 1);
        menuStage = new MenuStage(spriteBatch, game);
        Gdx.input.setInputProcessor(menuStage);

        GlobalMusic.stopGameMusic();
        GlobalMusic.startMenuMusic();

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        menuStage.act(delta);
        menuStage.draw();
    }

    @Override
    public void init() {

    }
}
