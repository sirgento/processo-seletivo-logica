import java.math.BigDecimal;
import java.math.MathContext;

public class Contador {

    private BigDecimal valor;
    private Integer contagem = 0;
    private Contador nextContador;
    private EnumNotaMoeda notaMoeda;

    public Contador(Double valor, EnumNotaMoeda notaMoeda, Contador nextContador) {
        this.valor = BigDecimal.valueOf(valor);
        this.notaMoeda = notaMoeda;
        this.nextContador = nextContador;
    }

    public Contador(BigDecimal valor, EnumNotaMoeda notaMoeda, Contador nextContador) {
        this.valor = valor;
        this.notaMoeda = notaMoeda;
        this.nextContador = nextContador;
    }

    public EnumNotaMoeda getNotaMoeda() {
        return this.notaMoeda;
    }
    
    public String getNotaMoedaString() {
        return this.notaMoeda.stringNotaMoeda;
    }

    public void contar(BigDecimal valorContar) {
        if (valorContar.compareTo(valor) == 0) {
            contagem++;
            return;
        }

        if (valorContar.compareTo(valor) < 0) {
            if (nextContador == null) {
                return;
            }
            nextContador.contar(valorContar);
        }

        if (valorContar.compareTo(valor) > 0) {
            valorContar = valorContar.subtract(valor, MathContext.DECIMAL64);
            contagem++;
            contar(valorContar);
        }
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getContagem() {
        return contagem;
    }

    public Contador getNextContador() {
        return nextContador;
    }

}
