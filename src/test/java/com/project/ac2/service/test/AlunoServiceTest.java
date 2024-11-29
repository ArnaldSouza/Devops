package com.project.ac2.service.test;

import com.project.ac2.dto.AlunoDTO;
import com.project.ac2.entity.Aluno;
import com.project.ac2.entity.Cpf;
import com.project.ac2.entity.Media;
import com.project.ac2.repository.Aluno_Repository;
import com.project.ac2.service.AlunoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AlunoServiceTest {
	
	@Mock
	private Aluno_Repository alunoRepository;
	
	@InjectMocks
	private AlunoService alunoService;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testGetAllUsers() {
		
		Aluno aluno1 = new Aluno();
		aluno1.setId(1L);
		aluno1.setnomeAluno("Aluno teste 1");
		aluno1.setCpf(new Cpf("123.456.789-09"));
		aluno1.setMedia(new Media(10.0));
		
		Aluno aluno2 = new Aluno();
		aluno2.setId(2L);
		aluno2.setnomeAluno("Aluno teste 2");
		aluno2.setCpf(new Cpf("397.705.138-57"));
		aluno2.setMedia(new Media(0.0));
		
		when(alunoRepository.findAll()).thenReturn(Arrays.asList(aluno1, aluno2));
		
		List<AlunoDTO> alunos = alunoService.getAllUsers();
		
		assertEquals(2, alunos.size());
		assertEquals("Aluno teste 1", alunos.get(0).getnomeAluno());
		assertEquals("123.456.789-09", alunos.get(0).getCpf());
		assertEquals(10.0, alunos.get(0).getMedia());
	}
	
}
