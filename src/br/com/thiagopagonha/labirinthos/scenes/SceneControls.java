package br.com.thiagopagonha.labirinthos.scenes;

import org.andengine.engine.Engine;
import org.andengine.entity.scene.Scene;

import android.util.Log;
import br.com.thiagopagonha.labirinthos.utils.GameResourcesFactory;

/**
 * Controles relativos às cenas
 * @author Thiago Pagonha
 * @version Abr/2013
 *
 */
public abstract class SceneControls extends Scene {

	public static final String TAG = "SceneControls";
	
	/**
	 * Ação relativa à criação da cena
	 */
	protected abstract void create();
	
	private GameResourcesFactory gameResourcesFactory; 
	
	protected SceneControls(GameResourcesFactory gameResourcesFactory) {
		
		this.gameResourcesFactory = gameResourcesFactory;
		
		create();
	}
	
	protected GameResourcesFactory getGameResourcesFactory() {
		return gameResourcesFactory;
	}
	
	/**
	 * Ação relativa ao processamento da cena
	 */
	protected void changeScene(Class<? extends SceneControls> newScene) {
		
		try {
			SceneControls newSceneControls = newScene.getDeclaredConstructor(GameResourcesFactory.class).newInstance(gameResourcesFactory);
			Engine engine = gameResourcesFactory.get(Engine.class);
			
			this.dispose();
			
			engine.setScene(newSceneControls);
		} catch (Exception e) {
			Log.e(TAG, "Pego a exceção =" + e.getMessage() + " , matando a aplicação agora!");
			System.exit(-1);
		}
	}
	
	
}
