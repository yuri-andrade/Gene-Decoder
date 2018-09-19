import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe que implementa um {@link Gene}.
 *
 * @author <a href="mailto:yuri.arend@acad.pucrs.br">yuri.arend</a>
 * @since 15/09/2018 07:06:00
 */
public class Gene {
    private String locus;
    private long begin;
    private long end;
    private List<Character> bases;

    public Gene(String locus, long begin, long end, List<Character> bases) {
        super();
        this.locus = locus;
        this.begin = begin;
        this.end = end;
        this.bases = bases;
    }

    public List<String> getTresCincoUm() {
        return decodeReverse(0);
    }

    public List<String> getTresCincoDois() {
        return decodeReverse(1);
    }

    public List<String> getTresCincoTres() {
        return decodeReverse(2);
    }

    public List<String> getCincoTresUm() {
        return decodeByFiveThreeOrder(0);
    }

    public List<String> getCincoTresDois() {
        return decodeByFiveThreeOrder(1);
    }

    public List<String> getCincoTresTres() {
        return decodeByFiveThreeOrder(2);
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
     * Percorre a lista de bases do gene a partir do index passado
     * preenchendo uma lista com os aminoácidos correspondentes a cada códon.
     *
     * @param index índice de inicio de contagem de códons
     * @return Lista de aminoácidos correspondente ao index recebido
     */
    public List<String> decodeByFiveThreeOrder(int index) {
        List<String> aminoAcids = new ArrayList<>();
        Iterator iterator = bases.subList(index, bases.size()).iterator();
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
        return aminoAcids;
    }


    public List<String> decodeByThreeFiveOrder(int index) {
        List<String> aminoAcids = new ArrayList<>();


        return null;
    }


    public List<String> decodeReverse(int index) {
        List<String> codons = new ArrayList<>();
        int count = this.bases.size() - index - 1;
        for (int i = this.bases.size() - 1; i > 3; i -= 3) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                String a = this.bases.get(count).toString();
                count--;
                sb.append(a);
            }
            codons.add(AminoacidTable.getInstance().getAminoacid(sb.toString()));
        }
        return codons;
    }

    public List<String> getRightSequence() {

        List<String> lista1 = decodeByFiveThreeOrder(0);
        List<String> lista2 = decodeByFiveThreeOrder(1);
        List<String> lista3 = decodeByFiveThreeOrder(2);
        List<String> lista4 = decodeReverse(0);
        List<String> lista5 = decodeReverse(1);
        List<String> lista6 = decodeReverse(2);
        List<String> theChosenOne = lista1;
        if (countRightSequence(lista2) > countRightSequence(theChosenOne)) {
            theChosenOne = lista2;
        }
        if (countRightSequence(lista3) > countRightSequence(theChosenOne)) {
            theChosenOne = lista3;
        }
        if (countRightSequence(lista4) > countRightSequence(theChosenOne)) {
            theChosenOne = lista4;
        }
        if (countRightSequence(lista5) > countRightSequence(theChosenOne)) {
            theChosenOne = lista5;
        }
        if (countRightSequence(lista6) > countRightSequence(theChosenOne)) {
            theChosenOne = lista6;
        }

        return theChosenOne;

    }

    public int countRightSequence(List<String> lista) {
        boolean contagemIniciada = false;
        int counter = 0;
        for (String amino : lista) {
            if (contagemIniciada) {
                counter++;
            } else if ("Met".equalsIgnoreCase(amino)) {
                contagemIniciada = true;
            } else if ("Stop".equalsIgnoreCase(amino)) {
                return counter;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        return "Gene [locus=" + locus + ", begin=" + begin + ", end=" + end + ", bases=" + bases + "]";
    }
}
