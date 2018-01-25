class Tournament < ApplicationRecord
  	@teams = []
  	@pools = []

	def create_tournament(num_pools, num_teams, num_rounds)
  		iterator = 0

  		# Figure out the number of rows
  		# round up to the next whole number if the number of teams
  		# does not divide evenly by the number of pools.
  		if (num_teams%num_pools) == 0 then
  			num_rows = (num_teams/num_pools) 
  		else
  			num_rows = (num_teams/num_pools) + 1
  		end

  		# Create the pools
  		(0..num_pools).each do |num|
  			@pools << Pool.new(:pool_name => "Pool #{(A..Z).to_a[num]}")
  		end

  		# Create the teams (team number is the index + 1)
  		(0..num_teams).each do |num|
  			@teams << Team.new(:team_name => "Team ##{num + 1}")
  		end

  		# If we have an odd row, traverse pools from left to right and add teams to the pools
  		# If we have an even row, traverse pools from right to left and add team to the pools
  		(1..num_rows).each do |row|
        	if row % 2 == 0
        		# even row
            	(num_pools).downto(0) do |i|
            	# if there are still teams, add them to the pools
            	if iterator < num_teams
                	@pools[i].add_team(@teams[iterator])
                	iterator += 1
            	end
        	end
        	else
        		# odd row
        	(0..num_pools).each do |i|
        		# if there are still teams, add them to the pools
            	if iterator < num_teams
                	@pools[i].add_team(@teams[iterator])
                	iterator += 1
            	end
        	end
    	end

    	# Create games for each pool, for num_rounds rounds.
    	(0...num_rounds).each do 
    		for pool in @pools
    			pool.create_games
    		end
    	end
 	end	
end
end