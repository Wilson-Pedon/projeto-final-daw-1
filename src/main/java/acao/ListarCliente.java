package acao;

import DAO.ClienteDao;
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

public class ListarCliente {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public ListarCliente(HttpServletResponse resp, HttpServletRequest req) {
        this.resp = resp;
        this.req = req;
    }

    public void executa() throws ServletException, IOException {
        ClienteDao dao = new ClienteDao();
        List<Leilao> list = dao.findAll();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/listadeclientes.jsp");
        req.setAttribute("list", list);
        dispatcher.forward(req, resp);
    }


}
