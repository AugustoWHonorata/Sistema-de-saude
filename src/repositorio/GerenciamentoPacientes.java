package repositorio;

import entidades.Paciente;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoPacientes {

    private static List<Paciente> pacientes = new ArrayList<>();

    public static void listar() {
        if (pacientes == null || pacientes.size() == 0) {
            System.out.println("\n\nLista de pacientes vazia.\n\n");
        } else {
            System.out.println("\nPacientes:");
            for (Paciente paciente : pacientes) {
                System.out.printf("%d - %s;\n", paciente.getId(), paciente.getNome());
            }
        }
    }


    public static Paciente buscarPorId(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    public static void adicionar(Paciente paciente) {
        pacientes.add(paciente);
    }

    //Ex. 10 semana 02 modulo 02
    public static boolean remover(int id) {
        Paciente paciente = buscarPorId(id);
        if (paciente != null) {
            pacientes.remove(paciente);
            return true;
        }
        return false;
    }
    //Ex. 7 semana 02 moodulo 02
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
