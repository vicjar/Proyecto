package Secene2;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorPlayer extends Actor 
{
	private Texture player;
	
	private boolean alive;
	
	public boolean isAlive(){
		return alive;
	}
	public void setAlive(boolean alive){
		this.alive = alive;
	}

	
	public ActorPlayer(Texture player)
	{
		alive = true;
	this.player=player;	
	setSize(player.getWidth(), player.getHeight());
	}
@Override
public void act(float delta)
{

}

@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(player, getX(), getY());
	}
}
