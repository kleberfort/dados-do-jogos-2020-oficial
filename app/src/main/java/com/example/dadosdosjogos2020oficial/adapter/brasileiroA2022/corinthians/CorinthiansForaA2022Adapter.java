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

public class CorinthiansForaA2022Adapter extends RecyclerView.Adapter<CorinthiansForaA2022Adapter.ViewHolder> {

    private List<Partida> corinthiansFora2022;

    public CorinthiansForaA2022Adapter(List<Partida> corinthiansFora2022) {
        this.corinthiansFora2022 = corinthiansFora2022;
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

        Partida listaPartidaCorinthiansFora = corinthiansFora2022.get(position);

        holder.binding.tvDescricaoCampeonato.setText(listaPartidaCorinthiansFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaCorinthiansFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaCorinthiansFora.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaCorinthiansFora.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaCorinthiansFora.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaCorinthiansFora.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaCorinthiansFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaCorinthiansFora.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaCorinthiansFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaCorinthiansFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaCorinthiansFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return corinthiansFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}