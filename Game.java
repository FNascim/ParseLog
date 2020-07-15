import java.util.List;

public class Game
{
	private String nome;
	private List<Jogadores> jogadores;
	
    public Game (String nome, List<Jogadores> jogadores)
    {
		this.nome = nome;
		this.jogadores = jogadores;
	}
	
    public String getNome () 
    {
		return nome;
	}
	
    public List<Jogadores> getJogadores () 
    {
		return jogadores;
	}
}