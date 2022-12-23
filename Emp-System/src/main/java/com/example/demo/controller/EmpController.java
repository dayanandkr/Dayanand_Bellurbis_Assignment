package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Employee;
import com.example.demo.services.Emp_Service;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	@Autowired
	private Emp_Service service;
	
	@GetMapping("/")
	public String home(Model m) {
		
		List<Employee> emp =service.getAllEmp();
		m.addAttribute("emp",emp);
		
		return "index";
	}
	
	@GetMapping("/add_emp")
	public String Add_emp() {
		return "add_emp";
	}
	@PostMapping("/register")
	public String Emp_register(@ModelAttribute Employee e, HttpSession session) {
		
		service.addEmp(e);
		session.setAttribute("msg","Employee added successfully....");
		return "redirect:/";
		
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e=service.getEmpById(id);
		m.addAttribute("emp",e);
		
		return "edit";
	}
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		service.addEmp(e);
		session.setAttribute("msg", "Employee data updated successfully");
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {
		
		service.deleteEmp(id);
		session.setAttribute("msg", "Employee data deleted successfully");
		return "redirect:/";
	}

}
 