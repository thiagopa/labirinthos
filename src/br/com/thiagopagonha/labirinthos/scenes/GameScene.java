package br.com.thiagopagonha.labirinthos.scenes;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.Entity;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.color.Color;

import br.com.thiagopagonha.labirinthos.data.LevelData;
import br.com.thiagopagonha.labirinthos.factory.GameResourcesFactory;
import br.com.thiagopagonha.labirinthos.factory.ItemFactory;

/**
 * Cena principal e implementação do jogo
 * @author Thiago Pagonha
 * @version Abr/2013
 */
public class GameScene extends SceneControls {

	private LevelData levelData;
	private HUD gameHUD;
	
	GameScene(GameResourcesFactory gameResourcesFactory) {
		super(gameResourcesFactory);
	}

	/**
	 * Implementação da tela de acordo com 
	 * 
	 * ===== Title =====
	 *         ^
	 * <                >
	 *         v
	 *        HUD
	 */
	protected void create() {
		// -- Inicializando os dados do jogo
		levelData = get(LevelData.class);
		
		// -- Inicializa o Heads Up Display
		createHUD();
		
	}

	private void createHUD() {
		gameHUD = new HUD();

		// -- Título da fase
		Text levelTitle = get(ItemFactory.class).createText(0, 0, levelData.levelName());
		levelTitle.setColor(Color.RED);
		gameHUD.attachChild(levelTitle);
		
		// -- Botões da tela
		IMenuItem leftButton = get(ItemFactory.class).createTextMenuItem(0, "<", new ControlNavigation());
		
		registerTouchArea(leftButton);
		leftButton.setPosition(170, 220);
		attachChild(leftButton);

		IMenuItem rightButton = get(ItemFactory.class).createTextMenuItem(0, ">", new ControlNavigation());
		
		registerTouchArea(rightButton);
		rightButton.setPosition(610, 220);
		attachChild(rightButton);

		IMenuItem bottomButton = get(ItemFactory.class).createTextMenuItem(0, "^", new ControlNavigation());
		
		registerTouchArea(bottomButton);
		bottomButton.setPosition(380, 380);
		attachChild(bottomButton);

		IMenuItem topButton = get(ItemFactory.class).createTextMenuItem(0, "v", new ControlNavigation());
		
		registerTouchArea(topButton);
		topButton.setPosition(380, 50);
		attachChild(topButton);
		
		// -- Retângulo da tela
		Entity rectangleScreen = get(ItemFactory.class).createRectangle(200, 100 , 400, 250, 4, Color.BLACK);
		gameHUD.attachChild(rectangleScreen);
		
		// -- Gruda o HUD à Câmera
		Camera camera = get(Camera.class);
		camera.setHUD(gameHUD);
	}
	
	/**
	 * Controle da cena 
	 *
	 */
	class ControlNavigation implements ItemFactory.ITouchArea {
		public boolean onAreaTouched(TouchEvent pSceneTouchEvent,float pTouchAreaLocalX, float pTouchAreaLocalY) {
			return false;
		}
	}
	
}
