class CreateGames < ActiveRecord::Migration[5.1]
  def change
    create_table :games do |t|
      t.string :first_team
      t.string :second_team

      t.timestamps
    end
  end
end
