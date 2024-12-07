import igor.sistemaanalisedesololpoo.Parcela;
import igor.sistemaanalisedesololpoo.Agricultor;
import dao.PersistenciaJPA;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Teste3 {
    PersistenciaJPA jpa = new PersistenciaJPA();

    public Teste3() {
    }

    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    @Test
    public void testePersistenciaComVariasEntidades() {
        Agricultor agricultor2 = new Agricultor("Mariana Pereira", "8888-5678");

        Parcela parcela1 = new Parcela("Arenoso", 5.8, 25.0);
        Parcela parcela2 = new Parcela("Humoso", 6.2, 45.0);
        
        agricultor2.setParcelas(new ArrayList<>());
        agricultor2.getParcelas().add(parcela1);
        agricultor2.getParcelas().add(parcela2);

        parcela1.setAgricultor(agricultor2);
        parcela2.setAgricultor(agricultor2);

        Fertilizante fertilizante1 = new Fertilizante("Fertilizante P", new Date(), 30.0);
        fertilizante1.setParcela(parcela1);
        
        Fertilizante fertilizante2 = new Fertilizante("Fertilizante K", new Date(), 40.0);
        fertilizante2.setParcela(parcela2);
        
        parcela1.setInsumosAplicados(new ArrayList<>());
        parcela2.setInsumosAplicados(new ArrayList<>());
        
        parcela1.getInsumosAplicados().add(fertilizante1);
        parcela2.getInsumosAplicados().add(fertilizante2);

        DefensivoAgricola defensivo1 = new DefensivoAgricola("Inseticida Y", new Date(), "Inseticida");
        defensivo1.setParcela(parcela1);
        
        DefensivoAgricola defensivo2 = new DefensivoAgricola("Fungicida Z", new Date(), "Fungicida");
        defensivo2.setParcela(parcela2);

        parcela1.getInsumosAplicados().add(defensivo1);
        parcela2.getInsumosAplicados().add(defensivo2);

        try {
            jpa.persist(agricultor2);
            System.out.println("Agricultor e dados associados persistidos com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao persistir o modelo: " + agricultor2);
        }
    }
}
