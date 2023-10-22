package com.jogos.dadosoficialkf228920.adapter.europa2023a24.alemanha.borussiamonchengladbach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.DadosPartidasAdapterBinding;
import com.jogos.dadosoficialkf228920.databinding.ListaJogosEstatisticaCartoesAdapterBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

public class BorussiaMoncheForaAdapter extends RecyclerView.Adapter<BorussiaMoncheForaAdapter.ViewHolder> {

    private List<Partida> augsburgFora;

    public BorussiaMoncheForaAdapter(List<Partida> augsburgFora) {
        this.augsburgFora = augsburgFora;
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

        Partida listaPartidaBayerLeverkusenFora = augsburgFora.get(position);

        //DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaBayerLeverkusenFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaBayerLeverkusenFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaBayerLeverkusenFora.getDate());

        /* Cartoes */
        holder.binding.cartaoAmrlCs.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeCartoes().getAmarelo()));
        holder.binding.cartaoAmrlFr.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getAwayCartoes().getAmarelo()));
        holder.binding.cartaoVmlCs.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeCartoes().getVermelho()));
        holder.binding.cartaoVmlFr.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getAwayCartoes().getVermelho()));
        holder.binding.cartaoTotalAmrl.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeCartoes().getAmarelo() + listaPartidaBayerLeverkusenFora.getAwayCartoes().getAmarelo()));
        holder.binding.cartaoTotalVml.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeCartoes().getVermelho() + listaPartidaBayerLeverkusenFora.getAwayCartoes().getVermelho()));

        holder.binding.tvEscanteiosTotalPrimeiroTempo.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBayerLeverkusenFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvEscanteiosTotalSegundoTempo.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaBayerLeverkusenFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        int escanteiosPrimeiroTempo = listaPartidaBayerLeverkusenFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBayerLeverkusenFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo();
        int escanteiosSegundoTempo = listaPartidaBayerLeverkusenFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaBayerLeverkusenFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo();
        holder.binding.tvEscanteiosTotal.setText(String.valueOf(escanteiosPrimeiroTempo + escanteiosSegundoTempo));

        holder.binding.tvGolsTotalPrimeiroTempo.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBayerLeverkusenFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvGolsTotalSegundoTempo.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaBayerLeverkusenFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        int golsPrimeiroTempo = listaPartidaBayerLeverkusenFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBayerLeverkusenFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo();
        int golsSegundtoTempo = listaPartidaBayerLeverkusenFora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaBayerLeverkusenFora.getAwayEstatisticaJogo().getGolsSegundoTempo();
        holder.binding.tvGolsTotal.setText(String.valueOf(golsPrimeiroTempo + golsSegundtoTempo));

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaBayerLeverkusenFora.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaBayerLeverkusenFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        holder.binding.tvCasaEscanteiosTres.setText(listaPartidaBayerLeverkusenFora.getHomeTimeEscanteios().getThree());
        holder.binding.tvCasaEscanteiosCinco.setText(listaPartidaBayerLeverkusenFora.getHomeTimeEscanteios().getFive());
        holder.binding.tvCasaEscanteiosSete.setText(listaPartidaBayerLeverkusenFora.getHomeTimeEscanteios().getSeven());
        holder.binding.tvCasaEscanteiosNove.setText(listaPartidaBayerLeverkusenFora.getHomeTimeEscanteios().getNine());

        holder.binding.tvCasaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvCasaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvCasaEscanteiosTotal.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBayerLeverkusenFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvCasaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvCasaGolsSegundoTempo.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvCasaGolsTotal.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBayerLeverkusenFora.getHomeEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaBayerLeverkusenFora.getHomeTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerLeverkusenFora.getHomeTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerLeverkusenFora.getHomeTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerLeverkusenFora.getHomeTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaBayerLeverkusenFora.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaBayerLeverkusenFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        holder.binding.tvForaEscanteiosTres.setText(listaPartidaBayerLeverkusenFora.getAwayTimeEscanteios().getThree());
        holder.binding.tvForaEscanteiosCinco.setText(listaPartidaBayerLeverkusenFora.getAwayTimeEscanteios().getFive());
        holder.binding.tvForaEscanteiosSete.setText(listaPartidaBayerLeverkusenFora.getAwayTimeEscanteios().getSeven());
        holder.binding.tvForaEscanteiosNove.setText(listaPartidaBayerLeverkusenFora.getAwayTimeEscanteios().getNine());

        holder.binding.tvForaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvForaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvForaEscanteiosTotal.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBayerLeverkusenFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvForaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvForaGolsSegundoTempo.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvForaGolsTotal.setText(String.valueOf(listaPartidaBayerLeverkusenFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBayerLeverkusenFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaBayerLeverkusenFora.getAwayTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerLeverkusenFora.getAwayTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerLeverkusenFora.getAwayTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerLeverkusenFora.getAwayTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);

    }

    @Override
    public int getItemCount() {
        return augsburgFora.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ListaJogosEstatisticaCartoesAdapterBinding binding;

        public ViewHolder(ListaJogosEstatisticaCartoesAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

