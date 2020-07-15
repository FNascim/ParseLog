import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameLog 
{
	private List<String> logs;
	
    public GameLog (List<String> logs) 
    {
		this.logs = logs; 
	}
	
    public List<Game> parserGames() 
    {
		List<Log> gameLogs = parserLogs();
		List<Game> games = new ArrayList<>();
		
        for (Log gameLog : gameLogs) 
        {
			games.add(parsergameLogs(gameLog));
		}
		return games;
	}
	
    private List<Log> parserLogs() 
    {
		List<Log> games = new ArrayList<>();
		int TotaldePartidas = 0;
		String UltimaLinha = logs.get(logs.size() - 1);
		Log game = new Log();
		
        for (String log : logs) 
        {
			boolean InitGame = Regex.EstaPresente(log.trim(), "InitGame");
			if (InitGame) {
                if (TotaldePartidas > 0) 
                {
					games.add(game);
					game = new Log ();
				}
				TotaldePartidas++;
				game.setNome("game: "+ TotaldePartidas);
			}
            else 
            {
				game.adicionaLinha(log);
			}
			
            if (log.equals(UltimaLinha)) 
            {
				games.add(game);
			}
		}
		return games;
	}
	
    private Game parsergameLogs (Log game) 
    {
		List<String> logs = game.getLogs();
		String nome = game.getNome();
		Map<String, Jogadores> mapJogadores = new HashMap<>();
		Verificador.verificador(logs, mapJogadores); 
		List<Jogadores> jogadores = new ArrayList<>(mapJogadores.values());
		
		return new Game(nome, jogadores);
	}	
}
