/**
 * Enum que representa as possíveis sequências de leitura de um gene.
 *
 * @author <a href="mailto:yuri.arend@acad.pucrs.br">yuri.arend</a>
 * @since 20/09/2018 01:32:00
 */
public enum AminoacidSequenceOrderEnum {
    AMINOACID_SEQUENCE_5_3_1(0, "5'3'-1 Order"),
    AMINOACID_SEQUENCE_5_3_2(1, "5'3'-2 Order"),
    AMINOACID_SEQUENCE_5_3_3(2, "5'3'-3 Order"),

    AMINOACID_SEQUENCE_3_5_1(0, "3'5'-1 Order"),
    AMINOACID_SEQUENCE_3_5_2(1, "3'5'-2 Order"),
    AMINOACID_SEQUENCE_3_5_3(2, "3'5'-3 Order");

    private Integer code;
    private String label;


    AminoacidSequenceOrderEnum(int code, String label) {
        this.code = code;
        this.label = label;
    }


    public Integer getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
