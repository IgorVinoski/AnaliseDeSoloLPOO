package igor.sistemaanalisedesololpoo;

import igor.sistemaanalisedesololpoo.Agricultor;
import igor.sistemaanalisedesololpoo.Insumo;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-12-05T20:33:42", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Parcela.class)
public class Parcela_ { 

    public static volatile SingularAttribute<Parcela, Double> umidade;
    public static volatile SingularAttribute<Parcela, Double> ph;
    public static volatile ListAttribute<Parcela, Insumo> insumosAplicados;
    public static volatile SingularAttribute<Parcela, String> tipoSolo;
    public static volatile SingularAttribute<Parcela, Long> id;
    public static volatile SingularAttribute<Parcela, Agricultor> agricultor;

}