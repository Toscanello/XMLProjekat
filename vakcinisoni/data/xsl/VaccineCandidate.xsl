<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:vc="http://www.vakcinisoni.com/VaccineCandidate"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="vaccine-candidate-page">
                    <fo:region-body margin="0.75in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="vaccine-candidate-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="Times New Roman" font-size="14px" font-weight="bold" padding="10px" text-align="center" padding-bottom="30px">
                        Исказивање интересовања за вакцинисање против COVID-19
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px">
                        Одаберите опцију:
                        <fo:inline font-weight="bold" font-family="Times New Roman" font-size="12px">
                            <xsl:value-of select="vc:vaccineCandidate/vc:residence"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-top="10px">
                        ЈМБГ:
                        <fo:inline font-weight="bold" font-family="Times New Roman" font-size="16px" padding-left="10px">
                            <xsl:value-of select="vc:vaccineCandidate/vc:jmbg"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-top="10px">
                        Име:
                        <fo:inline font-weight="bold" font-family="Times New Roman" font-size="16px" padding-left="10px">
                            <xsl:value-of select="vc:vaccineCandidate/vc:name"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-top="10px">
                        Презиме:
                        <fo:inline font-weight="bold" font-family="Times New Roman" font-size="16px" padding-left="10px">
                            <xsl:value-of select="vc:vaccineCandidate/vc:surname"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-top="10px">
                        Адреса електронске поште:
                        <fo:inline font-weight="bold" font-family="Times New Roman" font-size="16px" padding-left="10px">
                            <xsl:value-of select="vc:vaccineCandidate/vc:email"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-top="10px">
                        Број мобилног телефона (навести број у формату 06X..... без размака и цртица):
                    </fo:block>
                    <fo:block font-weight="bold" font-family="Times New Roman" font-size="16px" padding-top="10px" margin-left="30px">
                        <xsl:value-of select="vc:vaccineCandidate/vc:phoneNum"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-top="10px">
                        Број фиксног телефона (навести број у формату нпр. 011..... без размака и цртица):
                    </fo:block>
                    <fo:block font-weight="bold" font-family="Times New Roman" font-size="16px" padding-top="10px" margin-left="30px">
                        <xsl:value-of select="vc:vaccineCandidate/vc:homeNum"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-top="10px">
                        Одаберите локацију где желите да примите вакцину (унесите општину):
                    </fo:block>
                    <fo:block font-weight="bold" font-family="Times New Roman" font-size="16px" padding-top="10px" margin-left="30px">
                        <xsl:value-of select="vc:vaccineCandidate/vc:location"/>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-top="10px">
                        Исказујем интересовање да примим искључиво вакцину следећих произвођача за који Агенција за лекове и медицинска средства потврди безбедност, ефикасност и квалитет и изда дозволу за употребу лека:
                    </fo:block>
                    <fo:list-block margin-left="20px" margin-top="10px">
                        <xsl:for-each select="vc:vaccineCandidate/vc:options/vc:manufacturer">
                            <fo:list-item>
                                <fo:list-item-label end-indent="label-end()">
                                    <fo:block>
                                        <fo:inline linefeed-treatment="preserve">•</fo:inline>
                                    </fo:block>
                                </fo:list-item-label>
                                <fo:list-item-body start-indent="body-start()">
                                    <fo:block font-family="Times New Roman" text-align="justify">
                                        <fo:inline font-weight="bold" font-family="Times New Roman" font-size="12px">
                                            <xsl:value-of select="text()"/>
                                        </fo:inline>
                                    </fo:block>
                                </fo:list-item-body>
                            </fo:list-item>
                        </xsl:for-each>
                    </fo:list-block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-top="10px">
                        Да ли сте добровољни давалац крви?
                        <fo:inline font-weight="bold" font-family="Times New Roman" font-size="16px" padding-left="10px">
                            <xsl:value-of select="vc:vaccineCandidate/vc:isBloodDonor"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-bottom="5px" padding-top="50px">
                        дана
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="substring(vc:vaccineCandidate/vc:date, 6, string-length(vc:vaccineCandidate/vc:date)-1)"/>
                        </fo:inline>
                        20
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="substring(vc:vaccineCandidate/vc:date, 3, 2)"/>
                        </fo:inline>
                        године
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>