package Utils;

public enum Pino
{
	vermelho("vermelho"),
	azul("azul"), 
	rosa("rosa"), 
	amarelo("amarelo"), 
	roxo("roxo"), 
	verde("verde"),
	cinza("cinza"),
	laranja("laranja"),
	branco("branco"), 
	preto("preto");
	
	private String cor;
	
	private Pino(String cor)
	{
		this.cor = cor;
	}
	
	public static Pino getPinoByCor(String cor)
	{
		if (cor.equals(vermelho.cor))
			return vermelho;
		if (cor.equals(azul.cor))
			return azul;
		if (cor.equals(rosa.cor))
			return rosa;
		if (cor.equals(amarelo.cor))
			return amarelo;
		if (cor.equals(roxo.cor))
			return roxo;
		if (cor.equals(verde.cor))
			return verde;
		if (cor.equals(cinza.cor))
			return cinza;
		if (cor.equals(laranja.cor))
			return laranja;
		if (cor.equals(branco.cor))
			return branco;
		if (cor.equals(preto.cor))
			return preto;
		return null;
	}
}
