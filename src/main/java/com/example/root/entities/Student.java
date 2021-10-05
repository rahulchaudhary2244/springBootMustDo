package com.example.root.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private float testscore;

	public Student() {
	}

	public Student(String name, float testscore) {
		this.name = name;
		this.testscore = testscore;
	}

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

	public float gettestscore() {
		return testscore;
	}

	public void settestscore(float testscore) {
		this.testscore = testscore;
	}
}
