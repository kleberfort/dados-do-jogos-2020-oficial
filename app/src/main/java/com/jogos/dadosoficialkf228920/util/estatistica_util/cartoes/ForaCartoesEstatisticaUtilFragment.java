package com.jogos.dadosoficialkf228920.util.estatistica_util.cartoes;

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

public class ForaCartoesEstatisticaUtilFragment extends Fragment {
    private TelaEstatisticaCartoesBinding binding;
    private ResultadosPartidasAdapter resultadosPartidasAdapter;
    private ResultadosPartidasPrimeiroTempoAdapter resultadosPartidasPrimeiroTempoAdapter;
    private ResultadoPartidaSegundoTempoAdapter resultadoPartidaSegundoTempoAdapter;

    //CARTOES AMARELO 0.5 1T
    private int cartoesAmareloPrimeiroTempoZeroCincoMarcados;
    private int cartoesAmareloPrimeiroTempoZeroCincoNaoMarcados;

    //CARTOES AMARELO 1.5 1T
    private int cartoesAmareloPrimeiroTempoUmCincoMarcados;
    private int cartoesAmareloPrimeiroTempoUmCincoNaoMarcados;


    //CARTOES AMARELO 0.5 2T
    private int cartoesAmareloSegundoTempoZeroCincoMarcados;
    private int cartoesAmareloSegundoTempoZeroCincoNaoMarcados;

    //CARTOES AMARELO 1.5 2T
    private int cartoesAmareloSegundoTempoUmCincoMarcados;
    private int cartoesAmareloSegundoTempoUmCincoNaoMarcados;


    //CARTOES VERMELHO 0.5 1T
    private int cartoesVermelhoPrimeiroTempoZeroCincoMarcados;
    private int cartoesVermelhoPrimeiroTempoZeroCincoNaoMarcados;

    //CARTOES VERMELHO 0.5 2T
    private int cartoesVermelhoSegundoTempoZeroCincoMarcados;
    private int cartoesVermelhoSegundoTempoZeroCincoNaoMarcados;

    //CARTOES ACIMA

    private int cartoesAmareloVermelhoTotalZeroCincoMarcados;
    private int cartoesAmareloVermelhoTotalZeroCincoNaoMarcados;

    private int cartoesAmareloVermelhoTotalUmCincoMarcados;
    private int cartoesAmareloVermelhoTotalUmCincoNaoMarcados;

    private int cartoesAmareloVermelhoTotalDoisCincoMarcados;
    private int cartoesAmareloVermelhoTotalDoisCincoNaoMarcados;

    private int cartoesAmareloVermelhoTotalTresCincoMarcados;
    private int cartoesAmareloVermelhoTotalTresCincoNaoMarcados;
    private List<PartidaNovoModelo> partidas = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TelaEstatisticaCartoesBinding.inflate(inflater, container, false);


        return binding.getRoot();

    }

}
