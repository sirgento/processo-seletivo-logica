import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (exercicio()) {
            System.out.println("Deu certo");
        } else {
            System.out.println("Algo deu errado, verifique o log");
        }
    }

    private static boolean exercicio() {

        Integer k; // alvo
        Integer n; // tamanho do vetor
        Integer numeroPares = 0;
        Integer[] arr;
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Informe o tamanho do vetor: ");
            n = scanner.nextInt();
            while (n <= 0) {
                System.out.print("O tamanho vetor não pode ser negativo: ");
                n = scanner.nextInt();
            }
            System.out.print("Informe K (número a procurar): ");
            k = scanner.nextInt();
            System.out.println("Informe o vetor: ");
            arr = new Integer[n]; // array de inteiros
            VetorReader.lerVetor(arr, k, scanner);

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (j == i) {
                        continue;
                    }
                    if ((arr[i] - arr[j]) == k) {
                        numeroPares++;
                    }
                }
            }
            System.out.println(numeroPares);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    

}