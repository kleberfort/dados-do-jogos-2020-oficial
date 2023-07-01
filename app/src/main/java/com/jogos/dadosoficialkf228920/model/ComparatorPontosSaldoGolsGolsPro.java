package com.jogos.dadosoficialkf228920.model;

import java.util.Comparator;

public class ComparatorPontosSaldoGolsGolsPro implements Comparator<ClassificacaoOficial> {
    @Override
    public int compare(ClassificacaoOficial t1, ClassificacaoOficial t2) {

        int pontos = Integer.compare(t1.getPontos(), t2.getPontos());
        if (pontos != 0) return pontos;

        int saldoGols = Integer.compare(t1.getSaldoGols(), t2.getSaldoGols());
        if(saldoGols != 0 ) return saldoGols;

        return Integer.compare(t1.getGolsPro(), t2.getGolsPro());
    }
}
