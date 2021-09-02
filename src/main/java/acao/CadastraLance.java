package acao;

import DAO.LanceDao;
import DAO.LeilaoDao;
import DAO.LeilaoDaoSession;
import model.Lance;
import model.Leilao;
import regraDeNegocio.LanceRegras;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CadastraLance {

    private final HttpServletResponse resp;
    private final HttpServletRequest req;

    public CadastraLance(HttpServletResponse resp, HttpServletRequest req) {
        this.resp = resp;
        this.req = req;
    }

    public void executa() throws IOException, ServletException {
        LanceDao dao = new LanceDao();
        LeilaoDaoSession daoLeilao = new LeilaoDaoSession();
        String item = req.getParameter("objeto");
        String campoNome = req.getParameter("usuario");
        String email = req.getParameter("email");
        float valor = Integer.valueOf(req.getParameter("valordolance"));
        List<Lance> lista = new LanceDao().BuscarObjeto(item);
        List<String> qualquer = new ArrayList<>();
        List<Float> qualquer1 = new ArrayList<>();
        for (Lance l : lista) {
            qualquer.add(l.getNome());
            qualquer1.add(l.getValor());
        }
        String veficarNome = qualquer.get(qualquer.size() - 1);
        float veficarvalor = qualquer1.get(qualquer1.size() - 1);
        LanceRegras lanceRegras = new LanceRegras();
        Lance lance = new Lance(campoNome, item, valor, email);
        List<Leilao> list = new LeilaoDaoSession().BuscarObjeto(item);
        List<Integer> qualquer3 = new ArrayList<>();

        for (Leilao l : list) {
            qualquer3.add(l.getValorMinimo());
        }

        int valorMinino = qualquer3.get(qualquer3.size() - 1);

        lanceRegras.CadastramentoDeLances(lance, veficarNome, veficarvalor, valorMinino);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/entrada?acao=leilaoAberto");

    }
}
