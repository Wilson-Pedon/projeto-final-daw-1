package acao;

import DAO.LeilaoDao;
import DAO.LeilaoDaoSession;
import model.Leilao;
import regraDeNegocio.LeilaoRegras;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FiltroLeilao {


    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public FiltroLeilao(HttpServletResponse resp, HttpServletRequest req){
        this.resp = resp;
        this.req = req;
    }

    public void executa() throws ServletException, IOException {
        String tipo = req.getParameter("filtro-status");
        System.out.println("O tipo de status é : " + tipo);

                List <Leilao> list = new LeilaoRegras().filtroLeilaoNome(tipo);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/listadeleiloes.jsp");
                req.setAttribute("list", list);
                dispatcher.forward(req, resp);

//            if (tipo.equals("Aberto")) {
//
//                System.out.println("Entrou no Aberto");
//                List <Leilao> list = new LeilaoDaoSession().BuscarNome("Aberto");
//
//                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/listadeleiloes.jsp");
//                req.setAttribute("list", list);
//                dispatcher.forward(req, resp);
//
//            }else if(tipo.equals("Todos")){
//
//                System.out.println("Entrou no Todos");
//                ListarLeilao listarLeilao = new ListarLeilao(resp,req);
//                listarLeilao.executa();
//
//            }else if(tipo.equals("Finalizado")){
//
//                System.out.println("Entrou no Fechado");
//                List <Leilao> list = new LeilaoDaoSession().BuscarNome("Finalizado");
//                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/listadeleiloes.jsp");
//                req.setAttribute("list", list);
//                dispatcher.forward(req, resp);
//
//            }else if(tipo.equals("Expirado")){
//
//                System.out.println("Entrou no Expirado");
//                List <Leilao> list = new LeilaoDaoSession().BuscarNome("Expirado");
//                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/listadeleiloes.jsp");
//                req.setAttribute("list", list);
//                dispatcher.forward(req, resp);
//
//            }else if(tipo.equals("Inativo")){
//
//                System.out.println("Entrou no Inativo");
//                List <Leilao> list = new LeilaoDaoSession().BuscarNome("inativo");
//                RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/listadeleiloes.jsp");
//                req.setAttribute("list", list);
//                dispatcher.forward(req, resp);
//            }
    }


}


