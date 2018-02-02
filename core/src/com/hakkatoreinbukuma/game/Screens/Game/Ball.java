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
    ArrayList<ArrayList<Vector2>> winds;

    public Ball(TextureAtlas textureAtlas) {
        super(textureAtlas);
        setSize(getWidth() / 6, getHeight() / 6);
        setLooping(true);
        forces = new ArrayList<Vector2>();
        winds = new ArrayList<ArrayList<Vector2>>();
        position = new Vector2(super.getX() + super.getWidth() / 2, super.getY() + super.getHeight() / 2);
        velocity = new Vector2(0, 0);

        ArrayList<Vector2> wind1 = new ArrayList<Vector2>();
        wind1.add(new Vector2(200, 0));
        wind1.add(new Vector2(0, 800));
        winds.add(wind1);
    }

    @Override
    public void setSize(float width, float height) {
        super.setSize(width, height);
        radius = width / 2;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        forces.clear();
        for(ArrayList<Vector2> wind : winds){
            Vector2 windForce = raycast(wind.get(0), wind.get(1));
            if(windForce != null) forces.add(windForce);
        }

        Vector2 direction = new Vector2(0, 0);
        for(Vector2 force : forces){
            direction.add(force);
        }
        shift(direction);
    }

    public void setPosition(float x, float y){
        super.setPosition(x, y);
        position.set(super.getX() + super.getWidth() / 2, super.getY() + super.getHeight() / 2);
    }

    public Vector2 raycast(Vector2 rayOrigin, Vector2 rayDirection){
        Vector2 rayDir = (new Vector2(rayOrigin)).add(rayDirection);
        Vector2 intersection = lineIntersection(rayOrigin, rayDir, new Vector2(position));
        if((intersection) == null) System.out.println("Nincs ütközés");
        else {
            Vector2 normal = getCircleNormal(position, intersection);
            double radwidth = (2 * Math.PI) / (getWidth());
            System.out.println(radwidth);
            normal.y -= ((float)Math.cos(radwidth * (normal.x / 2)) / radwidth);

            Vector2 forceVector = new Vector2(1, 0).rotate(-normal.angle());
            forceVector.x *= -1;
            //forceVector = forceVector.scl(/*interpolate wind vector*/);
            return forceVector;
        }
        return null;
    }

    public Vector2 getCircleNormal(Vector2 center, Vector2 point){
        Vector2 normal = new Vector2(point).sub(center);
        return normal;
    }

    public void shift(Vector2 vector) {
        position = position.add(vector);
        super.setPosition(position.x, position.y);
    }

    public boolean pointCircleCollision(Vector2 point, Vector2 circlepos, float radius) {
        if (radius == 0) return false;
        Vector2 d = new Vector2(circlepos).sub(point);
        return d.x * d.x + d.y * d.y <= radius * radius;
    }

    public Vector2 lineIntersection(Vector2 a, Vector2 b, Vector2 circle) {
        if (pointCircleCollision(a, circle, radius)) return a;
        if (pointCircleCollision(b, circle, radius)) return b;

        Vector2 d = new Vector2(b).sub(a);
        Vector2 lc = new Vector2(circle).sub(a);

        Vector2 p = d;
        if (d.len2() > 0) {
            float dp = (lc.x * d.x + lc.y * d.y) / d.len2();
            p = p.scl(dp);
        }

        Vector2 nearest = new Vector2(a).add(p);

        if(pointCircleCollision(nearest, circle, radius) && p.len2() <= d.len2() && (p.x * d.x + p.y * d.y) >= 0) return nearest;
        else return null;
    }
}
