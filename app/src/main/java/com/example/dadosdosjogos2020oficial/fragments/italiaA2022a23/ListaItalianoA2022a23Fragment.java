package com.example.dadosdosjogos2020oficial.fragments.italiaA2022a23;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.adapter.italiaA2022a23.TimesItalianoA2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.italiaA2022a23.TimesItalianoA2022a23Api;
import com.example.dadosdosjogos2020oficial.databinding.FragmentListaItalianoA2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.ListaTimeCampeonatoPrincipal;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListaItalianoA2022a23Fragment extends Fragment {

    private FragmentListaItalianoA2022a23Binding binding;
    private TimesItalianoA2022a23Adapter timesItalianoA2022a23Adapter;
    private TimesItalianoA2022a23Api timesItalianoA2022a23Api;



    public ListaItalianoA2022a23Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentListaItalianoA2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupListaTimes();

        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/italia-a-2022-23/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        timesItalianoA2022a23Api = retrofit.create(TimesItalianoA2022a23Api.class);


    }

    private void setupListaTimes() {

        binding.rvListaItalianoA2022a23.setHasFixedSize(true);
        binding.rvListaItalianoA2022a23.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaItalianoA2022a23.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        timesItalianoA2022a23Api.getTimesItalianoA2022a2023().enqueue(new Callback<List<ListaTimeCampeonatoPrincipal>>() {
            @Override
            public void onResponse(Call<List<ListaTimeCampeonatoPrincipal>> call, Response<List<ListaTimeCampeonatoPrincipal>> response) {
                if(response.isSuccessful()){
                    List<ListaTimeCampeonatoPrincipal> listaDeTimes = response.body();
                    timesItalianoA2022a23Adapter = new TimesItalianoA2022a23Adapter(listaDeTimes);
                    binding.rvListaItalianoA2022a23.setAdapter(timesItalianoA2022a23Adapter);
                }else{
                    errorMensagem();
                }
            }

            @Override
            public void onFailure(Call<List<ListaTimeCampeonatoPrincipal>> call, Throwable t) {
                    errorMensagem();
            }
        });

    }

    private void errorMensagem() {
        Snackbar.make(binding.getRoot(), "Verifique a conexão de Internet", Snackbar.LENGTH_LONG).show();
    }
}