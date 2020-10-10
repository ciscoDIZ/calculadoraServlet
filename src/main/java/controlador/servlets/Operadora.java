package controlador.servlets;

import modelo.dao.ConexionMySQL;
import modelo.dao.OperacionDAO;
import vista.Calculadora;

import javax.servlet.*;
import java.io.IOException;
import java.sql.SQLException;

public class Operadora implements Servlet {
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        servletConfig = config;
        if(config == null){
            throw new ServletException("error de configuracion");
        }else {
            try {
                ConexionMySQL.setNewConexion("historial", "devuser", "Monst3r_");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        Calculadora calculadora = new Calculadora();
        String res;
        try {
            double opa = Double.parseDouble(request.getParameter("opa"));
            double opb = Double.parseDouble(request.getParameter("opb"));
            char opr = request.getParameter("opr").charAt(0);
            double resultadoDouble = calculadora.operar(opa, opb, opr);
            OperacionDAO oDao = new OperacionDAO(null, opa, opb, resultadoDouble, opr);
            oDao.insert();
            res = "<h2>" + resultadoDouble + "</h2>" + getClass().getResource("");
            request.setAttribute("res", res);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            res = "err";
            request.setAttribute("res", res);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "hola";
    }

    @Override
    public void destroy() {
        try{
            ConexionMySQL.getConexion().getConn().close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
