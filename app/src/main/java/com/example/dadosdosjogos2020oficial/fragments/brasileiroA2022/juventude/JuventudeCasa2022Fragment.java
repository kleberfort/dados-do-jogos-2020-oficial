package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.juventude;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.internacional.InternacionalForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.juventude.JuventudeCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.internacional.InternacionalCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.juventude.JuventudeCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoPRFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentJuventudeCasa2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JuventudeCasa2022Fragment extends Fragment {

    private FragmentJuventudeCasa2022Binding binding;
    private JuventudeCasaA2022Adapter juventudeCasaA2022Adapter;
    private JuventudeCasaA2022PartidaApi juventudeCasaA2022PartidaApi;




    public JuventudeCasa2022Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentJuventudeCasa2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;




    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/juventude/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        juventudeCasaA2022PartidaApi = retrofit.create(JuventudeCasaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvJuventudeCasa.setHasFixedSize(true);
        binding.rvJuventudeCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvJuventudeCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        juventudeCasaA2022PartidaApi.getJuventudeCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    juventudeCasaA2022Adapter = new JuventudeCasaA2022Adapter(partidas);
                    binding.rvJuventudeCasa.setAdapter(juventudeCasaA2022Adapter);
                }else {
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