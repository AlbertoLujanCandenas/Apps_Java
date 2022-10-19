package Entities;

import Entities.Modelo;
import Entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-23T08:45:42")
@StaticMetamodel(Cita.class)
public class Cita_ { 

    public static volatile SingularAttribute<Cita, String> fecha;
    public static volatile SingularAttribute<Cita, Usuario> usuario;
    public static volatile SingularAttribute<Cita, Short> id;
    public static volatile SingularAttribute<Cita, Modelo> modelo;

}