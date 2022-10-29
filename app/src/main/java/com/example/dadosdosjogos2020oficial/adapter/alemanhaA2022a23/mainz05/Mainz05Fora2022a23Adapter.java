package com.example.dadosdosjogos2020oficial.adapter.alemanhaA2022a23.mainz05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dadosdosjogos2020oficial.R;
import com.example.dadosdosjogos2020oficial.databinding.DadosPartidasAdapterBinding;
import com.example.dadosdosjogos2020oficial.model.Partida;

import java.util.List;

public class Mainz05Fora2022a23Adapter extends RecyclerView.Adapter<Mainz05Fora2022a23Adapter.ViewHolder> {

    private List<Partida> mainz05Fora2022_23;

    public Mainz05Fora2022a23Adapter(List<Partida> mainz05Fora2022_23) {
        this.mainz05Fora2022_23 = mainz05Fora2022_23;
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

        Partida listaPartidaMain05Fora = mainz05Fora2022_23.get(position);

        //DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaMain05Fora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaMain05Fora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaMain05Fora.getDate());

        holder.binding.tvEscanteiosTotalPrimeiroTempo.setText(String.valueOf(listaPartidaMain05Fora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaMain05Fora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvEscanteiosTotalSegundoTempo.setText(String.valueOf(listaPartidaMain05Fora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaMain05Fora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        int escanteiosPrimeiroTempo = listaPartidaMain05Fora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaMain05Fora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo();
        int escanteiosSegundoTempo = listaPartidaMain05Fora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaMain05Fora.getAwayEstatisticaJogo().getEscanteioSegundoTempo();
        holder.binding.tvEscanteiosTotal.setText(String.valueOf(escanteiosPrimeiroTempo + escanteiosSegundoTempo));

        holder.binding.tvGolsTotalPrimeiroTempo.setText(String.valueOf(listaPartidaMain05Fora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaMain05Fora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvGolsTotalSegundoTempo.setText(String.valueOf(listaPartidaMain05Fora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaMain05Fora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        int golsPrimeiroTempo = listaPartidaMain05Fora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaMain05Fora.getAwayEstatisticaJogo().getGolsPrimeiroTempo();
        int golsSegundtoTempo = listaPartidaMain05Fora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaMain05Fora.getAwayEstatisticaJogo().getGolsSegundoTempo();
        holder.binding.tvGolsTotal.setText(String.valueOf(golsPrimeiroTempo + golsSegundtoTempo));

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaMain05Fora.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaMain05Fora.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaMain05Fora.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaMain05Fora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        holder.binding.tvCasaEscanteiosTres.setText(listaPartidaMain05Fora.getHomeTimeEscanteios().getThree());
        holder.binding.tvCasaEscanteiosCinco.setText(listaPartidaMain05Fora.getHomeTimeEscanteios().getFive());
        holder.binding.tvCasaEscanteiosSete.setText(listaPartidaMain05Fora.getHomeTimeEscanteios().getSeven());
        holder.binding.tvCasaEscanteiosNove.setText(listaPartidaMain05Fora.getHomeTimeEscanteios().getNine());

        holder.binding.tvCasaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaMain05Fora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvCasaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaMain05Fora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvCasaEscanteiosTotal.setText(String.valueOf(listaPartidaMain05Fora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaMain05Fora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvCasaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaMain05Fora.getHomeEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvCasaGolsSegundoTempo.setText(String.valueOf(listaPartidaMain05Fora.getHomeEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvCasaGolsTotal.setText(String.valueOf(listaPartidaMain05Fora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaMain05Fora.getHomeEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaMain05Fora.getHomeTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaMain05Fora.getHomeTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaMain05Fora.getHomeTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaMain05Fora.getHomeTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaMain05Fora.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaMain05Fora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaMain05Fora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaMain05Fora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        holder.binding.tvForaEscanteiosTres.setText(listaPartidaMain05Fora.getAwayTimeEscanteios().getThree());
        holder.binding.tvForaEscanteiosCinco.setText(listaPartidaMain05Fora.getAwayTimeEscanteios().getFive());
        holder.binding.tvForaEscanteiosSete.setText(listaPartidaMain05Fora.getAwayTimeEscanteios().getSeven());
        holder.binding.tvForaEscanteiosNove.setText(listaPartidaMain05Fora.getAwayTimeEscanteios().getNine());

        holder.binding.tvForaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaMain05Fora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvForaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaMain05Fora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvForaEscanteiosTotal.setText(String.valueOf(listaPartidaMain05Fora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaMain05Fora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvForaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaMain05Fora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvForaGolsSegundoTempo.setText(String.valueOf(listaPartidaMain05Fora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvForaGolsTotal.setText(String.valueOf(listaPartidaMain05Fora.getAwayEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaMain05Fora.getAwayEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaMain05Fora.getAwayTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaMain05Fora.getAwayTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaMain05Fora.getAwayTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaMain05Fora.getAwayTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);

    }

    @Override
    public int getItemCount() {
        return mainz05Fora2022_23.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

