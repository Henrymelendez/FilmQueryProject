package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private Integer filmId;
	private String title;
	private String description;
	private Short releaseYear;
	private Integer languageId;
	private Integer rentalDuration;
	private Double rentalRate;
	private Integer length;
	private Double replacementCost;
	private String rating;
	private String specialFeatures;
	List<Actor> actors;
	
	
	
	public List<Actor> getActors() {
		return actors;
	}





	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}





	public Film() {
		
	}
	
	
	
	
	
	public Film(int filmId, String title, String description, short releaseYear, int languageId, int rentalDuration, double rentalRate,
			int length, double replacementCost, String rating, String specialFeatures) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
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





	public int getLanguageId() {
		return languageId;
	}





	public void setLanguageId(int languageId) {
		this.languageId = languageId;
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





	@Override
	public int hashCode() {
		return Objects.hash(filmId, languageId, length, rating, releaseYear, rentalDuration, rentalRate,
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
		return filmId == other.filmId && languageId == other.languageId && length == other.length
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}





	@Override
	public String toString() {
		return "Films\n film Id: " + filmId + ",\n title: " + title + ",\n release Year: " + releaseYear + ",\n languageId: "
				+ languageId + ",\n rental Duration: " + rentalDuration + ",\n rental Rate: " + rentalRate + ",\n length: "
				+ length + ",\n replacement Cost: " + replacementCost + ",\n rating: " + rating + ",\n specialFeatures: "
				+ specialFeatures + ",\n Actors: " + actors +"\n Description: " + description ;
	}




	

	
	
	
	
	
	
	
	
	
	
}