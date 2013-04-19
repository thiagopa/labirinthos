package br.com.thiagopagonha.labirinthos.scenes;

import org.andengine.entity.scene.Scene;

import br.com.thiagopagonha.labirinthos.utils.GameResourcesFactory;

/**
 * Controles relativos às cenas
 * @author Thiago Pagonha
 * @version Abr/2013
 *
 */
public abstract class SceneControls extends Scene {

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
	
}
