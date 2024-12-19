package com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.util;

import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface JogosPremierLeague_A_2024_2025_Listener {


    public void onJogosPremierLeague_A(HashMap<String, Map<String, List<PartidaNovoModelo>>> partidasPorTime);

}
