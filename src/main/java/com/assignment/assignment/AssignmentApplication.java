package com.assignment.assignment;

import com.assignment.assignment.model.Employee;
import com.assignment.assignment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class AssignmentApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeRepository.deleteAll();

		employeeRepository.save(new Employee( UUID.randomUUID().toString(), "a", 438473847, "a@gmail.com", null, "https://a.com"));
		employeeRepository.save(new Employee( UUID.randomUUID().toString(), "b", 423473847, "b@gmail.com", null, "https://b.com"));
		employeeRepository.save(new Employee( UUID.randomUUID().toString(), "c", 423472147, "c@gmail.com", null, "https://c.com"));
		employeeRepository.save(new Employee( UUID.randomUUID().toString(), "d", 423472147, "d@gmail.com", null, "https://d.com"));
		employeeRepository.save(new Employee( UUID.randomUUID().toString(), "e", 423472147, "e@gmail.com", null, "https://e.com"));

		System.out.println("Initial data saved!");
	}
}
