package br.com.thiagopagonha.labirinthos.utils;

import java.util.HashMap;
import java.util.Map;

import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.TextMenuItem;
import org.andengine.entity.text.Text;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Usado para gerenciar o acesso à todos os recursos do jogo
 * Só é permitido um tipo de objeto por vez e abstrai a criação de algum deles 
 * 
 * @author Thiago Pagonha
 * @version Abr/2013
 *
 */
public class GameResourcesFactory {

	private Map<Class, Object> repository = new HashMap<Class, Object>();
	
	public <T> void add(Class<T> clazz, T obj) {
		this.repository.put(clazz, obj);
	}

	public <T> T get(Class<T> clazz) {
		return (T) this.repository.get(clazz);
	}

	/**
	 * Cria um texto nas coordenadas
	 * @param pX
	 * @param pY
	 * @param string
	 * @return
	 */
	public Text createText(float pX, float pY, String string) {
		return new Text(pX, pY, get(Font.class), string , get(VertexBufferObjectManager.class));
	}
	
	/**
	 * Cria um item de botão
	 * @param pID
	 * @param text
	 * @return
	 */
	public IMenuItem createTextMenuItem(int pID, String text) {
		return new TextMenuItem(pID,get(Font.class),text, get(VertexBufferObjectManager.class));
	}
}
