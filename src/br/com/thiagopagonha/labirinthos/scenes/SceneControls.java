package br.com.thiagopagonha.labirinthos.scenes;

import org.andengine.engine.Engine;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.util.color.Color;

import android.util.Log;
import br.com.thiagopagonha.labirinthos.utils.GameResourcesFactory;

/**
 * Controles relativos às cenas
 * @author Thiago Pagonha
 * @version Abr/2013
 *
 */
public abstract class SceneControls extends Scene {

	private static final String TAG = "SceneControls";
	
	/**
	 * Ação relativa à criação da cena
	 */
	protected abstract void create();
	
	private GameResourcesFactory gameResourcesFactory; 
	
	protected SceneControls(GameResourcesFactory gameResourcesFactory) {
		
		this.gameResourcesFactory = gameResourcesFactory;
		// -- Limpa a tela de fundo
		setBackground(new Background(Color.WHITE));
		// -- Cria os objetos referentes à cena
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
			// -- Criando a nova cena com o gamesResourceFactory => new SceneControls(gameResourcesFactory);
			SceneControls newSceneControls = newScene.getDeclaredConstructor(GameResourcesFactory.class).newInstance(gameResourcesFactory);
			Engine engine = gameResourcesFactory.get(Engine.class);
			
			// -- Remove toda a sujeira da cena
			detachChildren();
			clearEntityModifiers();
			clearTouchAreas();
			clearUpdateHandlers();
			detachSelf();
			
			// -- Troca a cena pela engine
			engine.setScene(newSceneControls);
		} catch (Exception e) {
			Log.e(TAG, "Pego a exceção =" + e.getMessage() + " , matando a aplicação agora!");
			System.exit(-1);
		}
	}
}
