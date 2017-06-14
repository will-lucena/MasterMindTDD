package dominio;

import Utils.Pino;
import exceptions.CorInvalidaException;
import exceptions.MontarJogadaException;
import exceptions.PinosInsuficientesException;

public class Jogador implements IJogador
{
	@Override
	public Jogada fazerJogada(String[] cores) throws MontarJogadaException 
	{
		return montarJogada(cores);
	}
	
	private Jogada montarJogada(String[] cores) throws MontarJogadaException
	{
		if (cores.length != Combinacao.tamanhoMaximo)
		{
			throw new PinosInsuficientesException("A quantidade de pinos escolhidas foi insuficiente", cores);
		}
		
		Jogada jogada = new Jogada();
		for (String cor : cores)
		{
			if (jogada.addPino(Pino.getPinoByCor(cor)))
			{
				if (!jogada.isValida())
				{
					throw new CorInvalidaException(cor + " não é uma cor válida", Pino.getPinoByCor(cor));
				}
			}
		}
		return jogada;
	}
}
