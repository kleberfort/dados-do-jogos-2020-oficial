package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.botafogo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class BotafogoCasaA2022Adapter extends RecyclerView.Adapter<BotafogoCasaA2022Adapter.ViewHolder> {

    private List<Partida> botafogoCasa2022;

    public BotafogoCasaA2022Adapter(List<Partida> botafogoCasa2022) {
        this.botafogoCasa2022 = botafogoCasa2022;
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

        Partida listaPartidaBotafogoCasa = botafogoCasa2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaBotafogoCasa.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaBotafogoCasa.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaBotafogoCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaBotafogoCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaBotafogoCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaBotafogoCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaBotafogoCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaBotafogoCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaBotafogoCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaBotafogoCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaBotafogoCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return botafogoCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}