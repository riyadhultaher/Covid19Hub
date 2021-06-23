package com.casestudy.auth.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/*
 * The user model represents one individual user in
 * the database. The user can add states to their account
 * in order to navigate to that respective state's website.
 * This is mapped with a ManyToMany relationshup with the
 * state model. The user model consists of an id, a username,
 * a password, and password confirm which does not persist in
 * the database.
 */
@Entity
//@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String username;

	private String password;

	@Transient
	private String passwordConfirm;

	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "state_id"))
	private List<State> states = new ArrayList<State>();

	public User(Long id, String username, String password, String passwordConfirm, ArrayList<State> states) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.states = states;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(ArrayList<State> states) {
		this.states = states;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", passwordConfirm="
				+ passwordConfirm + ", states=" + states + "]";
	}
}