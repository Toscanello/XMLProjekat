<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:vc="http://www.vakcinisoni.com" version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Vaccine Candidate</title>
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
                    .pl-1 {
                        padding-left: 10px;
                    }
                    .pt-1 {
                        padding-top: 10px;
                    }
                    ul {
                        margin-top: 0;
                        padding-top: 0;
                    }
                    .date {
                        padding-top: 50px;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>Исказивање интересовања за вакцинисање против COVID-19</h1>

                    <p>
                        Одаберите опцију:
                        <b><xsl:value-of select="vc:vaccineCandidate/vc:residence"/></b>
                    </p>

                    <p>
                        ЈМБГ:
                        <b><xsl:value-of select="vc:vaccineCandidate/vc:jmbg"/></b>
                    </p>

                    <p>
                        Име:
                        <b><xsl:value-of select="vc:vaccineCandidate/vc:name"/></b>
                    </p>

                    <p>
                        Презиме:
                        <b><xsl:value-of select="vc:vaccineCandidate/vc:surname"/></b>
                    </p>

                    <p>
                        Адреса електронске поште:
                        <b><xsl:value-of select="vc:vaccineCandidate/vc:email"/></b>
                    </p>

                    <p>
                        Број мобилног телефона (навести број у формату 06X..... без размака и цртица):
                    </p>
                    <b class="pl-1"><xsl:value-of select="vc:vaccineCandidate/vc:phoneNum"/></b>

                    <p>
                        Број фиксног телефона (навести број у формату нпр. 011..... без размака и цртица):
                    </p>
                    <b class="pl-1"><xsl:value-of select="vc:vaccineCandidate/vc:homeNum"/></b>

                    <p>
                        Одаберите локацију где желите да примите вакцину (унесите општину):
                    </p>
                    <b class="pl-1"><xsl:value-of select="vc:vaccineCandidate/vc:location"/></b>

                    <p class="pt-1">
                        Исказујем интересовање да примим искључиво вакцину следећих произвођача за који Агенција за лекове и медицинска средства потврди безбедност, ефикасност и квалитет и изда дозволу за употребу лека:
                    </p>

                    <ul>
                        <xsl:for-each select="vc:vaccineCandidate/vc:options/vc:manufacturer">
                            <li>
                                <xsl:value-of select="text()"/>
                            </li>
                        </xsl:for-each>
                    </ul>

                    <p>
                        Да ли сте добровољни давалац крви?
                        <b><xsl:value-of select="vc:vaccineCandidate/vc:isBloodDonor"/></b>
                    </p>

                    <p class="date">
                        дана
                        <b><xsl:value-of select="substring(vc:vaccineCandidate/vc:date, 6, string-length(vc:vaccineCandidate/vc:date)-1)"/></b>
                        20
                        <b><xsl:value-of select="substring(vc:vaccineCandidate/vc:date, 3, 2)"/></b>
                        године
                    </p>

                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>