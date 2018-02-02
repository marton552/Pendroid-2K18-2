package com.hakkatoreinbukuma.game.Screens.Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class WindGenerator extends OneSpriteStaticActor {

    float velocity;
    Vector2 direction;

    public WindGenerator(Texture texture) {
        super(texture);
    }

    public void setPosition(float x, float y) {

    }
}
