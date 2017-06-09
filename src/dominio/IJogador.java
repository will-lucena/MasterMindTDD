package dominio;

/**
 * Interface que determina os m�todos do jogador.
 */

public interface IJogador
{
	/**
	 * M�todo usado para fazer a jogada do jogador, onde o mesmo escolher� 4 cores para compor sua jogada.
	 * 
	 * @return Jogada
	 * 		� a jogada resultante da combina��o passada como par�metro	
	 */
	public Jogada fazerJogada(String[] cores);
}
