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
			if (senha.contains(jogada.getCorAtIndex(i)))
			{
				Pino corJogada = jogada.getCorAtIndex(i);
				Pino corSenha = senha.getCorAtIndex(i);
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
