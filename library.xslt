<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="library">
<html>
    <head> <title> Книги </title> </head>
    <body>
        <table border="1" cellspacing="0" cellpadding="3">
            <tr>
                <th>Author</th>
                <th>Title</th>
                <th>Number of pages</th>
                <th>Publishing house</th>
                <th>Circulation</th>
                <th>Year of publication</th>
            </tr>
            <xsl:apply-templates/>
        </table>
    </body>
</html>
</xsl:template>
<xsl:template match="book">
    <tr> <xsl:apply-templates /> </tr>
</xsl:template>
<xsl:template match="author|title|number_of_pages|publishing_house|circulation|year_of_publication">
    <td> <xsl:apply-templates/></td>
</xsl:template>
<xsl:template match="text()"> <xsl:value-of select="." />
</xsl:template>
</xsl:stylesheet>
