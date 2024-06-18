package repositorio;

import entidades.Funcionario;
import entidades.Paciente;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoPacientes {

    private static List<Paciente> pacientes = new ArrayList<>();

    public static void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public static boolean remover(int id) {
        Paciente paciente = buscarPorId(id);
        if (paciente != null) {
            pacientes.remove(paciente);
            return true;
        }
        return false;
    }


    public static String listarPacientes() {
        if (!pacientes.isEmpty()) {
            System.out.println("\n==================== Pacientes ====================");
            for (Paciente paciente : pacientes) {
                return paciente.toString();
            }
        }
        return "\nNão há Pacientes cadastrados.";
    }

    public static Paciente buscarPorId(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    public static Paciente buscarPacientePorNome(String nome){
        return  pacientes.stream()
                .filter(n -> n.getNome().equals(nome))
                .findFirst()
                .orElse(null);
    }


    public static boolean alterar(int id, double peso, double altura, String pressaoArterial, int frequenciaCardiaca, String dietaAlimentar, List<String> atividadesFisicas) {
        Paciente paciente = buscarPorId(id);
        if (paciente != null) {
            paciente.setPeso(peso);
            paciente.setAltura(altura);
            paciente.setPressaoArterial(pressaoArterial);
            paciente.setFrequenciaCardiaca(frequenciaCardiaca);
            paciente.setDietaAlimentar(dietaAlimentar);
            paciente.setAtividadesFisicas(atividadesFisicas);
            return true;
        }
        return false;
    }
}
