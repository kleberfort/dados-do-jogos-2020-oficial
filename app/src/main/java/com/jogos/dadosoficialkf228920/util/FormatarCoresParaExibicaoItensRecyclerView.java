package com.jogos.dadosoficialkf228920.util;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

public class FormatarCoresParaExibicaoItensRecyclerView {

    public static SpannableStringBuilder formateTextMarcou(String mercado, String name, long porcentagem, int repeticos, int totalJogos) {
        SpannableStringBuilder builder = new SpannableStringBuilder();

        // Adiciona "FORTALEZA CASA" com cor azul
        String nameCasa = "[" + name + " CASA]";
        builder.append(nameCasa);
        builder.setSpan(new ForegroundColorSpan(0xFF0000FF), 0, nameCasa.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Adiciona espaço
        builder.append(" ");

        // Adiciona "MARCOU" com cor verde
        String marcou = "[MARCOU]";
        int startMarcou = builder.length();
        builder.append(marcou);
        builder.setSpan(new ForegroundColorSpan(0xFF00FF00), startMarcou, startMarcou + marcou.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        if(mercado.equals("homeGolsTotalZeroCincoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol Total > 0.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }
        if(mercado.equals("homeGolsTotalUmCincoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol Total > 1.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }



//        if(mercado.equals("homeGolsTotalZeroCincoNaoMarcados")){
//            // Adiciona "NÃO MARCOU" com cor verde
//            String naoMarcou = "[NÃO MARCOU]";
//            int startNaoMarcou = builder.length();
//            builder.append(naoMarcou);
//            builder.setSpan(new ForegroundColorSpan(0xFFFF0000), startNaoMarcou, startNaoMarcou + naoMarcou.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            // Adiciona o texto com porcentagem
//            String textoPorcentagem = " Gol Total > 0.5 em " + porcentagem + "% das partidas (";
//            builder.append(textoPorcentagem);
//        }

        // Adiciona "repeticos" com cor azul
        int startRepeticos = builder.length();
        builder.append(String.valueOf(repeticos));
        builder.setSpan(new ForegroundColorSpan(0xFF0000FF), startRepeticos, builder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Adiciona texto intermediário
        String textoIntermediario = ") de ";
        builder.append(textoIntermediario);

        // Adiciona "totalJogos" com cor azul
        int startTotalJogos = builder.length();
        builder.append(String.valueOf(totalJogos));
        builder.setSpan(new ForegroundColorSpan(0xFF0000FF), startTotalJogos, builder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Finaliza o texto
        String textoFinal = ".";
        builder.append(textoFinal);

        // Aplica negrito em toda a string
        builder.setSpan(new StyleSpan(Typeface.BOLD), 0, builder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return builder;
    }

}
