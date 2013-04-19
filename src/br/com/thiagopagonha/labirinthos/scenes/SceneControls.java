package br.com.thiagopagonha.labirinthos.scenes;

import org.andengine.entity.scene.Scene;

import br.com.thiagopagonha.labirinthos.MainActivity;

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
	
	private MainActivity mainActivity; 
	
	protected SceneControls(MainActivity mainActivity) {
		
		this.mainActivity = mainActivity;
		
		create();
	}
	
	protected MainActivity getMainActivity() {
		return this.mainActivity;
	}
	
}
