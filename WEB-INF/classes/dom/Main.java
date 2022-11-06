package dom;

import model.Library;

public class Main {
    private static Parser parser;
    private static final boolean isDOMParser = true;

    public static void main(String[] args) {

        configure();
        runLogic();
    }

    static void configure() {
        if (isDOMParser) {
            parser = new ValidationDecorator(
                                    new TransformationDecorator(
                                            new DOMParser()));
        }
    }

    static void runLogic() {
        Library library = parser.parse("library.xml", "library.xsd", "library.xslt");
        System.out.println(library);

        System.out.println(library.getMaxNumberOfPages());
        System.out.println(library.sumOfCirculation());
        System.out.println(library.getEarliestYearOfPublication());
        System.out.println(library.countOfBooks());
    }
}
