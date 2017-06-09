package servico;

import java.util.Arrays;
import java.util.Random;

import Utils.Pino;
import dominio.Combinacao;
import dominio.Senha;

public class GeradorDeSenha
{
	private static GeradorDeSenha INSTANCE = null;

	private GeradorDeSenha()
	{
		
	}

	public static GeradorDeSenha getInstance()
	{
		if (INSTANCE == null)
		{
			synchronized (GeradorDeSenha.class)
			{
				if (INSTANCE == null)
				{
					INSTANCE = new GeradorDeSenha();
				}
			}
		}
		return INSTANCE;
	}

	public Senha criarSenha()
	{
		Senha senha = new Senha();
		Pino[] cores = Pino.values();
		
		Pino pino;
		while (senha.getTamanhoAtual() != Combinacao.tamanhoMaximo)
		{
			int random = new Random().nextInt(Pino.values().length);
			pino = Arrays.asList(cores).get(random);
			if (!senha.contains(pino))
			{
				senha.addPino(pino);
				if (!senha.isValida())
				{
					senha.removeLastPino();
				}
			}
		}
		return senha;
	}
}
