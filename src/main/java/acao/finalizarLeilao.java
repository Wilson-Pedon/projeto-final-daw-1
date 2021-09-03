package acao;

import DAO.LanceDao;
import DAO.LeilaoDaoSession;
import model.Lance;
import model.Leilao;
import regraDeNegocio.LanceRegras;
import regraDeNegocio.LeilaoRegras;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class finalizarLeilao {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public finalizarLeilao(HttpServletResponse resp, HttpServletRequest req) {
        this.resp = resp;
        this.req = req;
    }

    public void executa() throws ServletException, IOException {
        LanceRegras lanceRegras = new LanceRegras();
        int id = Integer.valueOf(req.getParameter("id"));
        String nome = req.getParameter("nome");
        Integer valor = Integer.valueOf(req.getParameter("valor"));
        LocalDate data = LocalDate.parse(req.getParameter("data"));
        String status = req.getParameter("status");
        Leilao leilao = new Leilao(id, nome, valor, data, status);
        //=============================================================
        LeilaoRegras leilaoRegras = new LeilaoRegras();
        String email = lanceRegras.UtimoLance(nome);
        String texto = "Parabens o Senhor Ganhou o leilao do" + nome + "";
        leilaoRegras.finalizaLeilao(leilao, email, texto);
        ListarLeilao listarLeilao = new ListarLeilao(resp, req);
        listarLeilao.executa();
    }
}

