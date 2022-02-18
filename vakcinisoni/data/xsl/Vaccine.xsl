<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:v="http://www.vakcinisoni.com"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="term-page">
                    <fo:region-body margin="30px 20px"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
        </fo:root>
    </xsl:template>

    <fo:page-sequence master-reference="term-page">
        <fo:flow flow-name="term-body">
            <block>
                <fo:table>
                    <fo:table-column column-width="40%"/>
                    <fo:table-column column-width="60%"/>

                    <fo:table-body>
                        <fo:table-row font-family="Arial" font-size="13px" text-align="center">
                            <fo:table-cell>
                                <fo:block font-weight="bold">
                                    Произвођач:
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block margin-left="20px">
                                    <xsl:value-of select="v:vaccine/v:manufacturer"/>
                                </fo:block>
                            </fo:table-cell>
                        </fo:table-row>
                        <fo:table-row font-family="Arial" font-size="13px" text-align="center">
                            <fo:table-cell>
                                <fo:block font-weight="bold">
                                    Име:
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block margin-left="20px">
                                    <xsl:value-of select="v:vaccine/v:name"/>
                                </fo:block>
                            </fo:table-cell>
                        </fo:table-row>
                        <fo:table-row font-family="Arial" font-size="13px" text-align="center">
                            <fo:table-cell>
                                <fo:block font-weight="bold">
                                    Количина:
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block margin-left="20px">
                                    <xsl:value-of select="v:vaccine/v:quantity"/>
                                </fo:block>
                            </fo:table-cell>
                        </fo:table-row>
                    </fo:table-body>
                </fo:table>
            </block>
        </fo:flow>
    </fo:page-sequence>

</xsl:stylesheet>