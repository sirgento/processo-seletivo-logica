import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
	 * Método pra resolução do exercício 2.
	 * Recebe um valor monetário, e printa uma
	 * tabela de notas e moedas com a quantidade
	 * necessária pra dar o valor
	 * 
	 * @return true se deu tudo certo
	 */
	private static boolean exercicio() {

		// confia
		Double[] valores = { 0.01, 0.05, 0.10, 0.25, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00, 50.00, 100.00 };
		List<Contador> contadores = new ArrayList<Contador>();

		Contador lastContador = null;
		for (Double valor : valores) {
			Contador contador = new Contador(valor, (valor < 1.00 ? EnumNotaMoeda.MOEDA : EnumNotaMoeda.NOTA),
					lastContador);
			contadores.add(contador);
			lastContador = contador;
		}

		try (Scanner scanner = new Scanner(System.in)) {

			// pra ler com ponto
			scanner.useLocale(Locale.US);
			System.out.print("Informe um valor positivo para fazer a contagem: R$ ");
			BigDecimal valorLido = scanner.nextBigDecimal();
			// validar numeros negativos
			while (valorLido.compareTo(BigDecimal.ZERO) <= 0) {
				System.out.print("Informe um valor positivo para fazer a contagem: R$ ");
				valorLido = scanner.nextBigDecimal();
			}

			// último index nos contadores
			Integer indexContadores = (contadores.size() - 1);
			// faz de forma recursiva, último contador é o de 100
			contadores.get(indexContadores).contar(valorLido);

			DecimalFormat df = new DecimalFormat("#,##0.00", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
			boolean jaPrintouNota = false;
			boolean jaPrintouMoeda = false;
			for (int i = indexContadores; i >= 0; i--) {
				Contador contador = contadores.get(i);

				switch (contador.getNotaMoeda()) {
					case NOTA:
						if (!jaPrintouNota) {
							System.out.println("NOTAS:");
							jaPrintouNota = true;
						}
						break;
					case MOEDA:
						if (!jaPrintouMoeda) {
							System.out.println("MOEDAS:");
							jaPrintouMoeda = true;
						}
						break;
				}
				System.out.println(contador.getContagem()
						+ "\t" + contador.getNotaMoedaString()
						+ (contador.getNotaMoeda().equals(EnumNotaMoeda.NOTA) ? "\t\t" : "\t")
						+ "de\tR$\t" + df.format(contador.getValor()));
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}