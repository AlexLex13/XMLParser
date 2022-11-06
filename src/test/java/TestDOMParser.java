import dom.DOMParser;
import dom.Parser;
import model.Book;
import org.junit.*;
import static org.junit.Assert.*;

public class TestDOMParser {
    private Parser parser;

    @Before
    public void setup(){
        parser = new DOMParser();
    }

    @Test
    public void TestParser(){
        assertEquals( new Book("ЛЕВ ТОЛСТОЙ", "АННА КАРЕНИНА", 300, "Просвет", 1000, 1999),
                parser.parse("library.xml", "library.xsd", "library.xslt").getBook().get(0));
    }
}
