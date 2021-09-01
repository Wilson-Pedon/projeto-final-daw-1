package acao;

import DAO.LanceDao;
import model.Lance;

import java.util.ArrayList;
import java.util.List;

public class valorDiferenteLance {


    public String retornaValor(String nome){

        List<Lance> lista = new LanceDao().Seguinte_Professor_EuFiqueiUmaTardeInteiraPraFazerIsto_ParaNaoUsar_MasComoEUGasteiUmaTardeInteira_ElaVaiFicarAki_TiveQueAprenderHQL(nome);
        List<String> valor = new ArrayList<>();
        for(Lance l : lista) {
            valor.add(l.getNome());
        }
        String veficarNome = valor.get(valor.size() -1);

        return veficarNome;
    }




}
