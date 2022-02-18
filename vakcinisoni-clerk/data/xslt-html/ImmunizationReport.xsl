<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ir="http://www.vakcinisoni.com" version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Immunization Report</title>
                <style>
                    .container {
                        max-width: 700px;
                        margin: 0 auto;
                    }
                    h1 {
                        text-align: center;
                        margin-top: 50px;
                        margin-bottom: 50px;
                    }
                    .first-p {
                        padding-bottom: 30px;
                    }
                    .sub-title {
                        padding: 0;
                        margin: 0;
                    }
                    .middle-p {
                        padding: 50px 0;
                    }
                    ul {
                        margin-top: 0;
                        padding-top: 0;
                    }
                    .date {
                        padding-top: 100px;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>Извештај о имунизацији</h1>

                    <p class="first-p">
                        Извештај се односи на период од
                        <b><xsl:value-of select="ir:immunizationReport/ir:startDate"/></b>
                        до
                        <b><xsl:value-of select="ir:immunizationReport/ir:finishDate"/></b>
                    </p>

                    <p class="sub-title">У напоменутом временском интервалу је:</p>
                    <ul>
                        <li>
                            поднето
                            <b><xsl:value-of select="ir:immunizationReport/ir:immunizationRequests"/></b>
                            докумената о интересовању за имунизацију
                        </li>
                        <li>
                            примљено
                            <b><xsl:value-of select="ir:immunizationReport/ir:certificateRequests"/></b>
                            захтева за дигитални зелени сертификат, од којих је
                            <b><xsl:value-of select="ir:immunizationReport/ir:certificatesIssued"/></b>
                            издато
                        </li>
                    </ul>

                    <p class="middle-p">
                        Примљено је
                        <b><xsl:value-of select="ir:immunizationReport/ir:vaccinesTaken"/></b>
                        доза вакцине против covid-19 вируса, од чега је
                        <b><xsl:value-of select="ir:immunizationReport/ir:firstTimeVaccineTaken"/></b>
                        ново вакцинисаних.
                    </p>

                    <p class="sub-title">Расподела по произвођачима је:</p>
                    <ul>
                        <xsl:for-each select="ir:immunizationReport/ir:manufacturers/ir:manufacturer">
                            <li>
                                <b><xsl:value-of select="ir:name"/></b> - <b><xsl:value-of select="ir:numberOfVaccines"/></b>
                            </li>
                        </xsl:for-each>
                    </ul>

                    <p class="date">
                        Извештај издат
                        <b><xsl:value-of select="substring(ir:immunizationReport/ir:reportDate, 6, 2)"/></b>
                        .
                        <b><xsl:value-of select="substring(ir:immunizationReport/ir:reportDate, 9, 2)"/></b>
                        .
                        <b><xsl:value-of select="substring(ir:immunizationReport/ir:reportDate, 1, 4)"/></b>
                        године
                    </p>

                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>