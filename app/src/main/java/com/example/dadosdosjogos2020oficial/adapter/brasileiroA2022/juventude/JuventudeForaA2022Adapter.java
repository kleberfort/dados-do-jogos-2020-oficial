package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.juventude;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class JuventudeForaA2022Adapter extends RecyclerView.Adapter<JuventudeForaA2022Adapter.ViewHolder> {

    private List<Partida> juventudeFora2022;

    public JuventudeForaA2022Adapter(List<Partida> juventudeFora2022) {
        this.juventudeFora2022 = juventudeFora2022;
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

        Partida listaPartidaJuventudeFora = juventudeFora2022.get(position);

        holder.binding.tvDescricaoCampeonato.setText(listaPartidaJuventudeFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaJuventudeFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaJuventudeFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaJuventudeFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaJuventudeFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaJuventudeFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaJuventudeFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaJuventudeFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaJuventudeFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaJuventudeFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaJuventudeFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return juventudeFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
