/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import dao.PersistenciaJPA;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author igor
 */
public class TestePersistencia {
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public TestePersistencia() {
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
        Agricultor a  = new Agricultor();
        a.setNome("Igor");
        
        
        try{
            jpa.persist(a);

        }catch(Exception e){
            System.out.println("Erro ao presistir modelo: " + a);
    }
}
}