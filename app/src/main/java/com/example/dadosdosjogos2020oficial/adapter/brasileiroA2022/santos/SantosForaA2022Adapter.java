package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.santos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class SantosForaA2022Adapter extends RecyclerView.Adapter<SantosForaA2022Adapter.ViewHolder> {

    private List<Partida> santosFora2022;

    public SantosForaA2022Adapter(List<Partida> santosFora2022) {
        this.santosFora2022 = santosFora2022;
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

        Partida listaPartidaSantosFora = santosFora2022.get(position);

        holder.binding.tvDescricaoCampeonato.setText(listaPartidaSantosFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaSantosFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaSantosFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaSantosFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaSantosFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaSantosFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaSantosFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaSantosFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaSantosFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaSantosFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaSantosFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return santosFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
