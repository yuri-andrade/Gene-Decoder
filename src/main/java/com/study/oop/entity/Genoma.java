package com.study.oop.entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe que implementa um {@link Genoma}.
 *
 * @author <a href="mailto:yuri.arend@acad.pucrs.br">yuri.arend</a>
 * @since 15/09/2018 14:37:00
 */
public class Genoma {

    private Map<String, Gene> geneMap;

    public Genoma(String filePath) throws FileNotFoundException {
        geneMap = new TreeMap<>();
        loadDataFrom(new File(filePath));
    }

    public Map<String, Gene> getGeneMap() {
        return geneMap;
    }

    /**
     * Método que efetua a leitura de um arquivo FASTA e faz a montagem do geneMap
     * conforme faz a leitura dos genes no arquivo.
     *
     * @param filePath caminho do arquivo FASTA no disco
     * @throws FileNotFoundException exception caso não encontre o arquivo no caminho especificado
     */
    private void loadDataFrom(File filePath) throws FileNotFoundException {
        Pattern pattern = Pattern.compile("\\[locus_tag=(.*?)\\].*\\[location=(\\d+)\\D*(\\d+)\\]");

        try (Scanner data = new Scanner(filePath)) {
            String locusTag = null;
            long begin = Long.MIN_VALUE;
            long end = Long.MIN_VALUE;
            Gene gene = new Gene();

            while (data.hasNextLine()) {
                String line = data.nextLine();
                if (isHeaderLine(line)) {
                    gene = new Gene();
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        locusTag = matcher.group(1);
                        begin = Long.parseLong(matcher.group(2));
                        end = Long.parseLong(matcher.group(3));
                    }
                } else {
                    gene.setBases(mountSequence(gene, line));
                }
                gene.setLocus(locusTag);
                gene.setBegin(begin);
                gene.setEnd(end);
                addGeneInGenoma(gene);
            }
        }
    }

    private void addGeneInGenoma(Gene gene) {
        geneMap.put(gene.getLocus(), gene);
    }

    /**
     * Monta a sequência de bases do {@link Gene}.
     *
     * @param gene {@link Gene}
     * @param line linha do arquivo FASTA
     * @return lista de bases do gene atualizada
     */
    private List<Character> mountSequence(Gene gene, String line) {
        List<Character> geneBases = gene.getBases();
        for (Character c : line.toCharArray()) {
            geneBases.add(c);
        }
        return geneBases;
    }

    /**
     * Método para verificar se a linha atual do arquivo FASTA corresponde a
     * uma linha de cabeçalho.
     *
     * @param line linha a ser verificada
     * @return true caso seja uma linha de cabeçalho de gene.
     */
    private boolean isHeaderLine(String line) {
        return line.length() > 0 && Objects.equals('>', line.charAt(0));
    }
}