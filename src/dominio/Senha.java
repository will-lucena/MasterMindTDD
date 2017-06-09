package dominio;

import Utils.Pino;

public class Senha extends Combinacao
{
	public Senha()
	{
		super();
	}
	
	@Override
	public boolean isValida()
	{
		for (int i = 0; i < tamanhoAtual; i++)
		{
			if (pinos[i].equals(Pino.branco) || pinos[i].equals(Pino.preto) || numeroDeOcorrencias(pinos[i]) > 1)
			{
				return false;
			}
		}
		return true;
	}
}
