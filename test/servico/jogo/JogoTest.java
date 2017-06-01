package servico.jogo;

import dominio.Jogada;
import dominio.Jogador;
import dominio.Senha;
import servico.GeradorDeSenha;

import static org.junit.Assert.*;

import org.junit.Test;

public class JogoTest 
{
	@Test
	public void criarSenha()
	{
		Senha senha = GeradorDeSenha.getInstance().criarSenha();
		assertTrue(senha.isValida());
	}
	
	@Test
	public void realizarJogada()
	{
		Jogador player = new Jogador();
		Jogada jogada = player.fazerJogada();
		
		assertTrue(jogada.isValida());
	}
	
	@Test
	public void verificarFimDeJogo()
	{
		Senha senha = GeradorDeSenha.getInstance().criarSenha();
		
		Jogador player = new Jogador();
		Jogada jogada = player.fazerJogada();
		
		assertEquals(senha.getCombinacao(), jogada.getCombinacao());
	}
}
