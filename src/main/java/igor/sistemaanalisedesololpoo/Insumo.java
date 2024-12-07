package igor.sistemaanalisedesololpoo;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Insumo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date dataDeAplicacao;

    @ManyToOne
    private Parcela parcela; // Relacionamento com a classe Parcela

    // Construtores
    public Insumo() {}

    public Insumo(String nome, Date dataDeAplicacao) {
        this.nome = nome;
        this.dataDeAplicacao = dataDeAplicacao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

 

    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }

    // toString para exibição em JComboBox
    @Override
    public String toString() {
        return nome;
    }
}