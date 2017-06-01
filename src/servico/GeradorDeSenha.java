package servico;

import dominio.Senha;

public class GeradorDeSenha {

	private static GeradorDeSenha INSTANCE = null;
	
	private GeradorDeSenha()
	{
		
	}
	
	public static GeradorDeSenha getInstance() {
		if (INSTANCE == null)
		{
			synchronized(GeradorDeSenha.class)
			{
				if (INSTANCE == null)
				{
					INSTANCE = new GeradorDeSenha();
				}
			}
		}
		return INSTANCE;
	}

	public Senha criarSenha() {
		// TODO Auto-generated method stub
		return new Senha();
	}

}
