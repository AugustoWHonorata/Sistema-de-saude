package entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Nutricionista extends Funcionario {
    private List<String> certificacoes;
    private int numeroConsultas;
    private int tempoExperiencia;
    private static Set<String> nomesNutricionistas = new HashSet<>();

    // Construtors
    public Nutricionista(){ }
    public Nutricionista(String nome, int idade, Endereco endereco, double salario, List<String> certificacoes, int numeroConsultas, int tempoExperiencia) {
        super(nome, idade, endereco, salario);

        if (nomesNutricionistas.contains(nome)) {
            throw new IllegalArgumentException("O nome do nutricionista já existe.");
        }

        this.certificacoes = certificacoes != null ? new ArrayList<>(certificacoes) : new ArrayList<>();
        this.numeroConsultas = numeroConsultas;
        this.tempoExperiencia = tempoExperiencia;
        nomesNutricionistas.add(nome);
    }

    // Getters e Setters
    public List<String> getCertificacoes() {
        return certificacoes;
    }

    public void setCertificacoes(List<String> certificacoes) {
        this.certificacoes = certificacoes;
    }

    public int getNumeroConsultas() {
        return numeroConsultas;
    }

    public void setNumeroConsultas(int numeroConsultas) {
        this.numeroConsultas = numeroConsultas;
    }

    public int getTempoExperiencia() {
        return tempoExperiencia;
    }

    public void setTempoExperiencia(int tempoExperiencia) {
        this.tempoExperiencia = tempoExperiencia;
    }

    public void adicionarTempoDeExperiencia(){
        this.tempoExperiencia += 1;
        System.out.printf("Tempo experiência adicionado, tempo de experiência = %d", this.tempoExperiencia);
    }

    public void adicionarCertificacao(String certificacao) {
        if (certificacao != null && !certificacao.trim().isEmpty()) {
            this.certificacoes.add(certificacao);
        } else {
            throw new IllegalArgumentException("Certificação inválida.");
        }
    }

    // Método para retornar uma string com as informações do nutricionista
    @Override
    public String toString() {
        return "Nutricionista: " + getNome() + ", Idade: " + getIdade() + ", Salário: " + getSalario() + ", " + getEndereco().toString()
                + ", Certificações: " + certificacoes + ", Número de Consultas: " + numeroConsultas + ", Tempo de Experiência: " + tempoExperiencia + " anos";
    }
}

