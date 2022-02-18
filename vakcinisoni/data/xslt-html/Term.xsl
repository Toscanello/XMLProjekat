<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:t="http://www.vakcinisoni.com" version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Term</title>
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
                            <td class="boldovano">Почетак:</td>
                            <td>
                                <xsl:value-of select="substring(t:term/t:start, 11, string-length(t:term/t:start)-1)"/>
                                <xsl:value-of select="substring(t:term/t:start, 1, 10)"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="boldovano">Крај:</td>
                            <td>
                                <xsl:value-of select="substring(t:term/t:finish, 11, string-length(t:term/t:finish)-1)"/>
                                <xsl:value-of select="substring(t:term/t:finish, 1, 10)"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="boldovano">Заузет:</td>
                            <td>
                                <xsl:value-of select="t:term/t:taken"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="boldovano">Локација:</td>
                            <td>
                                <xsl:value-of select="t:term/t:location"/>
                            </td>
                        </tr>
                    </table>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>