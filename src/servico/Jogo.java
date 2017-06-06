package servico;

import Utils.Cores;
import dominio.Combinacao;
import dominio.Jogada;
import dominio.Senha;

public class Jogo
{
	public Combinacao verificarJogada(Jogada jogada, Senha senha)
	{
		Combinacao retorno = new Combinacao();
		retorno.clear();
		
		for (int i = 0; i < 4; i++)
		{
			if (senha.contains(jogada.getCorAtIndex(i)))
			{
				Cores corJogada = jogada.getCorAtIndex(i);
				Cores corSenha = senha.getCorAtIndex(i);
				if (corSenha.equals(corJogada))
				{
					retorno.addCor(Cores.preto);
				}
				else
				{
					retorno.addCor(Cores.branco);
				}
			}
		}
		return retorno;
	}
}
