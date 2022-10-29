package com.example.dadosdosjogos2020oficial.adapter.alemanhaA2022a23.borussiadortmund;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class BorussiaDortmundCasa2022a23Adapter extends RecyclerView.Adapter<BorussiaDortmundCasa2022a23Adapter.ViewHolder> {

    private List<Partida> borussiaDortmundCasa2022_23;

    public BorussiaDortmundCasa2022a23Adapter(List<Partida> borussiaDortmundCasa2022_23) {
        this.borussiaDortmundCasa2022_23 = borussiaDortmundCasa2022_23;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        DadosPartidasAdapterBinding binding = DadosPartidasAdapterBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        Partida listaPartidaBorussiaDortmundCasa = borussiaDortmundCasa2022_23.get(position);

        //DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaBorussiaDortmundCasa.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaBorussiaDortmundCasa.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaBorussiaDortmundCasa.getDate());

        holder.binding.tvEscanteiosTotalPrimeiroTempo.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBorussiaDortmundCasa.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvEscanteiosTotalSegundoTempo.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaBorussiaDortmundCasa.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        int escanteiosPrimeiroTempo = listaPartidaBorussiaDortmundCasa.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBorussiaDortmundCasa.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo();
        int escanteiosSegundoTempo = listaPartidaBorussiaDortmundCasa.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaBorussiaDortmundCasa.getAwayEstatisticaJogo().getEscanteioSegundoTempo();
        holder.binding.tvEscanteiosTotal.setText(String.valueOf(escanteiosPrimeiroTempo + escanteiosSegundoTempo));

        holder.binding.tvGolsTotalPrimeiroTempo.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBorussiaDortmundCasa.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvGolsTotalSegundoTempo.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaBorussiaDortmundCasa.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        int golsPrimeiroTempo = listaPartidaBorussiaDortmundCasa.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBorussiaDortmundCasa.getAwayEstatisticaJogo().getGolsPrimeiroTempo();
        int golsSegundtoTempo = listaPartidaBorussiaDortmundCasa.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaBorussiaDortmundCasa.getAwayEstatisticaJogo().getGolsSegundoTempo();
        holder.binding.tvGolsTotal.setText(String.valueOf(golsPrimeiroTempo + golsSegundtoTempo));

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaBorussiaDortmundCasa.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaBorussiaDortmundCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        holder.binding.tvCasaEscanteiosTres.setText(listaPartidaBorussiaDortmundCasa.getHomeTimeEscanteios().getThree());
        holder.binding.tvCasaEscanteiosCinco.setText(listaPartidaBorussiaDortmundCasa.getHomeTimeEscanteios().getFive());
        holder.binding.tvCasaEscanteiosSete.setText(listaPartidaBorussiaDortmundCasa.getHomeTimeEscanteios().getSeven());
        holder.binding.tvCasaEscanteiosNove.setText(listaPartidaBorussiaDortmundCasa.getHomeTimeEscanteios().getNine());

        holder.binding.tvCasaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvCasaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvCasaEscanteiosTotal.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBorussiaDortmundCasa.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvCasaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getHomeEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvCasaGolsSegundoTempo.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getHomeEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvCasaGolsTotal.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBorussiaDortmundCasa.getHomeEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaBorussiaDortmundCasa.getHomeTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBorussiaDortmundCasa.getHomeTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBorussiaDortmundCasa.getHomeTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBorussiaDortmundCasa.getHomeTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaBorussiaDortmundCasa.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaBorussiaDortmundCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        holder.binding.tvForaEscanteiosTres.setText(listaPartidaBorussiaDortmundCasa.getAwayTimeEscanteios().getThree());
        holder.binding.tvForaEscanteiosCinco.setText(listaPartidaBorussiaDortmundCasa.getAwayTimeEscanteios().getFive());
        holder.binding.tvForaEscanteiosSete.setText(listaPartidaBorussiaDortmundCasa.getAwayTimeEscanteios().getSeven());
        holder.binding.tvForaEscanteiosNove.setText(listaPartidaBorussiaDortmundCasa.getAwayTimeEscanteios().getNine());

        holder.binding.tvForaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvForaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvForaEscanteiosTotal.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBorussiaDortmundCasa.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvForaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvForaGolsSegundoTempo.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvForaGolsTotal.setText(String.valueOf(listaPartidaBorussiaDortmundCasa.getAwayEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBorussiaDortmundCasa.getAwayEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaBorussiaDortmundCasa.getAwayTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBorussiaDortmundCasa.getAwayTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBorussiaDortmundCasa.getAwayTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBorussiaDortmundCasa.getAwayTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);

    }

    @Override
    public int getItemCount() {
        return borussiaDortmundCasa2022_23.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

