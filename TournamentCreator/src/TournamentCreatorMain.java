
public class TournamentCreatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numPools = 0;
		int numTeams = 0;
		int numRounds = 0;
		try{
			numPools = Integer.parseInt(args[0]);
		    numTeams = Integer.parseInt(args[1]);
			numRounds = Integer.parseInt(args[2]);
		} catch(NumberFormatException e){
			System.out.println("ERROR: Invalid parameter type " + e.getMessage() + "\n" +
					           "USAGE: java -jar TournamentCreator.jar <number pools> <number teams> <number rounds> <mode (snake/standard)>" + "\n" +
							   "Exiting System.");
			System.exit(0);
		}
		String mode = args[3];
		
		if(numPools == 0){
			System.out.println("ERROR: Must enter at least one pool (arg 1");
			System.exit(0);
		} else if(numRounds == 0){
			System.out.println("ERROR: Must enter at least one Round (arg 3)");
			System.exit(0);
		}
		
		Tournament myTournament = new Tournament(numPools,numTeams,numRounds, mode);
		myTournament.poolTeams();
		myTournament.printTournament();
	}

}
