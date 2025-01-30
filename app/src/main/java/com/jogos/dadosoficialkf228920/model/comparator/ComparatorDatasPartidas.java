package com.jogos.dadosoficialkf228920.model.comparator;

import com.jogos.dadosoficialkf228920.model.MatchNewModelDate;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.Comparator;

public class ComparatorDatasPartidas implements Comparator<MatchNewModelDate> {


    @Override
    public int compare(MatchNewModelDate m1, MatchNewModelDate m2) {
        // Substitua "getData()" pelo método correto que retorna a data da partida
        return m2.getDataFormatada().compareTo(m1.getDataFormatada()); // Ordena em ordem decrescente
    }
}
