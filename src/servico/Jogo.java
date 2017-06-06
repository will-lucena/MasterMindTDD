package servico;

import Utils.Pino;
import dominio.Combinacao;
import dominio.Retorno;

public class Jogo
{
	public Combinacao verificarJogada(Combinacao jogada, Combinacao senha)
	{
		Combinacao retorno = new Retorno();
		retorno.clear();
		
		for (int i = 0; i < 4; i++)
		{
			if (senha.contains(jogada.getPinoAtIndex(i)))
			{
				Pino corJogada = jogada.getPinoAtIndex(i);
				Pino corSenha = senha.getPinoAtIndex(i);
				if (corSenha.equals(corJogada))
				{
					retorno.addPino(Pino.preto);
				}
				else
				{
					retorno.addPino(Pino.branco);
				}
			}
		}
		return retorno;
	}
}
