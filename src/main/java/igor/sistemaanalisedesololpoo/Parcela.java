package igor.sistemaanalisedesololpoo;

import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_parcela")
public class Parcela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50) 
    private String tipoSolo;
    private double ph;
    private double umidade;

    @ManyToOne
    @JoinColumn(name = "agricultor_id")
    private Agricultor agricultor;

    @OneToMany(mappedBy = "parcela", cascade = CascadeType.ALL)
    private List<Insumo> insumosAplicados;
    public Parcela() {
           this.insumosAplicados = new ArrayList<>();
       }
    
    public Parcela(String tipoSolo, double ph, double umidade) {
           this();
        this.tipoSolo = tipoSolo;
        this.ph = ph;
        this.umidade = umidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoSolo() {
        return tipoSolo;
    }

    public void setTipoSolo(String tipoSolo) {
        this.tipoSolo = tipoSolo;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getUmidade() {
        return umidade;
    }

    public void setUmidade(double umidade) {
        this.umidade = umidade;
    }

    public Agricultor getAgricultor() {
        return agricultor;
    }

    public void setAgricultor(Agricultor agricultor) {
        this.agricultor = agricultor;
    }

    public List<Insumo> getInsumosAplicados() {
        return insumosAplicados;
    }

    public void setInsumosAplicados(List<Insumo> insumosAplicados) {
        this.insumosAplicados = insumosAplicados;
    }

    @Override
   public String toString() {
       return "id=" + id + ", tipoSolo=" + tipoSolo + ", agricultor=" + agricultor;
   }

}