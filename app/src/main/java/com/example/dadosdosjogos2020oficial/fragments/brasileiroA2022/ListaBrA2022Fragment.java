package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.dadosdosjogos2020oficial.activity.CearaActivity;
import com.example.dadosdosjogos2020oficial.adapter.TimesBrA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.TimesBrA2022Api;
import com.example.dadosdosjogos2020oficial.databinding.FragmentListaBrA2022Binding;
import com.example.dadosdosjogos2020oficial.model.RecyclerItemClickListener;
import com.example.dadosdosjogos2020oficial.model.TimesBrA2022;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListaBrA2022Fragment extends Fragment {

    private FragmentListaBrA2022Binding binding;
    private TimesBrA2022Api timesBrA2022Api;
    private TimesBrA2022Adapter timesBrA2022Adapter;


    public ListaBrA2022Fragment() {
        // Required empty public constructor
    }


/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentListaBrA2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupHttpClient();
        setupListaTimes();



        // Inflate the layout for this fragment
        return view;
    }



    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kleberfort.github.io/dados-jogos-partidas-oficial-2022-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        timesBrA2022Api = retrofit.create(TimesBrA2022Api.class);

    }

    private void setupListaTimes() {
        binding.rvConteudo.setHasFixedSize(true);
        binding.rvConteudo.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvConteudo.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        timesBrA2022Api.getTimesBrA2022().enqueue(new Callback<List<TimesBrA2022>>() {
            @Override
            public void onResponse(Call<List<TimesBrA2022>> call, Response<List<TimesBrA2022>> response) {
                if(response.isSuccessful()){
                    List<TimesBrA2022> listaDeTimes = response.body();
                    timesBrA2022Adapter = new TimesBrA2022Adapter(listaDeTimes);
                    binding.rvConteudo.setAdapter(timesBrA2022Adapter);

                    binding.rvConteudo.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvConteudo, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            //TimesBrA2022 timesBrA2022 = listaDeTimes.get(position);

                            if(position == 7){
                                Intent intent = new Intent(getContext(), CearaActivity.class);
                                startActivity(intent);

                            }







                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    }));

                }else{
                    errorMensagem();
                }
            }

            @Override
            public void onFailure(Call<List<TimesBrA2022>> call, Throwable t) {
                errorMensagem();
            }
        });

    }

    private void errorMensagem() {

        Snackbar.make(binding.getRoot(), "Error ao buscar dados da Api", Snackbar.LENGTH_LONG).show();

    }



}