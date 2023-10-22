package com.jogos.dadosoficialkf228920.fragments.brasileiroA2023.fortaleza;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.AmericaMgActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.AtheticoPrActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.AtleticoMgActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.BahiaActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.BotafogoActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.BragantinoActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.CorinthiansActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.CoritibaActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.CruzeiroActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.CuiabaActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.FlamengoActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.FluminenseActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.FortalezaActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.GoiasActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.GremioActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.InternacionalActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.PalmeirasActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.SantosActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.SaoPauloActivity;
import com.jogos.dadosoficialkf228920.activity.brasilA2023.VascoActivity;
import com.jogos.dadosoficialkf228920.adapter.brasileiroA2023.fortaleza.FortalezaCasaA2023Adapter;
import com.jogos.dadosoficialkf228920.data.brasileiroA2023.fortaleza.FortalezaCasaA2023PartidaApi;
import com.jogos.dadosoficialkf228920.databinding.FragmentFortalezaCasaA2023Binding;
import com.jogos.dadosoficialkf228920.model.Partida;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FortalezaCasa2023Fragment extends Fragment {

    private FragmentFortalezaCasaA2023Binding binding;
    private FortalezaCasaA2023Adapter fortalezaCasaA2023Adapter;
    private FortalezaCasaA2023PartidaApi fortalezaCasaA2023PartidaApi;


    public FortalezaCasa2023Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFortalezaCasaA2023Binding.inflate(inflater, container, false);


        binding.btnCopiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = binding.tvChavePix.getText().toString();

                android.content.ClipboardManager cm = (android.content.ClipboardManager) getActivity()
                        .getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("texto copiado", texto);
                cm.setPrimaryClip(clipData);
                Toast.makeText(getActivity(), "Chave copiada!", Toast.LENGTH_LONG).show();


            }
        });

        setupHttpClient();
        setupDadosJogos();

        return binding.getRoot();
    }

    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2023/fortaleza/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        fortalezaCasaA2023PartidaApi = retrofit.create(FortalezaCasaA2023PartidaApi.class);


    }

    private void setupDadosJogos() {

        binding.rvFortalezaCasa.setHasFixedSize(true);
        binding.rvFortalezaCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvFortalezaCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        fortalezaCasaA2023PartidaApi.getFortalezaCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if (response.isSuccessful()) {
                    List<Partida> partidas = response.body();
                    fortalezaCasaA2023Adapter = new FortalezaCasaA2023Adapter(partidas);
                    binding.rvFortalezaCasa.setAdapter(fortalezaCasaA2023Adapter);

                    binding.rvFortalezaCasa.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvFortalezaCasa, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Partida lista = partidas.get(position);

                            switch (lista.getAwayTime().getNome()) {

                                case "América-MG":
                                    Intent americaMg = new Intent(getContext(), AmericaMgActivity.class);
                                    startActivity(americaMg);
                                    Toast.makeText(getContext(), "América-MG", Toast.LENGTH_LONG).show();
                                    break;
                                case "Atlético-PR":
                                    Intent atleticoPr = new Intent(getContext(), AtheticoPrActivity.class);
                                    startActivity(atleticoPr);
                                    break;
                                case "Atlético-MG":
                                    Intent atleticoMg = new Intent(getContext(), AtleticoMgActivity.class);
                                    startActivity(atleticoMg);
                                    break;
                                case "Bahia":
                                    Intent bahia = new Intent(getContext(), BahiaActivity.class);
                                    startActivity(bahia);
                                    break;
                                case "Cruzeiro":
                                    Intent cruzeiro = new Intent(getContext(), CruzeiroActivity.class);
                                    startActivity(cruzeiro);
                                    break;
                                case "Botafogo":
                                    Intent botafogo = new Intent(getContext(), BotafogoActivity.class);
                                    startActivity(botafogo);
                                    break;
                                case "Bragantino":
                                    Intent bragantino = new Intent(getContext(), BragantinoActivity.class);
                                    startActivity(bragantino);
                                    break;
                                case "Grêmio":
                                    Intent gremio = new Intent(getContext(), GremioActivity.class);
                                    startActivity(gremio);
                                    Toast.makeText(getContext(), "Ceará", Toast.LENGTH_LONG).show();
                                    break;
                                case "Corinthians":
                                    Intent corinthians = new Intent(getContext(), CorinthiansActivity.class);
                                    startActivity(corinthians);
                                    break;
                                case "Coritiba":
                                    Intent coritiba = new Intent(getContext(), CoritibaActivity.class);
                                    startActivity(coritiba);
                                    break;
                                case "Cuiabá":
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
                                case "Goiás":
                                    Intent goias = new Intent(getContext(), GoiasActivity.class);
                                    startActivity(goias);
                                    break;
                                case "Vasco":
                                    Intent vasco = new Intent(getContext(), VascoActivity.class);
                                    startActivity(vasco);
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
                                case "São-Paulo":
                                    Intent saopaulo = new Intent(getContext(), SaoPauloActivity.class);
                                    startActivity(saopaulo);
                                    break;

                            }//fim do switch

                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    }));

                } else {
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