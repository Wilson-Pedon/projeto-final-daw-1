package integracao;

import DAO.LanceDao;
import DAO.LeilaoDaoSession;
import model.Lance;
import model.Leilao;
import org.junit.Test;
import regraDeNegocio.LanceRegras;
import regraDeNegocio.LeilaoRegras;
import static org.junit.Assert.assertEquals;



import java.time.LocalDate;
import java.util.List;

public class LeilaoRegrasTeste {

    private LeilaoRegras leilaoRegras = new LeilaoRegras();
    private LeilaoDaoSession dao = new LeilaoDaoSession();
    private LanceDao daoLance = new LanceDao();
    private LanceRegras lanceRegras = new LanceRegras();


    @Test
    public void filtraTodos(){
       List<Leilao> list =  leilaoRegras.filtroLeilaoNome("Todos");
       List<Leilao> listBanco =  dao.BuscarTodos();
       assertEquals(list.size(), listBanco.size());
    }

    @Test
    public void umLeilaoSoPodeSerCadastradoInativo(){
        Leilao leilao = new Leilao(10,"jojo", 50,null,"Aberto");
        leilaoRegras.cadastraInativo(leilao);
        assertEquals("jojo", leilao.getNome());
    }

    @Test
    public void finalizaLeilao(){
        Leilao leilao = new Leilao("wiLson", 50, null, "Aberto");
        dao.Cadastro(leilao);
        Lance lance = new Lance("Wilson", "wiLson", 500, "netofelipeferreira1@gmail.com");
        daoLance.Cadastro(lance);
        String email = lanceRegras.UtimoLance("wiLson");
        leilaoRegras.finalizaLeilao(leilao, email, email);
        assertEquals("Finalizado", leilao.getStatus());
        leilao.setStatus(leilao.getStatus());
    }

    @Test
    public void expiraData(){
        Leilao leilao = new Leilao("wiLson", 50, LocalDate.parse("2021-09-02"), "Aberto");
        leilaoRegras.expiraLeilao(leilao);
        assertEquals("Expirado", leilao.getStatus());
    }



}
