package DAO;

import controler.BancoDeDados;

import model.Leilao;


import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LeilaoDao {

    private final BancoDeDados conexao = new BancoDeDados();

    public List findAll() {
        return BancoDeDados.em.createQuery("FROM " + Leilao.class.getName()).getResultList();
    }

    public Leilao getID(int id) {
        return conexao.em.find(Leilao.class, id);
    }

    public void delata(int IDLeilao) {
        try {
            conexao.em.getTransaction().begin();
            Leilao leilao = conexao.em.find(Leilao.class, IDLeilao);
            conexao.em.remove(leilao);
            conexao.em.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
            conexao.em.getTransaction().rollback();
        }
    }

    public void update(Leilao leilao){
        try {
            conexao.em.getTransaction().begin();
            conexao.em.merge(leilao);
            conexao.em.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
            conexao.em.getTransaction().rollback();
        }
    }


    public List BuscarObjeto(String nome){
        Query query = conexao.session.createQuery("from Leilao where nome = :nome ");
        query.setParameter("nome", nome);
        return query.getResultList();
    }

}
