package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.ceara;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.ceara.CearaForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.ceara.CearaForaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentCearaFora2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CearaFora2022Fragment extends Fragment {

    private FragmentCearaFora2022Binding binding;
    private CearaForaA2022PartidaApi cearaForaA2022PartidaApi;
    private CearaForaA2022Adapter cearaForaA2022Adapter;



    public CearaFora2022Fragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCearaFora2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupListaPartidas();



        // Inflate the layout for this fragment
        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/ceara/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cearaForaA2022PartidaApi = retrofit.create(CearaForaA2022PartidaApi.class);


    }

    private void setupListaPartidas() {

        binding.rvCearaFora.setHasFixedSize(true);
        binding.rvCearaFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvCearaFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));


        cearaForaA2022PartidaApi.getCearaFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> listCearaFora = response.body();
                    cearaForaA2022Adapter = new CearaForaA2022Adapter(listCearaFora);
                    binding.rvCearaFora.setAdapter(cearaForaA2022Adapter);
                }else{
                    errorBuscarDados();
                }
            }

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {
                errorBuscarDados();
            }
        });

    }

    private void errorBuscarDados() {
        Snackbar.make(binding.getRoot(), "erro ao buscar dados da API, Verifique a conexão de Internet, ", Snackbar.LENGTH_LONG).show();
    }


}