package dom;

import model.Library;

public interface Parser {
    String TAG_AUTHOR = "author";
    String TAG_TITLE = "title";
    String TAG_NUMBER_OF_PAGES = "number_of_pages";
    String TAG_PUBLISHING_HOUSE = "publishing_house";
    String TAG_CIRCULATION = "circulation";
    String TAG_YEAR_OF_PUBLICATION = "year_of_publication";

    Library parse(String xmlPath, String xsdPath, String xslPath);
}
