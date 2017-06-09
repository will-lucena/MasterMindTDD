package dominio;

import Utils.Pino;

public class Jogador implements IJogador
{
	@Override
	public Jogada fazerJogada(String[] cores) 
	{
		return montarJogada(cores);
	}
	
	private Jogada montarJogada(String[] cores)
	{
		if (cores.length != Combinacao.tamanhoMaximo)
		{
			//throw exception
			return null;
		}
		
		Jogada jogada = new Jogada();
		for (String cor : cores)
		{
			jogada.addPino(Pino.getPinoByCor(cor));
			if (!jogada.isValida())
			{
				//throw exception
				return null;
			}
		}
		return jogada;
	}
}
