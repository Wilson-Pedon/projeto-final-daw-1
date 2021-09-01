package integracao;

import DAO.LanceDao;
import DAO.LeilaoDaoSession;
import model.Lance;
import model.Leilao;
import org.junit.Test;
import regraDeNegocio.LanceRegras;
import regraDeNegocio.LeilaoRegras;


import java.time.LocalDate;
import java.util.List;

public class LeilaoRegrasTeste {

    private LeilaoRegras leilaoRegras = new LeilaoRegras();
    private LeilaoDaoSession dao = new LeilaoDaoSession();
    private LanceDao daoLance = new LanceDao();
    private LanceRegras lanceRegras = new LanceRegras();


    @Test
    public void CadastraLance(){
       List<Leilao> list =  leilaoRegras.filtroLeilaoNome("Todos");
       System.out.println(list.size());
       List<Leilao> listBanco =  dao.BuscarTodos();
       System.out.println(listBanco.size());

    }

    @Test
    public void umLeilaoSoPodeSerCadastradoInativo(){
        Leilao leilao = new Leilao("jojo", 50,null,"Aberto");
        leilaoRegras.cadastraInativo(leilao);
    }

    @Test
    public void finalizaLeilao(){
        Leilao leilao = new Leilao("wiLson", 50, null, "Aberto");
        dao.Cadastro(leilao);
        Lance lance = new Lance("Wilson", "wiLson", 500, "netofelipeferreira1@gmail.com");
        daoLance.Cadastro(lance);
        String email = lanceRegras.UtimoLance("wiLson");
        leilaoRegras.finalizaLeilao(leilao, email);
    }

    @Test
    public void expiraData(){
        Leilao leilao = new Leilao("wiLson", 50, LocalDate.parse("2021-09-01"), "Aberto");
        dao.Cadastro(leilao);
        leilaoRegras.expiraLeilao(leilao);
    }



}
