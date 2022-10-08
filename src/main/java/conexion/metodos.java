/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.profesor;

/**
 *
 * @author elvis
 */
public class metodos {

    public metodos() {
    }

    private Connection con = null;

    public boolean registrar(profesor pro) throws SQLException {
        con = getConexion();
        boolean estado = false;
        Statement st;
        //PreparedStatement   st;

        try {
            String sql = "INSERT INTO profeso (nombre, docente, semestre, cantidad) values ('" + pro.getNombre() + "', '" + pro.getDocente() + "', '" + pro.getSemestre()
                    + "','" + pro.getCantidad() + "')";
            st = con.createStatement();
            con.setAutoCommit(false);//inicio de transaccion
            st.executeUpdate(sql);
            con.commit();
            estado = true;
            st.close();
            con.close();

        } catch (SQLException e) {
            estado = false;
            con.rollback();
            System.out.println(e.getMessage());
        }
        return estado;

    }

    public List<profesor> listartodo() {
        List<profesor> lista = new ArrayList<>();
        boolean estado = false;
        PreparedStatement ps;
        ResultSet rs;
        try {
            String sql = "Select * from profeso";
            con = getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                profesor p = new profesor();
                p.setNombre(rs.getString(1));
                p.setDocente(rs.getString(2));
                p.setSemestre(rs.getString(3));
                p.setCantidad(rs.getString(4));

                lista.add(p);

            }
            ps.close();
            con.close();

        } catch (Exception e) {
        }
        return lista;
    }

    public profesor obtenerNombre(String nombre) throws SQLException {
        profesor p = new profesor();
        boolean estado = false;
        ResultSet rs;
        PreparedStatement ps;
        try {
            con = getConexion();
            String sql = "Select * from profeso where nombre = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setSemestre(rs.getString("nombre"));
                p.setDocente(rs.getString("docente"));
                p.setSemestre(rs.getString("semestre"));
                p.setCantidad(rs.getString("cantidad"));
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }
        return p;
    }

    public boolean editarProfesor(profesor p) throws SQLException {
        boolean estado = false;
        PreparedStatement st;
        try {
            con = getConexion();
            String sql ="UPDATE profeso set docente = ?, semestre =?, cantidad=? where nombre =?";
//            String sql = "update profeso set docente='" + p.getDocente()
//                    + "',semestre='" + p.getSemestre() + "', cantidad='" + p.getCantidad()
//                    + "'where nombre = '" + p.getNombre() + "'";

            con.setAutoCommit(false);//inicio de transaccion
            st = con.prepareStatement(sql);
            st.setString(1, p.getDocente());
            st.setString(2, p.getSemestre());
            st.setString(3, p.getCantidad());
            st.setString(4, p.getNombre());
            
            st.execute();
            con.commit();
            estado = true;
            st.close();
            con.close();
        } catch (SQLException e) {
            estado = false;
            con.rollback();
            System.out.println(e.getMessage());
        }
        return estado;
    }

    public boolean eliminar(String nombre) throws SQLException {
        boolean estado = false;
        PreparedStatement st;
        try {
            con = getConexion();
            con.setAutoCommit(false);
            String sql = "delete from profeso where nombre = ?";
            st = con.prepareStatement(sql);
            st.setString(1, nombre);
            estado = st.executeUpdate()>0;
            con.commit();
            st.close();
            con.close();
            
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return estado;
    }

    public Connection getConexion() throws SQLException {
        return poolConexiones.getConexion();
    }

}
