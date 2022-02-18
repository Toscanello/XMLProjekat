<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:dcr="http://www.vakcinisoni.com" version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Digital Certification Request</title>
                <style>
                    .container {
                        max-width: 700px;
                        margin: 0 auto;
                    }
                    .title {
                        text-align: center;
                        margin-top: 50px;
                        margin-bottom: 50px;
                    }
                    .title h2, h1 {
                        margin: 0;
                        padding: 0;
                    }
                    .text-before {
                        padding-bottom: 20px;
                    }
                    .sub-title {
                        padding-bottom: 10px;
                    }
                    .place-time {
                        padding-top: 50px;
                    }
                </style>
            </head>

            <body>
                <div class="container">
                    <div class="title">
                        <h1>ЗАХТЕВ</h1>
                        <h2>за издавање дигиталног зеленог сертификата</h2>
                    </div>

                    <p class="text-before">У складу са одредбом Републике Србије о издавању дигиталног зеленог сертификата као потврде о извршеној вакцинацији против COVID-19, резултатима тестирања на заразну болест SARS-CoV-2 или опоравку од болести COVID-19, подносим захтев за издавање дигиталног зеленог сертификата.</p>

                    <p class="sub-title">Подносилац захтева:</p>

                    <p>Име и презиме:
                        <b><xsl:value-of select="dcr:certificateRequest/dcr:fullName"/></b>
                    </p>

                    <p>Датум рођења:
                        <b><xsl:value-of select="dcr:certificateRequest/dcr:birthDate"/></b>
                    </p>

                    <p>Пол:
                        <b><xsl:value-of select="dcr:certificateRequest/dcr:gender"/></b>
                    </p>

                    <p>Јединствени матични број грађанина:
                        <b><xsl:value-of select="dcr:certificateRequest/dcr:jmbg"/></b>
                    </p>

                    <p>Број пасоша:
                        <b><xsl:value-of select="dcr:certificateRequest/dcr:passportNum"/></b>
                    </p>

                    <p>Разлог за подношење захтева:</p>
                    <b><xsl:value-of select="dcr:certificateRequest/dcr:reason"/></b>

                    <div class="place-time">
                        <p>У
                            <b><xsl:value-of select="dcr:certificateRequest/dcr:place"/></b>
                        </p>

                        <p>дана
                            <b><xsl:value-of select="substring(dcr:certificateRequest/dcr:requestDate, 6, string-length(dcr:certificateRequest/dcr:requestDate)-1)"/></b>
                            20
                            <b><xsl:value-of select="substring(dcr:certificateRequest/dcr:requestDate, 3, 2)"/></b>
                            године
                        </p>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>