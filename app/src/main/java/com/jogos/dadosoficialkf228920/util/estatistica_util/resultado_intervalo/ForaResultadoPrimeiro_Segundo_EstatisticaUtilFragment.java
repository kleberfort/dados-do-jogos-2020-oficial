package com.jogos.dadosoficialkf228920.util.estatistica_util.resultado_intervalo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadoPartidaSegundoTempoAdapter;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadosPartidasPrimeiroTempoAdapter;
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaEscanteiosBinding;
import com.jogos.dadosoficialkf228920.databinding.TelaResultadoPrimeiroSegundoTempoBinding;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.ArrayList;
import java.util.List;

public class ForaResultadoPrimeiro_Segundo_EstatisticaUtilFragment extends Fragment {

    private TelaResultadoPrimeiroSegundoTempoBinding binding;
    private ResultadosPartidasPrimeiroTempoAdapter resultadosPartidasPrimeiroTempoAdapter;

    private ResultadoPartidaSegundoTempoAdapter resultadoPartidaSegundoTempoAdapter;

    private int vitoriaPrimeiroTempo;
    private int empatePrimeiroTempo;
    private int derrotaPrimeiroTempo;

    private int vitoriaSegundoTempo;
    private int empateSegundoTempo;
    private int derrotaSegundoTempo;

    private List<PartidaNovoModelo> partidas = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TelaResultadoPrimeiroSegundoTempoBinding.inflate(inflater, container, false);


        return binding.getRoot();

    }
}
