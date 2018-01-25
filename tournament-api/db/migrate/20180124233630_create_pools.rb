class CreatePools < ActiveRecord::Migration[5.1]
  def change
    create_table :pools do |t|
      t.string :pool_name
      t.references :its_teams, foreign_key: true

      t.timestamps
    end
  end
end
