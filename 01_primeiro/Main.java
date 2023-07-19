import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (exercicio()) {
            System.out.println("Deu certo");
        } else {
            System.out.println("Algo deu errado, verifique o log");
        }
    }

    /**
     * Método pra resolução do exercício 1.
     * Recebe um array de int, e printa
     * os pares em ordem crescente, depois
     * os ímpares em ordem decrescente.
     * 
     * @return true se deu tudo certo
     */
    private static boolean exercicio() {
        // self close por qualidade de vida
        try (Scanner scanner = new Scanner(System.in, Charset.defaultCharset())) {
            System.out.print("Tamanho do array: ");
            int tamanho = scanner.nextInt();
            while (tamanho <= 0) {
                System.out.print("Não é possível criar um array com tamanho negativo, insira o tamanho: ");
                tamanho = scanner.nextInt();
            }
            System.out.println("Digite um array de uint32: ");

            Integer[] input = new Integer[tamanho];
            ArrayList<Integer> pares = new ArrayList<Integer>();
            ArrayList<Integer> impares = new ArrayList<Integer>();
            for (int i = 0; i < tamanho; i++) {
                input[i] = scanner.nextInt();
                // validar não negativo
                while (input[i] < 0) {
                    System.out.print("Insira um número maior que zero: ");
                    input[i] = scanner.nextInt();
                }
                // ja adiciona agora pra evitar iteração desnecessária
                if (IsEven.isEvenInteger(input[i])) {
                    pares.add(Integer.valueOf(input[i]));
                } else {
                    impares.add(Integer.valueOf(input[i]));
                }
            }
            Integer[] paresArray = new Integer[pares.size()];
            Integer[] imparesArray = new Integer[impares.size()];

            Sort<Integer> organizador = new Sort<Integer>();
            Integer[] paresSortados = organizador.sortCrescending(pares.toArray(paresArray));
            Integer[] imparesSortados = organizador.sortDescrescending(impares.toArray(imparesArray));

            // separador
            System.out.println("\n---\n");

            for (int i = 0; i < paresSortados.length; i++) {
                System.out.println(paresSortados[i]);
            }
            for (int i = 0; i < imparesSortados.length; i++) {
                System.out.println(imparesSortados[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}