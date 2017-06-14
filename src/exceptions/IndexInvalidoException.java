package exceptions;

public class IndexInvalidoException extends Exception
{
	private final int index;
	private final int tamanhoAtual;
	
	public IndexInvalidoException(String msg, int index, int tamanhoAtual)
	{
		super(msg);
		this.index = index;
		this.tamanhoAtual = tamanhoAtual;
	}
	
	public int getIndex()
	{
		return index;
	}
	
	public int getTamanhoAtual()
	{
		return tamanhoAtual;
	}
}
