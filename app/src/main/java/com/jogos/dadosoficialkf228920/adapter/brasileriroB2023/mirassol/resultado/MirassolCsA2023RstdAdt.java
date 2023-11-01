package com.jogos.dadosoficialkf228920.adapter.brasileriroB2023.mirassol.resultado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf228920.databinding.LayoutResultadoPartidasBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

public class MirassolCsA2023RstdAdt extends RecyclerView.Adapter<MirassolCsA2023RstdAdt.ViewHolder> {

    private List<Partida> jogosCasa;


    public MirassolCsA2023RstdAdt(List<Partida> jogosCasa) {
        this.jogosCasa = jogosCasa;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LayoutResultadoPartidasBinding binding = LayoutResultadoPartidasBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        Partida listaJogos = jogosCasa.get(position);


        //DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaJogos.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaJogos.getRound()));
        holder.binding.tvDataJogo.setText(listaJogos.getDate());

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaJogos.getHomeTime().getNome());
        holder.binding.tvClassificacaoCasa.setText(String.valueOf(listaJogos.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaJogos.getHomeTime().getPlacar()));
        Glide.with(context).load(listaJogos.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);


        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaJogos.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaJogos.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaJogos.getAwayTime().getPlacar()));
        Glide.with(context).load(listaJogos.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);


    }

    @Override
    public int getItemCount() {
        return jogosCasa.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private LayoutResultadoPartidasBinding binding;

        public ViewHolder(LayoutResultadoPartidasBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }


}
