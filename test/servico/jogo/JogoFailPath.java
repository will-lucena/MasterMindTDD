package servico.jogo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Utils.Pino;
import dominio.Combinacao;
import dominio.Jogada;
import dominio.Jogador;
import dominio.Retorno;
import dominio.Senha;
import exceptions.CorInvalidaException;
import exceptions.IndexInvalidoException;
import exceptions.MontarJogadaException;
import exceptions.PinosInsuficientesException;
import servico.GeradorDeSenha;
import servico.Jogo;

public class JogoFailPath
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
	
	@Test (expected = PinosInsuficientesException.class)
	public void realizarJogadaCoresInsuficientes() throws MontarJogadaException
	{
		Jogador player = new Jogador();
		String[] cores = {"azul", "cinza"};
		Combinacao jogada = player.fazerJogada(cores);
		
		assertTrue(jogada.isValida());
	}
	
	@Test (expected = CorInvalidaException.class)
	public void realizarJogadaCoresErradas() throws MontarJogadaException
	{
		Jogador player = new Jogador();
		String[] cores = {"azul", "cinza", "rosa", "preto"};
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
