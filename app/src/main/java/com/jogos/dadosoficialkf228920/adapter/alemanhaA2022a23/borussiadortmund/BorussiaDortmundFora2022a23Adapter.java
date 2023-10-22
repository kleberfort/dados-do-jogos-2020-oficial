package com.jogos.dadosoficialkf228920.adapter.alemanhaA2022a23.borussiadortmund;

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

public class BorussiaDortmundFora2022a23Adapter extends RecyclerView.Adapter<BorussiaDortmundFora2022a23Adapter.ViewHolder> {

    private List<Partida> borussiaDortmundFora2022_23;

    public BorussiaDortmundFora2022a23Adapter(List<Partida> borussiaDortmundFora2022_23) {
        this.borussiaDortmundFora2022_23 = borussiaDortmundFora2022_23;
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

        Partida listaPartidaBorussiaDortmundFora = borussiaDortmundFora2022_23.get(position);

        //DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaBorussiaDortmundFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaBorussiaDortmundFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaBorussiaDortmundFora.getDate());

        holder.binding.tvEscanteiosTotalPrimeiroTempo.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBorussiaDortmundFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvEscanteiosTotalSegundoTempo.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaBorussiaDortmundFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        int escanteiosPrimeiroTempo = listaPartidaBorussiaDortmundFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBorussiaDortmundFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo();
        int escanteiosSegundoTempo = listaPartidaBorussiaDortmundFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaBorussiaDortmundFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo();
        holder.binding.tvEscanteiosTotal.setText(String.valueOf(escanteiosPrimeiroTempo + escanteiosSegundoTempo));

        holder.binding.tvGolsTotalPrimeiroTempo.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBorussiaDortmundFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvGolsTotalSegundoTempo.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaBorussiaDortmundFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        int golsPrimeiroTempo = listaPartidaBorussiaDortmundFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBorussiaDortmundFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo();
        int golsSegundtoTempo = listaPartidaBorussiaDortmundFora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaBorussiaDortmundFora.getAwayEstatisticaJogo().getGolsSegundoTempo();
        holder.binding.tvGolsTotal.setText(String.valueOf(golsPrimeiroTempo + golsSegundtoTempo));

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaBorussiaDortmundFora.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaBorussiaDortmundFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        holder.binding.tvCasaEscanteiosTres.setText(listaPartidaBorussiaDortmundFora.getHomeTimeEscanteios().getThree());
        holder.binding.tvCasaEscanteiosCinco.setText(listaPartidaBorussiaDortmundFora.getHomeTimeEscanteios().getFive());
        holder.binding.tvCasaEscanteiosSete.setText(listaPartidaBorussiaDortmundFora.getHomeTimeEscanteios().getSeven());
        holder.binding.tvCasaEscanteiosNove.setText(listaPartidaBorussiaDortmundFora.getHomeTimeEscanteios().getNine());

        holder.binding.tvCasaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvCasaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvCasaEscanteiosTotal.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBorussiaDortmundFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvCasaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvCasaGolsSegundoTempo.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getHomeEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvCasaGolsTotal.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBorussiaDortmundFora.getHomeEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaBorussiaDortmundFora.getHomeTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBorussiaDortmundFora.getHomeTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBorussiaDortmundFora.getHomeTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBorussiaDortmundFora.getHomeTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaBorussiaDortmundFora.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaBorussiaDortmundFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        holder.binding.tvForaEscanteiosTres.setText(listaPartidaBorussiaDortmundFora.getAwayTimeEscanteios().getThree());
        holder.binding.tvForaEscanteiosCinco.setText(listaPartidaBorussiaDortmundFora.getAwayTimeEscanteios().getFive());
        holder.binding.tvForaEscanteiosSete.setText(listaPartidaBorussiaDortmundFora.getAwayTimeEscanteios().getSeven());
        holder.binding.tvForaEscanteiosNove.setText(listaPartidaBorussiaDortmundFora.getAwayTimeEscanteios().getNine());

        holder.binding.tvForaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvForaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvForaEscanteiosTotal.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBorussiaDortmundFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvForaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvForaGolsSegundoTempo.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvForaGolsTotal.setText(String.valueOf(listaPartidaBorussiaDortmundFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBorussiaDortmundFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaBorussiaDortmundFora.getAwayTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBorussiaDortmundFora.getAwayTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBorussiaDortmundFora.getAwayTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBorussiaDortmundFora.getAwayTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);

    }

    @Override
    public int getItemCount() {
        return borussiaDortmundFora2022_23.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ListaJogosEstatisticaCartoesAdapterBinding binding;

        public ViewHolder(ListaJogosEstatisticaCartoesAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

