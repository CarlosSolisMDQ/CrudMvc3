package com.carlos.crudmysql.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class FormularioCrud extends JFrame{

    public String header[] = {"id", "nombre", "apellido", "edad"};
    public DefaultTableModel model;
    public List<Object[]> lista = new ArrayList<Object[]>();

    public JTextField nombreText;
    public JTextField edadText;
    public JTextField apellidoText;
    public JButton registrarButton;
    public JButton buscarButton;
    public JButton borrarButton;
    public JButton limpiarButton;
    public JPanel mainPanel;
    public JLabel nombre;
    public JLabel apellido;
    public JLabel edad;
    public JButton modificarButton;
    public JTextField idText;

    public JButton imprimirButton;
    private JTable table1;
    private JLabel idLabel;


    private void createUIComponents() {
        // TODO: place custom component creation code here

        model = new DefaultTableModel(0, 4);
        table1 = new JTable(model);
        model.setColumnIdentifiers(header);


    }

    public void pintarLaTabla(List<Object[]> lista){
        try{
            for(Object[] row: lista){
                model.addRow(row);
            }
        } catch(NullPointerException e){
            e.getMessage();
        }

    }

}
