package com.hakkatoreinbukuma.game.Screens.Game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.MyButton;
import com.hakkatoreinbukuma.game.MyBaseClasses.UI.MyLabel;
import com.hakkatoreinbukuma.game.MyGdxGame;
import com.hakkatoreinbukuma.game.Screens.Menu.MenuScreen;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class HUD extends MyStage {

    MyLabel scoreCount;
    GameStage gameStage;

    Pixmap fadepixmap;
    Texture fadetexture;
    OneSpriteStaticActor fade;

    OneSpriteStaticActor menuBtn;
    MyLabel title;
    MyButton back;
    MyButton menu;

    GameScreen screen;

    public HUD(Batch batch, MyGdxGame game, GameStage gameStage, GameScreen screen) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);

        this.gameStage = gameStage;
        this.screen = screen;

        scoreCount = new MyLabel("0", game.getLabelStyle());
        scoreCount.setFontScale(1.5f);
        scoreCount.getStyle().fontColor = Color.BLACK;

        scoreCount.setX(getViewport().getWorldWidth() / 2 - scoreCount.getWidth() / 2 -(scoreCount.getWidth() / 2 / 2));
        scoreCount.setY(getViewport().getWorldHeight() - scoreCount.getHeight() - 20);


        addActor(scoreCount);

        addListener(new InputListener(){
            @Override
            public boolean keyDown(InputEvent event, int keycode) {

                if(keycode == Input.Keys.BACK){
                    startPauseMode();
                }

                return super.keyDown(event, keycode);
            }
        });

        menuBtn = new OneSpriteStaticActor(Assets.manager.get(Assets.MENU_ICON));
        menuBtn.setSize(32, 32);
        menuBtn.setPosition(getViewport().getWorldWidth() - menuBtn.getWidth()- 10, getViewport().getWorldHeight() - menuBtn.getHeight() - 10);
        addActor(menuBtn);

        menuBtn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println("Vissza");
                startPauseMode();
            }
        });


    }


    @Override
    public void act(float delta) {
        super.act(delta);

        scoreCount.setText(""+gameStage.SCORE);
        scoreCount.setX(getViewport().getWorldWidth() / 2 - scoreCount.getWidth() / 2 -(scoreCount.getWidth() / 2 / 2));

        //scoreCount.setX();

    }

    public void startPauseMode(){

        if(screen.paused == false){

            fadepixmap = new Pixmap((int) getViewport().getWorldWidth(), (int) getViewport().getWorldHeight(), Pixmap.Format.RGBA8888);

            fadepixmap.setColor(0, 0, 0, 0.7f);
            fadepixmap.fill();

            fadetexture = new Texture(fadepixmap);
            fade = new OneSpriteStaticActor(fadetexture);
            fade.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());

            title = new MyLabel("SZÜNET", game.getLabelStyle());
            title.setFontScale(1.5f, 1.5f);
            title.setPosition(getViewport().getWorldWidth() / 2 - title.getWidth() / 2 - (title.getWidth() / 2 / 2), getViewport().getWorldHeight() - title.getHeight() - 100);


            back = new MyButton("Vissza", game.getButtonStyle());
            back.setPosition(getViewport().getWorldWidth() / 2 - back.getWidth() / 2, getViewport().getWorldHeight() / 2 + 10);

            back.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    stopPauseMode();
                }
            });

            menu = new MyButton("Menü", game.getButtonStyle());
            menu.setPosition(getViewport().getWorldWidth() / 2 - back.getWidth() / 2, getViewport().getWorldHeight() / 2 - back.getHeight() - 10);


            menu.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    game.setScreen(new MenuScreen(game));
                }
            });


            addActor(fade);
            addActor(title);
            addActor(back);
            addActor(menu);

            screen.paused = true;
        }
    }

    public void stopPauseMode() {
        if(screen.paused == true){

            getActors().removeValue(fade, false);
            getActors().removeValue(title, false);
            getActors().removeValue(back, false);
            getActors().removeValue(menu, false);

            screen.paused = false;
        }
    }

    @Override
    public void init() {

    }
}
