package com.hakkatoreinbukuma.game.Screens.Game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

import java.util.ArrayList;
import java.util.Vector;

public class Ball extends OneSpriteAnimatedActor{
    float radius;
    Vector2 velocity;
    ArrayList<Vector2> forces;
    Vector2 position;

    public Ball(TextureAtlas textureAtlas) {
        super(textureAtlas);
        setSize(getWidth() / 6, getHeight() / 6);
        setLooping(true);
        forces = new ArrayList<Vector2>();
        position = new Vector2(super.getX() + super.getWidth() / 2, super.getY() + super.getHeight() / 2);

    }

    @Override
    public void setSize(float width, float height) {
        super.setSize(width, height);
        radius = width / 2;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        Vector2 windPos = new Vector2(0, 0);
        Vector2 windDir = new Vector2(300, 700);
        raycast(windPos, windDir);
    }

    public void setPosition(float x, float y){
        super.setPosition(x, y);
        position.set(super.getX() + super.getWidth() / 2, super.getY() + super.getHeight() / 2);
    }
    public void startSampling() {
        forces.clear();
    }

    public Vector2 raycast(Vector2 rayOrigin, Vector2 rayDirection){
        System.out.println(rayOrigin.x + " " + rayOrigin.y);
        Vector2 rayDir = (new Vector2(rayOrigin)).add(rayDirection);
        System.out.println(rayOrigin.x + " " + rayOrigin.y);
        Vector2 intersection = lineIntersection(rayOrigin, rayDir, position);
        if((intersection) == null) System.out.println("Nincs ütközés");
        else System.out.println("Ütközés (" + intersection.x + " " + intersection.y + ") pontnál");
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

    public boolean pointCircleCollision(Vector2 point, Vector2 circlepos, float radius) {
        if (radius == 0) return false;
        Vector2 d = circlepos.sub(point);
        return d.x * d.x + d.y * d.y <= radius * radius;
    }

    public Vector2 lineIntersection(Vector2 a, Vector2 b, Vector2 circle) {
        System.out.println("Intersection test: " + a.x + " " + a.y + " " + b.x + " " + b.y + " " + circle.x + " " + circle.y);
        if (pointCircleCollision(a, circle, radius)) return a;
        if (pointCircleCollision(b, circle, radius)) return b;

        Vector2 d = b.sub(a);
        Vector2 lc = circle.sub(a);

        Vector2 p = d;
        if (d.len2() > 0) {
            float dp = (lc.x * d.x + lc.y * d.y) / d.len2();
            p = p.scl(dp);
        }

        Vector2 nearest = a.add(p);

        if(pointCircleCollision(nearest, circle, radius) && p.len2() <= d.len2() && (p.x * d.x + p.y * d.y) >= 0) return nearest;
        else return null;
    }
}
