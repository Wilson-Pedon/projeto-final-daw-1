package acao;

import DAO.LeilaoDaoSession;
import model.Leilao;
import regraDeNegocio.LeilaoRegras;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class CadastrarLeilao {

    private final HttpServletResponse resp;
    private final HttpServletRequest req;

    public CadastrarLeilao(HttpServletResponse resp, HttpServletRequest req) {
        this.resp = resp;
        this.req = req;
    }

    public void executa() throws IOException {
        LeilaoDaoSession dao = new LeilaoDaoSession();
        String campoNome = req.getParameter("objeto");
        Integer valorMinimo = Integer.valueOf(req.getParameter("valor"));
        LocalDate data = LocalDate.parse(req.getParameter("data"));
        String status = req.getParameter("status");
        Leilao leilao = new Leilao(campoNome, valorMinimo, data, status);
        LeilaoRegras leilaoRegras = new LeilaoRegras();
        leilaoRegras.cadastraInativo(leilao);
        dao.Cadastro(leilao);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/entrada?acao=novoLeilao");
    }

}
