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
    private final List<Character> bases;

    public Gene(String locus, long begin, long end, List<Character> bases) {
        this.locus = locus;
        this.begin = begin;
        this.end = end;
        this.bases = bases;
    }

    public List<String> getTresCincoUm() {
        return decodeByThreeFiveOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_3_5_1);
    }

    public List<String> getTresCincoDois() {
        return decodeByThreeFiveOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_3_5_2);
    }

    public List<String> getTresCincoTres() {
        return decodeByThreeFiveOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_3_5_3);
    }

    public List<String> getCincoTresUm() {
        return decodeByFiveThreeOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_5_3_1);
    }

    public List<String> getCincoTresDois() {
        return decodeByFiveThreeOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_5_3_2);
    }

    public List<String> getCincoTresTres() {
        return decodeByFiveThreeOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_5_3_3);
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
     * preenchendo uma lista com os aminoácidos correspondentes a cada códon,
     * realizando a leitura no sentido 5'3'.
     *
     * @param aminoEnum Enum que representa o índice de inicio de contagem de códons
     * @return Lista de aminoácidos correspondente ao index recebido
     */
    public List<String> decodeByFiveThreeOrder(AminoacidSequenceOrderEnum aminoEnum) {
        List<String> aminoAcids = new ArrayList<>();
        Iterator iterator = bases.subList(aminoEnum.getCode(), bases.size()).iterator();
        parseCodonsIntoAminoacids(aminoAcids, iterator);

        return aminoAcids;
    }

    /**
     * Método que recebe uma lista de Aminoácidos vazia e o iterator da lista de bases
     * itera sobre a lista de bases e adiciona o aminoácido correspondente na mesma.
     *
     * @param aminoAcids lista de aminoácidos que ira ser preenchida
     * @param iterator   iterator da lista de bases do gene
     */
    private void parseCodonsIntoAminoacids(List<String> aminoAcids, Iterator iterator) {
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
     * preenchendo uma lista com os aminoácidos correspondentes a cada códon,
     * realizando a leitura no sentido 3'5'.
     *
     * @param aminoEnum Enum que representa o índice de inicio de contagem de códons
     * @return Lista de aminoácidos correspondente ao enum recebido
     */
    public List<String> decodeByThreeFiveOrder(AminoacidSequenceOrderEnum aminoEnum) {
        List<String> aminoAcids = new ArrayList<>();
        List<Character> basesInvertido = new ArrayList<>(this.bases);
        Collections.reverse(basesInvertido);
        Iterator iterator = basesInvertido.subList(aminoEnum.getCode(), basesInvertido.size()).iterator();
        parseCodonsIntoAminoacids(aminoAcids, iterator);

        return aminoAcids;
    }

    /**
     * Método que compara as listas buscando qual delas tem a maior distância
     * entre um aminoácido "Met" e um "Stop".
     *
     * @return lista correta de aminoácidos do gene
     */
    public List<String> getRightSequence() {

        List<String> theRightAminoSequence
                = decodeByFiveThreeOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_5_3_1);

        if (countRightSequence(decodeByFiveThreeOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_5_3_2))
                > countRightSequence(theRightAminoSequence)) {
            theRightAminoSequence = decodeByFiveThreeOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_5_3_2);
        }
        if (countRightSequence(decodeByFiveThreeOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_5_3_3))
                > countRightSequence(theRightAminoSequence)) {
            theRightAminoSequence = decodeByFiveThreeOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_5_3_3);
        }
        if (countRightSequence(decodeByThreeFiveOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_3_5_1))
                > countRightSequence(theRightAminoSequence)) {
            theRightAminoSequence = decodeByThreeFiveOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_3_5_1);
        }
        if (countRightSequence(decodeByThreeFiveOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_3_5_2))
                > countRightSequence(theRightAminoSequence)) {
            theRightAminoSequence = decodeByThreeFiveOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_3_5_2);
        }
        if (countRightSequence(decodeByThreeFiveOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_3_5_3))
                > countRightSequence(theRightAminoSequence)) {
            theRightAminoSequence = decodeByThreeFiveOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_3_5_3);
        }

        return theRightAminoSequence;

    }

    /**
     * Método que realiza a contagem da maior distância entre um aminoácido "Met" e um aminoácido "Stop".
     *
     * @param aminoAcidsList lista de aminoácidos
     * @return int com a diferença entre um aminoácido "Met" e um aminoácido "Stop"
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