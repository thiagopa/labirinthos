package br.com.thiagopagonha.labirinthos.factory;

import java.util.HashMap;
import java.util.Map;

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
	
	

}
