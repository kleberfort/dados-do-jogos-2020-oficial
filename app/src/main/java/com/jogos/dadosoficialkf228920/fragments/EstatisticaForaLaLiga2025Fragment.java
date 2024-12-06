package com.jogos.dadosoficialkf228920.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.FragmentEstatisticaCasaLaLiga2025Binding;
import com.jogos.dadosoficialkf228920.databinding.FragmentEstatisticaForaLaLiga2025Binding;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.util.estatistica_util.cartoes.CasaCartoesEstatisticaUtilFragment;
import com.jogos.dadosoficialkf228920.util.estatistica_util.cartoes.ForaCartoesEstatisticaUtilFragment;
import com.jogos.dadosoficialkf228920.util.estatistica_util.escanteios.CasaEscanteiosEstatisticaUtilFragment;
import com.jogos.dadosoficialkf228920.util.estatistica_util.escanteios.ForaEscanteiosEstatisticaUtilFragment;
import com.jogos.dadosoficialkf228920.util.estatistica_util.geral_dois_times.CasaGeralEstatisticaUtilFragment;
import com.jogos.dadosoficialkf228920.util.estatistica_util.geral_dois_times.ForaGeralEstatisticaUtilFragment;
import com.jogos.dadosoficialkf228920.util.estatistica_util.gols.CasaGolsEstatisticaUtilFragment;
import com.jogos.dadosoficialkf228920.util.estatistica_util.gols.CasaGolsSofridoEstatisticaUtilFragment;
import com.jogos.dadosoficialkf228920.util.estatistica_util.gols.ForaGolsEstatisticaUtilFragment;
import com.jogos.dadosoficialkf228920.util.estatistica_util.gols.ForaGolsSofridoEstatisticaUtilFragment;
import com.jogos.dadosoficialkf228920.util.estatistica_util.resultado_intervalo.CasaResultadoPrimeiro_Segunto_EstatisticaUtilFragment;
import com.jogos.dadosoficialkf228920.util.estatistica_util.resultado_intervalo.ForaResultadoPrimeiro_Segundo_EstatisticaUtilFragment;

import java.util.ArrayList;


public class EstatisticaForaLaLiga2025Fragment extends Fragment {

    private FragmentEstatisticaForaLaLiga2025Binding binding;
    private ArrayList<PartidaNovoModelo> partidasFora; // Ajuste o tipo conforme necessário
    private String nomeTime;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout with View Binding
        binding = FragmentEstatisticaForaLaLiga2025Binding.inflate(inflater, container, false);

        // Recuperar os argumentos passados para o fragmento
        if (getArguments() != null) {
            partidasFora = getArguments().getParcelableArrayList("partidas_fora");
            nomeTime = getArguments().getString("nome_time");
        }

        // Adicionar fragments dinamicamente
        carregarFragments();

        return binding.getRoot();
    }

    private void carregarFragments() {
        ForaGeralEstatisticaUtilFragment fragmentForaGeral = new ForaGeralEstatisticaUtilFragment();
        ForaResultadoPrimeiro_Segundo_EstatisticaUtilFragment fragmentForaResultado = new ForaResultadoPrimeiro_Segundo_EstatisticaUtilFragment();
        ForaGolsEstatisticaUtilFragment fragmentForaGolsMarcados = new ForaGolsEstatisticaUtilFragment();
        ForaGolsSofridoEstatisticaUtilFragment fragmentForaGolsSofrido = new ForaGolsSofridoEstatisticaUtilFragment();
        ForaCartoesEstatisticaUtilFragment fragmentForaCartoes = new ForaCartoesEstatisticaUtilFragment();
        ForaEscanteiosEstatisticaUtilFragment fragmentForaEscanteios = new ForaEscanteiosEstatisticaUtilFragment();


        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("partidas_fora", partidasFora); // Envia a lista
        bundle.putString("nome_time", nomeTime); // Envia o nome do time


        fragmentForaGeral.setArguments(bundle);
        fragmentForaResultado.setArguments(bundle);
        fragmentForaGolsMarcados.setArguments(bundle);
        fragmentForaGolsSofrido.setArguments(bundle);
        fragmentForaCartoes.setArguments(bundle);
        fragmentForaEscanteios.setArguments(bundle);

        // Adicionar os fragmentos
        adicionarFragmento(fragmentForaGeral);
        adicionarFragmento(fragmentForaResultado);
        adicionarFragmento(fragmentForaGolsMarcados);
        adicionarFragmento(fragmentForaGolsSofrido);
        adicionarFragmento(fragmentForaCartoes);
        adicionarFragmento(fragmentForaEscanteios);


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