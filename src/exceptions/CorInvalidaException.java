package exceptions;

import Utils.Pino;

public class CorInvalidaException extends MontarJogadaException
{
	private Pino pino;
	public CorInvalidaException(String msg, Pino pino)
	{
		super(msg);
		this.pino = pino;
	}
	
	public Pino getPino()
	{
		return pino;
	}
}
