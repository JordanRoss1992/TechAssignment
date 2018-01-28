import java.util.ArrayList;

public class Tournament {
	static protected int numPools;
	static protected int numTeams;
	static protected int numRounds;
	static protected String poolMode;
	
	private ArrayList<Pool> itsPools = new ArrayList<Pool>();
	private ArrayList<Team> itsTeams = new ArrayList<Team>();
	
	public Tournament(int numP, int numT, int numR, String mode){
		numPools = numP;
		numTeams = numT;
		numRounds = numR;
		poolMode = mode;
		this.createPools(numP);
		this.createTeams(numT);
	}
	
	private void createPools(int numPools){
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		for(int i = 0; i < numPools; i++){
			itsPools.add(new Pool("Pool_" + alphabet[i]));
		}
	}
	
	private void createTeams(int numTeams){
		for(int i = 0; i < numTeams; i++){
			itsTeams.add(new Team("Team #" + new Integer(i+1).toString()));
		}
	}
	
	public void poolTeams(){
		int numRows = setNumRows(numTeams, numPools);
		int teamIterator = 0;
		for(int i = 1; i <= numRows; i++){
			// Even Row
			if(i%2 == 0 && poolMode.toLowerCase().contains("snake")){
				for(int j = itsPools.size() - 1; j >= 0; j--){
					if(teamIterator < numTeams){
						itsPools.get(j).addTeam(itsTeams.get(teamIterator));
						teamIterator++;
					}
				}
			} 
			// odd row
			for(Pool p : itsPools){
				if(teamIterator < numTeams){
					p.addTeam(itsTeams.get(teamIterator));
					teamIterator++;
				}
			}
		}
	}
	
	public void printTournament(){
		for(int i = 1; i < numRounds + 1; i++){
		for(Pool p : itsPools){
				p.createGames();
				System.out.println("Pool: " + p.getName() + " Teams:");
				for(Team t : p.getTeams()){
					System.out.println(" -- " + t.getName());
				}
				System.out.println(p.getName() + " Round " + i + " Games:" );
				for(Game g : p.getGames()){
					g.printGame();
				}
			}
		}
	}
	
	
	
	private int setNumRows(int teams, int pools){
		if(teams%pools == 0){
			return teams/pools;
		}
		return (teams/pools + 1);
	}
}
