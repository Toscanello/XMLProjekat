<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:dcr="http://www.vakcinisoni.com/DigitalCertRequest"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="digital-certificate-request-page">
                    <fo:region-body margin="0.75in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="digital-certificate-request-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block linefeed-treatment="preserve" font-family="Times New Roman" font-size="14px" font-weight="bold" padding="10px" text-align="center">
                        ЗАХТЕВ&#xA;за издавање дигиталног зеленог сертификата
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" text-align="justify" padding-top="20px" padding-bottom="20px">
                        У складу са одредбом Републике Србије о издавању дигиталног зеленог сертификата као потврде о извршеној вакцинацији против COVID-19, резултатима тестирања на заразну болест SARS-CoV-2 или опоравку од болести COVID-19, подносим захтев за издавање дигиталног зеленог сертификата.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-bottom="10px">
                        Подносилац захтева:
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-bottom="5px">
                        Име и презиме:
                        <fo:inline font-weight="bold" font-family="Times New Roman" font-size="12px">
                            <xsl:value-of select="dcr:certificateRequest/dcr:fullName"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-bottom="5px">
                        Датум рођења:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="dcr:certificateRequest/dcr:birthDate"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-bottom="5px">
                        Пол:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="dcr:certificateRequest/dcr:gender"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-bottom="5px">
                        Јединствени матични број грађанина:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="dcr:certificateRequest/dcr:jmbg"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-bottom="5px">
                        Број пасоша:
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="dcr:certificateRequest/dcr:passportNum"/>
                        </fo:inline>
                    </fo:block>

                    <fo:block font-family="Times New Roman" font-size="12px" padding-top="10px" padding-bottom="5px">
                        Разлог за подношење захтева:
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-bottom="5px" font-weight="bold">
                        <xsl:value-of select="dcr:certificateRequest/dcr:reason"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-bottom="5px" padding-top="30px">
                        У
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="dcr:certificateRequest/dcr:place"/>
                        </fo:inline>
                        ,
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-bottom="5px" padding-top="10px">
                        дана
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="substring(dcr:certificateRequest/dcr:requestDate, 6, string-length(dcr:certificateRequest/dcr:requestDate)-1)"/>
                        </fo:inline>
                        20
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="substring(dcr:certificateRequest/dcr:requestDate, 3, 2)"/>
                        </fo:inline>
                        године
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>

        </fo:root>
    </xsl:template>

</xsl:stylesheet>