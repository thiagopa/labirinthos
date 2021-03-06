package br.com.thiagopagonha.labirinthos.scenes;

import static br.com.thiagopagonha.labirinthos.utils.Constants.CAMERA_HEIGHT;
import static br.com.thiagopagonha.labirinthos.utils.Constants.CAMERA_WIDTH;
import static br.com.thiagopagonha.labirinthos.utils.Constants.FONT_SIZE;

import org.andengine.engine.Engine;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.text.Text;
import org.andengine.util.HorizontalAlign;

import br.com.thiagopagonha.labirinthos.factory.GameResourcesFactory;
import br.com.thiagopagonha.labirinthos.factory.ItemFactory;

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
		// -- Cria textos da Tela
		Text gameTitle = get(ItemFactory.class).createText(CAMERA_WIDTH / 2, CAMERA_HEIGHT / 2,"Labirinthos");
		Text authorName = get(ItemFactory.class).createText(0,CAMERA_HEIGHT - FONT_SIZE * 2,"por Thiago Pagonha");
		
		authorName.setHorizontalAlign(HorizontalAlign.RIGHT);
		
		attachChild(gameTitle);
		attachChild(authorName);
		
		// -- Cria um timer para a splash por 3 segundos
		
		final Engine engine = get(Engine.class);
		
		engine.registerUpdateHandler(new TimerHandler(3f, new ITimerCallback() 
		{
		    public void onTimePassed(final TimerHandler pTimerHandler) 
		    {
		        engine.unregisterUpdateHandler(pTimerHandler);
		        changeScene(MenuScene.class);
		    }
		}));

		
	}

}
