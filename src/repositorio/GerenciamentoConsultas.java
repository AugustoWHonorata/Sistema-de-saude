package repositorio;

import entidades.Consulta;
import entidades.Nutricionista;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GerenciamentoConsultas {
    private static List<Consulta> consultas = new ArrayList<>(); // Certificar que a lista seja tipada corretamente

    // Método para listar todas as consultas
    public static void listar() {
        for (Consulta consulta : consultas) {
            System.out.println("Data e Hora: " + consulta.getDataHora() +
                    ", Nutricionista: " + consulta.getNomeNutricionista() +
                    ", Paciente: " + consulta.getNomePaciente());
        }
    }

    // Método para buscar uma consulta por ID (posição na lista)
    public static Consulta buscarPorId(int id) {
        if (id >= 0 && id < consultas.size()) {
            return consultas.get(id);
        }
        return null;
    }

    // Método para adicionar uma consulta
    public static void adicionar(Consulta consulta) {
        consultas.add(consulta);
        // Incrementar o número de consultas do nutricionista
        Nutricionista nutricionista = Nutricionista.buscarNutricionistaPorNome(consulta.getNomeNutricionista());
        if (nutricionista != null) {
            nutricionista.setNumeroConsultas(nutricionista.getNumeroConsultas() + 1);
        }
    }

    // Método para remover uma consulta por ID (posição na lista)
    public static boolean remover(int id) {
        if (id >= 0 && id < consultas.size()) {
            consultas.remove(id);
            return true;
        }
        return false;
    }

    // Método para alterar uma consulta por ID (posição na lista)
    public static boolean alterar(int id, LocalDateTime novaDataHora, String novoNomeNutricionista, String novoNomePaciente, boolean novaConsultaRealizada) {
        Consulta consulta = buscarPorId(id);
        if (consulta != null) {
            consulta.setDataHora(novaDataHora);
            consulta.setNomeNutricionista(novoNomeNutricionista);
            consulta.setNomePaciente(novoNomePaciente);
            consulta.setConsultaRealizada(novaConsultaRealizada);
            return true;
        }
        return false;
    }



}
