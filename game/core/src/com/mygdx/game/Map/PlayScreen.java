/*
package com.mygdx.game.Map;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
public class PlayScreen {
    public class PlayScreen implements Screen{
        //Reference to our Game, used to set Screens
        private MarioBros game;
        private TextureAtlas atlas;
        public static boolean alreadyDestroyed = false;

        //basic playscreen variables
        private OrthographicCamera gamecam;
        private Viewport gamePort;
        private Hud hud;

        //Tiled map variables
        private TmxMapLoader maploader;
        private TiledMap map;
        private OrthogonalTiledMapRenderer renderer;

        //Box2d variables
        private World world;
        private Box2DDebugRenderer b2dr;
        private B2WorldCreator creator;

        //sprites
        private Mario player;

        private Music music;

        private Array<Item> items;
        private LinkedBlockingQueue<ItemDef> itemsToSpawn;


        public PlayScreen(MarioBros game){
            atlas = new TextureAtlas("Mario_and_Enemies.pack");

            this.game = game;
            //create cam used to follow mario through cam world
            gamecam = new OrthographicCamera();

            //create a FitViewport to maintain virtual aspect ratio despite screen size
            gamePort = new FitViewport(MarioBros.V_WIDTH / MarioBros.PPM, MarioBros.V_HEIGHT / MarioBros.PPM, gamecam);

            //create our game HUD for scores/timers/level info
            hud = new Hud(game.batch);

            //Load our map and setup our map renderer
            maploader = new TmxMapLoader();
            map = maploader.load("level1.tmx");
            renderer = new OrthogonalTiledMapRenderer(map, 1  / MarioBros.PPM);

            //initially set our gamcam to be centered correctly at the start of of map
            gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);

            //create our Box2D world, setting no gravity in X, -10 gravity in Y, and allow bodies to sleep
            world = new World(new Vector2(0, -10), true);
            //allows for debug lines of our box2d world.
            b2dr = new Box2DDebugRenderer();

            creator = new B2WorldCreator(this);

            //create mario in our game world
            player = new Mario(this);

            world.setContactListener(new WorldContactListener());

            music = MarioBros.manager.get("audio/music/mario_music.ogg", Music.class);
            music.setLooping(true);
            music.setVolume(0.3f);
            //music.play();

            items = new Array<Item>();
            itemsToSpawn = new LinkedBlockingQueue<ItemDef>();
        }


}
*/