package com.example.dadosdosjogos2020oficial.fragments.ceara;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.data.CearaCasa2022Api;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CearaCasa2022Fragment extends Fragment {

    private DadosPartidasAdapterBinding binding;
    private CearaCasa2022Api cearaCasa2022Api;



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

        binding = DadosPartidasAdapterBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;
    }



    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kleberfort.github.io/dados-jogos-partidas-oficial-2022-api/ceara/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cearaCasa2022Api  = retrofit.create(CearaCasa2022Api.class);

    }

    private void setupDadosJogos() {
        cearaCasa2022Api.getCearaCasa2022().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> list = response.body();
                    Log.i("Sucesso", "sucesso na busca dos dados");
                }else{
                    erroBuscarDados();
                }
            }

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {
                    erroBuscarDados();
            }
        });

    }

    private void erroBuscarDados() {

        Toast.makeText(getContext(), "Erro ao buscar dados da Api dos jogos", Toast.LENGTH_LONG).show();

    }
}