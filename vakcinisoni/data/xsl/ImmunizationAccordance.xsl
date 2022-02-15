<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ia="http://www.vakcinisoni.com/ImmunizationAccordance"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="immunization-accordance-page">
                    <fo:region-body margin="30px 30px"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="immunization-accordance-page">
                <fo:flow flow-name="xsl-region-body">

                    <fo:block>
                        <fo:table>
                            <fo:table-column column-width="70%"/>
                            <fo:table-column column-width="10%"/>
                            <fo:table-column column-width="20%"/>

                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block linefeed-treatment="preserve" font-family="Arial" font-size="18px" font-weight="bold" padding-top="5px">САГЛАСНОСТ ЗА СПРОВОЂЕЊЕ
                                            ПРЕПОРУЧЕНЕ ИМУНИЗАЦИЈЕ
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <fo:external-graphic src="https://euprava.gov.rs/media/logos/Batut.gif" content-height="scale-to-fit" height="50px"  content-width="40px" scaling="non-uniform"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block linefeed-treatment="preserve" font-family="Arial" font-size="7px" padding-top="15px">ИНСТИТУТ ЗА
                                            ЈАВНО ЗДРАВЉЕ СРБИЈЕ
                                            "Др Милан Јовановић Батут"
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block padding-top="20px">
                        <fo:table>
                            <fo:table-column column-width="15%"/>
                            <fo:table-column column-width="85%"/>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" font-weight="bold">
                                            Држављанство
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px">
                                            1) Република Србија | ЈМБГ
                                            <fo:inline font-weight="bold">
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:jmbg"/>
                                                </fo:inline>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px">
                                            2)
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block>
                        <fo:table>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            Презиме
                                            <fo:inline>
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:surname"/>
                                                </fo:inline>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            Име
                                            <fo:inline>
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:name"/>
                                                </fo:inline>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            Име родитеља
                                            <fo:inline>
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:parentName"/>
                                                </fo:inline>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block>
                        <fo:table>
                            <fo:table-column column-width="20%"/>
                            <fo:table-column column-width="40%"/>
                            <fo:table-column column-width="40%"/>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            Пол:
                                            <fo:inline>
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:gender"/>
                                                </fo:inline>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            Датум рођења
                                            <fo:inline>
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:birthDate"/>
                                                </fo:inline>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            Место рођења
                                            <fo:inline>
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:birthPlace"/>
                                                </fo:inline>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block>
                        <fo:table>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            Адреца (улица и број)
                                            <fo:inline>
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:address"/>
                                                </fo:inline>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            Место/Насеље
                                            <fo:inline>
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:post"/>
                                                </fo:inline>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block>
                        <fo:table>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            Општина/Град
                                            <fo:inline>
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:city"/>
                                                </fo:inline>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            Тел. фиксни
                                            <fo:inline>
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:homeNumber"/>
                                                </fo:inline>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block>
                        <fo:table>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            Тел. мобилни
                                            <fo:inline>
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:phoneNum"/>
                                                </fo:inline>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            имејл
                                            <fo:inline>
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:email"/>
                                                </fo:inline>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                        Радни статус:
                        <fo:inline>
                            <fo:inline border-after-width="1pt" border-after-style="solid">
                                <xsl:value-of select="ia:accordance/ia:workStatus"/>
                            </fo:inline>
                        </fo:inline>
                    </fo:block>

                    <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                        Занимање запосленог:
                        <fo:inline>
                            <fo:inline border-after-width="1pt" border-after-style="solid">
                                <xsl:value-of select="ia:accordance/ia:employedAt"/>
                            </fo:inline>
                        </fo:inline>
                    </fo:block>

                    <fo:block>
                        <fo:table>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            Корисник установе соц. зашт.
                                            <fo:inline>
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:socialSecurity"/>
                                                </fo:inline>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            Назив и општина седишта
                                            <fo:inline>
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:residenceName"/>
                                                </fo:inline>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block>
                        <fo:table>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            Изјављујем да:
                                            <fo:inline>
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:isAccordant"/>
                                                </fo:inline>
                                            </fo:inline>
                                            са спровођењем активне/пасивне имунизације:
                                            <fo:inline>
                                                <fo:inline border-after-width="1pt" border-after-style="solid">
                                                    <xsl:value-of select="ia:accordance/ia:medicineName"/>
                                                </fo:inline>
                                            </fo:inline>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                        Лекар ми је објаснио предности и ризике од спровођења активне/пасивне имунизације наведеним имунолошким леком.
                    </fo:block>

                    <fo:block>
                        <fo:table>
                            <fo:table-column column-width="70%"/>
                            <fo:table-column column-width="30%"/>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            Потпис пацијента или законског заступника пацијента
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-family="Arial" font-size="9px" padding-top="10px" font-weight="bold">
                                            Датум:
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block padding-top="20px">
                                            <fo:leader leader-pattern="rule" leader-length="70%" rule-style="solid" rule-thickness="1pt"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block padding-top="20px">
                                            <xsl:value-of select="ia:accordance/ia:date"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>

                    <fo:block>
                        <fo:leader leader-pattern="rule" leader-length="100%" rule-style="solid" rule-thickness="2pt"/>
                    </fo:block>

                    <fo:block font-family="Arial" font-size="15px" padding-top="10px" text-align="center">
                        ЕВИДЕНЦИЈА О ВАКЦИНАЦИЈИ ПРОТИВ COVID-19
                    </fo:block>
                    <fo:block font-family="Arial" font-size="9px" text-align="center">
                        (попуњава здравствени радник)
                    </fo:block>

                    <fo:block font-family="Arial" font-size="9px" padding-top="10px">
                        Здравствена установа
                        <fo:inline font-weight="bold">
                            <fo:inline border-after-width="1pt" border-after-style="solid">
                                <xsl:value-of select="ia:accordance/ia:vaccineEvidence/ia:institution"/>
                            </fo:inline>
                        </fo:inline>
                        Вакцинацијски пункт
                        <fo:inline font-weight="bold">
                            <fo:inline border-after-width="1pt" border-after-style="solid">
                                <xsl:value-of select="ia:accordance/ia:vaccineEvidence/ia:vaccinationNum"/>
                            </fo:inline>
                        </fo:inline>
                    </fo:block>

                    <fo:block font-family="Arial" font-size="9px" padding-top="10px">
                        Име, презиме, факсимил и бр. телефона лекара:
                        <fo:inline font-weight="bold">
                            <fo:inline border-after-width="1pt" border-after-style="solid">
                                <xsl:value-of select="ia:accordance/ia:vaccineEvidence/ia:doctorInfo/ia:fullName"/>
                                ,
                                <xsl:value-of select="ia:accordance/ia:vaccineEvidence/ia:doctorInfo/ia:fax"/>
                                ,
                                <xsl:value-of select="ia:accordance/ia:vaccineEvidence/ia:doctorInfo/ia:phoneNum"/>
                            </fo:inline>
                        </fo:inline>
                    </fo:block>

                    <fo:block font-family="Arial" font-size="9px" padding-top="10px">
                        Пре давања вакцине прегледати особу и упознати је са користима и о могућим нежељеним реакцијама после вакцинације. Обавезно уписати сваку дату вакцину и све тражене податке у овај образац и податке унети у лични картон о извршеним имунизацијама и здравствени картон.
                    </fo:block>

                    <fo:block padding-top="10px">
                        <fo:table font-family="Arial" font-size="9px" text-align="center" border="solid 1px black">
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell border="solid 1px black" display-align="center">
                                        <fo:block>
                                            Назив вакцине
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="solid 1px black" display-align="center">
                                        <fo:block>
                                            Датум давања вакцине (V1 i V2)
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="solid 1px black" display-align="center">
                                        <fo:block>
                                            Начин давања вакцине
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="solid 1px black" display-align="center">
                                        <fo:block>
                                            Екстремитет
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="solid 1px black" display-align="center">
                                        <fo:block>
                                            Серија вакцине (лот)
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="solid 1px black" display-align="center">
                                        <fo:block>
                                            Произвођач
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="solid 1px black" display-align="center">
                                        <fo:block>
                                            Нежељена реакција
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="solid 1px black" display-align="center">
                                        <fo:block>
                                            Потпис лекара
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <xsl:for-each select="ia:accordance/ia:vaccineEvidence/ia:table/ia:row">
                                    <fo:table-row>
                                        <fo:table-cell border="solid 1px black" display-align="center" padding="5px 0px">
                                            <fo:block>
                                                <xsl:value-of select="ia:vaccineName"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border="solid 1px black" display-align="center" padding="5px 0px">
                                            <fo:block>
                                                <xsl:value-of select="ia:dateIssued"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border="solid 1px black" display-align="center" padding="5px 0px">
                                            <fo:block>
                                                <xsl:value-of select="ia:issueMethod"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border="solid 1px black" display-align="center" padding="5px 0px">
                                            <fo:block>
                                                <xsl:value-of select="ia:bodyPart"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border="solid 1px black" display-align="center" padding="5px 0px">
                                            <fo:block>
                                                <xsl:value-of select="ia:batch"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border="solid 1px black" display-align="center" padding="5px 0px">
                                            <fo:block>
                                                <xsl:value-of select="ia:manufacturer"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border="solid 1px black" display-align="center" padding="5px 0px">
                                            <fo:block>
                                                <xsl:value-of select="ia:reaction"/>
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border="solid 1px black" display-align="center" padding="5px 0px">
                                            <fo:block>

                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </xsl:for-each>
                                <fo:table-row text-align="left">
                                    <fo:table-cell number-columns-spanned="8" border="solid 1px black" display-align="center" padding="5px 0px">
                                        <fo:block>
                                            <fo:table>
                                                <fo:table-column column-width="40%"/>
                                                <fo:table-column column-width="60%"/>
                                                <fo:table-body>
                                                    <fo:table-row>
                                                        <fo:table-cell padding-left="5px">
                                                            <fo:block>
                                                                Привремене контраиндикације (датум утврђивања и дијагноза):
                                                            </fo:block>
                                                        </fo:table-cell>
                                                        <fo:table-cell>
                                                            <fo:block>
                                                                <xsl:value-of select="ia:accordance/ia:vaccineEvidence/ia:table/ia:contraindications/ia:date"/>
                                                                ,
                                                                <xsl:value-of select="ia:accordance/ia:vaccineEvidence/ia:table/ia:contraindications/ia:diagnosis"/>
                                                            </fo:block>
                                                        </fo:table-cell>
                                                    </fo:table-row>
                                                </fo:table-body>
                                            </fo:table>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row text-align="left">
                                    <fo:table-cell number-columns-spanned="8" border="solid 1px black" display-align="center" padding="5px 0px">
                                        <fo:block>
                                            <fo:table>
                                                <fo:table-column column-width="70%"/>
                                                <fo:table-column column-width="30%"/>
                                                <fo:table-body>
                                                    <fo:table-row>
                                                        <fo:table-cell padding-left="5px">
                                                            <fo:block>
                                                                Одлука комисије за трајне контраиндикације (ако постоји, уписати Да)
                                                            </fo:block>
                                                        </fo:table-cell>
                                                        <fo:table-cell>
                                                            <fo:block>
                                                                <xsl:value-of select="ia:accordance/ia:vaccineEvidence/ia:table/ia:contraindications/ia:permanent"/>
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

                    <fo:block font-family="Arial" font-size="9px" padding-top="5px">
                        <fo:inline font-weight="bold">
                            Напомена:
                        </fo:inline>
                        Образац се чува као део медицинске документације пацијента.
                    </fo:block>

                </fo:flow>
            </fo:page-sequence>

        </fo:root>
    </xsl:template>
</xsl:stylesheet>