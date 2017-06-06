package dominio;

import Utils.Pino;

/**
 * Classe abstrata que é usada como base para Retorno, Senha e Jogada.
 * Aqui são implementados todos os métodos comum as três classes e a assinatura do método isValida
 * que é diferente em cada uma das combinações.
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
	 * Vetor de Pinos que representa a combinação de cores usada pelas classes filhas.
	 */
	protected Pino[] pinos;

	/**
	 * Construtor padrão onde é inicializado o vetor de pinos com o tamanho definido pela constante.
	 */
	public Combinacao()
	{
		this.pinos = new Pino[tamanhoMaximo];
	}

	/**
	 * Construtor personalizado onde além de ser inicializado o vetor de pinos com tamanho definido
	 * pela constante são setados 4 pinos passados como paramentros.
	 * @param p1
	 * 		Pino que será adicionado na primeira posição (0) do vetor
	 * @param p2
	 * 		Pino que será adicionado na segunda posição (1) do vetor
	 * @param p3
	 * 		Pino que será adicionado na terceira posição (2) do vetor
	 * @param p4
	 * 		Pino que será adicionado na quarta posição (3) do vetor
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
	 * Assinatura do método a ser implementado nas classes filhas.
	 * @return Boolean
	 * 		True se os pinos presentes no vetor de pinos são válidos pra o presente tipo.
	 * 		False se os pinos presentes no vetor de pinos são inválidos pra o presente tipo.
	 */
	public abstract boolean isValida();
	
	/**
	 * Método que informa se um determinado pino passado como parametro está presente no vetor de pinos.
	 * @param pino
	 * 		Pino a ser buscado no vetor de pinos.
	 * @return
	 * 		True se o pino passado como parametro está presente no vetor de pinos.
	 * 		False se o pino passado como paramentro está ausente no vetor de pinos.
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
	 * Reescrita do método equals para melhorar a leitura do código onde um objeto será igual ao outro se
	 * não forem nulos, forem da mesma classe e seus dois vetores de pinos forem extritamente iguais.
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
	 * Método para limpar o vetor de pinos caso desejado.
	 */
	public void clear()
	{
		this.pinos = new Pino[tamanhoMaximo];
	}

	/**
	 * Método para adicionar um novo pino ao vetor de pinos se este ainda não estiver cheio
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
	 * Método que retorna o vetor de pinos.
	 * @return
	 * 		Pino[] o vetor de pinos.
	 */
	public Pino[] getPinos()
	{
		return this.pinos;
	}
	
	/**
	 * Método que retorna o pino dado uma posição se esta for válida.
	 * @param index
	 * 		Inteiro que indica a posição a qual deseja-se o pino.
	 * @return
	 * 		Pino caso a posição seja válida.
	 * 		null caso a posição seja inválida.
	 */
	public Pino getPinoAtIndex(int index)
	{
		if (index < tamanhoAtual)
		{
			return pinos[index];
		}
		//corrigir por lançar exception
		return null;
	}
	
	/**
	 * Método que retorna a quantidade atual de pinos no vetor de pinos.
	 * @return
	 * 		Inteiro correspondente a quantidade de pinos atual no vetor.
	 */
	public int getTamanhoAtual()
	{
		return tamanhoAtual;
	}
}
