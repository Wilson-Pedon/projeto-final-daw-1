package acao;

import DAO.LanceDao;
import DAO.LeilaoDaoSession;
import model.Lance;
import model.Leilao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FiltroLance {

    private final HttpServletResponse resp;
    private final HttpServletRequest req;

    public FiltroLance(HttpServletResponse resp, HttpServletRequest req){
        this.resp = resp;
        this.req = req;
    }

    public void executa() throws IOException, ServletException {
        valorDiferenteLance valorLance = new valorDiferenteLance();
        String nome = req.getParameter("nome");
        String item = req.getParameter("nome");
        System.out.println("O tipo de status é : " + nome);
        req.setAttribute("objeto", item);
        System.out.println("O item é:" + item);
        req.setAttribute("nome" , nome);
        List<Lance> list = new LanceDao().BuscarObjeto(nome);


        System.out.println(list);
        List <Lance> lista = new LanceDao().Seguinte_Professor_EuFiqueiUmaTardeInteiraPraFazerIsto_ParaNaoUsar_MasComoEUGasteiUmaTardeInteira_ElaVaiFicarAki_TiveQueAprenderHQL(nome);
        List<String> valor = new ArrayList<>();
        for(Lance l : lista) {
            valor.add(l.getNome());
        }
        String veficarNome = valor.get(valor.size() -1);
        System.out.println(veficarNome);


        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/listalance.jsp");
        dispatcher.forward(req, resp);


    }

}
