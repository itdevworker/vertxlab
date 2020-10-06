package com.training.lab3;

import io.reactivex.rxjava3.core.Observable;

//Reactive Programming : Lab Assignment 3
public class ObservableStream {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Jonny");
        employee.setCity("Bangalore");

        //Publisher
        Observable<Employee> stream = Observable.create(subscriber -> {
            try {
                if (null != employee) {
                    subscriber.onNext(employee);
                    subscriber.onComplete();
                } else {
                    throw new RuntimeException("Employee not found");
                }
            } catch (Exception e) {
                subscriber.onError(e);
            }
        });

        //subscriber; listen for data,error,complete
        stream.subscribe(data -> System.out.println(data.id + " "+ data.name + " "+ data.city), err -> System.out.println(err), () -> {
            System.out.println("Completed");
        });
    }
}
