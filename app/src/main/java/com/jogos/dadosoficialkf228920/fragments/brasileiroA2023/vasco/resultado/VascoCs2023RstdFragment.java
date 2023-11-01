package com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.vasco.resultado;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.jogos.dadosoficialkf228920.adapter.brasileiroA2023.vasco.resultado.VascoCsA2023RstdAdt;
import com.jogos.dadosoficialkf228920.data.brasileiroA2023.vasco.VascoCasaA2023PartidaApi;
import com.jogos.dadosoficialkf228920.databinding.FragmentVascoCs2023RstdBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class VascoCs2023RstdFragment extends Fragment {

    private FragmentVascoCs2023RstdBinding binding;
    private VascoCasaA2023PartidaApi vascoCasaA2023PartidaApi;
    private VascoCsA2023RstdAdt vascoCsA2023RstdAdt;

    public VascoCs2023RstdFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentVascoCs2023RstdBinding.inflate(inflater, container, false);
        View view = binding.getRoot();



        setupHttpClient();
        setupDadosJogos();




        return view;    }

    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2023/vasco/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        vascoCasaA2023PartidaApi = retrofit.create(VascoCasaA2023PartidaApi.class);



    }

    private void setupDadosJogos() {

        binding.rvListaResultado.setHasFixedSize(true);
        binding.rvListaResultado.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaResultado.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));


        vascoCasaA2023PartidaApi.getVascoCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){

                    List<Partida> partidas = response.body();
                    vascoCsA2023RstdAdt = new VascoCsA2023RstdAdt(partidas);
                    binding.rvListaResultado.setAdapter(vascoCsA2023RstdAdt);

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
        Snackbar.make(binding.getRoot(), "erro ao buscar LISTA dos jogos, Verifique a conexão de Internet, ", Snackbar.LENGTH_LONG).show();
    }
}