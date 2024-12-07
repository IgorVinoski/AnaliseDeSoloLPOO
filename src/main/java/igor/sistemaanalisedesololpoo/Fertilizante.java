package igor.sistemaanalisedesololpoo;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
    
@Entity
@Table(name = "tb_fertilizante")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate

public class Fertilizante extends Insumo {
        @Column(nullable = true) 
    private double quantidade;

    public Fertilizante() {
    }

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