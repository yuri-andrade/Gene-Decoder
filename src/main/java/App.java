public class App {
    public static void main(String[] args) {
        try {
            Genoma genoma = new Genoma("src/sequence.txt");

            genoma.getGenoma().keySet().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }
}
