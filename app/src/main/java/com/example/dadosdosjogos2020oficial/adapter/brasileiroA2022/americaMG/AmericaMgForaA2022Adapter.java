package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.americaMG;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class AmericaMgForaA2022Adapter extends RecyclerView.Adapter<AmericaMgForaA2022Adapter.ViewHolder> {

    private List<Partida> americaMgFora2022;

    public AmericaMgForaA2022Adapter(List<Partida> americaMgFora2022) {
        this.americaMgFora2022 = americaMgFora2022;
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

        Partida listaPartidaAmericaMgFora = americaMgFora2022.get(position);

        //DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaAmericaMgFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaAmericaMgFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaAmericaMgFora.getDate());

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaAmericaMgFora.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaAmericaMgFora.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaAmericaMgFora.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaAmericaMgFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        holder.binding.tvCasaEscanteiosTres.setText(listaPartidaAmericaMgFora.getHomeTimeEscanteios().getThree());
        holder.binding.tvCasaEscanteiosCinco.setText(listaPartidaAmericaMgFora.getHomeTimeEscanteios().getFive());
        holder.binding.tvCasaEscanteiosSete.setText(listaPartidaAmericaMgFora.getHomeTimeEscanteios().getSeven());
        holder.binding.tvCasaEscanteiosNove.setText(listaPartidaAmericaMgFora.getHomeTimeEscanteios().getNine());

        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaAmericaMgFora.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaAmericaMgFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaAmericaMgFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaAmericaMgFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        holder.binding.tvForaEscanteiosTres.setText(listaPartidaAmericaMgFora.getAwayTimeEscanteios().getThree());
        holder.binding.tvForaEscanteiosCinco.setText(listaPartidaAmericaMgFora.getAwayTimeEscanteios().getFive());
        holder.binding.tvForaEscanteiosSete.setText(listaPartidaAmericaMgFora.getAwayTimeEscanteios().getSeven());
        holder.binding.tvForaEscanteiosNove.setText(listaPartidaAmericaMgFora.getAwayTimeEscanteios().getNine());







    }

    @Override
    public int getItemCount() {
        return americaMgFora2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
