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
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.ArgentinoJuniors2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.AtleticoTucuman2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Banfield2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.BarracasCentral2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Belgrano2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.BocaJuniors2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.CentralCordoba2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.DefensaJusticia2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.DeportivoRiestra2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.EstudiantesLaPrata2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Gimnasia2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.GodoyCruz2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Huracan2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Independiente2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.IndependienteRivadavia2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Instituto2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Lanus2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.NewellOldBoys2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Platense2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Racing2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.RiverPlate2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.RosarioCentral2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.SanLorenzo2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Sarmiento2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Talleres2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.Tigre2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.UnionSanteFe2024Activity;
import com.jogos.dadosoficialkf228920.activity.americadosul.argentina.VelezSarsfield2024Activity;
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
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.ListaLigaProfissional_A_2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieA2024.ListaBrasilSerieA_2024_TesteFragment;
import com.jogos.dadosoficialkf228920.fragments.brasil.serieB2024.ListaBrasilSerie_B_2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.ListaPremierLeague_A_2024_25Fragment;
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

public class MainActivity extends AppCompatActivity implements ListaInglesA2023a24Fragment.ListaInglesaInterface, ListaEspanholA2023a24Fragment.ListaEspanholaInterface, ListaAlemaoA2023a24Fragment.ListaAlemanhaInterface, ListaItaliaA2023a24Fragment.ListaItalianoInterface, ListaFrancaA2023a24Fragment.ListaFrancesInterface, ListaBrasilSerieA_2024_TesteFragment.ListaBrasilA2024Interface, ListaBrasilSerie_B_2024Fragment.ListaBrasilB2024Interface, ListaLigaProfissional_A_2024Fragment.ListaArgentinaA2024Interface {

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
        adapter.addFragment(new ListaLigaProfissional_A_2024Fragment(), "Liga Profissional 2024");
        adapter.addFragment(new ListaPremierLeague_A_2024_25Fragment(), "Premier League A ");
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

                Intent intent = null;


