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

public class CuiabaCasaA2022Adapter extends RecyclerView.Adapter<CuiabaCasaA2022Adapter.ViewHolder> {
    private List<Partida> cuiabaCasa2022;

    public CuiabaCasaA2022Adapter(List<Partida> cuiabaCasa2022) {
        this.cuiabaCasa2022 = cuiabaCasa2022;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
        DadosPartidasAdapterBinding binding = DadosPartidasAdapterBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Context context = holder.itemView.getContext();

        Partida listaPartidaCuiabaCasa = cuiabaCasa2022.get(position);

        holder.binding.tvNomeTime.setText(listaPartidaCuiabaCasa.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaCuiabaCasa.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaCuiabaCasa.getDate());
        holder.binding.tvNomeCasa.setText(listaPartidaCuiabaCasa.getHomeTime().getNome());
        holder.binding.tvNomeFora.setText(listaPartidaCuiabaCasa.getAwayTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaCuiabaCasa.getHomeTime().getClassificacao()));
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaCuiabaCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaCuiabaCasa.getHomeTime().getPlacar()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaCuiabaCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaCuiabaCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        Glide.with(context).load(listaPartidaCuiabaCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        //DADOS DO JOGO

        //DADOS TIME CASA

        //DADOS TIME FORA

    }

    @Override
    public int getItemCount() {
        return cuiabaCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
