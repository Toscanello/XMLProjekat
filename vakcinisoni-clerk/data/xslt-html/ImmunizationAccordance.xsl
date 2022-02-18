<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ia="http://www.vakcinisoni.com" version="2.0">

    <xsl:template match="/">

        <html>
            <head>
                <title>Immunization Accordance</title>
                <style>
                    body {
                        font-family: Arial;
                    }
                    .container {
                        max-width: 700px;
                        margin: 0 auto;
                        margin-bottom: 50px;
                    }
                    header {
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                        margin-top: 30px;
                        margin-bottom: 20px;
                    }
                    header div img {
                        height: 60px;
                        weight: 40px;
                    }
                    header h1 {
                        font-size: 20px;
                        margin: 3px 0px;
                    }
                    header .logo-div {
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                        column-gap: 10px;
                    }
                    header .logo-div p {
                        margin: 0px;
                    }
                    header div p {
                        font-size: 9px;
                    }
                    .patient-container, .lekar-cnt {
                        font-size: 11px;
                    }
                    .lekar-cnt {
                        margin-top: 20px;
                    }
                    .drzavljanstvo {
                        display: flex;
                    }
                    .mr-1 {
                        margin-right: 10px;
                    }
                    .ml-1 {
                        margin-left: 10px;
                    }
                    .ul {
                        text-decoration: underline
                    }
                    .data {
                        display: flex;
                        justify-content: space-between;
                    }
                    .grid-3 {
                        display: grid;
                        grid-template-columns: 1fr 1fr 1fr;
                    }
                    .grid-2 {
                        display: grid;
                        grid-template-columns: 1fr 1fr;
                    }
                    .colum-gap {
                        column-gap: 100px;
                    }
                    .pt-1 {
                        padding-top: 20px;
                    }
                    .lekar-content {
                        text-align: center;
                    }
                    .title-lekar {
                        font-size: 16px;
                        margin-bottom: 0;
                    }
                    .subtitle-lekar {
                        margin: 0;
                        font-size: 11px;
                    }
                    .lekar-tabela table {
                        margin-top: 10px;
                        font-size: 11px;
                        border-collapse: collapse;
                    }
                    .lekar-tabela td {
                        border: solid 1px black;
                        text-align: center;
                        padding: 10px;
                    }
                    .ta-left {
                        text-align: left !important;
                    }
                    .border {
                        border: solid 1px black;
                    }
                    .no-border {
                        border: none !important;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <header>
                        <div>
                            <h1>САГЛАСНОСТ ЗА СПРОВОЂЕЊЕ</h1>
                            <h1>ПРЕПОРУЧЕНЕ ИМУНИЗАЦИЈЕ</h1>
                        </div>
                        <div class="logo-div">
                            <img src="https://euprava.gov.rs/media/logos/Batut.gif"/>
                            <div>
                                <p>ИНСТИТУТ ЗА</p>
                                <p>ЈАВНО ЗДРАВЉЕ СРБИЈЕ</p>
                                <p>"Др Милан Јовановић Батут"</p>
                            </div>
                        </div>
                    </header>

                    <div class="patient-container">
                        <div class="drzavljanstvo">
                            <p class="mr-1"><b>Држављанство</b></p>
                            <p>1) Република Србија | ЈМБГ</p>
                            <p class="ul ml-1"><b><xsl:value-of select="ia:accordance/ia:jmbg"/></b></p>
                        </div>
                        <div class="grid-3">
                            <p>
                                <b>Презиме</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:surname"/></b>
                            </p>
                            <p>
                                <b>Име</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:name"/></b>
                            </p>
                            <p>
                                <b>Име родитеља</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:parentName"/></b>
                            </p>
                        </div>

                        <div class="grid-3">
                            <p>
                                <b>Пол:</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:gender"/></b>
                            </p>
                            <p>
                                <b>Датум рођења</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:birthDate"/></b>
                            </p>
                            <p>
                                <b>Место рођења</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:birthPlace"/></b>
                            </p>
                        </div>

                        <div class="grid-2">
                            <p>
                                <b>Адреца (улица и број)</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:address"/></b>
                            </p>
                            <p>
                                <b>Место/Насеље</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:post"/></b>
                            </p>
                        </div>

                        <div class="grid-2">
                            <p>
                                <b>Општина/Град</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:city"/></b>
                            </p>
                            <p>
                                <b>Тел. фиксни</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:homeNumber"/></b>
                            </p>
                        </div>

                        <div class="grid-2">
                            <p>
                                <b>Тел. мобилни</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:phoneNum"/></b>
                            </p>
                            <p>
                                <b>имејл</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:email"/></b>
                            </p>
                        </div>

                        <div class="data">
                            <p>
                                <b>Радни статус:</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:workStatus"/></b>
                            </p>
                        </div>

                        <div class="data">
                            <p>
                                <b>Занимање запосленог:</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:employedAt"/></b>
                            </p>
                        </div>

                        <div class="grid-2">
                            <p>
                                <b>Корисник установе соц. зашт.</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:socialSecurity"/></b>
                            </p>
                            <p>
                                <b>Назив и општина седишта</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:residenceName"/></b>
                            </p>
                        </div>

                        <div class="data">
                            <p>
                                <b>Изјављујем да:</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:isAccordant"/></b>
                                <b>са спровођењем активне/пасивне имунизације:</b>
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:medicineName"/></b>
                            </p>
                        </div>

                        <div class="data">
                            <p>
                                <b>Лекар ми је објаснио предности и ризике од спровођења активне/пасивне имунизације наведеним имунолошким леком.</b>
                            </p>
                        </div>

                        <div class="grid-2 colum-gap">
                            <div>
                                <p class="pb-1">
                                    <b>Потпис пацијента или законског заступника пацијента</b>
                                </p>
                                <br/>
                                <hr/>
                            </div>
                            <div>
                                <p class="pb-1">
                                    <b>Датум:</b>
                                </p>
                                <p class="ul pt-1">
                                    <xsl:value-of select="ia:accordance/ia:date"/>
                                </p>
                            </div>
                        </div>
                    </div>

                    <hr/>

                    <div class="lekar-content">
                        <p class="title-lekar">ЕВИДЕНЦИЈА О ВАКЦИНАЦИЈИ ПРОТИВ COVID-19</p>
                        <p class="subtitle-lekar">(попуњава здравствени радник)</p>
                    </div>

                    <div class="lekar-cnt">
                        <div class="data">
                            <p>
                                Здравствена установа
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:vaccineEvidence/ia:institution"/></b>
                                Вакцинацијски пункт
                                <b class="ul"><xsl:value-of select="ia:accordance/ia:vaccineEvidence/ia:vaccinationNum"/></b>
                            </p>
                        </div>
                        <div class="data">
                            <p>
                                Име, презиме, факсимил и бр. телефона лекара:
                                <b class="ul">
                                    <xsl:value-of select="ia:accordance/ia:vaccineEvidence/ia:doctorInfo/ia:fullName"/>
                                    ,
                                    <xsl:value-of select="ia:accordance/ia:vaccineEvidence/ia:doctorInfo/ia:fax"/>
                                    ,
                                    <xsl:value-of select="ia:accordance/ia:vaccineEvidence/ia:doctorInfo/ia:phoneNum"/>
                                </b>
                            </p>
                        </div>
                        <div class="data">
                            <p>
                                Пре давања вакцине прегледати особу и упознати је са користима и о могућим нежељеним реакцијама после вакцинације. Обавезно уписати сваку дату вакцину и све тражене податке у овај образац и податке унети у лични картон о извршеним имунизацијама и здравствени картон.
                            </p>
                        </div>

                        <div class="lekar-tabela">
                            <table>
                                <tr>
                                    <td>Назив вакцине</td>
                                    <td>Датум давања вакцине (V1 i V2)</td>
                                    <td>Начин давања вакцине</td>
                                    <td>Екстремитет</td>
                                    <td>Серија вакцине (лот)</td>
                                    <td>Произвођач</td>
                                    <td>Нежељена реакција</td>
                                    <td>Потпис лекара</td>
                                </tr>
                                <xsl:for-each select="ia:accordance/ia:vaccineEvidence/ia:table/ia:row">
                                    <tr>
                                        <td><xsl:value-of select="ia:vaccineName"/></td>
                                        <td><xsl:value-of select="ia:dateIssued"/></td>
                                        <td><xsl:value-of select="ia:issueMethod"/></td>
                                        <td><xsl:value-of select="ia:bodyPart"/></td>
                                        <td><xsl:value-of select="ia:batch"/></td>
                                        <td><xsl:value-of select="ia:manufacturer"/></td>
                                        <td><xsl:value-of select="ia:reaction"/></td>
                                        <td></td>
                                    </tr>
                                </xsl:for-each>
                                <tr class="border">
                                    <td colspan="5" class="ta-left no-border">Привремене контраиндикације (датум утврђивања и дијагноза):</td>
                                    <td colspan="3" class="no-border">
                                        <xsl:value-of select="ia:accordance/ia:vaccineEvidence/ia:table/ia:contraindications/ia:date"/>
                                        ,
                                        <xsl:value-of select="ia:accordance/ia:vaccineEvidence/ia:table/ia:contraindications/ia:diagnosis"/>
                                    </td>
                                </tr>
                                <tr class="border">
                                    <td colspan="5" class="ta-left no-border">Одлука комисије за трајне контраиндикације (ако постоји, уписати Да)</td>
                                    <td colspan="3" class="no-border">
                                        <xsl:value-of select="ia:accordance/ia:vaccineEvidence/ia:table/ia:contraindications/ia:permanent"/>
                                    </td>
                                </tr>
                            </table>

                            <p>
                                <b>Напомена:</b>
                                Образац се чува као део медицинске документације пацијента.
                            </p>

                        </div>

                    </div>

                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>