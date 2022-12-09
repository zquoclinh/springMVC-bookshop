package models;

import java.io.Serializable;


public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int parent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public Category(int id, String name, int parent) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
	}
	public Category() {
		super();
	}
	
	
}
