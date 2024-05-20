package com.jogos.dadosoficialkf228920.adapter.brasil2024;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf228920.databinding.ListaJogosEstatisticaCartoesBrasil2024AdapterBinding;
import com.jogos.dadosoficialkf228920.model.PartidaNovoModelo;

import java.util.List;

public class Serie_A_B_2024Adapter extends RecyclerView.Adapter<Serie_A_B_2024Adapter.ViewHolder>{

    private List<PartidaNovoModelo> lista;

    public Serie_A_B_2024Adapter(List<PartidaNovoModelo> augsburgCasa) {
        this.lista = augsburgCasa;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListaJogosEstatisticaCartoesBrasil2024AdapterBinding binding = ListaJogosEstatisticaCartoesBrasil2024AdapterBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Serie_A_B_2024Adapter.ViewHolder holder, int position) {


        Context context = holder.itemView.getContext();

        PartidaNovoModelo partida= lista.get(position);

        //DADOS DO JOGO
        holder.binding.tvDescricaco.setText(partida.getDescription());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(partida.getRound()));
        holder.binding.tvDataJogo.setText(partida.getDate());

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(partida.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(partida.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(partida.getHomeTime().getPlacar()));
        Glide.with(context).load(partida.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(partida.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(partida.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(partida.getAwayTime().getPlacar()));
        Glide.with(context).load(partida.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);


//        /* Cartoes Home */

        holder.binding.tvCartaoAmrlCsPrimeiroTempo.setText(String.valueOf(partida.getHomeCartoes().getCartaoAmareloPrimeiroTempo()));
        holder.binding.tvCartaoAmrlCsSegundoTempo.setText(String.valueOf(partida.getHomeCartoes().getCartaoAmareloSegundoTempo()));
        holder.binding.cartaoTotalAmrlCasa.setText(String.valueOf(partida.getHomeCartoes().getCartaoAmareloPrimeiroTempo() + partida.getHomeCartoes().getCartaoAmareloSegundoTempo()));


        holder.binding.tvCartaoVmlCsPrimeiroTempo.setText(String.valueOf(partida.getHomeCartoes().getCartaoVermelhoPrimeiroTempo()));
        holder.binding.tvCartaoVmlCsSegundoTempo.setText(String.valueOf(partida.getHomeCartoes().getCartaoVermelhoSegundoTempo()));
        holder.binding.tvcartaoTotalVmlCasa.setText(String.valueOf(partida.getHomeCartoes().getCartaoVermelhoPrimeiroTempo() + partida.getHomeCartoes().getCartaoVermelhoSegundoTempo()));

        /* Cartoes Away */
        holder.binding.tvCartaoAmrlFrPrimeiroTempo.setText(String.valueOf(partida.getAwayCartoes().getCartaoAmareloPrimeiroTempo()));
        holder.binding.tvCartaoAmrlFrSegundoTempo.setText(String.valueOf(partida.getAwayCartoes().getCartaoAmareloSegundoTempo()));
        holder.binding.cartaoTotalAmrlFora.setText(String.valueOf(partida.getAwayCartoes().getCartaoAmareloPrimeiroTempo() + partida.getAwayCartoes().getCartaoAmareloSegundoTempo()));

        holder.binding.tvCartaoVmlFrPrimeiroTempo.setText(String.valueOf(partida.getAwayCartoes().getCartaoVermelhoPrimeiroTempo()));
        holder.binding.tvCartaoVmlFrSegundoTempo.setText(String.valueOf(partida.getAwayCartoes().getCartaoVermelhoSegundoTempo()));
        holder.binding.tvCartaoTotalVmlFora.setText(String.valueOf(partida.getAwayCartoes().getCartaoVermelhoPrimeiroTempo() + partida.getAwayCartoes().getCartaoVermelhoSegundoTempo()));

        /* Estatística home e Away - yellow */
        holder.binding.tvCartoesAmrlTotaisPrimeiroTempo.setText(String.valueOf(partida.getHomeCartoes().getCartaoAmareloPrimeiroTempo() + partida.getAwayCartoes().getCartaoAmareloPrimeiroTempo()));
        holder.binding.tvCartoesAmrlTotaisSegundoTempo.setText(String.valueOf(partida.getHomeCartoes().getCartaoAmareloSegundoTempo() + partida.getAwayCartoes().getCartaoAmareloSegundoTempo()));
        int cartoesAmareloTotal = partida.getHomeCartoes().getCartaoAmareloPrimeiroTempo() + partida.getAwayCartoes().getCartaoAmareloPrimeiroTempo() + partida.getHomeCartoes().getCartaoAmareloSegundoTempo() + partida.getAwayCartoes().getCartaoAmareloSegundoTempo();
        holder.binding.tvCartoesAmrlTotal.setText(String.valueOf(cartoesAmareloTotal));

        /* Estatística home e Away - red */
        holder.binding.tvCartoesVmlTotaisPrimeiroTempo.setText(String.valueOf(partida.getHomeCartoes().getCartaoVermelhoPrimeiroTempo() + partida.getAwayCartoes().getCartaoVermelhoPrimeiroTempo()));
        holder.binding.tvCartoesVmlTotaisSegundoTempo.setText(String.valueOf(partida.getHomeCartoes().getCartaoVermelhoSegundoTempo() + partida.getAwayCartoes().getCartaoVermelhoSegundoTempo()));
        int cartoesVermelhoTotal = partida.getHomeCartoes().getCartaoVermelhoPrimeiroTempo() + partida.getAwayCartoes().getCartaoVermelhoPrimeiroTempo() + partida.getHomeCartoes().getCartaoVermelhoSegundoTempo() + partida.getAwayCartoes().getCartaoVermelhoSegundoTempo();
        holder.binding.tvCartoesVmlTotal.setText(String.valueOf(cartoesVermelhoTotal));

        /* Estatística home e Away - Corner */
        holder.binding.tvCasaEscanteiosPrimeiroTempo.setText(String.valueOf(partida.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvCasaEscanteiosSegundoTempo.setText(String.valueOf(partida.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvCasaEscanteiosTotal.setText(String.valueOf(partida.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + partida.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvForaEscanteiosPrimeiroTempo.setText(String.valueOf(partida.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvForaEscanteiosSegundoTempo.setText(String.valueOf(partida.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvForaEscanteiosTotal.setText(String.valueOf(partida.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + partida.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvEscanteiosTotalPrimeiroTempo.setText(String.valueOf(partida.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + partida.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvEscanteiosTotalSegundoTempo.setText(String.valueOf(partida.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + partida.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        int escanteiosPrimeiroTempo = partida.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + partida.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo();
        int escanteiosSegundoTempo = partida.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + partida.getAwayEstatisticaJogo().getEscanteioSegundoTempo();
        holder.binding.tvEscanteiosTotal.setText(String.valueOf(escanteiosPrimeiroTempo + escanteiosSegundoTempo));

        /* Estatística home e Away - Goal */
        holder.binding.tvCasaGolsPrimeiroTempo.setText(String.valueOf(partida.getHomeEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvCasaGolsSegundoTempo.setText(String.valueOf(partida.getHomeEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvCasaGolsTotal.setText(String.valueOf(partida.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + partida.getHomeEstatisticaJogo().getGolsSegundoTempo()));

        holder.binding.tvForaGolsPrimeiroTempo.setText(String.valueOf(partida.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvForaGolsSegundoTempo.setText(String.valueOf(partida.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvForaGolsTotal.setText(String.valueOf(partida.getAwayEstatisticaJogo().getGolsPrimeiroTempo() + partida.getAwayEstatisticaJogo().getGolsSegundoTempo()));

        holder.binding.tvGolsTotalPrimeiroTempo.setText(String.valueOf(partida.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + partida.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvGolsTotalSegundoTempo.setText(String.valueOf(partida.getHomeEstatisticaJogo().getGolsSegundoTempo() + partida.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        int golsPrimeiroTempo = partida.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + partida.getAwayEstatisticaJogo().getGolsPrimeiroTempo();
        int golsSegundtoTempo = partida.getHomeEstatisticaJogo().getGolsSegundoTempo() + partida.getAwayEstatisticaJogo().getGolsSegundoTempo();
        holder.binding.tvGolsTotal.setText(String.valueOf(golsPrimeiroTempo + golsSegundtoTempo));




    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ListaJogosEstatisticaCartoesBrasil2024AdapterBinding binding;

        public ViewHolder(ListaJogosEstatisticaCartoesBrasil2024AdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
