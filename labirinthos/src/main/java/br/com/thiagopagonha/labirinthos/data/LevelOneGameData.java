package br.com.thiagopagonha.labirinthos.data;

/**
 * LevelOne Game Data
 * @author Thiago Pagoha
 *
 */
public class LevelOneGameData implements LevelData {

	public String levelName() {
		return "Testes";
	}

	/**
	 * Desenho da fase:
	 * 
	 *    T
	 *   WHW - "Trap Ahead"
	 *   W|WWWWWW
	 *   WC---P-|W
	 *    W|WWWW|W
	 *    W|W  W|W
	 *     E    S
	 */
	public int[][][] levelData() {
		return new int[][][] {
			{ 
				{},{TRAP}
			},
			{
				{WALL},{HINT},{WALL}
			},
			{
				{WALL},{PATH},{WALL},{WALL},{WALL},{WALL},{WALL},{WALL}
			},
			{
				{WALL},{KEY},{PATH},{PATH},{PATH},{DOOR},{PATH},{PATH},{WALL}
			},
			{
				{},{WALL},{PATH},{WALL},{WALL},{WALL},{WALL},{PATH},{WALL}
			},
			{
				{},{WALL},{PATH},{WALL},{},{},{WALL},{PATH},{WALL}
			},
			{
				{},{WALL},{START},{WALL},{},{},{},{END}
			},
			{
				{},{},{WALL}
			}

		};
	}

	public String getHint(int x, int y) {
		return "Trap Ahead!!!";
	}

}
