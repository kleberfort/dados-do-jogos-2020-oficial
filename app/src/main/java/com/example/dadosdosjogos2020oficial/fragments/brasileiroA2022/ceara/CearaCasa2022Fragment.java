package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.ceara;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dadosdosjogos2020oficial.adapter.ceara.CearaCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.ceara.CearaCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentCearaCasa2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CearaCasa2022Fragment extends Fragment {

    private FragmentCearaCasa2022Binding binding;
   private CearaCasaA2022PartidaApi cearaCasaA2022PartidaApi;
    private CearaCasaA2022Adapter cearaCasaA2022Adapter;



    public CearaCasa2022Fragment() {
        // Required empty public constructor
    }

 /*

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
*/



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCearaCasa2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/ceara/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cearaCasaA2022PartidaApi = retrofit.create(CearaCasaA2022PartidaApi.class);

    }

    private void setupDadosJogos() {
        binding.rvCearaCasa.setHasFixedSize(true);
        binding.rvCearaCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvCearaCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        cearaCasaA2022PartidaApi.getCearaCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    cearaCasaA2022Adapter = new CearaCasaA2022Adapter(partidas);
                    binding.rvCearaCasa.setAdapter(cearaCasaA2022Adapter);
                }else {
                    erroBuscaDados();
                }
            }

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {
                    erroBuscaDados();
            }
        });


    }

    private void erroBuscaDados() {
        Log.i("ERRO", "Erro na busca dos dados");
    }


}