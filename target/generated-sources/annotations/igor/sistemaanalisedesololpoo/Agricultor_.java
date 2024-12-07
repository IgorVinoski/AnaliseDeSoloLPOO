package igor.sistemaanalisedesololpoo;

import igor.sistemaanalisedesololpoo.Parcela;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-12-05T20:33:42", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Agricultor.class)
public class Agricultor_ { 

    public static volatile ListAttribute<Agricultor, Parcela> parcelas;
    public static volatile SingularAttribute<Agricultor, String> telefone;
    public static volatile SingularAttribute<Agricultor, String> nome;
    public static volatile SingularAttribute<Agricultor, Long> id;
    public static volatile SingularAttribute<Agricultor, String> email;

}