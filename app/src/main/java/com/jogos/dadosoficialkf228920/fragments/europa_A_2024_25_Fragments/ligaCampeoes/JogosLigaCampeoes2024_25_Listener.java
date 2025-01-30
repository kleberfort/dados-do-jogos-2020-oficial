package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.ligaCampeoes;

import com.jogos.dadosoficialkf228920.model.MatchNewModelDate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface JogosLigaCampeoes2024_25_Listener {

    public void onJogosLigaCampeoes2024_25(HashMap<String, Map<String, List<MatchNewModelDate>>> partidasPorTime);
}
