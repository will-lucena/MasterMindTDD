package dominio;

import Utils.Cores;

public class Combinacao
{
	public static final int tamanhoMaximo = 4;
	private int tamanhoAtual = 0;
	private Cores[] combinacao;

	public Combinacao()
	{
		this.combinacao = new Cores[tamanhoMaximo];
	}

	public Combinacao(Cores cor1, Cores cor2, Cores cor3, Cores cor4)
	{
		this.combinacao = new Cores[tamanhoMaximo];
		addCor(cor1);
		addCor(cor2);
		addCor(cor3);
		addCor(cor4);
	}

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
			if (!this.combinacao[i].equals(other.combinacao[i]))
			{
				return false;
			}
		}
		return true;
	}

	public void clear()
	{
		this.combinacao = new Cores[tamanhoMaximo];
	}

	public void addCor(Cores cor)
	{
		if (this.tamanhoAtual < tamanhoMaximo)
		{
			this.combinacao[tamanhoAtual] = cor;
			this.tamanhoAtual++;
		}
	}
	
	public Cores[] getCombinacao()
	{
		return this.combinacao;
	}
	
	public Cores get(int index)
	{
		if (index < tamanhoMaximo)
		{
			return this.combinacao[index];
		}
		//corrigir pra lançar exceção
		return null;
	}
	
	public int getTamanhoAtual()
	{
		return tamanhoAtual;
	}
}
