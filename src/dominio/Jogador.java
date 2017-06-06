package dominio;

/**
 * Classe que representa o pr�prio usu�rio do jogo. O jogador tenta acertar a combina��o correta 
 * que comp�e a senha.
 * 
 * Essa classe Implementa a interface IJogador
 */
public class Jogador implements IJogador
{
	/**
	 * M�todo usado para fazer a jogada do jogador, onde o mesmo escolher� 4 cores para compor sua jogada.
	 * 
	 * @param jogada
	 * 		� a tentativa completa(com 4 pinos) que o jogador fez para
	 * 		tentar acertar a senha.
	 * @return Jogada
	 * 		� a jogada resultante da combina��o passada como par�metro	
	 */
	@Override
	public Jogada fazerJogada(Combinacao jogada)
	{
		// TODO Auto-generated method stub
		return new Jogada();
	}
}
