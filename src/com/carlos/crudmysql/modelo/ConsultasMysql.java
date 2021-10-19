package com.carlos.crudmysql.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasMysql extends ConeccionMysql {

    public boolean registrar(Persona persona) throws SQLException {

        PreparedStatement ps = null;
        Connection coneccion = getConnection();

        String sql = "INSERT INTO persona (nombre, apellido, edad) VALUES (?,?,?)";
    try {
        ps = coneccion.prepareStatement(sql);

        ps.setString(1,persona.getNombre());
        ps.setString(2,persona.getApellido());
        ps.setInt(3,persona.getEdad());

        ps.execute();

        return true;
    } catch (SQLException e) {
        System.err.println(e.getMessage());
        } finally {
            try{
                coneccion.close();
            } catch(SQLException e2){
                System.err.println(e2.getMessage());
            }

        }
    return false;
    }


    public boolean actualizar(Persona persona) throws SQLException {

        PreparedStatement ps = null;
        Connection coneccion = getConnection();

        String sql = "UPDATE persona SET nombre=?, apellido=?, edad=? WHERE id=?";
        try {
            ps = coneccion.prepareStatement(sql);


            ps.setString(1,persona.getNombre());
            ps.setString(2,persona.getApellido());
            ps.setInt(3,persona.getEdad());
            ps.setString(4, String.valueOf(persona.getId()));
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try{
                coneccion.close();
            } catch(SQLException e2){
                System.err.println(e2.getMessage());
            }

        }
        return false;
    }


    public boolean Eliminar(Persona persona) throws SQLException {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "DELETE FROM persona WHERE id=?";

        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1,persona.getId());
            ps.execute();
            return true;
        }catch (SQLException e){
            System.err.println(e.getMessage());
        } finally {
            try{
                con.close();
            } catch (SQLException e2){
                System.err.println(e2.getMessage());
            }

        }
        return false;
    }


    public boolean Buscar(Persona persona) throws SQLException {
        PreparedStatement ps = null;
        Connection con = getConnection();
        ResultSet rs = null;
        String sql = "SELECT * FROM persona WHERE id=?";

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(persona.getId()));
            rs = ps.executeQuery();

            if(rs.next()) {

                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setEdad(Integer.parseInt(rs.getString("edad")));

                return true;
            }

        }catch (SQLException e){
            System.err.println(e.getMessage());
        } finally {
            try{
                con.close();
            } catch (SQLException e2){
                System.err.println(e2.getMessage());
            }

        }
        return false;
    }


}
