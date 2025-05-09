package model;

import java.io.Serializable;

public class Game implements Serializable {
	private static final long serialLongUID = 1L;
	public static final String DEFAULT_NAME = "New Game";
	public static final String DEFAULT_GENRE = "No Genre";
	public static final int MAX_STORAGE = 1000;
	
	private int id;
	private String name;
	private String genre;
	private float price;
	private LocalDate release_date;
	
	public Game() {
		id = -1;
		name = DEFAULT_NAME;
		genre = DEFAULT_GENRE;
		price = 0.01F;
		release_date = LocalDate.now();
	}
	
	public Game(int id, String name, String genre, float price, LocalDate release_date) {
		setId(id);
		setName(name);
		setGenre(genre);
		setPrice(price);
		setReleaseDate(release_date);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public void getReleaseDate() {
		return release_date;
	}
	
	public void setReleaseDate() {
		this.release_date = release_date;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "Genre: " + genre + "Price: $" + price + "Release Date: " + release_date;
	}
	
	@Override
	public boolean equals(Object obj) {
		return(this.getId() == ((Game) obj).getId());
	}
}
