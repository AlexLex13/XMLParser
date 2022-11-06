package dom;

import model.Book;
import model.Library;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;

public class DOMParser implements Parser {

    @Override
    public Library parse(String xmlPath, String xsdPath, String xslPath) {

        Library library = new Library();

        Document doc;
        try {
            doc = buildDocument(xmlPath);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

        Node rootNode = doc.getFirstChild().getNextSibling();
        NodeList rootChildren = rootNode.getChildNodes();

        ArrayList<Book> bookList = new ArrayList<>();
        for (int i = 0; i < rootChildren.getLength(); ++i) {

            if (rootChildren.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Book book = parsBook(rootChildren.item(i));
                bookList.add(book);
            }

        }

        library.setBook(bookList);
        return library;

    }

    private Document buildDocument(String pathname) throws Exception {
        File file = new File(pathname);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder().parse(file);
    }

    private Book parsBook(Node bookNode) {

        String author = "";
        String title = "";
        int number_of_pages = 0;
        String publishing_house = "";
        int circulation = 0;
        int year_of_publication = 0;


        NodeList bookChildren = bookNode.getChildNodes();
        for (int i = 0; i < bookChildren.getLength(); ++i) {

            if (bookChildren.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            switch (bookChildren.item(i).getNodeName()) {
                case TAG_AUTHOR -> {
                    author = bookChildren.item(i).getTextContent();
                }
                case TAG_TITLE -> {
                    title = bookChildren.item(i).getTextContent();
                }
                case TAG_NUMBER_OF_PAGES -> {
                    number_of_pages = Integer.parseInt(bookChildren.item(i).getTextContent());
                }
                case TAG_PUBLISHING_HOUSE -> {
                    publishing_house = bookChildren.item(i).getTextContent();
                }
                case TAG_CIRCULATION -> {
                    circulation = Integer.parseInt(bookChildren.item(i).getTextContent());
                }
                case TAG_YEAR_OF_PUBLICATION -> {
                    year_of_publication = Integer.parseInt(bookChildren.item(i).getTextContent());
                }
                default -> throw new IllegalStateException("Unexpected value: " + bookChildren.item(i).getNodeName());
            }
        }

        return new Book(author, title, number_of_pages, publishing_house, circulation, year_of_publication);
    }

}
