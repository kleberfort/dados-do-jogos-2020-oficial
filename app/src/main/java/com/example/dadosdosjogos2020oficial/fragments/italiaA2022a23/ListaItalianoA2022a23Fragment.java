package com.example.dadosdosjogos2020oficial.fragments.italiaA2022a23;

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
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.AjaccioActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.AngersActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.AuxerreActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.BrestActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.ClermontActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.LensActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.LilleActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.LorientActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.LyonActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.MarseilleActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.MonacoActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.MontpellierActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.NantesActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.NiceActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.PsgActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.ReimsActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.RennesActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.StrasbourgActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.ToulouseActivity;
import com.example.dadosdosjogos2020oficial.activity.francaA2022a23.TroyesActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.AtalantaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.BolognaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.CremoneseActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.EmpoliActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.FiorentinaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.HellasVeronaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.InterMilanActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.JuventusActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.LazioActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.LecceActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.MilanActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.MonzaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.NapoliActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.RomaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.SalernitanaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.SampdoriaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.SassuoloActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.SpeziaActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.TorinoActivity;
import com.example.dadosdosjogos2020oficial.activity.italiaA2022a23.UdineseActivity;
import com.example.dadosdosjogos2020oficial.adapter.italiaA2022a23.TimesItalianoA2022a23Adapter;
import com.example.dadosdosjogos2020oficial.data.italiaA2022a23.TimesItalianoA2022a23Api;
import com.example.dadosdosjogos2020oficial.databinding.FragmentListaItalianoA2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.ListaTimeCampeonatoPrincipal;
import com.example.dadosdosjogos2020oficial.model.RecyclerItemClickListener;
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

                    binding.rvListaItalianoA2022a23.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaItalianoA2022a23, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            ListaTimeCampeonatoPrincipal lista = listaDeTimes.get(position);

                            switch (lista.getName()){
                                case "Atalanta":
                                    Intent atalanta = new Intent(getContext(), AtalantaActivity.class);
                                    startActivity(atalanta);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Bologna":
                                    Intent bologna = new Intent(getContext(), BolognaActivity.class);
                                    startActivity(bologna);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Cremonese":
                                    Intent cremonese = new Intent(getContext(), CremoneseActivity.class);
                                    startActivity(cremonese);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Empoli":
                                    Intent empoli = new Intent(getContext(), EmpoliActivity.class);
                                    startActivity(empoli);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Fiorentina":
                                    Intent fiorentina = new Intent(getContext(), FiorentinaActivity.class);
                                    startActivity(fiorentina);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Hellas Verona":
                                    Intent hellasVerona = new Intent(getContext(), HellasVeronaActivity.class);
                                    startActivity(hellasVerona);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Inter Milan":
                                    Intent interMilao = new Intent(getContext(), InterMilanActivity.class);
                                    startActivity(interMilao);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Juventus":
                                    Intent juventus = new Intent(getContext(), JuventusActivity.class);
                                    startActivity(juventus);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lazio":
                                    Intent lazio = new Intent(getContext(), LazioActivity.class);
                                    startActivity(lazio);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lecce":
                                    Intent lecce = new Intent(getContext(), LecceActivity.class);
                                    startActivity(lecce);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Milan":
                                    Intent milan = new Intent(getContext(), MilanActivity.class);
                                    startActivity(milan);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Monza":
                                    Intent monza = new Intent(getContext(), MonzaActivity.class);
                                    startActivity(monza);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Napoli":
                                    Intent napoli = new Intent(getContext(), NapoliActivity.class);
                                    startActivity(napoli);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Roma":
                                    Intent roma = new Intent(getContext(), RomaActivity.class);
                                    startActivity(roma);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Salernitana":
                                    Intent salernitanaa = new Intent(getContext(), SalernitanaActivity.class);
                                    startActivity(salernitanaa);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Sampdoria":
                                    Intent sampdoria = new Intent(getContext(), SampdoriaActivity.class);
                                    startActivity(sampdoria);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Sassuolo":
                                    Intent sassuolo = new Intent(getContext(), SassuoloActivity.class);
                                    startActivity(sassuolo);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Spezia":
                                    Intent spezia = new Intent(getContext(), SpeziaActivity.class);
                                    startActivity(spezia);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Torino":
                                    Intent torino = new Intent(getContext(), TorinoActivity.class);
                                    startActivity(torino);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Udinese":
                                    Intent udinese = new Intent(getContext(), UdineseActivity.class);
                                    startActivity(udinese);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                            }
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    }));

                }else{
                    errorBuscarDados();
                }
            }

            @Override
            public void onFailure(Call<List<ListaTimeCampeonatoPrincipal>> call, Throwable t) {
                errorBuscarDados();
            }
        });

    }

    private void errorBuscarDados() {
        Snackbar.make(binding.getRoot(), "erro ao buscar dados da API, Verifique a conexão de Internet, ", Snackbar.LENGTH_LONG).show();
    }
}