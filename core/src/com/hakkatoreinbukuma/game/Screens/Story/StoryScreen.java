package com.hakkatoreinbukuma.game.Screens.Story;

import com.badlogic.gdx.Gdx;
import com.hakkatoreinbukuma.game.GlobalMusic;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyScreen;
import com.hakkatoreinbukuma.game.MyGdxGame;

public class StoryScreen extends MyScreen {

    StoryStage storyStage;

    public StoryScreen(MyGdxGame game) {
        super(game);

        storyStage = new StoryStage(spriteBatch, game);

        Gdx.input.setInputProcessor(storyStage);

        GlobalMusic.stopMenuMusic();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        storyStage.act(delta);
        storyStage.draw();
    }

    @Override
    public void init() {

    }
}
