package com.jogos.dadosoficialkf228920.adapter.alemanhaA2022a23.augsburg;

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

public class AugsburgCasa2022a23Adapter extends RecyclerView.Adapter<AugsburgCasa2022a23Adapter.ViewHolder> {

    private List<Partida> augsburgCasa2022_23;

    public AugsburgCasa2022a23Adapter(List<Partida> augsburgCasa2022_23) {
        this.augsburgCasa2022_23 = augsburgCasa2022_23;
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

        Partida listaPartidaAugsburgCasa = augsburgCasa2022_23.get(position);

        //DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaAugsburgCasa.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaAugsburgCasa.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaAugsburgCasa.getDate());

        holder.binding.tvEscanteiosTotalPrimeiroTempo.setText(String.valueOf(listaPartidaAugsburgCasa.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaAugsburgCasa.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvEscanteiosTotalSegundoTempo.setText(String.valueOf(listaPartidaAugsburgCasa.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaAugsburgCasa.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        int escanteiosPrimeiroTempo = listaPartidaAugsburgCasa.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaAugsburgCasa.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo();
        int escanteiosSegundoTempo = listaPartidaAugsburgCasa.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaAugsburgCasa.getAwayEstatisticaJogo().getEscanteioSegundoTempo();
        holder.binding.tvEscanteiosTotal.setText(String.valueOf(escanteiosPrimeiroTempo + escanteiosSegundoTempo));

        holder.binding.tvGolsTotalPrimeiroTempo.setText(String.valueOf(listaPartidaAugsburgCasa.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaAugsburgCasa.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvGolsTotalSegundoTempo.setText(String.valueOf(listaPartidaAugsburgCasa.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaAugsburgCasa.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        int golsPrimeiroTempo = listaPartidaAugsburgCasa.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaAugsburgCasa.getAwayEstatisticaJogo().getGolsPrimeiroTempo();
        int golsSegundtoTempo = listaPartidaAugsburgCasa.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaAugsburgCasa.getAwayEstatisticaJogo().getGolsSegundoTempo();
        holder.binding.tvGolsTotal.setText(String.valueOf(golsPrimeiroTempo + golsSegundtoTempo));

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaAugsburgCasa.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaAugsburgCasa.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaAugsburgCasa.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaAugsburgCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        holder.binding.tvCasaEscanteiosTres.setText(listaPartidaAugsburgCasa.getHomeTimeEscanteios().getThree());
        holder.binding.tvCasaEscanteiosCinco.setText(listaPartidaAugsburgCasa.getHomeTimeEscanteios().getFive());
        holder.binding.tvCasaEscanteiosSete.setText(listaPartidaAugsburgCasa.getHomeTimeEscanteios().getSeven());
        holder.binding.tvCasaEscanteiosNove.setText(listaPartidaAugsburgCasa.getHomeTimeEscanteios().getNine());

        holder.binding.tvCasaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaAugsburgCasa.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvCasaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaAugsburgCasa.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvCasaEscanteiosTotal.setText(String.valueOf(listaPartidaAugsburgCasa.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaAugsburgCasa.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvCasaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaAugsburgCasa.getHomeEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvCasaGolsSegundoTempo.setText(String.valueOf(listaPartidaAugsburgCasa.getHomeEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvCasaGolsTotal.setText(String.valueOf(listaPartidaAugsburgCasa.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaAugsburgCasa.getHomeEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaAugsburgCasa.getHomeTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaAugsburgCasa.getHomeTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaAugsburgCasa.getHomeTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaAugsburgCasa.getHomeTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaAugsburgCasa.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaAugsburgCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaAugsburgCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaAugsburgCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        holder.binding.tvForaEscanteiosTres.setText(listaPartidaAugsburgCasa.getAwayTimeEscanteios().getThree());
        holder.binding.tvForaEscanteiosCinco.setText(listaPartidaAugsburgCasa.getAwayTimeEscanteios().getFive());
        holder.binding.tvForaEscanteiosSete.setText(listaPartidaAugsburgCasa.getAwayTimeEscanteios().getSeven());
        holder.binding.tvForaEscanteiosNove.setText(listaPartidaAugsburgCasa.getAwayTimeEscanteios().getNine());

        holder.binding.tvForaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaAugsburgCasa.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvForaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaAugsburgCasa.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvForaEscanteiosTotal.setText(String.valueOf(listaPartidaAugsburgCasa.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaAugsburgCasa.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvForaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaAugsburgCasa.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvForaGolsSegundoTempo.setText(String.valueOf(listaPartidaAugsburgCasa.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvForaGolsTotal.setText(String.valueOf(listaPartidaAugsburgCasa.getAwayEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaAugsburgCasa.getAwayEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaAugsburgCasa.getAwayTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaAugsburgCasa.getAwayTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaAugsburgCasa.getAwayTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaAugsburgCasa.getAwayTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);

    }

    @Override
    public int getItemCount() {
        return augsburgCasa2022_23.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ListaJogosEstatisticaCartoesAdapterBinding binding;

        public ViewHolder(ListaJogosEstatisticaCartoesAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
