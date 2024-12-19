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
import com.jogos.dadosoficialkf228920.activity.carregarDadosActivity.CarregarDadosFragmentsActivity;
import com.jogos.dadosoficialkf228920.databinding.ActivityMainBinding;
import com.jogos.dadosoficialkf228920.fragments.americadosul.argentina.ListaLigaProfissional_A_2024Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.bundesliga.ListaBundesliga_A_2024_25Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.eredivisie.ListaEredivisie_A_2024_25Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.laLiga.ListaLaLiga_A_2024_25Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.ligue1.ListaLigue1_A_2024_25Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.premierLeague.ListaPremierLeague_A_2024_25Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.primeiraLiga.ListaPrimeiraLiga_A_2024_25Fragment;
import com.jogos.dadosoficialkf228920.fragments.europa_A_2024_25_Fragments.serieA.ListaSerie_A_2024_25Fragment;
import com.jogos.dadosoficialkf228920.model.ViewPagerAdapter;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

public class MainActivity extends AppCompatActivity implements ListaPremierLeague_A_2024_25Fragment.ListaPremierLeague2025_OnClinkInterface,
        ListaPremierLeague_A_2024_25Fragment.ListaPremierLeague2025_LongClickInterface,
        ListaBundesliga_A_2024_25Fragment.ListaBundesliga2025_OnClinkInterface, ListaBundesliga_A_2024_25Fragment.ListaBundesliga2025_LongClickInterface,
        ListaLaLiga_A_2024_25Fragment.ListaLaLiga2025_OnClinkInterface, ListaLaLiga_A_2024_25Fragment.ListaLaLiga2025_LongClickInterface,
        ListaEredivisie_A_2024_25Fragment.ListaEredivise2025_OnClinkInterface, ListaEredivisie_A_2024_25Fragment.ListaEredivise2025_LongClickInterface,
        ListaLigue1_A_2024_25Fragment.ListaLigue1_2025_OnClinkInterface, ListaLigue1_A_2024_25Fragment.ListaLigue1_2025_LongClickInterface,
        ListaPrimeiraLiga_A_2024_25Fragment.ListaPrimeiraLiga2025_OnClinkInterface, ListaPrimeiraLiga_A_2024_25Fragment.ListaPrimeiraLiga2025_LongClickInterface,
        ListaSerie_A_2024_25Fragment.ListaSerieAItalia2025_OnClinkInterface, ListaSerie_A_2024_25Fragment.ListaSerieAItalia2025_LongClickInterface{

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
        UnityAds.initialize(this, unityGameID, new IUnityAdsInitializationListener() {
            @Override
            public void onInitializationComplete() {

                Log.d("testeunity", "completo");
                //quando a comunicao acontece com sucesso.. comunicao do Aplicativo com a Unity
            }

            @Override
            public void onInitializationFailed(UnityAds.UnityAdsInitializationError error, String message) {
                //quando coloco o this la em cima esse metodo é chamado para falar qual foi o erro
                //Esse erro é referente a Unity

                Log.d("testeunity-", message);

            }
        });


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

        adapter.addFragment(new ListaPremierLeague_A_2024_25Fragment(), "Premier League A ");
        adapter.addFragment(new ListaLaLiga_A_2024_25Fragment(), "La Liga A");
        adapter.addFragment(new ListaBundesliga_A_2024_25Fragment(), "Bundesliga A");
        adapter.addFragment(new ListaSerie_A_2024_25Fragment(), "Serie A Italia");
        adapter.addFragment(new ListaPrimeiraLiga_A_2024_25Fragment(), "Primeira Liga A");
        adapter.addFragment(new ListaLigue1_A_2024_25Fragment(), "Ligue 1");
        adapter.addFragment(new ListaEredivisie_A_2024_25Fragment(), "Eredivisie A");

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
    public void listaPremierLeagueOnClick2025Metodo(String nome) {
        opcao = nome;
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        }
    }

    @Override
    public void listaPremierLeagueLongClick2025metodo() {
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        }

    }

    @Override
    public void listaLaLigaLongClick2025metodo() {
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        }
    }

    @Override
    public void listaLaLigaOnClick2025Metodo(String nome) {
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        }
    }

    @Override
    public void listaErediviseLongClick2025metodo() {
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        }
    }

    @Override
    public void listaErediviseOnClick2025Metodo(String nome) {
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        }
    }

    @Override
    public void listaLigue1_LongClick2025metodo() {
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        }
    }

    @Override
    public void listaLigue1_OnClick2025Metodo(String nome) {
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        }
    }

    @Override
    public void listaPrimeiraLigaLongClick2025metodo() {
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        }
    }

    @Override
    public void listaPrimeiraLigaOnClick2025Metodo(String nome) {
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        }
    }

    @Override
    public void listaSerieAItaliaLongClick2025metodo() {
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        }
    }

    @Override
    public void listaSerieAItaliaOnClick2025Metodo(String nome) {
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        }
    }

    @Override
    public void listaBundesligaLongClick2025metodo() {
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        }
    }

    @Override
    public void listaBundesligaOnClick2025Metodo(String nome) {
        if (intersticialUnityCarregado) {//se intersticialUnityCarregado == true cai dentro do if... intersticialUnityCarregado vai ser true se o intersticial ja foi recebido da Unity
            UnityAds.show(MainActivity.this, intersticialAdUnitId, new UnityAdsShowOptions(), showListener);
        }
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