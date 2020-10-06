package com.training.lab2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//Functional Programming : Lab Assignment 2
@FunctionalInterface
interface Helper<T> {
    void handle();
}

class CustomerHelper {
    public void apiCaller(Helper<String> helper) {
        helper.handle();
    }
}

class Repository {
	List<Customer> custList = new CopyOnWriteArrayList<Customer>();
	
	public void save(Customer customer) {
        custList.add(customer);
        System.out.println("save - Customer Saved: " + customer);
    }
 
	public void findById(int id) {
		custList.stream().forEach(cust -> {
			 if (cust.getId() == id) {
				 System.out.println("findById - Customer Found: " + cust);
             } else {
            	 System.out.println("findById - Customer not found");
             }
		});
    }
 
	public void findAll() {
		custList.stream().forEach(cust -> {
			 if (!custList.isEmpty() && custList.size() > 0) {
				 System.out.println("findAll - Customer List: " + custList);
            } else {
           	 	System.out.println("findAll - Customer List is Empty");
            }
		});
    }

    public void remove(int id) {
    	custList.stream().forEach(cust -> {
			if (!custList.isEmpty() && custList.size() > 0 && cust != null && cust.getId() == id) {
				 custList.remove(custList.indexOf(cust));
				 System.out.println("remove - Customer Removed from Customer List: " + cust);
           } else {
          	 	System.out.println("remove - Customer not found");
           }
		});
    }
}

public class CustomerManagerApp {
    public static void main(String[] args) {
        CustomerHelper customerHelper = new CustomerHelper();
        Repository repository = new Repository();
        List<Customer> custList = new CopyOnWriteArrayList<Customer>();
        
        //customer
        Customer cust1 = new Customer();
        cust1.setId(1);
        cust1.setFirstName("Ramesh");
        cust1.setLastName("Patel");
        cust1.setCity("Bangalore");
        custList.add(cust1);
        
        Customer cust2 = new Customer();
        cust2.setId(2);
        cust2.setFirstName("John");
        cust2.setLastName("Purohit");
        cust2.setCity("Mumbai");
        custList.add(cust2);
        
        //save
        customerHelper.apiCaller(() -> {
        	repository.save(cust1);
        	repository.save(cust2);
        });
        
        //findById
        customerHelper.apiCaller(() -> {
        	repository.findById(1);
            //System.out.println(res);
        });
        
        //findAll
        customerHelper.apiCaller(() -> {
        	repository.findAll();
            //System.out.println(res);
        });
        
        //remove
        customerHelper.apiCaller(() -> {
        	repository.remove(1);
            //System.out.println(res);
        });
    }
}
