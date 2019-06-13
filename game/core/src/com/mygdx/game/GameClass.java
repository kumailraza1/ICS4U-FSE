 package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Entities.LoadTypes;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.Map.GameMap;
//import com.mygdx.game.Map.PlayScreen;
import com.mygdx.game.Map.TileType;
import com.mygdx.game.Map.TiledGameMap;

import java.awt.*;

 public class GameClass extends ApplicationAdapter {
    public static final float PPM = 100;
	SpriteBatch batch;
	Sprite playerimg;
	Texture playertex;
	OrthographicCamera camera;
	//GameMap gameMap;
	TmxMapLoader mapLoader;
	TiledMap map;
	OrthogonalTiledMapRenderer renderer;
	Viewport gamePort;

	//sprites
    Player player;

	// Box 2D variables
    World world;
    Box2DDebugRenderer b2dr;


	@Override
	public void create () {
        batch = new SpriteBatch();
        //setScreen(new PlayScreen(this));

        //Loading player pic
        playertex = new Texture("temp.png");//player
        playerimg = new Sprite(playertex);
        playerimg.setSize(1,1);

        LoadTypes.load();
        ////LOADING THE MAP
        mapLoader=new TmxMapLoader();
        map =mapLoader.load("map.tmx");
        renderer=new OrthogonalTiledMapRenderer(map, 1/PPM);
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false,Gdx.graphics.getWidth()/PPM, Gdx.graphics.getHeight()/PPM);

		//Box2D for the layer
        //creating box2d world
		world = new World(new Vector2(0,-10),true);
		b2dr= new Box2DDebugRenderer();
		player=new Player(world);
        //Defining box2d body and fixture, and shape
        BodyDef bdef = new BodyDef();
        PolygonShape shape= new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;
        //Box2D for the ground
        for(MapObject object: map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect=((RectangleMapObject)object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX()+rect.getWidth() / 2)/PPM, (rect.getY()+rect.getHeight()/2)/PPM);

            body=world.createBody(bdef);

            shape.setAsBox((rect.getWidth()/2)/PPM,(rect.getHeight()/2)/PPM);
            fdef.shape=shape;
            body.createFixture(fdef);
        }
        //Box2D for the obstacles
        for(MapObject object: map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect=((RectangleMapObject)object).getRectangle();
            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX()+rect.getWidth() / 2)/PPM, (rect.getY()+rect.getHeight()/2)/PPM);

            body=world.createBody(bdef);

            shape.setAsBox((rect.getWidth()/2)/PPM,(rect.getHeight()/2)/PPM);
            fdef.shape=shape;
            body.createFixture(fdef);
        }
        camera.update();
		//gameMap = new TiledGameMap();
        //Player.create(map);

	}

	public void handleInput(){
	    ////////////// MOVEMENT OF THE PLAYER ///////////////////

	    if(Gdx.input.isKeyJustPressed((Input.Keys.UP))){
	        player.b2body.applyLinearImpulse(new Vector2(0,7f),player.b2body.getWorldCenter(),true);
        }
        if(Gdx.input.isKeyJustPressed((Input.Keys.DOWN))){
            player.b2body.applyLinearImpulse(new Vector2(0,-0.1f),player.b2body.getWorldCenter(),true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.b2body.getLinearVelocity().x<=2){
            player.b2body.applyLinearImpulse(new Vector2(0.1f,0),player.b2body.getWorldCenter(),true);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.b2body.getLinearVelocity().x>=-2){
            player.b2body.applyLinearImpulse(new Vector2(-0.1f,0),player.b2body.getWorldCenter(),true);
        }
    }

    public void update(){
	    handleInput();
        world.step(1/60f,6,2);
        //camera moves according to the movement of mario
        if(player.b2body.getPosition().x>=Gdx.graphics.getWidth()/2/PPM){
            camera.position.x = player.b2body.getPosition().x;
        }
        camera.update();
        renderer.setView(camera);
    }


	@Override
	public void render () {
        update();
	    //Player.update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//Player.render(batch);


        //render our game map
		renderer.render();

        // renderer our BOX2DDebugLines
        b2dr.render(world,camera.combined);

		//Rectangle rect = Player.getBoundingRectangle();
		//System.out.println(gameMap.doesRectCollideWithMap(rect.getX(),rect.getY(),(int)rect.getWidth(),(int)rect.getHeight()));
		//TileType type = gameMap.getTileTypeByLocation(0, 10, 50);
		//if(type!=null){
			//System.out.println(type.getId());
		//}

		//System.out.println(gameMap.doesCollide(Player.getBoundingRectangle()));
        //TileType type = gameMap.getTileTypeByLocation(0, 10, 50);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        playerimg.setPosition(player.b2body.getPosition().x - playerimg.getWidth() / 2, player.b2body.getPosition().y - playerimg.getHeight() / 2);
        playerimg.draw(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		renderer.dispose();
        world.dispose();
        b2dr.dispose();
        map.dispose();
	}
}
