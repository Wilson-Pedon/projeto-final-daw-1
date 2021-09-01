package acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NovoUpdateCliente {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public NovoUpdateCliente(HttpServletRequest req, HttpServletResponse resp){
        this.req = req;
        this.resp = resp;
    }

    public void executa() throws ServletException, IOException {
        String id = req.getParameter("id");
        String nome = req.getParameter("nome");
        String email = (req.getParameter("cadastra-email"));
        String senha = req.getParameter("cadastra-senha");
        req.setAttribute("pID" , id);
        req.setAttribute("nome", nome);
        req.setAttribute("cadastra-email",email);
        req.setAttribute("cadastra-senha",senha);
        req.getRequestDispatcher("/WEB-INF/pages/upgrade-cliente.jsp").forward(req, resp);
        System.out.println("O id é: " + id + nome + email + senha);
    }

}
