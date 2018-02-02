package com.hakkatoreinbukuma.game.Screens.Story;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.MyButton;
import com.hakkatoreinbukuma.game.MyGdxGame;
import com.hakkatoreinbukuma.game.Screens.Menu.MenuScreen;

public class StoryStage extends MyStage {

    Music music;
    int state = 0;

    OneSpriteStaticActor bg1;
    OneSpriteStaticActor bg2;
    OneSpriteStaticActor bg3;
    OneSpriteStaticActor bg4;

    MyButton back;

    public StoryStage(Batch batch, final MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);

        bg1 = new OneSpriteStaticActor(Assets.manager.get(Assets.FILM1));
        bg1.setVisible(false);
        bg1.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());

        addActor(bg1);

        bg2 = new OneSpriteStaticActor(Assets.manager.get(Assets.FILM2));
        bg2.setVisible(false);
        bg2.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());

        addActor(bg2);

        bg3 = new OneSpriteStaticActor(Assets.manager.get(Assets.FILM3));
        bg3.setVisible(false);
        bg3.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());

        addActor(bg3);

        bg4 = new OneSpriteStaticActor(Assets.manager.get(Assets.FILM4));
        bg4.setVisible(false);
        bg4.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());

        addActor(bg4);

        back = new MyButton("Vissza", game.getButtonStyle());
        back.setPosition(getViewport().getWorldWidth() - back.getWidth() - 10, 10);
        back.setVisible(false);

        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                music.stop();
                game.setScreen(new MenuScreen(game));
            }
        });

        addActor(back);

        playNextStory();
    }

    public void playNextStory() {

        state++;
        System.out.println(state);
        boolean musicPlaying = true;

        if(state == 1) {
            bg1.setVisible(true);
            music = Assets.manager.get(Assets.STORY_MUSIC1);
        }else if(state == 2) {
            bg1.setVisible(false);
            bg2.setVisible(true);
            music = Assets.manager.get(Assets.STORY_MUSIC2);
        }else if(state == 3) {
            bg2.setVisible(false);
            bg1.setVisible(true);

            music = Assets.manager.get(Assets.STORY_MUSIC3);

        }else if(state == 4) {
            bg1.setVisible(false);
            bg2.setVisible(true);

            music = Assets.manager.get(Assets.STORY_MUSIC4);

        }else if(state == 5) {
            bg2.setVisible(false);
            bg3.setVisible(true);
            music = Assets.manager.get(Assets.NO_MUSIC);

        }else if(state == 6) {
            bg3.setVisible(false);
            bg4.setVisible(true);
            back.setVisible(true);
            music = Assets.manager.get(Assets.STORY_MUSIC5);

        }
        if(musicPlaying){
            music.play();

            music.setOnCompletionListener(new Music.OnCompletionListener() {
                @Override
                public void onCompletion(Music music) {
                    if (state == 6){
                        game.setScreen(new MenuScreen(game));
                    }else
                        playNextStory();
                }
            });
        }


    }

    @Override
    public void init() {

    }
}
