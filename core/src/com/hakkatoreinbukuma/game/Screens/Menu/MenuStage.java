package com.hakkatoreinbukuma.game.Screens.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.GlobalMusic;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.MyButton;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.MyLabel;
import com.hakkatoreinbukuma.game.MyGdxGame;
import com.hakkatoreinbukuma.game.Screens.About.AboutScreen;
import com.hakkatoreinbukuma.game.Screens.End.EndScreen;
import com.hakkatoreinbukuma.game.Screens.Game.GameScreen;
import com.hakkatoreinbukuma.game.Screens.Story.StoryScreen;

public class MenuStage extends MyStage {

    private OneSpriteStaticActor logoActor = new OneSpriteStaticActor(Assets.manager.get(Assets.LOGO));
    MyButton story;


    public MenuStage(Batch batch, final MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);

        OneSpriteStaticActor bg = new OneSpriteStaticActor(Assets.manager.get(Assets.MENU));
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        addActor(bg);

        logoActor.setSize(logoActor.getWidth() / 2, logoActor.getHeight() / 2);

        logoActor.setPosition(30, getViewport().getWorldHeight() - logoActor.getHeight() - 50);


        MyButton playButton = new MyButton("Play", game.getButtonStyle());
        playButton.setPosition(50, getViewport().getWorldHeight() - 360);

        playButton.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new GameScreen(game));
                GlobalMusic.stopMenuMusic();
                //game.setScreen(new EndScreen(game, 10000, 16));

            }
        });

        story = new MyButton("Történet", game.getButtonStyle());
        story.setPosition(50, getViewport().getWorldHeight() - 420);

        story.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new StoryScreen(game));
            }
        });

        addActor(story);

        MyButton aboutButton = new MyButton("About", game.getButtonStyle());
        aboutButton.setPosition(50, getViewport().getWorldHeight() - 480);

        aboutButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new AboutScreen(game));
            }
        });

        MyButton quitButton = new MyButton("Quit", game.getButtonStyle());
        quitButton.setPosition(50, getViewport().getWorldHeight() - 540);

        quitButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });


        //addActor(bgActor);
        addActor(logoActor);
        addActor(playButton);
        addActor(aboutButton);
        addActor(quitButton);

    }

    @Override
    public void init() {

    }


    @Override
    public void act(float delta) {
        super.act(delta);

    }
}
