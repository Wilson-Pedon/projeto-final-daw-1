package acao;

import DAO.LanceDao;
import DAO.LeilaoDaoSession;
import model.Leilao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListarLeilaoLance {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public ListarLeilaoLance(HttpServletResponse resp, HttpServletRequest req){
        this.resp = resp;
        this.req = req;
    }

    public void executa() throws ServletException, IOException {
        LanceDao dao = new LanceDao();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/listalance.jsp");
        dispatcher.forward(req, resp);
    }


}
