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

public class JuventudeCasaA2022Adapter extends RecyclerView.Adapter<JuventudeCasaA2022Adapter.ViewHolder> {

    private List<Partida> juventudeCasa2022;

    public JuventudeCasaA2022Adapter(List<Partida> juventudeCasa2022) {
        this.juventudeCasa2022 = juventudeCasa2022;
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

        Partida listaPartidaJuventudeCasa = juventudeCasa2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaJuventudeCasa.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaJuventudeCasa.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaJuventudeCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaJuventudeCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaJuventudeCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaJuventudeCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaJuventudeCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaJuventudeCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaJuventudeCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaJuventudeCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaJuventudeCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return juventudeCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
