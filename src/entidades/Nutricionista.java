package entidades;

import java.util.ArrayList;
import java.util.List;
import repositorio.GerenciamentoNutricionistas;

public class Nutricionista extends Funcionario {
    private List<String> certificacoes;
    private int numeroConsultas;
    private int tempoExperiencia;

    // Construtors
    public Nutricionista(){ }
    public Nutricionista(int id, String nome, int idade, Endereco endereco, double salario, List<String> certificacoes, int numeroConsultas, int tempoExperiencia) {
        super(id, nome, idade, endereco, salario);

        if (GerenciamentoNutricionistas.listarNutricionistas().contains(this)) {
            throw new IllegalArgumentException("O nutricionista já existe.");
        }
        this.certificacoes = certificacoes != null ? new ArrayList<>(certificacoes) : new ArrayList<>();
        this.numeroConsultas = numeroConsultas;
        this.tempoExperiencia = tempoExperiencia;
        GerenciamentoNutricionistas.adicionarNutricionista(this);
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

    @Override
    public String toString() {
        return "Nutricionista: " + getNome() + ", Idade: " + getIdade() + ", Salário: " + getSalario() + ", " + getEndereco().toString()
                + ", Certificações: " + certificacoes + ", Número de Consultas: " + numeroConsultas + ", Tempo de Experiência: " + tempoExperiencia + " anos";
    }
}

