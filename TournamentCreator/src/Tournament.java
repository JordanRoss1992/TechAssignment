import java.util.ArrayList;

public class Tournament {
	static protected int numPools;
	static protected int numTeams;
	static protected int numRounds;
	
	private ArrayList<Pool> itsPools = new ArrayList<Pool>();
	private ArrayList<Team> itsTeams = new ArrayList<Team>();
	
	public Tournament(int numP, int numT, int numR){
		numPools = numP;
		numTeams = numT;
		numRounds = numR;
		this.createPools(numP);
		this.createTeams(numT);
	}
	
	private void createPools(int numPools){
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		for(int i =0; i < numPools; i++){
			itsPools.add(new Pool("Pool_" + alphabet[i]));
		}
	}
	
	private void createTeams(int numTeams){
		for(int i =0; i < numTeams; i++){
			itsTeams.add(new Team("Team #" + new Integer(i+1).toString()));
		}
	}
	
	public void poolTeams(){
		int numRows = setNumRows(numTeams, numPools);
		int teamIterator = 0;
		for(int i = 1; i < numRows; i++){
			// Even Row
			if(i%2 == 0){
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
		for(Pool p : itsPools){
			p.createGames();
			System.out.println("Pool: " + p.getName() + " Teams:");
			for(Team t : p.getTeams()){
				System.out.println(" -- " + t.getName());
			}
			System.out.println(p.getName() + " Games:");
			for(Game g : p.getGames()){
				g.printGame();
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
