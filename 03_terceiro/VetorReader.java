import java.util.Scanner;

public class VetorReader {
    
    /**
     * @return se o vetor contém K
     */
    public static boolean lerVetor(Integer[] arr, Integer k, Scanner scanner) {
        boolean contem_K = false;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            if (arr[i] == k) {
                contem_K = true;
            } 
        }
        if (!contem_K) {
            System.out.println("O vetor não contém K. Informe um vetor que contenha K: ");
            contem_K = lerVetor(arr, k, scanner);
        }
        return contem_K;
    }
}
