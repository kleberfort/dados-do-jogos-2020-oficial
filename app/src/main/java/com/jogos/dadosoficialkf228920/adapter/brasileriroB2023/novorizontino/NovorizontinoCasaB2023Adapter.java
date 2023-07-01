package com.jogos.dadosoficialkf228920.adapter.brasileriroB2023.novorizontino;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jogos.dadosoficialkf228920.R;
import com.jogos.dadosoficialkf228920.databinding.ListaJogosEstatisticaCartoesAdapterBinding;
import com.jogos.dadosoficialkf228920.model.Partida;

import java.util.List;

public class NovorizontinoCasaB2023Adapter extends RecyclerView.Adapter<NovorizontinoCasaB2023Adapter.ViewHolder> {

    private List<Partida> novorizontinoCasa;

    public NovorizontinoCasaB2023Adapter(List<Partida> novorizontinoCasa) {
        this.novorizontinoCasa = novorizontinoCasa;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListaJogosEstatisticaCartoesAdapterBinding binding = ListaJogosEstatisticaCartoesAdapterBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        Context context = holder.itemView.getContext();

        Partida listaPartidaNovorizontinoCasa
 = novorizontinoCasa.get(position);

        //DADOS DO JOGO
        holder.binding.tvNomeTime.setText(listaPartidaNovorizontinoCasa
.getName());
        holder.binding.tvRodada.setText("Rodada: " + String.valueOf(listaPartidaNovorizontinoCasa
.getRound()));
        holder.binding.tvDataJogo.setText(listaPartidaNovorizontinoCasa
.getDate());

        /* Cartoes */
        holder.binding.cartaoAmrlCs.setText(String.valueOf(listaPartidaNovorizontinoCasa.getHomeCartoes().getAmarelo()));
        holder.binding.cartaoAmrlFr.setText(String.valueOf(listaPartidaNovorizontinoCasa.getAwayCartoes().getAmarelo()));
        holder.binding.cartaoVmlCs.setText(String.valueOf(listaPartidaNovorizontinoCasa.getHomeCartoes().getVermelho()));
        holder.binding.cartaoVmlFr.setText(String.valueOf(listaPartidaNovorizontinoCasa.getAwayCartoes().getVermelho()));
        holder.binding.cartaoTotalAmrl.setText(String.valueOf(listaPartidaNovorizontinoCasa.getHomeCartoes().getAmarelo() + listaPartidaNovorizontinoCasa.getAwayCartoes().getAmarelo()));
        holder.binding.cartaoTotalVml.setText(String.valueOf(listaPartidaNovorizontinoCasa.getHomeCartoes().getVermelho() + listaPartidaNovorizontinoCasa.getAwayCartoes().getVermelho()));

        holder.binding.tvEscanteiosTotalPrimeiroTempo.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaNovorizontinoCasa
.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvEscanteiosTotalSegundoTempo.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaNovorizontinoCasa
.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        int escanteiosPrimeiroTempo = listaPartidaNovorizontinoCasa
.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaNovorizontinoCasa
.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo();
        int escanteiosSegundoTempo = listaPartidaNovorizontinoCasa
.getHomeEstatisticaJogo().getEscanteioSegundoTempo() + listaPartidaNovorizontinoCasa
.getAwayEstatisticaJogo().getEscanteioSegundoTempo();
        holder.binding.tvEscanteiosTotal.setText(String.valueOf(escanteiosPrimeiroTempo + escanteiosSegundoTempo));

        holder.binding.tvGolsTotalPrimeiroTempo.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaNovorizontinoCasa
.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvGolsTotalSegundoTempo.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaNovorizontinoCasa
.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        int golsPrimeiroTempo = listaPartidaNovorizontinoCasa
.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaNovorizontinoCasa
.getAwayEstatisticaJogo().getGolsPrimeiroTempo();
        int golsSegundtoTempo = listaPartidaNovorizontinoCasa
.getHomeEstatisticaJogo().getGolsSegundoTempo() + listaPartidaNovorizontinoCasa
.getAwayEstatisticaJogo().getGolsSegundoTempo();
        holder.binding.tvGolsTotal.setText(String.valueOf(golsPrimeiroTempo + golsSegundtoTempo));

        //DADOS TIME CASA
        holder.binding.tvNomeCasa.setText(listaPartidaNovorizontinoCasa
.getHomeTime().getNome());
        holder.binding.tvclassicacaoCasa.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getHomeTime().getClassificacao()));
        holder.binding.tvPlacarCasa.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getHomeTime().getPlacar()));
        Glide.with(context).load(listaPartidaNovorizontinoCasa
.getHomeTime().getImagem()).into(holder.binding.ivTimeCasa);

        holder.binding.tvCasaEscanteiosTres.setText(listaPartidaNovorizontinoCasa
.getHomeTimeEscanteios().getThree());
        holder.binding.tvCasaEscanteiosCinco.setText(listaPartidaNovorizontinoCasa
.getHomeTimeEscanteios().getFive());
        holder.binding.tvCasaEscanteiosSete.setText(listaPartidaNovorizontinoCasa
.getHomeTimeEscanteios().getSeven());
        holder.binding.tvCasaEscanteiosNove.setText(listaPartidaNovorizontinoCasa
.getHomeTimeEscanteios().getNine());

        holder.binding.tvCasaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvCasaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvCasaEscanteiosTotal.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getHomeEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaNovorizontinoCasa
.getHomeEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvCasaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getHomeEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvCasaGolsSegundoTempo.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getHomeEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvCasaGolsTotal.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getHomeEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaNovorizontinoCasa
.getHomeEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaNovorizontinoCasa
.getHomeTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaNovorizontinoCasa
.getHomeTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaNovorizontinoCasa
.getHomeTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaNovorizontinoCasa
.getHomeTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvCasaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);


        //DADOS TIME FORA
        holder.binding.tvNomeFora.setText(listaPartidaNovorizontinoCasa
.getAwayTime().getNome());
        holder.binding.tvClassificacaoFora.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getAwayTime().getClassificacao()));
        holder.binding.tvPlacarFora.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getAwayTime().getPlacar()));
        Glide.with(context).load(listaPartidaNovorizontinoCasa
.getAwayTime().getImagem()).into(holder.binding.ivTimeFora);

        holder.binding.tvForaEscanteiosTres.setText(listaPartidaNovorizontinoCasa
.getAwayTimeEscanteios().getThree());
        holder.binding.tvForaEscanteiosCinco.setText(listaPartidaNovorizontinoCasa
.getAwayTimeEscanteios().getFive());
        holder.binding.tvForaEscanteiosSete.setText(listaPartidaNovorizontinoCasa
.getAwayTimeEscanteios().getSeven());
        holder.binding.tvForaEscanteiosNove.setText(listaPartidaNovorizontinoCasa
.getAwayTimeEscanteios().getNine());

        holder.binding.tvForaEscanteiosPrimeiroTempo.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo()));
        holder.binding.tvForaEscanteiosSegundoTempo.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));
        holder.binding.tvForaEscanteiosTotal.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getAwayEstatisticaJogo().getEscanteiosPrimeiroTempo() + listaPartidaNovorizontinoCasa
.getAwayEstatisticaJogo().getEscanteioSegundoTempo()));

        holder.binding.tvForaGolsPrimeiroTempo.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getAwayEstatisticaJogo().getGolsPrimeiroTempo()));
        holder.binding.tvForaGolsSegundoTempo.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getAwayEstatisticaJogo().getGolsSegundoTempo()));
        holder.binding.tvForaGolsTotal.setText(String.valueOf(listaPartidaNovorizontinoCasa
.getAwayEstatisticaJogo().getGolsPrimeiroTempo() + listaPartidaNovorizontinoCasa
.getAwayEstatisticaJogo().getGolsSegundoTempo()));

        if(listaPartidaNovorizontinoCasa
.getAwayTimeEscanteios().getThree().contains("SIM"))
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosTres.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaNovorizontinoCasa
.getAwayTimeEscanteios().getFive().contains("SIM"))
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosCinco.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaNovorizontinoCasa
.getAwayTimeEscanteios().getSeven().contains("SIM"))
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosSete.setBackgroundResource(R.drawable.background_fundo_vermelho);

        if(listaPartidaNovorizontinoCasa
.getAwayTimeEscanteios().getNine().contains("SIM"))
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_verde);
        else
            holder.binding.tvForaEscanteiosNove.setBackgroundResource(R.drawable.background_fundo_vermelho);

    }

    @Override
    public int getItemCount() {
        return novorizontinoCasa.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{



        private ListaJogosEstatisticaCartoesAdapterBinding binding;

        public ViewHolder(ListaJogosEstatisticaCartoesAdapterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
