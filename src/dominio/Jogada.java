package dominio;

import Utils.Pino;

public class Jogada extends Combinacao
{
	public Jogada()
	{
		super();
	}
	
	@Override
	public boolean isValida()
	{
		for (int i = 0; i < tamanhoAtual; i++)
		{
			if (pinos[i].equals(Pino.branco) || pinos[i].equals(Pino.preto))
			{
				return false;
			}
		}
		return true;
	}
}
