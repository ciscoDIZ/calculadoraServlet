package controlador.servlets;

import vista.Calculadora;

import javax.servlet.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Operadora implements Servlet {
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        servletConfig = config;
    }
    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        Calculadora calculadora = new Calculadora();
        double opa = Double.parseDouble(request.getParameter("opa"));
        double opb = Double.parseDouble(request.getParameter("opb"));
        char opr = request.getParameter("opr").charAt(0);
        double resultadoDouble = calculadora.operar(opa,opb,opr);
        String res = "<h2>"+resultadoDouble+"</h2>";
        request.setAttribute("res", res);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);
    }
    @Override
    public String getServletInfo() {
        return "hola";
    }
    @Override
    public void destroy() {

    }
}
