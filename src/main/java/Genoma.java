import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Genoma {
    private static Genoma instance = null;
    private Map<String, Gene> genoma;

    Genoma() {
        genoma = new HashMap<>();
        try {
            loadData(new File("./src/sequence.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void loadData(File sourceFile) throws FileNotFoundException {
        if (sourceFile == null)
            return;
        Pattern pattern = Pattern.compile("(\\[(.*?)])");
        Pattern patloc = Pattern.compile("(\\[location=(\\d+)..(\\d+)])");
        Pattern patLocus = Pattern.compile("(\\[locus_tag=(.*?)])");
        Scanner data = new Scanner(sourceFile);
        String locus = "";
        long begin = -1;
        long end = -1;
        List<Character> sequence = new ArrayList<>(200);
        // Percorre o arquivo do genoma
        while (data.hasNextLine()) {
            String line = data.nextLine();
            // Se � uma linha de cabe�alho ...
            if (line.length() > 0 && line.charAt(0) == '>') {
                if (begin != -1) { // Se j� tem um Gene para montar, monta e armazena
                    locus = "";
                    begin = -1;
                    end = -1;
                    sequence = new ArrayList<>(200);
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
            addGene(locus, gene); // Adiciona o gene no genoma com locus de key e gene como valor
        }
        data.close();
    }

    Map<String, Gene> getGenoma() {
        return genoma;
    }

    static synchronized Genoma getInstance() throws FileNotFoundException {
        if (instance == null) {

            instance = new Genoma();

        }
        return instance;
    }

    private void addGene(String locus, Gene gene) {
        genoma.put(locus, gene);
    }
}
