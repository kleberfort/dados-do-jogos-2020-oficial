package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.eredivisie.util;

import com.jogos.dadosoficialkf228920.model.MatchNewModelDate;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface JogosEredivisie_A_2024_25_Listener {

    public void onJogosEredivisie_A(HashMap<String, Map<String, List<MatchNewModelDate>>> partidasPorTime);

}
