package com.jogos.dadosoficialkf2289.fragments.brasileiroA2022.americaMG;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jogos.dadosoficialkf2289.activity.brasilA2022.AtleticoGoActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.AtleticoMgActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.AtleticoPrActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.AvaiActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.BotafogoActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.BragantinoActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.CearaActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.CorinthiansActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.CoritibaActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.CuiabaActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.FlamengoActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.FluminenseActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.FortalezaActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.GoiasActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.InternacionalActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.JuventudeActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.PalmeirasActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.SantosActivity;
import com.jogos.dadosoficialkf2289.activity.brasilA2022.SaoPauloActivity;
import com.jogos.dadosoficialkf2289.adapter.brasileiroA2022.americaMG.AmericaMgCasaA2022Adapter;
import com.jogos.dadosoficialkf2289.data.brasileiroSerieA2022.americaMG.AmericaMgCasaA2022PartidaApi;
import com.jogos.dadosoficialkf2289.databinding.FragmentAmericaMgCasa2022Binding;
import com.jogos.dadosoficialkf2289.model.Partida;
import com.jogos.dadosoficialkf2289.model.RecyclerItemClickListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AmericaMgCasa2022Fragment extends Fragment {

    private FragmentAmericaMgCasa2022Binding binding;
    private AmericaMgCasaA2022PartidaApi americaMGCasaA2022PartidaApi;
    private AmericaMgCasaA2022Adapter americaMgCasaA2022Adapter;




    public AmericaMgCasa2022Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAmericaMgCasa2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();
        
        


        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/america-mg/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        americaMGCasaA2022PartidaApi = retrofit.create(AmericaMgCasaA2022PartidaApi.class);

    }

    private void setupDadosJogos() {

        binding.rvAmericaMgCasa.setHasFixedSize(true);
        binding.rvAmericaMgCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvAmericaMgCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        americaMGCasaA2022PartidaApi.getAmericaMgCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    americaMgCasaA2022Adapter = new AmericaMgCasaA2022Adapter(partidas);
                    binding.rvAmericaMgCasa.setAdapter(americaMgCasaA2022Adapter);

                    binding.rvAmericaMgCasa.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvAmericaMgCasa, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Partida lista = partidas.get(position);

                            switch (lista.getAwayTime().getNome()){
                                case "Atl??tico-PR":
                                    Intent atleticoPr = new Intent(getContext(), AtleticoPrActivity.class);
                                    startActivity(atleticoPr);
                                    break;
                                case "Atl??tico-MG":
                                    Intent atleticoMg = new Intent(getContext(), AtleticoMgActivity.class);
                                    startActivity(atleticoMg);
                                    break;
                                case "Atl??tico-GO":
                                    Intent atleticoGo = new Intent(getContext(), AtleticoGoActivity.class);
                                    startActivity(atleticoGo);
                                    break;
                                case "Ava??":
                                    Intent avai = new Intent(getContext(), AvaiActivity.class);
                                    startActivity(avai);
                                    break;
                                case "Botafogo":
                                    Intent botafogo = new Intent(getContext(), BotafogoActivity.class);
                                    startActivity(botafogo);
                                    break;
                                case "Bragantino":
                                    Intent bragantino = new Intent(getContext(), BragantinoActivity.class);
                                    startActivity(bragantino);
                                    break;
                                case "Cear??":
                                    Intent ceara = new Intent(getContext(), CearaActivity.class);
                                    startActivity(ceara);
                                    Toast.makeText(getContext(), "Cear??", Toast.LENGTH_LONG).show();
                                    break;
                                case "Corinthians":
                                    Intent corinthians = new Intent(getContext(), CorinthiansActivity.class);
                                    startActivity(corinthians);
                                    break;
                                case "Coritiba":
                                    Intent coritiba = new Intent(getContext(), CoritibaActivity.class);
                                    startActivity(coritiba);
                                    break;
                                case "Cuiab??":
                                    Intent cuiaba = new Intent(getContext(), CuiabaActivity.class);
                                    startActivity(cuiaba);
                                    break;
                                case "Flamengo":
                                    Intent flamengo = new Intent(getContext(), FlamengoActivity.class);
                                    startActivity(flamengo);
                                    break;
                                case "Fluminense":
                                    Intent fluminense = new Intent(getContext(), FluminenseActivity.class);
                                    startActivity(fluminense);
                                    break;
                                case "Fortaleza":
                                    Intent fortaleza = new Intent(getContext(), FortalezaActivity.class);
                                    startActivity(fortaleza);
                                    break;
                                case "Goi??s":
                                    Intent goias = new Intent(getContext(), GoiasActivity.class);
                                    startActivity(goias);
                                    break;
                                case "Juventude":
                                    Intent juventude = new Intent(getContext(), JuventudeActivity.class);
                                    startActivity(juventude);
                                    break;
                                case "Internacional":
                                    Intent internacional = new Intent(getContext(), InternacionalActivity.class);
                                    startActivity(internacional);
                                    break;
                                case "Palmeiras":
                                    Intent palmeiras = new Intent(getContext(), PalmeirasActivity.class);
                                    startActivity(palmeiras);
                                    break;
                                case "Santos":
                                    Intent santos = new Intent(getContext(), SantosActivity.class);
                                    startActivity(santos);
                                    break;
                                case "S??o-Paulo":
                                    Intent saopaulo = new Intent(getContext(), SaoPauloActivity.class);
                                    startActivity(saopaulo);
                                    break;

                            }
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    }));

                }else {
                    errorBuscarDados();
                }


            }

            @Override
            public void onFailure(Call<List<Partida>> call, Throwable t) {
                errorBuscarDados() ;
            }
        });

    }

    private void errorBuscarDados() {
        Snackbar.make(binding.getRoot(), "erro ao buscar dados da API, Verifique a conex??o de Internet, ", Snackbar.LENGTH_LONG).show();
    }
}