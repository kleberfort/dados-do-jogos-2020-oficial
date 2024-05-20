package com.jogos.dadosoficialkf228920.model.comparator;

import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.Comparator;

public class ComparatorDatasPartidas implements Comparator<PartidaNovoModelo> {


    @Override
    public int compare(PartidaNovoModelo partida1, PartidaNovoModelo partida2) {
        return partida2.getDataFormatada().compareTo(partida1.getDataFormatada());
    }



}
