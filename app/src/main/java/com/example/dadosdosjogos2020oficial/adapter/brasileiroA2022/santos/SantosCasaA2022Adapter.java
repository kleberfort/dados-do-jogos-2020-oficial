package com.example.dadosdosjogos2020oficial.adapter.brasileiroA2022.santos;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class SantosCasaA2022Adapter extends RecyclerView.Adapter<SantosCasaA2022Adapter.ViewHolder> {
    private List<Partida> santosCasa2022;

    public SantosCasaA2022Adapter(List<Partida> santosCasa2022) {
        this.santosCasa2022 = santosCasa2022;
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

        Partida listaPartidaSantosCasa = santosCasa2022.get(position);

        //DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaSantosCasa.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaSantosCasa.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaSantosCasa.getDate());

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaSantosCasa.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaSantosCasa.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaSantosCasa.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaSantosCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);
        holder.binding.tvCasaEscanteiosTres.setText(listaPartidaSantosCasa.getHomeTimeEscanteios().getThree());


           // holder.binding.tvCasaEscanteiosTres.setText(listaPartidaSantosCasa.getHomeTimeEscanteios().getThree());

           // String casaTres = listaPartidaSantosCasa.getHomeTimeEscanteios().getThree();

            if(listaPartidaSantosCasa.getHomeTimeEscanteios().getThree() == "SIM")
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
            else
                holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaSantosCasa.getHomeTimeEscanteios().getFive() == "SIM")
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaSantosCasa.getHomeTimeEscanteios().getSeven() == "SIM")
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaSantosCasa.getHomeTimeEscanteios().getNine() == "SIM")
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);





        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaSantosCasa.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaSantosCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaSantosCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaSantosCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

    }

    @Override
    public int getItemCount() {
        return santosCasa2022.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
