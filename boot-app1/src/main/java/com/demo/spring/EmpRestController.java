package com.demo.spring;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;

@RestController
public class EmpRestController {

	/*
	 * static HashMap<Integer, Emp> empDb = new HashMap<>(); static {
	 * empDb.put(1000, new Emp(1000, "Scott", "London", 7500)); empDb.put(1001,
	 * new Emp(1001, "Scotts", "London", 7500)); empDb.put(1002, new Emp(1002,
	 * "Scottd", "London", 7500)); empDb.put(1003, new Emp(1003, "Scottf",
	 * "London", 7500)); empDb.put(1004, new Emp(1004, "Scottg", "London",
	 * 7500)); empDb.put(1005, new Emp(1005, "Scotth", "London", 7500)); }
	 */

	@Autowired
	EmpRepo empRepo;

	@RequestMapping(path = "/info", method = RequestMethod.GET)
	public String info() {
		return "This is spring RESTFUL Service";
	}

	@RequestMapping(path = "/greet/{name}", method = RequestMethod.GET)
	public String greet(@PathVariable("name") String name) {
		return "Hello " + name;
	}

	@RequestMapping(path = "/emp", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity getEmp(@RequestParam("id") int id) {
		Emp emp = empRepo.findOne(id);
		if (emp != null) {
			return ResponseEntity.ok(emp);
		} else {
			return ResponseEntity.ok("employee does not exist..");

		}
	}

	@RequestMapping(path = "/save", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity saveEmp(@RequestBody Emp e) {
		Emp e1 = empRepo.save(e);
		if (e1.getEmpId() == e.getEmpId()) {
			return ResponseEntity.ok("Emp Saved");
		} else {
			return ResponseEntity.ok("Emp not saved");
		}

	}

}
