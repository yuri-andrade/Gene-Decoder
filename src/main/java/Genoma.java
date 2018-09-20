import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe que implementa um {@link Genoma} a partir de um arquivo de entrada.
 *
 * @author <a href="mailto:yuri.arend@acad.pucrs.br">yuri.arend</a>
 * @since 15/09/2018 14:37:00
 */
public class Genoma {
    private Map<String, Gene> genoma;

    public Genoma(String filePath) {
        genoma = new HashMap<>();
        try {
            loadDataFrom(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Gene> getGenoma() {
        return genoma;
    }

    private void loadDataFrom(File filePath) throws FileNotFoundException {
        if (filePath == null) {
            return;
        }

        Pattern pattern = Pattern.compile("(\\[(.*?)])");
        Pattern patloc = Pattern.compile("(\\[location=(\\d+)..(\\d+)])");
        Pattern patLocus = Pattern.compile("(\\[locus_tag=(.*?)])");

        Scanner data = new Scanner(filePath);

        String locus = "";
        long begin = -1;
        long end = -1;
        List<Character> sequence = new ArrayList<>();

        while (data.hasNextLine()) {
            String line = data.nextLine();
            // Se � uma linha de cabe�alho ...
            if (line.length() > 0 && Objects.equals('>', line.charAt(0))) {
                if (begin != -1) { // Se j� tem um Gene para montar, monta e armazena
                    locus = "";
                    begin = -1;
                    end = -1;
                    sequence = new ArrayList<>();
                }
                Matcher matcher = pattern.matcher(line);
                // Procura pelos dados
                while (matcher.find()) {
                    String token = matcher.group(1);
                    Matcher matchLoc = patloc.matcher(token);
                    if (matchLoc.matches()) {
                        begin = Long.parseLong(matchLoc.group(2));
                        end = Long.parseLong(matchLoc.group(3));
                    } else {
                        Matcher matchLocus = patLocus.matcher(token);
                        if (matchLocus.matches()) {
                            locus = matchLocus.group(2);
                        }
                    }
                }
            } else { // Se � uma linha de sequencia de gene ...
                for (int i = 0; i < line.length(); i++) {
                    sequence.add(line.charAt(i));
                }
            }
            Gene gene = new Gene(locus, begin, end, sequence);
            genoma.put(locus, gene); // Adiciona o gene no genoma com locus de key e gene como valor
        }
    }

}