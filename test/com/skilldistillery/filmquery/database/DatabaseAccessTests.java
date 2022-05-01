package com.skilldistillery.filmquery.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mysql.cj.exceptions.DataConversionException;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;
import com.skilldistillery.filmquery.entities.Inventory;

class DatabaseAccessTests {
  private DatabaseAccessor db;

  @BeforeEach
  void setUp() throws Exception {
    db = new DatabaseAccessorObject();
  }

  @AfterEach
  void tearDown() throws Exception {
    db = null;
  }

  @Test
  void test_getFilmById_with_invalid_id_returns_null() {
    Film f = db.findFilmById(-42);
    assertNull(f);
  }
  
  @Test
  void test_findActorById_with_invalid_id_returns_null() {
	  
	  Actor a = db.findActorById(-42);
	  assertNull(a);
	  
  }
  
  @Test
  void test_findActorsByFilmId_with_invalid_id_returns_null() {
	  
	  List<Actor> a = db.findActorsByFilmId(-42);
	  assertNull(a);
  }
  
  @Test
  @DisplayName("Test Film inventory by Id Method with invalid id returns null")
  void test_getFilmInvetoryById() {
	  
	  List<Inventory> inventory = db.getFilmInvetoryById(-42);
	  assertNull(inventory);
	  
  }
  
  @Test
  @DisplayName("Test findLikeWord method with invalid input to return null")
  void test_findLikeWord() {
	  List<Film> keyword = db.findLikeWord("#");
	  assertNull(keyword);
  }
  
  
  
  

}
