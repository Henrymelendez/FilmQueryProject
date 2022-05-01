package com.skilldistillery.filmquery.entities;

import java.util.Objects;

public class Inventory {
	private String condition;
	private Integer count;
	
	
	
	public Inventory() {
		
	}
	
	



	public Inventory(String condition, Integer count) {
		super();
		this.condition = condition;
		this.count = count;
	}





	public String getCondition() {
		return condition;
	}



	public void setCondition(String condition) {
		this.condition = condition;
	}



	public Integer getCount() {
		return count;
	}



	public void setCount(Integer count) {
		this.count = count;
	}



	@Override
	public int hashCode() {
		return Objects.hash(condition, count);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		return Objects.equals(condition, other.condition) && Objects.equals(count, other.count);
	}



	@Override
	public String toString() {
		return "\n condition: " + condition + ", Amount of Flims: " + count + " ";
	}
	
	
	
	

}
