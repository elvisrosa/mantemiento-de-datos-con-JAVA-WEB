/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import conexion.metodos;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.profesor;

/**
 *
 * @author elvis
 */
@WebServlet(name = "controlador", urlPatterns = {"/controlador"})
public class controlador extends HttpServlet {

    public controlador() {
        super();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("opcion");
        switch (op) {
            case "registrar":
                RequestDispatcher ds = request.getRequestDispatcher("/registrar.jsp");
                ds.forward(request, response);
                break;

            case "listar":
                profesor p = new profesor();
                List<profesor> lista;
                try {
                    metodos metodo = new metodos();
                    lista = metodo.listartodo();
//                    for (profesor pro : lista) {
//                        System.out.println(pro);
//                    }
                    request.setAttribute("lista", lista);
                    RequestDispatcher dsl = request.getRequestDispatcher("/listar.jsp");
                    dsl.forward(request, response);
                } catch (IOException | ServletException e) {
                    e.printStackTrace();
                }
                break;

            case "editar":
                String nombre = request.getParameter("nombrepk");
                profesor pr;
                try {
                    metodos metodo = new metodos();
                    pr = metodo.obtenerNombre(nombre);
                    request.setAttribute("profesor", pr);
                    RequestDispatcher r = request.getRequestDispatcher("/editar.jsp");
                    r.forward(request, response);

                } catch (IOException | ServletException e) {
                    e.printStackTrace();
                } catch (SQLException ex) {
                    Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "eliminar":
                try {
                metodos metodo = new metodos();
                if (metodo.eliminar(request.getParameter("nombrepk"))) {
                    request.getRequestDispatcher("controlador?opcion=listar").forward(request, response);
                    System.out.println("Eliminado");
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String opcion = request.getParameter("opcion");
        if (opcion.equals("guardar")) {
            metodos metodo = new metodos();
            profesor pro = new profesor();
            pro.setNombre(request.getParameter("nombre"));
            pro.setDocente(request.getParameter("docente"));
            pro.setSemestre(request.getParameter("semestre"));
            pro.setCantidad(request.getParameter("cantidad"));
            try {
                if (metodo.registrar(pro)) {
                    System.out.println("Registrado");
                }

                RequestDispatcher re = request.getRequestDispatcher("/index.jsp");
                re.forward(request, response);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());

            }
        } else if (opcion.equals("eeditar")) {
            profesor pro = new profesor();
            metodos metodos = new metodos();
            pro.setNombre(request.getParameter("nombreId"));
            pro.setDocente(request.getParameter("docente"));
            pro.setSemestre(request.getParameter("semestre"));
            pro.setCantidad(request.getParameter("cantidad"));
            try {
                if (metodos.editarProfesor(pro)) {
                    System.out.println("Actualizado");
                    //request.getRequestDispatcher("controlador?opcion=listar").forward(request, response);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        //doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
