package com.training.lab5;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import io.reactivex.rxjava3.core.Observable;

//Reactive Programming : Lab Assignment 4
public class ObservableStreamOnsite {
	public static void main(String[] args) {
		List<Employee> empList = new CopyOnWriteArrayList<Employee>();
		
		Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Jonny");
        employee1.setCity("Bangalore");
        employee1.setOnsite(true);
        empList.add(employee1);
        
        Employee employee2 = new Employee();
        employee2.setId(1);
        employee2.setName("Ronny");
        employee2.setCity("Mumbai");
        employee2.setOnsite(true);
        empList.add(employee2);
        
        employeeUpperCase(empList);
	}

	public static void employeeUpperCase(List<Employee> empList){
        Observable
        .fromIterable(empList)
        .filter(employee -> {
        	if(employee.isOnsite()) {
        		System.out.println("filtering " + employee);
        		return employee != null;
        	}
			return false;
        })
        .map(employee -> {
        	return employee.getName().toUpperCase() + " " + employee.getCity().toUpperCase();
        })
        .subscribe(System.out::println, System.out::println, () -> System.out.println("complete"));
    }
}
