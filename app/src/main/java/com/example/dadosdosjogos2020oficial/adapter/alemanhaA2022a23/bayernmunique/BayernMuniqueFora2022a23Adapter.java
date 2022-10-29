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

public class BayernMuniqueFora2022a23Adapter extends RecyclerView.Adapter<BayernMuniqueFora2022a23Adapter.ViewHolder> {

    private List<Partida> bayerMuniqueFora2022_23;

    public BayernMuniqueFora2022a23Adapter(List<Partida> bayerMuniqueFora2022_23) {
        this.bayerMuniqueFora2022_23 = bayerMuniqueFora2022_23;
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

        Partida listaPartidaBayerMuniqueFora = bayerMuniqueFora2022_23.get(position);

        //DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaBayerMuniqueFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaBayerMuniqueFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaBayerMuniqueFora.getDate());

        holder.binding.tvEscanteiosTotalPrimeiroTempo.setText(String.valueOf(listaPartidaBayerMuniqueFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBayerMuniqueFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvEscanteiosTotalSegundoTempo.setText(String.valueOf(listaPartidaBayerMuniqueFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaBayerMuniqueFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        int escanteiosPrimeiroTempo = listaPartidaBayerMuniqueFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBayerMuniqueFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo();
        int escanteiosSegundoTempo = listaPartidaBayerMuniqueFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaBayerMuniqueFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo();
        holder.binding.tvEscanteiosTotal.setText(String.valueOf(escanteiosPrimeiroTempo + escanteiosSegundoTempo));

        holder.binding.tvGolsTotalPrimeiroTempo.setText(String.valueOf(listaPartidaBayerMuniqueFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBayerMuniqueFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvGolsTotalSegundoTempo.setText(String.valueOf(listaPartidaBayerMuniqueFora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaBayerMuniqueFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        int golsPrimeiroTempo = listaPartidaBayerMuniqueFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBayerMuniqueFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo();
        int golsSegundtoTempo = listaPartidaBayerMuniqueFora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaBayerMuniqueFora.getAwayEstatisticaJogo().getGolsSegundoTempo();
        holder.binding.tvGolsTotal.setText(String.valueOf(golsPrimeiroTempo + golsSegundtoTempo));

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaBayerMuniqueFora.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaBayerMuniqueFora.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaBayerMuniqueFora.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaBayerMuniqueFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        holder.binding.tvCasaEscanteiosTres.setText(listaPartidaBayerMuniqueFora.getHomeTimeEscanteios().getThree());
        holder.binding.tvCasaEscanteiosCinco.setText(listaPartidaBayerMuniqueFora.getHomeTimeEscanteios().getFive());
        holder.binding.tvCasaEscanteiosSete.setText(listaPartidaBayerMuniqueFora.getHomeTimeEscanteios().getSeven());
        holder.binding.tvCasaEscanteiosNove.setText(listaPartidaBayerMuniqueFora.getHomeTimeEscanteios().getNine());

        holder.binding.tvCasaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaBayerMuniqueFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvCasaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaBayerMuniqueFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvCasaEscanteiosTotal.setText(String.valueOf(listaPartidaBayerMuniqueFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBayerMuniqueFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvCasaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaBayerMuniqueFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvCasaGolsSegundoTempo.setText(String.valueOf(listaPartidaBayerMuniqueFora.getHomeEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvCasaGolsTotal.setText(String.valueOf(listaPartidaBayerMuniqueFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBayerMuniqueFora.getHomeEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaBayerMuniqueFora.getHomeTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerMuniqueFora.getHomeTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerMuniqueFora.getHomeTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerMuniqueFora.getHomeTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaBayerMuniqueFora.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaBayerMuniqueFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaBayerMuniqueFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaBayerMuniqueFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        holder.binding.tvForaEscanteiosTres.setText(listaPartidaBayerMuniqueFora.getAwayTimeEscanteios().getThree());
        holder.binding.tvForaEscanteiosCinco.setText(listaPartidaBayerMuniqueFora.getAwayTimeEscanteios().getFive());
        holder.binding.tvForaEscanteiosSete.setText(listaPartidaBayerMuniqueFora.getAwayTimeEscanteios().getSeven());
        holder.binding.tvForaEscanteiosNove.setText(listaPartidaBayerMuniqueFora.getAwayTimeEscanteios().getNine());

        holder.binding.tvForaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaBayerMuniqueFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvForaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaBayerMuniqueFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvForaEscanteiosTotal.setText(String.valueOf(listaPartidaBayerMuniqueFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaBayerMuniqueFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvForaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaBayerMuniqueFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvForaGolsSegundoTempo.setText(String.valueOf(listaPartidaBayerMuniqueFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvForaGolsTotal.setText(String.valueOf(listaPartidaBayerMuniqueFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaBayerMuniqueFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaBayerMuniqueFora.getAwayTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerMuniqueFora.getAwayTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerMuniqueFora.getAwayTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaBayerMuniqueFora.getAwayTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);

    }

    @Override
    public int getItemCount() {
        return bayerMuniqueFora2022_23.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

