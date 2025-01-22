package se.lexicon;


public class App {
    public static void main(String[] args) {

        int size = NameRepository.getSize();
        System.out.println(size);
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println(NameRepository.getSize());
        NameRepository.add("Botond Medgyesi");
        NameRepository.findByFirstName("Botond");
        NameRepository.findByLastName("Svensson");
        NameRepository.update("Botond Medgyesi", "adam b");
        NameRepository.printStringArray(NameRepository.findAll());
        System.out.println("==================");
        NameRepository.remove("adam b");
        NameRepository.printStringArray(NameRepository.findAll());

        // call more methods as needed
    }
}
