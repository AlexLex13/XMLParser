import static org.junit.Assert.*;

import dom.DOMParser;
import dom.Parser;
import model.Library;
import org.junit.*;

public class TestLibrary {
    private Library lib;

    @Before
    public void setup(){
       Parser parser = new DOMParser();
       lib = parser.parse("library.xml","library.xsd","library.xslt");
    }

    @Test
    public void TestSumOfCirculation(){
        assertEquals(2200, lib.sumOfCirculation());
    }

    @Test
    public void TestCountOfBooks(){
        assertEquals(3, lib.countOfBooks());
    }

    @Test
    public void TestGetEarliestYearOfPublication(){
        assertEquals("ТИХИЙ ДОН", lib.getEarliestYearOfPublication());
    }

    @Test
    public void TestGetMaxNumberOfPages(){
        assertEquals("ТИХИЙ ДОН", lib.getMaxNumberOfPages());
    }
}
