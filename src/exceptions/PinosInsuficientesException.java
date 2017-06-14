package exceptions;

public class PinosInsuficientesException extends MontarJogadaException
{
	private String[] jogada;
	
	public PinosInsuficientesException(String msg, String[] jogada)
	{
		super(msg);
		this.jogada = jogada;
	}
	
	public String[] getJogada()
	{
		return jogada;
	}
}
