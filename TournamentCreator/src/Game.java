
public class Game {
	private Team homeTeam;
	private Team awayTeam;
	private String gameId;
	
	public Game(String id, Team t1, Team t2){
		gameId = id;
		
		// randomize which team is home, and which is away
		if(Math.random() < .5){
			homeTeam = t1;
			awayTeam = t2;
		} else {
			homeTeam = t2;
			awayTeam = t1;
		}
			
	}
	
	public void printGame(){
		System.out.println("GAME ID: " + gameId + " Home Team: " + homeTeam.getName() + " vs. " + "Away Team: " + awayTeam.getName());
	}
	
	public void setGameId(String s){
		this.gameId = s;
	}
	
	public String getId(){
		return this.gameId;
	}

}
