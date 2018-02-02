package com.hakkatoreinbukuma.game.Screens.Copyright;

import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyScreen;
import com.hakkatoreinbukuma.game.MyGdxGame;

public class CopyrightScreen extends MyScreen{

    CopyrightStage copyrightStage;

    public CopyrightScreen(MyGdxGame game) {
        super(game);

        setBackGroundColor(1, 1, 1);

        copyrightStage = new CopyrightStage(spriteBatch, game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        copyrightStage.act(delta);
        copyrightStage.draw();
    }

    @Override
    public void init() {

    }
}
