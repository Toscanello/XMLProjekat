<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:t="http://www.vakcinisoni.com"
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
                                    Почетак:
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block margin-left="20px">
                                    <xsl:value-of select="substring(t:term/t:start, 11, string-length(t:term/t:start)-1)"/>
                                    <fo:inline>
                                        <xsl:value-of select="substring(t:term/t:start, 1, 10)"/>
                                    </fo:inline>
                                </fo:block>
                            </fo:table-cell>
                        </fo:table-row>
                        <fo:table-row font-family="Arial" font-size="13px" text-align="center">
                            <fo:table-cell>
                                <fo:block font-weight="bold">
                                    Крај:
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block margin-left="20px">
                                    <xsl:value-of select="substring(t:term/t:finish, 11, string-length(t:term/t:finish)-1)"/>
                                    <fo:inline>
                                        <xsl:value-of select="substring(t:term/t:finish, 1, 10)"/>
                                    </fo:inline>
                                </fo:block>
                            </fo:table-cell>
                        </fo:table-row>
                        <fo:table-row font-family="Arial" font-size="13px" text-align="center">
                            <fo:table-cell>
                                <fo:block font-weight="bold">
                                    Заузет:
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block margin-left="20px">
                                    <xsl:value-of select="t:term/t:taken"/>
                                </fo:block>
                            </fo:table-cell>
                        </fo:table-row>
                        <fo:table-row font-family="Arial" font-size="13px" text-align="center">
                            <fo:table-cell>
                                <fo:block font-weight="bold">
                                    Локација:
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block margin-left="20px">
                                    <xsl:value-of select="t:term/t:location"/>
                                </fo:block>
                            </fo:table-cell>
                        </fo:table-row>
                    </fo:table-body>
                </fo:table>
            </block>
        </fo:flow>
    </fo:page-sequence>

</xsl:stylesheet>