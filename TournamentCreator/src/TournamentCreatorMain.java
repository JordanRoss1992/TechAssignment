
public class TournamentCreatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numPools = Integer.parseInt(args[0]);
		int numTeams = Integer.parseInt(args[1]);
		int numRounds = Integer.parseInt(args[2]);
		
		Tournament myTournament = new Tournament(numPools,numTeams,numRounds);
		myTournament.poolTeams();
		myTournament.printTournament();
	}

}
