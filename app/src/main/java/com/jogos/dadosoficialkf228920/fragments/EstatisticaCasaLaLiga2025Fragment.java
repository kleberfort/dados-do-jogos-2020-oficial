package com.jogos.dadosoficialkf228920.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.jogos.dadosoficialkf228920.databinding.FragmentEstatisticaCasaLaLiga2025Binding;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.util.estatistica_util.cartoes.CasaCartoesEstatisticaUtilFragment;
import com.jogos.dadosoficialkf228920.util.estatistica_util.escanteios.CasaEscanteiosEstatisticaUtilFragment;
import com.jogos.dadosoficialkf228920.util.estatistica_util.geral_dois_times.CasaGeralEstatisticaUtilFragment;
import com.jogos.dadosoficialkf228920.util.estatistica_util.gols.CasaGolsEstatisticaUtilFragment;
import com.jogos.dadosoficialkf228920.util.estatistica_util.gols.CasaGolsSofridoEstatisticaUtilFragment;
import com.jogos.dadosoficialkf228920.util.estatistica_util.resultado_intervalo.CasaResultadoPrimeiro_Segunto_EstatisticaUtilFragment;

import java.util.ArrayList;


public class EstatisticaCasaLaLiga2025Fragment extends Fragment {

    private FragmentEstatisticaCasaLaLiga2025Binding binding;
    private ArrayList<PartidaNovoModelo> partidasCasa; // Ajuste o tipo conforme necessário
    private String nomeTime;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout with View Binding
        binding = FragmentEstatisticaCasaLaLiga2025Binding.inflate(inflater, container, false);

        // Recuperar os argumentos passados para o fragmento
        if (getArguments() != null) {
            partidasCasa = getArguments().getParcelableArrayList("partidas_casa");
            nomeTime = getArguments().getString("nome_time");
        }

        // Adicionar fragments dinamicamente
        carregarFragments();

        return binding.getRoot();
    }

    private void carregarFragments() {
        CasaGeralEstatisticaUtilFragment fragmentCasaGeral = new CasaGeralEstatisticaUtilFragment();
        CasaResultadoPrimeiro_Segunto_EstatisticaUtilFragment fragmentcasaResultado = new CasaResultadoPrimeiro_Segunto_EstatisticaUtilFragment();
        CasaGolsEstatisticaUtilFragment fragmentCasaGolsMarcados = new CasaGolsEstatisticaUtilFragment();
        CasaGolsSofridoEstatisticaUtilFragment fragmentCasaGolsSofrido = new CasaGolsSofridoEstatisticaUtilFragment();
        CasaCartoesEstatisticaUtilFragment fragmentCasaCartoes = new CasaCartoesEstatisticaUtilFragment();
        CasaEscanteiosEstatisticaUtilFragment fragmentCasaEscanteios = new CasaEscanteiosEstatisticaUtilFragment();


        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("partidas_casa", partidasCasa); // Envia a lista
        bundle.putString("nome_time", nomeTime); // Envia o nome do time


        fragmentCasaGeral.setArguments(bundle);
        fragmentcasaResultado.setArguments(bundle);
        fragmentCasaGolsMarcados.setArguments(bundle);
        fragmentCasaGolsSofrido.setArguments(bundle);
        fragmentCasaCartoes.setArguments(bundle);
        fragmentCasaEscanteios.setArguments(bundle);

        // Adicionar os fragmentos
        adicionarFragmento(fragmentCasaGeral);
        adicionarFragmento(fragmentcasaResultado);
        adicionarFragmento(fragmentCasaGolsMarcados);
        adicionarFragmento(fragmentCasaGolsSofrido);
        adicionarFragmento(fragmentCasaCartoes);
        adicionarFragmento(fragmentCasaEscanteios);


    }

    private void adicionarFragmento(Fragment fragment) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        View fragmentContainer = new FrameLayout(requireContext());
        int containerId = View.generateViewId(); // Gerar ID único para cada fragmento
        fragmentContainer.setId(containerId);

        // Adicionar dinamicamente ao LinearLayout
        binding.containerFragmentos.addView(fragmentContainer,
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                ));

        // Adicionar o fragmento ao FrameLayout
        transaction.add(containerId, fragment);
        transaction.commit();
    }

}