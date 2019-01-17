package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuário
 */
@WebServlet(urlPatterns = {"/Sconfirmar"})
public class Sconfirmar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession sessao;
        String botao;

        Usuario obj;
        try {
            botao = request.getParameter("b1");
            String sen, user;
            sessao = request.getSession(true);
            obj = new Usuario();
            Usuario usuario = (Usuario) sessao.getAttribute("user");
            user = usuario.getUsuario();
            sen = usuario.getSenha();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SLogin</title>");
            out.println("</head>");
            out.println("<body>");
            if (obj.loginAut(user, sen, botao)) {
                //para chamar servlet
                //request.getRequestDispatcher("menu.html").forward(request, response);
                //para chamar HTML
                if (request.getParameter("b1").compareTo("3DS") ==0) {
                    out.println(" <div align=\"center\">\n"
                            + "            <h1>Autorizado,redirecionando...</h1>\n"
                            + "            <img src=\"imgs/img2.png\" width=\"459\" height=\"302\" alt=\"img2\"/>\n"
                            + "        <meta HTTP-EQUIV='Refresh' CONTENT='5;URL=3DS.html'>\n"
                            + "        </div>");
                }
                if (request.getParameter("b1").compareTo("PS4") ==0) {
                    out.println(" <div align=\"center\">\n"
                            + "            <h1>Autorizado,redirecionando...</h1>\n"
                            + "            <img src=\"imgs/img2.png\" width=\"459\" height=\"302\" alt=\"img2\"/>\n"
                            + "        <meta HTTP-EQUIV='Refresh' CONTENT='5;URL=PS4.html'>\n"
                            + "        </div>");
                }
                if (request.getParameter("b1").compareTo("Wii u") ==0) {
                    out.println(" <div align=\"center\">\n"
                            + "            <h1>Autorizado,redirecionando...</h1>\n"
                            + "            <img src=\"imgs/img2.png\" width=\"459\" height=\"302\" alt=\"img2\"/>\n"
                            + "        <meta HTTP-EQUIV='Refresh' CONTENT='5;URL=Vita.html'>\n"
                            + "        </div>");
                }
                if (request.getParameter("b1").compareTo("Vita") ==0) {
                    out.println(" <div align=\"center\">\n"
                            + "            <h1>Autorizado,redirecionando...</h1>\n"
                            + "            <img src=\"imgs/img2.png\" width=\"459\" height=\"302\" alt=\"img2\"/>\n"
                            + "        <meta HTTP-EQUIV='Refresh' CONTENT='5;URL=Wiiu.html'>\n"
                            + "        </div>");
                }
                if (request.getParameter("b1").compareTo("Switch") ==0) {
                    out.println(" <div align=\"center\">\n"
                            + "            <h1>Autorizado,redirecionando...</h1>\n"
                            + "            <img src=\"imgs/img2.png\" width=\"459\" height=\"302\" alt=\"img2\"/>\n"
                            + "        <meta HTTP-EQUIV='Refresh' CONTENT='5;URL=Switch.html'>\n"
                            + "        </div>");
                }

            } else {
                out.println(" <div align=\"center\">\n"
                        + "            <h1>Acesso Negado,Voltando ao menu inicial...</h1>\n"
                        + "            <img src=\"imgs/img2.png\" width=\"459\" height=\"302\" alt=\"img2\"/>\n"
                        + "        <meta HTTP-EQUIV='Refresh' CONTENT='4;URL=menu.html'>\n"
                        + "        </div>");
            }

        } catch (Exception ex) {
        }
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
