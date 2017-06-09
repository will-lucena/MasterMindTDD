package dominio;

import Utils.Pino;

public class Retorno extends Combinacao
{
	public Retorno()
	{
		super();
	}
	
	@Override
	public boolean isValida()
	{
		for (int i = 0; i < tamanhoAtual; i++)
		{
			if (!pinos[i].equals(Pino.branco) || !pinos[i].equals(Pino.preto))
			{
				return false;
			}
		}
		return true;
	}
}
