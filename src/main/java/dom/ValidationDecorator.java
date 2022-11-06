package dom;

import model.Library;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidationDecorator extends ParserDecorator {

    public ValidationDecorator(Parser source) {
        super(source);
    }

    @Override
    public Library parse(String xmlPath, String xsdPath, String xslPath) {
        System.out.println("Was the validation successful? >>> " + validateXMLSchema(xsdPath, xmlPath));
        return super.parse(xmlPath, xsdPath, xslPath);
    }

    private static boolean validateXMLSchema(String xsdPath, String xmlPath){
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        }catch (IOException | SAXException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
