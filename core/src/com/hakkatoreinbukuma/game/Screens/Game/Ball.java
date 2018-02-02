package com.hakkatoreinbukuma.game.Screens.Game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

import java.util.ArrayList;

public class Ball extends OneSpriteAnimatedActor{
    float radius;
    Vector2 velocity;
    ArrayList<Vector2> forces;
    Vector2 position;

    public Ball(TextureAtlas textureAtlas) {
        super(textureAtlas);
    }
    public void setPosition(float x, float y){
        super.setPosition(x, y);
        position.set(x, y);
    }
    public void startSampling() {
        forces.clear();
    }

    public Vector2 raycast(Vector2 startPoint, Vector2 direction){
        Vector2 invStartPoint = new Vector2();
        invStartPoint.setZero();

        return null;
    }

    public Vector2 getSurfaceNormal(){
        return null;
    }

    public void shift(Vector2 vector){
        //super.setPosition(vector[0], vector[1]);
    }

    public void addForce(Vector2 force) {
        forces.add(force);
    }
    public Vector2 finishSampling(){
        Vector2 direction = new Vector2();
        for(Vector2 force : forces){
            direction.add(force);
        }
        return direction;
    }
}
