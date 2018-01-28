import java.util.ArrayList;

public class Pool {
	private String poolName;
	private ArrayList<Team> itsTeams = new ArrayList<Team>();
	private ArrayList<Game> itsGames = new ArrayList<Game>();
	
	public Pool(String name){
		poolName = name;
	}
	
	public void createGames(){
		int duplicateRemoval = 0;
		int gameId = 1;
		for(int i = 0; i < itsTeams.size() - 1; i++) {
			for(int j = duplicateRemoval; j < itsTeams.size(); j++){
				if(i != j){
					String gameIdString = poolName + Integer.toString(gameId);
					itsGames.add(new Game(gameIdString, itsTeams.get(i), itsTeams.get(j)));
					gameId++;
				}
			}
			duplicateRemoval++;
		}
	}
	
	public void addTeam(Team t){
		itsTeams.add(t);
	}
	
	public Game getGameById(String identifier){
		for(Game g : itsGames){
			if(g.getId() == identifier){
				return g;
			}
		}
		return null;
	}
	
	public ArrayList<Team> getTeams(){
		return itsTeams;
	}
	
	public ArrayList<Game> getGames(){
		return itsGames;
	}
	
	public String getName(){
		return poolName;
	}
}
