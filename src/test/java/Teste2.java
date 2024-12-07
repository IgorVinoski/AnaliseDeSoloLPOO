/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import igor.sistemaanalisedesololpoo.Parcela;
import igor.sistemaanalisedesololpoo.Agricultor;
import dao.PersistenciaJPA;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author igor
 */
public class Teste2 {
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public Teste2() {
    }
    
    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }
    
    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testePersistencia() {
  Agricultor agricultor = new Agricultor("Carlos Silva", "9999-1234");

        // Criar uma Parcela e associar ao Agricultor
        Parcela parcela = new Parcela("Argiloso", 6.5, 30.0);
        parcela.setAgricultor(agricultor);
        agricultor.setParcelas(new ArrayList<>());
        agricultor.getParcelas().add(parcela);

        // Criar um Fertilizante e associar à Parcela
        Fertilizante fertilizante = new Fertilizante("Fertilizante NPK", new Date(), 50.0);
        fertilizante.setParcela(parcela);
        parcela.setInsumosAplicados(new ArrayList<>());
        parcela.getInsumosAplicados().add(fertilizante);

        // Criar um DefensivoAgricola e associar à Parcela
        DefensivoAgricola defensivo = new DefensivoAgricola("Herbicida X", new Date(), "Herbicida");
        defensivo.setParcela(parcela);
        parcela.getInsumosAplicados().add(defensivo);
        
        
        try{
            jpa.persist(agricultor);

        }catch(Exception e){
            System.out.println("Erro ao presistir modelo: " + agricultor);
    }
}
}