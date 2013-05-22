package br.com.thiagopagonha.labirinthos.scenes;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.Entity;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.color.Color;

import android.util.Log;
import br.com.thiagopagonha.labirinthos.data.LevelData;
import br.com.thiagopagonha.labirinthos.factory.GameResourcesFactory;
import br.com.thiagopagonha.labirinthos.factory.ItemFactory;
import br.com.thiagopagonha.labirinthos.navigation.Navigation;

/**
 * Cena principal e implementação do jogo
 * @author Thiago Pagonha
 * @version Abr/2013
 */
public class GameScene extends SceneControls {

	private static final String TAG = "GameScene";

	private Navigation navigation;
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
		
		// -- Procura e cria a cena inicial
		initScene();
		
	}

	private void initScene() {
		
		
	}

	private void createHUD() {
		Log.i(TAG, "createHUD()");
		gameHUD = new HUD();

		// -- Título da fase
		Text levelTitle = get(ItemFactory.class).createText(0, 0, levelData.levelName());
		levelTitle.setColor(Color.RED);
		gameHUD.attachChild(levelTitle);
		
		// -- Botões da tela
		IMenuItem leftButton = get(ItemFactory.class).createTextMenuItem(0, "<", new ControlNavigation());
		leftButton.setPosition(150, 220);
		attachToHud(leftButton);
		
		IMenuItem rightButton = get(ItemFactory.class).createTextMenuItem(1, ">", new ControlNavigation());
		rightButton.setPosition(630, 220);
		attachToHud(rightButton);

		IMenuItem bottomButton = get(ItemFactory.class).createTextMenuItem(2, "v", new ControlNavigation());
		bottomButton.setPosition(380, 390);
		bottomButton.setRotation(180);
		attachToHud(bottomButton);
		
		IMenuItem topButton = get(ItemFactory.class).createTextMenuItem(3, "v", new ControlNavigation());
		topButton.setPosition(380, 30);
		attachToHud(topButton);
		
		// -- Retângulo da tela
		Entity rectangleScreen = get(ItemFactory.class).createRectangle(200, 100 , 400, 250, 4, Color.BLACK);
		gameHUD.attachChild(rectangleScreen);
		
		// -- Gruda o HUD à Câmera
		Camera camera = get(Camera.class);
		camera.setHUD(gameHUD);
	}

	private void attachToHud(IMenuItem iMenuItem) {
		iMenuItem.setScale(2, 2);
		
		gameHUD.registerTouchArea(iMenuItem);
		gameHUD.attachChild(iMenuItem);
	}
	
	
	/**
	 * Controle da cena 
	 *
	 */
	class ControlNavigation implements ItemFactory.ITouchArea {
		public boolean onAreaTouched(TouchEvent pSceneTouchEvent,float pTouchAreaLocalX, float pTouchAreaLocalY) {
			
			Log.i(TAG, "Touched Coordenates X=" + pTouchAreaLocalX + " Y=" + pTouchAreaLocalY);
			
			return false;
		}
	}
	
}
