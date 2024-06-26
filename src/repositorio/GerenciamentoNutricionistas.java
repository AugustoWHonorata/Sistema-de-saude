package repositorio;
import entidades.Nutricionista;
import java.util.ArrayList;
import java.util.List;

public class GerenciamentoNutricionistas {
    private static List<Nutricionista> nutricionistas = new ArrayList<>();

    public static String listarNutricionistas() {
        if (!nutricionistas.isEmpty()) {
            System.out.println("==================== Nutricionistas ====================");
            for (Nutricionista nutricionista : nutricionistas) {
                return nutricionista.toString();
            }
        }
        return "\nNão há Nutricionistas cadastrados";
    }

    public static Nutricionista buscarNutricionistaPorId(int id) {
        for (Nutricionista n : nutricionistas) {
            if (n.getId() == id) {
                return n;
            }
        }
        return null;
    }

    public static Nutricionista buscarNutricionistaPorNome(String nome){
        return  nutricionistas.stream()
                .filter(n -> n.getNome().equals(nome))
                .findFirst()
                .orElse(null);
    }



    public static void adicionarNutricionista(Nutricionista nutricionista) {
        nutricionistas.add(nutricionista);
    }

    public static boolean removerNutricionista(int id) {
        return nutricionistas.removeIf(n -> n.getId() == id);
    }

    public static boolean alterarNutricionista(int id, Nutricionista nutricionistaAlterado) {
        for (int i = 0; i < nutricionistas.size(); i++) {
            if (nutricionistas.get(i).getId() == id) {
                nutricionistas.set(i, nutricionistaAlterado);
                return true;
            }
        }
        return false;
    }
}
