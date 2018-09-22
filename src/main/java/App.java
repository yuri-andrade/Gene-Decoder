public class App {
    public static void main(String[] args) {
//        List<Character> basesList = Arrays.asList('G', 'A', 'T', 'G', 'A', 'C',
//                'A', 'G', 'G', 'A', 'C', 'T', 'G', 'C',
//                'T', 'G', 'G', 'A', 'C', 'T', 'A', 'G', 'A', 'A');
//        Gene gene = new Gene("locusTest", 0, 0, basesList);
//        System.out.println(gene.getTresCincoUm());
        try {
            Genoma genoma = new Genoma("src/sequence.txt");


//            System.out.println(gene.getBases());
//            System.out.println(gene.getCincoTresUm());
//            System.out.println(gene.getCincoTresDois());
//            System.out.println(gene.getCincoTresTres());
//            System.out.println(gene.getTresCincoUm());
//            System.out.println(gene.getTresCincoDois());
//            System.out.println(gene.getTresCincoTres());
//            System.out.println("-------------------------------");
//            System.out.println(gene.decodeByFiveThreeOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_5_3_1));
//            System.out.println(gene.decodeByFiveThreeOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_5_3_2));
//            System.out.println(gene.decodeByFiveThreeOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_5_3_3));
//            System.out.println(gene.decodeByThreeFiveOrder(AminoacidSequenceOrderEnum.AMINOACID_SEQUENCE_3_5_1));

            genoma.getGenoma().keySet().stream().forEach(s -> {
                System.out.println(s);
                System.out.println(genoma.getGenoma().get(s).getRightSequence());
            });


        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}
