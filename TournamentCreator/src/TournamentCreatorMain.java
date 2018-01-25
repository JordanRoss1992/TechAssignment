
public class TournamentCreatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numPools = Integer.parseInt(args[0]);
		int numTeams = Integer.parseInt(args[1]);
		int numRounds = Integer.parseInt(args[2]);
		String mode = args[3];
		
		Tournament myTournament = new Tournament(numPools,numTeams,numRounds, mode);
		myTournament.poolTeams();
		myTournament.printTournament();
	}

}
