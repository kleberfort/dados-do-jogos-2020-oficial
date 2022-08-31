package com.example.dadosdosjogos2020oficial.adapter.ceara;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.data.PartidaApi;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class CearaCasaA2022Adapter extends RecyclerView.Adapter<CearaCasaA2022Adapter.ViewHolder> {

    private List<Partida> cearaCasaA2022;

    public CearaCasaA2022Adapter(List<Partida> cearaCasaA2022) {
        this.cearaCasaA2022 = cearaCasaA2022;
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

        Partida listaPartidaCearaCasa = cearaCasaA2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaCearaCasa.getNome());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaCearaCasa.getRodada()));
        holder.binding.tvNomeCasa.setText(listaPartidaCearaCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaCearaCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaCearaCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaCearaCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaCearaCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaCearaCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaCearaCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaCearaCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        // holder.binding.tvDataJogo.setText(listaPartidaCearaCasa.getRodada());


    }

    @Override
    public int getItemCount() {
        return cearaCasaA2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());

            this.binding = binding;

        }
    }
}
