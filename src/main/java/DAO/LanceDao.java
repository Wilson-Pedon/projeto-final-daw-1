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

    public static void main(String[] args) {

        BancoDeDados conexao = new BancoDeDados();
        LanceDao dao = new LanceDao();
        Lance lance = new Lance();
        //dao.BuscaNomedoCabraLaPraVerSeONomeEIgualAoUtimo((Lance) list);

        //System.out.println(dao.BuscaNomedoCabraLaPraVerSeONomeEIgualAoUtimo((Lance) list));

//        lance.setObjeto("rtx 3060");
//        lance.setNome("admin");
//        lance.setValor(1);
//        dao.Cadastro(lance);

        List <Lance> list = new LanceDao().Seguinte_Professor_EuFiqueiUmaTardeInteiraPraFazerIsto_ParaNaoUsar_MasComoEUGasteiUmaTardeInteira_ElaVaiFicarAki_TiveQueAprenderHQL("Ps5");
        List<String> valor = new ArrayList<>();
        for(Lance l : list) {
            valor.add(l.getNome());
        }
        String veficarNome = valor.get(valor.size() -1);
        System.out.println(veficarNome);

    }

}







