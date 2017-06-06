package servico.jogo;

import dominio.Combinacao;
import dominio.Jogada;
import dominio.Jogador;
import dominio.Senha;
import servico.GeradorDeSenha;
import servico.Jogo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Utils.Cores;

public class JogoTest 
{
	private Jogada jogadaPadrao;
	private Senha senhaPadrao;
	private Combinacao retornoPadrao;
	
	private Jogada jogadaDefault()
	{
		Jogada jogada = new Jogada();
		jogada.addCor(Cores.amarelo);
		jogada.addCor(Cores.amarelo);
		jogada.addCor(Cores.amarelo);
		jogada.addCor(Cores.amarelo);
		return jogada;
	}
	
	private Senha senhaDefault()
	{
		Senha senha = new Senha();
		senha.addCor(Cores.azul);
		senha.addCor(Cores.cinza);
		senha.addCor(Cores.rosa);
		senha.addCor(Cores.amarelo);
		return senha;
	}
	
	private Combinacao retornoDefault()
	{
		Combinacao retorno = new Combinacao();
		retorno.addCor(Cores.branco);
		retorno.addCor(Cores.branco);
		retorno.addCor(Cores.branco);
		retorno.addCor(Cores.preto);
		return retorno;
	}
	
	@Before
	public void setUp()
	{
		this.senhaPadrao = senhaDefault();
		this.jogadaPadrao = jogadaDefault();
		this.retornoPadrao = retornoDefault();
	}
	
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
		assertNotEquals(this.senhaPadrao, this.jogadaPadrao);
	}
	
	@Test
	public void verificarJogada()
	{
		assertEquals(retornoPadrao, new Jogo().verificarJogada(jogadaPadrao, senhaPadrao));
	}
}
