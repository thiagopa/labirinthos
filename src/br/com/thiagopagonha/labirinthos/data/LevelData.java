package br.com.thiagopagonha.labirinthos.data;

/**
 * Dados do jogo
 * 
 * @author Thiago Pagonha
 * @version Abr/2013
 */
public interface LevelData {

	/**
	 * Nome da fase
	 * @return o nome da fase
	 */
	String levelName();
	
	/**
	 * O mapa da fase com y,x e o objeto
	 * 
	 * Primeiro vem a linha
	 * Depois vem a coluna
	 * E por último a informação
	 * 
	 * @return mapa
	 */
	int[][][] levelData();
	
	/**
	 * A partir da posição, retorna a dica
	 * @param x
	 * @param y
	 * @return
	 */
	String getHint(int x, int y);
	
	// -- Possible objects
	int PATH = 0;
	int WALL = 1;
	int DOOR = 2;
	int KEY = 3;
	int HINT = 4;
	
	// -- Control objects
	int START = 11;
	int END = 22;
	int TRAP = 66;
	
}
