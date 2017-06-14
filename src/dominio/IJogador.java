package dominio;

import exceptions.MontarJogadaException;

public interface IJogador
{
	public Jogada fazerJogada(String[] cores) throws MontarJogadaException;
}
