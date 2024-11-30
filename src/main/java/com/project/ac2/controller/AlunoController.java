package com.project.ac2.controller;	

import com.project.ac2.service.AlunoService;
import com.project.ac2.dto.AlunoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.project.ac2", "com.project.ac2.controller"})
@RestController
@CrossOrigin
@RequestMapping("/api")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/alunos")
	public List<AlunoDTO> getAlunos(){
		return alunoService.getAllUsers();
	}
}
