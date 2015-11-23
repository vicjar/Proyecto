package com.proyecto.game;

import com.badlogic.gdx.Screen;

public abstract class BaseScreen implements Screen
{
protected MainGame game;

public BaseScreen(MainGame game){
	this.setGame(game);
}
	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	public MainGame getGame() {
		return game;
	}
	public void setGame(MainGame game) {
		this.game = game;
	}

}
