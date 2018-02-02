package com.hakkatoreinbukuma.game.Screens.Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class WindGenerator extends OneSpriteStaticActor {

    float velocity;
    Vector2 direction;
    Vector2 position;

    public WindGenerator(Texture texture) {
        //Nulltexture handler
        super(texture);

        position = new Vector2();
        direction = new Vector2();

        position.setZero();
        direction.setZero();
        velocity = 0.0f;
    }

    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        position.set(x, y);
    }
}