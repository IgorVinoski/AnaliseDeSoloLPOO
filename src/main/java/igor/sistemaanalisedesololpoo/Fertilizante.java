
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_fertilizante")
public class Fertilizante extends Insumo {
    private double quantidade;

    public Fertilizante(String nome, Date dataAplicacao, double quantidade) {
        super(nome, dataAplicacao);
        this.quantidade = quantidade;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

}