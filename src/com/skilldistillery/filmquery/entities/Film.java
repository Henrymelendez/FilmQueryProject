package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;



public class Film {
	private Integer filmId;
	private String title;
	private String description;
	private Short releaseYear;
	private String language;
	private Integer rentalDuration;
	private Double rentalRate;
	private Integer length;
	private Double replacementCost;
	private String rating;
	private String specialFeatures;
	private String category; 
	List<Actor> actors;
	List<Inventory> inventory;
	
	
	
	






	public Film() {
		
	}
	
	
	
	







	public Film(int filmId, String title, String description, short releaseYear, String language, int rentalDuration, double rentalRate,
			int length, double replacementCost, String rating, String specialFeatures, String category) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.language = language;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.category = category;
	}
	
	





	public int getFilmId() {
		return filmId;
	}





	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}





	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
	}





	public short getReleaseYear() {
		return releaseYear;
	}





	public void setReleaseYear(short releaseYear) {
		this.releaseYear = releaseYear;
	}





	public String getLanguage() {
		return language;
	}





	public void setLanguage(String language) {
		this.language = language;
	}





	public int getRentalDuration() {
		return rentalDuration;
	}





	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}





	public double getRentalRate() {
		return rentalRate;
	}





	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}





	public int getLength() {
		return length;
	}





	public void setLength(int length) {
		this.length = length;
	}





	public double getReplacementCost() {
		return replacementCost;
	}





	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}





	public String getRating() {
		return rating;
	}





	public void setRating(String rating) {
		this.rating = rating;
	}





	public String getSpecialFeatures() {
		return specialFeatures;
	}





	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	
	
	





	public List<Actor> getActors() {
		return actors;
	}





	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	
	





	public List<Inventory> getInventory() {
		return inventory;
	}











	public void setInventory(List<Inventory> inventory) {
		this.inventory = inventory;
	}







	@Override
	public int hashCode() {
		return Objects.hash(filmId, language, length, rating, releaseYear, rentalDuration, rentalRate,
				replacementCost, specialFeatures, title);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return filmId == other.filmId && language == other.language && length == other.length
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}





	@Override
	public String toString() {
		return "Film\n film Id: " + filmId + ",\n title: " + title + ",\n year: " + releaseYear + ",\n rating: " + rating + 
				",\n description: " + description + ",\n Language : " + language + ",\n actors: " + actors;
	}
	
	
	
	public String PrintDetails() {
		
		return "Film Detail\n " + "Category: " + category + ",\n rental Duration: " + rentalDuration + ",\n rental Rate: " + rentalRate + ",\n length: "
				+ length + ",\n replacement Cost: " + replacementCost  + ",\n specialFeatures: "
				+ specialFeatures + ",\n Inventory: " + inventory +"\n" ;
	}




	

	
	
	
	
	
	
	
	
	
	
}
