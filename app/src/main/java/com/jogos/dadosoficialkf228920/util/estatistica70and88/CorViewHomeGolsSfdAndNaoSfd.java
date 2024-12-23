package com.jogos.dadosoficialkf228920.util.estatistica70and88;

import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

public class CorViewHomeGolsSfdAndNaoSfd {

    public static SpannableStringBuilder formateTextHomeGolsNaoSofreu(String mercado, String name, long porcentagem, int repeticos, int totalJogos) {
        SpannableStringBuilder builder = new SpannableStringBuilder();

        // Adiciona "CASA" com cor azul
        String nameCasa = "[" + name + " CASA]";
        builder.append(nameCasa);
        builder.setSpan(new ForegroundColorSpan(0xFF0000FF), 0, nameCasa.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Adiciona espaço
        builder.append(" ");

        // Adiciona "[NÃO SOFREU]" com cor verde
        String marcou = "[NÃO SOFREU]";
        int startMarcou = builder.length();
        builder.append(marcou);
        builder.setSpan(new ForegroundColorSpan(0xFF00FF00), startMarcou, startMarcou + marcou.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);



        //FORMATACAO GOLS MARCADOS 1T AWAY
        if(mercado.equals("awayGolsTotalPrimeiroTempoZeroCincoNaoMarcados") ){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 1T > 0.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("awayGolsTotalPrimeiroTempoUmCincoNaoMarcados") ){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 1T > 1.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("awayGolsTotalPrimeiroTempoDoisCincoNaoMarcados")  ){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 1T > 2.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }

        //FORMATACAO GOLS MARCADOS 2T AWAY
        else if(mercado.equals("awayGolsTotalSegundoTempoZeroCincoNaoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 2T > 0.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("awayGolsTotalSegundoTempoUmCincoNaoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 2T > 1.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("awayGolsTotalSegundoTempoDoisCincoNaoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 2T > 2.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }

        //FORMATACAO TOTAL GOLS NAO MARCADOS AWAY
        else if(mercado.equals("awayGolsTotalZeroCincoNaoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol Total > 0.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("awayGolsTotalUmCincoNaoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol Total > 1.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("awayGolsTotalDoisCincoNaoMarcados")){
            String textoPorcentagem = " Gol TOTAL > 2.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("awayGolsTotalTresCincoNaoMarcados")){
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

    public static SpannableStringBuilder formateTextHomeGolsSofreu(String mercado, String name, long porcentagem, int repeticos, int totalJogos) {
        SpannableStringBuilder builder = new SpannableStringBuilder();


        // Adiciona "CASA" com cor azul
        String nameCasa = "[" + name + " CASA]";
        builder.append(nameCasa);
        builder.setSpan(new ForegroundColorSpan(0xFF0000FF), 0, nameCasa.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Adiciona espaço
        builder.append(" ");

        // Adiciona "[ SOFREU]" com cor vermelho
        String naoMarcou = "[SOFREU]";
        int startNaoMarcou = builder.length();
        builder.append(naoMarcou);
        builder.setSpan(new ForegroundColorSpan(0xFFFF0000), startNaoMarcou, startNaoMarcou + naoMarcou.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        //FORMATACAO GOLS NAO MARCADOS 1T AWAY
        if(mercado.equals("awayGolsTotalPrimeiroTempoZeroCincoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 1T > 0.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("awayGolsTotalPrimeiroTempoUmCincoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 1T > 1.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("awayGolsTotalPrimeiroTempoDoisCincoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 1T > 2.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }

        //FORMATACAO GOLS NAO MARCADOS  2T AWAY
        else if(mercado.equals("awayGolsTotalSegundoTempoZeroCincoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 2T > 0.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("awayGolsTotalSegundoTempoUmCincoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 2T > 1.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("awayGolsTotalSegundoTempoDoisCincoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol 2T > 2.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }

        //FORMATACAO GOLS MARCADOS  TOTAL AWAY
        else if(mercado.equals("awayGolsTotalZeroCincoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol Total > 0.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("awayGolsTotalUmCincoMarcados")){
            // Adiciona o texto com porcentagem
            String textoPorcentagem = " Gol Total > 1.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("awayGolsTotalDoisCincoMarcados")){
            String textoPorcentagem = " Gol TOTAL > 2.5 em " + porcentagem + "% das partidas (";
            builder.append(textoPorcentagem);
        }else if(mercado.equals("awayGolsTotalTresCincoMarcados")){
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
