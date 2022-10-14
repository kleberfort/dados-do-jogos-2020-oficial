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

public class FluminenseCasaA2022Adapter extends RecyclerView.Adapter<FluminenseCasaA2022Adapter.ViewHolder> {

    private List<Partida> fluminenseCasa2022;

    public FluminenseCasaA2022Adapter(List<Partida> fluminenseCasa2022) {
        this.fluminenseCasa2022 = fluminenseCasa2022;
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

        Partida listaPartidaFluminenseCasa = fluminenseCasa2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaFluminenseCasa.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaFluminenseCasa.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaFluminenseCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaFluminenseCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaFluminenseCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaFluminenseCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaFluminenseCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaFluminenseCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaFluminenseCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaFluminenseCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaFluminenseCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return fluminenseCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}