package <paquete>;

<clase.importaciones :{ imp | <imp><\n>}>

  public <if(clase.abstracta)>abstract class <endif><if(clase.esInterfaz)>interface <endif><if(!clase.abstracta && !clase.esInterfaz )>class <endif><clase.nombre><clase.parametros><if(clase.heredaDeClase)> extends <clase.clasePadre><endif> {  

   <clase.variables :{ atributo | <atributo>;}; separator="\n">

   <clase.metodos :{ metodo |<if(metodo.esOverride)>@Override<endif><\n><metodo.calificador> <if(metodo.abstracto)>abstract <endif><if(metodo.estatico)>static <endif><metodo.tipo> <metodo.nombre><metodo.cuerpo> <\n>}; separator="\n\n">

}