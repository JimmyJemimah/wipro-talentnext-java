<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
        <head>
            <title>Flower Depot</title>
            <style>
                table {
                    border-collapse: collapse;
                    width: 60%;
                    font-family: Arial, sans-serif;
                }
                th, td {
                    border: 1px solid #888888;
                    padding: 6px 12px;
                    text-align: left;
                }
                th {
                    background-color: #f2a8a8;
                    font-weight: bold;
                }
                caption {
                    font-weight: bold;
                    font-size: 16px;
                    text-align: left;
                    margin-bottom: 8px;
                }
            </style>
        </head>
        <body>
            <table>
                <caption>Flower Depot</caption>
                <tr>
                    <th>Flower Name</th>
                    <th>Color</th>
                    <th>Price</th>
                    <th>Availability</th>
                </tr>
                <xsl:for-each select="FlowerDepot/Flower">
                    <tr>
                        <td><xsl:value-of select="Name"/></td>
                        <td><xsl:value-of select="Color"/></td>
                        <td><xsl:value-of select="Price"/></td>
                        <td><xsl:value-of select="Availability"/></td>
                    </tr>
                </xsl:for-each>
            </table>
        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>