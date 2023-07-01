package com.jogos.dadosoficialkf228920.adapter.brasileiroA2023.santos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.ListaJogosEstatisticaCartoesAdapterBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

public class SantosForaA2023Adapter extends RecyclerView.Adapter<SantosForaA2023Adapter.ViewHolder> {

    private List<Partida> santosFora2022;

    public SantosForaA2023Adapter(List<Partida> santosFora2022) {
        this.santosFora2022 = santosFora2022;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListaJogosEstatisticaCartoesAdapterBinding binding = ListaJogosEstatisticaCartoesAdapterBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        Context context = holder.itemView.getContext();

        Partida listaPartidaSampaioCorreaFora = santosFora2022.get(position);

//DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaSampaioCorreaFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaSampaioCorreaFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaSampaioCorreaFora.getDate());

        /* Cartoes */
        holder.binding.cartaoAmrlCs.setText(String.valueOf(listaPartidaSampaioCorreaFora.getHomeCartoes().getAmarelo()));
        holder.binding.cartaoAmrlFr.setText(String.valueOf(listaPartidaSampaioCorreaFora.getAwayCartoes().getAmarelo()));
        holder.binding.cartaoVmlCs.setText(String.valueOf(listaPartidaSampaioCorreaFora.getHomeCartoes().getVermelho()));
        holder.binding.cartaoVmlFr.setText(String.valueOf(listaPartidaSampaioCorreaFora.getAwayCartoes().getVermelho()));
        holder.binding.cartaoTotalAmrl.setText(String.valueOf(listaPartidaSampaioCorreaFora.getHomeCartoes().getAmarelo() + listaPartidaSampaioCorreaFora.getAwayCartoes().getAmarelo()));
        holder.binding.cartaoTotalVml.setText(String.valueOf(listaPartidaSampaioCorreaFora.getHomeCartoes().getVermelho() + listaPartidaSampaioCorreaFora.getAwayCartoes().getVermelho()));

        holder.binding.tvEscanteiosTotalPrimeiroTempo.setText(String.valueOf(listaPartidaSampaioCorreaFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaSampaioCorreaFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvEscanteiosTotalSegundoTempo.setText(String.valueOf(listaPartidaSampaioCorreaFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaSampaioCorreaFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        int escanteiosPrimeiroTempo = listaPartidaSampaioCorreaFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaSampaioCorreaFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo();
        int escanteiosSegundoTempo = listaPartidaSampaioCorreaFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaSampaioCorreaFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo();
        holder.binding.tvEscanteiosTotal.setText(String.valueOf(escanteiosPrimeiroTempo + escanteiosSegundoTempo));

        holder.binding.tvGolsTotalPrimeiroTempo.setText(String.valueOf(listaPartidaSampaioCorreaFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaSampaioCorreaFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvGolsTotalSegundoTempo.setText(String.valueOf(listaPartidaSampaioCorreaFora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaSampaioCorreaFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        int golsPrimeiroTempo = listaPartidaSampaioCorreaFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaSampaioCorreaFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo();
        int golsSegundtoTempo = listaPartidaSampaioCorreaFora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaSampaioCorreaFora.getAwayEstatisticaJogo().getGolsSegundoTempo();
        holder.binding.tvGolsTotal.setText(String.valueOf(golsPrimeiroTempo + golsSegundtoTempo));

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaSampaioCorreaFora.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaSampaioCorreaFora.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaSampaioCorreaFora.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaSampaioCorreaFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        holder.binding.tvCasaEscanteiosTres.setText(listaPartidaSampaioCorreaFora.getHomeTimeEscanteios().getThree());
        holder.binding.tvCasaEscanteiosCinco.setText(listaPartidaSampaioCorreaFora.getHomeTimeEscanteios().getFive());
        holder.binding.tvCasaEscanteiosSete.setText(listaPartidaSampaioCorreaFora.getHomeTimeEscanteios().getSeven());
        holder.binding.tvCasaEscanteiosNove.setText(listaPartidaSampaioCorreaFora.getHomeTimeEscanteios().getNine());

        holder.binding.tvCasaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaSampaioCorreaFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvCasaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaSampaioCorreaFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvCasaEscanteiosTotal.setText(String.valueOf(listaPartidaSampaioCorreaFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaSampaioCorreaFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvCasaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaSampaioCorreaFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvCasaGolsSegundoTempo.setText(String.valueOf(listaPartidaSampaioCorreaFora.getHomeEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvCasaGolsTotal.setText(String.valueOf(listaPartidaSampaioCorreaFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaSampaioCorreaFora.getHomeEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaSampaioCorreaFora.getHomeTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaSampaioCorreaFora.getHomeTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaSampaioCorreaFora.getHomeTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaSampaioCorreaFora.getHomeTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaSampaioCorreaFora.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaSampaioCorreaFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaSampaioCorreaFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaSampaioCorreaFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        holder.binding.tvForaEscanteiosTres.setText(listaPartidaSampaioCorreaFora.getAwayTimeEscanteios().getThree());
        holder.binding.tvForaEscanteiosCinco.setText(listaPartidaSampaioCorreaFora.getAwayTimeEscanteios().getFive());
        holder.binding.tvForaEscanteiosSete.setText(listaPartidaSampaioCorreaFora.getAwayTimeEscanteios().getSeven());
        holder.binding.tvForaEscanteiosNove.setText(listaPartidaSampaioCorreaFora.getAwayTimeEscanteios().getNine());

        holder.binding.tvForaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaSampaioCorreaFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvForaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaSampaioCorreaFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvForaEscanteiosTotal.setText(String.valueOf(listaPartidaSampaioCorreaFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaSampaioCorreaFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvForaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaSampaioCorreaFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvForaGolsSegundoTempo.setText(String.valueOf(listaPartidaSampaioCorreaFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvForaGolsTotal.setText(String.valueOf(listaPartidaSampaioCorreaFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaSampaioCorreaFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaSampaioCorreaFora.getAwayTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaSampaioCorreaFora.getAwayTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaSampaioCorreaFora.getAwayTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaSampaioCorreaFora.getAwayTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);

    }

    @Override
    public int getItemCount() {
        return santosFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{



        private ListaJogosEstatisticaCartoesAdapterBinding binding;

        public ViewHolder(ListaJogosEstatisticaCartoesAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
