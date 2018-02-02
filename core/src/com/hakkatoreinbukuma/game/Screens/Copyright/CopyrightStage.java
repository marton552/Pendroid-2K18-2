package com.hakkatoreinbukuma.game.Screens.Copyright;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.hakkatoreinbukuma.game.MyGdxGame;
import com.hakkatoreinbukuma.game.Screens.Menu.MenuScreen;

public class CopyrightStage extends MyStage {

    OneSpriteStaticActor logo;

    public CopyrightStage(Batch batch, final MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);

        logo = new OneSpriteStaticActor(Assets.manager.get(Assets.PEN_LOGO));
        logo.setPosition(getViewport().getWorldWidth() / 2 - logo.getWidth() / 2,
                getViewport().getWorldHeight() / 2 - logo.getHeight() / 2);

        addActor(logo);

        Timer.schedule(new Timer.Task() {

            @Override
            public void run() {
                game.setScreen(new MenuScreen(game));
            }

        }, 1);
    }

    @Override
    public void init() {

    }
}
