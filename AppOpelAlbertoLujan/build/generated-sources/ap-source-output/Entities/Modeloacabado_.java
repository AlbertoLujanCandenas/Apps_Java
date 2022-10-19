package Entities;

import Entities.Acabado;
import Entities.Itemacabado;
import Entities.Modelo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-23T08:45:42")
@StaticMetamodel(Modeloacabado.class)
public class Modeloacabado_ { 

    public static volatile ListAttribute<Modeloacabado, Itemacabado> itemacabadoList;
    public static volatile SingularAttribute<Modeloacabado, Acabado> acabado;
    public static volatile SingularAttribute<Modeloacabado, Short> id;
    public static volatile SingularAttribute<Modeloacabado, Modelo> modelo;

}