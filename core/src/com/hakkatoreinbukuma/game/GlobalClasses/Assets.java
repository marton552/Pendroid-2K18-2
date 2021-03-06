package com.hakkatoreinbukuma.game.GlobalClasses;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.g3d.Model;


public class Assets {
	// https://github.com/libgdx/libgdx/wiki/Managing-your-assets
	// http://www.jacobplaster.net/using-libgdx-asset-manager
	// https://www.youtube.com/watch?v=JXThbQir2gU
	// https://github.com/Matsemann/libgdx-loading-screen/blob/master/Main/src/com/matsemann/libgdxloadingscreen/screen/LoadingScreen.java

	public static AssetManager manager;



	public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";


	static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
	static {
		fontParameter.fontFileName = "alegreyaregular.otf";
		fontParameter.fontParameters.size = 30;
		fontParameter.fontParameters.borderColor = Color.WHITE;
		fontParameter.fontParameters.borderWidth = 1;
		fontParameter.fontParameters.characters = CHARS;
		fontParameter.fontParameters.color = Color.WHITE;
	}

	public static final AssetDescriptor<BitmapFont> ALEGREYAREGULAR_FONT
			= new AssetDescriptor<BitmapFont>(fontParameter.fontFileName, BitmapFont.class, fontParameter);


	//public static final AssetDescriptor<Texture> AGYU_TEXTURE = new AssetDescriptor<Texture>("cannon/cannon5.png", Texture.class);
	//public static final AssetDescriptor<Texture> BG_TEXTURE = new AssetDescriptor<Texture>("back2.png", Texture.class);
	public static final AssetDescriptor<Texture> MENU = new AssetDescriptor<Texture>("menu.png", Texture.class);
	public static final AssetDescriptor<Texture> GAME_BG = new AssetDescriptor<Texture>("bg.png", Texture.class);
	public static final AssetDescriptor<Texture> MENU_ICON = new AssetDescriptor<Texture>("menu_icon.png", Texture.class);


	public static final AssetDescriptor<TextureAtlas> TITLE_ATLAS = new AssetDescriptor<TextureAtlas>("atlasok/opening.atlas", TextureAtlas.class);

	//Button
	public static final AssetDescriptor<Texture> BTN_BACK = new AssetDescriptor<Texture>("ui_textures/btn_back.png", Texture.class);
	public static final AssetDescriptor<Texture> BTN_HOVER = new AssetDescriptor<Texture>("ui_textures/btn_hover.png", Texture.class);

	public static final AssetDescriptor<Texture> WHITE_TEXTURE = new AssetDescriptor<Texture>("ui_textures/white.png", Texture.class);
	public static final AssetDescriptor<Texture> FULLWHITE_TEXTURE = new AssetDescriptor<Texture>("ui_textures/fullwhite.png", Texture.class);

	//Slider
	public static final AssetDescriptor<Texture> SLIDER_BG = new AssetDescriptor<Texture>("ui_textures/slider.png", Texture.class);
	public static final AssetDescriptor<Texture> SLIDER_KNOB = new AssetDescriptor<Texture>("ui_textures/sliderknob.png", Texture.class);
	public static final AssetDescriptor<Texture> SLIDER_KNOBH = new AssetDescriptor<Texture>("ui_textures/sliderknob2.png", Texture.class);

	public static final AssetDescriptor<Texture> LOGO = new AssetDescriptor<Texture>("logo.png", Texture.class);
	public static final AssetDescriptor<Texture> PEN_LOGO = new AssetDescriptor<Texture>("penlogo.jpg", Texture.class);
	public static final AssetDescriptor<Texture> SPONSOR = new AssetDescriptor<Texture>("sponsor.png", Texture.class);


	public static final AssetDescriptor<Texture> STAR = new AssetDescriptor<Texture>("star.png", Texture.class);


	public static final AssetDescriptor<TextureAtlas> BALL_ATLAS = new AssetDescriptor<TextureAtlas>("atlas/ball.atlas", TextureAtlas.class);
	public static final AssetDescriptor<TextureAtlas> FAN_ATLAS = new AssetDescriptor<TextureAtlas>("atlas/fan.atlas", TextureAtlas.class);

