import java.util.ArrayList;
import java.util.List;

public class Log 
{
	private String nome;
	private List<String> logs;
	
	public Log() 
	{
		this.logs = new ArrayList<> ();
	}
	
	public String getNome () 
	{
		return nome;
	}
	
	public void setNome (final String nome) 
	{
		this.nome = nome;
	}
	
	public List<String> getLogs () 
	{
		return logs;
	}
	
	public void setLogs (final List<String> logs) 
	{
		this.logs = logs;
	}
	
	public void adicionaLinha (final String log) 
	{
		logs.add(log);
	}
}