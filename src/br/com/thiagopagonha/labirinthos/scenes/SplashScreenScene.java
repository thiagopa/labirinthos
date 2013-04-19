package br.com.thiagopagonha.labirinthos.scenes;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import org.andengine.util.color.Color;

import br.com.thiagopagonha.labirinthos.MainActivity;

/**
 * Tela principal que aparecerá quando o jogo for iniciado
 * 
 * @author Thiago Pagonha
 * @version Abr/2013
 * 
 */
public class SplashScreenScene extends SceneControls {

	public SplashScreenScene(MainActivity mainActivity) {
		super(mainActivity);
	}

	public void create() {
		setBackground(new Background(Color.WHITE));
		attachChild(new Text(400, 240, getMainActivity().getGameResources()
				.get(Font.class), "Loading...", getMainActivity()
				.getVertexBufferObjectManager()));
	}

}
