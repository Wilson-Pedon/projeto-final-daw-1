package acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NovoUpdate {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public NovoUpdate(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    public void executa() throws ServletException, IOException {
        String id = req.getParameter("id");
        String nome = req.getParameter("nome");
        String valor = req.getParameter("valor");
        String data = req.getParameter("data");
        req.setAttribute("pID", id);
        req.setAttribute("nome", nome);
        req.setAttribute("data", data);
        req.setAttribute("valor", valor);
        req.getRequestDispatcher("/WEB-INF/pages/update-leilao.jsp").forward(req, resp);
        System.out.println("O id é: " + id + nome + data + valor);
    }

}
