package servico.jogo;

import dominio.Combinacao;
import dominio.Jogada;
import dominio.Jogador;
import dominio.Retorno;
import dominio.Senha;
import exceptions.IndexInvalidoException;
import exceptions.MontarJogadaException;
import servico.GeradorDeSenha;
import servico.Jogo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Utils.Pino;

public class JogoHappyPath 
{
	private Combinacao jogadaPadrao;
	private Combinacao senhaPadrao;
	private Combinacao retornoPadrao;
	
	private Jogada jogadaDefault()
	{
		Jogada jogada = new Jogada();
		jogada.addPino(Pino.amarelo);
		jogada.addPino(Pino.amarelo);
		jogada.addPino(Pino.amarelo);
		jogada.addPino(Pino.amarelo);
		return jogada;
	}
	
	private Senha senhaDefault()
	{
		Senha senha = new Senha();
		senha.addPino(Pino.azul);
		senha.addPino(Pino.cinza);
		senha.addPino(Pino.rosa);
		senha.addPino(Pino.amarelo);
		return senha;
	}
	
	private Combinacao retornoDefault()
	{
		Retorno retorno = new Retorno();
		retorno.addPino(Pino.branco);
		retorno.addPino(Pino.branco);
		retorno.addPino(Pino.branco);
		retorno.addPino(Pino.preto);
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
		Combinacao senha = GeradorDeSenha.getInstance().criarSenha();
		
		assertTrue(senha.isValida());
	}
	
	@Test
	public void realizarJogada() throws MontarJogadaException
	{
		Jogador player = new Jogador();
		String[] cores = {"azul", "cinza", "rosa", "amarelo"};
		Combinacao jogada = player.fazerJogada(cores);
		
		assertTrue(jogada.isValida());
	}
	
	@Test
	public void verificarFimDeJogo() throws IndexInvalidoException
	{
		Jogo jogo = new Jogo();
		Retorno retorno = jogo.verificarJogada(this.jogadaPadrao, this.senhaPadrao);
		
		assertFalse(jogo.verificarFimDeJogo(retorno));
	}
	
	@Test
	public void verificarJogada() throws IndexInvalidoException
	{
		assertEquals(this.retornoPadrao, new Jogo().verificarJogada(this.jogadaPadrao, this.senhaPadrao));
	}
}
