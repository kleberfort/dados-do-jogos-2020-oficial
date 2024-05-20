package com.jogos.dadosoficialkf228920.activity.brasilA2022;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.AtleticoGO2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.AtleticoMG2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.AtleticoPR2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.Bahia2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.Botafogo2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.Bragantino2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.Corinthians2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.Criciuma2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.Cruzeiro2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.Cuiaba2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.Flamengo2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.Fluminense2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.Fortaleza2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.Gremio2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.Internacional2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.Juventude2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.Palmeiras2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.SaoPaulo2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.Vasco2024Activity;
import com.jogos.dadosoficialkf228920.activity.brasil.serieA2024.Vitoria2024Activity;
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
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Augsburg2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.BayerLeverkusen2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.BayernMunique2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Bochum2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.BorussiaDortmund2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.BorussiaMonche2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Darmstadt2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.EintrachtFrankfurt2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Freiburg2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Heidenheim2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Hoffenheim2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Koln2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Leipzig2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Mainz2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Stuttgart2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.UnionBerlin2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.WerderBremen2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.alemanha.Wolfsburg2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Alaves2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Almeria2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.AthleticBilbao2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.AtleticoMadrid2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Barcelona2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Cadiz2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.CeltaVigo2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Getafe2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Girona2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Granada2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.LasPalmas2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Mallorca2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Osasuna2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.RayoVallecano2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.RealBetis2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.RealMadrid2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.RealSociedad2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Sevilla2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Valencia2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.espanhol.Villarreal2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Brest2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Clermont2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.LeHavre2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Lens2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Lille2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Lorient2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Lyon2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Marseille2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Metz2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Monaco2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Montpellier2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Nantes2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.OgcNice2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Psg2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Reims2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Rennes2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Strasbourg2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.franca.Toulouse2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Arsenal2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.AstonVilla2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Bournemouth2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Brentford2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Brighton2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Burnley2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Chelsea2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.CrystalPalace2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Everton2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Fulham2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Liverpool2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Luton2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.ManchesterCity2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.ManchesterUnited2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Newcastle2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Nottingham2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Sheffield2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Tottenham2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.WestHam2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.ingles.Wolves2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.AcMilan2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Atalanta2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Bologna2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Cagliari2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Empoli2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Fiorentina2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Frosinone2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Genoa2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.HellasVerona2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.InterMilao2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Juventus2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Lazio2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Lecce2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Monza2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Napoli2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Roma2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Salernitana2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Sassuolo2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Torino2023_24Activity;
import com.jogos.dadosoficialkf228920.activity.europaA2023a24.italia.Udinese2023_24Activity;
import com.jogos.dadosoficialkf228920.databinding.ActivityMainBinding;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.ListaBrasilSerieA_2024_TesteFragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.ListaBrasilSerie_B_2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.alemanha.ListaAlemaoA2023a24Fragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.espanhol.ListaEspanholA2023a24Fragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.franca.ListaFrancaA2023a24Fragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.ingles.ListaInglesA2023a24Fragment;
import com.jogos.dadosoficialkf228920.fragments.listajogo.europaA2023a24.italia.ListaItaliaA2023a24Fragment;
import com.jogos.dadosoficialkf228920.model.ViewPagerAdapter;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

public class MainActivity extends AppCompatActivity implements ListaInglesA2023a24Fragment.ListaInglesaInterface, ListaEspanholA2023a24Fragment.ListaEspanholaInterface, ListaAlemaoA2023a24Fragment.ListaAlemanhaInterface, ListaItaliaA2023a24Fragment.ListaItalianoInterface, ListaFrancaA2023a24Fragment.ListaFrancesInterface, ListaBrasilSerieA_2024_TesteFragment.ListaBrasilA2024Interface, ListaBrasilSerie_B_2024Fragment.ListaBrasilB2024Interface {

    //o que tenho que fazer agora aqui ?posso chamar varias Interfaces?, sim.// ele ja mostrou meio que direto pra mim
    //mas perceba: Tem o nome do fragment e o nome da interface que criamos na lista espanhola,
    //faz a importacao do meotod  da um alt+ enter

    //lembra que a MainActivty esdta ouvindo o metodo da interface ?sim

    //esta vendo esse código aqui ?sim//

    //os fragemtns ficam dentro da onde ? da Activitvy
    //certo ?sim
    //imagine que a actrivi é um pai e os fragments sao os filhos

    // criei uma interface na onde ?sim esta no fragmen t certo?sim, v
    // e estamos na MainActivty
    // e como ela é o pai e os fragments são filhos
    //posso escutar o que os fragments fazem
    // e podemos fazer isso com a Interface

    //entao usamos o implements e passamos o nome do filho (fragment) que queremos ouvir
    //ListaInglesA2023a24Fragment.
    // depois colocamos o nome da interface que criamos, pois queresmo saber o que esta acontecendo com o medoto que esta dentro da interface
    //ListaInglesA2023a24Fragment.ListaInglesaInterface
    //entendeu um pouco ?entendi, não apaga, pois vou ler tudo, e um pouco complexo,sim isso é complexo mesmo, relaxa
    //vai demorar alguns projetos ainda pra pegar o jeito//
    //estou te mostrando da forma mais simples..

    //quando colocamos que queremos ou o fragment e colocamos o nome da nossa interface
    //temos que criar o metodo que esta dentro dessa interface.. Como voce disse é obrigatorio usar o metodo dela
    //viu que ficou vermelho la em cima ?sim
    //vamos escolher a parte que fala
    //implementar metodos


    private ActivityMainBinding binding;
    private FirebaseAnalytics mFirebaseAnalytics;

    String id;
    String name;

    String keyAppOdealBanner = "77e8bff791352f147853a14eb2eac44f5e6262538a98b6cb";

    String opcao = "";

    private String unityGameID = "5558906";
    private Boolean testMode = true;

    private BannerView bannerBottomUnity;
    private RelativeLayout relativeLayoutBannerUnity;
    private String bottomAdUnitId = "Banner_Android";
    private String intersticialAdUnitId = "Inters";
    boolean intersticialUnityCarregado = false;

    IUnityAdsShowListener showListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        configTablayout();

        Log.d("Executou", "MainActivity");

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);


        //coloco o códigi de cima? //unityGameID, //tira o teste para publicar//
        //mas antes de publicar tente colocar mais times  somente copiando o que fizemos

        //Quando irei publicar, tenho que tirar o parametro "textMode" e para teste coloco depois do parametro unityGameId.
