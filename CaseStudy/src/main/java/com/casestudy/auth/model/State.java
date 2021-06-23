package com.casestudy.auth.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/*
 * This model represents one state that a user can have.
 * States can be added to a user's account via a list and
 * is connected to users with a ManyToMany relationship.
 * The state model has an id, a name, and an associated
 * hyperlink that takes the user to the website for that
 * respective state.
 */
@Entity
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String name;
	
	@Transient
	private String hyperlink;

	@ManyToMany(mappedBy = "states")
	private List<User> users = new ArrayList<User>();

	public State(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public State() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", name=" + name + "]";
	}
}