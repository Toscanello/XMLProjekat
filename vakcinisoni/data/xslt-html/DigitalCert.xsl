<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:dc="http://www.vakcinisoni.com" version="2.0">

    <xsl:template match="/">

        <html>
            <head>
                <title>Digital Cert</title>
                <style>
                    body {
                        font-family: Arial;
                    }
                    .container {
                        max-width: 700px;
                        margin: 0 auto;
                    }
                    header {
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                        margin-top: 20px;
                    }
                    .logo {
                        text-align: center;
                        font-size: 10px;
                    }
                    .logo p {
                        margin: 0;
                        font-weight: bold;
                    }
                    .logo img {
                        height: 100px;
                        width: 50px;
                        margin-bottom: 10px;
                    }
                    .qr-code img {
                        height: 100px;
                        width: 100px;
                    }
                    .title {
                        text-align: center;
                        width: 320px;
                    }
                    .title h2 {
                        margin: 0;
                        font-size: 16px;
                    }
                    .title p {
                        margin: 0;
                        font-size: 13px;
                    }
                    .main {
                        font-size: 11px;
                        margin-top: 30px;
                    }
                    .first-row {
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                    }
                    .data {
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                    }
                    .data__title p {
                        margin: 0;
                    }
                    .data__value {
                        margin-left: 20px;
                    }
                    .main table {
                        font-size: 11px;
                        border-spacing: 0px;
                        margin-top: 10px;
                    }
                    .main table td {
                        min-width: 300px
                    }
                    tr.pb-1 td {
                        padding-bottom: 15px;
                    }
                    h3 {
                        text-align: center;
                    }
                    .vaccination-container {
                        display: flex;
                        justify-content: space-between;
                    }
                    .right {
                        text-align: right;
                        margin-right: 70px;
                    }
                    .footer {
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                    }
                    .footer {
                        margin-top: 100px;
                        font-size: 9px;
                    }
                    .batut-part, .grb-part {
                        display: flex;
                        align-items: center;
                        column-gap: 10px;
                    }
                    .batut-part p, .grb-part p {
                        margin: 0;
                    }
                    .batut-part img  {
                        height: 80px;
                        width: 70px;
                    }
                    .grb-part img {
                        height: 70px;
                        width: 35px;
                    }
                </style>
            </head>

            <body>
                <div class="container">
                    <header>
                        <div class="logo">
                            <img src="http://www.zetss.edu.rs/wp-content/uploads/2014/11/Grb-Srbije.png"/>
                            <p>РЕПУБЛИКА СРБИЈА</p>
                            <p>REPUBLIC OF SERBIA</p>
                        </div>
                        <div class="title">
                            <h2>ДИГИТАЛНИ ЗЕЛЕНИ СЕРТИФИКАТ</h2>
                            <p>Потврда о извршеној вакцинацији против COVID-19 и резултатима тестирања</p>
                            <h2>DIGITAL GREEN CERTIFICATE</h2>
                            <p>Certificate of vaccination against COVID-19 and test results</p>
                        </div>
                        <div class="qr-code">
                            <img src="../../../data/xsl/images/qr-code.png"/>
                        </div>
                    </header>

                    <div class="main">
                        <div class="first-row">
                            <div class="data">
                                <div class="data__title">
                                    <p><b>Број сертификата/</b></p>
                                    <p><b>Certificate ID:</b></p>
                                </div>
                                <p class="data__value"><b><xsl:value-of select="dc:certificate/dc:id"/></b></p>
                            </div>
                            <div class="data">
                                <div class="data__title">
                                    <p><b>Датум и време издавања сертификата/</b></p>
                                    <p><b>Certificate issuing date and time:</b></p>
                                </div>
                                <p class="data__value"><b>22.11.2022.</b></p>
                            </div>
                        </div>

                        <div>
                            <table>
                                <tr class="pb-1">
                                    <td><b>Име и презиме / Name and surname:</b></td>
                                    <td><xsl:value-of select="dc:certificate/dc:fullName"/></td>
                                </tr>
                                <tr class="pb-1">
                                    <td><b>Пол / Gender:</b></td>
                                    <td><xsl:value-of select="dc:certificate/dc:gender"/></td>
                                </tr>
                                <tr class="pb-1">
                                    <td><b>Датум рођења / Date of birth:</b></td>
                                    <td><xsl:value-of select="dc:certificate/dc:dateOfBirth"/></td>
                                </tr>
                                <tr class="pb-1">
                                    <td><b>ЈМБГ / Personal No. / EBS:</b></td>
                                    <td><xsl:value-of select="dc:certificate/dc:jmbg"/></td>
                                </tr>
                                <tr class="pb-1">
                                    <td><b>Број пасоша / Passport No.</b></td>
                                    <td><xsl:value-of select="dc:certificate/dc:passportNum"/></td>
                                </tr>
                            </table>
                        </div>

                        <hr/>

                        <h3>Вакцинација / Vaccination</h3>

                        <div class="vaccination-container">
                            <xsl:for-each select="dc:certificate/dc:vaccination/dc:dose">
                                <div>
                                    <div>
                                        <p>
                                            <b>Доза / Dose:</b>
                                        </p>
                                    </div>
                                    <div>
                                        <p>
                                            <b>Тип / Type:</b>
                                        </p>
                                        <p>
                                            <xsl:value-of select="dc:type"/>
                                        </p>
                                    </div>
                                    <div>
                                        <p>
                                            <b>Произвођач и серија / Manufacturer and batch number:</b>
                                        </p>
                                        <p>
                                            <xsl:value-of select="dc:manufacturer"/>
                                            ,
                                            <xsl:value-of select="dc:batch"/>
                                        </p>
                                    </div>
                                    <div>
                                        <p>
                                            <b>Датум / Date:</b>
                                            <b><xsl:value-of select="dc:date"/></b>
                                        </p>
                                    </div>
                                    <div>
                                        <p>
                                            <b>Здравствена установа / Health care Institution:</b>
                                        </p>
                                        <p>
                                            <xsl:value-of select="dc:institution"/>
                                        </p>
                                    </div>
                                </div>
                            </xsl:for-each>
                        </div>

                        <hr/>

                        <div class="right">
                            <p>
                                <b>Дигитални потпис / Digitally signed by:</b>
                            </p>
                        </div>
                    </div>

                    <div class="footer">
                        <div class="batut-part">
                            <img src="https://euprava.gov.rs/media/logos/Batut.gif"/>
                            <div>
                                <p><b>Сертификат издаје:</b></p>
                                <p>Институт за јавно здравство Србије</p>
                                <p>"Др Милан Јовановић Батут"</p>
                                <p><b>Certificate issued by:</b></p>
                                <p>Institute of Public Heath of Serbia</p>
                                <p>"Dr Milan Jovanović Butut"</p>
                            </div>
                        </div>
                        <div class="grb-part">
                            <img src="http://www.zetss.edu.rs/wp-content/uploads/2014/11/Grb-Srbije.png"/>
                            <div>
                                <p>РЕПУБЛИКА СРБИЈА</p>
                                <p>Влада Републике Србије</p>
                                <p>Канцеларија за информационе</p>
                                <p>технологије и електронску управу</p>
                                <p>Немањина 11, БЕОГРАД</p>
                                <p>Датум: 12.05.2021.</p>
                            </div>
                        </div>
                    </div>

                </div>

            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>