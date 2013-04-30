package br.com.thiagopagonha.labirinthos.scenes;

import static br.com.thiagopagonha.labirinthos.utils.Constants.CAMERA_HEIGHT;
import static br.com.thiagopagonha.labirinthos.utils.Constants.CAMERA_WIDTH;

import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.input.touch.TouchEvent;

import android.util.Log;
import br.com.thiagopagonha.labirinthos.data.LevelData;
import br.com.thiagopagonha.labirinthos.data.LevelOneGameData;
import br.com.thiagopagonha.labirinthos.utils.GameResourcesFactory;

/**
 * Cena que cuida da seleção das fases
 * 
 * @author Thiago Pagonha
 * @version Abr/2013
 * 
 */
public class LevelSelectScene extends SceneControls {

	private static final String TAG = "LevelSelectScene";
	
	LevelSelectScene(GameResourcesFactory gameResourcesFactory) {
		super(gameResourcesFactory);
	}

	@Override
	protected void create() {
		// -- Cria o botão do menu e associa uma ação a ele
		IMenuItem levelOne = getGameResourcesFactory().createTextMenuItem(0, "Level One", new GameSceneButton(new LevelOneGameData())); 
		// -- registra o toque do botão na cena
		registerTouchArea(levelOne);
		// -- Coloca o botão na posição
		levelOne.setPosition(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2);
		// -- Insere o botão na cena
		attachChild(levelOne);
	}
	
	class GameSceneButton implements GameResourcesFactory.ITouchArea {
		
		private LevelData gameData;
		
		GameSceneButton(LevelData gameData) {
			this.gameData = gameData;
		}
		
		public boolean onAreaTouched(TouchEvent pSceneTouchEvent,float pTouchAreaLocalX, float pTouchAreaLocalY) {
			Log.i(TAG,"Touch Coordinates x=" + pSceneTouchEvent.getX() + " y=" + pSceneTouchEvent.getY() + " and isActionUP = " + pSceneTouchEvent.isActionUp());
			// -- Muda a cena para outra só se o usuário tirar o dedo da tela!!! 
			if(pSceneTouchEvent.isActionUp()) {
				getGameResourcesFactory().add(LevelData.class, gameData);
				changeScene(GameScene.class);
				return true;
			}
			
			return false;
		}
	}

}
