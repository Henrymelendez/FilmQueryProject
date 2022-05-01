# FilmQueryProject


## Description 
An Application that returns film information 

## Technologies / Skills Used

* Eclipse
* MySQL
* DAO Design
* J Unit
* Maven 
* Array Lists
* Classes
* Abstraction
* Encapsulation
* Polymorphism
* Inheritance 
* Interface
* Exceptions
* try / catch
* Hashcode / Equals
* Scanner

## User Stories

##### User Story 1
The user is presented with a menu in which they can choose to:

Look up a film by its id.
Look up a film by a search keyword.
Exit the application.

##### User Story 2
If the user looks up a film by id, they are prompted to enter the film id. If the film is not found, they see a message saying so. If the film is found, its title, year, rating, and description are displayed.

##### User Story 3
If the user looks up a film by search keyword, they are prompted to enter it. If no matching films are found, they see a message saying so. Otherwise, they see a list of films for which the search term was found anywhere in the title or description, with each film displayed exactly as it is for User Story 2.

##### User Story 4
When a film is displayed, its language (English,Japanese, etc.) is also displayed.

##### User Story 5
When a film is displayed, the list of actors in its cast is displayed along with the title, year, rating, and description.

## Stretch Goals

##### Goal 1
When a film is displayed, the user can choose from a submenu whether to:

Return to the main menu.
View all film details.
If they choose to view all details, they will see all column values of the film record they chose.

##### Goal 2
When viewing film details, the user will see a list of all the film's categories (Family, Comedy, etc.) for the film.

##### Goal 3
When viewing film details, the user will see a list of all copies of the film in inventory, with their condition.

##### Goal 4
Write JUnit tests for DatabaseAccessorObject's methods.


## Installation

Use Mysql database server [MAMP](https://www.mamp.info) to install MAMP basic not pro

next set up your zhrc files in your text editor 

```bash 
atom .zhrc 
```
Next set up your cnf file
 
```bash 
/etc/my.cnf
```

after your setup go to preferences and un check everything but start server in the general tab
and in the ports tab set the ports to 8080 & 3306 once finished restart your MAMP server.


Next log into Mysql:  

~~~~Mysql

$> mysql -u root -p
~~~~

Setup and use the Sakila Database with the following command:

```bash
mysql> SOURCE C:/temp/sakila-db/sakila-schema.sql;
mysql> SOURCE C:/temp/sakila-db/sakila-data.sql;
mysql> USE sakila;
```

now download the project into you projects in you favorite IDE
and hit run

## Lessons Learned 

The project was simple the sql queries were not too complicated the main challenge was ensuring i kept a DAO design and my methods did not return primative types or their coresponding wrapper classes. The one thing i wish i had done was separate the queries into seperate classes to make the queries a little faster.



