package br.com.thiagopagonha.labirinthos.scenes;

import static br.com.thiagopagonha.labirinthos.utils.Constants.CAMERA_HEIGHT;
import static br.com.thiagopagonha.labirinthos.utils.Constants.CAMERA_WIDTH;

import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.input.touch.TouchEvent;

import android.util.Log;
import br.com.thiagopagonha.labirinthos.utils.GameResourcesFactory;

/**
 * Menu de seleção do jogo
 * 
 * @author Thiago Pagonha
 * @version Abr/2013
 * 
 */
public class MenuScene extends SceneControls {

	public static final String TAG = "MenuScene";
	
	protected MenuScene(GameResourcesFactory gameResourcesFactory) {
		super(gameResourcesFactory);
	}

	protected void create() {
		// -- Cria o botão do menu e associa uma ação a ele
		IMenuItem playMenuItem = getGameResourcesFactory().createTextMenuItem(0, "Jogar", new GameResourcesFactory.ITouchArea() {
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent,float pTouchAreaLocalX, float pTouchAreaLocalY) {
				Log.i(TAG,"Touch Coordinates x=" + pSceneTouchEvent.getX() + " y=" + pSceneTouchEvent.getY() + " and isActionUP = " + pSceneTouchEvent.isActionUp());
				// -- Muda a cena para outra só se o usuário tirar o dedo da tela!!! 
				if(pSceneTouchEvent.isActionUp()) {
					changeScene(LevelSelectScene.class);
					return true;
				}
				
				return false;
			}
		}); 
		// -- registra o toque do botão na cena
		registerTouchArea(playMenuItem);
		// -- Coloca o botão na posição
		playMenuItem.setPosition(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2);
		// -- Insere o botão na cena
		attachChild(playMenuItem);

	}
}
