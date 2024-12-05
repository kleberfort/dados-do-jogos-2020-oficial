package com.jogos.dadosoficialkf228920.util.estatistica_util.geral_dois_times;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jogos.dadosoficialkf228920.adapter.brasil2024.ResultadosPartidasAdapter;
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaEscanteiosBinding;
import com.jogos.dadosoficialkf228920.databinding.TelaEstatisticaOficialPorcentagemBinding;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.ArrayList;
import java.util.List;

public class ForaGeralEstatisticaUtilFragment extends Fragment {

    private TelaEstatisticaOficialPorcentagemBinding binding;

    private ResultadosPartidasAdapter resultadosPartidasAdapter;

    private int golsTotalPrimeiroTempoZeroCincoMarcados;
    private int golsTotalPrimeiroTempoZeroCincoNaoMarcados;

    private int golsTotalPrimeiroTempoUmCincoMarcados;
    private int golsTotalPrimeiroTempoUmCincoNaoMarcados;


    private int golsTotalSegundoTempoZeroCincoMarcados;
    private int golsTotalSegundoTempoZeroCincoNaoMarcados;

    private int golsTotalSegundoTempoUmCincoMarcados;
    private int golsTotalSegundoTempoUmCincoNaoMarcados;

    private int golsTotalZeroCincoMarcados;
    private int golsTotalZeroCincoNaoMarcados;

    private int golsTotalUmCincoMarcados;
    private int golsTotalUmCincoNaoMarcados;

    private int golsTotalDoisCincoMarcados;
    private int golsTotalDoisCincoNaoMarcados;

    private int totalAmbasMarcados;
    private int totalAmbasNaoMarcados;

    private int escanteiosTotalPrimeiroTempoMaiorIgualCincoMarcados;
    private int escanteiosTotalPrimeiroTempoMaiorIgualCincoNaoMarcados;

    private int escanteiosTotalSegundoTempoMaiorIgualCincoMarcados;
    private int escanteiosTotalSegundoTempoMaiorIgualCincoNaoMarcados;

    private int escanteiosTotalMaiorIgualOitoMarcados;
    private int escanteiosTotalMaiorIgualOitoNaoMarcados;

    private int escanteiosTotalMaiorIgualNoveMarcados;
    private int escanteiosTotalMaiorIgualNoveNaoMarcados;

    private int escanteiosTotalMaiorIgualDezMarcados;
    private int escanteiosTotalMaiorIgualDezNaoMarcados;



    private int totalVitoria;
    private int totalEmpate;
    private int totalDerrota;



    private List<PartidaNovoModelo> partidas = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TelaEstatisticaOficialPorcentagemBinding.inflate(inflater, container, false);


        return binding.getRoot();

    }
}
