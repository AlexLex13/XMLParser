package dom;

import model.Library;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TransformationDecorator extends ParserDecorator {
    public TransformationDecorator(Parser source) {
        super(source);
    }

    @Override
    public Library parse(String xmlPath, String xsdPath, String xslPath) {
        Document doc;
        try {
            doc = buildDocument(xmlPath);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

        try(FileOutputStream output = new FileOutputStream("D:\\work_data\\Tomcat\\webapps\\webapptest\\library.html")){
            transform(doc, output, xslPath);
        } catch (TransformerException | IOException e) {
            e.printStackTrace();
        }

        return super.parse(xmlPath, xsdPath, xslPath);
    }

    static void transform(Document doc, OutputStream output, String xslPath) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(new StreamSource(new File(xslPath)));
        transformer.transform(new DOMSource(doc), new StreamResult(output));
    }

    private Document buildDocument(String pathname) throws Exception {
        File file = new File(pathname);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder().parse(file);
    }
}
