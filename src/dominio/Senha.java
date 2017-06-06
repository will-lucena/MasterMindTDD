package dominio;

import Utils.Cores;

public class Senha
{

	private Combinacao combinacao;

	public Senha()
	{
		this.combinacao = new Combinacao();
	}

	public boolean isValida()
	{
		// TODO Auto-generated method stub
		return true;
	}

	public Cores[] getCombinacao()
	{
		return combinacao.getCombinacao();
	}

	public void addCor(Cores cor)
	{
		this.combinacao.addCor(cor);
	}

	public Cores getCorAtIndex(int index)
	{
		return this.combinacao.get(index);
	}
	
	public boolean contains(Cores cor)
	{
		for (int i = 0; i < this.combinacao.getTamanhoAtual(); i++)
		{
			if (this.combinacao.get(i).equals(cor))
			{
				return true;
			}
		}
		return false;
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
		Senha other = (Senha) obj;

		for (int i = 0; i < 4; i++)
		{
			if (!this.combinacao.equals(other.combinacao))
			{
				return false;
			}
		}
		return true;
	}
}
