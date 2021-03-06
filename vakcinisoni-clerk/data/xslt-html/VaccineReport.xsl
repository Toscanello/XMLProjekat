<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:vr="http://www.vakcinisoni.com" version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Vaccine Report</title>
                <style>
                    body {
                        font-family: Arial;
                    }
                    .container {
                        max-width: 700px;
                        margin: 0 auto;
                    }
                    header {
                        margin-top: 20px;
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                    }
                    header img {
                        height: 100px;
                        width: 80px;
                    }
                    header div {
                        text-align: center;
                    }
                    header div p {
                        font-size: 13px;
                        line-height: 10px;
                        color: #8f8f8f;
                    }
                    header div b {
                        color: black;
                    }
                    .title {
                        text-align: center;
                        margin-top: 50px;
                        margin-bottom: 50px;
                    }
                    .title h1 {
                        margin: 0;
                        font-size: 18px;
                    }
                    .title p {
                        color: #8f8f8f;
                        margin: 0;
                        font-size: 13px;
                    }

                    .data {
                        font-size: 13px;
                        margin-top: 20px;
                    }
                    .data p {
                        margin: 0;
                    }
                    .data .data__second {
                        color: #8f8f8f;
                        margin-top: 5px;
                    }
                    .right {
                        text-align: right;
                    }
                    .footer {
                        display: flex;
                        justify-content: space-between;
                        align-items: end;
                    }
                    .footer img {
                        height: 150px;
                        width: 150px;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <header>
                        <img src="https://euprava.gov.rs/media/logos/Batut.gif"/>
                        <div>
                            <p>
                                <b>
                                    ???????????????? ???? ?????????? ?????????????? ????????????
                                    <br/>
                                    "???? ?????????? ?????????????????? ??????????"
                                </b>
                                <br/>
                                INSTITUT ZA JAVNO ZDRAVLJE SRBIJE
                                <br/>
                                "Dr Milan Jovanovi?? Batut"
                                <br/>
                                INSTITUTE OF PUBLIC HEALTH OF SERBIA
                                <br/>
                                "Dr Milan Jovanovic Batut"
                            </p>
                        </div>
                    </header>

                    <div class="data">
                        <p>
                            <b>
                                ?????????? ?????????????? ??????????????????????:
                                <xsl:value-of select="vr:vaccinationReport/vr:id"/>
                            </b>
                        </p>
                        <p class="data__second">
                            ??ifra potvrde / Confirmation code
                        </p>
                    </div>

                    <div class="title">
                        <h1>?????????????? ?? ?????????????????? ?????????????????????? ???????????? COVID-19</h1>
                        <p>POTVRDA O IZVR??ENOJ VAKCINACIJI PROTIV COVID-19</p>
                        <p>CONFIRMATION OF THE COVID-19 VACCINATION</p>
                    </div>

                    <div class="data">
                        <p>
                            <b>
                                ?????? ?? ??????????????:
                                <xsl:value-of select="vr:vaccinationReport/vr:fullName"/>
                            </b>
                        </p>
                        <p class="data__second">
                            Ime i prezime / First and Last Name
                        </p>
                    </div>

                    <div class="data">
                        <p>
                            <b>
                                ?????????? ????????????:
                                <xsl:value-of select="vr:vaccinationReport/vr:birthDate"/>
                            </b>
                        </p>
                        <p class="data__second">
                            Datum ro??enja / Date of Birth
                        </p>
                    </div>

                    <div class="data">
                        <p>
                            <b>
                                ??????:
                                <xsl:value-of select="vr:vaccinationReport/vr:gender"/>
                            </b>
                        </p>
                        <p class="data__second">
                            Pol / Gender
                        </p>
                    </div>

                    <div class="data">
                        <p>
                            <b>
                                ????????:
                                <xsl:value-of select="vr:vaccinationReport/vr:jmbg"/>
                            </b>
                        </p>
                        <p class="data__second">
                            JMBG / Personal No.
                        </p>
                    </div>

                    <xsl:for-each select="vr:vaccinationReport/vr:doses/vr:dose">
                        <div class="data">
                            <p>
                                <b>
                                    ?????????? ???????????? ?? ???????? ???????????? ???????? ??????????????:
                                    <xsl:value-of select="vr:date"/>
                                    , ????????????:
                                    <xsl:value-of select="vr:batch"/>
                                </b>
                            </p>
                            <p class="data__second">
                                Datum vakcinacije / Vaccination Date
                            </p>
                        </div>
                    </xsl:for-each>

                    <div class="data">
                        <p>
                            <b>
                                ?????????????????????? ???????????????? ???????? ??????????????????:
                                <xsl:value-of select="vr:vaccinationReport/vr:institution"/>
                            </b>
                        </p>
                        <p class="data__second">
                            Zdravstvena ustanova koja vakcini??e / Health care institution of vaccination
                        </p>
                    </div>

                    <div class="data">
                        <p>
                            <b>
                                ?????????? ??????????????:
                                <xsl:value-of select="vr:vaccinationReport/vr:vaccine"/>
                            </b>
                        </p>
                        <p class="data__second">
                            Naziv vakcine / Name of vaccine
                        </p>
                    </div>

                    <div class="data">
                        <p>
                            <b>
                                ?????????? ???????????????? ??????????????:
                                <xsl:value-of select="vr:vaccinationReport/vr:confirmationDate"/>
                            </b>
                        </p>
                        <p class="data__second">
                            Datum izdavanja potvrde / Confiramtion Release Date
                        </p>
                    </div>

                    <div class="data right">
                        <p>
                            <b>
                                ?????????????????????? ????????????????:
                                <xsl:value-of select="vr:vaccinationReport/vr:institution"/>
                            </b>
                        </p>
                        <p class="data__second">
                            Zdravstvena ustanova / Medical Institution
                        </p>
                    </div>

                    <div class="footer">
                        <div class="data">
                            <p>
                                <b>
                                    ?????? ?????????????? ???????? ?????? ?????????????? ?? ????????????
                                </b>
                            </p>
                            <p class="data__second">
                                Ova potvrda va??i bez potpisa i pe??ata / This certificate is valid without signatures and seals
                            </p>
                        </div>
                        <img src="../../../data/xsl/images/qr-code.png"/>
                    </div>

                </div>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>