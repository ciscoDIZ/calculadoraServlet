package controlador.servlets;

import modelo.dao.Conexion;

import javax.servlet.*;
import java.io.IOException;

public class Gestor implements Servlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            Conexion.setNewConnection("historial.db");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
