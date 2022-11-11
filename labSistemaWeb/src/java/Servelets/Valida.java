///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package Servelets;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///**
// *
// * @author mathe
// */
//public class Valida extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    private String usuario;
//    private String senha;
//
//    @Override
//    public void init() {
//        usuario = getInitParameter("usuario");
//        senha = getInitParameter("senha");
//    }
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String user_a = request.getParameter("usuario");
//        String pw_a = request.getParameter("senha");
//
//        // Pega senha do banco de dados
//        String user_bd = "root";
//        String pw_bd = "root";
//
//        boolean result = false;
//        String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
//        String DB_URL = "jdbc:derby://localhost:1527/matheus";
//        //  Database credentials
//        Connection conn = null;
//        Statement stmt = null;
//        // Set response content type
//        String resp = "";
//        try {
//            // Register JDBC drive
//            Class.forName(JDBC_DRIVER);
//            // Open a connection
//            conn = DriverManager.getConnection(DB_URL, user_bd, pw_bd);
//            // Execute SQL query
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT nome, senha FROM ROOT.USUARIO where upper(nome) = '"
//                    + user_a.toUpperCase() + "' and senha='" + pw_a + "'";
//            ResultSet rs = stmt.executeQuery(sql);
//            // Extract data from result set
//            if (rs.next()) {
//                result = true;
//            }
//            rs.close();
//            stmt.close();
//            conn.close();
//        } catch (SQLException e) {
//            //Handle errors for JDBC
//            //throw new ServletException(e);
//            resp = e.getMessage();
//            throw new ServletException(e);
//        } catch (Exception e) {
//            //Handle errors for Class.forName
//            //throw new ServletException(e);
//            resp = e.getMessage();
//            throw new ServletException(e);
//        } finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException e) {
//                throw new ServletException(e);
//            }// nothing we can do
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                throw new ServletException(e);
//            }//end finally try
//        } //end try    
//        if (result) {
//           request.getRequestDispatcher("Menu").forward(request, response);
//        } else {
//            response.setContentType("text/html;charset=UTF-8");
//            try (PrintWriter out = response.getWriter()) {
//                /*TODO output your page here. You may use following sample code.*/
//                out.println("<!DOCTYPE html>");
//                out.println("<html>");
//                out.println("<head>");
//                out.println("<title>Servlet Menu</title>");
//                out.println("</head>");
//                out.println("<body>");
//                out.println("<h1>Erro ao validar</h1>");
//                out.println("</body>");
//                out.println("</html>");
//
//            }
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}

package Servelets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ciro
 */
public class Valida extends HttpServlet {

    String bd_us;
    String bd_pw;

    @Override
    public void init() {
        bd_us = this.getServletContext().getInitParameter("bd_user");
        bd_pw = this.getServletContext().getInitParameter("bd_pw");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Pega a sessao
        HttpSession session = request.getSession(true);
        String code = request.getParameter("code");
        boolean menu = false;
        if (code != null && code.equals("menu")) {
            menu = true;
        }
        if (code != null && code.equals("sair")) {
            //session.setAttribute("logado", false);
            session.invalidate();
            response.sendRedirect("index.jsp");
            return ;
        }
        boolean logado = false;
        Object tmp = session.getAttribute("logado");
        if (tmp != null && (boolean) tmp) {
            logado = true;
        }

        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");

        if (!logado) {
            if (nome != null || menu) {
                // quer fazer login
                if (validaLogin(nome, senha)) {
                    session.setAttribute("logado", true);
                    session.setAttribute("nome", nome);
                    logado = true;
                } else {
                    session.setAttribute("msg", "Login inválido!");
                }
            } else {
                session.setAttribute("msg", "Sessão expirou!!");
                // expirou a sessao
            }
        }
        if (logado) {
            response.sendRedirect("menu.jsp");
            //request.getRequestDispatcher("menu.jsp").forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    public boolean validaLogin(String _nome, String _senha) throws ServletException {

        // return _nome.equalsIgnoreCase(no) && _senha.equals(pw);
        boolean result = false;
        String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
        String DB_URL = "jdbc:derby://localhost:1527/matheus";
        //  Database credentials
        Connection conn = null;
        Statement stmt = null;
        String resp = "EXECUTOU";
        // Set response content type
        
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // Open a connection
            conn = DriverManager.getConnection(DB_URL, bd_us, bd_pw);
            // Execute SQL query
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT nome, senha FROM usuario where upper(nome) = '"
                    + _nome.toUpperCase() + "' and senha='" + _senha + "'";
            ResultSet rs = stmt.executeQuery(sql);
            // Extract data from result set
            if (rs.next()) {
                result = true;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            //Handle errors for JDBC
            //throw new ServletException(e);
            resp = e.getMessage();
            throw new ServletException(e);
        } catch (Exception e) {
            //Handle errors for Class.forName
            //throw new ServletException(e);
            resp = e.getMessage();
            throw new ServletException(e);
        } finally {
            System.out.printf(resp);
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }//end finally try
        } //end try    
        return result;
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
