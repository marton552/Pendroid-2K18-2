package com.hakkatoreinbukuma.game.Screens.Game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.hakkatoreinbukuma.game.GlobalClasses.Assets;
import com.hakkatoreinbukuma.game.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

/**
 * Created by tanulo on 2018. 02. 02..
 */

public class Fan extends OneSpriteAnimatedActor{

    public Fan() {

        //super(Assets.manager.get(Assets.TITLE_ATLAS));
        super(Assets.manager.get(Assets.TITLE_ATLAS));

        setLooping(true);

    }
}
