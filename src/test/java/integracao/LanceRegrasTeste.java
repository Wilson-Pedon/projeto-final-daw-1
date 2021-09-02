package integracao;

import DAO.LanceDao;
import model.Lance;
import model.Leilao;
import org.junit.Test;
import regraDeNegocio.LanceRegras;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import regraDeNegocio.LeilaoRegras;


public class LanceRegrasTeste {

    private LanceRegras lr = new LanceRegras();
    private LeilaoRegras le = new LeilaoRegras();
    private LanceDao dao = new LanceDao();


    @Test
    public void CadastraLance(){
        Leilao leilao = new Leilao("PS4", 200,null,"Aberto");
        Lance lance = new Lance("Wilson", "PS4", 500, "wilsonpedon@hotmail.com");
        Lance lance1 = new Lance("Roberto", "PS4", 600, "wilsonpedon1@hotmail.com");
        lr.CadastramentoDeLances(lance1,lance.getNome(),lance.getValor(),leilao.getValorMinimo());
    }


}
