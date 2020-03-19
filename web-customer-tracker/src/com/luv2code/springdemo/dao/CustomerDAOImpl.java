package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<Customer> getCustomers() {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		// create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName", Customer.class);
		//execute query and get result list
		
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		
		
		return customers;
	}

    @Transactional
	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
		
	}

    @Transactional
	@Override
	public Customer getCUstomer(int theId) {
	
    	Session currentSesssion = sessionFactory.getCurrentSession();
    	
    	Customer theCustomer = currentSesssion.get(Customer.class, theId);
    	
    	return theCustomer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		Session currentSesssion = sessionFactory.getCurrentSession();
    	
    	Query theQuery = currentSesssion.createQuery("delete from Customer where id=:customerId");
    	
    	theQuery.setParameter("customerId", theId );
    	
    	theQuery.executeUpdate();
		
	}

}
