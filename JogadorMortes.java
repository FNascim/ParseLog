public class JogadorMortes {
	private Integer Mortes;
	private Integer MatouTotal;
	private Integer MorreuTotal;
	
	
	
    public JogadorMortes() 
    {
		Mortes = 0;
		MatouTotal = 0;
		MorreuTotal = 0;
		
	}
	
    public void setMortes (Integer Mortes) 
    {
		this.Mortes = Mortes;
	}
	
    public Integer getMortes () 
    {
		return Mortes;
	}
	
    public void setMatouTotal (Integer MatouTotal) 
    {
		this.MatouTotal = MatouTotal;
	}
	
    public Integer getMatouTotal () 
    {
		return MatouTotal;
	}
	
    public void setMorreuTotal (Integer MorreuTotal) 
    {
		this.MorreuTotal = MorreuTotal;
	}
	
    public Integer getMorreuTotal () 
    {
		return MorreuTotal;
	}
	
    public void MorteValida () 
    {
		Mortes++;
	}
	
    public void Matou () 
    {
		MatouTotal++;
	}
	
    public void Morreu () 
    {
		MorreuTotal++;
	}
	
    public void WorldMatou () 
    {
		Mortes--;
	}
	
	
	
}
