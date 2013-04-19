package br.com.thiagopagonha.labirinthos.scenes;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.util.color.Color;

import br.com.thiagopagonha.labirinthos.utils.GameResourcesFactory;

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
		Text gameTitle = getGameResourcesFactory().createText(400,240,"Labirinthos");
		Text authorName = getGameResourcesFactory().createText(600,420,"por Thiago Pagonha");
		
		attachChild(gameTitle);
		attachChild(authorName);
	}

}
