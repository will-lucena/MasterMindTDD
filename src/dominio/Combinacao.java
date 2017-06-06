package dominio;

import Utils.Pino;

/**
 * Classe abstrata que � usada como base para Retorno, Senha e Jogada.
 * Aqui s�o implementados todos os m�todos comum as tr�s classes e a assinatura do m�todo isValida
 * que � diferente em cada uma das combina��es.
 */
public abstract class Combinacao
{
	/**
	 * Constante que define o tamanho do vetor de Pinos.
	 */
	public static final int tamanhoMaximo = 4;
	/**
	 * Inteiro que representa a quantidade atual de pinos no vetor de pinos.
	 */
	protected int tamanhoAtual = 0;
	/**
	 * Vetor de Pinos que representa a combina��o de cores usada pelas classes filhas.
	 */
	protected Pino[] pinos;

	/**
	 * Construtor padr�o onde � inicializado o vetor de pinos com o tamanho definido pela constante.
	 */
	public Combinacao()
	{
		this.pinos = new Pino[tamanhoMaximo];
	}

	/**
	 * Construtor personalizado onde al�m de ser inicializado o vetor de pinos com tamanho definido
	 * pela constante s�o setados 4 pinos passados como paramentros.
	 * @param p1
	 * 		Pino que ser� adicionado na primeira posi��o (0) do vetor
	 * @param p2
	 * 		Pino que ser� adicionado na segunda posi��o (1) do vetor
	 * @param p3
	 * 		Pino que ser� adicionado na terceira posi��o (2) do vetor
	 * @param p4
	 * 		Pino que ser� adicionado na quarta posi��o (3) do vetor
	 */
	public Combinacao(Pino p1, Pino p2, Pino p3, Pino p4)
	{
		this.pinos = new Pino[tamanhoMaximo];
		addPino(p1);
		addPino(p2);
		addPino(p3);
		addPino(p4);
	}

	/**
	 * Assinatura do m�todo a ser implementado nas classes filhas.
	 * @return Boolean
	 * 		True se os pinos presentes no vetor de pinos s�o v�lidos pra o presente tipo.
	 * 		False se os pinos presentes no vetor de pinos s�o inv�lidos pra o presente tipo.
	 */
	public abstract boolean isValida();
	
	/**
	 * M�todo que informa se um determinado pino passado como parametro est� presente no vetor de pinos.
	 * @param pino
	 * 		Pino a ser buscado no vetor de pinos.
	 * @return
	 * 		True se o pino passado como parametro est� presente no vetor de pinos.
	 * 		False se o pino passado como paramentro est� ausente no vetor de pinos.
	 */
	public boolean contains(Pino pino)
	{
		for (int i = 0; i < this.tamanhoAtual; i++)
		{
			if (this.pinos[i].equals(pino))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Reescrita do m�todo equals para melhorar a leitura do c�digo onde um objeto ser� igual ao outro se
	 * n�o forem nulos, forem da mesma classe e seus dois vetores de pinos forem extritamente iguais.
	 * @return 
	 * 		True se os objetos forem iguais.
	 * 		False se os objetos forem diferentes.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (!obj.getClass().equals(this.getClass()))
		{
			return false;
		}
		Combinacao other = (Combinacao) obj;

		for (int i = 0; i < 4; i++)
		{
			if (!this.pinos[i].equals(other.pinos[i]))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * M�todo para limpar o vetor de pinos caso desejado.
	 */
	public void clear()
	{
		this.pinos = new Pino[tamanhoMaximo];
	}

	/**
	 * M�todo para adicionar um novo pino ao vetor de pinos se este ainda n�o estiver cheio
	 * @param pino
	 * 		Pino que deseja-se inserir no vetor de pinos
	 */
	public void addPino(Pino pino)
	{
		if (this.tamanhoAtual < tamanhoMaximo)
		{
			this.pinos[tamanhoAtual] = pino;
			this.tamanhoAtual++;
		}
	}
	
	/**
	 * M�todo que retorna o vetor de pinos.
	 * @return
	 * 		Pino[] o vetor de pinos.
	 */
	public Pino[] getPinos()
	{
		return this.pinos;
	}
	
	/**
	 * M�todo que retorna o pino dado uma posi��o se esta for v�lida.
	 * @param index
	 * 		Inteiro que indica a posi��o a qual deseja-se o pino.
	 * @return
	 * 		Pino caso a posi��o seja v�lida.
	 * 		null caso a posi��o seja inv�lida.
	 */
	public Pino getPinoAtIndex(int index)
	{
		if (index < tamanhoAtual)
		{
			return pinos[index];
		}
		//corrigir por lan�ar exception
		return null;
	}
	
	/**
	 * M�todo que retorna a quantidade atual de pinos no vetor de pinos.
	 * @return
	 * 		Inteiro correspondente a quantidade de pinos atual no vetor.
	 */
	public int getTamanhoAtual()
	{
		return tamanhoAtual;
	}
}
