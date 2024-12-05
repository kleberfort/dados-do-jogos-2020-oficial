package com.jogos.dadosoficialkf228920.util.estatistica_util.escanteios;

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
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaCartoesBinding;
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaEscanteiosBinding;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.ArrayList;
import java.util.List;

public class CasaEscanteiosEstatisticaUtilFragment extends Fragment {
    private TelaEstatisticaEscanteiosBinding binding;

    private ArrayList<PartidaNovoModelo> partidasCasa; // Ajuste o tipo conforme necessário
    private String nomeTime;
    private ResultadosPartidasAdapter resultadosPartidasAdapter;
    private ResultadosPartidasPrimeiroTempoAdapter resultadosPartidasPrimeiroTempoAdapter;
    private ResultadoPartidaSegundoTempoAdapter resultadoPartidaSegundoTempoAdapter;

    private int escanteiosPrimeiroTempoZeroCincoMarcados;
    private int escanteiosPrimeiroTempoZeroCincoNaoMarcados;


    private int escanteiosPrimeiroTempoUmCincoMarcados;
    private int escanteiosPrimeiroTempoUmCincoNaoMarcados;

    private int escanteiosPrimeiroTempoDoisCincoMarcados;
    private int escanteiosPrimeiroTempoDoisCincoNaoMarcados;

    private int escanteiosPrimeiroTempoTresCincoMarcados;
    private int escanteiosPrimeiroTempoTresCincoNaoMarcados;


    private int escanteiosSegundoTempoZeroCincoMarcados;
    private int escanteiosSegundoTempoZeroCincoNaoMarcados;


    private int escanteiosSegundoTempoUmCincoMarcados;
    private int escanteiosSegundoTempoUmCincoNaoMarcados;

    private int escanteiosSegundoTempoDoisCincoMarcados;
    private int escanteiosSegundoTempoDoisCincoNaoMarcados;

    private int escanteiosSegundoTempoTresCincoMarcados;
    private int escanteiosSegundoTempoTresCincoNaoMarcados;


    private int escanteiosTotalZeroCincoMarcados;
    private int escanteiosTotalZeroCincoNaoMarcados;

    private int escanteiosTotalUmCincoMarcados;
    private int escanteiosTotalUmCincoNaoMarcados;

    private int escanteiosTotalDoisCincoMarcados;
    private int escanteiosTotalDoisCincoNaoMarcados;

    private int escanteiosTotalTresCincoMarcados;
    private int escanteiosTotalTresCincoNaoMarcados;

    private int escanteiosTotalQuatroCincoMarcados;
    private int escanteiosTotalQuatroCincoNaoMarcados;

    private int escanteiosTotalCincoCincoMarcados;
    private int escanteiosTotalCincoCincoNaoMarcados;

    private List<PartidaNovoModelo> partidas = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TelaEstatisticaEscanteiosBinding.inflate(inflater, container, false);


        return binding.getRoot();

    }
}
