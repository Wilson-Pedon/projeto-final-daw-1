package acao;

import DAO.ClienteDao;
import DAO.LeilaoDaoSession;
import model.Cliente;
import model.Leilao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeletarCliente {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public DeletarCliente(HttpServletResponse resp, HttpServletRequest req) {
        this.resp = resp;
        this.req = req;
    }

    public void executa() throws ServletException, IOException {
        ClienteDao dao = new ClienteDao();
        String id = req.getParameter("id");
        dao.deleta(Integer.parseInt(id));

        ListarCliente listarCliente = new ListarCliente(resp, req);
        listarCliente.executa();
    }

}
