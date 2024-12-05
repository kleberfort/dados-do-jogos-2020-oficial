package com.jogos.dadosoficialkf228920.util.estatistica_util.gols;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadoPartidaSegundoTempoAdapter;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadosPartidasAdapter;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadosPartidasPrimeiroTempoAdapter;
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaEscanteiosBinding;
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaGolsBinding;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.ArrayList;
import java.util.List;

public class ForaGolsSofridoEstatisticaUtilFragment extends Fragment {
    private TelaEstatisticaGolsBinding binding;

    private ResultadosPartidasAdapter resultadosPartidasAdapter;
    private ResultadosPartidasPrimeiroTempoAdapter resultadosPartidasPrimeiroTempoAdapter;
    private ResultadoPartidaSegundoTempoAdapter resultadoPartidaSegundoTempoAdapter;



    private int golsTotalPrimeiroTempoZeroCincoMarcados;
    private int golsTotalPrimeiroTempoZeroCincoNaoMarcados;

    private int golsTotalPrimeiroTempoUmCincoMarcados;
    private int golsTotalPrimeiroTempoUmCincoNaoMarcados;

    private int golsTotalPrimeiroTempoDoisCincoMarcados;
    private int golsTotalPrimeiroTempoDoisCincoNaoMarcados;


    private int golsTotalSegundoTempoZeroCincoMarcados;
    private int golsTotalSegundoTempoZeroCincoNaoMarcados;

    private int golsTotalSegundoTempoUmCincoMarcados;
    private int golsTotalSegundoTempoUmCincoNaoMarcados;


    private int golsTotalSegundoTempoDoisCincoMarcados;
    private int golsTotalSegundoTempoDoisCincoNaoMarcados;





    private int golsTotalZeroCincoMarcados;
    private int golsTotalZeroCincoNaoMarcados;

    private int golsTotalUmCincoMarcados;
    private int golsTotalUmCincoNaoMarcados;

    private int golsTotalDoisCincoMarcados;
    private int golsTotalDoisCincoNaoMarcados;


    private int golsTotalTresCincoMarcados;
    private int golsTotalTresCincoNaoMarcados;

    private List<PartidaNovoModelo> partidas = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TelaEstatisticaGolsBinding.inflate(inflater, container, false);


        return binding.getRoot();

    }

}
