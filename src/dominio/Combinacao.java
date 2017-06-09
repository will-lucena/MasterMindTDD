package dominio;

import Utils.Pino;

public abstract class Combinacao
{
	public static final int tamanhoMaximo = 4;
	protected int tamanhoAtual = 0;
	protected Pino[] pinos;
	
	public Combinacao()
	{
		this.pinos = new Pino[tamanhoMaximo];
	}

	public Combinacao(Pino p1, Pino p2, Pino p3, Pino p4)
	{
		this.pinos = new Pino[tamanhoMaximo];
		addPino(p1);
		addPino(p2);
		addPino(p3);
		addPino(p4);
	}

	public abstract boolean isValida();
	
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
	
	public int numeroDeOcorrencias(Pino pino)
	{
		int count = 0;
		for (int i = 0; i < this.tamanhoAtual; i++)
		{
			if (this.pinos[i].equals(pino))
			{
				count++;
			}
		}
		return count;
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

		if (other.tamanhoAtual != this.tamanhoAtual)
		{
			return false;
		}
		
		for (int i = 0; i < tamanhoAtual; i++)
		{
			if (!this.pinos[i].equals(other.pinos[i]))
			{
				return false;
			}
		}
		return true;
	}

	public void clear()
	{
		this.pinos = new Pino[tamanhoMaximo];
	}

	public void addPino(Pino pino)
	{
		if (this.tamanhoAtual < tamanhoMaximo)
		{
			this.pinos[tamanhoAtual] = pino;
			this.tamanhoAtual++;
		}
	}
	
	public void removeLastPino()
	{
		pinos[tamanhoAtual-1] = null;
		tamanhoAtual--;
	}
	
	public Pino[] getPinos()
	{
		return this.pinos;
	}

	public Pino getPinoAtIndex(int index)
	{
		if (index < tamanhoAtual)
		{
			return pinos[index];
		}
		//corrigir por lan�ar exception
		return null;
	}
	
	public int getTamanhoAtual()
	{
		return tamanhoAtual;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		for (Pino pino : pinos)
		{
			sb.append(pino.name());
			sb.append(",");
		}
		return sb.toString();
	}
}
