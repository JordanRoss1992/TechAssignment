Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  get '/create_tournament', to: "tournament#new"
  post 'populate_tournament', to: "tournament#create"
  get '/populate_tournament', to: "tournament#show"
end
