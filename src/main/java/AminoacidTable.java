import java.util.HashMap;
import java.util.Map;

/**
 * Classe Singleton que implementa um {@link AminoacidTable}
 * populado com o mapeamento de codon para aminoácido.
 *
 * @author <a href="mailto:yuri.arend@acad.pucrs.br">yuri.arend</a>
 * @since 15/09/2018 07:10:00
 */
public class AminoacidTable {
    private static AminoacidTable instance;
    private Map<String, String> aminoacidTable;

    private AminoacidTable() {
        aminoacidTable = new HashMap<>();
        populateAminoacidTable();
    }

    static synchronized AminoacidTable getInstance() {
        if (instance == null) {
            instance = new AminoacidTable();
        }
        return instance;
    }

    String getAminoacid(String codon) {
        return aminoacidTable.get(codon);
    }

    private void populateAminoacidTable() {
        aminoacidTable.put("TTT", "F");// Phe
        aminoacidTable.put("TTC", "F");



        aminoacidTable.put("TTA", "L");// Leu
        aminoacidTable.put("TTG", "L");
        aminoacidTable.put("CTT", "L");
        aminoacidTable.put("CTC", "L");
        aminoacidTable.put("CTA", "L");
        aminoacidTable.put("CTG", "L");

        aminoacidTable.put("ATT", "I"); // Ile
        aminoacidTable.put("ATC", "I");
        aminoacidTable.put("ATA", "I");

        aminoacidTable.put("ATG", "Met");// Met

        aminoacidTable.put("GTT", "V");// Val
        aminoacidTable.put("GTC", "V");
        aminoacidTable.put("GTA", "V");
        aminoacidTable.put("GTG", "V");

        aminoacidTable.put("TCT", "S"); // Ser
        aminoacidTable.put("TCC", "S");
        aminoacidTable.put("TCA", "S");
        aminoacidTable.put("TCG", "S");

        aminoacidTable.put("CCT", "P"); // Pro
        aminoacidTable.put("CCC", "P");
        aminoacidTable.put("CCA", "P");
        aminoacidTable.put("CCG", "P");

        aminoacidTable.put("ACT", "T"); // Thr
        aminoacidTable.put("ACC", "T");
        aminoacidTable.put("ACA", "T");
        aminoacidTable.put("ACG", "T");

        aminoacidTable.put("GCT", "A"); // Ala
        aminoacidTable.put("GCC", "A");
        aminoacidTable.put("GCA", "A");
        aminoacidTable.put("GCG", "A");

        aminoacidTable.put("TAT", "Y"); // Tyr
        aminoacidTable.put("TAC", "Y");

        aminoacidTable.put("TAA", "Stop");//Stop
        aminoacidTable.put("TAG", "Stop");
        aminoacidTable.put("TGA", "Stop");

        aminoacidTable.put("CAT", "H"); // His
        aminoacidTable.put("CAC", "H");

        aminoacidTable.put("CAA", "Q"); // Gln
        aminoacidTable.put("CAG", "Q");

        aminoacidTable.put("AAT", "N");// Asn
        aminoacidTable.put("AAC", "N");

        aminoacidTable.put("AAA", "K");// Lys
        aminoacidTable.put("AAG", "K");

        aminoacidTable.put("GAT", "D");// Asp
        aminoacidTable.put("GAC", "D");

        aminoacidTable.put("GAA", "E"); // Glu
        aminoacidTable.put("GAG", "E");

        aminoacidTable.put("TGT", "C"); // Cys
        aminoacidTable.put("TGC", "C");

        aminoacidTable.put("TGG", "W"); // Trp

        aminoacidTable.put("CGT", "R"); // Arg
        aminoacidTable.put("CGC", "R");
        aminoacidTable.put("CGA", "R");
        aminoacidTable.put("CGG", "R");

        aminoacidTable.put("AGA", "R"); // Arg
        aminoacidTable.put("AGG", "R");

        aminoacidTable.put("AGT", "S"); // Ser
        aminoacidTable.put("AGC", "S");

        aminoacidTable.put("GGT", "G"); // Gly
        aminoacidTable.put("GGC", "G");
        aminoacidTable.put("GGA", "G");
        aminoacidTable.put("GGG", "G");
    }
}