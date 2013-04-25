package br.com.thiagopagonha.labirinthos.scenes;

import br.com.thiagopagonha.labirinthos.data.LevelData;
import br.com.thiagopagonha.labirinthos.utils.GameResourcesFactory;

/**
 * Cena principal e implementação do jogo
 * @author Thiago Pagonha
 * @version Abr/2013
 */
public class GameScene extends SceneControls {

	private LevelData gameData;
	
	protected GameScene(GameResourcesFactory gameResourcesFactory, LevelData gameData) {
		super(gameResourcesFactory);
		this.gameData = gameData;
	}

	@Override
	protected void create() {
		// TODO Auto-generated method stub
		
	}
	
}
