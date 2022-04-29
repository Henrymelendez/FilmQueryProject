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

		String sqlStatement = "SELECT * FROM film WHERE id = ?;";
		Connection conn = DriverManager.getConnection(URL, user, password);
		PreparedStatement statement = conn.prepareStatement(sqlStatement);
		statement.setInt(1, filmId);
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
		
		int id = rs.getInt("id");
		String title = rs.getString("title");
		String description = rs.getString("description");
		short releaseYear = rs.getShort("release_year");
		int languageId = rs.getInt("release_year");
		int rentalDuration = rs.getInt("rental_duration");
		double rentalRate = rs.getDouble("rental_rate");
		int length = rs.getInt("length");
		double replacementCost = rs.getDouble("replacement_cost");
		String rating = rs.getString("rating");
		String specialFeatures = rs.getString("special_features");
		
		
		movie = new Film(id, title, releaseYear, languageId, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures);
		
		movie.setActors(findActorsByFilmId(filmId));
		
		}
		
		rs.close();
		statement.close();
		conn.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return movie;
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
			int id = rs.getInt("id");
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
	
		return actor;
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
			int id = rs.getInt("id");
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
				
		
		
		
		
		return actors;
	}

}
