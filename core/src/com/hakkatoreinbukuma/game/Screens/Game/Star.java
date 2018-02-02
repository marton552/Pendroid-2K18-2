package com.hakkatoreinbukuma.game.Screens.Game;

import com.badlogic.gdx.graphics.Texture;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Star extends OneSpriteStaticActor{

    boolean right = true;

    public Star() {
        super(Assets.manager.get(Assets.STAR));
        setSize(getWidth() / 3, getHeight() / 3);
    }

    @Override
    public void act(float delta) {
        super.act(delta);


        if(right) {
            setX(getX() + 5);

            if(getX() >= getStage().getViewport().getWorldWidth()) {
                right = false;
            }
        }else{

            setX(getX() - 5);

            if(getX() < - getWidth()) {
                right = true;
            }
        }

    }
}
