package com.hakkatoreinbukuma.game.Screens.About;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.MyButton;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.MyLabel;
import com.hakkatoreinbukuma.game.MyGdxGame;
import com.hakkatoreinbukuma.game.Screens.Menu.MenuScreen;
import com.hakkatoreinbukuma.game.Screens.Story.StoryScreen;

public class AboutStage extends MyStage{

    OneSpriteStaticActor bg;

    MyLabel title;
    MyLabel info;

    OneSpriteStaticActor sponsor;

    MyButton menu;

    public AboutStage(Batch batch, final MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);


        bg = new OneSpriteStaticActor(Assets.manager.get(Assets.MENU));
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());

        addActor(bg);

        title = new MyLabel("About", game.getLabelStyle());
        title.setFontScale(2);
        title.setPosition(getViewport().getWorldWidth() / 2 - title.getWidth() / 2 - (title.getWidth() /2),
                getViewport().getWorldHeight() - title.getHeight() - 50);
        addActor(title);

        info = new MyLabel("Tartsd a levegőben a labdát a ventillátorral,\n" +
                "miközben oldalról szelek fújnak.", game.getLabelStyle());
        info.setPosition(getViewport().getWorldWidth() / 2 - info.getWidth() / 2,
                getViewport().getWorldHeight() / 2 - info.getHeight() / 2 + 60);
        info.setAlignment(Align.center);

        addActor(info);

        sponsor = new OneSpriteStaticActor(Assets.manager.get(Assets.SPONSOR));
        sponsor.setSize(sponsor.getWidth() / 4, sponsor.getHeight() / 4);
        sponsor.setPosition(10, getViewport().getWorldHeight() - sponsor.getHeight() - 10);
        addActor(sponsor);

        menu = new MyButton("Vissza a menübe", game.getButtonStyle());
        menu.setPosition(getViewport().getWorldWidth() / 2 - menu.getWidth() / 2, menu.getHeight() + 10);

        menu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
            }
        });

        addActor(menu);

    }

    @Override
    public void init() {

    }
}
