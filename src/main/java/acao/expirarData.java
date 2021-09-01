package acao;

import DAO.LeilaoDaoSession;
import controler.BancoDeDados;
import model.Leilao;
import regraDeNegocio.LeilaoRegras;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class expirarData {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public expirarData(HttpServletResponse resp, HttpServletRequest req){
        this.resp = resp;
        this.req = req;
    }

    public void executa() throws ServletException, IOException {
        LeilaoDaoSession dao = new LeilaoDaoSession();
        Calendar c = Calendar.getInstance();
        java.util.Date data = c.getTime();
        LocalDate date = dao.convertToLocalDateViaInstant(data);
        List <Leilao> list = new LeilaoDaoSession().BuscarData(date);
        LeilaoRegras leilaoRegras = new LeilaoRegras();
        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                for (Leilao l : list) {
                        leilaoRegras.expiraLeilao(l);
                }
            }
        },0,5000);
    }
}
