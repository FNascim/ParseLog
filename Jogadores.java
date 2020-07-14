public class Jogadores {
	private String id;
	private String nome;
	private JogadorMortes mor;
	
	@Override
	public String toString() 
	{
		return "nome: " + this.nome + ", JogadorMortes: " + this.mor;
	}
	
	public Jogadores (final String id, final String nome, final JogadorMortes mor) 
	{
		this.id = id;
		this.nome = nome;
		this.mor = mor;
	}
	
	public String getNome () 
	{
		return nome;
	}
	
	public void setNome (final String nome) 
	{
		this.nome = nome;
	}
	
	public JogadorMortes getJogadorMortes () 
	{
		return mor;
	}
	
	public void setJogadorMortes (final JogadorMortes mor) 
	{
		this.mor = mor;
	}
	
	public String getID () 
	{
		return id;
	}
	
	public void setID (final String id) 
	{
		this.id = id;
	}
}
