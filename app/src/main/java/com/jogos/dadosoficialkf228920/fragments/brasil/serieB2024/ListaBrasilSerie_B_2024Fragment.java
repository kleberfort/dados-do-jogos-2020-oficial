package com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.Amazonas2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.AmericaMG2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.Avai2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.BotafogoSP2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.Brusque2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.Ceara2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.Chapecoense2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.Coritiba2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.Crb2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.Goias2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.Guarani2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.Ituano2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.Mirassol2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.Novorizontino2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.Operario2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.Paysandu2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.PontePreta2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.Santos2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.Sport2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieB2024.VilaNova2024Activity;
import com.jogos.dadosoficialkf228920.adapter.brasil2024.TimesClasificacaoBrasilA2024Adapter;
import com.jogos.dadosoficialkf228920.databinding.FragmentListaBrasilSerieB2024Binding;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.ListaBrasilSerieA_2024_TesteFragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.util.JogosSerieB2024;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.util.JogosSerieB2024Listener;
import com.jogos.dadosoficialkf228920.model.ClassificacaoOficialNovoModelo;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;
import com.jogos.dadosoficialkf228920.model.RecyclerItemClickListener;
import com.jogos.dadosoficialkf228920.model.comparator.ComparatorPontosVitoriaSaldoGolsProSerieA_B;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ListaBrasilSerie_B_2024Fragment extends Fragment implements JogosSerieB2024Listener {

    private FragmentListaBrasilSerieB2024Binding binding;
    private JogosSerieB2024 jogosSerieB2024;
    private TimesClasificacaoBrasilA2024Adapter timesClasificacaoBrasilA2024Adapter;



    String nome = null;
    String imagem = null;


    Integer totalGolsPro = 0;
    Integer totalGolsContra = 0;
    Integer totalsaldoGols = 0;

    Integer totalJogos = 0;

    Integer totalVitoria = 0;
    Integer totalEmpate = 0;
    Integer totalDerrota = 0;
    Integer totalPontos = 0;

    private List<PartidaNovoModelo> amazonasCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> americaMGCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> avaiCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> botafogoSPCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> brusqueCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> crbCompleto= new ArrayList<>();
    private List<PartidaNovoModelo> cearaCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> chapecoenseCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> coritibaCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> goiasCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> guaraniCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> ituanoCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> mirassolCompleto= new ArrayList<>();
    private List<PartidaNovoModelo> novorizontinoCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> operarioCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> paysanduCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> pontepretaCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> santosCompleto= new ArrayList<>();
    private List<PartidaNovoModelo> sportCompleto = new ArrayList<>();
    private List<PartidaNovoModelo> vilanovaCompleto = new ArrayList<>();


    List<ClassificacaoOficialNovoModelo> listaOficial = new ArrayList<>(); ;//estamos iniciando nossa lista vazia

    public interface ListaBrasilB2024Interface{//esse é o codigo de criar a interface // entede essa primeira parte ? ele basicamente
        void listaBrasilBMetodo(String nome);//viu que é uma string ?sim
    }


    //2 etapa criamos uma variavel da interface
    ListaBrasilB2024Interface listaBrasilB2024 = null;//queremos usar o metodo listaInglesa(String nome) mas estamos iniciando ela com o valor null
    //ou seuja null é igual a nulo ou nada
    //entende isso ?sim



    //3 etapa iniciamos a variavel
    @Override
    public void onAttach(@NonNull Context context) {//
        super.onAttach(context);

        if(context instanceof ListaBrasilB2024Interface){
            listaBrasilB2024 = (ListaBrasilB2024Interface) context;//aqui iniciamos a nossa variavel... Esse código voce nao precisa entender, só tem que
            //compreendeu as 3 etapadas ?sim ok
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListaBrasilSerieB2024Binding.inflate(inflater, container, false);
        View view = binding.getRoot();
        jogosSerieB2024 = new JogosSerieB2024();
        jogosSerieB2024.setupHttpClient();
        jogosSerieB2024.setupDadosJogos();
        jogosSerieB2024.setListener(this);// Registra o fragmento como listener

        binding.rvLista.setHasFixedSize(true);
        binding.rvLista.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvLista.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        //aqui esta certo, estamos iniciando o adaptador. Sempre temos que fazer isso
        timesClasificacaoBrasilA2024Adapter = new TimesClasificacaoBrasilA2024Adapter(listaOficial);//o adapter vai receber a variazel listaOficial, mas ela esta vazia ainda
        //entendeu essa parte ?sim
        //
        binding.rvLista.setAdapter(timesClasificacaoBrasilA2024Adapter);


        binding.rvLista.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), binding.rvLista, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ClassificacaoOficialNovoModelo lista = listaOficial.get(position);

                switch (lista.getName()) {
                    case "Amazonas":
                        listaBrasilB2024.listaBrasilBMetodo("Amazonas");
                        Intent intent = new Intent(getContext(), Amazonas2024Activity.class);
                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "América-MG":
                        listaBrasilB2024.listaBrasilBMetodo("América-MG");
//                         intent = new Intent(getContext(), AmericaMG2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Avaí":
                        listaBrasilB2024.listaBrasilBMetodo("Avaí");
//                        intent = new Intent(getContext(), Avai2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Botafogo-SP":
                        listaBrasilB2024.listaBrasilBMetodo("Botafogo-SP");
//                        intent = new Intent(getContext(), BotafogoSP2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Brusque":
                        listaBrasilB2024.listaBrasilBMetodo("Brusque");
//                        intent = new Intent(getContext(), Brusque2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "CRB":
                        listaBrasilB2024.listaBrasilBMetodo("CRB");
//                        intent = new Intent(getContext(), Crb2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Ceará":
                        listaBrasilB2024.listaBrasilBMetodo("Ceará");
//                         intent = new Intent(getContext(), Ceara2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Chapecoense":
                        listaBrasilB2024.listaBrasilBMetodo("Chapecoense");
//                        intent = new Intent(getContext(), Chapecoense2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Coritiba":
                        listaBrasilB2024.listaBrasilBMetodo("Coritiba");
//                        intent = new Intent(getContext(), Coritiba2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Goiás":
                        listaBrasilB2024.listaBrasilBMetodo("Goiás");
//                        intent = new Intent(getContext(), Goias2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Guarani":
                        listaBrasilB2024.listaBrasilBMetodo("Guarani");
//                        intent = new Intent(getContext(), Guarani2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Ituano":
                        listaBrasilB2024.listaBrasilBMetodo("Ituano");
//                        intent = new Intent(getContext(), Ituano2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Mirassol":
                        listaBrasilB2024.listaBrasilBMetodo("Mirassol");
//                        intent = new Intent(getContext(), Mirassol2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Novorizontino":
                        listaBrasilB2024.listaBrasilBMetodo("Novorizontino");
//                        intent = new Intent(getContext(), Novorizontino2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Operário":
                        listaBrasilB2024.listaBrasilBMetodo("Operário");
//                        intent = new Intent(getContext(), Operario2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Paysandu":
                        listaBrasilB2024.listaBrasilBMetodo("Paysandu");
//                        intent = new Intent(getContext(), Paysandu2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Ponte Preta":
                        listaBrasilB2024.listaBrasilBMetodo("Ponte Preta");
//                        intent = new Intent(getContext(), PontePreta2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Santos":
                        listaBrasilB2024.listaBrasilBMetodo("Santos");
//                        intent = new Intent(getContext(), Santos2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Sport":
                        listaBrasilB2024.listaBrasilBMetodo("Sport");
//                        intent = new Intent(getContext(), Sport2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;
                    case "Vila Nova":
                        listaBrasilB2024.listaBrasilBMetodo("Vila Nova");
//                        intent = new Intent(getContext(), VilaNova2024Activity.class);
//                        startActivity(intent);
                        Toast.makeText(getContext(), " " + lista.getName(), Toast.LENGTH_LONG).show();
                        break;








                }//fim do switch




            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));


        return view;

    }


    @Override
    public void onJogosSerieBReady(List<PartidaNovoModelo> amazonasCompleto, List<PartidaNovoModelo> americaMGCompleto, List<PartidaNovoModelo> avaiCompleto,
                                   List<PartidaNovoModelo> botafogoSPCompleto, List<PartidaNovoModelo> brusqueCompleto, List<PartidaNovoModelo> crbCompleto,
                                   List<PartidaNovoModelo> cearaCompleto, List<PartidaNovoModelo> chapecoenseCompleto, List<PartidaNovoModelo> coritibaCompleto,
                                   List<PartidaNovoModelo> goiasCompleto, List<PartidaNovoModelo> guaraniCompleto, List<PartidaNovoModelo> ituanoCompleto,
                                   List<PartidaNovoModelo> mirassolCompleto, List<PartidaNovoModelo> novorizontinoCompleto, List<PartidaNovoModelo> operarioCompleto,
                                   List<PartidaNovoModelo> paysanduCompleto, List<PartidaNovoModelo> pontepretaCompleto, List<PartidaNovoModelo> santosCompleto,
                                   List<PartidaNovoModelo> sportCompleto, List<PartidaNovoModelo> vilanovaCompleto) {



        this.amazonasCompleto = amazonasCompleto;
        this.americaMGCompleto = americaMGCompleto;
        this.avaiCompleto = avaiCompleto;
        this.botafogoSPCompleto = botafogoSPCompleto;
        this.brusqueCompleto = brusqueCompleto;
        this.crbCompleto = crbCompleto;
        this.cearaCompleto = cearaCompleto;
        this.chapecoenseCompleto = chapecoenseCompleto;
        this.coritibaCompleto = coritibaCompleto;
        this.goiasCompleto = goiasCompleto;
        this.guaraniCompleto = guaraniCompleto;
        this.ituanoCompleto = ituanoCompleto;
        this.mirassolCompleto = mirassolCompleto;
        this.novorizontinoCompleto = novorizontinoCompleto;
        this.operarioCompleto = operarioCompleto;
        this.paysanduCompleto = paysanduCompleto;
        this.pontepretaCompleto = pontepretaCompleto;
        this.santosCompleto = santosCompleto;
        this.sportCompleto = sportCompleto;
        this.vilanovaCompleto = vilanovaCompleto;


        ClassificacaoOficialNovoModelo classificacaoOficialNovoModelo = new ClassificacaoOficialNovoModelo();


        String name = null;
        String image = null;
        Integer pontos = 0;
        Integer golsPro = 0;
        Integer golsContra = 0;
        Integer saldoGols = 0;
        Integer jogos = 0;
        Integer vitoria = 0;
        Integer empate = 0;
        Integer derrota = 0;


        for (int i = 0; i < amazonasCompleto.size(); i++) {
            if (amazonasCompleto.get(i).getHomeTime().getName().equals("Amazonas")) {
                // ClassificaTeste classificaTeste = new ClassificaTeste();
                name = amazonasCompleto.get(i).getHomeTime().getName();
                image = amazonasCompleto.get(i).getHomeTime().getImage();
                if (amazonasCompleto.get(i).getHomeTime().getScore() > amazonasCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (amazonasCompleto.get(i).getHomeTime().getScore() == amazonasCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (amazonasCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += amazonasCompleto.get(i).getHomeTime().getScore();
                if (amazonasCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += amazonasCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (amazonasCompleto.get(i).getAwayTime().getName().equals("Amazonas")) {
                //ClassificaTeste classificaTeste = new ClassificaTeste();
                name = amazonasCompleto.get(i).getAwayTime().getName();
                image = amazonasCompleto.get(i).getAwayTime().getImage();
                if (amazonasCompleto.get(i).getAwayTime().getScore() > amazonasCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (amazonasCompleto.get(i).getAwayTime().getScore() == amazonasCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (amazonasCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += amazonasCompleto.get(i).getAwayTime().getScore();
                if (amazonasCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += amazonasCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;

            }//fim do segundo if arsenal

        }//fim do for arsenal

        ClassificacaoOficialNovoModelo classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);

        listaOficial.add(classifica);//adicionamos as informacoes na nossa variavel que foi passada para o adapter na linha 110.
        //essa variavel listaOficial esta associada ao nosso adapter, pois fizemos isso na linha 110
        //entendeu essa parte ?sim


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < americaMGCompleto.size(); i++) {
            if (americaMGCompleto.get(i).getHomeTime().getName().equals("América-MG")) {
                name = americaMGCompleto.get(i).getHomeTime().getName();
                image = americaMGCompleto.get(i).getHomeTime().getImage();
                if (americaMGCompleto.get(i).getHomeTime().getScore() > americaMGCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (americaMGCompleto.get(i).getHomeTime().getScore() == americaMGCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (americaMGCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += americaMGCompleto.get(i).getHomeTime().getScore();
                if (americaMGCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra +=  americaMGCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (americaMGCompleto.get(i).getAwayTime().getName().equals("América-MG")) {
                name = americaMGCompleto.get(i).getAwayTime().getName();
                image = americaMGCompleto.get(i).getAwayTime().getImage();
                if (americaMGCompleto.get(i).getAwayTime().getScore() > americaMGCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (americaMGCompleto.get(i).getAwayTime().getScore() == americaMGCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (americaMGCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += americaMGCompleto.get(i).getAwayTime().getScore();
                if (americaMGCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += americaMGCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for astonVilla

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < avaiCompleto.size(); i++) {
            if (avaiCompleto.get(i).getHomeTime().getName().equals("Avaí")) {
                name = avaiCompleto.get(i).getHomeTime().getName();
                image = avaiCompleto.get(i).getHomeTime().getImage();
                if (avaiCompleto.get(i).getHomeTime().getScore() > avaiCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (avaiCompleto.get(i).getHomeTime().getScore() == avaiCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (avaiCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += avaiCompleto.get(i).getHomeTime().getScore();
                if (avaiCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += avaiCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (avaiCompleto.get(i).getAwayTime().getName().equals("Avaí")) {
                name = avaiCompleto.get(i).getAwayTime().getName();
                image = avaiCompleto.get(i).getAwayTime().getImage();
                if (avaiCompleto.get(i).getAwayTime().getScore() > avaiCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (avaiCompleto.get(i).getAwayTime().getScore() == avaiCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (avaiCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += avaiCompleto.get(i).getAwayTime().getScore();
                if (avaiCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += avaiCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for bournemouth

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < botafogoSPCompleto.size(); i++) {
            if (botafogoSPCompleto.get(i).getHomeTime().getName().equals("Botafogo-SP")) {
                name = botafogoSPCompleto.get(i).getHomeTime().getName();
                image = botafogoSPCompleto.get(i).getHomeTime().getImage();
                if (botafogoSPCompleto.get(i).getHomeTime().getScore() > botafogoSPCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (botafogoSPCompleto.get(i).getHomeTime().getScore() == botafogoSPCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (botafogoSPCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += botafogoSPCompleto.get(i).getHomeTime().getScore();
                if (botafogoSPCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += botafogoSPCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (botafogoSPCompleto.get(i).getAwayTime().getName().equals("Botafogo-SP")) {
                name = botafogoSPCompleto.get(i).getAwayTime().getName();
                image = botafogoSPCompleto.get(i).getAwayTime().getImage();
                if (botafogoSPCompleto.get(i).getAwayTime().getScore() > botafogoSPCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (botafogoSPCompleto.get(i).getAwayTime().getScore() == botafogoSPCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (botafogoSPCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += botafogoSPCompleto.get(i).getAwayTime().getScore();
                if (botafogoSPCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += botafogoSPCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for brentford

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < brusqueCompleto.size(); i++) {
            if (brusqueCompleto.get(i).getHomeTime().getName().equals("Brusque")) {
                name = brusqueCompleto.get(i).getHomeTime().getName();
                image = brusqueCompleto.get(i).getHomeTime().getImage();
                if (brusqueCompleto.get(i).getHomeTime().getScore() > brusqueCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (brusqueCompleto.get(i).getHomeTime().getScore() == brusqueCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (brusqueCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += brusqueCompleto.get(i).getHomeTime().getScore();
                if (brusqueCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += brusqueCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (brusqueCompleto.get(i).getAwayTime().getName().equals("Brusque")) {
                name = brusqueCompleto.get(i).getAwayTime().getName();
                image = brusqueCompleto.get(i).getAwayTime().getImage();
                if (brusqueCompleto.get(i).getAwayTime().getScore() > brusqueCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (brusqueCompleto.get(i).getAwayTime().getScore() == brusqueCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (brusqueCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += brusqueCompleto.get(i).getAwayTime().getScore();
                if (brusqueCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += brusqueCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for brighton

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < crbCompleto.size(); i++) {
            if (crbCompleto.get(i).getHomeTime().getName().equals("CRB")) {
                name = crbCompleto.get(i).getHomeTime().getName();
                image = crbCompleto.get(i).getHomeTime().getImage();
                if (crbCompleto.get(i).getHomeTime().getScore() > crbCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (crbCompleto.get(i).getHomeTime().getScore() == crbCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (crbCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += crbCompleto.get(i).getHomeTime().getScore();
                if (crbCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += crbCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (crbCompleto.get(i).getAwayTime().getName().equals("CRB")) {
                name = crbCompleto.get(i).getAwayTime().getName();
                image = crbCompleto.get(i).getAwayTime().getImage();
                if (crbCompleto.get(i).getAwayTime().getScore() > crbCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (crbCompleto.get(i).getAwayTime().getScore() == crbCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (crbCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += crbCompleto.get(i).getAwayTime().getScore();
                if (crbCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += crbCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for burnley

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < cearaCompleto.size(); i++) {
            if (cearaCompleto.get(i).getHomeTime().getName().equals("Ceará")) {
                name = cearaCompleto.get(i).getHomeTime().getName();
                image = cearaCompleto.get(i).getHomeTime().getImage();
                if (cearaCompleto.get(i).getHomeTime().getScore() > cearaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (cearaCompleto.get(i).getHomeTime().getScore() == cearaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (cearaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += cearaCompleto.get(i).getHomeTime().getScore();
                if (cearaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += cearaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (cearaCompleto.get(i).getAwayTime().getName().equals("Ceará")) {
                name = cearaCompleto.get(i).getAwayTime().getName();
                image = cearaCompleto.get(i).getAwayTime().getImage();
                if (cearaCompleto.get(i).getAwayTime().getScore() > cearaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (cearaCompleto.get(i).getAwayTime().getScore() == cearaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (cearaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += cearaCompleto.get(i).getAwayTime().getScore();
                if (cearaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += cearaCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for chelsea

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < chapecoenseCompleto.size(); i++) {
            if (chapecoenseCompleto.get(i).getHomeTime().getName().equals("Chapecoense")) {
                name = chapecoenseCompleto.get(i).getHomeTime().getName();
                image = chapecoenseCompleto.get(i).getHomeTime().getImage();
                if (chapecoenseCompleto.get(i).getHomeTime().getScore() > chapecoenseCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (chapecoenseCompleto.get(i).getHomeTime().getScore() == chapecoenseCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (chapecoenseCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += chapecoenseCompleto.get(i).getHomeTime().getScore();
                if (chapecoenseCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += chapecoenseCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (chapecoenseCompleto.get(i).getAwayTime().getName().equals("Chapecoense")) {
                name = chapecoenseCompleto.get(i).getAwayTime().getName();
                image = chapecoenseCompleto.get(i).getAwayTime().getImage();
                if (chapecoenseCompleto.get(i).getAwayTime().getScore() > chapecoenseCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (chapecoenseCompleto.get(i).getAwayTime().getScore() == chapecoenseCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (chapecoenseCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += chapecoenseCompleto.get(i).getAwayTime().getScore();
                if (chapecoenseCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += chapecoenseCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for crystalPalace

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < coritibaCompleto.size(); i++) {
            if (coritibaCompleto.get(i).getHomeTime().getName().equals("Coritiba")) {
                name = coritibaCompleto.get(i).getHomeTime().getName();
                image = coritibaCompleto.get(i).getHomeTime().getImage();
                if (coritibaCompleto.get(i).getHomeTime().getScore() > coritibaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (coritibaCompleto.get(i).getHomeTime().getScore() == coritibaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (coritibaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += coritibaCompleto.get(i).getHomeTime().getScore();
                if (coritibaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += coritibaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (coritibaCompleto.get(i).getAwayTime().getName().equals("Coritiba")) {
                name = coritibaCompleto.get(i).getAwayTime().getName();
                image = coritibaCompleto.get(i).getAwayTime().getImage();
                if (coritibaCompleto.get(i).getAwayTime().getScore() > coritibaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (coritibaCompleto.get(i).getAwayTime().getScore() == coritibaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (coritibaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += coritibaCompleto.get(i).getAwayTime().getScore();
                if (coritibaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += coritibaCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for everton

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < goiasCompleto.size(); i++) {
            if (goiasCompleto.get(i).getHomeTime().getName().equals("Goiás")) {
                name = goiasCompleto.get(i).getHomeTime().getName();
                image = goiasCompleto.get(i).getHomeTime().getImage();
                if (goiasCompleto.get(i).getHomeTime().getScore() > goiasCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (goiasCompleto.get(i).getHomeTime().getScore() == goiasCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (goiasCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += goiasCompleto.get(i).getHomeTime().getScore();
                if (goiasCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += goiasCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (goiasCompleto.get(i).getAwayTime().getName().equals("Goiás")) {
                name = goiasCompleto.get(i).getAwayTime().getName();
                image = goiasCompleto.get(i).getAwayTime().getImage();
                if (goiasCompleto.get(i).getAwayTime().getScore() > goiasCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (goiasCompleto.get(i).getAwayTime().getScore() == goiasCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (goiasCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += goiasCompleto.get(i).getAwayTime().getScore();
                if (goiasCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += goiasCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for fulham

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < guaraniCompleto.size(); i++) {
            if (guaraniCompleto.get(i).getHomeTime().getName().equals("Guarani")) {
                name = guaraniCompleto.get(i).getHomeTime().getName();
                image = guaraniCompleto.get(i).getHomeTime().getImage();
                if (guaraniCompleto.get(i).getHomeTime().getScore() > guaraniCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (guaraniCompleto.get(i).getHomeTime().getScore() == guaraniCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (guaraniCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += guaraniCompleto.get(i).getHomeTime().getScore();
                if (guaraniCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += guaraniCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (guaraniCompleto.get(i).getAwayTime().getName().equals("Guarani")) {
                name = guaraniCompleto.get(i).getAwayTime().getName();
                image = guaraniCompleto.get(i).getAwayTime().getImage();
                if (guaraniCompleto.get(i).getAwayTime().getScore() > guaraniCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (guaraniCompleto.get(i).getAwayTime().getScore() == guaraniCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (guaraniCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += guaraniCompleto.get(i).getAwayTime().getScore();
                if (guaraniCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += guaraniCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for liverpool

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < ituanoCompleto.size(); i++) {
            if (ituanoCompleto.get(i).getHomeTime().getName().equals("Ituano")) {
                name = ituanoCompleto.get(i).getHomeTime().getName();
                image = ituanoCompleto.get(i).getHomeTime().getImage();
                if (ituanoCompleto.get(i).getHomeTime().getScore() > ituanoCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (ituanoCompleto.get(i).getHomeTime().getScore() == ituanoCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (ituanoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += ituanoCompleto.get(i).getHomeTime().getScore();
                if (ituanoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += ituanoCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (ituanoCompleto.get(i).getAwayTime().getName().equals("Ituano")) {
                name = ituanoCompleto.get(i).getAwayTime().getName();
                image = ituanoCompleto.get(i).getAwayTime().getImage();
                if (ituanoCompleto.get(i).getAwayTime().getScore() > ituanoCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (ituanoCompleto.get(i).getAwayTime().getScore() == ituanoCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (ituanoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += ituanoCompleto.get(i).getAwayTime().getScore();
                if (ituanoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += ituanoCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for luton

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < mirassolCompleto.size(); i++) {
            if (mirassolCompleto.get(i).getHomeTime().getName().equals("Mirassol")) {
                name = mirassolCompleto.get(i).getHomeTime().getName();
                image = mirassolCompleto.get(i).getHomeTime().getImage();
                if (mirassolCompleto.get(i).getHomeTime().getScore() > mirassolCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (mirassolCompleto.get(i).getHomeTime().getScore() == mirassolCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (mirassolCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += mirassolCompleto.get(i).getHomeTime().getScore();
                if (mirassolCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += mirassolCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (mirassolCompleto.get(i).getAwayTime().getName().equals("Mirassol")) {
                name = mirassolCompleto.get(i).getAwayTime().getName();
                image = mirassolCompleto.get(i).getAwayTime().getImage();
                if (mirassolCompleto.get(i).getAwayTime().getScore() > mirassolCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (mirassolCompleto.get(i).getAwayTime().getScore() == mirassolCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (mirassolCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += mirassolCompleto.get(i).getAwayTime().getScore();
                if (mirassolCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += mirassolCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for city

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < novorizontinoCompleto.size(); i++) {
            if (novorizontinoCompleto.get(i).getHomeTime().getName().equals("Novorizontino")) {
                name = novorizontinoCompleto.get(i).getHomeTime().getName();
                image = novorizontinoCompleto.get(i).getHomeTime().getImage();
                if (novorizontinoCompleto.get(i).getHomeTime().getScore() > novorizontinoCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (novorizontinoCompleto.get(i).getHomeTime().getScore() == novorizontinoCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (novorizontinoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += novorizontinoCompleto.get(i).getHomeTime().getScore();
                if (novorizontinoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += novorizontinoCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (novorizontinoCompleto.get(i).getAwayTime().getName().equals("Novorizontino")) {
                name = novorizontinoCompleto.get(i).getAwayTime().getName();
                image = novorizontinoCompleto.get(i).getAwayTime().getImage();
                if (novorizontinoCompleto.get(i).getAwayTime().getScore() > novorizontinoCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (novorizontinoCompleto.get(i).getAwayTime().getScore() == novorizontinoCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (novorizontinoCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += novorizontinoCompleto.get(i).getAwayTime().getScore();
                if (novorizontinoCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += novorizontinoCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for unitede

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < operarioCompleto.size(); i++) {
            if (operarioCompleto.get(i).getHomeTime().getName().equals("Operário")) {
                name = operarioCompleto.get(i).getHomeTime().getName();
                image = operarioCompleto.get(i).getHomeTime().getImage();
                if (operarioCompleto.get(i).getHomeTime().getScore() > operarioCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (operarioCompleto.get(i).getHomeTime().getScore() == operarioCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (operarioCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += operarioCompleto.get(i).getHomeTime().getScore();
                if (operarioCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += operarioCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (operarioCompleto.get(i).getAwayTime().getName().equals("Operário")) {
                name = operarioCompleto.get(i).getAwayTime().getName();
                image = operarioCompleto.get(i).getAwayTime().getImage();
                if (operarioCompleto.get(i).getAwayTime().getScore() > operarioCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (operarioCompleto.get(i).getAwayTime().getScore() == operarioCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (operarioCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += operarioCompleto.get(i).getAwayTime().getScore();
                if (operarioCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += operarioCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for newcastle

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;

        for (int i = 0; i < paysanduCompleto.size(); i++) {
            if (paysanduCompleto.get(i).getHomeTime().getName().equals("Paysandu")) {
                name = paysanduCompleto.get(i).getHomeTime().getName();
                image = paysanduCompleto.get(i).getHomeTime().getImage();
                if (paysanduCompleto.get(i).getHomeTime().getScore() > paysanduCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (paysanduCompleto.get(i).getHomeTime().getScore() == paysanduCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (paysanduCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += paysanduCompleto.get(i).getHomeTime().getScore();
                if (paysanduCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += paysanduCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (paysanduCompleto.get(i).getAwayTime().getName().equals("Paysandu")) {
                name = paysanduCompleto.get(i).getAwayTime().getName();
                image = paysanduCompleto.get(i).getAwayTime().getImage();
                if (paysanduCompleto.get(i).getAwayTime().getScore() > paysanduCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (paysanduCompleto.get(i).getAwayTime().getScore() == paysanduCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (paysanduCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += paysanduCompleto.get(i).getAwayTime().getScore();
                if (paysanduCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += paysanduCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for nottingham

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < pontepretaCompleto.size(); i++) {
            if (pontepretaCompleto.get(i).getHomeTime().getName().equals("Ponte Preta")) {
                name = pontepretaCompleto.get(i).getHomeTime().getName();
                image = pontepretaCompleto.get(i).getHomeTime().getImage();
                if (pontepretaCompleto.get(i).getHomeTime().getScore() > pontepretaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (pontepretaCompleto.get(i).getHomeTime().getScore() == pontepretaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (pontepretaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += pontepretaCompleto.get(i).getHomeTime().getScore();
                if (pontepretaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += pontepretaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (pontepretaCompleto.get(i).getAwayTime().getName().equals("Ponte Preta")) {
                name = pontepretaCompleto.get(i).getAwayTime().getName();
                image = pontepretaCompleto.get(i).getAwayTime().getImage();
                if (pontepretaCompleto.get(i).getAwayTime().getScore() > pontepretaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (pontepretaCompleto.get(i).getAwayTime().getScore() == pontepretaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (pontepretaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += pontepretaCompleto.get(i).getAwayTime().getScore();
                if (pontepretaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += pontepretaCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for sheffield

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);

        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < santosCompleto.size(); i++) {
            if (santosCompleto.get(i).getHomeTime().getName().equals("Santos")) {
                name = santosCompleto.get(i).getHomeTime().getName();
                image = santosCompleto.get(i).getHomeTime().getImage();
                if (santosCompleto.get(i).getHomeTime().getScore() > santosCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (santosCompleto.get(i).getHomeTime().getScore() == santosCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (santosCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += santosCompleto.get(i).getHomeTime().getScore();
                if (santosCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += santosCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (santosCompleto.get(i).getAwayTime().getName().equals("Santos")) {
                name = santosCompleto.get(i).getAwayTime().getName();
                image = santosCompleto.get(i).getAwayTime().getImage();
                if (santosCompleto.get(i).getAwayTime().getScore() > santosCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (santosCompleto.get(i).getAwayTime().getScore() == santosCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (santosCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += santosCompleto.get(i).getAwayTime().getScore();
                if (santosCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += santosCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for tottenham

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modifiquei a variavel


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < sportCompleto.size(); i++) {
            if (sportCompleto.get(i).getHomeTime().getName().equals("Sport")) {
                name = sportCompleto.get(i).getHomeTime().getName();
                image = sportCompleto.get(i).getHomeTime().getImage();
                if (sportCompleto.get(i).getHomeTime().getScore() > sportCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (sportCompleto.get(i).getHomeTime().getScore() == sportCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (sportCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += sportCompleto.get(i).getHomeTime().getScore();
                if (sportCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += sportCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (sportCompleto.get(i).getAwayTime().getName().equals("Sport")) {
                name = sportCompleto.get(i).getAwayTime().getName();
                image = sportCompleto.get(i).getAwayTime().getImage();
                if (sportCompleto.get(i).getAwayTime().getScore() > sportCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (sportCompleto.get(i).getAwayTime().getScore() == sportCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (sportCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += sportCompleto.get(i).getAwayTime().getScore();
                if (sportCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += sportCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for westHam

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modifiquei a variavel


        //isso que fiz vai funcionar tambem.. masss podemos ter um problema de travar.. POis quando a lista é grande
        //e fico pedindo para o adapter atualizar para o usuario ele pode demorar e isso pode até fazer o app travar
        //entendeu ?sim, e agora?
        //por isso que nós fazemos o controle e avisamos o adapter para ele atualizar.. POis se toda vez que voce for modificar a variavel listaficial e o adapter
        //atualizar automaticamente pode acontecer esses problemas de travar o app.. entendeu ?sim, e qual seria outra melhor abordagem neste contexto?
        //fazer isso que 'nós fizemos ..pedir para o adapter atualizat a lista somente depois que inserimos tudo dentro da variavel listaOFICIAL
        //ENTENDEU ?pois é, aqui e adicionado a cada laço for percorrido e la no final e adicionado o útimo objeto.. ISSO


        name = null;
        image = null;
        pontos = 0;
        golsPro = 0;
        golsContra = 0;
        saldoGols = 0;
        jogos = 0;
        vitoria = 0;
        empate = 0;
        derrota = 0;


        for (int i = 0; i < vilanovaCompleto.size(); i++) {
            if (vilanovaCompleto.get(i).getHomeTime().getName().equals("Vila Nova")) {
                name = vilanovaCompleto.get(i).getHomeTime().getName();
                image = vilanovaCompleto.get(i).getHomeTime().getImage();
                if (vilanovaCompleto.get(i).getHomeTime().getScore() > vilanovaCompleto.get(i).getAwayTime().getScore()) {
                    vitoria += 1;
                } else if (vilanovaCompleto.get(i).getHomeTime().getScore() == vilanovaCompleto.get(i).getAwayTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (vilanovaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsPro += vilanovaCompleto.get(i).getHomeTime().getScore();
                if (vilanovaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsContra += vilanovaCompleto.get(i).getAwayTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }
            if (vilanovaCompleto.get(i).getAwayTime().getName().equals("Vila Nova")) {
                name = vilanovaCompleto.get(i).getAwayTime().getName();
                image = vilanovaCompleto.get(i).getAwayTime().getImage();
                if (vilanovaCompleto.get(i).getAwayTime().getScore() > vilanovaCompleto.get(i).getHomeTime().getScore()) {
                    vitoria += 1;
                } else if (vilanovaCompleto.get(i).getAwayTime().getScore() == vilanovaCompleto.get(i).getHomeTime().getScore()) {
                    empate += 1;
                } else {
                    derrota += 1;
                }
                if (vilanovaCompleto.get(i).getAwayTime().getScore() > 0)
                    golsPro += vilanovaCompleto.get(i).getAwayTime().getScore();
                if (vilanovaCompleto.get(i).getHomeTime().getScore() > 0)
                    golsContra += vilanovaCompleto.get(i).getHomeTime().getScore();
                jogos += 1;
                pontos = (vitoria * 3) + empate;
                saldoGols = golsPro - golsContra;
            }//fim do segundo if arsenal

        }//fim do for wolves

        classifica = new ClassificacaoOficialNovoModelo(name, image, pontos, golsPro, golsContra, saldoGols, jogos, vitoria, empate, derrota);
        listaOficial.add(classifica);//aqui modificamos a variavel listaOficial.. Essa variuavel nao esta vazia mais.// Só que pro adapter ela ainda esta vazia

        listaOficial.sort(new ComparatorPontosVitoriaSaldoGolsProSerieA_B());
        //Collections.sort(minhaLista);
        Collections.reverse(listaOficial);


        //Mas entenda que o código abaixo sempre vai atualizar a lista inteira
        timesClasificacaoBrasilA2024Adapter.notifyDataSetChanged();




    }//fim do método da interface
}//fim da classe


