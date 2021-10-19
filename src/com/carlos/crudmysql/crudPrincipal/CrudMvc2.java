package com.carlos.crudmysql.crudPrincipal;

import com.carlos.crudmysql.modelo.ConsultasMysql;
import com.carlos.crudmysql.controlador.ControladorCrud;
import com.carlos.crudmysql.modelo.Persona;
import com.carlos.crudmysql.vista.FormularioCrud;

public class CrudMvc2 {

    public static void main(String[] args) {

        Persona persona = new Persona();
        FormularioCrud formulario = new FormularioCrud();
        ConsultasMysql consultas = new ConsultasMysql();
        ControladorCrud controlador = new ControladorCrud(persona, formulario, consultas);

        controlador.iniciar();
        formulario.setVisible(true);

    }
}
