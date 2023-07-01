package com.jogos.dadosoficialkf228920.adapter.brasileiroA2023.goias;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.ListaJogosEstatisticaCartoesAdapterBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

public class GoiasForaA2023Adapter extends RecyclerView.Adapter<GoiasForaA2023Adapter.ViewHolder> {

    private List<Partida> goiasCasa;

    public GoiasForaA2023Adapter(List<Partida> goiasCasa) {
        this.goiasCasa = goiasCasa;
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

        Partida listaPartidaGoiasFora = goiasCasa.get(position);

//DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaGoiasFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaGoiasFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaGoiasFora.getDate());

        /* Cartoes */
        holder.binding.cartaoAmrlCs.setText(String.valueOf(listaPartidaGoiasFora.getHomeCartoes().getAmarelo()));
        holder.binding.cartaoAmrlFr.setText(String.valueOf(listaPartidaGoiasFora.getAwayCartoes().getAmarelo()));
        holder.binding.cartaoVmlCs.setText(String.valueOf(listaPartidaGoiasFora.getHomeCartoes().getVermelho()));
        holder.binding.cartaoVmlFr.setText(String.valueOf(listaPartidaGoiasFora.getAwayCartoes().getVermelho()));
        holder.binding.cartaoTotalAmrl.setText(String.valueOf(listaPartidaGoiasFora.getHomeCartoes().getAmarelo() + listaPartidaGoiasFora.getAwayCartoes().getAmarelo()));
        holder.binding.cartaoTotalVml.setText(String.valueOf(listaPartidaGoiasFora.getHomeCartoes().getVermelho() + listaPartidaGoiasFora.getAwayCartoes().getVermelho()));

        holder.binding.tvEscanteiosTotalPrimeiroTempo.setText(String.valueOf(listaPartidaGoiasFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaGoiasFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvEscanteiosTotalSegundoTempo.setText(String.valueOf(listaPartidaGoiasFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaGoiasFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        int escanteiosPrimeiroTempo = listaPartidaGoiasFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaGoiasFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo();
        int escanteiosSegundoTempo = listaPartidaGoiasFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaGoiasFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo();
        holder.binding.tvEscanteiosTotal.setText(String.valueOf(escanteiosPrimeiroTempo + escanteiosSegundoTempo));

        holder.binding.tvGolsTotalPrimeiroTempo.setText(String.valueOf(listaPartidaGoiasFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaGoiasFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvGolsTotalSegundoTempo.setText(String.valueOf(listaPartidaGoiasFora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaGoiasFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        int golsPrimeiroTempo = listaPartidaGoiasFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaGoiasFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo();
        int golsSegundtoTempo = listaPartidaGoiasFora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaGoiasFora.getAwayEstatisticaJogo().getGolsSegundoTempo();
        holder.binding.tvGolsTotal.setText(String.valueOf(golsPrimeiroTempo + golsSegundtoTempo));

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaGoiasFora.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaGoiasFora.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaGoiasFora.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaGoiasFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        holder.binding.tvCasaEscanteiosTres.setText(listaPartidaGoiasFora.getHomeTimeEscanteios().getThree());
        holder.binding.tvCasaEscanteiosCinco.setText(listaPartidaGoiasFora.getHomeTimeEscanteios().getFive());
        holder.binding.tvCasaEscanteiosSete.setText(listaPartidaGoiasFora.getHomeTimeEscanteios().getSeven());
        holder.binding.tvCasaEscanteiosNove.setText(listaPartidaGoiasFora.getHomeTimeEscanteios().getNine());

        holder.binding.tvCasaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaGoiasFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvCasaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaGoiasFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvCasaEscanteiosTotal.setText(String.valueOf(listaPartidaGoiasFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaGoiasFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvCasaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaGoiasFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvCasaGolsSegundoTempo.setText(String.valueOf(listaPartidaGoiasFora.getHomeEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvCasaGolsTotal.setText(String.valueOf(listaPartidaGoiasFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaGoiasFora.getHomeEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaGoiasFora.getHomeTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaGoiasFora.getHomeTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaGoiasFora.getHomeTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaGoiasFora.getHomeTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaGoiasFora.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaGoiasFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaGoiasFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaGoiasFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        holder.binding.tvForaEscanteiosTres.setText(listaPartidaGoiasFora.getAwayTimeEscanteios().getThree());
        holder.binding.tvForaEscanteiosCinco.setText(listaPartidaGoiasFora.getAwayTimeEscanteios().getFive());
        holder.binding.tvForaEscanteiosSete.setText(listaPartidaGoiasFora.getAwayTimeEscanteios().getSeven());
        holder.binding.tvForaEscanteiosNove.setText(listaPartidaGoiasFora.getAwayTimeEscanteios().getNine());

        holder.binding.tvForaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaGoiasFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvForaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaGoiasFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvForaEscanteiosTotal.setText(String.valueOf(listaPartidaGoiasFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaGoiasFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvForaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaGoiasFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvForaGolsSegundoTempo.setText(String.valueOf(listaPartidaGoiasFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvForaGolsTotal.setText(String.valueOf(listaPartidaGoiasFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaGoiasFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaGoiasFora.getAwayTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaGoiasFora.getAwayTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaGoiasFora.getAwayTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaGoiasFora.getAwayTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);

    }

    @Override
    public int getItemCount() {
        return goiasCasa.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{



        private ListaJogosEstatisticaCartoesAdapterBinding binding;

        public ViewHolder(ListaJogosEstatisticaCartoesAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