	public static final AssetDescriptor<TextureAtlas> WIND_ATLAS = new AssetDescriptor<TextureAtlas>("atlas/wind.atlas", TextureAtlas.class);
	public static final AssetDescriptor<TextureAtlas> OVER_ATLAS = new AssetDescriptor<TextureAtlas>("atlas/gameover.atlas", TextureAtlas.class);


	//Story
	public static final AssetDescriptor<Texture> FILM1 = new AssetDescriptor<Texture>("story/film1-3.png", Texture.class);
	public static final AssetDescriptor<Texture> FILM2 = new AssetDescriptor<Texture>("story/film2-4.png", Texture.class);
	public static final AssetDescriptor<Texture> FILM3 = new AssetDescriptor<Texture>("story/film5.png", Texture.class);
	public static final AssetDescriptor<Texture> FILM4 = new AssetDescriptor<Texture>("story/film6.png", Texture.class);

	public static final AssetDescriptor<Music> STORY_MUSIC1 = new AssetDescriptor<Music>("story/hang1.wav", Music.class);
	public static final AssetDescriptor<Music> STORY_MUSIC2 = new AssetDescriptor<Music>("story/hang2.wav", Music.class);
	public static final AssetDescriptor<Music> STORY_MUSIC3 = new AssetDescriptor<Music>("story/hang3.wav", Music.class);
	public static final AssetDescriptor<Music> STORY_MUSIC4 = new AssetDescriptor<Music>("story/hang4.wav", Music.class);
	public static final AssetDescriptor<Music> STORY_MUSIC5 = new AssetDescriptor<Music>("story/hang5.wav", Music.class);
	public static final AssetDescriptor<Music> NO_MUSIC = new AssetDescriptor<Music>("story/no.wav", Music.class);

	public static final AssetDescriptor<Sound> BTN_SOUND = new AssetDescriptor<Sound>("effects/pickup.mp3", Sound.class);

	//Music
	public static final AssetDescriptor<Music> MENU_MUSIC = new AssetDescriptor<Music>("music/menu.ogg", Music.class);
	public static final AssetDescriptor<Music> MUSIC_1 = new AssetDescriptor<Music>("music/1.ogg", Music.class);
	public static final AssetDescriptor<Music> MUSIC_2 = new AssetDescriptor<Music>("music/2.ogg", Music.class);
	public static final AssetDescriptor<Music> MUSIC_3 = new AssetDescriptor<Music>("music/3.ogg", Music.class);
	public static final AssetDescriptor<Music> MUSIC_4 = new AssetDescriptor<Music>("music/4.ogg", Music.class);
	public static final AssetDescriptor<Music> MUSIC_5 = new AssetDescriptor<Music>("music/5.ogg", Music.class);


	public static void prepare() {
		manager = new AssetManager();
		Texture.setAssetManager(manager);
	}

	public static void load() {
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));

		manager.load(GAME_BG);
		manager.load(MENU);
		manager.load(MENU_ICON);

		manager.load(TITLE_ATLAS);

		manager.load(BTN_BACK);
		manager.load(BTN_HOVER);

		manager.load(WHITE_TEXTURE);
		manager.load(FULLWHITE_TEXTURE);

		manager.load(SLIDER_BG);
		manager.load(SLIDER_KNOB);
		manager.load(SLIDER_KNOBH);

		manager.load(LOGO);

		manager.load(WIND_ATLAS);
		manager.load(BALL_ATLAS);
		manager.load(FAN_ATLAS);

		manager.load(STAR);

		manager.load(FILM1);
		manager.load(FILM2);
		manager.load(FILM3);
		manager.load(FILM4);

		manager.load(STORY_MUSIC1);
		manager.load(STORY_MUSIC2);
		manager.load(STORY_MUSIC3);
		manager.load(STORY_MUSIC4);
		manager.load(STORY_MUSIC5);
		manager.load(NO_MUSIC);

		manager.load(MENU_MUSIC);
		manager.load(MUSIC_1);
		manager.load(MUSIC_2);
		manager.load(MUSIC_3);
		manager.load(MUSIC_4);
		manager.load(MUSIC_5);

		manager.load(PEN_LOGO);
		manager.load(SPONSOR);

		manager.load(BTN_SOUND);

		manager.load(OVER_ATLAS);

		manager.load(ALEGREYAREGULAR_FONT);

	}

    public static void afterLoaded() {
        //manager.get(MUSIC).setLooping(true);
    }

	public static void unload() {
		manager.dispose();
	}

}
