package com.hakkatoreinbukuma.game.MyBaseClasses;

import com.badlogic.gdx.Gdx;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.Screens.Copyright.CopyrightScreen;
import com.hakkatoreinbukuma.game.Screens.Menu.MenuScreen;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyScreen;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import com.hakkatoreinbukuma.game.MyGdxGame;

public class TitleScreen extends MyScreen{
    private OneSpriteAnimatedActor title = new OneSpriteAnimatedActor(Assets.manager.get(Assets.TITLE_ATLAS));

    public TitleScreen(MyGdxGame game) {
        super(game);
        title.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        title.setLooping(false);
        title.setFps(10);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
            title.draw(spriteBatch, 1);
            title.act(delta);
        spriteBatch.end();
        if(!title.isRunning()){
            game.setScreen(new CopyrightScreen(game));
        }

    }

    @Override
    public void init() {

    }
}
