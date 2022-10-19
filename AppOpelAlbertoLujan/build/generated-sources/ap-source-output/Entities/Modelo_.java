package Entities;

import Entities.Cita;
import Entities.Modeloacabado;
import Entities.Tipo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-23T08:45:42")
@StaticMetamodel(Modelo.class)
public class Modelo_ { 

    public static volatile ListAttribute<Modelo, Modeloacabado> modeloacabadoList;
    public static volatile ListAttribute<Modelo, Tipo> tipoList;
    public static volatile SingularAttribute<Modelo, String> imagen;
    public static volatile SingularAttribute<Modelo, Short> id;
    public static volatile SingularAttribute<Modelo, String> nombre;
    public static volatile ListAttribute<Modelo, Cita> citaList;

}