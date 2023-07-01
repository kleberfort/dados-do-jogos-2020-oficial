package com.jogos.dadosoficialkf228920.adapter.brasileriroB2023.avai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.ListaJogosEstatisticaCartoesAdapterBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

public class AvaiForaB2023Adapter extends RecyclerView.Adapter<AvaiForaB2023Adapter.ViewHolder> {

    private List<Partida> avaiFora;

    public AvaiForaB2023Adapter(List<Partida> avaiFora) {
        this.avaiFora = avaiFora;
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

        Partida listaPartidaAvaiFora = avaiFora.get(position);

//DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaAvaiFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaAvaiFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaAvaiFora.getDate());

        /* Cartoes */
        holder.binding.cartaoAmrlCs.setText(String.valueOf(listaPartidaAvaiFora.getHomeCartoes().getAmarelo()));
        holder.binding.cartaoAmrlFr.setText(String.valueOf(listaPartidaAvaiFora.getAwayCartoes().getAmarelo()));
        holder.binding.cartaoVmlCs.setText(String.valueOf(listaPartidaAvaiFora.getHomeCartoes().getVermelho()));
        holder.binding.cartaoVmlFr.setText(String.valueOf(listaPartidaAvaiFora.getAwayCartoes().getVermelho()));
        holder.binding.cartaoTotalAmrl.setText(String.valueOf(listaPartidaAvaiFora.getHomeCartoes().getAmarelo() + listaPartidaAvaiFora.getAwayCartoes().getAmarelo()));
        holder.binding.cartaoTotalVml.setText(String.valueOf(listaPartidaAvaiFora.getHomeCartoes().getVermelho() + listaPartidaAvaiFora.getAwayCartoes().getVermelho()));

        holder.binding.tvEscanteiosTotalPrimeiroTempo.setText(String.valueOf(listaPartidaAvaiFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaAvaiFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvEscanteiosTotalSegundoTempo.setText(String.valueOf(listaPartidaAvaiFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaAvaiFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        int escanteiosPrimeiroTempo = listaPartidaAvaiFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaAvaiFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo();
        int escanteiosSegundoTempo = listaPartidaAvaiFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaAvaiFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo();
        holder.binding.tvEscanteiosTotal.setText(String.valueOf(escanteiosPrimeiroTempo + escanteiosSegundoTempo));

        holder.binding.tvGolsTotalPrimeiroTempo.setText(String.valueOf(listaPartidaAvaiFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaAvaiFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvGolsTotalSegundoTempo.setText(String.valueOf(listaPartidaAvaiFora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaAvaiFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        int golsPrimeiroTempo = listaPartidaAvaiFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaAvaiFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo();
        int golsSegundtoTempo = listaPartidaAvaiFora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaAvaiFora.getAwayEstatisticaJogo().getGolsSegundoTempo();
        holder.binding.tvGolsTotal.setText(String.valueOf(golsPrimeiroTempo + golsSegundtoTempo));

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaAvaiFora.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaAvaiFora.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaAvaiFora.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaAvaiFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        holder.binding.tvCasaEscanteiosTres.setText(listaPartidaAvaiFora.getHomeTimeEscanteios().getThree());
        holder.binding.tvCasaEscanteiosCinco.setText(listaPartidaAvaiFora.getHomeTimeEscanteios().getFive());
        holder.binding.tvCasaEscanteiosSete.setText(listaPartidaAvaiFora.getHomeTimeEscanteios().getSeven());
        holder.binding.tvCasaEscanteiosNove.setText(listaPartidaAvaiFora.getHomeTimeEscanteios().getNine());

        holder.binding.tvCasaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaAvaiFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvCasaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaAvaiFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvCasaEscanteiosTotal.setText(String.valueOf(listaPartidaAvaiFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaAvaiFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvCasaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaAvaiFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvCasaGolsSegundoTempo.setText(String.valueOf(listaPartidaAvaiFora.getHomeEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvCasaGolsTotal.setText(String.valueOf(listaPartidaAvaiFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaAvaiFora.getHomeEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaAvaiFora.getHomeTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaAvaiFora.getHomeTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaAvaiFora.getHomeTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaAvaiFora.getHomeTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaAvaiFora.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaAvaiFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaAvaiFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaAvaiFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        holder.binding.tvForaEscanteiosTres.setText(listaPartidaAvaiFora.getAwayTimeEscanteios().getThree());
        holder.binding.tvForaEscanteiosCinco.setText(listaPartidaAvaiFora.getAwayTimeEscanteios().getFive());
        holder.binding.tvForaEscanteiosSete.setText(listaPartidaAvaiFora.getAwayTimeEscanteios().getSeven());
        holder.binding.tvForaEscanteiosNove.setText(listaPartidaAvaiFora.getAwayTimeEscanteios().getNine());

        holder.binding.tvForaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaAvaiFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvForaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaAvaiFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvForaEscanteiosTotal.setText(String.valueOf(listaPartidaAvaiFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaAvaiFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvForaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaAvaiFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvForaGolsSegundoTempo.setText(String.valueOf(listaPartidaAvaiFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvForaGolsTotal.setText(String.valueOf(listaPartidaAvaiFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaAvaiFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaAvaiFora.getAwayTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaAvaiFora.getAwayTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaAvaiFora.getAwayTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaAvaiFora.getAwayTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);


    }

    @Override
    public int getItemCount() {
        return avaiFora.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{



        private ListaJogosEstatisticaCartoesAdapterBinding binding;

        public ViewHolder(ListaJogosEstatisticaCartoesAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
