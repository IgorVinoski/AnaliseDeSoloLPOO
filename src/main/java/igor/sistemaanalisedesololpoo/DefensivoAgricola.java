import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import javax.persistence.Column;

@Entity
@Table(name = "tb_defensivoAgricola")
public class DefensivoAgricola extends Insumo {
    @Column(length = 100) 
    private String categoria;

    public DefensivoAgricola(String nome, Date dataAplicacao, String categoria) {
        super(nome, dataAplicacao);
        this.categoria = categoria;
    }

    // Getters e Setters
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
