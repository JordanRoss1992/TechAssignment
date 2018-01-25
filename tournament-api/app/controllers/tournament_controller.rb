class TournamentController < ApplicationController

	def new
		@tournament = Tournament.new
	end

	def create
		@tournament.create_tournament(tournament_params)
	end

	def show
		for pool in @tournament.pools do 
			puts(pool.games)
		end
	end

	def tournament_params
		params.permit(:num_pools, :num_teams, :num_rounds)
	end
end
