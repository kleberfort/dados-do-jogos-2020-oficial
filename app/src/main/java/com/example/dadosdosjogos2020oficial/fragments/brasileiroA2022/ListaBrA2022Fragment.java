package com.example.dadosdosjogos2020oficial.fragments.brasileiroA2022;

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

import com.example.dadosdosjogos2020oficial.activity.AmericaMgActivity;
import com.example.dadosdosjogos2020oficial.activity.AtleticoGoActivity;
import com.example.dadosdosjogos2020oficial.activity.AtleticoMgActivity;
import com.example.dadosdosjogos2020oficial.activity.AtleticoPrActivity;
import com.example.dadosdosjogos2020oficial.activity.AvaiActivity;
import com.example.dadosdosjogos2020oficial.activity.BotafogoActivity;
import com.example.dadosdosjogos2020oficial.activity.BragantinoActivity;
import com.example.dadosdosjogos2020oficial.activity.CearaActivity;
import com.example.dadosdosjogos2020oficial.activity.CorinthiansActivity;
import com.example.dadosdosjogos2020oficial.activity.CoritibaActivity;
import com.example.dadosdosjogos2020oficial.activity.CuiabaActivity;
import com.example.dadosdosjogos2020oficial.activity.FlamengoActivity;
import com.example.dadosdosjogos2020oficial.activity.FluminenseActivity;
import com.example.dadosdosjogos2020oficial.activity.FortalezaActivity;
import com.example.dadosdosjogos2020oficial.activity.GoiasActivity;
import com.example.dadosdosjogos2020oficial.activity.InternacionalActivity;
import com.example.dadosdosjogos2020oficial.activity.JuventudeActivity;
import com.example.dadosdosjogos2020oficial.activity.PalmeirasActivity;
import com.example.dadosdosjogos2020oficial.activity.SantosActivity;
import com.example.dadosdosjogos2020oficial.activity.SaoPauloActivity;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.TimesBrA2022Adapter;
import com.example.dadosdosjogos2020oficial.data.brasileiroSerieA2022.TimesBrA2022Api;
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    private void setupHttpClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/brasileiro-a-2022/")
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


                            switch (position){
                                case 0:
                                    Intent americaMg = new Intent(getContext(), AmericaMgActivity.class);
                                    startActivity(americaMg);
                                    Toast.makeText(getContext(), "América-MG", Toast.LENGTH_LONG).show();
                                    break;
                                case 1:
                                    Intent atleticoPr = new Intent(getContext(), AtleticoPrActivity.class);
                                    startActivity(atleticoPr);
                                    break;
                                case 2:
                                    Intent atleticoMg = new Intent(getContext(), AtleticoMgActivity.class);
                                    startActivity(atleticoMg);
                                    break;
                                case 3:
                                    Intent atleticoGo = new Intent(getContext(), AtleticoGoActivity.class);
                                    startActivity(atleticoGo);
                                    break;
                                case 4:
                                    Intent avai = new Intent(getContext(), AvaiActivity.class);
                                    startActivity(avai);
                                    break;
                                case 5:
                                    Intent botafogo = new Intent(getContext(), BotafogoActivity.class);
                                    startActivity(botafogo);
                                    break;
                                case 6:
                                    Intent bragantino = new Intent(getContext(), BragantinoActivity.class);
                                    startActivity(bragantino);
                                    break;
                                case 7:
                                    Intent ceara = new Intent(getContext(), CearaActivity.class);
                                    startActivity(ceara);
                                    Toast.makeText(getContext(), "Ceará", Toast.LENGTH_LONG).show();
                                    break;
                                case 8:
                                    Intent corinthians = new Intent(getContext(), CorinthiansActivity.class);
                                    startActivity(corinthians);
                                    break;
                                case 9:
                                    Intent coritiba = new Intent(getContext(), CoritibaActivity.class);
                                    startActivity(coritiba);
                                    break;
                                case 10:
                                    Intent cuiaba = new Intent(getContext(), CuiabaActivity.class);
                                    startActivity(cuiaba);
                                    break;
                                case 11:
                                    Intent flamengo = new Intent(getContext(), FlamengoActivity.class);
                                    startActivity(flamengo);
                                    break;
                                case 12:
                                    Intent fluminense = new Intent(getContext(), FluminenseActivity.class);
                                    startActivity(fluminense);
                                    break;
                                case 13:
                                    Intent fortaleza = new Intent(getContext(), FortalezaActivity.class);
                                    startActivity(fortaleza);
                                    break;
                                case 14:
                                    Intent goias = new Intent(getContext(), GoiasActivity.class);
                                    startActivity(goias);
                                    break;
                                case 15:
                                    Intent juventude = new Intent(getContext(), JuventudeActivity.class);
                                    startActivity(juventude);
                                    break;
                                case 16:
                                    Intent internacional = new Intent(getContext(), InternacionalActivity.class);
                                    startActivity(internacional);
                                    break;
                                case 17:
                                    Intent palmeiras = new Intent(getContext(), PalmeirasActivity.class);
                                    startActivity(palmeiras);
                                    break;
                                case 18:
                                    Intent santos = new Intent(getContext(), SantosActivity.class);
                                    startActivity(santos);
                                    break;
                                case 19:
                                    Intent saopaulo = new Intent(getContext(), SaoPauloActivity.class);
                                    startActivity(saopaulo);
                                    break;

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