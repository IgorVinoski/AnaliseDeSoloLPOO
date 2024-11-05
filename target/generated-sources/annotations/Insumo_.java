import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-11-04T21:40:38", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Insumo.class)
public abstract class Insumo_ { 

    public static volatile SingularAttribute<Insumo, Date> dataAplicacao;
    public static volatile SingularAttribute<Insumo, String> nome;
    public static volatile SingularAttribute<Insumo, Long> id;
    public static volatile SingularAttribute<Insumo, Parcela> parcela;

}