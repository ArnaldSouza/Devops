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
	
	//testes cpf
	@Test
    void testSetAndGetValidCpf() {
        Aluno aluno = new Aluno();
        Cpf cpf = new Cpf("123.456.789-09");
        aluno.setCpf(cpf);
        
        assertEquals(cpf, aluno.getCpf());
    }

    @Test
    void testCpfValido() {
        Cpf cpf = new Cpf("123.456.789-09");
        assertEquals("123.456.789-09", cpf.getAlunoCpf());
    }

    @Test
    void testCpfInvalidoFormato() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cpf("12345678909");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Cpf("123.456-78909"); 
        });
    }

    @Test
    void testCpfInvalidoComDigitosIguais() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cpf("111.111.111-11"); // CPF com todos os dígitos iguais
        });
    }

    @Test
    void testCpfInvalidoDigitosVerificadores() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cpf("123.456.789-00"); // CPF com dígitos verificadores errados
        });
    }

    @Test
    void testCpfNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cpf(null); // CPF nulo
        });
    }

    @Test
    void testCpfValidoComPontosEHifen() {
        Cpf cpf = new Cpf("987.654.321-00"); // CPF válido com formato correto
        assertEquals("987.654.321-00", cpf.getAlunoCpf());
    }

    @Test
    void testCpfComApenasNumeros() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cpf("98765432100"); // CPF com apenas números, sem pontuação
        });
    }

    @Test
    void testCpfComCaracteresEspeciais() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cpf("987.654@321-00"); // CPF com caracteres especiais
        });
    }

    @Test
    void testCpfComEspacosEmBranco() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cpf(" 123.456.789-10 "); // CPF com espaços extras
        });
    }

    @Test
    void testCpfComTamanhoIncorreto() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cpf("123.456.78-10"); // CPF com tamanho incorreto
        });
    }

    @Test
    void testCpfComMenosDeOnzeDigitos() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cpf("123.456.78-00"); // CPF com menos de 11 dígitos
        });
    }

    @Test
    void testCpfComMaisDeOnzeDigitos() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cpf("123.456.789-100"); // CPF com mais de 11 dígitos
        });
    }
    
    @Test
    void testEqualsWithEqualCpfs() {
        Cpf cpf1 = new Cpf("123.456.789-09");
        Cpf cpf2 = new Cpf("123.456.789-09");

        assertEquals(cpf1, cpf2); // Deve retornar true, pois os CPFs são iguais
    }

    @Test
    void testEqualsWithDifferentCpfs() {
        Cpf cpf1 = new Cpf("123.456.789-09");
        Cpf cpf2 = new Cpf("459.810.398-17");

        assertNotEquals(cpf1, cpf2); // Deve retornar false, pois os CPFs são diferentes
    }

    @Test
    void testEqualsWithDifferentClass() {
        Cpf cpf = new Cpf("123.456.789-09");
        String outroObjeto = "123.456.789-09"; 

        assertNotEquals(cpf, outroObjeto);
    }

    @Test
    void testEqualsWithSameObject() {
        Cpf cpf = new Cpf("123.456.789-09");

        assertEquals(cpf, cpf); 
    }

    @Test
    void testHashCodeWithEqualCpfs() {
        Cpf cpf1 = new Cpf("123.456.789-09");
        Cpf cpf2 = new Cpf("123.456.789-09");

        assertEquals(cpf1.hashCode(), cpf2.hashCode()); 
    }

    @Test
    void testHashCodeWithDifferentCpfs() {
        Cpf cpf1 = new Cpf("123.456.789-09");
        Cpf cpf2 = new Cpf("459.810.398-17");

        assertNotEquals(cpf1.hashCode(), cpf2.hashCode()); 
    }
    
    //testes media
	

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
