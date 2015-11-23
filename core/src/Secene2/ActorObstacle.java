package Secene2;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorObstacle extends Actor{
private Texture obstacle;

public ActorObstacle(Texture obstacle){
	this.obstacle = obstacle;
	setSize(obstacle.getWidth()-30, obstacle.getHeight()+10);
}
@Override
	public void act(float delta) 
	{
	setX(getX() - 300 * delta);
}
@Override
	public void draw(Batch batch, float parentAlpha) {
	batch.draw(obstacle, getX(), getY(), 100, 140);
}
}
