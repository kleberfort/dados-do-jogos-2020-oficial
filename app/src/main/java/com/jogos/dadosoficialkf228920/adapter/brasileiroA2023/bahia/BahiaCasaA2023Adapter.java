package com.jogos.dadosoficialkf228920.adapter.brasileiroA2023.bahia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.ListaJogosEstatisticaCartoesAdapterBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

public class BahiaCasaA2023Adapter extends RecyclerView.Adapter<BahiaCasaA2023Adapter.ViewHolder> {
    private List<Partida> bahiaPrCasa2023;

    public BahiaCasaA2023Adapter(List<Partida> bahiaPrCasa2023) {
        this.bahiaPrCasa2023 = bahiaPrCasa2023;
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

        Partida listaPartidaBotafogoSpCasa = bahiaPrCasa2023.get(position);

//DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaBotafogoSpCasa
.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaBotafogoSpCasa
.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaBotafogoSpCasa
.getDate());

        /* Cartoes */
        holder.binding.cartaoAmrlCs.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getHomeCartoes().getAmarelo()));
        holder.binding.cartaoAmrlFr.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getAwayCartoes().getAmarelo()));
        holder.binding.cartaoVmlCs.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getHomeCartoes().getVermelho()));
        holder.binding.cartaoVmlFr.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getAwayCartoes().getVermelho()));
        holder.binding.cartaoTotalAmrl.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getHomeCartoes().getAmarelo() + listaPartidaBotafogoSpCasa
.getAwayCartoes().getAmarelo()));
        holder.binding.cartaoTotalVml.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getHomeCartoes().getVermelho() + listaPartidaBotafogoSpCasa
.getAwayCartoes().getVermelho()));

        holder.binding.tvEscanteiosTotalPrimeiroTempo.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBotafogoSpCasa
.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvEscanteiosTotalSegundoTempo.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaBotafogoSpCasa
.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        int escanteiosPrimeiroTempo = listaPartidaBotafogoSpCasa
.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBotafogoSpCasa
.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo();
        int escanteiosSegundoTempo = listaPartidaBotafogoSpCasa
.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaBotafogoSpCasa
.getAwayEstatisticaJogo().getEscanteioSegundoTempo();
        holder.binding.tvEscanteiosTotal.setText(String.valueOf(escanteiosPrimeiroTempo + escanteiosSegundoTempo));

        holder.binding.tvGolsTotalPrimeiroTempo.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBotafogoSpCasa
.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvGolsTotalSegundoTempo.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaBotafogoSpCasa
.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        int golsPrimeiroTempo = listaPartidaBotafogoSpCasa
.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBotafogoSpCasa
.getAwayEstatisticaJogo().getGolsPrimeiroTempo();
        int golsSegundtoTempo = listaPartidaBotafogoSpCasa
.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaBotafogoSpCasa
.getAwayEstatisticaJogo().getGolsSegundoTempo();
        holder.binding.tvGolsTotal.setText(String.valueOf(golsPrimeiroTempo + golsSegundtoTempo));

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaBotafogoSpCasa
.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaBotafogoSpCasa
.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        holder.binding.tvCasaEscanteiosTres.setText(listaPartidaBotafogoSpCasa
.getHomeTimeEscanteios().getThree());
        holder.binding.tvCasaEscanteiosCinco.setText(listaPartidaBotafogoSpCasa
.getHomeTimeEscanteios().getFive());
        holder.binding.tvCasaEscanteiosSete.setText(listaPartidaBotafogoSpCasa
.getHomeTimeEscanteios().getSeven());
        holder.binding.tvCasaEscanteiosNove.setText(listaPartidaBotafogoSpCasa
.getHomeTimeEscanteios().getNine());

        holder.binding.tvCasaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvCasaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvCasaEscanteiosTotal.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBotafogoSpCasa
.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvCasaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getHomeEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvCasaGolsSegundoTempo.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getHomeEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvCasaGolsTotal.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBotafogoSpCasa
.getHomeEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaBotafogoSpCasa
.getHomeTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBotafogoSpCasa
.getHomeTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBotafogoSpCasa
.getHomeTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBotafogoSpCasa
.getHomeTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaBotafogoSpCasa
.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaBotafogoSpCasa
.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        holder.binding.tvForaEscanteiosTres.setText(listaPartidaBotafogoSpCasa
.getAwayTimeEscanteios().getThree());
        holder.binding.tvForaEscanteiosCinco.setText(listaPartidaBotafogoSpCasa
.getAwayTimeEscanteios().getFive());
        holder.binding.tvForaEscanteiosSete.setText(listaPartidaBotafogoSpCasa
.getAwayTimeEscanteios().getSeven());
        holder.binding.tvForaEscanteiosNove.setText(listaPartidaBotafogoSpCasa
.getAwayTimeEscanteios().getNine());

        holder.binding.tvForaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvForaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvForaEscanteiosTotal.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBotafogoSpCasa
.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvForaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvForaGolsSegundoTempo.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvForaGolsTotal.setText(String.valueOf(listaPartidaBotafogoSpCasa
.getAwayEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBotafogoSpCasa
.getAwayEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaBotafogoSpCasa
.getAwayTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBotafogoSpCasa
.getAwayTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBotafogoSpCasa
.getAwayTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBotafogoSpCasa
.getAwayTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);


    }

    @Override
    public int getItemCount() {
        return bahiaPrCasa2023.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{



        private ListaJogosEstatisticaCartoesAdapterBinding binding;

        public ViewHolder(ListaJogosEstatisticaCartoesAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}