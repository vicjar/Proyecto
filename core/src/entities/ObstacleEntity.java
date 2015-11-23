package entities;

import static com.proyecto.game.Constantes.PIXELS_IN_METER;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import static com.proyecto.game.Constantes.PIXELS_IN_METER;

public class ObstacleEntity extends Actor{
	private Texture texture;
	private World world;
	private Body body;
	private Fixture fixture;


	public ObstacleEntity(World world, Texture texture, float x, float y){
	this.world=world;
	this.texture=texture;
	
	BodyDef def = new BodyDef();
	def.position.set(x, y-1.5f);
//	def.type = BodyDef.BodyType.DynamicBody;
	body = world.createBody(def);
	
	PolygonShape box = new PolygonShape();
	box.setAsBox(0.5f, .5f);
	fixture = body.createFixture(box, 1);
	fixture.setUserData("obstacle");
	box.dispose();

	setSize(PIXELS_IN_METER, PIXELS_IN_METER);
	setPosition((x)* PIXELS_IN_METER,y*PIXELS_IN_METER);

	}
	public void draw(Batch batch, float parentAlpha) {
		setPosition((body.getPosition().x+0.5f)*PIXELS_IN_METER, 
					(body.getPosition().y+.5f)*PIXELS_IN_METER);
		batch.draw(texture, getX(), getY(), getWidth(), getHeight());
	
	}

		public void detach() {
			body.destroyFixture(fixture);
			world.destroyBody(body);
			
		}

}
