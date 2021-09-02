package DAO;

import model.Lance;
import controler.BancoDeDados;
import model.Leilao;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class LanceDao {


    BancoDeDados conexao = new BancoDeDados();

    public void Cadastro(Lance lance){
        conexao.session.beginTransaction();
        conexao.session.save(lance);
        conexao.session.getTransaction().commit();
    }

    public List BuscarTodos(){
        return conexao.session.createQuery("FROM " + Lance.class.getName()).getResultList();
    }

    public List BuscarObjeto(String nome){
        Query query = conexao.session.createQuery("from Lance where objeto = :nome ");
        query.setParameter("nome", nome);
        return query.getResultList();
    }

    public List Seguinte_Professor_EuFiqueiUmaTardeInteiraPraFazerIsto_ParaNaoUsar_MasComoEUGasteiUmaTardeInteira_ElaVaiFicarAki_TiveQueAprenderHQL(String nome){
        Query query = conexao.session.createQuery("from Lance lance" +
                " where objeto = :nome" +
                " ORDER BY lance.id");
        query.setParameter("nome", nome);
        return query.getResultList();
    }

    public void deleta(int IDleilao) {
        conexao.session.getTransaction().begin();
        Lance lance = conexao.session.find(Lance.class, IDleilao);
        conexao.session.remove(lance);
        conexao.session.getTransaction().commit();
    }



}







