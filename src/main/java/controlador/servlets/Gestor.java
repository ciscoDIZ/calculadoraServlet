package controlador.servlets;

import modelo.dao.ConexionMySQL;
import modelo.dao.OperacionDAO;

import javax.servlet.*;
import java.io.IOException;
import java.sql.SQLException;

public class Gestor implements Servlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            ConexionMySQL.setNewConexion("historial", "devuser", "Monst3r_");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        try {
            String his = request.getParameter("his");
            StringBuilder res=null;
            if(his != null) {
                res = new StringBuilder("<ul>");
                for (OperacionDAO operacionDAO : OperacionDAO.getResultados()) {
                    res.append("<li>").append(operacionDAO.toString()).append("</li>");
                }
                res.append("</ul>");

            }
            request.setAttribute("res", String.valueOf(res));
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return null;
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
