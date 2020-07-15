import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

public class Verificador {
	public static void verificador (List<String> logs, Map<String, Jogadores> jogadores) {
		for (String log : logs) {
			Matcher RegJogador = Regex.getMatcherForSentence(log, "ClientUserinfoChanged");
			if (RegJogador.matches()) {
				verificadorRegistro(RegJogador, jogadores);
			}
			Matcher Matou = Regex.getMatcherForSentence(log, "Matou");
			if (Matou.matches()) {
				verificadorMatou(Matou, jogadores);
			}
		}
	}
	
	private static void verificadorRegistro (Matcher RegJogador, Map<String, Jogadores> jogadores) {
		String jogador = RegJogador.group(3).trim();
		String jogadorID = null;
		String JogadorName = null;
		
		if (jogador.length() > 0) {
			jogadorID = jogador.substring(0, 1);
			int nameStart = jogador.indexOf("n\\");
			int nameEnd = jogador.indexOf("\\t\\");
			
			if (nameStart == 0 || nameEnd == 0) {
				JogadorName = "";
			}
			else {
				JogadorName = jogador.substring(nameStart + 2, nameEnd);
			}
		}
		
		else {
			jogadorID = "";
			JogadorName = "";
		}
		
		if (jogadores.containsKey(jogadorID)) {
			Jogadores antigo = jogadores.get(jogadorID);
			
			if (!antigo.getNome().equals(JogadorName)) {
				jogadores.remove(jogadorID);
				antigo.setID("1000" + antigo.getID());
				jogadores.put(antigo.getID(), antigo);
				jogadores.put(jogadorID, new Jogadores (jogadorID, JogadorName, new JogadorMortes()));
			}
		}
		else {
			jogadores.put(jogadorID, new Jogadores(jogadorID, JogadorName, new JogadorMortes()));
		}
	}
	
	private static void verificadorMatou (Matcher Matou, Map<String, Jogadores> jogadores) {
		String jogadorMatou = Matou.group(3).trim();
		Matcher matcherKD = Regex.createPatternForSetence("([0-9]*)\\s([0-9]*)\\s([0-9]*)(.*)", jogadorMatou);
		if (!matcherKD.matches()) {
			return;
		}
		String idMatou = matcherKD.group(1);
		String idMorreu = matcherKD.group(2);
		
		if (!idMatou.equals(idMorreu)) {
			Jogadores killer = jogadores.get(idMatou);
			if (!(killer == null)) {
				killer.getJogadorMortes().Matou();
				killer.getJogadorMortes().MorteValida();
			}
		}
		
		Jogadores killed = jogadores.get(idMorreu);
		if (!(killed == null)) {
			killed.getJogadorMortes().Morreu();
		}
		
		if (idMatou.equals("1022")) {
			Jogadores KilledWorld =  jogadores.get(idMorreu);
			if (!(KilledWorld == null)) {
				KilledWorld.getJogadorMortes().WorldMatou();
			}
		}
	}
	
}
