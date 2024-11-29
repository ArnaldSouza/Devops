package com.project.ac2.DTO.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.project.ac2.dto.AlunoDTO;

public class AlunoDTOTest {

    @Test
    void testGettersAndSetters() {
        AlunoDTO alunoDTO = new AlunoDTO();

        alunoDTO.setId(1L);
        alunoDTO.setnomeAluno("João");
        alunoDTO.setCpf("123.456.789-09");
        alunoDTO.setMedia(8.5);

        assertEquals(1L, alunoDTO.getId());
        assertEquals("João", alunoDTO.getnomeAluno());
        assertEquals("123.456.789-09", alunoDTO.getCpf());
        assertEquals(8.5, alunoDTO.getMedia());
    }
    
    @Test
    void testConstructorParametrized() {
        
        Long id = 1L;
        String nomeAluno = "Ana";
        String cpf = "123.456.789-09";
        Double media = 9.5;
        
        AlunoDTO alunoDTO = new AlunoDTO(id, nomeAluno, cpf, media);

        assertEquals(id, alunoDTO.getId());
        assertEquals(nomeAluno, alunoDTO.getnomeAluno());
        assertEquals(cpf, alunoDTO.getCpf());
        assertEquals(media, alunoDTO.getMedia());
    }
}

