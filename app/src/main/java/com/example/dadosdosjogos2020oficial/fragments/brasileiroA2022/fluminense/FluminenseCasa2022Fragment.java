package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022.fluminense;

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

import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.AmericaMgActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.AtleticoGoActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.AtleticoMgActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.AtleticoPrActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.AvaiActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.BotafogoActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.BragantinoActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.CearaActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.CorinthiansActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.CoritibaActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.CuiabaActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.FlamengoActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.FluminenseActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.FortalezaActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.GoiasActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.InternacionalActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.JuventudeActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.PalmeirasActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.SantosActivity;
import com.example.dadosdosjogos2020oficial.activity.brasilA2022.SaoPauloActivity;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.flamengo.FlamengoForaA2022Adapter;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.fluminense.FluminenseCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.flamengo.FlamengoCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.fluminense.FluminenseCasaA2022PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.FragmentAtleticoPRFora2022Binding;
import com.example.dadosdosjogos2020oficial.databinding.FragmentFluminenseCasa2022Binding;
import com.example.dadosdosjogos2020oficial.model.Partida;
import com.example.dadosdosjogos2020oficial.model.RecyclerItemClickListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FluminenseCasa2022Fragment extends Fragment {

   private FragmentFluminenseCasa2022Binding binding;
   private FluminenseCasaA2022Adapter fluminenseCasaA2022Adapter;
   private FluminenseCasaA2022PartidaApi fluminenseCasaA2022PartidaApi;

    public FluminenseCasa2022Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFluminenseCasa2022Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupDadosJogos();


        return view;




    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/fluminense/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        fluminenseCasaA2022PartidaApi = retrofit.create(FluminenseCasaA2022PartidaApi.class);
    }

    private void setupDadosJogos() {
        binding.rvFluminenseCasa.setHasFixedSize(true);
        binding.rvFluminenseCasa.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvFluminenseCasa.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        fluminenseCasaA2022PartidaApi.getFluminenseCasa().enqueue(new Callback<List<Partida>>() {
            @Override
            public void onResponse(Call<List<Partida>> call, Response<List<Partida>> response) {
                if(response.isSuccessful()){
                    List<Partida> partidas = response.body();
                    fluminenseCasaA2022Adapter = new FluminenseCasaA2022Adapter(partidas);
                    binding.rvFluminenseCasa.setAdapter(fluminenseCasaA2022Adapter);

                    binding.rvFluminenseCasa.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvFluminenseCasa, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Partida lista = partidas.get(position);

                            switch (lista.getAwayTime().getNome()){
                                case "América-MG":
                                    Intent americaMg = new Intent(getContext(), AmericaMgActivity.class);
                                    startActivity(americaMg);
                                    Toast.makeText(getContext(), "América-MG", Toast.LENGTH_LONG).show();
                                    break;
                                case "Atlético-PR":
                                    Intent atleticoPr = new Intent(getContext(), AtleticoPrActivity.class);
                                    startActivity(atleticoPr);
                                    break;
                                case "Atlético-MG":
                                    Intent atleticoMg = new Intent(getContext(), AtleticoMgActivity.class);
                                    startActivity(atleticoMg);
                                    break;
                                case "Atlético-GO":
                                    Intent atleticoGo = new Intent(getContext(), AtleticoGoActivity.class);
                                    startActivity(atleticoGo);
                                    break;
                                case "Avaí":
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
                                case "Ceará":
                                    Intent ceara = new Intent(getContext(), CearaActivity.class);
                                    startActivity(ceara);
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
                                case "Fortaleza":
                                    Intent fortaleza = new Intent(getContext(), FortalezaActivity.class);
                                    startActivity(fortaleza);
                                    break;
                                case "Goiás":
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
                                case "São-Paulo":
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

                errorBuscarDados();

            }
        });

    }

    private void errorBuscarDados() {
        Snackbar.make(binding.getRoot(), "erro ao buscar dados da API, Verifique a conexão de Internet, ", Snackbar.LENGTH_LONG).show();
    }
}