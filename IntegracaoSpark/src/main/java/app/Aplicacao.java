package app;

import static spark.Spark.*;

public class Aplicacao {
	
	public static GameService gameService = new GameService();
	
	public static void main(String[] args) {
		port(6789);
		
		post("/game", (request, response) -> gameService.add(request, response));
		
		get("/game/:id", (request, response) -> gameService.get(request, response)); 
	
		get("/game/update/:id", (request, response) -> gameService.update(request, response));
	
		get("/game/delete/:id", (request, response) -> gameService.delete(request, response));
		
		get("/game/", (request, response) -> gameService.getAll(request, response));
	}

}
