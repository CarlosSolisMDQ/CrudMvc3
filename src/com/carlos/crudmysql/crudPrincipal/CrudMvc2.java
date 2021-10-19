package com.carlos.crudmysql.crudPrincipal;

import com.carlos.crudmysql.modelo.ConsultasMysql;
import com.carlos.crudmysql.controlador.ControladorCrud;
import com.carlos.crudmysql.modelo.Persona;
import com.carlos.crudmysql.vista.FormularioCrud;
import com.carlos.crudmysql.vista.TablaFormulario;

public class CrudMvc2 {

    public static void main(String[] args) {

        Persona persona = new Persona();
        FormularioCrud formulario = new FormularioCrud();
        ConsultasMysql consultas = new ConsultasMysql();
        TablaFormulario tabla = new TablaFormulario();
        ControladorCrud controlador = new ControladorCrud(persona, formulario, consultas, tabla);


        controlador.iniciar();
        controlador.iniciarTabla();
        formulario.setVisible(true);
        tabla.setVisible(true);
    }
}
