package com.project.ac2.entity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.project.ac2.entity.Aluno;
import com.project.ac2.entity.Cpf;
import com.project.ac2.entity.Media;

public class AlunoTest {
	
	@Test
    void testSetAndGetValidCpf() {
        Aluno aluno = new Aluno();
        Cpf cpf = new Cpf("123.456.789-10");
        aluno.setCpf(cpf);
        
        assertEquals(cpf, aluno.getCpf());
    }
	
	@Test
    void testInvalidCpfThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cpf("123456789");
        });
    }
	

	@Test
    void testSetAndGetMediaValida() {
        Aluno al = new Aluno();
        Media media = new Media(8.5);
        al.setMedia(media);
        
        assertEquals(media, al.getMedia());
    }
	
	@Test
	void testMediaInvalidaThrowsException() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Media(11.0); // Média fora do intervalo 0-10
	    });
	}
	
	@Test
	void testMediaInvalidaThrowsException2() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Media(-1.0); // Média fora do intervalo 0-10
	    });
	}
	
	@Test
	void testMediaValorLimiteInferior() {
	    Media media = new Media(0.0);
	    assertEquals(0.0, media.getAlunoMedia());
	}

	@Test
	void testMediaValorLimiteSuperior() {
	    Media media = new Media(10.0);
	    assertEquals(10.0, media.getAlunoMedia());
	}

	@Test
	void testMediaNulaThrowsException() {
	    assertThrows(IllegalArgumentException.class, () -> new Media(null));
	}

	@Test
	void testMediaEquals() {
	    Media media1 = new Media(8.0);
	    Media media2 = new Media(8.0);
	    assertEquals(media1, media2);
	}

	@Test
	void testMediaNotEquals() {
	    Media media1 = new Media(8.0);
	    Media media2 = new Media(9.0);
	    assertNotEquals(media1, media2);
	}

	@Test
	void testMediaHashCode() {
	    Media media1 = new Media(8.0);
	    Media media2 = new Media(8.0);
	    assertEquals(media1.hashCode(), media2.hashCode());
	}
	
	@Test
	void testMediaDefaultConstructor() {
	    Media media = new Media(); // Usando o construtor padrão
	    assertNull(media.getAlunoMedia()); // Deve ser nulo inicialmente
	}

	@Test
	void testAtualizarMediaAluno() {
	    Aluno aluno = new Aluno();
	    Media mediaInicial = new Media(6.0);
	    aluno.setMedia(mediaInicial);

	    Media novaMedia = new Media(9.5);
	    aluno.setMedia(novaMedia);

	    assertEquals(novaMedia, aluno.getMedia());
	}

}
