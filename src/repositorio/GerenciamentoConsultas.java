package repositorio;

import entidades.Consulta;
import entidades.Nutricionista;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GerenciamentoConsultas {
    private static List<Consulta> consultas = new ArrayList<>(); // Certificar que a lista seja tipada corretamente

    // Método para listar todas as consultas
    public static String listarConsultas() {
        if (!consultas.isEmpty()) {
            System.out.println("==================== Consultas Agendadas ====================");
            for (Consulta consulta : consultas) {
                return consulta.toString();
            }
        }
        return "\nNão há Consultas Agendadas";
    }

    // Método para buscar uma consulta por ID (posição na lista)
    public static Consulta buscarConsultaPorId(int id) {
            for (Consulta consulta : consultas) {
                if (consulta.getIdConsulta() == id) {
                    return consulta;
                }
            }
            return null;
    }

    public static void realizarConsulta(int id){
        Consulta consulta = buscarConsultaPorId(id);
        if (consulta == null){
            System.out.println("\nConsulta não encontrada!");
            return;
        }
        consulta.setConsultaRealizada(true);
        System.out.println("\nConsulta Realizada!");
    }

    // Método para adicionar uma consulta
    public static void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
        // Incrementar o número de consultas do nutricionista
        Nutricionista nutricionista = GerenciamentoNutricionistas.buscarNutricionistaPorNome(consulta.getNomeNutricionista());
        if (nutricionista != null) {
            nutricionista.setNumeroConsultas(nutricionista.getNumeroConsultas() + 1);
        }
    }

    // Método para remover uma consulta por ID
    public static boolean removerConsulta(int id) {
        if (id >= 0 && id < consultas.size()) {
            consultas.remove(id);
            return true;
        }
        return false;
    }

    // Método para alterar uma consulta por ID (posição na lista)
    public static boolean alterarConsulta(int id, LocalDateTime novaDataHora, String novoNomeNutricionista, String novoNomePaciente, boolean novaConsultaRealizada) {
        Consulta consulta = buscarConsultaPorId(id);
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
