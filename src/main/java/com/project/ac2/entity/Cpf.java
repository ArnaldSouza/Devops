package com.project.ac2.entity;

import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public final class Cpf {
    
    private final String alunoCpf;

    protected Cpf() {
        this.alunoCpf = null;
    }

    public Cpf(String alunoCpf) {
        validarCpf(alunoCpf);
        this.alunoCpf = alunoCpf;
    }

    private void validarCpf(String cpf) {
        if (cpf == null || !cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")) {
            throw new IllegalArgumentException("Formato de CPF inválido");
        }
        if (!cpfValido(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    private boolean cpfValido(String cpf) {
        String numeros = cpf.replaceAll("\\D", "");

        if (numeros.length() != 11 || numeros.matches("(\\d)\\1{10}")) {
            return false;
        }

        int[] pesos1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesos2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        int primeiroDigito = calcularDigitoVerificador(numeros.substring(0, 9), pesos1);
        int segundoDigito = calcularDigitoVerificador(numeros.substring(0, 9) + primeiroDigito, pesos2);

        return numeros.endsWith("" + primeiroDigito + segundoDigito);
    }

    private int calcularDigitoVerificador(String base, int[] pesos) {
        int soma = 0;
        for (int i = 0; i < base.length(); i++) {
            soma += Character.getNumericValue(base.charAt(i)) * pesos[i];
        }
        int resto = soma % 11;
        return resto < 2 ? 0 : 11 - resto;
    }

    public String getAlunoCpf() {
        return alunoCpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cpf cpf = (Cpf) o;
        return Objects.equals(alunoCpf, cpf.alunoCpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alunoCpf);
    }
}
