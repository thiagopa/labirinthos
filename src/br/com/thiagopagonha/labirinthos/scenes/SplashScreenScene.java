package br.com.thiagopagonha.labirinthos.scenes;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;

import br.com.thiagopagonha.labirinthos.utils.GameResourcesFactory;

import static br.com.thiagopagonha.labirinthos.utils.Constants.*;

/**
 * Tela principal que aparecerá quando o jogo for iniciado
 * 
 * @author Thiago Pagonha
 * @version Abr/2013
 * 
 */
public class SplashScreenScene extends SceneControls {

	public SplashScreenScene(GameResourcesFactory gameResourcesFactory) {
		super(gameResourcesFactory);
	}

	public void create() {
		setBackground(new Background(Color.WHITE));
		
		// -- Cria textos da Tela
		Text gameTitle = getGameResourcesFactory().createText(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2,"Labirinthos");
		Text authorName = getGameResourcesFactory().createText(CAMERA_WIDTH - (CAMERA_WIDTH/3),CAMERA_HEIGHT - FONT_SIZE * 2,"por Thiago Pagonha");
		
		authorName.setHorizontalAlign(HorizontalAlign.RIGHT);
		
		attachChild(gameTitle);
		attachChild(authorName);
	}

}
