package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.fluminense;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class FluminenseForaA2022Adapter extends RecyclerView.Adapter<FluminenseForaA2022Adapter.ViewHolder> {

    private List<Partida> fluminenseFora2022;

    public FluminenseForaA2022Adapter(List<Partida> fluminenseFora2022) {
        this.fluminenseFora2022 = fluminenseFora2022;
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

        Partida listaPartidaFluminenseFora = fluminenseFora2022.get(position);

        holder.binding.tvDescricaoCampeonato.setText(listaPartidaFluminenseFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaFluminenseFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaFluminenseFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaFluminenseFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaFluminenseFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaFluminenseFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaFluminenseFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaFluminenseFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaFluminenseFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaFluminenseFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaFluminenseFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return fluminenseFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
