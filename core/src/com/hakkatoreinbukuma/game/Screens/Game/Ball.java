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
        setSize(getWidth() / 6, getHeight() / 6);
        setLooping(true);
        position = new Vector2();
        forces = new ArrayList<Vector2>();

    }
    public void setPosition(float x, float y){
        super.setPosition(x, y);
        position.set(x, y);
    }
    public void startSampling() {
        forces.clear();
    }

    public Vector2 raycast(Vector2 rayOrigin, Vector2 rayDirection){
        Vector2 rayEnd = rayOrigin.add(rayDirection);
        double dR = Math.sqrt(Math.pow(rayDirection.x, 2) + Math.pow(rayDirection.y, 2));
        double d = rayEnd.x * rayOrigin.y - rayOrigin.x * rayEnd.y;
        double discriminant = Math.pow(radius, 2) - Math.pow(dR, 2) - Math.pow(d, 2);

        if(discriminant < 0) System.out.println("Nem érinti");
        else if(discriminant == 0) System.out.println("Érinti");
        else System.out.println("Átmegy rajta");

        return null;
    }

    public Vector2 getSurfaceNormal(){

        return null;
    }

    public void shift(Vector2 vector) {
        position = position.add(vector);
        super.setPosition(position.x, position.y);
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
