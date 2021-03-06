package com.carlos.crudmysql.controlador;

import com.carlos.crudmysql.modelo.ConsultasMysql;
import com.carlos.crudmysql.modelo.Persona;
import com.carlos.crudmysql.vista.FormularioCrud;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorCrud implements ActionListener {

    private Persona persona;
    private FormularioCrud formulario;
    private ConsultasMysql consulta;



    public ControladorCrud(Persona persona, FormularioCrud formulario, ConsultasMysql consulta) {
        this.persona = persona;
        this.formulario = formulario;
        this.consulta = consulta;

        this.formulario.registrarButton.addActionListener(this);
        this.formulario.borrarButton.addActionListener(this);
        this.formulario.modificarButton.addActionListener(this);
        this.formulario.buscarButton.addActionListener(this);
        this.formulario.limpiarButton.addActionListener(this);
        this.formulario.imprimirButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == formulario.registrarButton){
            persona.setNombre(formulario.nombreText.getText());
            persona.setApellido(formulario.apellidoText.getText());
            persona.setEdad(Integer.parseInt(formulario.edadText.getText()));

            try {
                if(consulta.registrar(persona)){
                    JOptionPane.showMessageDialog(null, "registrado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "error de registrado");
                    limpiar();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }


            limpiar();
        } else if(e.getSource() == formulario.modificarButton){

            persona.setId(Integer.parseInt(formulario.idText.getText()));
            persona.setNombre(formulario.nombreText.getText());
            persona.setApellido(formulario.apellidoText.getText());
            persona.setEdad(Integer.parseInt(formulario.edadText.getText()));

            try {
                if(consulta.actualizar(persona)){
                    JOptionPane.showMessageDialog(null, "actualizado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "error de actualizado");
                    limpiar();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else if(e.getSource() == formulario.borrarButton){
            persona.setId(Integer.parseInt(formulario.idText.getText()));

            try {
                if(consulta.Eliminar(persona)){
                    JOptionPane.showMessageDialog(null, "borrado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "error de borrado");
                    limpiar();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } else if(e.getSource() == formulario.buscarButton){

            persona.setId(Integer.parseInt(formulario.idText.getText()));
            try{
                if(consulta.Buscar(persona)){
                    formulario.nombreText.setText(persona.getNombre());
                    formulario.apellidoText.setText(persona.getApellido());
                    formulario.edadText.setText(String.valueOf(persona.getEdad()));
                } else {
                    JOptionPane.showMessageDialog(null, "error de busqueda");
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }



        } else if(formulario.limpiarButton == e.getSource()){
            limpiar();

        } else if(formulario.imprimirButton == e.getSource()){
            try {
                formulario.model.setNumRows(0);
                formulario.lista = new ArrayList<Object[]>(consulta.listar());
                //System.out.println(formulario.lista);
                formulario.pintarLaTabla(formulario.lista);
            } catch (SQLException ex) {
                ex.getMessage();
            }

        }

    }

    public void limpiar(){

        formulario.nombreText.setText("");
        formulario.edadText.setText("");
        formulario.apellidoText.setText("");
        formulario.idText.setText("");
    }

    public void iniciar(){
        formulario.setContentPane(formulario.mainPanel);
        formulario.setTitle("Base de datos de Personas");

        formulario.setResizable(false);
        formulario.setSize(680,400);
        formulario.pack();
        formulario.setLocationRelativeTo(null);
        formulario.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
