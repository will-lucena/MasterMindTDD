package dominio;

/**
 * Interface que determina os métodos do jogador.
 */

public interface IJogador
{
	/**
	 * Método usado para fazer a jogada do jogador, onde o mesmo escolherá 4 cores para compor sua jogada.
	 * 
	 * @param jogada
	 * 		é a tentativa completa(com 4 pinos) que o jogador fez para
	 * 		tentar acertar a senha.
	 * @return Jogada
	 * 		é a jogada resultante da combinação passada como parâmetro	
	 */
	public Jogada fazerJogada(Combinacao jogada);
}
