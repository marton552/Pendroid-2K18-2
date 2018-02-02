package com.hakkatoreinbukuma.game.Screens.Game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.hakkatoreinbukuma.game.MyGdxGame;
import com.hakkatoreinbukuma.game.Screens.End.EndScreen;

import java.util.Random;

public class GameStage extends MyStage {


    MyGdxGame game;

    public Ball ball;
    public Fan fan;

    float strength;
    int strengthLasts;

    int strengthTick = 0;

    boolean windBlowing = false;
    int nextWind = 0;
    boolean startWindTick = false;

    int windTick = 0;

    public int SCORE = 0;
    public int STARS = 0;

    Star star;
    boolean isStar = false;
    int starTick = 0;
    int nextStar = 1000;
    int starLasts = 100;


    Random r = new Random();

    boolean timerIsOn = false;

    OneSpriteStaticActor bg;
    //OneSpriteAnimatedActor fanWind;


    public GameStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);

        this.game = game;

        bg = new OneSpriteStaticActor(Assets.manager.get(Assets.GAME_BG));
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());

        addActor(bg);

        ball = new Ball(Assets.manager.get(Assets.BALL_ATLAS));
        ball.setPosition(500, 500);
        ball.setFps(10);
        addActor(ball);

        final OneSpriteAnimatedActor fanWind = new OneSpriteAnimatedActor(Assets.manager.get(Assets.WIND_ATLAS));

        fan = new Fan();

        addListener(new DragListener(){

            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                super.drag(event, x, y, pointer);
                fan.setX(x - fan.getWidth() / 2);
                fanWind.setPosition(fan.getX(), fan.getY() + fan.getHeight() + 10);
            }

            @Override
            public void dragStart(InputEvent event, float x, float y, int pointer) {
                super.dragStart(event, x, y, pointer);

                fan.setX(x - fan.getWidth() / 2);
                fanWind.setPosition(fan.getX(), fan.getY() + fan.getHeight() + 10);
            }
        });




        fanWind.setSize(fanWind.getWidth() / 2, fanWind.getHeight() / 2);
        fanWind.setFps(5);
        fanWind.setLooping(true);
        fanWind.setRotation(90);
        fanWind.setPosition(fan.getX(), fan.getY() + fan.getHeight() + 10);

        addActor(fan);
        addActor(fanWind);

        generateWind();

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if(startWindTick) {
            windTick++;

            if(windTick >= nextWind) {
                windTick = 0;
                generateWind();
                startWindTick = false;
            }
        }

        if(windBlowing) {
            strengthTick++;

            if(strengthTick >= strengthLasts) {
                strengthTick = 0;
                strength -= 0.5f;

                // setWindStrength

                if(strength <= 0)
                    destroyWind();
            }
        }

        if(!timerIsOn) { // Score számláló
            timerIsOn = true;

            Timer.schedule(new Timer.Task() {

                @Override
                public void run() {
                    SCORE += 1;
                    timerIsOn = false;
                }

            }, 1);

        }

        //Star létrehozása majd eltünése.



        //End Game
        //A labda a képernyőn kívül van-e?

        if(ball.getX() >= getViewport().getWorldWidth() || ball.getX() + ball.getWidth() <= 0
                || ball.getY() + ball.getHeight() < 0 || ball.getY() >= getViewport().getWorldHeight()) {

            game.setScreen(new EndScreen(game, SCORE, STARS));
        }


    }

    public void destroyWind() {

        strengthTick= 0;

        nextWind = r.nextInt(200) + 200;

        windBlowing = false;
        startWindTick = true;

        //Wind törlése.
    }

    public void generateWind() {
        int rand = r.nextInt(3);

        Vector2 point;

        // POINT
        if(rand == 0){ // lefelé fúj
            point = new Vector2(0, -1);
        }else if(rand == 1) { // felfelé fúj
            point = new Vector2(0, 1);
        }else if(rand == 2) { // jobbra fúj
            point = new Vector2(1, 0);
        }else{ // balra fúj
            point = new Vector2(-1, 0);
        }

        strength = r.nextInt(3) + 2;

        strengthLasts = r.nextInt(100) + 50;

        windBlowing = true;


        //Wind létrehozása
        Vector2 point2 = new Vector2(0, 200);

        Vector2 dir = point.scl(r.nextInt(300));

        ball.addForce(dir);


    }

    @Override
    public void init() {

    }
}
