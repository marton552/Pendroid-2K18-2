package com.hakkatoreinbukuma.game.Screens.Game;

import com.badlogic.gdx.math.Vector2;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Core {
    public static Vector2 interpolate(Vector2 vector, float distance){
        Vector2 finalVector = new Vector2();
        if (distance >= vector.len()) finalVector.setZero();
        else vector.scl(vector.len() / distance);
        return finalVector;
    }
}
