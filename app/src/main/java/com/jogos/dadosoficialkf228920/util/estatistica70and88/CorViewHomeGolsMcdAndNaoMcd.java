package com.jogos.dadosoficialkf228920.util.estatistica70and88;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

public class CorViewHomeGolsMcdAndNaoMcd {

    public static SpannableStringBuilder formatTextHomeMarcou(String mercado, String name, long porcentagem, int repeticos, int totalJogos) {
        SpannableStringBuilder builder = new SpannableStringBuilder();

        // Adiciona "CASA" com cor azul
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



        //FORMATACAO GOLS MARCADOS 1T
        if(mercado.equals("homeGolsTotalPrimeiroTempoZeroCincoMarcados") ){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 1T > 0.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("homeGolsTotalPrimeiroTempoUmCincoMarcados") ){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 1T > 1.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("homeGolsTotalPrimeiroTempoDoisCincoMarcados") ){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 1T > 2.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }

        //FORMATACAO GOLS MARCADOS 2T
        else if(mercado.equals("homeGolsTotalSegundoTempoZeroCincoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 2T > 0.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("homeGolsTotalSegundoTempoUmCincoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 2T > 1.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("homeGolsTotalSegundoTempoDoisCincoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 2T > 2.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }

        //FORMATACAO GOLS MARCADOS TOTAL
        else if(mercado.equals("homeGolsTotalZeroCincoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol Total > 0.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("homeGolsTotalUmCincoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol Total > 1.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("homeGolsTotalDoisCincoMarcados")){
            String textoPorcentagem = " Gol TOTAL > 2.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("homeGolsTotalTresCincoMarcados")){
            String textoPorcentagem = " Gol TOTAL > 3.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }

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

    public static SpannableStringBuilder formatTextHomeNaoMarcou(String mercado, String name, long porcentagem, int repeticos, int totalJogos) {
        SpannableStringBuilder builder = new SpannableStringBuilder();


        // Adiciona "CASA" com cor azul
        String nameCasa = "[" + name + " CASA]";
        builder.append(nameCasa);
        builder.setSpan(new ForegroundColorSpan(0xFF0000FF), 0, nameCasa.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Adiciona espaço
        builder.append(" ");

        // Adiciona "NÃO MARCOU" com cor vermelho
        String naoMarcou = "[NÃO MARCOU]";
        int startNaoMarcou = builder.length();
        builder.append(naoMarcou);
        builder.setSpan(new ForegroundColorSpan(0xFFFF0000), startNaoMarcou, startNaoMarcou + naoMarcou.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        //FORMATACAO GOLS NAO MARCADOS 1T
        if(mercado.equals("homeGolsTotalPrimeiroTempoZeroCincoNaoMarcados") ){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 1T > 0.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("homeGolsTotalPrimeiroTempoUmCincoNaoMarcados") ){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 1T > 1.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("homeGolsTotalPrimeiroTempoDoisCincoNaoMarcados") ){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 1T > 2.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }

        //FORMATACAO GOLS NAO MARCADOS  2T
        else if(mercado.equals("homeGolsTotalSegundoTempoZeroCincoNaoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 2T > 0.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("homeGolsTotalSegundoTempoUmCincoNaoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 2T > 1.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("homeGolsTotalSegundoTempoDoisCincoNaoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 2T > 2.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }

        //FORMATACAO GOLS NAO MARCADOS  TOTAL
        else if(mercado.equals("homeGolsTotalZeroCincoNaoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol Total > 0.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("homeGolsTotalUmCincoNaoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol Total > 1.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("homeGolsTotalDoisCincoNaoMarcados")){
            String textoPorcentagem = " Gol TOTAL > 2.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("homeGolsTotalTresCincoNaoMarcados")){
            String textoPorcentagem = " Gol TOTAL > 3.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }

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
