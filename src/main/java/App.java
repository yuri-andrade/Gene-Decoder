import java.time.LocalDate;

public class App {
    public static void main(String args[]) {

        try {
            Genoma genoma = new Genoma("/home/yuri/projects/GeneDecoder/src/sequence.txt");
            System.out.println(LocalDate.now());
            genoma.getGenoma().keySet().forEach(s -> System.out.println(genoma.getGenoma().get(s).getRightSequence()));

//            for (String key : Genoma.getInstance().getGenoma().keySet()) {
//
//                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//                System.out.println("Gene: " + key);
//                System.out.println("Sequencia de : " + Genoma.getInstance().getGenoma().get(key).getBegin() + " at� "
//                        + Genoma.getInstance().getGenoma().get(key).getEnd());
//                System.out.println("Sequencia correta : " + Genoma.getInstance().getGenoma().get(key).getRightSequence());
//                System.out.println("....................................................................................................................................................................................");
//                System.out.println("Sequencia 5'-3' 1 : " + Genoma.getInstance().getGenoma().get(key).getCincoTresUm());
//                System.out.println("Sequencia 5'-3' 2 : " + Genoma.getInstance().getGenoma().get(key).getCincoTresDois());
//                System.out.println("Sequencia 5'-3' 3 : " + Genoma.getInstance().getGenoma().get(key).getCincoTresTres());
//                System.out.println("Sequencia 3'-5' 1 : " + Genoma.getInstance().getGenoma().get(key).getTresCincoTres());
//                System.out.println("Sequencia 3'-5' 2 : " + Genoma.getInstance().getGenoma().get(key).getTresCincoDois());
//                System.out.println("Sequencia 3'-5' 3 : " + Genoma.getInstance().getGenoma().get(key).getTresCincoUm());
//                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
//
//            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
