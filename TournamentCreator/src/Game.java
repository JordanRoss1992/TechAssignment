
public class Game {
	private Team team1;
	private Team team2;
	private int gameId;
	
	public Game(int id, Team t1, Team t2){
		gameId = id;
		team1 = t1;
		team2 = t2;
	}
	
	public boolean isDuplicateGame(Team t1, Team t2){
		if(this.team1 == t2 && this.team2 == t1){
			return true;
		}
		return false;	
	}
	
	public void printGame(){
		System.out.println("First Team: " + team1.getName() + " vs. " + "Second team: " + team2.getName());
	}
	
	public int getId(){
		return this.gameId;
	}

}
