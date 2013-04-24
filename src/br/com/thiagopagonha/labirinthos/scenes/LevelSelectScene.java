package br.com.thiagopagonha.labirinthos.scenes;

import static br.com.thiagopagonha.labirinthos.utils.Constants.CAMERA_HEIGHT;
import static br.com.thiagopagonha.labirinthos.utils.Constants.CAMERA_WIDTH;

import org.andengine.entity.text.Text;

import br.com.thiagopagonha.labirinthos.utils.GameResourcesFactory;

/**
 * Cena que cuida da seleção das fases
 * @author Thiago Pagonha
 * @version Abr/2013
 *
 */
public class LevelSelectScene extends SceneControls {

	protected LevelSelectScene(GameResourcesFactory gameResourcesFactory) {
		super(gameResourcesFactory);
	}

	@Override
	protected void create() {
		Text gameTitle = getGameResourcesFactory().createText(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2,"Level Select Scene");
		attachChild(gameTitle);
	}

}
