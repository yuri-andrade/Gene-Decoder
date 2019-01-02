package com.study.oop.creator;

import com.study.oop.entity.Gene;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe que realiza a criação de um gene conforme uma linha de cabeçalho.
 *
 * @author <a href="mailto:yuri.arend@acad.pucrs.br">yuri.arend</a>
 * @since 29/12/2018 04:33:00
 */
public class GeneCreator {
    private GeneCreator() {
    }

    /**
     * Extrai os dados de uma linha de cabeçalho para iniciar um gene novo.
     *
     * @param line linha do arquivo FASTA
     * @return gene iniciado
     */
    public static Gene create(String line) {
        Pattern pattern = Pattern.compile("\\[locus_tag=(.*?)].*\\[location=(\\d+)\\D*(\\d+)]");
        Gene gene = new Gene();
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            gene.setLocus(matcher.group(1));
            gene.setBegin(Long.parseLong(matcher.group(2)));
            gene.setEnd(Long.parseLong(matcher.group(3)));
        }
        return gene;
    }
}
