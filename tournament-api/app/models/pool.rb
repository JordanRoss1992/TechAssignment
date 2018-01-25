class Pool < ApplicationRecord
  serialize :@teams, Array 
  serialize :@games, Array

  def add_team(team)
	@teams << team
  end

  def create_games
  	@games = @teams.combination(2).to_a
  end


end
