import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GameParser 
{
	public static void main (String[] args) throws IOException 
	{
		List<String> logs; 
		int opcao = 0;
		logs = Files.readAllLines(Paths.get("C:/ParserLog/Quake.log"));

		GameLog game = new GameLog(logs);
				List<Game> games = game.parserGames();
				printGames(games, opcao);
		
	}

	
	public static void printGames (List <Game> games, int opcao) 
	{
		
		System.out.println("Ranking: {");
		Map<String, Integer> mortesTotais = new HashMap<>();
		List<Jogadores> jogadores = new ArrayList<>();
		for (Game game : games) {
			for (Jogadores p : game.getJogadores()) 
			{
				jogadores.add(p);
			}
		}
		
		for (Jogadores p : jogadores) 
		{
			String nome = p.getNome();
			Integer mortesNoJogo = p.getJogadorMortes().getMortes();
			if (!mortesTotais.containsKey(nome)) 
			{
				mortesTotais.put(nome, 0);
			}
			mortesTotais.put(nome, mortesTotais.get(nome) + mortesNoJogo);
		}
		
		for (Entry<String, Integer> Jogadores : mortesTotais.entrySet()) 
		{
			System.out.println(" " + Jogadores.getKey() + ": " + Jogadores.getValue());
		}
		System.out.println("}");
		System.out.println("");
		
		for (Game game : games) 
		{
			System.out.println(game.getNome() + " {");
			int totalKills = 0;
			for (Jogadores jogador : game.getJogadores()) 
			{
				totalKills = totalKills + jogador.getJogadorMortes().getMorreuTotal();
			}
			System.out.println("Total_Kills: " + totalKills);
			System.out.print("jogadores: [");
			for (Jogadores jogador : game.getJogadores()) 
			{
				System.out.print("'" + jogador.getNome() + "', ");
			}
			System.out.print("]");
			System.out.println("");
			System.out.println("Kills: {");
			for (Jogadores jogador : game.getJogadores()) 
			{
				System.out.println(jogador.getNome() + " : " + jogador.getJogadorMortes().getMortes());
			}
			System.out.println("  }");
			
		}
	}		
}
