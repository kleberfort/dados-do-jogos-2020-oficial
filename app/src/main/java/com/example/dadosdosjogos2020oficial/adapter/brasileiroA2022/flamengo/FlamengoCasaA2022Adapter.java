package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.flamengo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.fluminense.FluminenseCasaA2022Adapter;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class FlamengoCasaA2022Adapter extends RecyclerView.Adapter<FlamengoCasaA2022Adapter.ViewHolder> {

    private List<Partida> flamengoCasa2022;

    public FlamengoCasaA2022Adapter(List<Partida> flamengoCasa2022) {
        this.flamengoCasa2022 = flamengoCasa2022;
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

        Partida listaPartidaFlamengoCasa = flamengoCasa2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaFlamengoCasa.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaFlamengoCasa.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaFlamengoCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaFlamengoCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaFlamengoCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaFlamengoCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaFlamengoCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaFlamengoCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaFlamengoCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaFlamengoCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaFlamengoCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return flamengoCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}