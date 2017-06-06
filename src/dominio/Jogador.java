package dominio;

/**
 * Classe que representa o próprio usuário do jogo. O jogador tenta acertar a combinação correta 
 * que compõe a senha.
 * 
 * Essa classe Implementa a interface IJogador
 */
public class Jogador implements IJogador
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
	@Override
	public Jogada fazerJogada(Combinacao jogada)
	{
		// TODO Auto-generated method stub
		return new Jogada();
	}
}
