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

public class AtleticoPrForaA2022Adapter extends RecyclerView.Adapter<AtleticoPrForaA2022Adapter.ViewHolder> {

    private List<Partida> atleticoPrFora2022;

    public AtleticoPrForaA2022Adapter(List<Partida> atleticoMgFora2022) {
        this.atleticoPrFora2022 = atleticoMgFora2022;
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

        Partida listaPartidaAtleticoPrFora = atleticoPrFora2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaAtleticoPrFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaAtleticoPrFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaAtleticoPrFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaAtleticoPrFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaAtleticoPrFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaAtleticoPrFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaAtleticoPrFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaAtleticoPrFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaAtleticoPrFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaAtleticoPrFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaAtleticoPrFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return atleticoPrFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
