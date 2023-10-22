package com.jogos.dadosoficialkf228920.adapter.alemanhaA2022a23.herthaberlin;

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

public class HerthaBerlinFora2022a23Adapter extends RecyclerView.Adapter<HerthaBerlinFora2022a23Adapter.ViewHolder> {

    private List<Partida> herthaBerlinFora2022_23;

    public HerthaBerlinFora2022a23Adapter(List<Partida> herthaBerlinFora2022_23) {
        this.herthaBerlinFora2022_23 = herthaBerlinFora2022_23;
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

        Partida listaHertaBerlinFora = herthaBerlinFora2022_23.get(position);

        //DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaHertaBerlinFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaHertaBerlinFora.getRound()));
        holder.binding.tvDataJogo.setText(listaHertaBerlinFora.getDate());

        holder.binding.tvEscanteiosTotalPrimeiroTempo.setText(String.valueOf(listaHertaBerlinFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaHertaBerlinFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvEscanteiosTotalSegundoTempo.setText(String.valueOf(listaHertaBerlinFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaHertaBerlinFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        int escanteiosPrimeiroTempo = listaHertaBerlinFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaHertaBerlinFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo();
        int escanteiosSegundoTempo = listaHertaBerlinFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaHertaBerlinFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo();
        holder.binding.tvEscanteiosTotal.setText(String.valueOf(escanteiosPrimeiroTempo + escanteiosSegundoTempo));

        holder.binding.tvGolsTotalPrimeiroTempo.setText(String.valueOf(listaHertaBerlinFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaHertaBerlinFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvGolsTotalSegundoTempo.setText(String.valueOf(listaHertaBerlinFora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaHertaBerlinFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        int golsPrimeiroTempo = listaHertaBerlinFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaHertaBerlinFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo();
        int golsSegundtoTempo = listaHertaBerlinFora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaHertaBerlinFora.getAwayEstatisticaJogo().getGolsSegundoTempo();
        holder.binding.tvGolsTotal.setText(String.valueOf(golsPrimeiroTempo + golsSegundtoTempo));

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaHertaBerlinFora.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaHertaBerlinFora.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaHertaBerlinFora.getHomeTime().getPlacar()));
        Glide.with(context).load(listaHertaBerlinFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        holder.binding.tvCasaEscanteiosTres.setText(listaHertaBerlinFora.getHomeTimeEscanteios().getThree());
        holder.binding.tvCasaEscanteiosCinco.setText(listaHertaBerlinFora.getHomeTimeEscanteios().getFive());
        holder.binding.tvCasaEscanteiosSete.setText(listaHertaBerlinFora.getHomeTimeEscanteios().getSeven());
        holder.binding.tvCasaEscanteiosNove.setText(listaHertaBerlinFora.getHomeTimeEscanteios().getNine());

        holder.binding.tvCasaEscanteiosPrimeiroTempo.setText(String.valueOf(listaHertaBerlinFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvCasaEscanteiosSegundoTempo.setText(String.valueOf(listaHertaBerlinFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvCasaEscanteiosTotal.setText(String.valueOf(listaHertaBerlinFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaHertaBerlinFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvCasaGolsPrimeiroTempo.setText(String.valueOf(listaHertaBerlinFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvCasaGolsSegundoTempo.setText(String.valueOf(listaHertaBerlinFora.getHomeEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvCasaGolsTotal.setText(String.valueOf(listaHertaBerlinFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaHertaBerlinFora.getHomeEstatisticaJogo().getGolsSegundoTempo()));

        if(listaHertaBerlinFora.getHomeTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaHertaBerlinFora.getHomeTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaHertaBerlinFora.getHomeTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaHertaBerlinFora.getHomeTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaHertaBerlinFora.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaHertaBerlinFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaHertaBerlinFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaHertaBerlinFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        holder.binding.tvForaEscanteiosTres.setText(listaHertaBerlinFora.getAwayTimeEscanteios().getThree());
        holder.binding.tvForaEscanteiosCinco.setText(listaHertaBerlinFora.getAwayTimeEscanteios().getFive());
        holder.binding.tvForaEscanteiosSete.setText(listaHertaBerlinFora.getAwayTimeEscanteios().getSeven());
        holder.binding.tvForaEscanteiosNove.setText(listaHertaBerlinFora.getAwayTimeEscanteios().getNine());

        holder.binding.tvForaEscanteiosPrimeiroTempo.setText(String.valueOf(listaHertaBerlinFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvForaEscanteiosSegundoTempo.setText(String.valueOf(listaHertaBerlinFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvForaEscanteiosTotal.setText(String.valueOf(listaHertaBerlinFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaHertaBerlinFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvForaGolsPrimeiroTempo.setText(String.valueOf(listaHertaBerlinFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvForaGolsSegundoTempo.setText(String.valueOf(listaHertaBerlinFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvForaGolsTotal.setText(String.valueOf(listaHertaBerlinFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo() + listaHertaBerlinFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));

        if(listaHertaBerlinFora.getAwayTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaHertaBerlinFora.getAwayTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaHertaBerlinFora.getAwayTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaHertaBerlinFora.getAwayTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);

    }

    @Override
    public int getItemCount() {
        return herthaBerlinFora2022_23.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ListaJogosEstatisticaCartoesAdapterBinding binding;

        public ViewHolder(ListaJogosEstatisticaCartoesAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

