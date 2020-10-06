package com.training.lab5;

public class Employee {
    public int id;
    public String name;
    public String city;
    public boolean onsite;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

	public boolean isOnsite() {
		return onsite;
	}

	public void setOnsite(boolean onsite) {
		this.onsite = onsite;
	}
}
