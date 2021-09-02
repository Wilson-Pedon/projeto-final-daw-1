package acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NovoLeilao {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public NovoLeilao(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    public void executa() throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/cadastro-leilao.jsp").forward(req, resp);
    }

}
