package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.proyecto.game.Constantes.PIXELS_IN_METER;
public class FloorEntity extends Actor{

private World world;
private Texture floor;
private Texture overfloor;
private Body body;
private Fixture fixture;

public FloorEntity(World world, Texture floor, Texture overfloor, float x, float width, float y) {
this.world = world;
this.floor = floor;
this.overfloor = overfloor;

//------colocar suelo en su posicion correspondiente
BodyDef def = new BodyDef();
def.position.set(-0.5f, y -1f);
body = world.createBody(def);

//-------forma de caja
PolygonShape box = new PolygonShape();
box.setAsBox(1000,0);//tamaño de la propiedad fisica
fixture = body.createFixture(box, 1);
fixture.setUserData("floor");
box.dispose();

setSize(PIXELS_IN_METER+1000, PIXELS_IN_METER);//tamaño de la imagen que se pinta
setPosition((x-width/2)* PIXELS_IN_METER,(y-1)*PIXELS_IN_METER);

}

public void draw(Batch batch, float parentAlpha) {
setPosition((body.getPosition().x+0.5f)*PIXELS_IN_METER, 
			(body.getPosition().y)*PIXELS_IN_METER);
batch.draw(floor, getX(), getY(), getWidth(), getHeight());
}

public void detach() {
	body.destroyFixture(fixture);
	world.destroyBody(body);
	
}



}
