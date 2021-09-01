package regraDeNegocio;

import DAO.LeilaoDao;
import DAO.LeilaoDaoSession;
import acao.ListarLeilao;
import model.Lance;
import model.Leilao;

import javax.servlet.ServletContext;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class LeilaoRegras {

    private LeilaoDaoSession dao = new LeilaoDaoSession();


    public LeilaoRegras(LeilaoDaoSession dao){
        this.dao = dao;
    }

    public LeilaoRegras(){}



    public List filtroLeilaoNome(String status){
        if(status.equals("Todos")) {
            return dao.BuscarTodos();
        }
        else{
            return dao.BuscarNome(status);
        }
    }

    public List buscarApenasAbertos() {
        System.out.println(dao.BuscarNome("Aberto"));
        return dao.BuscarNome("Aberto");
    }

    public void finalizaLeilao(Leilao leilao, String email){
        LanceRegras lanceRegras = new LanceRegras();
        if(leilao.getStatus().equals("Aberto") || leilao.getStatus().equals("Expirado")){
            leilao.setStatus("Finalizado");
            leilao.setId(leilao.getId());
            leilao.setNome(leilao.getNome());
            leilao.setValorMinimo(leilao.getValorMinimo());
            leilao.setData(leilao.getData());
            dao.update(leilao);
            lanceRegras.EnviaEmail(email);
        }
    }

    public void expiraLeilao(Leilao leilao){
        LocalDate date = LocalDate.now();
        String.valueOf(date);
        String.valueOf(leilao.getData());
        if (leilao.getData().equals(date) && !(leilao.getStatus().equals("Expirado"))) {
            leilao.setStatus("Expirado");
            dao.update(leilao);
        }
    }

    public void cadastraInativo(Leilao leilao){
        leilao.setStatus("Inativo");
        dao.Cadastro(leilao);
    }





}
