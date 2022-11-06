package wasap;

import dom.DOMParser;
import dom.Parser;
import dom.TransformationDecorator;
import dom.ValidationDecorator;
import model.Library;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
    private static Parser parser;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        parser = new ValidationDecorator(
                new DOMParser());
        Library library = parser.parse("D:\\work_data\\Tomcat\\webapps\\webapptest\\library.xml",
                "D:\\work_data\\Tomcat\\webapps\\webapptest\\library.xsd",
                "D:\\work_data\\Tomcat\\webapps\\webapptest\\library.xslt");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();

        int size = Integer.parseInt(request.getParameter("size"));
        int count = Integer.parseInt(request.getParameter("count"));

        if (count >= library.countOfBooks())
            count = library.countOfBooks();


        try {

            writer.println("<table border=\"1\" cellspacing=\"0\" cellpadding=\"3\">");
            writer.println("<tr>");
            writer.println("<th>Author</th>");
            writer.println("<th>Title</th>");
            writer.println("<th>Number of pages</th>");
            writer.println("<th>Publishing house</th>");
            writer.println("<th>Circulation</th>");
            writer.println("<th>Year of publication</th>");
            writer.println("</tr>");

            for (var book : library.getBook().subList(0, count)) {
                writer.println("<tr style=\"font-size: " + size + "pt;\">");
                writer.println("<th>" + book.getAuthor() + "</th>");
                writer.println("<th>" + book.getTitle() + "</th>");
                writer.println("<th>" + book.getNumber_of_pages() + "</th>");
                writer.println("<th>" + book.getPublishing_house() + "</th>");
                writer.println("<th>" + book.getCirculation() + "</th>");
                writer.println("<th>" + book.getYear_of_publication() + "</th>");
                writer.println("</tr>");
            }
            writer.println("</table>");
            writer.println("<br><br>");

            writer.println("<p>A book with the maximum number of pages: " + library.getMaxNumberOfPages() + "</p>");
            writer.println("<p>Sum of circulations: " + library.sumOfCirculation() + "</p>");
            writer.println("<p>The book with the earliest publication date: " + library.getEarliestYearOfPublication() + "</p>");
            writer.println("<p>Number of books: " + library.countOfBooks() + "</p>");

        } finally {
            writer.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        parser = new ValidationDecorator(
                    new TransformationDecorator(
                        new DOMParser()));

        parser.parse("D:\\work_data\\Tomcat\\webapps\\webapptest\\library.xml",
                "D:\\work_data\\Tomcat\\webapps\\webapptest\\library.xsd",
                "D:\\work_data\\Tomcat\\webapps\\webapptest\\library.xslt");

        response.setContentType("text/html");

        getServletContext().getRequestDispatcher("/library.html").forward(request, response);
    }
}
