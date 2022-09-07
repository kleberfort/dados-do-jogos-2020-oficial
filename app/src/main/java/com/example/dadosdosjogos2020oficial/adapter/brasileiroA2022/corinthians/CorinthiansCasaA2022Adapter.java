package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.corinthians;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class CorinthiansCasaA2022Adapter extends RecyclerView.Adapter<CorinthiansCasaA2022Adapter.ViewHolder> {
    private List<Partida> corinthiansCasa2022;

    public CorinthiansCasaA2022Adapter(List<Partida> corinthiansCasa2022) {
        this.corinthiansCasa2022 = corinthiansCasa2022;
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

        Partida listaPartidaCorinthiansCasa = corinthiansCasa2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaCorinthiansCasa.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaCorinthiansCasa.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaCorinthiansCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaCorinthiansCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaCorinthiansCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaCorinthiansCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaCorinthiansCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaCorinthiansCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaCorinthiansCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaCorinthiansCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaCorinthiansCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);


    }

    @Override
    public int getItemCount() {
        return corinthiansCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
