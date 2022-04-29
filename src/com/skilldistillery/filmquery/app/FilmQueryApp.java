package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) {
    FilmQueryApp app = new FilmQueryApp();
    app.test();
//    app.launch();
  }

  private void test() {
    Film film = db.findFilmById(1);
    System.out.println(film);
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
    
    
  }

  private void startUserInterface(Scanner input) {
	  
	  System.out.println("WELCOME TO THE FILM QUERY APP");
	  System.out.println("1.) Look up Film by its Id");
	  System.out.print("2.) Look up a film by a seach keyword");
	  
	  int choice = input.nextInt();
	  
	  
	  switch(choice) {
	  
	  case 1:
		  System.out.print("Input a film Id: ");
		  Scanner filmId = input.nextInt();
	  
	  }
    
    
  }

}
