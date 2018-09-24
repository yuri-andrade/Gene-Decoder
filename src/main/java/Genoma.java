import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe que implementa um {@link Genoma}.
 *
 * @author <a href="mailto:yuri.arend@acad.pucrs.br">yuri.arend</a>
 * @since 15/09/2018 14:37:00
 */
public class Genoma {
    private Map<String, Gene> genoma;

    public Genoma(String filePath) {
        genoma = new TreeMap<>();
        try {
            loadDataFrom(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Gene> getGenoma() {
        return genoma;
    }

    /**
     * Método que efetua a leitura de um arquivo FASTA e faz a montagem do genoma
     * conforme faz a leitura dos genes no arquivo.
     *
     * @param filePath caminho do arquivo FASTA no disco
     * @throws FileNotFoundException exception caso não encontre o arquivo no caminho especificado
     */
    private void loadDataFrom(File filePath) throws FileNotFoundException {
        if (filePath == null) {
            return;
        }

        Pattern pattern = Pattern.compile("(\\[(.*?)\\])");
        Pattern patternLocation = Pattern.compile("(\\[location=(\\d+)..(\\d+)\\])");
        Pattern patternLocusTag = Pattern.compile("(\\[locus_tag=(.*?)\\])");

        Scanner data = new Scanner(filePath);
        boolean first = true;
        String locusTag = null;
        long begin = -1;
        long end = -1;
        List<Character> dnaBasesSequence = new ArrayList<>();
        String line;

        while (data.hasNextLine()) {
            line = data.nextLine();
            if (isHeaderLine(line)) {
                if (first) {
                    first = false;
                } else {
                    addGeneInGenoma(locusTag, begin, end, dnaBasesSequence);
                    locusTag = "";
                    begin = -1;
                    end = -1;
                    dnaBasesSequence.clear();
                }
                Matcher patternMatcher = pattern.matcher(line);
                while (patternMatcher.find()) {
                    String token = patternMatcher.group(1);
                    Matcher patterLocationMatcher = patternLocation.matcher(token);
                    if (patterLocationMatcher.matches()) {
                        begin = Long.parseLong(patterLocationMatcher.group(2));
                        end = Long.parseLong(patterLocationMatcher.group(3));
                    } else {
                        Matcher patternLocusTagMatcher = patternLocusTag.matcher(token);
                        if (patternLocusTagMatcher.matches()) {
                            locusTag = patternLocusTagMatcher.group(2);
                        }
                    }
                }
            } else {
                mountSequence(dnaBasesSequence, line);
            }

        }
        addGeneInGenoma(locusTag, begin, end, dnaBasesSequence);
    }

    /**
     * Método que adiciona o Gene lido no arquivo FASTA para dentro do Genoma.
     *
     * @param locus    locus tag do gene extraída do arquivo FASTA
     * @param begin    início de DNA do gene extraída do arquivo FASTA
     * @param end      final do DNA do gene extraída do arquivo FASTA
     * @param sequence sequência de DNA do gene extraída do arquivo FASTA
     */
    private void addGeneInGenoma(String locus, long begin, long end, List<Character> sequence) {
        Gene gene = new Gene(locus, begin, end, sequence);
        genoma.put(locus, gene);
    }

    /**
     * Método que monta a sequência de DNA do gene caractere à caractere da linha.
     *
     * @param sequence lista onde serão adicionados os DNAS
     * @param line     linha atual do arquivo FASTA
     */
    private void mountSequence(List<Character> sequence, String line) {
        for (int i = 0; i < line.length(); i++) {
            sequence.add(line.charAt(i));
        }
    }

    /**
     * Método para verificar se a linha atual do arquivo FASTA corresponde a
     * uma linha de cabeçalho.
     *
     * @param line linha a ser verificada
     * @return true caso seja uma linha de cabeçalho de gene.
     */
    private boolean isHeaderLine(String line) {
        return (line.length() > 0 && Objects.equals('>', line.charAt(0))) ? true : false;
    }
}