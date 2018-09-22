import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Classe que implementa um {@link Gene}.
 *
 * @author <a href="mailto:yuri.arend@acad.pucrs.br">yuri.arend</a>
 * @since 15/09/2018 07:06:00
 */
public class Gene {
    private final String locus;
    private final long begin;
    private final long end;
    private List<Character> bases;
    private List<String> cincoTresUm;
    private List<String> cincoTresDois;
    private List<String> cincoTresTres;
    private List<String> tresCincoUm;
    private List<String> tresCincoDois;
    private List<String> tresCincoTres;

    public Gene(String locus, long begin, long end, List<Character> bases) {
        this.locus = locus;
        this.begin = begin;
        this.end = end;
        this.bases = bases;
        this.cincoTresUm = decodeByFiveThreeOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_5_3_1);
        this.cincoTresDois = decodeByFiveThreeOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_5_3_2);
        this.cincoTresTres = decodeByFiveThreeOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_5_3_3);
        this.tresCincoUm = decodeByThreeFiveOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_3_5_1);
        this.tresCincoDois = decodeByThreeFiveOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_3_5_2);
        this.tresCincoTres = decodeByThreeFiveOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_3_5_3);
    }

    public List<String> getTresCincoUm() {
        return tresCincoUm;
    }

    public List<String> getTresCincoDois() {
        return tresCincoDois;
    }

    public List<String> getTresCincoTres() {
        return tresCincoTres;
    }

    public List<String> getCincoTresUm() {
        return cincoTresUm;
    }

    public List<String> getCincoTresDois() {
        return cincoTresDois;
    }

    public List<String> getCincoTresTres() {
        return cincoTresTres;
    }

    public String getLocus() {
        return locus;
    }

    public long getBegin() {
        return begin;
    }

    public long getEnd() {
        return end;
    }

    public List<Character> getBases() {
        return bases;
    }

    /**
     * Percorre a lista de bases do gene a partir do enum passado
     * preenchendo uma lista com os aminoácidos correspondentes a cada códon.
     *
     * @param aminoEnum Enum que representa o índice de inicio de contagem de códons
     * @return Lista de aminoácidos correspondente ao index recebido
     */

    public List<String> decodeByFiveThreeOrder(AminoacidSequenceOrderEnum aminoEnum) {
        List<String> aminoAcids = new ArrayList<>();
        Iterator iterator = bases.subList(aminoEnum.getCode(), bases.size()).iterator();
        addGene(aminoAcids, iterator);

        return aminoAcids;
    }

    /**
     * Método que recebe uma lista de Aminoácidos vazia e o iterator da lista de bases
     * itera sobre a lista de bases e adiciona o aminoácido correspondente na mesma.
     *
     * @param aminoAcids lista de aminoácidos que ira ser preenchida
     * @param iterator   iterator da lista de bases do gene
     */
    private void addGene(List<String> aminoAcids, Iterator iterator) {
        int counter = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            counter++;
            if (counter % 3 == 0) {
                aminoAcids.add(AminoacidTable.getInstance().getAminoacid(stringBuilder.toString()));
                stringBuilder = new StringBuilder();
            }
        }
    }

    /**
     * Inverte a lista de bases do gene e percorre a lista a partir do enum passado
     * preenchendo uma lista com os aminoácidos correspondentes a cada códon.
     *
     * @param aminoEnum Enum que representa o índice de inicio de contagem de códons
     * @return Lista de aminoácidos correspondente ao enum recebido
     */
    public List<String> decodeByThreeFiveOrder(AminoacidSequenceOrderEnum aminoEnum) {
        List<String> aminoAcids = new ArrayList<>();
        List<Character> basesInvertido = new ArrayList<>();
        basesInvertido.addAll(this.bases);
        Collections.reverse(basesInvertido);
        Iterator iterator = basesInvertido.subList(aminoEnum.getCode(), basesInvertido.size()).iterator();
        addGene(aminoAcids, iterator);

        return aminoAcids;
    }

    /**
     * Método que compara as listas buscando qual delas tem a maior distância
     * entre um aminoácido "Met" e um "Stop".
     *
     * @return lista correta de aminoácidos do gene
     */
    public List<String> getRightSequence() {

        List<String> theChosenOne = this.cincoTresUm;

        theChosenOne = (countRightSequence(this.cincoTresDois) > countRightSequence(theChosenOne))
                ? this.cincoTresDois : theChosenOne;

        theChosenOne = (countRightSequence(this.cincoTresTres) > countRightSequence(theChosenOne))
                ? this.cincoTresTres : theChosenOne;

        theChosenOne = (countRightSequence(this.tresCincoUm) > countRightSequence(theChosenOne))
                ? this.tresCincoUm : theChosenOne;

        theChosenOne = (countRightSequence(this.tresCincoDois) > countRightSequence(theChosenOne))
                ? this.tresCincoDois : theChosenOne;

        theChosenOne = (countRightSequence(this.tresCincoTres) > countRightSequence(theChosenOne))
                ? this.tresCincoTres : theChosenOne;

        return theChosenOne;
    }

    /**
     * Método que percorre uma lista de aminoácidos e procura um aminoácido
     * de inicio de contagem, caso encontre, é iniciada a busca
     * pelo aminoácido de parada.
     *
     * @param aminoAcidsList lista de aminoácidos
     * @return int com a diferença entre o aminoácido de inicio e o aminoácido de parada
     */
    public int countRightSequence(List<String> aminoAcidsList) {
        boolean contagemIniciada = false;
        int counter = 0;
        int stopCounter = 0;
        for (String amino : aminoAcidsList) {
            if (contagemIniciada) {
                counter++;
            } else if ("Met".equalsIgnoreCase(amino)) {
                contagemIniciada = true;
            } else if ("Stop".equalsIgnoreCase(amino)) {
                stopCounter = counter;
            }
        }
        return Math.max(stopCounter, counter);
    }

    @Override
    public String toString() {
        return "Gene [locus=" + locus + ", begin=" + begin + ", end=" + end + ", bases=" + bases + "]";
    }
}