//        UnityAds.initialize(this, unityGameID, new IUnityAdsInitializationListener() {
//            @Override
//            public void onInitializationComplete() {
//
//                Log.d("testeunity", "completo");
//                //quando a comunicao acontece com sucesso.. comunicao do Aplicativo com a Unity
//            }
//
//            @Override
//            public void onInitializationFailed(UnityAds.UnityAdsInitializationError error, String message) {
//                //quando coloco o this la em cima esse metodo é chamado para falar qual foi o erro
//                //Esse erro é referente a Unity
//
//                Log.d("testeunity-", message);
//
//            }
//        });


        relativeLayoutBannerUnity = binding.adViewContainerMainActivityUnity;
        exibirBannerUnity();
        iniciarIntersticialUnity();



        /*

        //código do admob
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        binding.adViewBsA22Principal.loadAd(adRequest);
         */



    }//fim do onCreate

    private void configTablayout(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        binding.viewPager.setAdapter(adapter);

        adapter.addFragment(new ListaBrasilSerieA_2024_TesteFragment(), "Série A 2024");
        adapter.addFragment(new ListaBrasilSerie_B_2024Fragment(), "Série B 2024");
        adapter.addFragment(new ListaInglesA2023a24Fragment(), "Inglês A 2023-24");
        adapter.addFragment(new ListaEspanholA2023a24Fragment(), "Espanhol A 2023-24");
        adapter.addFragment(new ListaAlemaoA2023a24Fragment(), "Alemão A 2023-24");
        adapter.addFragment(new ListaItaliaA2023a24Fragment(), "Italiano A 2023-24");
        adapter.addFragment(new ListaFrancaA2023a24Fragment(), "Françês A 2023-24");
        binding.viewPager.setOffscreenPageLimit(adapter.getItemCount());

        TabLayoutMediator mediator = new TabLayoutMediator(binding.tabs, binding.viewPager, (tab, position) -> {
            tab.setText(adapter.getTitle(position));
        });

        mediator.attach();

    }


    //-------------------------------------------------------  BANNER UNITY
    //banner Unity

    public void exibirBannerUnity() {

        bannerBottomUnity = new BannerView(this, bottomAdUnitId, new UnityBannerSize(320, 50));
        bannerBottomUnity.setListener(listenerBanner());
        bannerBottomUnity.load();
        relativeLayoutBannerUnity.addView(bannerBottomUnity);
        //conecta seu celular
    }


    //callback banner Unity
    public BannerView.Listener listenerBanner() {

        //agora esse metodo é para detectar o banner da Unity.. Erro do banner, abriu o banner, clicou no banner
        //entendeu ? caso eu queira obter informações eu verifico onde?
        //

        // Listener for banner events:
        BannerView.Listener bannerListener = new BannerView.Listener() {

            @Override
            public void onBannerLoaded(BannerView bannerAdView) {

            }

            @Override
            public void onBannerShown(BannerView bannerAdView) {

            }

            @Override
            public void onBannerClick(BannerView bannerAdView) {

            }

            @Override
            public void onBannerFailedToLoad(BannerView bannerAdView, BannerErrorInfo errorInfo) {

            }

            @Override
            public void onBannerLeftApplication(BannerView bannerView) {

            }
        };

        return bannerListener;

    }


    //-------------------------------------------------------  INTERSTICIAL UNITY


    public void iniciarIntersticialUnity() {

        // load = carrega o intersticial para o aplicativo exibir
        //unityGameid = idientificacao da conta com seu aplicativo da Unity
        //IUnityAdsLoadListener = callback para nos dizer se intersticial ja esta armazenado no aplicativo
        //erro bobo
        // faz um teste ai .. Apareceu ?clico no time e abri apenas o detalhe do time e não intersticial
        UnityAds.load(intersticialAdUnitId, new IUnityAdsLoadListener() {
            @Override
            public void onUnityAdsAdLoaded(String placementId) {

                intersticialUnityCarregado = true;
                //onUnityAdsAdLoaded cai aqui dentro quando o intersticial foi carregado no app
                listenerIntesticialUnity();//se foi carregado dentro do app, chamamos esse metodo para nos dizer o que vai acontecer quando o aplicativo
                // exibe o intersticial

            }

            @Override
            public void onUnityAdsFailedToLoad(String placementId, UnityAds.UnityAdsLoadError error, String message) {
                //falha ao armazenar o intesrticial
                intersticialUnityCarregado = false;
            }
        });
    }


    private void listenerIntesticialUnity() {

        //o interstifcial nao pode ser exibido de qualquer jeito se nao temos problemas
        //vou dar um exemplo

        showListener = new IUnityAdsShowListener() {
            @Override
            public void onUnityAdsShowFailure(String placementId, UnityAds.UnityAdsShowError error, String message) {

            }

            @Override
            public void onUnityAdsShowStart(String placementId) {
                Log.v("UnityAdsExample", "onUnityAdsShowStart: " + placementId);
            }

            @Override
            public void onUnityAdsShowClick(String placementId) {
                Log.v("UnityAdsExample", "onUnityAdsShowClick: " + placementId);
            }

            @Override
            public void onUnityAdsShowComplete(String placementId, UnityAds.UnityAdsShowCompletionState state) {
                // o que acontece quando o nintersticial é fechado

                intersticialUnityCarregado = false;
                iniciarIntersticialUnity();

                if (opcao.equals("Atlético-PR")) {
                    Intent intent = new Intent(getBaseContext(), AtleticoPR2024Activity.class);
                    startActivity(intent);
                }
                //entendeu? aqui não entendi, qual vai aparecer?
                //estamos usando a variavel opcao
                else if (opcao.equals("Atlético-GO")) {
                    Intent intent = new Intent(getBaseContext(), AtleticoGO2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Atlético-MG")) {
                    Intent intent = new Intent(getBaseContext(), AtleticoMG2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Bahia")) {
                    Intent intent = new Intent(getBaseContext(), Bahia2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Botafogo")) {
                    Intent intent = new Intent(getBaseContext(), Botafogo2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Bragantino")) {
                    Intent intent = new Intent(getBaseContext(), Bragantino2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Corinthians")) {
                    Intent intent = new Intent(getBaseContext(), Corinthians2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Criciúma")) {
                    Intent intent = new Intent(getBaseContext(), Criciuma2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Cruzeiro")) {
                    Intent intent = new Intent(getBaseContext(), Cruzeiro2024Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Cuiabá")) {
                    Intent intent = new Intent(getBaseContext(), Cuiaba2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Flamengo")) {
                    Intent intent = new Intent(getBaseContext(), Flamengo2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Fluminense")) {
                    Intent intent = new Intent(getBaseContext(), Fluminense2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Fortaleza")) {
                    Intent intent = new Intent(getBaseContext(), Fortaleza2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Grêmio")) {
                    Intent intent = new Intent(getBaseContext(), Gremio2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Internacional")) {
                    Intent intent = new Intent(getBaseContext(), Internacional2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Juventude")) {
                    Intent intent = new Intent(getBaseContext(), Juventude2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Palmeiras")) {
                    Intent intent = new Intent(getBaseContext(), Palmeiras2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("São-Paulo")) {
                    Intent intent = new Intent(getBaseContext(), SaoPaulo2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Vasco")) {
                    Intent intent = new Intent(getBaseContext(), Vasco2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Vitória")) {
                    Intent intent = new Intent(getBaseContext(), Vitoria2024Activity.class);
                    startActivity(intent);

                }
                //FIM DA CHAMADA BRASILEIRO SERIE A 2024

                else if (opcao.equals("Amazonas")) {
                    Intent intent = new Intent(getBaseContext(), Amazonas2024Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("América-MG")) {
                    Intent intent = new Intent(getBaseContext(), AmericaMG2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Avaí")) {
                    Intent intent = new Intent(getBaseContext(), Avai2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Botafogo-SP")) {
                    Intent intent = new Intent(getBaseContext(), BotafogoSP2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Brusque")) {
                    Intent intent = new Intent(getBaseContext(), Brusque2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("CRB")) {
                    Intent intent = new Intent(getBaseContext(), Crb2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Ceará")) {
                    Intent intent = new Intent(getBaseContext(), Ceara2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Chapecoense")) {
                    Intent intent = new Intent(getBaseContext(), Chapecoense2024Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Coritiba")) {
                    Intent intent = new Intent(getBaseContext(), Coritiba2024Activity.class);
                    startActivity(intent);

                } else if (opcao.equals("Goiás")) {
                    Intent intent = new Intent(getBaseContext(), Goias2024Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Guarani")) {
                    Intent intent = new Intent(getBaseContext(), Guarani2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Ituano")) {
                    Intent intent = new Intent(getBaseContext(), Ituano2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Mirassol")) {
                    Intent intent = new Intent(getBaseContext(), Mirassol2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Novorizontino")) {
                    Intent intent = new Intent(getBaseContext(), Novorizontino2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Operário")) {
                    Intent intent = new Intent(getBaseContext(), Operario2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Paysandu")) {
                    Intent intent = new Intent(getBaseContext(), Paysandu2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Ponte Preta")) {
                    Intent intent = new Intent(getBaseContext(), PontePreta2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Santos")) {
                    Intent intent = new Intent(getBaseContext(), Santos2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Sport")) {
                    Intent intent = new Intent(getBaseContext(), Sport2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Vila Nova")) {
                    Intent intent = new Intent(getBaseContext(), VilaNova2024Activity.class);
                    startActivity(intent);

                }
                //FIM DA CHAMADA BRASILEIRO SERIE B 2024

                //esta vendo todo esse codigo aqui abaixo ?sim
                if (opcao.equals("Arsenal")) {
                    Intent arsenal = new Intent(getBaseContext(), Arsenal2023_24Activity.class);
                    startActivity(arsenal);
                }
                //entendeu? aqui não entendi, qual vai aparecer?
                //estamos usando a variavel opcao
                else if (opcao.equals("Aston")) {
                    Intent astonvilla = new Intent(getBaseContext(), AstonVilla2023_24Activity.class);
                    startActivity(astonvilla);
                } else if (opcao.equals("Bournemouth")) {
                    Intent bournemouth = new Intent(getBaseContext(), Bournemouth2023_24Activity.class);
                    startActivity(bournemouth);
                } else if (opcao.equals("Brentford")) {
                    Intent brentford = new Intent(getBaseContext(), Brentford2023_24Activity.class);
                    startActivity(brentford);
                } else if (opcao.equals("Liverpool")) {
                    Intent liverpool = new Intent(getBaseContext(), Liverpool2023_24Activity.class);
                    startActivity(liverpool);
                } else if (opcao.equals("Manchester City")) {
                    Intent city = new Intent(getBaseContext(), ManchesterCity2023_24Activity.class);
                    startActivity(city);
                } else if (opcao.equals("Manchester United")) {
                    Intent united = new Intent(getBaseContext(), ManchesterUnited2023_24Activity.class);
                    startActivity(united);
                } else if (opcao.equals("Tottenham")) {
                    Intent tottenham = new Intent(getBaseContext(), Tottenham2023_24Activity.class);
                    startActivity(tottenham);
                } else if (opcao.equals("Brighton")) {
                    Intent brighton = new Intent(getBaseContext(), Brighton2023_24Activity.class);
                    startActivity(brighton);
                }else if (opcao.equals("Burnley")) {
                    Intent burnley = new Intent(getBaseContext(), Burnley2023_24Activity.class);
                    startActivity(burnley);

                }else if (opcao.equals("Chelsea")) {
                    Intent chelsea = new Intent(getBaseContext(), Chelsea2023_24Activity.class);
                    startActivity(chelsea);

                }else if (opcao.equals("Crystal Palace")) {
                    Intent crystalpalace = new Intent(getBaseContext(), CrystalPalace2023_24Activity.class);
                    startActivity(crystalpalace);

                }else if (opcao.equals("Everton")) {
                    Intent everton = new Intent(getBaseContext(), Everton2023_24Activity.class);
                    startActivity(everton);

                }else if (opcao.equals("Fulham")) {
                    Intent fulham = new Intent(getBaseContext(), Fulham2023_24Activity.class);
                    startActivity(fulham);

                }else if (opcao.equals("Luton")) {
                    Intent luton = new Intent(getBaseContext(), Luton2023_24Activity.class);
                    startActivity(luton);

                }else if (opcao.equals("Newcastle")) {
                    Intent luton = new Intent(getBaseContext(), Newcastle2023_24Activity.class);
                    startActivity(luton);

                }else if (opcao.equals("Nottingham Forest")) {
                    Intent forest = new Intent(getBaseContext(), Nottingham2023_24Activity.class);
                    startActivity(forest);

                }else if (opcao.equals("Sheffield")) {
                    Intent sheffield = new Intent(getBaseContext(), Sheffield2023_24Activity.class);
                    startActivity(sheffield);

                }else if (opcao.equals("West Ham")) {
                    Intent westham = new Intent(getBaseContext(), WestHam2023_24Activity.class);
                    startActivity(westham);

                }else if (opcao.equals("Wolverhampton")) {
                    Intent wolves = new Intent(getBaseContext(), Wolves2023_24Activity.class);
                    startActivity(wolves);

                }



                //Times Espanhol
                else if (opcao.equals("Alaves")) {
                    Intent elche = new Intent(getBaseContext(), Alaves2023_24Activity.class);
                    startActivity(elche);
                } else if (opcao.equals("Almería")) {
                    Intent almeria = new Intent(getBaseContext(), Almeria2023_24Activity.class);
                    startActivity(almeria);
                } else if (opcao.equals("Barcelona")) {
                    Intent barcelona = new Intent(getBaseContext(), Barcelona2023_24Activity.class);
                    startActivity(barcelona);
                } else if (opcao.equals("Real Madrid")) {
                    Intent realMadrid = new Intent(getBaseContext(), RealMadrid2023_24Activity.class);
                    startActivity(realMadrid);
                } else if (opcao.equals("Atlético de Madrid")) {
                    Intent atleticoMadrid = new Intent(getBaseContext(), AtleticoMadrid2023_24Activity.class);
                    startActivity(atleticoMadrid);
                } else if (opcao.equals("Girona")) {
                    Intent girona = new Intent(getBaseContext(), Girona2023_24Activity.class);
                    startActivity(girona);
                } else if (opcao.equals("Athletic Bilbao")) {
                    Intent athleticBilbao = new Intent(getBaseContext(), AthleticBilbao2023_24Activity.class);
                    startActivity(athleticBilbao);
                } else if (opcao.equals("Cádiz")) {
                    Intent cadiz = new Intent(getBaseContext(), Cadiz2023_24Activity.class);
                    startActivity(cadiz);

                }else if (opcao.equals("Celta de Vigo")) {
                    Intent celtaVigo = new Intent(getBaseContext(), CeltaVigo2023_24Activity.class);
                    startActivity(celtaVigo);

                }else if (opcao.equals("Getafe")) {
                    Intent getafe = new Intent(getBaseContext(), Getafe2023_24Activity.class);
                    startActivity(getafe);

                }else if (opcao.equals("Granada")) {
                    Intent espanyol = new Intent(getBaseContext(), Granada2023_24Activity.class);
                    startActivity(espanyol);

                }else if (opcao.equals("Las Palmas")) {
                    Intent realValladolid = new Intent(getBaseContext(), LasPalmas2023_24Activity.class);
                    startActivity(realValladolid);

                }else if (opcao.equals("Mallorca")) {
                    Intent mallorca = new Intent(getBaseContext(), Mallorca2023_24Activity.class);
                    startActivity(mallorca);

                }else if (opcao.equals("Osasuna")) {
                    Intent osasuna = new Intent(getBaseContext(), Osasuna2023_24Activity.class);
                    startActivity(osasuna);

                }else if (opcao.equals("Rayo Vallecano")) {
                    Intent rayoVallecano = new Intent(getBaseContext(), RayoVallecano2023_24Activity.class);
                    startActivity(rayoVallecano);

                }else if (opcao.equals("Real Betis")) {
                    Intent realBetis = new Intent(getBaseContext(), RealBetis2023_24Activity.class);
                    startActivity(realBetis);

                }else if (opcao.equals("Real Sociedad")) {
                    Intent realSociedad = new Intent(getBaseContext(), RealSociedad2023_24Activity.class);
                    startActivity(realSociedad);

                }else if (opcao.equals("Sevilla")) {
                    Intent sevilla = new Intent(getBaseContext(), Sevilla2023_24Activity.class);
                    startActivity(sevilla);

                }else if (opcao.equals("Valencia")) {
                    Intent valencica = new Intent(getBaseContext(), Valencia2023_24Activity.class);
                    startActivity(valencica);

                }else if (opcao.equals("Villarreal")) {
                    Intent villarreal = new Intent(getBaseContext(), Villarreal2023_24Activity.class);
                    startActivity(villarreal);

                }



                //Times Alemanha
                else if (opcao.equals("Bayer Leverkusen")) {
                    Intent bayerLeverkusen = new Intent(getBaseContext(), BayerLeverkusen2023_24Activity.class);
                    startActivity(bayerLeverkusen);
                }else if (opcao.equals("Bayern de Munique")) {
                    Intent bayernMunique = new Intent(getBaseContext(), BayernMunique2023_24Activity.class);
                    startActivity(bayernMunique);
                }else if (opcao.equals("Borussia Dortmund")) {
                    Intent borussiaDortmund = new Intent(getBaseContext(), BorussiaDortmund2023_24Activity.class);
                    startActivity(borussiaDortmund);
                }else if (opcao.equals("RB Leipzig")) {
                    Intent leipzig = new Intent(getBaseContext(), Leipzig2023_24Activity.class);
                    startActivity(leipzig);
                }else if (opcao.equals("Union Berlin")) {
                    Intent unionBerlin = new Intent(getBaseContext(), UnionBerlin2023_24Activity.class);
                    startActivity(unionBerlin);
                }else if (opcao.equals("Stuttgart")) {
                    Intent stuttgart = new Intent(getBaseContext(), Stuttgart2023_24Activity.class);
                    startActivity(stuttgart);
                }else if (opcao.equals("Werder Bremen")) {
                    Intent werderBremen = new Intent(getBaseContext(), WerderBremen2023_24Activity.class);
                    startActivity(werderBremen);
                }else if (opcao.equals("Augsburg")) {
                    Intent augsburg = new Intent(getBaseContext(), Augsburg2023_24Activity.class);
                    startActivity(augsburg);

                }else if (opcao.equals("Bochum")) {
                    Intent bochum = new Intent(getBaseContext(), Bochum2023_24Activity.class);
                    startActivity(bochum);

                }else if (opcao.equals("Borussia Mönchengladbach")) {
                    Intent borussiaMonchengladbach = new Intent(getBaseContext(), BorussiaMonche2023_24Activity.class);
                    startActivity(borussiaMonchengladbach);

                }else if (opcao.equals("Köln(Colônia)")) {
                    Intent koln = new Intent(getBaseContext(), Koln2023_24Activity.class);
                    startActivity(koln);

                }else if (opcao.equals("Darmstadt98")) {
                    Intent darmstadt98 = new Intent(getBaseContext(), Darmstadt2023_24Activity.class);
                    startActivity(darmstadt98);

                }else if (opcao.equals("Eintracht Frankfurt")) {
                    Intent frankfurt = new Intent(getBaseContext(), EintrachtFrankfurt2023_24Activity.class);
                    startActivity(frankfurt);

                }else if (opcao.equals("Freiburg")) {
                    Intent freiburg = new Intent(getBaseContext(), Freiburg2023_24Activity.class);
                    startActivity(freiburg);

                }else if (opcao.equals("Heidenheim")) {
                    Intent heidenheim = new Intent(getBaseContext(), Heidenheim2023_24Activity.class);
                    startActivity(heidenheim);

                }else if (opcao.equals("Hoffenheim")) {
                    Intent hoffenheim = new Intent(getBaseContext(), Hoffenheim2023_24Activity.class);
                    startActivity(hoffenheim);

                }else if (opcao.equals("Mainz 05")) {
                    Intent mainz05 = new Intent(getBaseContext(), Mainz2023_24Activity.class);
                    startActivity(mainz05);

                }else if (opcao.equals("Wolfsburg")) {
                    Intent wolfburg = new Intent(getBaseContext(), Wolfsburg2023_24Activity.class);
                    startActivity(wolfburg);
                }





                //TIMES ITALIANO
                else if (opcao.equals("Inter Milan")) {
                    Intent inter = new Intent(getBaseContext(), InterMilao2023_24Activity.class);
                    startActivity(inter);
                } else if (opcao.equals("Milan")) {
                    Intent milan = new Intent(getBaseContext(), AcMilan2023_24Activity.class);
                    startActivity(milan);
                }else if (opcao.equals("Juventus")) {
                    Intent juventus = new Intent(getBaseContext(), Juventus2023_24Activity.class);
                    startActivity(juventus);
                }else if (opcao.equals("Atalanta")) {
                    Intent atalanta = new Intent(getBaseContext(), Atalanta2023_24Activity.class);
                    startActivity(atalanta);
                }else if (opcao.equals("Napoli")) {
                    Intent napoli = new Intent(getBaseContext(), Napoli2023_24Activity.class);
                    startActivity(napoli);
                }else if (opcao.equals("Roma")) {
                    Intent roma = new Intent(getBaseContext(), Roma2023_24Activity.class);
                    startActivity(roma);
                }else if (opcao.equals("Lazio")) {
                    Intent lazio = new Intent(getBaseContext(), Lazio2023_24Activity.class);
                    startActivity(lazio);
                }else if (opcao.equals("Fiorentina")) {
                    Intent fiorentina = new Intent(getBaseContext(), Fiorentina2023_24Activity.class);
                    startActivity(fiorentina);
                }else if (opcao.equals("Bologna")) {
                    Intent bologna = new Intent(getBaseContext(), Bologna2023_24Activity.class);
                    startActivity(bologna);

                }else if (opcao.equals("Cagliari")) {
                    Intent cagliari = new Intent(getBaseContext(), Cagliari2023_24Activity.class);
                    startActivity(cagliari);

                }else if (opcao.equals("Empoli")) {
                    Intent empoli = new Intent(getBaseContext(), Empoli2023_24Activity.class);
                    startActivity(empoli);

                }else if (opcao.equals("Genoa")) {
                    Intent genoa = new Intent(getBaseContext(), Genoa2023_24Activity.class);
                    startActivity(genoa);

                }else if (opcao.equals("Frosinone")) {
                    Intent frosinone = new Intent(getBaseContext(), Frosinone2023_24Activity.class);
                    startActivity(frosinone);

                }else if (opcao.equals("Hellas Verona")) {
                    Intent verona = new Intent(getBaseContext(), HellasVerona2023_24Activity.class);
                    startActivity(verona);

                }else if (opcao.equals("Lecce")) {
                    Intent lecce = new Intent(getBaseContext(), Lecce2023_24Activity.class);
                    startActivity(lecce);

                }else if (opcao.equals("Monza")) {
                    Intent monza = new Intent(getBaseContext(), Monza2023_24Activity.class);
                    startActivity(monza);

                }else if (opcao.equals("Salernitana")) {
                    Intent salernitana = new Intent(getBaseContext(), Salernitana2023_24Activity.class);
                    startActivity(salernitana);
                }else if (opcao.equals("Sassuolo")) {
                    Intent sassuolo = new Intent(getBaseContext(), Sassuolo2023_24Activity.class);
                    startActivity(sassuolo);

                }else if (opcao.equals("Torino")) {
                    Intent torino = new Intent(getBaseContext(), Torino2023_24Activity.class);
                    startActivity(torino);

                }else if (opcao.equals("Udinese")) {
                    Intent udinese = new Intent(getBaseContext(), Udinese2023_24Activity.class);
                    startActivity(udinese);

                }


                //TIMES FRACES
                else if (opcao.equals("Brest")) {
                  Intent brest = new Intent(getBaseContext(), Brest2023_24Activity.class);
                  startActivity(brest);
                }    else if (opcao.equals("Clermont")) {
                    Intent clermont = new Intent(getBaseContext(), Clermont2023_24Activity.class);
                    startActivity(clermont);

                }  else if (opcao.equals("Le Havre")) {
                    Intent leHavre = new Intent(getBaseContext(), LeHavre2023_24Activity.class);
                    startActivity(leHavre);

                }  else if (opcao.equals("Lens")) {
                    Intent lens = new Intent(getBaseContext(), Lens2023_24Activity.class);
                    startActivity(lens);

                }  else if (opcao.equals("Lille")) {
                    Intent lille = new Intent(getBaseContext(), Lille2023_24Activity.class);
                    startActivity(lille);

                }  else if (opcao.equals("Lorient")) {
                    Intent lorient = new Intent(getBaseContext(), Lorient2023_24Activity.class);
                    startActivity(lorient);

                }  else if (opcao.equals("Lyon")) {
                    Intent lyon = new Intent(getBaseContext(), Lyon2023_24Activity.class);
                    startActivity(lyon);

                }  else if (opcao.equals("Marseille")) {
                    Intent marseille = new Intent(getBaseContext(), Marseille2023_24Activity.class);
                    startActivity(marseille);

                }  else if (opcao.equals("Metz")) {
                    Intent metz = new Intent(getBaseContext(), Metz2023_24Activity.class);
                    startActivity(metz);

                }  else if (opcao.equals("Monaco")) {
                    Intent monaco = new Intent(getBaseContext(), Monaco2023_24Activity.class);
                    startActivity(monaco);

                }  else if (opcao.equals("Montpellier")) {
                    Intent montpellier = new Intent(getBaseContext(), Montpellier2023_24Activity.class);
                    startActivity(montpellier);

                }  else if (opcao.equals("Nantes")) {
                    Intent nantes = new Intent(getBaseContext(), Nantes2023_24Activity.class);
                    startActivity(nantes);

                }  else if (opcao.equals("Nice")) {
                    Intent nice = new Intent(getBaseContext(), OgcNice2023_24Activity.class);
                    startActivity(nice);

                }  else if (opcao.equals("PSG")) {
                    Intent psg = new Intent(getBaseContext(), Psg2023_24Activity.class);
                    startActivity(psg);

                }  else if (opcao.equals("Reims")) {
                    Intent reims = new Intent(getBaseContext(), Reims2023_24Activity.class);
                    startActivity(reims);

                }  else if (opcao.equals("Rennes")) {
                    Intent rennes = new Intent(getBaseContext(), Rennes2023_24Activity.class);
                    startActivity(rennes);

                }  else if (opcao.equals("Strasbourg")) {
                    Intent strasbourg = new Intent(getBaseContext(), Strasbourg2023_24Activity.class);
                    startActivity(strasbourg);

                }  else if (opcao.equals("Toulouse")) {
                    Intent toulouse = new Intent(getBaseContext(), Toulouse2023_24Activity.class);
                    startActivity(toulouse);

                }

                // blz, a dúvida minha é, vc implementou no ingles e espanhol, para colocar nos outros, primeiro inicio onde, criando a interface dentro da minha Lista?
                //sempre comeca pelos fragments
                //copia e cola e faz os nomes da interfaces diferentes
                //depois faz a parte da MainActivity
            }
        };

    }



    @Override
    public void listaInglesaMetodo(String nome) {

        opcao = nome;
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        } else {
            if (nome.equals("Arsenal")) {
                Intent arsenal = new Intent(this, Arsenal2023_24Activity.class);
                startActivity(arsenal);
            } else if (nome.equals("Aston")) {
                Intent astonvilla = new Intent(this, AstonVilla2023_24Activity.class);
                startActivity(astonvilla);
            } else if (nome.equals("Bournemouth")) {
                Intent bournemouth = new Intent(this, Bournemouth2023_24Activity.class);
                startActivity(bournemouth);
            } else if (nome.equals("Brentford")) {
                Intent brentford = new Intent(this, Brentford2023_24Activity.class);
                startActivity(brentford);
            } else if (nome.equals("Liverpool")) {
                Intent liverpool = new Intent(this, Liverpool2023_24Activity.class);
                startActivity(liverpool);
            } else if (nome.equals("Manchester City")) {
                Intent city = new Intent(this, ManchesterCity2023_24Activity.class);
                startActivity(city);
            } else if (nome.equals("Manchester United")) {
                Intent united = new Intent(this, ManchesterUnited2023_24Activity.class);
                startActivity(united);
            } else if (nome.equals("Tottenham")) {
                Intent tottenham = new Intent(this, Tottenham2023_24Activity.class);
                startActivity(tottenham);
            }else if (nome.equals("Brighton")) {
                Intent brighton = new Intent(this, Brighton2023_24Activity.class);
                startActivity(brighton);

            }else if (nome.equals("Burnley")) {
                Intent burnley = new Intent(this, Burnley2023_24Activity.class);
                startActivity(burnley);

            }else if (nome.equals("Chelsea")) {
                Intent chelsea = new Intent(this, Chelsea2023_24Activity.class);
                startActivity(chelsea);

            }else if (nome.equals("Crystal Palace")) {
                Intent crystalpalace = new Intent(this, CrystalPalace2023_24Activity.class);
                startActivity(crystalpalace);

            }else if (nome.equals("Everton")) {
                Intent everton = new Intent(this, Everton2023_24Activity.class);
                startActivity(everton);

            }else if (nome.equals("Fulham")) {
                Intent fulham = new Intent(this, Fulham2023_24Activity.class);
                startActivity(fulham);

            }else if (nome.equals("Luton")) {
                Intent luton = new Intent(this, Luton2023_24Activity.class);
                startActivity(luton);

            }else if (nome.equals("Newcastle")) {
                Intent luton = new Intent(this, Newcastle2023_24Activity.class);
                startActivity(luton);

            }else if (nome.equals("Nottingham Forest")) {
                Intent forest = new Intent(this, Nottingham2023_24Activity.class);
                startActivity(forest);

            }else if (nome.equals("Sheffield")) {
                Intent sheffield = new Intent(this, Sheffield2023_24Activity.class);
                startActivity(sheffield);

            }else if (nome.equals("West Ham")) {
                Intent westham = new Intent(this, WestHam2023_24Activity.class);
                startActivity(westham);

            }else if (nome.equals("Wolverhampton")) {
                Intent wolves = new Intent(this, Wolves2023_24Activity.class);
                startActivity(wolves);

            }

        }




    }// fim do método listaInglesMetodo
    //pronto agora é só ir adicionando os outros times e pode depois tirar a parte do teste

    @Override
    public void listaEspanholaMetodo(String nome) {

        //vai fazer a memsa coisa como de cima mas com os nomes desse fragament
        //veja se vai aparecer o intersticial ?não

        //fizemos apenas com a liga espanhola//testa a liga espanhola
        //funcionou ? qual o time mesmo
        opcao = nome;
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);

        } else {
            if (nome.equals("Alaves")) {
                Intent elche = new Intent(this, Alaves2023_24Activity.class);
                startActivity(elche);
            } else if (nome.equals("Almería")) {
                Intent almeria = new Intent(this, Almeria2023_24Activity.class);
                startActivity(almeria);
            } else if (nome.equals("Barcelona")) {
                Intent barcelona = new Intent(this, Barcelona2023_24Activity.class);
                startActivity(barcelona);
            } else if (nome.equals("Real Madrid")) {
                Intent realMadrid = new Intent(this, RealMadrid2023_24Activity.class);
                startActivity(realMadrid);
            } else if (nome.equals("Atlético de Madrid")) {
                Intent atleticoMadrid = new Intent(this, AtleticoMadrid2023_24Activity.class);
                startActivity(atleticoMadrid);
            } else if (nome.equals("Girona")) {
                Intent girona = new Intent(this, Girona2023_24Activity.class);
                startActivity(girona);
            } else if (nome.equals("Athletic Bilbao")) {
                Intent athleticBilbao = new Intent(this, AthleticBilbao2023_24Activity.class);
                startActivity(athleticBilbao);
            }else if (nome.equals("Cádiz")) {
                Intent cadiz = new Intent(this, Cadiz2023_24Activity.class);
                startActivity(cadiz);

            }else if (nome.equals("Celta de Vigo")) {
                Intent celtaVigo = new Intent(this, CeltaVigo2023_24Activity.class);
                startActivity(celtaVigo);

            }else if (nome.equals("Getafe")) {
                Intent getafe = new Intent(this, Getafe2023_24Activity.class);
                startActivity(getafe);

            }else if (nome.equals("Granada")) {
                Intent espanyol = new Intent(this, Granada2023_24Activity.class);
                startActivity(espanyol);

            }else if (nome.equals("Las Palmas")) {
                Intent realValladolid = new Intent(this, LasPalmas2023_24Activity.class);
                startActivity(realValladolid);

            }else if (nome.equals("Mallorca")) {
                Intent mallorca = new Intent(this, Mallorca2023_24Activity.class);
                startActivity(mallorca);

            }else if (nome.equals("Osasuna")) {
                Intent osasuna = new Intent(this, Osasuna2023_24Activity.class);
                startActivity(osasuna);

            }else if (nome.equals("Rayo Vallecano")) {
                Intent rayoVallecano = new Intent(this, RayoVallecano2023_24Activity.class);
                startActivity(rayoVallecano);

            }else if (nome.equals("Real Betis")) {
                Intent realBetis = new Intent(this, RealBetis2023_24Activity.class);
                startActivity(realBetis);

            }else if (nome.equals("Real Sociedad")) {
                Intent realSociedad = new Intent(this, RealSociedad2023_24Activity.class);
                startActivity(realSociedad);

            }else if (nome.equals("Sevilla")) {
                Intent sevilla = new Intent(this, Sevilla2023_24Activity.class);
                startActivity(sevilla);

            }else if (nome.equals("Valencia")) {
                Intent valencica = new Intent(this, Valencia2023_24Activity.class);
                startActivity(valencica);

            }else if (nome.equals("Villarreal")) {
                Intent villarreal = new Intent(this, Villarreal2023_24Activity.class);
                startActivity(villarreal);

            }
        }



    }

    @Override
    public void listaAlemanhaMetodo(String nome) {

        opcao = nome;
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);

        } else {
            if (nome.equals("Bayer Leverkusen")) {
                Intent bayerLeverkusen = new Intent(this, BayerLeverkusen2023_24Activity.class);
                startActivity(bayerLeverkusen);
            }else if(nome.equals("Bayern de Munique")){
                Intent bayernMunique = new Intent(this, BayernMunique2023_24Activity.class);
                startActivity(bayernMunique);
            }else if(nome.equals("Borussia Dortmund")){
                Intent borussiaDortmund = new Intent(this, BorussiaDortmund2023_24Activity.class);
                startActivity(borussiaDortmund);
            }else if(nome.equals("RB Leipzig")){
                Intent leipzig = new Intent(this, Leipzig2023_24Activity.class);
                startActivity(leipzig);
            }else if(nome.equals("Union Berlin")){
                Intent unionBerlin = new Intent(this, UnionBerlin2023_24Activity.class);
                startActivity(unionBerlin);
            }else if(nome.equals("Stuttgart")){
                Intent stuttgart = new Intent(this, Stuttgart2023_24Activity.class);
                startActivity(stuttgart);
            }else if(nome.equals("Werder Bremen")){
                Intent werderBremen = new Intent(this, WerderBremen2023_24Activity.class);
                startActivity(werderBremen);
            }else if(nome.equals("Augsburg")){
                Intent augsburg = new Intent(this, Augsburg2023_24Activity.class);
                startActivity(augsburg);

            }else if(nome.equals("Bochum")){
                Intent bochum = new Intent(this, Bochum2023_24Activity.class);
                startActivity(bochum);

            }else if(nome.equals("Borussia Mönchengladbach")){
                Intent borussiaMonchengladbach = new Intent(this, BorussiaMonche2023_24Activity.class);
                startActivity(borussiaMonchengladbach);

            }else if(nome.equals("Köln(Colônia)")){
                Intent koln = new Intent(this, Koln2023_24Activity.class);
                startActivity(koln);

            }else if(nome.equals("Darmstadt98")){
                Intent darmstadt98 = new Intent(this, Darmstadt2023_24Activity.class);
                startActivity(darmstadt98);

            }else if(nome.equals("Eintracht Frankfurt")){
                Intent frankfurt = new Intent(this, EintrachtFrankfurt2023_24Activity.class);
                startActivity(frankfurt);

            }else if(nome.equals("Freiburg")){
                Intent freiburg = new Intent(this, Freiburg2023_24Activity.class);
                startActivity(freiburg);

            }else if(nome.equals("Heidenheim")){
                Intent heidenheim = new Intent(this, Heidenheim2023_24Activity.class);
                startActivity(heidenheim);

            }else if(nome.equals("Hoffenheim")){
                Intent hoffenheim = new Intent(this, Hoffenheim2023_24Activity.class);
                startActivity(hoffenheim);

            }else if(nome.equals("Mainz 05")){
                Intent mainz05 = new Intent(this, Mainz2023_24Activity.class);
                startActivity(mainz05);

            }else if(nome.equals("Wolfsburg")){
                Intent wolfburg = new Intent(this, Wolfsburg2023_24Activity.class);
                startActivity(wolfburg);

            }
        }





    }

    @Override
    public void listaItalianoMetodo(String nome) {
        opcao = nome;
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);

        }else{
            if (nome.equals("Inter Milan")) {
                Intent inter = new Intent(this, InterMilao2023_24Activity.class);
                startActivity(inter);
            }else if(nome.equals("Milan")){
                Intent milan = new Intent(this, AcMilan2023_24Activity.class);
                startActivity(milan);
            }else if(nome.equals("Juventus")){
                Intent juventus = new Intent(this, Juventus2023_24Activity.class);
                startActivity(juventus);
            }else if(nome.equals("Atalanta")){
                Intent atalanta = new Intent(this, Atalanta2023_24Activity.class);
                startActivity(atalanta);
            }else if(nome.equals("Napoli")){
                Intent napoli = new Intent(this, Napoli2023_24Activity.class);
                startActivity(napoli);
            }else if(nome.equals("Roma")){
                Intent roma = new Intent(this, Roma2023_24Activity.class);
                startActivity(roma);
            }else if(nome.equals("Lazio")){
                Intent lazio = new Intent(this, Lazio2023_24Activity.class);
                startActivity(lazio);
            }else if(nome.equals("Fiorentina")){
                Intent fiorentina = new Intent(this, Fiorentina2023_24Activity.class);
                startActivity(fiorentina);
            }else if(nome.equals("Bologna")){
                Intent bologna = new Intent(this, Bologna2023_24Activity.class);
                startActivity(bologna);

            }else if(nome.equals("Cagliari")){
                Intent cagliari = new Intent(this, Cagliari2023_24Activity.class);
                startActivity(cagliari);

            }else if(nome.equals("Empoli")){
                Intent empoli = new Intent(this, Empoli2023_24Activity.class);
                startActivity(empoli);

            }else if(nome.equals("Frosinone")){
                Intent frosinone = new Intent(this, Frosinone2023_24Activity.class);
                startActivity(frosinone);

            }else if(nome.equals("Genoa")){
                Intent genoa = new Intent(this, Genoa2023_24Activity.class);
                startActivity(genoa);

            }else if(nome.equals("Hellas Verona")){
                Intent verona = new Intent(this, HellasVerona2023_24Activity.class);
                startActivity(verona);

            }else if(nome.equals("Lecce")){
                Intent lecce = new Intent(this, Lecce2023_24Activity.class);
                startActivity(lecce);

            }else if(nome.equals("Monza")){
                Intent monza = new Intent(this, Monza2023_24Activity.class);
                startActivity(monza);

            }else if(nome.equals("Salernitana")){
                Intent salernitana = new Intent(this, Salernitana2023_24Activity.class);
                startActivity(salernitana);

            }else if(nome.equals("Sassuolo")){
                Intent sassuolo = new Intent(this, Sassuolo2023_24Activity.class);
                startActivity(sassuolo);

            }else if(nome.equals("Torino")){
                Intent torino = new Intent(this, Torino2023_24Activity.class);
                startActivity(torino);

            }else if(nome.equals("Udinese")){
                Intent udinese = new Intent(this, Udinese2023_24Activity.class);
                startActivity(udinese);

            }


        }

    }

    @Override
    public void listaFrancesMetodo(String nome) {

        opcao = nome;
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        }else {
            if (nome.equals("Brest")) {
                Intent brest = new Intent(this, Brest2023_24Activity.class);
                startActivity(brest);
            }else if(nome.equals("Clermont")){
                Intent clermont = new Intent(this, Clermont2023_24Activity.class);
                startActivity(clermont);
            }else if(nome.equals("Le Havre")){
                Intent leHavre = new Intent(this, LeHavre2023_24Activity.class);
                startActivity(leHavre);

            }else if(nome.equals("Lens")){
                Intent lens = new Intent(this, Lens2023_24Activity.class);
                startActivity(lens);

            }else if(nome.equals("Lille")){
                Intent lille = new Intent(this, Lille2023_24Activity.class);
                startActivity(lille);

            }else if(nome.equals("Lorient")){
                Intent lorient = new Intent(this, Lorient2023_24Activity.class);
                startActivity(lorient);

            }else if(nome.equals("Lyon")){
                Intent lyon = new Intent(this, Lyon2023_24Activity.class);
                startActivity(lyon);

            }else if(nome.equals("Marseille")){
                Intent marseille = new Intent(this, Marseille2023_24Activity.class);
                startActivity(marseille);

            }else if(nome.equals("Metz")){
                Intent metz = new Intent(this, Metz2023_24Activity.class);
                startActivity(metz);

            }else if(nome.equals("Monaco")){
                Intent monaco = new Intent(this, Monaco2023_24Activity.class);
                startActivity(monaco);

            }else if(nome.equals("Montpellier")){
                Intent montpellier = new Intent(this, Montpellier2023_24Activity.class);
                startActivity(montpellier);

            }else if(nome.equals("Nantes")){
                Intent nantes = new Intent(this, Nantes2023_24Activity.class);
                startActivity(nantes);

            }else if(nome.equals("Nice")){
                Intent nice = new Intent(this, OgcNice2023_24Activity.class);
                startActivity(nice);

            }else if(nome.equals("PSG")){
                Intent psg = new Intent(this, Psg2023_24Activity.class);
                startActivity(psg);

            }else if(nome.equals("Reims")){
                Intent reims = new Intent(this, Reims2023_24Activity.class);
                startActivity(reims);

            }else if(nome.equals("Rennes")){
                Intent rennes = new Intent(this, Rennes2023_24Activity.class);
                startActivity(rennes);

            }else if(nome.equals("Strasbourg")){
                Intent strasbourg = new Intent(this, Strasbourg2023_24Activity.class);
                startActivity(strasbourg);

            }else if(nome.equals("Toulouse")){
                Intent toulouse = new Intent(this, Toulouse2023_24Activity.class);
                startActivity(toulouse);

            }


        }//fim do else
    }


    @Override
    public void listaBrasilAMetodo(String nome) {

        opcao = nome;
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        } else {
            if (nome.equals("Atlético-PR")) {
                Intent intent = new Intent(this, AtleticoPR2024Activity.class);
                startActivity(intent);
            } else if (nome.equals("Atlético-GO")) {
                Intent intent = new Intent(this, AtleticoGO2024Activity.class);
                startActivity(intent);
            } else if (nome.equals("Atlético-MG")) {
                Intent intent = new Intent(this, AtleticoMG2024Activity.class);
                startActivity(intent);
            } else if (nome.equals("Bahia")) {
                Intent intent = new Intent(this, Bahia2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Botafogo")) {
                Intent intent = new Intent(this, Botafogo2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Bragantino")) {
                Intent intent = new Intent(this, Bragantino2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Corinthians")) {
                Intent intent = new Intent(this, Corinthians2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Criciúma")) {
                Intent intent = new Intent(this, Criciuma2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Cruzeiro")) {
                Intent intent = new Intent(this, Cruzeiro2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Cuiabá")) {
                Intent intent = new Intent(this, Cuiaba2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Flamengo")) {
                Intent intent = new Intent(this, Flamengo2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Fluminense")) {
                Intent intent = new Intent(this, Fluminense2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Fortaleza")) {
                Intent intent = new Intent(this, Fortaleza2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Grêmio")) {
                Intent intent = new Intent(this, Gremio2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Internacional")) {
                Intent intent = new Intent(this, Internacional2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Juventude")) {
                Intent intent = new Intent(this, Juventude2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Palmeiras")) {
                Intent intent = new Intent(this, Palmeiras2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("São-Paulo")) {
                Intent intent = new Intent(this, SaoPaulo2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Vasco")) {
                Intent intent = new Intent(this, Vasco2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Vitória")) {
                Intent intent = new Intent(this, Vitoria2024Activity.class);
                startActivity(intent);
            }


        }//fim do else

    }

    @Override
    public void listaBrasilBMetodo(String nome) {

        opcao = nome;
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        } else {
            if (nome.equals("Amazonas")) {
                Intent intent = new Intent(this, Amazonas2024Activity.class);
                startActivity(intent);
            } else if (nome.equals("América-MG")) {
                Intent intent = new Intent(this, AmericaMG2024Activity.class);
                startActivity(intent);
            } else if (nome.equals("Avaí")) {
                Intent intent = new Intent(this, Avai2024Activity.class);
                startActivity(intent);
            } else if (nome.equals("Botafogo-SP")) {
                Intent intent = new Intent(this, BotafogoSP2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Brusque")) {
                Intent intent = new Intent(this, Brusque2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("CRB")) {
                Intent intent = new Intent(this, Crb2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Ceará")) {
                Intent intent = new Intent(this, Ceara2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Chapecoense")) {
                Intent intent = new Intent(this, Chapecoense2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Coritiba")) {
                Intent intent = new Intent(this, Coritiba2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Goiás")) {
                Intent intent = new Intent(this, Goias2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Guarani")) {
                Intent intent = new Intent(this, Guarani2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Ituano")) {
                Intent intent = new Intent(this, Ituano2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Mirassol")) {
                Intent intent = new Intent(this, Mirassol2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Novorizontino")) {
                Intent intent = new Intent(this, Novorizontino2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Operário")) {
                Intent intent = new Intent(this, Operario2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Paysandu")) {
                Intent intent = new Intent(this, Paysandu2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Ponte Preta")) {
                Intent intent = new Intent(this, PontePreta2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Santos")) {
                Intent intent = new Intent(this, Santos2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Sport")) {
                Intent intent = new Intent(this, Sport2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Vila Nova")) {
                Intent intent = new Intent(this, VilaNova2024Activity.class);
                startActivity(intent);
            }


        }//fim do else

    }
}//Fim do MainActivity







/*

            public void exibirBannerAppOdeal(){

        //iniciar o banner
        Appodeal.setTesting(true);//quando queremos testar//retirar esse codigo ao publicar app
        //alguma duvida ã mais ? só esse código que apago né?sim ta certo
        Appodeal.setBannerViewId(R.id.bannerViewAppOdealMainActivity);

        //exibi o banner /// esta   Appodeal.BANNER_VIEW
        Appodeal.show(this, Appodeal.BANNER_VIEW);
    }

         */


                /*
        Appodeal.initialize(this, keyAppOdealBanner, Appodeal.BANNER, new ApdInitializationCallback() {
            @Override
            public void onInitializationFinished(List<ApdInitializationError> list) {
                //quando coloco o this la em cima esse metodo é chamado para falar qual foi o erro
                //Esse erro é referente a AppOdeal com o banner

            }
        });

        Appodeal.initialize(view.getContext(), keyAppOdealBanner, Appodeal.INTERSTITIAL, new ApdInitializationCallback() {
            @Override
            public void onInitializationFinished(List<ApdInitializationError> list) {
                //se a AppOdeal nao consegir enviar um Intersticial irá cair aqui dentro de metodo
                //mesma coisa do banner
                //entendeu ? tudo do mesmo jeito do banner, os métodos e o callback? isso
                //unica diferenca : Appodeal.INTERSTITIAL
                //ok ? a diferença é so essa, o Nome Interstitial? isso
                //ok? sim, qual o momento q vai aparecer um interticial, pois aqui é onde fica a lista de times de um dois campeonatos, que
                // no caso é primerio ?

            }
        });


        exibirBannerAppOdeal();
        listenerBannerAppOdeal();//metyodo para sabermos se o banner foi clicado, se foi exibido,,
        listenerIntersticialAppOdeal();//metyodo para sabermos se o intersticial foi clicado, se foi exibido,


         */


//testa agora
//exibiu ?sim
//ok o almeria nao, so alaves
//é que precisamos fazer o tratamento igual abaixo
//temos que fazer um if else
//pois se o intersticial ainda não foi carregado vai para tela de detalhes
//pois o interstiial pode estar carregando na hora que voce clicou no time,, tenta de novo clicar nele
//estou tentando aqui e não consigo, vou fechar e abrir //pera ai esqueci de um codigo

        /*
        if (Appodeal.isLoaded(Appodeal.INTERSTITIAL)) {//cai no if se a AppOdeal ja envio o intersticial para aplicativo
            opcao = nome;
            Appodeal.show(this, Appodeal.INTERSTITIAL);

        }
        else{
            //cai no else se AppOdeal ainda naoi enviou Intersticial para Aplicativo. Exemplo: Internet do usuario esta ruim ou usuario esta sem internet

            //entendeu esse codigo abaixo tambem ? sim,

            if(nome.equals("Alaves")){
                Intent elche = new Intent(this, Alaves2023_24Activity.class);
                startActivity(elche);
            }
            else if(nome.equals("Almería")){
                Intent almeria = new Intent(this, Almeria2023_24Activity.class);
                startActivity(almeria);
            }

            //entendeu ?sim
            //vai usar o mesmo intersticial para todos os fragments
            //se o usuario ficar clicando de fragment em fragment, nao vai interferir no intersticia
            //pois quem esta controlando ele é a activity
            //entendeu ?sim, mas facil em um só lugar
            //dessa forma voce vai ter  exemplo:   100 solicitacoes  e 50 impressoes.. pois o mesmo intersticial nao esta sendo chamado varias vezes
            //faz um teste agora nas duas lista com o alaves a almeria tambem
            //ele abriu o intertiscial,mas não abriu a tela de detalhes, depois que feche ele

        }
        */


/*

   //iniciar o banner
       Appodeal.setTesting(true);//quando queremos testar//retirar esse codigo ao publicar app
        //alguma duvida ã mais ? só esse código que apago né?sim ta certo
        Appodeal.setBannerViewId(R.id.bannerViewAppOdealMainActivity);

        //exibi o banner /// esta   Appodeal.BANNER_VIEW
        Appodeal.show(this, Appodeal.BANNER_VIEW);

        listenerBannerAppOdeal();//metyodo para sabermos se o banner foi clicado, se foi exibido,,
        listenerIntersticialAppOdeal();//metyodo para sabermos se o intersticial foi clicado, se foi exibido,

        //o codigo que é chamado quando clico em cima do time para ver mais detalhes//
        //onde fica esse código?

        //me avisa se deu certo. deu certo
        //ok .. agora vou deixar voce implementar nos outros fragments e dai voce escolher se quer colcoar somente em alguns times
        //ou todos

        //qualquer duvida me avisa
        //dessa forma ja posso publicar o app? sim tanto é que dessa forma voce ja vai comecar a monetizar
        //nao vamos fazer controle de quantos intersticial o usuario vai ver.. pois o mesmo pode ver varios..
        //depois fazemos um controle ok
        //para publciar tire a perte que fala de teste


        //Appodeal.initialize(this, "keyAppOdeal", Appodeal.BANNER);//é a memsa coisa ali de cima mas dessa forma nao temos um feecbadk se deu erro ou nao
        //entendeu ? sim

 */


/*
    ///kkk coloquei no codigo do AppOdeal
    private void listenerIntersticialAppOdeal(){//nao estamos utilizando o metodo kkkk


        //o interstifcial nao pode ser exibido de qualquer jeito se nao temos problemas
        //vou dar um exemplo
        Appodeal.setInterstitialCallbacks(new InterstitialCallbacks() {
            @Override
            public void onInterstitialLoaded(boolean isPrecache) {
                // Called when interstitial is loaded
                //aqui é quando o intersticial é aberto
            }
            @Override
            public void onInterstitialFailedToLoad() {
                // Called when interstitial failed to load
                //falha/// é só traduzir no proprio Google que ele te fala   ok?tranquilo essa parte
            }
            @Override
            public void onInterstitialShown() {
                // Called when interstitial is shown
            }
            @Override
            public void onInterstitialShowFailed() {
                //voce tambe, pode colocar aqui, pois se o intersticial falhar por algum motivo tambem vai ir para proxima tela
                //eu nao coloquei em meus apps, mas caso precise pode adicionar aqui tmabem ok>?entendido
                //quaklquer coisa me avise. ok muito show, deu pra absolver varias coisas, apesar da cabeçãa não está boa. tranquilo
                //dai vamos aos poucos melhorando, podemos colocar esse mesmo intersticial para ser exibido quando o usuario entra no app, depois exibir ele tambem
                //na hora que ele clica no time, ou a cada 2, 3 clikes é exibido o intersticial e por ai vai.show, vai da certo!!!
            }
            @Override
            public void onInterstitialClicked() {
                // Called when interstitial is clicked
            }
            @Override
            public void onInterstitialClosed() {

                //depois que o intersticial foi exibido,, precisamo chamar o código para pedir mais um intersticial


                //esta vendo todo esse codigo aqui abaixo ?sim
                if(opcao.equals("Arsenal")){
                    Intent arsenal = new Intent(getBaseContext(), Arsenal2023_24Activity.class);
                    startActivity(arsenal);
                }
                //entendeu? aqui não entendi, qual vai aparecer?
                //estamos usando a variavel opcao
                else if (opcao.equals("Aston")){
                    Intent astonvilla = new Intent(getBaseContext(), AstonVilla2023_24Activity.class);
                    startActivity(astonvilla);
                }
                else if(opcao.equals("Bournemouth")){
                    Intent bournemouth = new Intent(getBaseContext(), Bournemouth2023_24Activity.class);
                    startActivity(bournemouth);
                }

               else if(opcao.equals("Alaves")){
                    Intent elche = new Intent(getBaseContext(), Alaves2023_24Activity.class);
                    startActivity(elche);
                }
                else if(opcao.equals("Almería")){
                    Intent almeria = new Intent(getBaseContext(), Almeria2023_24Activity.class);
                    startActivity(almeria);
                }

                //testa de novo , sao esses dois ultimo nomes ali.. Alaves e  alemeria
                //deu certo ?quando clico ele fecha o app

            }
            @Override
            public void onInterstitialExpired() {
                // Called when interstitial is expired
            }
        });

    }//appodeal

 */

/*
        //agora todo o codigo que usamos antes vamos usar de novo
        //quando clicamos no time enviamos o nome do time
        // e dai fazemos aquele mesmo esquema de antes
        //lembra ?
        //verificamos se o intersticial foi carregado se for carregado
        //adicionamo a variavel  nome para a variavel opcao
      /*  if (Appodeal.isLoaded(Appodeal.INTERSTITIAL)) {//cai no if se a AppOdeal ja envio o intersticial para aplicativo
            opcao = nome;
            Appodeal.show(this, Appodeal.INTERSTITIAL);

        }else{//cai no else se AppOdeal ainda naoi enviou Intersticial para Aplicativo. Exemplo: Internet do usuario esta ruim ou usuario esta sem internet

            //entendeu esse codigo abaixo tambem ? sim,
            if(nome.equals("Arsenal")){
                Intent arsenal = new Intent(this, Arsenal2023_24Activity.class);
                startActivity(arsenal);
            }else if(nome.equals("Aston")){
                Intent astonvilla = new Intent(getBaseContext(), AstonVilla2023_24Activity.class);
                startActivity(astonvilla);
            }

        }

       */



/*


    public void listenerBannerAppOdeal(){

        //agora esse metodo é para detectar o banner.. Erro do banner, abriu o banner, clicou no banner
        //entendeu ? caso eu queira obter informações eu verifico onde?
        //
        Appodeal.setBannerCallbacks(new BannerCallbacks() {
            @Override
            public void onBannerLoaded(int height, boolean isPrecache) {
                // Called when banner is loaded //é só fazer a traducao dessa infromacao
                // quando o banner é exibido
            }
            @Override
            public void onBannerFailedToLoad() {
                // Called when banner failed to load
                //quando o banner falhou em abrir
            }
            @Override
            public void onBannerShown() {
                // Called when banner is shown
                //o banner foi exibido
            }
            @Override
            public void onBannerShowFailed() {
                // Called when banner show failed
                //falha ao abrir o banner
            }
            @Override
            public void onBannerClicked() {
                // Called when banner is clicked
            }
            @Override
            public void onBannerExpired() {
                // Called when banner is expired
            }
            //entendeu essa parte ? sim, referente o exemplo. quero saber quantas vezes o banner foi exibido, onde vejo? Isso não ttem necessidade de controlar
            //voce pode colocar toast para testar o banner .. Mas quando estiver publicado nao precisa de toast... Eu mesmo nao utilizo esse codigo acimam ..deixo ele no
            //app e uso apenas quando quero fazer testes. Se esta tendo falhas.
            // agora entendi, blz. // tanto que voce pode ou nao chamar esse metodo... mas sempre é bom ter, pois o dia que tiver problema, voce coloca um toast e ve a mensagem
            //entendeu. sim entendi.
        });

    }// Listener Banner da AppOdeal
 */