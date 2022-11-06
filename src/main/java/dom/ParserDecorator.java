package dom;

import model.Library;

public class ParserDecorator implements Parser{
    private Parser wrap;

    ParserDecorator(Parser source) {
        this.wrap = source;
    }

    @Override
    public Library parse(String xmlPath, String xsdPath, String xslPath) {
        return wrap.parse(xmlPath, xsdPath, xslPath);
    }
}
