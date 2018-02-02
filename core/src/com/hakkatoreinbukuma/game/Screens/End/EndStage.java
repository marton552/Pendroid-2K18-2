package com.hakkatoreinbukuma.game.Screens.End;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.MyButton;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.MyLabel;
import com.hakkatoreinbukuma.game.MyGdxGame;
import com.hakkatoreinbukuma.game.Screens.Menu.MenuScreen;

public class EndStage extends MyStage{

    MyLabel title;
    MyLabel info;
    MyButton back;


    public EndStage(Batch batch, final MyGdxGame game, int score, int stars) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);

        title = new MyLabel("LEESETT A LABDA", game.getLabelStyle());
        title.setFontScale(2);
        title.getStyle().fontColor = Color.RED;
        title.setPosition(getViewport().getWorldWidth() / 2 - title.getWidth() / 2 - (title.getWidth() /2),
                           getViewport().getWorldHeight() - title.getHeight() - 50);
        addActor(title);

        info = new MyLabel(score+" másodpercig tudtad\n" +
                "levegőbe tartani a labdát\n" +
                "Felvett csillagok: "+stars+" db", game.getLabelStyle());
        info.setPosition(getViewport().getWorldWidth() / 2 - info.getWidth() / 2,
                        getViewport().getWorldHeight() / 2 - info.getHeight() / 2);
        info.setAlignment(Align.center);

        addActor(info);

        back = new MyButton("Vissza a menübe", game.getButtonStyle());
        back.setPosition(getViewport().getWorldWidth()/ 2 - back.getWidth() / 2,
                            back.getHeight() + 20);

        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
            }
        });

        addActor(back);

    }

    @Override
    public void init() {

    }
}
