package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.cuiaba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class CuiabaForaA2022Adapter extends RecyclerView.Adapter<CuiabaForaA2022Adapter.ViewHolder> {

    private List<Partida> cuiabaFora2022;

    public CuiabaForaA2022Adapter(List<Partida> cuiabaFora2022) {
        this.cuiabaFora2022 = cuiabaFora2022;
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

        Partida listaPartidaCuiabaFora = cuiabaFora2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaCuiabaFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaCuiabaFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaCuiabaFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaCuiabaFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaCuiabaFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaCuiabaFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaCuiabaFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaCuiabaFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaCuiabaFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaCuiabaFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaCuiabaFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return cuiabaFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
