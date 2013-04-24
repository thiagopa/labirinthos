package br.com.thiagopagonha.labirinthos.scenes;

import static br.com.thiagopagonha.labirinthos.utils.Constants.CAMERA_HEIGHT;
import static br.com.thiagopagonha.labirinthos.utils.Constants.CAMERA_WIDTH;

import org.andengine.entity.scene.IOnSceneTouchListener;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.color.Color;

import br.com.thiagopagonha.labirinthos.utils.GameResourcesFactory;

/**
 * Menu de seleção do jogo
 * 
 * @author Thiago Pagonha
 * @version Abr/2013
 * 
 */
public class MenuScene extends SceneControls implements IOnSceneTouchListener {

	protected MenuScene(GameResourcesFactory gameResourcesFactory) {
		super(gameResourcesFactory);
	}

	protected void create() {
		setBackground(new Background(Color.WHITE));

		IMenuItem playMenuItem = getGameResourcesFactory().createTextMenuItem(0, "Jogar");

		playMenuItem.setPosition(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2);

		attachChild(playMenuItem);

		setOnSceneTouchListener(this);
	}

	@Override
	public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
		// TODO Auto-generated method stub
		return false;
	}

}
