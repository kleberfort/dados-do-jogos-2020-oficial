package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.util;

import com.jogos.dadosoficialkf228920.model.MatchNewModelDate;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface JogosLaLiga_A_2024_2025_Listener {

    public void onJogosLaLiga_A(HashMap<String, Map<String, List<MatchNewModelDate>>> partidasPorTime);

}
