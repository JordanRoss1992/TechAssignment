class CreateTournaments < ActiveRecord::Migration[5.1]
  def change
    create_table :tournaments do |t|
      t.references :its_pools, foreign_key: true
      t.references :its_teams, foreign_key: true
      t.integer :num_pools
      t.integer :num_teams
      t.integer :num_rounds

      t.timestamps
    end
  end
end
