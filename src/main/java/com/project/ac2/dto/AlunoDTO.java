package com.project.ac2.dto;

import com.project.ac2.entity.Aluno;

public class AlunoDTO {
	
	private Long id;
	private String nomeAluno;
	private String Cpf;
	private Double media;
	
	public AlunoDTO() {}
	
	public AlunoDTO(Long id, String nomeAluno, String Cpf, Double media) {
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.Cpf = Cpf;
		this.media = media;
	}
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getnomeAluno() {
    	return nomeAluno;
    }
    
    public void setnomeAluno(String nomeAluno) {
    	this.nomeAluno = nomeAluno;
    }
    
    public String getCpf() {
    	return Cpf;
    }
    
    public void setCpf(String Cpf) {
    	this.Cpf = Cpf;
    }
    
    public Double getMedia() {
    	return media;
    }
    
    public void setMedia(Double media) {
    	this.media = media;
    }
    
    public static AlunoDTO fromEntity(Aluno aluno) {
    	AlunoDTO alunoDTO = new AlunoDTO();
    	alunoDTO.setId(aluno.getId());
    	alunoDTO.setnomeAluno(aluno.getnomeAluno());

        if (aluno.getCpf() != null) {
        	alunoDTO.setCpf(aluno.getCpf().getAlunoCpf());
        }
        
        if (aluno.getMedia() != null) {
        	alunoDTO.setMedia(aluno.getMedia().getAlunoMedia());
        }

        return alunoDTO;
    }
}
