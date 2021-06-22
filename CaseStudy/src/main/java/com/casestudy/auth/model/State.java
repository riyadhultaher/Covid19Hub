package com.casestudy.auth.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String name;
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