package com.example.repotest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.entity.Customer;

import com.example.repository.CustomerRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CustomerReopsitoryTest {

	@Autowired
	private CustomerRepository repository;
		
	@Test
	@Rollback(false)
	public void TestCustomer(){
			Customer customer =new Customer(1, "S@gmail.com", "F", "Shivani", null);
			Customer saveCustomer =repository.save(customer);
			repository.save(customer);
			
			assertNotNull(saveCustomer);
			
		}
	
	@Test
	@Rollback(false)
	void TestUpdateCustomer() {
		Customer customer =new Customer(3, "Divya@gmail.com", "F", "Divya", null);
		Customer saveCustomer =repository.save(customer);
		repository.save(customer);
		
		assertNotNull(saveCustomer);	
	}
	
	
}

