package service;

import java.io.IOException;

public class GameService {
	
	private GameDAO gameDAO;
	
	public GameService() {
		try {
			gameDAO = new GameDAO("game.dat");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Object add(Request request, Response response) {
		String name = request.queryParams("name");
		String genre = request.queryParams("genre");
		float price = Float.parseFloat(request.queryParams("price"));
		LocalDate release_date = LocalDate.parse(request.queryParams("release_date"));
		
		int id = gameDAO.getMaxId() + 1;
		
		Game game = new Game(id, name, genre, price, release_date);
		
		gameDao.add(game);
		
		response.status(201);
		return id;
	}
	
	public Object get(Request request, Response response) {
			int id = Integer.parseInt(request.queryParams(":id"));
			
			Game game = (Game) gameDAO.get(id);
			
			if(game != null) {
				response.header 
			}
	}
	
}
