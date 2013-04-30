package br.com.thiagopagonha.labirinthos.scenes;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.text.Text;
import org.andengine.util.color.Color;

import br.com.thiagopagonha.labirinthos.data.LevelData;
import br.com.thiagopagonha.labirinthos.utils.GameResourcesFactory;

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
		levelData = getGameResourcesFactory().get(LevelData.class);
		
		// -- Inicializa o Heads Up Display
		createHUD();
		
	}

	private void createHUD() {
		gameHUD = new HUD();

		// -- Título da fase
		Text levelTitle = getGameResourcesFactory().createText(0, 0, levelData.levelName());
		levelTitle.setColor(Color.RED);
		gameHUD.attachChild(levelTitle);
		
		// -- Retângulo da tela
		Rectangle screen = getGameResourcesFactory().createRectangle(240, 240 , 100, 100);
		screen.setColor(Color.BLUE);
		gameHUD.attachChild(screen);
		
		// -- Gruda o HUD à Câmera
		Camera camera = getGameResourcesFactory().get(Camera.class);
		camera.setHUD(gameHUD);
	}
	
}
