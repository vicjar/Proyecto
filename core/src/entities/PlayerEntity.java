package entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
public class PlayerEntity extends Actor {

	static final float PIXELS_IN_METER = 91;
	private Texture texture;
	private World world;
	private Body body;
	private Fixture fixture;
	private boolean alive = true, jumping = false, mustJump = false;

	public PlayerEntity(World world, Texture texture, Vector2 position){
	this.world = world;
	this.texture = texture;
	
	BodyDef def = new BodyDef();
	def.position.set(position);
	def.type = BodyDef.BodyType.DynamicBody;
	body = world.createBody(def);
	
	PolygonShape box = new PolygonShape();
		box.setAsBox(0.5f, .5f);
		fixture = body.createFixture(box, 3);
		fixture.setUserData("player");
		box.dispose();
		
		setSize(PIXELS_IN_METER, PIXELS_IN_METER);
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
	setPosition((body.getPosition().x+0.5f)*PIXELS_IN_METER, 
				(body.getPosition().y+0.5f)*PIXELS_IN_METER);
	batch.draw(texture, getX(), getY(), getWidth(), getHeight());	
	}
	
	@Override
	public void act(float delta){
		//saltar si se toca la pantalla
		if(Gdx.input.justTouched() || mustJump){
			mustJump=false;
			jump();
		}
		//---------------------------------------------------velocidad
		if(alive){
			float speedY = body.getLinearVelocity().y;
			body.setLinearVelocity(1.5f, speedY);
		}

	}
	public void jump(){
		if(!jumping){
			jumping=true;
			Vector2 position = body.getPosition();
			body.applyLinearImpulse(0, 20, position.x, position.y, true);
		}
	}
	public void detach() {
		body.destroyFixture(fixture);
		world.destroyBody(body);
		
	}
	public boolean isAlive() {
		return alive;
	}
	public boolean isJumping() {
		return jumping;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	public boolean isMustJump() {
		return mustJump;
	}
	public void setMustJump(boolean mustJump) {
		this.mustJump = mustJump;
	}
	
	
	
	
}
