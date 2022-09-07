package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.americaMG;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class AmericaMgCasaA2022Adapter extends RecyclerView.Adapter<AmericaMgCasaA2022Adapter.ViewHolder> {

    private List<Partida> americaMgCasa2022;

    public AmericaMgCasaA2022Adapter(List<Partida> americaMgCasa2022) {
        this.americaMgCasa2022 = americaMgCasa2022;
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

        Partida listaPartidaAmericaMgCasa = americaMgCasa2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaAmericaMgCasa.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaAmericaMgCasa.getRodada()));
        holder.binding.tvDataJogo.setText(listaPartidaAmericaMgCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaAmericaMgCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaAmericaMgCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaAmericaMgCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaAmericaMgCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaAmericaMgCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaAmericaMgCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaAmericaMgCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaAmericaMgCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return americaMgCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
