package entidades;

import java.time.LocalDateTime;

public class Consulta {
    private static int contadorId = 1; // ID inicial
    private int idConsulta;
    private String nomeNutricionista;
    private String nomePaciente;
    private LocalDateTime dataHora;
    private boolean consultaRealizada;

    // Construtors
    public Consulta(){}
    public Consulta(String nomeNutricionista, String nomePaciente, LocalDateTime dataHora, boolean consultaRealizada) {
        this.idConsulta = contadorId++;
        this.nomeNutricionista = nomeNutricionista;
        this.nomePaciente = nomePaciente;
        this.dataHora = dataHora;
        this.consultaRealizada = consultaRealizada;
    }

    // Getters e Setters
    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getNomeNutricionista() {
        return nomeNutricionista;
    }

    public void setNomeNutricionista(String nomeNutricionista) {
        this.nomeNutricionista = nomeNutricionista;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public boolean getConsultaRealizada() {
        return consultaRealizada;
    }

    public void setConsultaRealizada(boolean consulta) {
        this.consultaRealizada = consulta;
    }

    // Método para retornar uma string com as informações da consulta
    @Override
    public String toString() {
        String stringConsultaRealizada = consultaRealizada ? "Sim" : "Não";
        return "Consulta: " + getIdConsulta() +
                ", Nutricionista = " + getNomeNutricionista() +
                ", Paciente = " + getNomePaciente() +
                ", Data e Hora = " + getDataHora() +
                ", Consulta Realizada = " + stringConsultaRealizada;
    }
}
