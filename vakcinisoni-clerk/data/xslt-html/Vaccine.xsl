<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:v="http://www.vakcinisoni.com" version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Vaccine</title>
                <style>
                    body {
                        font-family: Arial;
                    }
                    .container {
                        max-width: 700px;
                        margin: 0 auto;
                        margin-top: 30px;
                    }
                    table {
                        width: 100%;
                    }
                    .boldovano {
                        font-weight: bold;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <table>
                        <tr>
                            <td class="boldovano">Произвођач:</td>
                            <td>
                                <xsl:value-of select="v:vaccine/v:manufacturer"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="boldovano">Име:</td>
                            <td>
                                <xsl:value-of select="v:vaccine/v:name"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="boldovano">Количина:</td>
                            <td>
                                <xsl:value-of select="v:vaccine/v:quantity"/>
                            </td>
                        </tr>
                    </table>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>