package br.com.thiagopagonha.labirinthos;

import static br.com.thiagopagonha.labirinthos.utils.Constants.CAMERA_HEIGHT;
import static br.com.thiagopagonha.labirinthos.utils.Constants.CAMERA_WIDTH;
import static br.com.thiagopagonha.labirinthos.utils.Constants.MAX_FPS;

import java.util.HashMap;
import java.util.Map;

import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.util.Log;
import br.com.thiagopagonha.labirinthos.scenes.SplashScreenScene;

/**
 * Atividade Principal da Aplicação
 * 
 * @author Thiago Pagonha
 * @version Abr/2013
 *
 */
public class MainActivity extends SimpleBaseGameActivity {

	public static final String TAG = "MainActivity";
	
	// -- Usado como um container de todos os recursos importantes 
	private GameResources gameResources = new GameResources();

	public GameResources getGameResources() {
		return gameResources;
	}
	
	public EngineOptions onCreateEngineOptions() {
		Log.i(TAG, "onCreateEngineOptions()");

		/*
		 * Inicializa a câmera com os propriedades inseridas
		 */
		Camera camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		
		gameResources.add(Camera.class, camera);
		
		EngineOptions engineOptions = new EngineOptions(true,
				ScreenOrientation.LANDSCAPE_FIXED, new FillResolutionPolicy(),
				camera);

//		engineOptions.getAudioOptions().setNeedsMusic(true).setNeedsSound(true);
//	    engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
		
		return engineOptions;
	}

	@Override
	protected void onCreateResources() {
		Log.i(TAG, "onCreateResources()");
		
	    FontFactory.setAssetBasePath("font/");
	    final ITexture mainFontTexture = new BitmapTextureAtlas(this.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

	    Font font = FontFactory.createFromAsset(this.getFontManager(), mainFontTexture, this.getAssets(), "BUENAN__.ttf", 50, true, 2);
	    font.load();
	    
	    gameResources.add(Font.class, font);
	}


	/**
	 * Sobreescrevo esse método para ter certeza
	 */
	public Engine onCreateEngine(EngineOptions pEngineOptions) {
		Log.i(TAG, "onCreateEngine()");
		
		Engine engine = new LimitedFPSEngine(pEngineOptions, MAX_FPS);
		
		gameResources.add(Engine.class, engine);
		
		return engine;
	}
	
	
	@Override
	protected Scene onCreateScene() {
		Log.i(TAG, "onCreateScene()");

		Scene scene = new SplashScreenScene(this);
		
		return scene;
	}

}
