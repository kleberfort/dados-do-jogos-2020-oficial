package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.ligue1.util;

import com.jogos.dadosoficialkf228920.model.MatchNewModelDate;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface JogosLigue1_A_2024_25_Listener {

    public void onJogosLigue1_A_franca(HashMap<String, Map<String, List<MatchNewModelDate>>> partidasPorTime);

}
