package com.example.dadosdosjogos2020oficial.adapter.alemanhaA2022a23.unionberlin;

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

public class UnionBerlinFora2022a23Adapter extends RecyclerView.Adapter<UnionBerlinFora2022a23Adapter.ViewHolder> {

    private List<Partida> unionBerlinFora2022_23;

    public UnionBerlinFora2022a23Adapter(List<Partida> unionBerlinFora2022_23) {
        this.unionBerlinFora2022_23 = unionBerlinFora2022_23;
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

        Partida listaPartidaUnionBerlinFora = unionBerlinFora2022_23.get(position);

        //DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaUnionBerlinFora.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaUnionBerlinFora.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaUnionBerlinFora.getDate());

        holder.binding.tvEscanteiosTotalPrimeiroTempo.setText(String.valueOf(listaPartidaUnionBerlinFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaUnionBerlinFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvEscanteiosTotalSegundoTempo.setText(String.valueOf(listaPartidaUnionBerlinFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaUnionBerlinFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        int escanteiosPrimeiroTempo = listaPartidaUnionBerlinFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaUnionBerlinFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo();
        int escanteiosSegundoTempo = listaPartidaUnionBerlinFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaUnionBerlinFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo();
        holder.binding.tvEscanteiosTotal.setText(String.valueOf(escanteiosPrimeiroTempo + escanteiosSegundoTempo));

        holder.binding.tvGolsTotalPrimeiroTempo.setText(String.valueOf(listaPartidaUnionBerlinFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaUnionBerlinFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvGolsTotalSegundoTempo.setText(String.valueOf(listaPartidaUnionBerlinFora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaUnionBerlinFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        int golsPrimeiroTempo = listaPartidaUnionBerlinFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaUnionBerlinFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo();
        int golsSegundtoTempo = listaPartidaUnionBerlinFora.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaUnionBerlinFora.getAwayEstatisticaJogo().getGolsSegundoTempo();
        holder.binding.tvGolsTotal.setText(String.valueOf(golsPrimeiroTempo + golsSegundtoTempo));

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaUnionBerlinFora.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaUnionBerlinFora.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaUnionBerlinFora.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaUnionBerlinFora.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        holder.binding.tvCasaEscanteiosTres.setText(listaPartidaUnionBerlinFora.getHomeTimeEscanteios().getThree());
        holder.binding.tvCasaEscanteiosCinco.setText(listaPartidaUnionBerlinFora.getHomeTimeEscanteios().getFive());
        holder.binding.tvCasaEscanteiosSete.setText(listaPartidaUnionBerlinFora.getHomeTimeEscanteios().getSeven());
        holder.binding.tvCasaEscanteiosNove.setText(listaPartidaUnionBerlinFora.getHomeTimeEscanteios().getNine());

        holder.binding.tvCasaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaUnionBerlinFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvCasaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaUnionBerlinFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvCasaEscanteiosTotal.setText(String.valueOf(listaPartidaUnionBerlinFora.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaUnionBerlinFora.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvCasaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaUnionBerlinFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvCasaGolsSegundoTempo.setText(String.valueOf(listaPartidaUnionBerlinFora.getHomeEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvCasaGolsTotal.setText(String.valueOf(listaPartidaUnionBerlinFora.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaUnionBerlinFora.getHomeEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaUnionBerlinFora.getHomeTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaUnionBerlinFora.getHomeTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaUnionBerlinFora.getHomeTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaUnionBerlinFora.getHomeTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaUnionBerlinFora.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaUnionBerlinFora.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaUnionBerlinFora.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaUnionBerlinFora.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        holder.binding.tvForaEscanteiosTres.setText(listaPartidaUnionBerlinFora.getAwayTimeEscanteios().getThree());
        holder.binding.tvForaEscanteiosCinco.setText(listaPartidaUnionBerlinFora.getAwayTimeEscanteios().getFive());
        holder.binding.tvForaEscanteiosSete.setText(listaPartidaUnionBerlinFora.getAwayTimeEscanteios().getSeven());
        holder.binding.tvForaEscanteiosNove.setText(listaPartidaUnionBerlinFora.getAwayTimeEscanteios().getNine());

        holder.binding.tvForaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaUnionBerlinFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvForaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaUnionBerlinFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvForaEscanteiosTotal.setText(String.valueOf(listaPartidaUnionBerlinFora.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaUnionBerlinFora.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvForaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaUnionBerlinFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvForaGolsSegundoTempo.setText(String.valueOf(listaPartidaUnionBerlinFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvForaGolsTotal.setText(String.valueOf(listaPartidaUnionBerlinFora.getAwayEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaUnionBerlinFora.getAwayEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaUnionBerlinFora.getAwayTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaUnionBerlinFora.getAwayTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaUnionBerlinFora.getAwayTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaUnionBerlinFora.getAwayTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);

    }

    @Override
    public int getItemCount() {
        return unionBerlinFora2022_23.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private DadosPartidasAdapterBinding binding;

        public ViewHolder(DadosPartidasAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

