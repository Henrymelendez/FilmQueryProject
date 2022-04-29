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

		boolean keepGoing = true;

		do {

			System.out.println("WELCOME TO THE FILM QUERY APP");
			System.out.println("1.) Look up Film by its Id");
			System.out.println("2.) Look up a film by a search keyword");
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

				break;
			case 2:
				System.out.println("Enter an a keyword: ");
				String keyword = input.nextLine();

				break;

			}

		} while (keepGoing == true);

	}

}
