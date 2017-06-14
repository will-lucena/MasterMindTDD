package servico;

import java.util.Arrays;
import java.util.Scanner;

import Utils.Pino;
import dominio.Combinacao;
import dominio.IJogador;
import dominio.Jogada;
import dominio.Jogador;
import dominio.Retorno;
import dominio.Senha;
import exceptions.IndexInvalidoException;
import exceptions.MontarJogadaException;

public class Jogo
{
	public static final Scanner ler = new Scanner(System.in);
	public static final int tentativasTotais = 10;
	
	public static void main(String[] args)
	{
		Jogo jogo = new Jogo();
		Senha s = GeradorDeSenha.getInstance().criarSenha();
		System.out.println(s);
		try
		{
			System.out.println(jogo.jogar(new Jogador(), s));
		} catch (MontarJogadaException | IndexInvalidoException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Retorno verificarJogada(Combinacao jogada, Combinacao senha) throws IndexInvalidoException
	{
		Retorno retorno = new Retorno();
		
		for (int i = 0; i < Combinacao.tamanhoMaximo; i++)
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
	
	public String jogar(IJogador jogador, Senha senha) throws MontarJogadaException, IndexInvalidoException
	{
		int tentativas = tentativasTotais;
		while (tentativas > 0)
		{
			Jogada jogada = jogador.fazerJogada(getCoresToJogada());
			if (jogada.isValida())
			{
				Retorno retorno = verificarJogada(jogada, senha);
				if (verificarFimDeJogo(retorno))
				{
					return "Você Venceu";
				}
				System.out.println(retorno);
				tentativas--;
			}
		}
		return "Game over otaro";
	}
	
	public String[] getCoresToJogada()
	{
		String[] cores = new String[Combinacao.tamanhoMaximo];
		mostrarCores();
		for (int i = 0; i < Combinacao.tamanhoMaximo; i++)
		{
			
			System.out.println("Escolha a cor do " + (i+1) + " da sua jogada");
			cores[i] = ler.nextLine().toLowerCase();
		}
		return cores;
	}
	
	private void mostrarCores()
	{
		for (Pino cor : Arrays.asList(Pino.values()))
		{
			if (!cor.equals(Pino.branco) && !cor.equals(Pino.preto))
			{
				System.out.println(cor);
			}
		}
	}
		
	public boolean verificarFimDeJogo(Combinacao retorno)
	{
		if (retorno.contains(Pino.branco))
		{
			return false;
		}
		return true;
	}
}
