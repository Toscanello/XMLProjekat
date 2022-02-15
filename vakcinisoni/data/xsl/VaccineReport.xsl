<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:vr="http://www.vakcinisoni.com/VaccineReport"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="vaccine-report-page">
                    <fo:region-body margin="30px 20px"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="vaccine-report-page">
                <fo:flow flow-name="xsl-region-body">

                    <fo:block>
                        <fo:table>
                            <fo:table-column column-width="40%"/>
                            <fo:table-column column-width="60%"/>

                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block margin-left="10px">
                                            <fo:external-graphic src="https://euprava.gov.rs/media/logos/Batut.gif" content-height="scale-to-fit" height="80px"  content-width="70px" scaling="non-uniform"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell font-family="Arial" font-size="10px" text-align="center" margin-left="25px">
                                        <fo:block linefeed-treatment="preserve" font-weight="bold">ИНСТИТУТ ЗА ЈАВНО ЗДРАВЉЕ СРБИЈЕ
                                            "Др Милан Јовановић Батут"
                                        </fo:block>
                                        <fo:block linefeed-treatment="preserve" color="#8f8f8f" font-weight="bold">INSTITUT ZA JAVNO ZDRAVLJE SRBIJE
                                            "Dr Milan Jovanović Batut"
                                        </fo:block>
                                        <fo:block linefeed-treatment="preserve" color="#8f8f8f" font-weight="bold">INSTITUTE OF PUBLIC HEALTH OF SERBIA
                                            "Dr Milan Jovanovic Batut"
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block font-family="Arial" font-weight="bold" font-size="9px" padding-top="10px">
                        Шифра потврде вакцинације:
                        <fo:inline>
                            <xsl:value-of select="vr:vaccinationReport/vr:id"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Arial" font-size="9px" color="#8f8f8f">
                        Šifra potvrde / Confirmation code
                    </fo:block>

                    <fo:block font-family="Arial" font-size="12px" font-weight="bold" padding-top="20px" text-align="center">
                        ПОТВРДА О ИЗВРШЕНОЈ ВАКЦИНАЦИЈИ ПРОТИВ COVID-19
                    </fo:block>
                    <fo:block font-family="Arial" font-size="9px" color="#8f8f8f" linefeed-treatment="preserve" text-align="center">POTVRDA O IZVRŠENOJ VAKCINACIJI PROTIV COVID-19
                        CONFIRMATION OF THE COVID-19 VACCINATION
                    </fo:block>

                    <fo:block font-family="Arial" font-size="11px" font-weight="bold" padding-top="20px">
                        Име и презиме:
                        <fo:inline>
                            <xsl:value-of select="vr:vaccinationReport/vr:fullName"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Arial" font-size="9px" color="#8f8f8f">
                        Ime i prezime / First and Last Name
                    </fo:block>

                    <fo:block font-family="Arial" font-size="11px" font-weight="bold" padding-top="20px">
                        Датум рођења:
                        <fo:inline>
                            <xsl:value-of select="vr:vaccinationReport/vr:birthDate"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Arial" font-size="9px" color="#8f8f8f">
                        Datum rođenja / Date of Birth
                    </fo:block>

                    <fo:block font-family="Arial" font-size="11px" font-weight="bold" padding-top="20px">
                        Пол:
                        <fo:inline>
                            <xsl:value-of select="vr:vaccinationReport/vr:gender"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Arial" font-size="9px" color="#8f8f8f">
                        Pol / Gender
                    </fo:block>

                    <fo:block font-family="Arial" font-size="11px" font-weight="bold" padding-top="20px">
                        ЈМБГ:
                        <fo:inline>
                            <xsl:value-of select="vr:vaccinationReport/vr:jmbg"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Arial" font-size="9px" color="#8f8f8f">
                        JMBG / Personal No.
                    </fo:block>

                    <xsl:for-each select="vr:vaccinationReport/vr:doses/vr:dose">
                        <fo:block font-family="Arial" font-size="11px" font-weight="bold" padding-top="20px">
                            Датум давања и број серије дозе вакцине:
                            <fo:inline>
                                <xsl:value-of select="vr:date"/>
                            </fo:inline>
                            , серија:
                            <fo:inline>
                                <xsl:value-of select="vr:batch"/>
                            </fo:inline>
                        </fo:block>
                        <fo:block font-family="Arial" font-size="9px" color="#8f8f8f">
                            Datum vakcinacije / Vaccination Date
                        </fo:block>
                    </xsl:for-each>

                    <fo:block font-family="Arial" font-size="11px" font-weight="bold" padding-top="20px">
                        Здравствена установа која вакцинише:
                        <fo:inline>
                            <xsl:value-of select="vr:vaccinationReport/vr:institution"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Arial" font-size="9px" color="#8f8f8f">
                        Zdravstvena ustanova koja vakciniše / Health care institution of vaccination
                    </fo:block>

                    <fo:block font-family="Arial" font-size="11px" font-weight="bold" padding-top="20px">
                        Назив вакцине:
                        <fo:inline>
                            <xsl:value-of select="vr:vaccinationReport/vr:vaccine"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Arial" font-size="9px" color="#8f8f8f">
                        Naziv vakcine / Name of vaccine
                    </fo:block>

                    <fo:block font-family="Arial" font-size="11px" font-weight="bold" padding-top="20px">
                        Датум издавања потврде:
                        <fo:inline>
                            <xsl:value-of select="vr:vaccinationReport/vr:confirmationDate"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Arial" font-size="9px" color="#8f8f8f">
                        Datum izdavanja potvrde / Confiramtion Release Date
                    </fo:block>

                    <fo:block font-family="Arial" font-size="11px" font-weight="bold" padding-top="20px" text-align="right">
                        Здравствена установа:
                        <fo:inline>
                            <xsl:value-of select="vr:vaccinationReport/vr:institution"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Arial" font-size="9px" color="#8f8f8f" text-align="right">
                        Zdravstvena ustanova / Medical Institution
                    </fo:block>

                    <fo:block padding-top="10px">
                        <fo:table>
                            <fo:table-column column-width="80%"/>
                            <fo:table-column column-width="20%"/>

                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="11px" font-weight="bold" padding-top="80px">
                                            Ова потврда важи без потписа и печата
                                        </fo:block>
                                        <fo:block font-family="Arial" font-size="9px" color="#8f8f8f">
                                            Ova potvrda važi bez potpisa i pečata / This certificate is valid without signatures and seals
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <fo:external-graphic src="../../../../../../data/xsl/images/qr-code.png" content-height="scale-to-fit" height="100px"  content-width="100px" scaling="non-uniform"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                </fo:flow>
            </fo:page-sequence>

        </fo:root>
    </xsl:template>

</xsl:stylesheet>