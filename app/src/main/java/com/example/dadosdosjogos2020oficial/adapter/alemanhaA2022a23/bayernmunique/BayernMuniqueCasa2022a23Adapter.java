package com.example.dadosdosjogos2020oficial.adapter.alemanhaA2022a23.bayernmunique;

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

public class BayernMuniqueCasa2022a23Adapter extends RecyclerView.Adapter<BayernMuniqueCasa2022a23Adapter.ViewHolder> {

    private List<Partida> bayerMuniqueCasa2022_23;

    public BayernMuniqueCasa2022a23Adapter(List<Partida> bayerMuniqueCasa2022_23) {
        this.bayerMuniqueCasa2022_23 = bayerMuniqueCasa2022_23;
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

        Partida listaPartidaBayerMuniqueCasa = bayerMuniqueCasa2022_23.get(position);

        //DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaBayerMuniqueCasa.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaBayerMuniqueCasa.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaBayerMuniqueCasa.getDate());

        holder.binding.tvEscanteiosTotalPrimeiroTempo.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBayerMuniqueCasa.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvEscanteiosTotalSegundoTempo.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaBayerMuniqueCasa.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        int escanteiosPrimeiroTempo = listaPartidaBayerMuniqueCasa.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBayerMuniqueCasa.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo();
        int escanteiosSegundoTempo = listaPartidaBayerMuniqueCasa.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaBayerMuniqueCasa.getAwayEstatisticaJogo().getEscanteioSegundoTempo();
        holder.binding.tvEscanteiosTotal.setText(String.valueOf(escanteiosPrimeiroTempo + escanteiosSegundoTempo));

        holder.binding.tvGolsTotalPrimeiroTempo.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBayerMuniqueCasa.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvGolsTotalSegundoTempo.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaBayerMuniqueCasa.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        int golsPrimeiroTempo = listaPartidaBayerMuniqueCasa.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBayerMuniqueCasa.getAwayEstatisticaJogo().getGolsPrimeiroTempo();
        int golsSegundtoTempo = listaPartidaBayerMuniqueCasa.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaBayerMuniqueCasa.getAwayEstatisticaJogo().getGolsSegundoTempo();
        holder.binding.tvGolsTotal.setText(String.valueOf(golsPrimeiroTempo + golsSegundtoTempo));

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaBayerMuniqueCasa.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaBayerMuniqueCasa.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        holder.binding.tvCasaEscanteiosTres.setText(listaPartidaBayerMuniqueCasa.getHomeTimeEscanteios().getThree());
        holder.binding.tvCasaEscanteiosCinco.setText(listaPartidaBayerMuniqueCasa.getHomeTimeEscanteios().getFive());
        holder.binding.tvCasaEscanteiosSete.setText(listaPartidaBayerMuniqueCasa.getHomeTimeEscanteios().getSeven());
        holder.binding.tvCasaEscanteiosNove.setText(listaPartidaBayerMuniqueCasa.getHomeTimeEscanteios().getNine());

        holder.binding.tvCasaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvCasaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvCasaEscanteiosTotal.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBayerMuniqueCasa.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvCasaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getHomeEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvCasaGolsSegundoTempo.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getHomeEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvCasaGolsTotal.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBayerMuniqueCasa.getHomeEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaBayerMuniqueCasa.getHomeTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerMuniqueCasa.getHomeTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerMuniqueCasa.getHomeTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerMuniqueCasa.getHomeTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaBayerMuniqueCasa.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaBayerMuniqueCasa.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        holder.binding.tvForaEscanteiosTres.setText(listaPartidaBayerMuniqueCasa.getAwayTimeEscanteios().getThree());
        holder.binding.tvForaEscanteiosCinco.setText(listaPartidaBayerMuniqueCasa.getAwayTimeEscanteios().getFive());
        holder.binding.tvForaEscanteiosSete.setText(listaPartidaBayerMuniqueCasa.getAwayTimeEscanteios().getSeven());
        holder.binding.tvForaEscanteiosNove.setText(listaPartidaBayerMuniqueCasa.getAwayTimeEscanteios().getNine());

        holder.binding.tvForaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvForaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvForaEscanteiosTotal.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBayerMuniqueCasa.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvForaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvForaGolsSegundoTempo.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvForaGolsTotal.setText(String.valueOf(listaPartidaBayerMuniqueCasa.getAwayEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBayerMuniqueCasa.getAwayEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaBayerMuniqueCasa.getAwayTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerMuniqueCasa.getAwayTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerMuniqueCasa.getAwayTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerMuniqueCasa.getAwayTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);

    }

    @Override
    public int getItemCount() {
        return bayerMuniqueCasa2022_23.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

