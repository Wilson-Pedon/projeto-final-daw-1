package Unitario.RegrasDeNegocio;

import DAO.ClienteDao;
import DAO.LeilaoDaoSession;
import model.Lance;
import model.Leilao;
import org.junit.Test;
import org.mockito.Mockito;
import regraDeNegocio.LeilaoRegras;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LeilaoRegrasTeste {

    private ClienteDao daocliente = Mockito.mock(ClienteDao.class);
    private LeilaoDaoSession daoFake = Mockito.mock(LeilaoDaoSession.class);
    private LeilaoRegras leilaoRegras = new LeilaoRegras(daoFake);


@Test
public void filtraLeilaoPorStatusTodos(){

    List<Leilao> leilao = Arrays.asList
            (new Leilao("wiLson", 50, null, "Aberto"),
            new Leilao("wiLson", 50, null, "Inativo"),
            new Leilao("wiLson", 50, null, "Inativo"),
            new Leilao("wiLson", 50, null, "Finalizado"),
            new Leilao("wiLson", 50, null, "Finalizado"));

    Mockito.when(daoFake.BuscarTodos()).thenReturn(leilao);
    List<Leilao> leilao1 = leilaoRegras.filtroLeilaoNome("Todos");
    System.out.println(leilao1.size());
    assertEquals(leilao.size(), leilao1.size());
}

@Test
public void umLeilaoSoPodeSerCadastradoInativo(){
        Leilao leilao = new Leilao("jojo", 50,null,"Aberto");
        leilaoRegras.cadastraInativo(leilao);
        daoFake.Cadastro(leilao);
        assertEquals("Inativo", leilao.getStatus());
}

@Test
public void finalizaLeilao(){
    LeilaoRegras leilaoRegras = new LeilaoRegras(daoFake);
    Leilao leilao = new Leilao("wiLson", 50, null, "Aberto");
    Lance lance = new Lance("Wilson", "wiLson", 500, "netofelipeferreira1@gmail.com");
    daoFake.Cadastro(leilao);
    leilaoRegras.finalizaLeilao(leilao, null, lance.getEmail());
    assertEquals("Finalizado", leilao.getStatus());
}

@Test
public void expiraData() {
    Leilao leilao = new Leilao("wiLson", 50, LocalDate.parse("2021-09-02"), "Aberto");
    leilaoRegras.expiraLeilao(leilao);
    assertEquals("Expirado", leilao.getStatus());
}



}
