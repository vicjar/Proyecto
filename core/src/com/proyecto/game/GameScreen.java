package com.proyecto.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

import entities.FloorEntity;
import entities.ObstacleEntity;
import entities.PlayerEntity;

public class GameScreen extends BaseScreen{
	
	
		private Stage stage;
		private World world;
		private PlayerEntity player;
		
		private ArrayList<FloorEntity> floorList = new ArrayList<FloorEntity>();
		private ArrayList<ObstacleEntity> obstacleList = new ArrayList<ObstacleEntity>();
		
		public GameScreen(MainGame game) {
			super(game);
			stage = new Stage(new FitViewport(640, 360));
			world = new World(new Vector2(0, -10), true);
			
			world.setContactListener(new ContactListener() {
				private boolean areCollided(Contact contact, Object userA, Object userB){
					return (contact.getFixtureA().getUserData().equals(userA) && contact.getFixtureB().getUserData().equals(userB)) ||
							(contact.getFixtureA().getUserData().equals(userB) && contact.getFixtureB().getUserData().equals(userA));
				}
				@Override
				public void preSolve(Contact contact, Manifold oldManifold) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void postSolve(Contact contact, ContactImpulse impulse) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void endContact(Contact contact) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void beginContact(Contact contact) {
					
					if(areCollided(contact, "player", "floor")){
						System.out.println("Salto");
						
						player.setJumping(false);
						if(Gdx.input.isTouched()){
							player.setMustJump(true);
						}
					}
					if(areCollided(contact, "player","obstacle")){
						player.setAlive(false);
						System.out.println("Moriste");
					}
				}
			});
				
			}
		
		@Override
		public void show() {
		Texture playerTexture = game.getManager().get("character.png");
		Texture floorTexture = game.getManager().get("floor.png");
		Texture obstacleTexture = game.getManager().get("obstacle.png");
		Texture overFloorTexture = game.getManager().get("overfloor.png");
		
		player = new PlayerEntity(world, playerTexture, new Vector2(0, 1));
		floorList.add(new FloorEntity(world, floorTexture, overFloorTexture, 0, 1000, 1));
		obstacleList.add(new ObstacleEntity(world, obstacleTexture, 4, 2));
		
		stage.addActor(player);
		
		for (FloorEntity floor : floorList){
			stage.addActor(floor);
		}
		for (ObstacleEntity obstacle : obstacleList){
			stage.addActor(obstacle);
		}
		
		}
		
		@Override
		public void hide() {
	 player.detach();
	 player.remove();
	 
	 for (FloorEntity floor : floorList){
	floor.detach();
	floor.remove();
	 }
		for (ObstacleEntity obstacle : obstacleList){
			obstacle.detach();
			obstacle.remove();
		}
		
		}
		@Override
		public void render(float delta) {
		Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		world.step(delta, 6, 2);
		stage.draw();
		}
		
		@Override
		public void dispose(){
			stage.dispose();
			world.dispose();
		}
}
