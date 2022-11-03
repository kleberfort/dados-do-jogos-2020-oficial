package com.example.dadosdosjogos2020oficial.fragments.francaA2022a23;

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
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.AlmeriaActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.AthleticBilbaoActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.AtleticoMadridActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.BarcelonaActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.CadizActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.CeltaVigoActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.ElcheActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.EspanyolActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.GetafeActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.GironaActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.MallorcaActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.OsasunaActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.RayoVallecanoActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.RealBetisActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.RealMadridActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.RealSociedadActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.RealValladolidActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.SevillaActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.ValenciaActivity;
import com.example.dadosdosjogos2020oficial.activity.espanhaA2022a23.VillarrealActivity;
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
import com.example.dadosdosjogos2020oficial.adapter.francaA2022a23.TimesFrancesA2022a23Adpater;
import com.example.dadosdosjogos2020oficial.data.francaA2022a23.TimesFrancesA2022a23Api;
import com.example.dadosdosjogos2020oficial.databinding.FragmentListaFrancesA2022a23Binding;
import com.example.dadosdosjogos2020oficial.model.ListaTimeCampeonatoPrincipal;
import com.example.dadosdosjogos2020oficial.model.RecyclerItemClickListener;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListaFrancesA2022a23Fragment extends Fragment {

    private FragmentListaFrancesA2022a23Binding binding;
    private TimesFrancesA2022a23Adpater timesFrancesA2022a23Adpater;
    private TimesFrancesA2022a23Api timesFrancesA2022a23Api;




    public ListaFrancesA2022a23Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentListaFrancesA2022a23Binding.inflate(inflater, container, false);
        View view = binding.getRoot();


        setupHttpClient();
        setupListaTimes();

        return view;
    }

    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/kleberfort/dados-jogos-partidas-oficial-2022-api/master/franca-a-2022-23/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        timesFrancesA2022a23Api = retrofit.create(TimesFrancesA2022a23Api.class);


    }

    private void setupListaTimes() {

        binding.rvListaFrancesA2022a23.setHasFixedSize(true);
        binding.rvListaFrancesA2022a23.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvListaFrancesA2022a23.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        timesFrancesA2022a23Api.getTimesFrancesA2022a2023().enqueue(new Callback<List<ListaTimeCampeonatoPrincipal>>() {
            @Override
            public void onResponse(Call<List<ListaTimeCampeonatoPrincipal>> call, Response<List<ListaTimeCampeonatoPrincipal>> response) {
                if(response.isSuccessful()){
                    List<ListaTimeCampeonatoPrincipal> listaDeTimes = response.body();
                    timesFrancesA2022a23Adpater = new TimesFrancesA2022a23Adpater(listaDeTimes);
                    binding.rvListaFrancesA2022a23.setAdapter(timesFrancesA2022a23Adpater);



                    binding.rvListaFrancesA2022a23.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvListaFrancesA2022a23, new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {

                            ListaTimeCampeonatoPrincipal lista = listaDeTimes.get(position);

                            switch (lista.getName()){
                                case "Ajaccio":
                                    Intent ajaccio = new Intent(getContext(), AjaccioActivity.class);
                                    startActivity(ajaccio);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Angers":
                                    Intent angers = new Intent(getContext(), AngersActivity.class);
                                    startActivity(angers);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Auxerre":
                                    Intent auxerre = new Intent(getContext(), AuxerreActivity.class);
                                    startActivity(auxerre);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Brest":
                                    Intent brest = new Intent(getContext(), BrestActivity.class);
                                    startActivity(brest);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Clermont":
                                    Intent clermont = new Intent(getContext(), ClermontActivity.class);
                                    startActivity(clermont);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lens":
                                    Intent lens = new Intent(getContext(), LensActivity.class);
                                    startActivity(lens);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lille":
                                    Intent lille = new Intent(getContext(), LilleActivity.class);
                                    startActivity(lille);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lorient":
                                    Intent lorient = new Intent(getContext(), LorientActivity.class);
                                    startActivity(lorient);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Lyon":
                                    Intent lyon = new Intent(getContext(), LyonActivity.class);
                                    startActivity(lyon);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Marseille":
                                    Intent marseille = new Intent(getContext(), MarseilleActivity.class);
                                    startActivity(marseille);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Monaco":
                                    Intent monaco = new Intent(getContext(), MonacoActivity.class);
                                    startActivity(monaco);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Montpellier":
                                    Intent montpellier = new Intent(getContext(), MontpellierActivity.class);
                                    startActivity(montpellier);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Nantes":
                                    Intent nantes = new Intent(getContext(), NantesActivity.class);
                                    startActivity(nantes);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Nice":
                                    Intent nice = new Intent(getContext(), NiceActivity.class);
                                    startActivity(nice);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "PSG":
                                    Intent psg = new Intent(getContext(), PsgActivity.class);
                                    startActivity(psg);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Reims":
                                    Intent reims = new Intent(getContext(), ReimsActivity.class);
                                    startActivity(reims);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Rennes":
                                    Intent rennes = new Intent(getContext(), RennesActivity.class);
                                    startActivity(rennes);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Strasbourg":
                                    Intent strasbourg = new Intent(getContext(), StrasbourgActivity.class);
                                    startActivity(strasbourg);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Toulouse":
                                    Intent toulouse = new Intent(getContext(), ToulouseActivity.class);
                                    startActivity(toulouse);
                                    Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                                    break;
                                case "Troyes":
                                    Intent troyes = new Intent(getContext(), TroyesActivity.class);
                                    startActivity(troyes);
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