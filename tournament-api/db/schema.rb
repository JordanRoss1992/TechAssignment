# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20180125014920) do

  create_table "games", force: :cascade do |t|
    t.string "first_team"
    t.string "second_team"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "pools", force: :cascade do |t|
    t.string "pool_name"
    t.integer "its_teams_id"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["its_teams_id"], name: "index_pools_on_its_teams_id"
  end

  create_table "teams", force: :cascade do |t|
    t.string "team_name"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "tournaments", force: :cascade do |t|
    t.integer "its_pools_id"
    t.integer "its_teams_id"
    t.integer "num_pools"
    t.integer "num_teams"
    t.integer "num_rounds"
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
    t.index ["its_pools_id"], name: "index_tournaments_on_its_pools_id"
    t.index ["its_teams_id"], name: "index_tournaments_on_its_teams_id"
  end

end
