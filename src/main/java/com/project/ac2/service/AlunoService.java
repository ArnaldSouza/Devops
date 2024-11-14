package com.project.ac2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ac2.entity.Aluno;
import com.project.ac2.repository.Aluno_Repository;
import com.project.ac2.dto.AlunoDTO;

@Service
public class AlunoService {
	
	@Autowired
	private Aluno_Repository alunoRepository;
	
	public List<AlunoDTO> getAllUsers(){
		List<Aluno> alunos = alunoRepository.findAll();
		return alunos.stream()
                .map(AlunoDTO::fromEntity)
                .collect(Collectors.toList());
	}
}
