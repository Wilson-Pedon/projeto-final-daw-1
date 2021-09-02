package DAO;

import controler.BancoDeDados;
import model.Leilao;

import javax.persistence.Query;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class LeilaoDaoSession {

    private final BancoDeDados conexao = new BancoDeDados();
    Leilao leilao = new Leilao();

    public void Cadastro(Leilao leilao){
        conexao.session.beginTransaction();
        conexao.session.save(leilao);
        conexao.session.getTransaction().commit();

    }

    public List BuscarTodos(){
        return BancoDeDados.session.createQuery("FROM " + Leilao.class.getName()).getResultList();
    }

    public List BuscarNome(String nome){
        Query query = conexao.session.createQuery("from Leilao where status = :nome ");
        query.setParameter("nome", nome);
        return query.getResultList();
    }

    public List BuscarObjeto(String nome){
        Query query = conexao.session.createQuery("from Leilao where nome = :nome ");
        query.setParameter("nome", nome);
        return query.getResultList();
    }

    public List BuscarData(LocalDate nome){
        Query query = conexao.session.createQuery("from Leilao where data = :nome ");
        query.setParameter("nome", nome);
        return query.getResultList();
    }

    public void deleta(int IDleilao) {
        conexao.session.getTransaction().begin();
        Leilao leilao = conexao.session.find(Leilao.class, IDleilao);
        conexao.session.remove(leilao);
        conexao.session.getTransaction().commit();
    }

    public void carregar(int IDleilao){
        conexao.session.getTransaction().begin();
        conexao.session.load(Leilao.class, IDleilao);
        conexao.session.getTransaction().commit();
    }

    public Leilao buscar(int id){
        return conexao.session.find(Leilao.class, id);
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public void update(Leilao leilao){
        try{
        conexao.session.getTransaction().begin();
        System.out.println("O leilao é : " + leilao);
        conexao.session.merge(leilao);
        conexao.session.getTransaction().commit();

        }catch (Exception ex){
            System.out.println("Não foi !!!");
        }
    }

}
