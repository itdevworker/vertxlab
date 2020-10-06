package com.training.lab4;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import io.reactivex.rxjava3.core.Observable;

//Reactive Programming : Lab Assignment 4
public class ObservableStreamUpperCase {
	public static void main(String[] args) {
		List<Employee> empList = new CopyOnWriteArrayList<Employee>();
		
		Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Jonny");
        employee.setCity("Bangalore");
        empList.add(employee);
        employeeUpperCase(empList);
	}

	public static void employeeUpperCase(List<Employee> empList){
        Observable
	        .fromIterable(empList)
	        .map(employee -> {
	            return employee.getName().toUpperCase() + " " + employee.getCity().toUpperCase();
	        })
	        .subscribe(System.out::println, System.out::println, () -> System.out.println("complete"));
    }
}
