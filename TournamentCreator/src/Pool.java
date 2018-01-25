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
		for(int i = 0; i < itsTeams.size() - 1; i++) {
			for(int j = duplicateRemoval; j < itsTeams.size() - 1; j++){
				if(i != j){
					itsGames.add(new Game(duplicateRemoval, itsTeams.get(i), itsTeams.get(j)));
				}
			}
			duplicateRemoval++;
		}
	}
	
	
	public void addTeam(Team t){
		itsTeams.add(t);
	}
	
	public Game getGameById(int identifier){
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
