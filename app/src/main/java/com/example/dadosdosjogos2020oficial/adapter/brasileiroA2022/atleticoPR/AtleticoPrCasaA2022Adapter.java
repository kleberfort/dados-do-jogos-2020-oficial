package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.atleticoPR;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class AtleticoPrCasaA2022Adapter extends RecyclerView.Adapter<AtleticoPrCasaA2022Adapter.ViewHolder> {
    private List<Partida> atleticoPrCasa2022;

    public AtleticoPrCasaA2022Adapter(List<Partida> atleticoPrCasa2022) {
        this.atleticoPrCasa2022 = atleticoPrCasa2022;
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

        Partida listaPartidaAtleticoPrCasa = atleticoPrCasa2022.get(position);

        holder.binding.tvDescricaoCampeonato.setText(listaPartidaAtleticoPrCasa.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaAtleticoPrCasa.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaAtleticoPrCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaAtleticoPrCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaAtleticoPrCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaAtleticoPrCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaAtleticoPrCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaAtleticoPrCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaAtleticoPrCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaAtleticoPrCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaAtleticoPrCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        holder.binding.tvCasaEscanteiosTres.setText(listaPartidaAtleticoPrCasa.getHomeTimeEscanteios().getThree());
        holder.binding.tvCasaEscanteiosCinco.setText(listaPartidaAtleticoPrCasa.getHomeTimeEscanteios().getFive());
        holder.binding.tvCasaEscanteiosSete.setText(listaPartidaAtleticoPrCasa.getHomeTimeEscanteios().getSeven());
        holder.binding.tvCasaEscanteiosNove.setText(listaPartidaAtleticoPrCasa.getHomeTimeEscanteios().getNine());

        holder.binding.tvForaEscanteiosTres.setText(listaPartidaAtleticoPrCasa.getAwayTimeEscanteios().getThree());
        holder.binding.tvForaEscanteiosCinco.setText(listaPartidaAtleticoPrCasa.getAwayTimeEscanteios().getFive());
        holder.binding.tvForaEscanteiosSete.setText(listaPartidaAtleticoPrCasa.getAwayTimeEscanteios().getSeven());
        holder.binding.tvForaEscanteiosNove.setText(listaPartidaAtleticoPrCasa.getAwayTimeEscanteios().getNine());


        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA


    }

    @Override
    public int getItemCount() {
        return atleticoPrCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}