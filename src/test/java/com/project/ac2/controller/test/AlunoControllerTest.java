package com.project.ac2.controller.test;

import com.project.ac2.controller.AlunoController;
import com.project.ac2.dto.AlunoDTO;
import com.project.ac2.service.AlunoService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AlunoController.class)
public class AlunoControllerTest {

		@Autowired
		private MockMvc mockMvc;
		
		@MockBean
		private AlunoService alunoService;
		
		@Test
		public void testGetAlunos() throws Exception{
			
			AlunoDTO mockAluno = new AlunoDTO();
			mockAluno.setId(1L);
			mockAluno.setnomeAluno("Joe");
			mockAluno.setCpf("123.456.789-10");
			mockAluno.setMedia(7.5);
			
			List<AlunoDTO> mockAlunos = List.of(mockAluno);
			Mockito.when(alunoService.getAllUsers()).thenReturn(mockAlunos);
			
			mockMvc.perform(MockMvcRequestBuilders.get("/api/alunos")
			        .accept(MediaType.APPLICATION_JSON))
			        .andExpect(status().isOk())
			        .andExpect(jsonPath("$[0].nomeAluno").value("Joe"))
			        .andExpect(jsonPath("$[0].cpf").value("123.456.789-10"))
			        .andExpect(jsonPath("$[0].media").value(7.5)); 
		}
		
}
