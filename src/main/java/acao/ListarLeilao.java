package acao;

import DAO.LeilaoDaoSession;
import model.Cliente;
import model.Leilao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ListarLeilao {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public ListarLeilao(HttpServletResponse resp, HttpServletRequest req){
        this.resp = resp;
        this.req = req;
    }

    public void executa() throws ServletException, IOException {
            LeilaoDaoSession dao = new LeilaoDaoSession();
            List<Leilao> list = dao.BuscarTodos();
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/listadeleiloes.jsp");
            req.setAttribute("list", list);
            dispatcher.forward(req, resp);
    }


}
