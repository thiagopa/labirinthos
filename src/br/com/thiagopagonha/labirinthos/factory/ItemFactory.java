package br.com.thiagopagonha.labirinthos.factory;

import org.andengine.entity.Entity;
import org.andengine.entity.primitive.Line;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.TextMenuItem;
import org.andengine.entity.text.Text;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.color.Color;

import android.util.Log;

/**
 * Fábrica de Itens comuns e utilitários
 * @author Thiago Pagonha
 * @version Mai/2013
 *
 */
public class ItemFactory {

	private static final String TAG = "ItemFactory";
	
	private Font font;
	private VertexBufferObjectManager vertexBufferObjectManager;
	
	public ItemFactory(Font font, VertexBufferObjectManager vertexBufferObjectManager) {
		this.font = font;
		this.vertexBufferObjectManager = vertexBufferObjectManager;
	}
	
	/**
	 * Cria um texto nas coordenadas
	 * @param pX
	 * @param pY
	 * @param string
	 * @return
	 */
	public Text createText(float pX, float pY, String string) {
		Log.d(TAG, "createText()");
		return new Text(pX, pY, font, string , vertexBufferObjectManager);
	}
	
	/**
	 * Cria um retângulo apenas com bordas e a cor específica
	 * @param pX, horizontal começo
	 * @param pY, vertical começo
	 * @param pWidth, a largura
	 * @param pHeight, a altura
	 * @param pColor, a cor
	 * @return <Entity>
	 */
	public Entity createRectangle(float pX, float pY, float pWidth, float pHeight, Color pColor) {
		Log.d(TAG, "createRectangle()");
		//return new Rectangle(pX, pY, pWidth, pHeight, get(VertexBufferObjectManager.class));
		Entity rectangleScreen = new Entity(0, 0);
		
		Line topLine = new Line(pX, pY, pX + pWidth, pY, vertexBufferObjectManager);
		topLine.setColor(pColor);
		
		Line bottomLine = new Line(pX, pY + pHeight , pX +pWidth , pY + pHeight, vertexBufferObjectManager);
		bottomLine.setColor(pColor);

		Line leftLine = new Line(pX, pY, pX, pY + pHeight, vertexBufferObjectManager);
		leftLine.setColor(pColor);

		Line rightLine = new Line(pX + pWidth, pY, pX + pWidth, pY + pHeight, vertexBufferObjectManager);
		rightLine.setColor(pColor);
		
		rectangleScreen.attachChild(topLine);
		rectangleScreen.attachChild(bottomLine);
		rectangleScreen.attachChild(leftLine);
		rectangleScreen.attachChild(rightLine);
		
		return rectangleScreen;
	}
	
	/**
	 * Usado para marcar a ação do clique do botão 
	 */
	public interface ITouchArea {
		boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY);
	}
	
	/**
	 * Cria um item de botão com determina ação
	 * @param pID
	 * @param text
	 * @param onTouch
	 * @return
	 */
	public IMenuItem createTextMenuItem(int pID, String text, final ITouchArea onTouch) {
		Log.d(TAG, "createTextMenuItem()");
		return new TextMenuItem(pID,font,text, vertexBufferObjectManager) {
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float pTouchAreaLocalX, float pTouchAreaLocalY) {
				return onTouch.onAreaTouched(pSceneTouchEvent, pTouchAreaLocalX, pTouchAreaLocalY);
			}
		};
	}

	
}
