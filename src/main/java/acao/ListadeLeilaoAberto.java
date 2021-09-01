package acao;

import DAO.ClienteDao;
import DAO.LeilaoDaoSession;
import model.Leilao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListadeLeilaoAberto {

    private final HttpServletResponse resp;
    private final HttpServletRequest req;

    public ListadeLeilaoAberto(HttpServletResponse resp, HttpServletRequest req){
        this.resp = resp;
        this.req = req;
    }

    public void executa() throws ServletException, IOException {
        LeilaoDaoSession dao = new LeilaoDaoSession();
        List<Leilao> list = dao.BuscarNome("Aberto");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/listadeleilaoaberto.jsp");
        req.setAttribute("list", list);
        dispatcher.forward(req, resp);
    }
}
