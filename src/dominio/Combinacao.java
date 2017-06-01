package dominio;

import java.util.List;

import Utils.Cores;

public class Combinacao {
	private List<Cores> combinacao;
	
	@Override
	public boolean equals(Object obj) {
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
			if (!this.combinacao.get(i).equals(other.combinacao.get(i)))
			{
				return false;
			}
		}
		return true;
	}
}
