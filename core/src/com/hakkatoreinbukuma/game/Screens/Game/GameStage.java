package com.hakkatoreinbukuma.game.Screens.Game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.MyStage;
import com.hakkatoreinbukuma.game.MyGdxGame;

import java.util.Random;

public class GameStage extends MyStage {

    Fan fan;

    float strength;
    int strengthLasts;
    int strengthTick = 0;

    boolean windBlowing = false;

    int nextWind = 0;
    boolean startWindTick = false;
    int windTick = 0;

    public int SCORE = 0;

    Random r = new Random();


    public GameStage(Batch batch, MyGdxGame game) {
        super(new ExtendViewport(1024, 576, new OrthographicCamera(1024, 576)), batch, game);

        fan = new Fan();

        addListener(new DragListener(){
            @Override
            public void dragStart(InputEvent event, float x, float y, int pointer) {
                super.dragStart(event, x, y, pointer);

                fan.setX(x - fan.getWidth());
            }
        });

        addActor(fan);

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

        // SIDES
        if(rand == 0){ // lefelé fúj
            point = new Vector2(0, -1);
        }else if(rand == 1) { // felfelé fúj
            point = new Vector2(0, 1);
        }else if(rand == 2) { // jobbra fúj
            point = new Vector2(1, 0);
        }else if(rand == 3) { // balra fúj
            point = new Vector2(-1, 0);
        }

        strength = r.nextInt(3) + 2;

        strengthLasts = r.nextInt(100) + 50;

        windBlowing = true;


        //Wind létrehozása
    }

    @Override
    public void init() {

    }
}
