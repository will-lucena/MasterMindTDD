package dominio;

import Utils.Cores;

public class Jogada
{
	private Combinacao combinacao;

	public Jogada()
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
		Jogada other = (Jogada) obj;

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
