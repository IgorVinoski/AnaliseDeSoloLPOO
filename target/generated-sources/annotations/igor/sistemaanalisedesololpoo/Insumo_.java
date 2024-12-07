package igor.sistemaanalisedesololpoo;

import igor.sistemaanalisedesololpoo.Parcela;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-12-05T20:33:42", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Insumo.class)
public abstract class Insumo_ { 

    public static volatile SingularAttribute<Insumo, Date> dataDeAplicacao;
    public static volatile SingularAttribute<Insumo, String> nome;
    public static volatile SingularAttribute<Insumo, Long> id;
    public static volatile SingularAttribute<Insumo, Parcela> parcela;

}