                if (opcao.equals("Atlético-PR")) {
                     intent = new Intent(getBaseContext(), AtleticoPR2024Activity.class);
                    startActivity(intent);
                }
                //entendeu? aqui não entendi, qual vai aparecer?
                //estamos usando a variavel opcao
                else if (opcao.equals("Atlético-GO")) {
                     intent = new Intent(getBaseContext(), AtleticoGO2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Atlético-MG")) {
                     intent = new Intent(getBaseContext(), AtleticoMG2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Bahia")) {
                     intent = new Intent(getBaseContext(), Bahia2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Botafogo")) {
                     intent = new Intent(getBaseContext(), Botafogo2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Bragantino")) {
                     intent = new Intent(getBaseContext(), Bragantino2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Corinthians")) {
                     intent = new Intent(getBaseContext(), Corinthians2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Criciúma")) {
                     intent = new Intent(getBaseContext(), Criciuma2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Cruzeiro")) {
                     intent = new Intent(getBaseContext(), Cruzeiro2024Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Cuiabá")) {
                     intent = new Intent(getBaseContext(), Cuiaba2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Flamengo")) {
                     intent = new Intent(getBaseContext(), Flamengo2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Fluminense")) {
                     intent = new Intent(getBaseContext(), Fluminense2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Fortaleza")) {
                     intent = new Intent(getBaseContext(), Fortaleza2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Grêmio")) {
                     intent = new Intent(getBaseContext(), Gremio2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Internacional")) {
                     intent = new Intent(getBaseContext(), Internacional2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Juventude")) {
                     intent = new Intent(getBaseContext(), Juventude2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Palmeiras")) {
                     intent = new Intent(getBaseContext(), Palmeiras2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("São-Paulo")) {
                     intent = new Intent(getBaseContext(), SaoPaulo2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Vasco")) {
                     intent = new Intent(getBaseContext(), Vasco2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Vitória")) {
                     intent = new Intent(getBaseContext(), Vitoria2024Activity.class);
                    startActivity(intent);

                }
                //FIM DA CHAMADA BRASILEIRO SERIE A 2024

                else if (opcao.equals("Amazonas")) {
                     intent = new Intent(getBaseContext(), Amazonas2024Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("América-MG")) {
                     intent = new Intent(getBaseContext(), AmericaMG2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Avaí")) {
                     intent = new Intent(getBaseContext(), Avai2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Botafogo-SP")) {
                     intent = new Intent(getBaseContext(), BotafogoSP2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Brusque")) {
                     intent = new Intent(getBaseContext(), Brusque2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("CRB")) {
                     intent = new Intent(getBaseContext(), Crb2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Ceará")) {
                     intent = new Intent(getBaseContext(), Ceara2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Chapecoense")) {
                     intent = new Intent(getBaseContext(), Chapecoense2024Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Coritiba")) {
                     intent = new Intent(getBaseContext(), Coritiba2024Activity.class);
                    startActivity(intent);

                } else if (opcao.equals("Goiás")) {
                     intent = new Intent(getBaseContext(), Goias2024Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Guarani")) {
                     intent = new Intent(getBaseContext(), Guarani2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Ituano")) {
                     intent = new Intent(getBaseContext(), Ituano2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Mirassol")) {
                     intent = new Intent(getBaseContext(), Mirassol2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Novorizontino")) {
                     intent = new Intent(getBaseContext(), Novorizontino2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Operário")) {
                     intent = new Intent(getBaseContext(), Operario2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Paysandu")) {
                     intent = new Intent(getBaseContext(), Paysandu2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Ponte Preta")) {
                     intent = new Intent(getBaseContext(), PontePreta2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Santos")) {
                     intent = new Intent(getBaseContext(), Santos2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Sport")) {
                     intent = new Intent(getBaseContext(), Sport2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Vila Nova")) {
                     intent = new Intent(getBaseContext(), VilaNova2024Activity.class);
                    startActivity(intent);

                }
                //FIM DA CHAMADA BRASILEIRO SERIE B 2024

                else if (opcao.equals("Argentinos Jrs")) {
                     intent = new Intent(getBaseContext(), ArgentinoJuniors2024Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Atl. Tucuman")) {
                     intent = new Intent(getBaseContext(), AtleticoTucuman2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Banfield")) {
                     intent = new Intent(getBaseContext(), Banfield2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Barracas Central")) {
                     intent = new Intent(getBaseContext(), BarracasCentral2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Belgrano")) {
                     intent = new Intent(getBaseContext(), Belgrano2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Boca Juniors")) {
                     intent = new Intent(getBaseContext(), BocaJuniors2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Central Córdoba")) {
                     intent = new Intent(getBaseContext(), CentralCordoba2024Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Def. Justicia")) {
                     intent = new Intent(getBaseContext(), DefensaJusticia2024Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Deportivo Riestra")) {
                     intent = new Intent(getBaseContext(), DeportivoRiestra2024Activity.class);
                    startActivity(intent);

                } else if (opcao.equals("Estudiantes")) {
                     intent = new Intent(getBaseContext(), EstudiantesLaPrata2024Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Gimnasia")) {
                     intent = new Intent(getBaseContext(), Gimnasia2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Godoy Cruz")) {
                     intent = new Intent(getBaseContext(), GodoyCruz2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Huracán")) {
                     intent = new Intent(getBaseContext(), Huracan2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Independiente")) {
                     intent = new Intent(getBaseContext(), Independiente2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Ind. Rivadavia")) {
                     intent = new Intent(getBaseContext(), IndependienteRivadavia2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Instituto")) {
                     intent = new Intent(getBaseContext(), Instituto2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Lanús")) {
                     intent = new Intent(getBaseContext(), Lanus2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Newell Old Boys")) {
                     intent = new Intent(getBaseContext(), NewellOldBoys2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Platense")) {
                     intent = new Intent(getBaseContext(), Platense2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Racing")) {
                     intent = new Intent(getBaseContext(), Racing2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("River Plate")) {
                     intent = new Intent(getBaseContext(), RiverPlate2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Rosario")) {
                     intent = new Intent(getBaseContext(), RosarioCentral2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("San Lorenzo")) {
                     intent = new Intent(getBaseContext(), SanLorenzo2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Sarmiento")) {
                     intent = new Intent(getBaseContext(), Sarmiento2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Talleres")) {
                     intent = new Intent(getBaseContext(), Talleres2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Tigre")) {
                     intent = new Intent(getBaseContext(), Tigre2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Union Santa Fe")) {
                     intent = new Intent(getBaseContext(), UnionSanteFe2024Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Vélez Sársfield")) {
                     intent = new Intent(getBaseContext(), VelezSarsfield2024Activity.class);
                    startActivity(intent);

                }
                //FIM DA CHAMADA ARGENTINA SERIE A 2024

                //esta vendo todo esse codigo aqui abaixo ?sim
                else if (opcao.equals("Arsenal")) {
                    intent = new Intent(getBaseContext(), Arsenal2023_24Activity.class);
                    startActivity(intent);
                }
                //entendeu? aqui não entendi, qual vai aparecer?
                //estamos usando a variavel opcao
                else if (opcao.equals("Aston")) {
                    intent  = new Intent(getBaseContext(), AstonVilla2023_24Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Bournemouth")) {
                    intent  = new Intent(getBaseContext(), Bournemouth2023_24Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Brentford")) {
                    intent  = new Intent(getBaseContext(), Brentford2023_24Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Liverpool")) {
                    intent  = new Intent(getBaseContext(), Liverpool2023_24Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Manchester City")) {
                    intent  = new Intent(getBaseContext(), ManchesterCity2023_24Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Manchester United")) {
                    intent  = new Intent(getBaseContext(), ManchesterUnited2023_24Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Tottenham")) {
                    intent  = new Intent(getBaseContext(), Tottenham2023_24Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Brighton")) {
                    intent  = new Intent(getBaseContext(), Brighton2023_24Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Burnley")) {
                    intent  = new Intent(getBaseContext(), Burnley2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Chelsea")) {
                    intent  = new Intent(getBaseContext(), Chelsea2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Crystal Palace")) {
                    intent  = new Intent(getBaseContext(), CrystalPalace2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Everton")) {
                    intent  = new Intent(getBaseContext(), Everton2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Fulham")) {
                    intent  = new Intent(getBaseContext(), Fulham2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Luton")) {
                    intent  = new Intent(getBaseContext(), Luton2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Newcastle")) {
                    intent  = new Intent(getBaseContext(), Newcastle2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Nottingham Forest")) {
                    intent  = new Intent(getBaseContext(), Nottingham2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Sheffield")) {
                    intent  = new Intent(getBaseContext(), Sheffield2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("West Ham")) {
                    intent  = new Intent(getBaseContext(), WestHam2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Wolverhampton")) {
                    intent  = new Intent(getBaseContext(), Wolves2023_24Activity.class);
                    startActivity(intent);

                }

                //Times Espanhol
                else if (opcao.equals("Alaves")) {
                    intent  = new Intent(getBaseContext(), Alaves2023_24Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Almería")) {
                    intent  = new Intent(getBaseContext(), Almeria2023_24Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Barcelona")) {
                    intent  = new Intent(getBaseContext(), Barcelona2023_24Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Real Madrid")) {
                    intent  = new Intent(getBaseContext(), RealMadrid2023_24Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Atlético de Madrid")) {
                    intent  = new Intent(getBaseContext(), AtleticoMadrid2023_24Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Girona")) {
                    intent  = new Intent(getBaseContext(), Girona2023_24Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Athletic Bilbao")) {
                    intent  = new Intent(getBaseContext(), AthleticBilbao2023_24Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Cádiz")) {
                    intent  = new Intent(getBaseContext(), Cadiz2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Celta de Vigo")) {
                    intent  = new Intent(getBaseContext(), CeltaVigo2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Getafe")) {
                    intent  = new Intent(getBaseContext(), Getafe2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Granada")) {
                    intent  = new Intent(getBaseContext(), Granada2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Las Palmas")) {
                    intent  = new Intent(getBaseContext(), LasPalmas2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Mallorca")) {
                    intent  = new Intent(getBaseContext(), Mallorca2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Osasuna")) {
                    intent  = new Intent(getBaseContext(), Osasuna2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Rayo Vallecano")) {
                    intent  = new Intent(getBaseContext(), RayoVallecano2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Real Betis")) {
                    intent  = new Intent(getBaseContext(), RealBetis2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Real Sociedad")) {
                    intent  = new Intent(getBaseContext(), RealSociedad2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Sevilla")) {
                    intent  = new Intent(getBaseContext(), Sevilla2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Valencia")) {
                    intent  = new Intent(getBaseContext(), Valencia2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Villarreal")) {
                    intent  = new Intent(getBaseContext(), Villarreal2023_24Activity.class);
                    startActivity(intent);

                }

                //Times Alemanha
                else if (opcao.equals("Bayer Leverkusen")) {
                    intent  = new Intent(getBaseContext(), BayerLeverkusen2023_24Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Bayern de Munique")) {
                    intent  = new Intent(getBaseContext(), BayernMunique2023_24Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Borussia Dortmund")) {
                    intent  = new Intent(getBaseContext(), BorussiaDortmund2023_24Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("RB Leipzig")) {
                    intent  = new Intent(getBaseContext(), Leipzig2023_24Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Union Berlin")) {
                    intent  = new Intent(getBaseContext(), UnionBerlin2023_24Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Stuttgart")) {
                    intent  = new Intent(getBaseContext(), Stuttgart2023_24Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Werder Bremen")) {
                    intent  = new Intent(getBaseContext(), WerderBremen2023_24Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Augsburg")) {
                    intent  = new Intent(getBaseContext(), Augsburg2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Bochum")) {
                    intent  = new Intent(getBaseContext(), Bochum2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Borussia Mönchengladbach")) {
                    intent  = new Intent(getBaseContext(), BorussiaMonche2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Köln(Colônia)")) {
                    intent  = new Intent(getBaseContext(), Koln2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Darmstadt98")) {
                    intent  = new Intent(getBaseContext(), Darmstadt2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Eintracht Frankfurt")) {
                    intent  = new Intent(getBaseContext(), EintrachtFrankfurt2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Freiburg")) {
                    intent  = new Intent(getBaseContext(), Freiburg2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Heidenheim")) {
                    intent  = new Intent(getBaseContext(), Heidenheim2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Hoffenheim")) {
                    intent  = new Intent(getBaseContext(), Hoffenheim2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Mainz 05")) {
                    intent  = new Intent(getBaseContext(), Mainz2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Wolfsburg")) {
                    intent  = new Intent(getBaseContext(), Wolfsburg2023_24Activity.class);
                    startActivity(intent);
                }





                //TIMES ITALIANO
                else if (opcao.equals("Inter Milan")) {
                    intent  = new Intent(getBaseContext(), InterMilao2023_24Activity.class);
                    startActivity(intent);
                } else if (opcao.equals("Milan")) {
                    intent  = new Intent(getBaseContext(), AcMilan2023_24Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Juventus")) {
                    intent  = new Intent(getBaseContext(), Juventus2023_24Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Atalanta")) {
                    intent  = new Intent(getBaseContext(), Atalanta2023_24Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Napoli")) {
                    intent  = new Intent(getBaseContext(), Napoli2023_24Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Roma")) {
                    intent  = new Intent(getBaseContext(), Roma2023_24Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Lazio")) {
                    intent  = new Intent(getBaseContext(), Lazio2023_24Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Fiorentina")) {
                    intent  = new Intent(getBaseContext(), Fiorentina2023_24Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Bologna")) {
                    intent  = new Intent(getBaseContext(), Bologna2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Cagliari")) {
                    intent  = new Intent(getBaseContext(), Cagliari2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Empoli")) {
                    intent  = new Intent(getBaseContext(), Empoli2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Genoa")) {
                    intent  = new Intent(getBaseContext(), Genoa2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Frosinone")) {
                    intent  = new Intent(getBaseContext(), Frosinone2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Hellas Verona")) {
                    intent  = new Intent(getBaseContext(), HellasVerona2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Lecce")) {
                    intent  = new Intent(getBaseContext(), Lecce2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Monza")) {
                    intent  = new Intent(getBaseContext(), Monza2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Salernitana")) {
                    intent  = new Intent(getBaseContext(), Salernitana2023_24Activity.class);
                    startActivity(intent);
                }else if (opcao.equals("Sassuolo")) {
                    intent  = new Intent(getBaseContext(), Sassuolo2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Torino")) {
                    intent  = new Intent(getBaseContext(), Torino2023_24Activity.class);
                    startActivity(intent);

                }else if (opcao.equals("Udinese")) {
                    intent  = new Intent(getBaseContext(), Udinese2023_24Activity.class);
                    startActivity(intent);

                }


                //TIMES FRACES
                else if (opcao.equals("Brest")) {
                    intent  = new Intent(getBaseContext(), Brest2023_24Activity.class);
                  startActivity(intent);
                }    else if (opcao.equals("Clermont")) {
                    intent  = new Intent(getBaseContext(), Clermont2023_24Activity.class);
                    startActivity(intent);

                }  else if (opcao.equals("Le Havre")) {
                    intent  = new Intent(getBaseContext(), LeHavre2023_24Activity.class);
                    startActivity(intent);

                }  else if (opcao.equals("Lens")) {
                    intent  = new Intent(getBaseContext(), Lens2023_24Activity.class);
                    startActivity(intent);

                }  else if (opcao.equals("Lille")) {
                    intent  = new Intent(getBaseContext(), Lille2023_24Activity.class);
                    startActivity(intent);

                }  else if (opcao.equals("Lorient")) {
                    intent  = new Intent(getBaseContext(), Lorient2023_24Activity.class);
                    startActivity(intent);

                }  else if (opcao.equals("Lyon")) {
                    intent  = new Intent(getBaseContext(), Lyon2023_24Activity.class);
                    startActivity(intent);

                }  else if (opcao.equals("Marseille")) {
                    intent  = new Intent(getBaseContext(), Marseille2023_24Activity.class);
                    startActivity(intent);

                }  else if (opcao.equals("Metz")) {
                    intent  = new Intent(getBaseContext(), Metz2023_24Activity.class);
                    startActivity(intent);

                }  else if (opcao.equals("Monaco")) {
                    intent  = new Intent(getBaseContext(), Monaco2023_24Activity.class);
                    startActivity(intent);

                }  else if (opcao.equals("Montpellier")) {
                    intent  = new Intent(getBaseContext(), Montpellier2023_24Activity.class);
                    startActivity(intent);

                }  else if (opcao.equals("Nantes")) {
                    intent  = new Intent(getBaseContext(), Nantes2023_24Activity.class);
                    startActivity(intent);

                }  else if (opcao.equals("Nice")) {
                    intent  = new Intent(getBaseContext(), OgcNice2023_24Activity.class);
                    startActivity(intent);

                }  else if (opcao.equals("PSG")) {
                    intent  = new Intent(getBaseContext(), Psg2023_24Activity.class);
                    startActivity(intent);

                }  else if (opcao.equals("Reims")) {
                    intent  = new Intent(getBaseContext(), Reims2023_24Activity.class);
                    startActivity(intent);

                }  else if (opcao.equals("Rennes")) {
                    intent  = new Intent(getBaseContext(), Rennes2023_24Activity.class);
                    startActivity(intent);

                }  else if (opcao.equals("Strasbourg")) {
                    intent  = new Intent(getBaseContext(), Strasbourg2023_24Activity.class);
                    startActivity(intent);

                }  else if (opcao.equals("Toulouse")) {
                    intent  = new Intent(getBaseContext(), Toulouse2023_24Activity.class);
                    startActivity(intent);

                }

                if (intent != null) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
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

            Intent intent = null;

            if (nome.equals("Arsenal")) {
                intent = new Intent(this, Arsenal2023_24Activity.class);
                startActivity(intent);
            } else if (nome.equals("Aston")) {
                intent = new Intent(this, AstonVilla2023_24Activity.class);
                startActivity(intent);
            } else if (nome.equals("Bournemouth")) {
                intent = new Intent(this, Bournemouth2023_24Activity.class);
                startActivity(intent);
            } else if (nome.equals("Brentford")) {
                intent = new Intent(this, Brentford2023_24Activity.class);
                startActivity(intent);
            } else if (nome.equals("Liverpool")) {
                intent = new Intent(this, Liverpool2023_24Activity.class);
                startActivity(intent);
            } else if (nome.equals("Manchester City")) {
                intent = new Intent(this, ManchesterCity2023_24Activity.class);
                startActivity(intent);
            } else if (nome.equals("Manchester United")) {
                intent = new Intent(this, ManchesterUnited2023_24Activity.class);
                startActivity(intent);
            } else if (nome.equals("Tottenham")) {
                intent = new Intent(this, Tottenham2023_24Activity.class);
                startActivity(intent);
            }else if (nome.equals("Brighton")) {
                intent = new Intent(this, Brighton2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Burnley")) {
                intent = new Intent(this, Burnley2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Chelsea")) {
                intent = new Intent(this, Chelsea2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Crystal Palace")) {
                intent = new Intent(this, CrystalPalace2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Everton")) {
                intent = new Intent(this, Everton2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Fulham")) {
                intent = new Intent(this, Fulham2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Luton")) {
                intent = new Intent(this, Luton2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Newcastle")) {
                intent = new Intent(this, Newcastle2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Nottingham Forest")) {
                intent = new Intent(this, Nottingham2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Sheffield")) {
                intent = new Intent(this, Sheffield2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("West Ham")) {
                intent = new Intent(this, WestHam2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Wolverhampton")) {
                intent = new Intent(this, Wolves2023_24Activity.class);
                startActivity(intent);

            }

            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
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

            Intent intent = null;

            if (nome.equals("Alaves")) {
                intent = new Intent(this, Alaves2023_24Activity.class);
                startActivity(intent);
            } else if (nome.equals("Almería")) {
                intent = new Intent(this, Almeria2023_24Activity.class);
                startActivity(intent);
            } else if (nome.equals("Barcelona")) {
                intent = new Intent(this, Barcelona2023_24Activity.class);
                startActivity(intent);
            } else if (nome.equals("Real Madrid")) {
                intent = new Intent(this, RealMadrid2023_24Activity.class);
                startActivity(intent);
            } else if (nome.equals("Atlético de Madrid")) {
                intent = new Intent(this, AtleticoMadrid2023_24Activity.class);
                startActivity(intent);
            } else if (nome.equals("Girona")) {
                intent = new Intent(this, Girona2023_24Activity.class);
                startActivity(intent);
            } else if (nome.equals("Athletic Bilbao")) {
                intent = new Intent(this, AthleticBilbao2023_24Activity.class);
                startActivity(intent);
            }else if (nome.equals("Cádiz")) {
                intent = new Intent(this, Cadiz2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Celta de Vigo")) {
                intent = new Intent(this, CeltaVigo2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Getafe")) {
                intent = new Intent(this, Getafe2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Granada")) {
                intent = new Intent(this, Granada2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Las Palmas")) {
                intent = new Intent(this, LasPalmas2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Mallorca")) {
                intent = new Intent(this, Mallorca2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Osasuna")) {
                intent = new Intent(this, Osasuna2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Rayo Vallecano")) {
                intent = new Intent(this, RayoVallecano2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Real Betis")) {
                intent = new Intent(this, RealBetis2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Real Sociedad")) {
                intent = new Intent(this, RealSociedad2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Sevilla")) {
                intent = new Intent(this, Sevilla2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Valencia")) {
                intent = new Intent(this, Valencia2023_24Activity.class);
                startActivity(intent);

            }else if (nome.equals("Villarreal")) {
                intent = new Intent(this, Villarreal2023_24Activity.class);
                startActivity(intent);

            }

            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

        }



    }

    @Override
    public void listaAlemanhaMetodo(String nome) {

        opcao = nome;
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);

        } else {

            Intent intent = null;

            if (nome.equals("Bayer Leverkusen")) {
                intent = new Intent(this, BayerLeverkusen2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("Bayern de Munique")){
                intent = new Intent(this, BayernMunique2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("Borussia Dortmund")){
                intent = new Intent(this, BorussiaDortmund2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("RB Leipzig")){
                intent = new Intent(this, Leipzig2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("Union Berlin")){
                intent = new Intent(this, UnionBerlin2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("Stuttgart")){
                intent = new Intent(this, Stuttgart2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("Werder Bremen")){
                intent = new Intent(this, WerderBremen2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("Augsburg")){
                intent = new Intent(this, Augsburg2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Bochum")){
                intent = new Intent(this, Bochum2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Borussia Mönchengladbach")){
                intent = new Intent(this, BorussiaMonche2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Köln(Colônia)")){
                intent = new Intent(this, Koln2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Darmstadt98")){
                intent = new Intent(this, Darmstadt2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Eintracht Frankfurt")){
                intent = new Intent(this, EintrachtFrankfurt2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Freiburg")){
                intent = new Intent(this, Freiburg2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Heidenheim")){
                intent = new Intent(this, Heidenheim2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Hoffenheim")){
                intent = new Intent(this, Hoffenheim2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Mainz 05")){
                intent = new Intent(this, Mainz2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Wolfsburg")){
                intent = new Intent(this, Wolfsburg2023_24Activity.class);
                startActivity(intent);

            }

            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }





    }

    @Override
    public void listaItalianoMetodo(String nome) {
        opcao = nome;
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);

        }else{

            Intent intent = null;

            if (nome.equals("Inter Milan")) {
                intent = new Intent(this, InterMilao2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("Milan")){
                intent = new Intent(this, AcMilan2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("Juventus")){
                intent = new Intent(this, Juventus2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("Atalanta")){
                intent = new Intent(this, Atalanta2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("Napoli")){
                intent = new Intent(this, Napoli2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("Roma")){
                intent = new Intent(this, Roma2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("Lazio")){
                intent = new Intent(this, Lazio2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("Fiorentina")){
                intent = new Intent(this, Fiorentina2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("Bologna")){
                intent = new Intent(this, Bologna2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Cagliari")){
                intent = new Intent(this, Cagliari2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Empoli")){
                intent = new Intent(this, Empoli2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Frosinone")){
                intent = new Intent(this, Frosinone2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Genoa")){
                intent = new Intent(this, Genoa2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Hellas Verona")){
                intent = new Intent(this, HellasVerona2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Lecce")){
                intent = new Intent(this, Lecce2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Monza")){
                intent = new Intent(this, Monza2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Salernitana")){
                intent = new Intent(this, Salernitana2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Sassuolo")){
                intent = new Intent(this, Sassuolo2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Torino")){
                intent = new Intent(this, Torino2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Udinese")){
                intent = new Intent(this, Udinese2023_24Activity.class);
                startActivity(intent);

            }

            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

        }

    }

    @Override
    public void listaFrancesMetodo(String nome) {

        opcao = nome;
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        }else {

            Intent intent = null;

            if (nome.equals("Brest")) {
                intent = new Intent(this, Brest2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("Clermont")){
                intent = new Intent(this, Clermont2023_24Activity.class);
                startActivity(intent);
            }else if(nome.equals("Le Havre")){
                intent = new Intent(this, LeHavre2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Lens")){
                intent = new Intent(this, Lens2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Lille")){
                intent = new Intent(this, Lille2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Lorient")){
                intent = new Intent(this, Lorient2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Lyon")){
                intent = new Intent(this, Lyon2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Marseille")){
                intent = new Intent(this, Marseille2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Metz")){
                intent = new Intent(this, Metz2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Monaco")){
                intent = new Intent(this, Monaco2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Montpellier")){
                intent = new Intent(this, Montpellier2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Nantes")){
                intent = new Intent(this, Nantes2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Nice")){
                intent = new Intent(this, OgcNice2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("PSG")){
                intent = new Intent(this, Psg2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Reims")){
                intent = new Intent(this, Reims2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Rennes")){
                intent = new Intent(this, Rennes2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Strasbourg")){
                intent = new Intent(this, Strasbourg2023_24Activity.class);
                startActivity(intent);

            }else if(nome.equals("Toulouse")){
                intent = new Intent(this, Toulouse2023_24Activity.class);
                startActivity(intent);

            }

            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }


        }//fim do else
    }


    @Override
    public void listaBrasilAMetodo(String nome) {

        opcao = nome;
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        } else {

            Intent intent = null;

            if (nome.equals("Atlético-PR")) {
                 intent = new Intent(this, AtleticoPR2024Activity.class);
                startActivity(intent);
            } else if (nome.equals("Atlético-GO")) {
                 intent = new Intent(this, AtleticoGO2024Activity.class);
                startActivity(intent);
            } else if (nome.equals("Atlético-MG")) {
                 intent = new Intent(this, AtleticoMG2024Activity.class);
                startActivity(intent);
            } else if (nome.equals("Bahia")) {
                 intent = new Intent(this, Bahia2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Botafogo")) {
                 intent = new Intent(this, Botafogo2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Bragantino")) {
                 intent = new Intent(this, Bragantino2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Corinthians")) {
                 intent = new Intent(this, Corinthians2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Criciúma")) {
                 intent = new Intent(this, Criciuma2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Cruzeiro")) {
                 intent = new Intent(this, Cruzeiro2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Cuiabá")) {
                 intent = new Intent(this, Cuiaba2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Flamengo")) {
                 intent = new Intent(this, Flamengo2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Fluminense")) {
                 intent = new Intent(this, Fluminense2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Fortaleza")) {
                 intent = new Intent(this, Fortaleza2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Grêmio")) {
                 intent = new Intent(this, Gremio2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Internacional")) {
                 intent = new Intent(this, Internacional2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Juventude")) {
                 intent = new Intent(this, Juventude2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Palmeiras")) {
                 intent = new Intent(this, Palmeiras2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("São-Paulo")) {
                 intent = new Intent(this, SaoPaulo2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Vasco")) {
                 intent = new Intent(this, Vasco2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Vitória")) {
                 intent = new Intent(this, Vitoria2024Activity.class);
                startActivity(intent);
            }

            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
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
            Intent intent = null;

            if (nome.equals("Amazonas")) {
                 intent = new Intent(this, Amazonas2024Activity.class);
                startActivity(intent);
            } else if (nome.equals("América-MG")) {
                 intent = new Intent(this, AmericaMG2024Activity.class);
                startActivity(intent);
            } else if (nome.equals("Avaí")) {
                 intent = new Intent(this, Avai2024Activity.class);
                startActivity(intent);
            } else if (nome.equals("Botafogo-SP")) {
                 intent = new Intent(this, BotafogoSP2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Brusque")) {
                 intent = new Intent(this, Brusque2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("CRB")) {
                 intent = new Intent(this, Crb2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Ceará")) {
                 intent = new Intent(this, Ceara2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Chapecoense")) {
                 intent = new Intent(this, Chapecoense2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Coritiba")) {
                 intent = new Intent(this, Coritiba2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Goiás")) {
                 intent = new Intent(this, Goias2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Guarani")) {
                 intent = new Intent(this, Guarani2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Ituano")) {
                 intent = new Intent(this, Ituano2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Mirassol")) {
                 intent = new Intent(this, Mirassol2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Novorizontino")) {
                 intent = new Intent(this, Novorizontino2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Operário")) {
                 intent = new Intent(this, Operario2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Paysandu")) {
                 intent = new Intent(this, Paysandu2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Ponte Preta")) {
                 intent = new Intent(this, PontePreta2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Santos")) {
                 intent = new Intent(this, Santos2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Sport")) {
                 intent = new Intent(this, Sport2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Vila Nova")) {
                 intent = new Intent(this, VilaNova2024Activity.class);
                startActivity(intent);
            }

            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

        }//fim do else

    }

    @Override
    public void listaArgentinaAMetodo(String nome) {

        opcao = nome;
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        } else {

            Intent intent = null;
            if (nome.equals("Argentinos Jrs")) {
                 intent = new Intent(this, ArgentinoJuniors2024Activity.class);
                startActivity(intent);
            } else if (nome.equals("Atl. Tucuman")) {
                 intent = new Intent(this, AtleticoTucuman2024Activity.class);
                startActivity(intent);
            } else if (nome.equals("Banfield")) {
                 intent = new Intent(this, Banfield2024Activity.class);
                startActivity(intent);
            } else if (nome.equals("Barracas Central")) {
                 intent = new Intent(this, BarracasCentral2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Belgrano")) {
                 intent = new Intent(this, Belgrano2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Boca Juniors")) {
                 intent = new Intent(this, BocaJuniors2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Central Córdoba")) {
                 intent = new Intent(this, CentralCordoba2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Def. Justicia")) {
                 intent = new Intent(this, DefensaJusticia2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Deportivo Riestra")) {
                 intent = new Intent(this, DeportivoRiestra2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Estudiantes")) {
                 intent = new Intent(this, EstudiantesLaPrata2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Gimnasia")) {
                 intent = new Intent(this, Gimnasia2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Godoy Cruz")) {
                 intent = new Intent(this, GodoyCruz2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Huracán")) {
                 intent = new Intent(this, Huracan2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Independiente")) {
                 intent = new Intent(this, Independiente2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Ind. Rivadavia")) {
                 intent = new Intent(this, IndependienteRivadavia2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Instituto")) {
                 intent = new Intent(this, Instituto2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Lanús")) {
                 intent = new Intent(this, Lanus2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Newell Old Boys")) {
                 intent = new Intent(this, NewellOldBoys2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Platense")) {
                 intent = new Intent(this, Platense2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Racing")) {
                 intent = new Intent(this, Racing2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("River Plate")) {
                 intent = new Intent(this, RiverPlate2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Rosario")) {
                 intent = new Intent(this, RosarioCentral2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("San Lorenzo")) {
                 intent = new Intent(this, SanLorenzo2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Sarmiento")) {
                 intent = new Intent(this, Sarmiento2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Talleres")) {
                 intent = new Intent(this, Talleres2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Tigre")) {
                 intent = new Intent(this, Tigre2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Union Santa Fe")) {
                 intent = new Intent(this, UnionSanteFe2024Activity.class);
                startActivity(intent);
            }else if (nome.equals("Vélez Sársfield")) {
                 intent = new Intent(this, VelezSarsfield2024Activity.class);
                startActivity(intent);
            }

            if (intent != null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
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