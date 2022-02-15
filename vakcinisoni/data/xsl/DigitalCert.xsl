<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:dc="http://www.vakcinisoni.com/DigitalCert"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="digital-cert-page">
                    <fo:region-body margin="20px 5px"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="digital-cert-page">
                <fo:flow flow-name="xsl-region-body">

                    <fo:block>
                        <fo:table>
                            <fo:table-column column-width="25%"/>
                            <fo:table-column column-width="50%"/>
                            <fo:table-column column-width="25%"/>

                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block linefeed-treatment="preserve" font-family="Arial" font-size="9px" font-weight="bold" text-align="center">
                                            <fo:external-graphic src="http://www.zetss.edu.rs/wp-content/uploads/2014/11/Grb-Srbije.png" content-height="scale-to-fit" height="100px"  content-width="50px" scaling="non-uniform"/>
                                            РЕПУБЛИКА СРБИЈА
                                            REPUBLIC OF SERBIA
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" text-align="center">
                                            <fo:block font-size="14px" font-weight="bold">
                                                ДИГИТАЛНИ ЗЕЛЕНИ СЕРТИФИКАТ
                                            </fo:block>
                                            <fo:block font-size="12px" text-align="center">
                                                Потврда о извршеној вакцинацији против&#xA;COVID-19 и резултатима тестирања
                                            </fo:block>
                                            <fo:block font-size="14px" font-weight="bold">
                                                DIGITAL GREEN CERTIFICATE
                                            </fo:block>
                                            <fo:block font-size="12px">
                                                Certificate of vaccination against COVID-19 and test results
                                            </fo:block>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell text-align="center">
                                        <fo:block>
                                            <fo:external-graphic src="../../../../../../data/xsl/images/qr-code.png" content-height="scale-to-fit" height="100px"  content-width="100px" scaling="non-uniform"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block padding-top="20px">
                        <fo:table>
                            <fo:table-column column-width="50%"/>
                            <fo:table-column column-width="50%"/>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px">
                                            <fo:table>
                                                <fo:table-column column-width="40%"/>
                                                <fo:table-column column-width="60%"/>
                                                <fo:table-body>
                                                    <fo:table-row>
                                                        <fo:table-cell>
                                                            <fo:block font-weight="bold">
                                                                Број сертификата/
                                                                Certificate ID:
                                                            </fo:block>
                                                        </fo:table-cell>
                                                        <fo:table-cell padding="5px">
                                                            <fo:block>
                                                                <xsl:value-of select="dc:certificate/dc:id"/>
                                                            </fo:block>
                                                        </fo:table-cell>
                                                    </fo:table-row>
                                                </fo:table-body>
                                            </fo:table>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px">
                                            <fo:table>
                                                <fo:table-column column-width="70%"/>
                                                <fo:table-column column-width="30%"/>
                                                <fo:table-body>
                                                    <fo:table-row>
                                                        <fo:table-cell font-weight="bold">
                                                            <fo:block linefeed-treatment="preserve">Датум и време издавања сертификата/
                                                                Certificate issuing date and time:
                                                            </fo:block>
                                                        </fo:table-cell>
                                                        <fo:table-cell padding="5px">
                                                            <fo:block>
                                                                22.11.2022.
                                                            </fo:block>
                                                        </fo:table-cell>
                                                    </fo:table-row>
                                                </fo:table-body>
                                            </fo:table>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block padding-top="10px">
                        <fo:table font-family="Arial" font-size="9px" border-collapse="separate" border-spacing="0px 10px">
                            <fo:table-column column-width="40%"/>
                            <fo:table-column column-width="60%"/>
                            <fo:table-body>

                                <fo:table-row>
                                    <fo:table-cell font-weight="bold">
                                        <fo:block>
                                            Име и презиме / Name and surname:
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="dc:certificate/dc:fullName"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>

                                <fo:table-row>
                                    <fo:table-cell font-weight="bold">
                                        <fo:block>
                                            Пол / Gender:
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="dc:certificate/dc:gender"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>

                                <fo:table-row>
                                    <fo:table-cell font-weight="bold">
                                        <fo:block>
                                            Датум рођења / Date of birth:
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="dc:certificate/dc:dateOfBirth"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>

                                <fo:table-row>
                                    <fo:table-cell font-weight="bold">
                                        <fo:block>
                                            ЈМБГ / Personal No. / EBS:
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="dc:certificate/dc:jmbg"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>

                                <fo:table-row>
                                    <fo:table-cell font-weight="bold">
                                        <fo:block>
                                            Број пасоша / Passport No.
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="dc:certificate/dc:passportNum"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>

                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block>
                        <fo:leader leader-pattern="rule" leader-length="100%" rule-style="solid" rule-thickness="1pt"/>
                    </fo:block>

                    <fo:block font-family="Arial" font-weight="bold" font-size="12px" text-align="center">
                        Вакцинација / Vaccination
                    </fo:block>

                    <fo:block padding-top="5px">
                        <fo:table>
                            <xsl:for-each select="dc:certificate/dc:vaccination/dc:dose">
                                <fo:table-column column-width="(100/count(//dc:dose))%"/>
                            </xsl:for-each>
                            <fo:table-body>
                                <fo:table-row>
                                    <xsl:for-each select="dc:certificate/dc:vaccination/dc:dose">
                                        <fo:table-cell>
                                            <fo:block>
                                                <fo:table>
                                                    <fo:table-column column-width="100%"/>
                                                    <fo:table-body>
                                                        <fo:table-row>
                                                            <fo:table-cell>
                                                                <fo:block font-family="Arial" font-weight="bold" font-size="9px">
                                                                    Доза / Dose:
                                                                </fo:block>
                                                            </fo:table-cell>
                                                        </fo:table-row>
                                                        <fo:table-row>
                                                            <fo:table-cell>
                                                                <fo:block font-family="Arial" font-weight="bold" font-size="9px" padding-top="5px">
                                                                    Тип / Type:
                                                                </fo:block>
                                                                <fo:block font-family="Arial" font-size="9px" padding-top="10px">
                                                                    <xsl:value-of select="dc:type"/>
                                                                </fo:block>
                                                            </fo:table-cell>
                                                        </fo:table-row>
                                                        <fo:table-row>
                                                            <fo:table-cell>
                                                                <fo:block font-family="Arial" font-weight="bold" font-size="9px" padding-top="10px">
                                                                    Произвођач и серија / Manufacturer and batch number:
                                                                </fo:block>
                                                                <fo:block font-family="Arial" font-size="9px" padding-top="10px">
                                                                    <xsl:value-of select="dc:manufacturer"/>
                                                                    ,
                                                                    <xsl:value-of select="dc:batch"/>
                                                                </fo:block>
                                                            </fo:table-cell>
                                                        </fo:table-row>
                                                        <fo:table-row>
                                                            <fo:table-cell>
                                                                <fo:block font-family="Arial" font-weight="bold" font-size="9px" padding-top="10px">
                                                                    Датум / Date:
                                                                    <fo:inline font-family="Arial" font-weight="regular" font-size="9px">
                                                                        <xsl:value-of select="dc:date"/>
                                                                    </fo:inline>
                                                                </fo:block>
                                                            </fo:table-cell>
                                                        </fo:table-row>
                                                        <fo:table-row>
                                                            <fo:table-cell>
                                                                <fo:block font-family="Arial" font-weight="bold" font-size="9px" padding-top="10px">
                                                                    Здравствена установа / Health care Institution:
                                                                </fo:block>
                                                                <fo:block font-family="Arial" font-size="9px" padding-top="10px">
                                                                    <xsl:value-of select="dc:institution"/>
                                                                </fo:block>
                                                            </fo:table-cell>
                                                        </fo:table-row>
                                                    </fo:table-body>
                                                </fo:table>
                                            </fo:block>
                                        </fo:table-cell>
                                    </xsl:for-each>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block>
                        <fo:leader leader-pattern="rule" leader-length="100%" rule-style="solid" rule-thickness="1pt"/>
                    </fo:block>

                    <fo:block font-family="Arial" font-weight="bold" font-size="9px" text-align="right" margin-right="50px">
                        Дигитални потпис / Digitally signed by:
                    </fo:block>

                    <fo:block padding-top="150px">
                        <fo:table>
                            <fo:table-column column-width="14%"/>
                            <fo:table-column column-width="57%"/>
                            <fo:table-column column-width="8%"/>
                            <fo:table-column column-width="31%"/>

                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block>
                                            <fo:external-graphic src="https://euprava.gov.rs/media/logos/Batut.gif" content-height="scale-to-fit" height="80px"  content-width="70px" scaling="non-uniform"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell font-family="Arial" font-size="9px">
                                        <fo:block font-weight="bold" linefeed-treatment="preserve">
                                            Сертификат издаје:
                                        </fo:block>
                                        <fo:block linefeed-treatment="preserve">Институт за јавно здравство Србије
                                            "Др Милан Јовановић Батут"
                                        </fo:block>
                                        <fo:block font-weight="bold">
                                            Certificate issued by:
                                        </fo:block>
                                        <fo:block linefeed-treatment="preserve">Institute of Public Heath of Serbia
                                            "Dr Milan Jovanović Butut"
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block padding-top="5px">
                                            <fo:external-graphic src="http://www.zetss.edu.rs/wp-content/uploads/2014/11/Grb-Srbije.png" content-height="scale-to-fit" height="60px"  content-width="30px" scaling="non-uniform"/>
                                        </fo:block>
                                    </fo:table-cell >
                                    <fo:table-cell font-family="Arial" font-size="7px">
                                        <fo:block linefeed-treatment="preserve" padding-top="5px">
                                            РЕПУБЛИКА СРБИЈА
                                            Влада Републике Србије
                                            Канцеларија за информационе
                                            технологије и електронску управу
                                            Немањина 11, БЕОГРАД
                                            Датум: 12.05.2021.
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