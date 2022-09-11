package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.internacional;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.internacional.InternacionalCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.internacional.InternacionalForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.internacional.InternacionalCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.internacional.InternacionalForaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoPRFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentInternacionalFora2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class InternacionalFora2022Fragment extends Fragment {

    private FragmentInternacionalFora2022Binding binding;
    private InternacionalForaA2022Adapter internacionalForaA2022Adapter;
    private InternacionalForaA2022PartidaApi internacionalForaA2022PartidaApi;



    public InternacionalFora2022Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentInternacionalFora2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;




    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/internacional/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        internacionalForaA2022PartidaApi = retrofit.create(InternacionalForaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvInternacionalFora.setHasFixedSize(true);
        binding.rvInternacionalFora.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvInternacionalFora.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        internacionalForaA2022PartidaApi.getInternacionalFora().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    internacionalForaA2022Adapter = new InternacionalForaA2022Adapter(partidas);
                    binding.rvInternacionalFora.setAdapter(internacionalForaA2022Adapter);
                }else {
                    erroBuscaDados();
                }
            }

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {

            }
        });

    }

    private void erroBuscaDados() {
    }
}