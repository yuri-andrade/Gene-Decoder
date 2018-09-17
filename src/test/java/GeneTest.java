import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GeneTest {
    Gene gene;

    @BeforeEach
    void setaTeste(){
        List<Character> listBase = new ArrayList<>();
        String nn = "GATGACAGGACTGCTGGACTAGAA";
        for (Character c: nn.toCharArray()) {
            listBase.add(c);
        }
         this.gene = new Gene("locusTest", 0,0, listBase);
    }
    @Test
    void getTresCincoUm() {
        Assertions.assertEquals("[K, I, R, S, S, G, Q]", gene.getTresCincoUm().toString());
    }

    @Test
    void getTresCincoDois() {
    }

    @Test
    void getTresCincoTres() {
    }

    @Test
    void getCincoTresUm() {
    }

    @Test
    void getCincoTresDois() {
        Assertions.assertEquals("[Met, T, G, L, L, D, Stop]", gene.getCincoTresDois().toString());
    }

    @Test
    void getCincoTresTres() {
    }

    @Test
    void getRightSequence() {
        Assertions.assertEquals("[Met, T, G, L, L, D, Stop]", gene.getCincoTresDois().toString());
    }
}