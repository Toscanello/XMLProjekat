<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ir="http://www.vakcinisoni.com/ImmunizationReport"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="immunization-report-page">
                    <fo:region-body margin="0.75in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="immunization-report-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="Times New Roman" font-size="14px" font-weight="bold" padding="10px" text-align="center" padding-bottom="30px">
                        Извештај о имунизацији
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px" padding-bottom="30px">
                        Извештај се односи на период од
                        <fo:inline font-weight="bold" font-family="Times New Roman" font-size="12px">
                            <xsl:value-of select="ir:immunizationReport/ir:startDate"/>
                        </fo:inline>
                        до
                        <fo:inline font-weight="bold" font-family="Times New Roman" font-size="12px">
                            <xsl:value-of select="ir:immunizationReport/ir:finishDate"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px">
                        У напоменутом временском интервалу је:
                    </fo:block>
                    <!-- list start -->
                    <fo:list-block margin-left="20px">
                        <!-- list item -->
                        <fo:list-item>
                            <!-- insert a bullet -->
                            <fo:list-item-label end-indent="label-end()">
                                <fo:block>
                                    <fo:inline linefeed-treatment="preserve">•</fo:inline>
                                </fo:block>
                            </fo:list-item-label>
                            <!-- list text -->
                            <fo:list-item-body start-indent="body-start()">
                                <fo:block font-family="Times New Roman" text-align="justify">
                                    поднето
                                    <fo:inline font-weight="bold" font-family="Times New Roman" font-size="12px">
                                        <xsl:value-of select="ir:immunizationReport/ir:immunizationRequests"/>
                                    </fo:inline>
                                    докумената о интересовању за имунизацију
                                </fo:block>
                            </fo:list-item-body>
                        </fo:list-item>
                        <fo:list-item>
                            <!-- insert a bullet -->
                            <fo:list-item-label end-indent="label-end()">
                                <fo:block>
                                    <fo:inline linefeed-treatment="preserve">•</fo:inline>
                                </fo:block>
                            </fo:list-item-label>
                            <!-- list text -->
                            <fo:list-item-body start-indent="body-start()">
                                <fo:block font-family="Times New Roman" text-align="justify">
                                    примљено
                                    <fo:inline font-weight="bold" font-family="Times New Roman" font-size="12px">
                                        <xsl:value-of select="ir:immunizationReport/ir:certificateRequests"/>
                                    </fo:inline>
                                    захтева за дигитални зелени сертификат, од којих је
                                    <fo:inline font-weight="bold" font-family="Times New Roman" font-size="12px">
                                        <xsl:value-of select="ir:immunizationReport/ir:certificatesIssued"/>
                                    </fo:inline>
                                    издато
                                </fo:block>
                            </fo:list-item-body>
                        </fo:list-item>
                    </fo:list-block>
                    <!-- end list -->
                    <fo:block font-family="Times New Roman" font-size="12px" padding-top="30px" padding-bottom="30px">
                        Примљено је
                        <fo:inline font-weight="bold" font-family="Times New Roman" font-size="12px">
                            <xsl:value-of select="ir:immunizationReport/ir:vaccinesTaken"/>
                        </fo:inline>
                        доза вакцине против covid-19 вируса, од чега је
                        <fo:inline font-weight="bold" font-family="Times New Roman" font-size="12px">
                            <xsl:value-of select="ir:immunizationReport/ir:firstTimeVaccineTaken"/>
                        </fo:inline>
                        ново вакцинисаних.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="12px">
                        Расподела по произвођачима је:
                    </fo:block>
                    <!-- list start -->
                        <fo:list-block margin-left="20px">
                        <!-- list item -->
                            <xsl:for-each select="ir:immunizationReport/ir:manufacturers/ir:manufacturer">
                                <fo:list-item>
                                <!-- insert a bullet -->
                                    <fo:list-item-label end-indent="label-end()">
                                        <fo:block>
                                            <fo:inline linefeed-treatment="preserve">•</fo:inline>
                                        </fo:block>
                                    </fo:list-item-label>
                                    <!-- list text -->
                                    <fo:list-item-body start-indent="body-start()">
                                        <fo:block font-family="Times New Roman" text-align="justify">
                                            <fo:inline font-weight="bold" font-family="Times New Roman" font-size="12px">
                                                <xsl:value-of select="ir:name"/>
                                            </fo:inline>
                                            -
                                            <fo:inline font-weight="bold" font-family="Times New Roman" font-size="12px">
                                                <xsl:value-of select="ir:numberOfVaccines"/>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:list-item-body>
                                </fo:list-item>
                            </xsl:for-each>
                        </fo:list-block>
                    <!-- end list -->
                    <fo:block font-family="Times New Roman" font-size="12px" padding-top="40px">
                        Извештај издат
                        <fo:inline font-weight="bold">
                            <xsl:value-of select="substring(ir:immunizationReport/ir:reportDate, 6, 2)"/>
                            .
                            <xsl:value-of select="substring(ir:immunizationReport/ir:reportDate, 9, 2)"/>
                            .
                            <xsl:value-of select="substring(ir:immunizationReport/ir:reportDate, 1, 4)"/>
                        </fo:inline>
                        године
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>