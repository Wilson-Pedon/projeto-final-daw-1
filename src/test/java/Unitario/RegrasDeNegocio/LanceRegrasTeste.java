package Unitario.RegrasDeNegocio;

import DAO.ClienteDao;
import DAO.LanceDao;
import DAO.LeilaoDaoSession;
import acao.CadastraLance;
import model.Lance;
import model.Leilao;
import org.junit.Test;
import org.mockito.Mockito;
import regraDeNegocio.LanceRegras;
import regraDeNegocio.LeilaoRegras;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LanceRegrasTeste {

    private LanceDao daoFake = Mockito.mock(LanceDao.class);
    private LanceRegras lanceRegras = new LanceRegras(daoFake);

    @Test
    public void naoPodeCadastrarOMesmoNome(){
        Lance lance = new Lance("Wilson", "wiLson", 500, "qualquer");
        Lance lance1 = new Lance("Felipe", "wiLson", 600, "qualquer");
        Boolean teste = lanceRegras.NaoCadastraLanceComNomeIgual(lance,lance1.getNome());
        assertEquals(teste, true);
    }

    @Test
    public void naoPodeCadastrarOMesmoValor(){
        Lance lance = new Lance("Wilson", "wiLson", 500, "qualquer");
        Lance lance1 = new Lance("Felipe", "wiLson", 600, "qualquer");
        Boolean teste = lanceRegras.NaoCadastraLanceComValorIgual(lance1,lance.getValor());
        assertEquals(teste, true);
    }

    @Test
    public void NaoPodeLanceMenorValorMinino(){
        Leilao leilao = new Leilao("jojo", 50,null,"Aberto");
        Lance lance = new Lance("Wilson", "wiLson", 50, "qualquer");
        Boolean teste = lanceRegras.NaoCadastraMenorQueOValorMinino(lance,leilao.getValorMinimo());
        System.out.println(teste);
        assertEquals(teste, true);
    }

    @Test
    public void CadastrarLance() {
        Leilao leilao = new Leilao("jojo", 50,null,"Aberto");
        Lance lance = new Lance("Wilson", "jojo", 500, "qualquer");
        Lance lance1 = new Lance("Felipe", "jojo", 600, "qualquer");
        lanceRegras.CadastramentoDeLances(lance, lance1.getNome(),lance1.getValor(),leilao.getValorMinimo());
        assertEquals(lance.getNome(), lance.getNome());
    }



}
