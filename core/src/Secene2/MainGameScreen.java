package Secene2;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.proyecto.game.BaseScreen;
import com.proyecto.game.MainGame;

public class MainGameScreen extends BaseScreen {

	public MainGameScreen(MainGame game) {
		super(game);
	texturePlayer = new Texture("character.png");
	textureObstacle = new Texture("obstacle.png");
	}
	
private Stage stage;
private ActorPlayer player;
private ActorObstacle obstacle;
private Texture texturePlayer, textureObstacle;
	

@Override
public void show() {

stage = new Stage();
stage.setDebugAll(true);

player = new ActorPlayer(texturePlayer);
obstacle = new ActorObstacle(textureObstacle);

stage.addActor(player);
stage.addActor(obstacle);

player.setPosition(20, 100);
obstacle.setPosition(400, 100);

}
	@Override
	public void hide() {
	stage.dispose();
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		colision();
		stage.draw();
	}
	private void colision(){
		if (player.isAlive() && (player.getX() + player.getWidth() > obstacle.getX()))
		{
			System.out.println("colisiono");
			player.setAlive(false);
			System.out.println("muerto");
		}
	}
	@Override
	public void dispose() {
		texturePlayer.dispose();
	}
}
