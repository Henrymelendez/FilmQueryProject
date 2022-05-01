package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;



import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
    app.launch();
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

		boolean keepGoing = true;

		do {

			System.out.println("WELCOME TO THE FILM QUERY APP");
			System.out.println("1.) Look up Film by its Id");
			System.out.println("2.) Look up a film by a search keyword");
			System.out.println("3.) Exit the application");
			System.out.print("Enter A Choice: ");
			int choice = input.nextInt();

			switch (choice) {

			case 1:
				System.out.print("Input a film Id: ");
				int filmId = input.nextInt();
				Film a = db.findFilmById(filmId);
				if (a == null) {
					System.out.println("Sorry There is No Film by that Number!!");
				}
				
				
				System.out.println();
				System.out.println(a);
				System.out.println();
				System.out.println("Do you want details on the film ?");
				System.out.println("1.) To view details ");
				System.out.println("2.) Return to main menu");
				System.out.print("Enter a choive: ");
				int submenu = input.nextInt();
				if(submenu == 1) {
					System.out.println();
					System.out.println(a.PrintDetails());
					System.out.println();
				}
				else {
					System.out.println();
					break;
				}
				
				
				break;
			case 2:
				input.nextLine();
				System.out.println("Enter an a keyword: ");
				String keyword = input.nextLine();
				List<Film> lookUp = db.findLikeWord(keyword);
				if(lookUp == null) {
					System.out.println("sorry that fill doesnt exist");
				}
				for(Film list : lookUp) {
					System.out.println(list);
				}
				System.out.println();
				break;

			case 3:
				keepGoing = false;
				break;
				
			default :
				System.out.println("Invalid Choice Try again");
			}
			

		} while (keepGoing == true);
		
		input.close();
	}
	

}
