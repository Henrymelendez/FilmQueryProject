package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.Inventory;

public class DatabaseAccessorObject implements DatabaseAccessor {
	public static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private String user = "student";
	private String password = "student";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film movie = null;
		
		try {

		String sqlStatement = "SELECT film.id, film.title, film.description, film.release_year, language.name, film.rental_duration, film.rental_rate, film.length, film.replacement_cost, film.rating, film.special_features, category.name\n"
				+ "FROM film\n"
				+ "JOIN language ON film.language_id = language.id\n"
				+ "JOIN film_category ON film.id = film_category.film_id\n"
				+ "JOIN category ON film_category.category_id = category.id WHERE film.id = ?;";
		Connection conn = DriverManager.getConnection(URL, user, password);
		PreparedStatement statement = conn.prepareStatement(sqlStatement);
		statement.setInt(1, filmId);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
		
		Integer id = rs.getInt("id");
		String title = rs.getString("title");
		String description = rs.getString("description");
		Short releaseYear = rs.getShort("release_year");
		String language = rs.getString("language.name");
		Integer rentalDuration = rs.getInt("rental_duration");
		Double rentalRate = rs.getDouble("rental_rate");
		Integer length = rs.getInt("length");
		Double replacementCost = rs.getDouble("replacement_cost");
		String rating = rs.getString("rating");
		String specialFeatures = rs.getString("special_features");
		String category = rs.getString("category.name");
		
		
		movie = new Film(id, title, description, releaseYear, language, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, category);
		
		movie.setActors(findActorsByFilmId(filmId));
		
		movie.setInventory(getFilmInvetoryById(filmId));
		
		}
		
		rs.close();
		statement.close();
		conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		if(movie == null) {
			return null;
		}else {
			
			return movie;
		}
		
	}
	
	
	
	

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		
		try {
			String sqlStatement = "SELECT id, first_name, last_name FROM actor WHERE id = ?; ";
			Connection conn = DriverManager.getConnection(URL, user, password);
			PreparedStatement pStatement = conn.prepareStatement(sqlStatement);
			pStatement.setInt(1, actorId);
			ResultSet rs = pStatement.executeQuery();
			
			while (rs.next()) {
			Integer id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			
			actor = new Actor(id, firstName, lastName);
			}
			rs.close();
			pStatement.close();
			conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(actor == null) {
			return null;
			
		}else {
	
		return actor;
		}
	}
	
	

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		
		List<Actor> actors = new ArrayList<Actor>();
		
		String sql = "SELECT actor.id, first_name, last_name FROM actor JOIN film_actor ON acto";
				sql+= "r.id = film_actor.actor_id JOIN film ON film_actor.film_id = film.id WHERE film.";
				sql+= "id = ?;";
		try {
			Connection conn = DriverManager.getConnection(URL,user,password);
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, filmId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
			Integer id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			
			Actor nn = new Actor(id, firstName, lastName);
			actors.add(nn);
			}
			
			rs.close();
			statement.close();
			conn.close();
		
			
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
				
		if(actors.isEmpty()) {
			
			return null;
		}
		else {
			return actors;
			
		}
		
		
		
	}
	
	@Override
	public List<Film> findLikeWord(String word) {
		List<Film> result = new ArrayList<Film>();
		
		String sql = "SELECT film.id, film.title, film.description, film.release_year, language.name, film.rental_duration, film.rental_rate, film.length, film.replacement_cost, film.rating, film.special_features, category.name\n"
				+ "FROM film\n"
				+ "JOIN language ON film.language_id = language.id\n"
				+ "JOIN film_category ON film.id = film_category.film_id\n"
				+ "JOIN category ON film_category.category_id = category.id\n"
				+ "WHERE title LIKE ? OR description LIKE ? ;";
		
		try {
			Connection conn = DriverManager.getConnection(URL,user,password);
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%" + word + "%");
			statement.setString(2, "%" + word + "%");
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				Short releaseYear = rs.getShort("release_year");
				String language = rs.getString("name");
				Integer rentalDuration = rs.getInt("rental_duration");
				Double rentalRate = rs.getDouble("rental_rate");
				Integer length = rs.getInt("length");
				Double replacementCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String specialFeature = rs.getString("special_features");
				String category = rs.getString("category.name");
				
				
				Film res = new Film(id, title, description, releaseYear, language, rentalDuration, rentalRate, length, replacementCost, rating, specialFeature, category);
				res.setActors(findActorsByFilmId(id));
				result.add(res);
		
			}
			
			rs.close();
			statement.close();
			conn.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		if(result.isEmpty()) {
			return null;
		} else {
			return result;
			
		}

	}

	public List<Inventory> getFilmInvetoryById(int filmId){
		
		List<Inventory> inventory = new ArrayList<>();
		
		String sql = "SELECT media_condition, COUNT(film_id) AS \"Inventory\" "
				+ "FROM inventory_item WHERE film_id = ?"
				+ " GROUP BY media_condition;";
		
		try {
			Connection conn = DriverManager.getConnection(URL, user, password);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String condition = rs.getString("media_condition");
				Integer count = rs.getInt("Inventory");
				
				Inventory stock = new Inventory(condition, count);
				
				inventory.add(stock);
				
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(inventory.isEmpty()) {
			return null;
		} else {
			
			return inventory;
		}
		
		
	}




	
	
	
	

}
