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
        Integer quantidadeStrings;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Informe a quantidade de strings a serem lidas: ");
            quantidadeStrings = scanner.nextInt();
            while (quantidadeStrings <= 0) {
                System.out.print("A quantidade de strings não pode ser inferior a zero, informe: ");
                quantidadeStrings = scanner.nextInt();
            }
            String[] strings = new String[quantidadeStrings];

            // consume a quebra de linha anterior
            scanner.nextLine();
            System.out.println("Digite uma string: ");
            for (int i = 0; i < strings.length; i++) {
                String s = scanner.nextLine();
                if (s.length() > 100 || s.length() < 2) {
                    System.out.println("String inválida, tente novamente: ");
                    s = scanner.nextLine();
                }
                strings[i] = s;
            }
            System.out.println();

            for (String string : strings) {
                String[] strs = StringUtils.dividirString(string);
                for (String str : strs) {
                    System.out.print(
                            StringUtils.inverterString(str));
                }
                System.out.println();
            }
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}