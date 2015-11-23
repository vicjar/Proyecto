package com.proyecto.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class MainGame extends Game {

	private AssetManager manager;
	
	public AssetManager getManager(){
		return manager;
	}
	
@Override
public void create(){
	manager = new AssetManager();
	manager.load("character.png", Texture.class);
	manager.load("obstacle.png", Texture.class);
	manager.load("floor.png", Texture.class);
	manager.load("overfloor.png", Texture.class);
	
	manager.finishLoading();
	setScreen(new GameScreen(this));
}

}