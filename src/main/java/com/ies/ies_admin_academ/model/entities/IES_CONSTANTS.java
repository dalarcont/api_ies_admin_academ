package com.ies.ies_admin_academ.model.entities;

public class IES_CONSTANTS {

    public enum EMAIL_ADDRESS{
        String;

        public static final String ADMISIONES       = "admisiones@unifalsa.com";
        public static final String DEV              = "dev@unifalsa.com";
        public static final String HELP             = "help@unifalsa.com";
        public static final String INSCRIPCIONES    = "inscripciones@unifalsa.com";
        public static final String JUDICIAL         = "judicial@unifalsa.com";
        public static final String MATRICULA        = "matricula@unifalsa.com";
        public static final String PRESIDENCIA      = "presidencia@unifalsa.com";
        public static final String SOPORTE          = "soporte@unifalsa.com";
        public static final String VICEPRESIDENCIA  = "vicepresidencia@unifalsa.com";
        public static final String NOREPLY          = "noreply@unifalsa.com";
    }

    public enum EMAIL_NAMES{
        String;

        public static final String ADMISIONES       = "Admisiones Universidad Falsa";
        public static final String DEV              = "Desarrollo Informático Universidad Falsa";
        public static final String HELP             = "Ayuda Universidad Falsa";
        public static final String INSCRIPCIONES    = "Inscripciones Universidad Falsa";
        public static final String JUDICIAL         = "Judicial Universidad Falsa";
        public static final String MATRICULA        = "Matrícula Universidad Falsa";
        public static final String PRESIDENCIA      = "Presidencia Universidad Falsa";
        public static final String SOPORTE          = "Soporte General Universidad Falsa";
        public static final String VICEPRESIDENCIA  = "Vicepresidencia Universidad Falsa";
        public static final String INFO_REGISTRO    = "Información de Registro - Universidad Falsa";

    }

    public static String IES_DEV_InfoMail(String dest){
        return "<style>" +
                "    div.PWPostnewuser {" +
                "      border: 1px solid #1C6EA4;" +
                "      background-color: #EEEEEE;" +
                "      width: 565px;" +
                "      text-align: center;" +
                "      border-collapse: collapse;" +
                "    }" +
                "    .divTable.PWPostnewuser .divTableCell, .divTable.PWPostnewuser .divTableHead {" +
                "      border: 1px solid #AAAAAA;" +
                "      padding: 3px 2px;" +
                "    }" +
                "    .divTable.PWPostnewuser .divTableBody .divTableCell {" +
                "      font-size: 13px;" +
                "    }" +
                "    .divTable.PWPostnewuser .divTableRow:nth-child(even) {" +
                "      background: #D0E4F5;" +
                "    }" +
                "    .divTable.PWPostnewuser .divTableHeading {" +
                "      background: #1C6EA4;" +
                "      background: -moz-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);" +
                "      background: -webkit-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);" +
                "      background: linear-gradient(to bottom, #5592bb 0%, #327cad 66%, #1C6EA4 100%);" +
                "      border-bottom: 2px solid #444444;" +
                "    }" +
                "    .divTable.PWPostnewuser .divTableHeading .divTableHead {" +
                "      font-size: 15px;" +
                "      font-weight: bold;" +
                "      color: #FFFFFF;" +
                "      border-left: 2px solid #D0E4F5;" +
                "    }" +
                "    .divTable.PWPostnewuser .divTableHeading .divTableHead:first-child {" +
                "      border-left: none;" +
                "    }" +
                "    " +
                "    .PWPostnewuser .tableFootStyle {" +
                "      font-size: 14px;" +
                "    }" +
                "    .PWPostnewuser .tableFootStyle .links {" +
                "         text-align: right;" +
                "    }" +
                "    .PWPostnewuser .tableFootStyle .links a{" +
                "      display: inline-block;" +
                "      background: #1C6EA4;" +
                "      color: #FFFFFF;" +
                "      padding: 2px 8px;" +
                "      border-radius: 5px;" +
                "    }" +
                "    .PWPostnewuser.outerTableFooter {" +
                "      border-top: none;" +
                "    }" +
                "    .PWPostnewuser.outerTableFooter .tableFootStyle {" +
                "      padding: 3px 5px; " +
                "    }" +
                "    .divTable{ display: table; }" +
                "    .divTableRow { display: table-row; }" +
                "    .divTableHeading { display: table-header-group;}" +
                "    .divTableCell, .divTableHead { display: table-cell;}" +
                "    .divTableHeading { display: table-header-group;}" +
                "    .divTableFoot { display: table-footer-group;}" +
                "    .divTableBody { display: table-row-group;}" +
                "    </style>" +
                "    <div class='divTable PWPostnewuser'>" +
                "    <div class='divTableHeading'>" +
                "    <div class='divTableRow'>" +
                "    <div class='divTableHead'><?xml version='1.0' encoding='UTF-8' standalone='no'?>" +
                "    <!DOCTYPE svg PUBLIC '-//W3C//DTD SVG 1.1//EN' 'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd'>" +
                "    <svg version='1.1' id='Layer_1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' x='0px' y='0px' width='32px' height='32px' viewBox='0 0 16 16' enable-background='new 0 0 16 16' xml:space='preserve'>  <image id='image0' width='16' height='16' x='0' y='0'" +
                "        xlink:href='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAABGdBTUEAALGPC/xhBQAAACBjSFJN" +
                "    AAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAApVBMVEUSTKcPSaENSKEOSKIN" +
                "    R6IOS6UOR6MOSqYNR6EQSaIzZLA6abMYT6U5aLIiV6k3Z7IyY7Df5vKHpNDO2uxFcrfl6/Xi6fTf" +
                "    5/MbUqbAz+Z0lcmJpdH09vu0xuI9a7Tc5PEYUKXn7faovd3L1+s1ZbDG1OnE0ugbUqfh6PNNd7ov" +
                "    Ya6vwuDQ3O2Ysde6yuTe5vIkWKp7msxCcLYfVKhHc7cpXKz///+b2HPvAAAACHRSTlNG3P3d/kfe" +
                "    SJjPmjcAAAABYktHRDZHv4jRAAAAB3RJTUUH5QMRARkPLyW0BQAAAIhJREFUGNNlj+kSgjAMhLcF" +
                "    ZfGsB96Kihd4Vuv7v5oDKENlf2QyXzLZDSAkC0kBCFpyIG3ggn+C32i2sq7NDtn1oXr9wTAFAUfk" +
                "    eAI15Wyeg8VyFa6hNttoV2zsCXU45tcCnsiYSM7f8xdeb/H9kdkmWuvnzzYtL2PMuwysYJXoledq" +
                "    dbc0d7wPhe4M3pKgs/MAAAAldEVYdGRhdGU6Y3JlYXRlADIwMjEtMDMtMTdUMDE6MjU6MTUrMDM6" +
                "    MDAtSZx6AAAAJXRFWHRkYXRlOm1vZGlmeQAyMDIxLTAzLTE3VDAxOjI1OjE1KzAzOjAwXBQkxgAA" +
                "    AABJRU5ErkJggg==' />" +
                "    </svg><br>PWPost</div>" +
                "    </div>" +
                "    </div>" +
                "    <div class='divTableBody'>" +
                "    <div class='divTableRow'>" +
                "    <div class='divTableCell'><br>Correo Informativo Desarrollo Informático<br></div>" +
                "    </div>" +
                "    <div class='divTableRow'>" +
                "    <div class='divTableCell'><br>Recibes este correo con el fin de que se están ejecutando pruebas<br>" +
                "en las cuales se evidencia que se necesita un envío de correo a tu dirección y por eso recibes esta comunicación.<br>Puedes borrarla.</div>" +
                "    </div>" +
                "    <div class='divTableRow'>" +
                "    <div class='divTableCell'><br>CORREO INFORMATIVO ÚNICAMENTE<br></div>" +
                "    </div>" +
                "    <div class='divTableRow'>" +
                "    <div class='divTableCell'><br>Correo objetivo:" +dest+"<br />Si usted no es el destinatario final y se trata de una equivocaci&oacute;n, por favor hacer caso omiso de este mensaje y eliminarlo.<br /><br />Universidad Falsa<br />2023</div>" +
                "    </div>" +
                "    </div>" +
                "    </div>";
    }

    /*
    public static String IES_DEV_WELCOME_NEW_USER(String[] msgContent){
        return "<style>" +
                "    div.PWPostnewuser {" +
                "      border: 1px solid #1C6EA4;" +
                "      background-color: #EEEEEE;" +
                "      width: 565px;" +
                "      text-align: center;" +
                "      border-collapse: collapse;" +
                "    }" +
                "    .divTable.PWPostnewuser .divTableCell, .divTable.PWPostnewuser .divTableHead {" +
                "      border: 1px solid #AAAAAA;" +
                "      padding: 3px 2px;" +
                "    }" +
                "    .divTable.PWPostnewuser .divTableBody .divTableCell {" +
                "      font-size: 13px;" +
                "    }" +
                "    .divTable.PWPostnewuser .divTableRow:nth-child(even) {" +
                "      background: #D0E4F5;" +
                "    }" +
                "    .divTable.PWPostnewuser .divTableHeading {" +
                "      background: #1C6EA4;" +
                "      background: -moz-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);" +
                "      background: -webkit-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);" +
                "      background: linear-gradient(to bottom, #5592bb 0%, #327cad 66%, #1C6EA4 100%);" +
                "      border-bottom: 2px solid #444444;" +
                "    }" +
                "    .divTable.PWPostnewuser .divTableHeading .divTableHead {" +
                "      font-size: 15px;" +
                "      font-weight: bold;" +
                "      color: #FFFFFF;" +
                "      border-left: 2px solid #D0E4F5;" +
                "    }" +
                "    .divTable.PWPostnewuser .divTableHeading .divTableHead:first-child {" +
                "      border-left: none;" +
                "    }" +
                "    " +
                "    .PWPostnewuser .tableFootStyle {" +
                "      font-size: 14px;" +
                "    }" +
                "    .PWPostnewuser .tableFootStyle .links {" +
                "         text-align: right;" +
                "    }" +
                "    .PWPostnewuser .tableFootStyle .links a{" +
                "      display: inline-block;" +
                "      background: #1C6EA4;" +
                "      color: #FFFFFF;" +
                "      padding: 2px 8px;" +
                "      border-radius: 5px;" +
                "    }" +
                "    .PWPostnewuser.outerTableFooter {" +
                "      border-top: none;" +
                "    }" +
                "    .PWPostnewuser.outerTableFooter .tableFootStyle {" +
                "      padding: 3px 5px; " +
                "    }" +
                "    .divTable{ display: table; }" +
                "    .divTableRow { display: table-row; }" +
                "    .divTableHeading { display: table-header-group;}" +
                "    .divTableCell, .divTableHead { display: table-cell;}" +
                "    .divTableHeading { display: table-header-group;}" +
                "    .divTableFoot { display: table-footer-group;}" +
                "    .divTableBody { display: table-row-group;}" +
                "    </style>" +
                "    <div class='divTable PWPostnewuser'>" +
                "    <div class='divTableHeading'>" +
                "    <div class='divTableRow'>" +
                "    <div class='divTableHead'><?xml version='1.0' encoding='UTF-8' standalone='no'?>" +
                "    <!DOCTYPE svg PUBLIC '-//W3C//DTD SVG 1.1//EN' 'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd'>" +
                "    <svg version='1.1' id='Layer_1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' x='0px' y='0px' width='32px' height='32px' viewBox='0 0 16 16' enable-background='new 0 0 16 16' xml:space='preserve'>  <image id='image0' width='16' height='16' x='0' y='0'" +
                "        xlink:href='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAABGdBTUEAALGPC/xhBQAAACBjSFJN" +
                "    AAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAApVBMVEUSTKcPSaENSKEOSKIN" +
                "    R6IOS6UOR6MOSqYNR6EQSaIzZLA6abMYT6U5aLIiV6k3Z7IyY7Df5vKHpNDO2uxFcrfl6/Xi6fTf" +
                "    5/MbUqbAz+Z0lcmJpdH09vu0xuI9a7Tc5PEYUKXn7faovd3L1+s1ZbDG1OnE0ugbUqfh6PNNd7ov" +
                "    Ya6vwuDQ3O2Ysde6yuTe5vIkWKp7msxCcLYfVKhHc7cpXKz///+b2HPvAAAACHRSTlNG3P3d/kfe" +
                "    SJjPmjcAAAABYktHRDZHv4jRAAAAB3RJTUUH5QMRARkPLyW0BQAAAIhJREFUGNNlj+kSgjAMhLcF" +
                "    ZfGsB96Kihd4Vuv7v5oDKENlf2QyXzLZDSAkC0kBCFpyIG3ggn+C32i2sq7NDtn1oXr9wTAFAUfk" +
                "    eAI15Wyeg8VyFa6hNttoV2zsCXU45tcCnsiYSM7f8xdeb/H9kdkmWuvnzzYtL2PMuwysYJXoledq" +
                "    dbc0d7wPhe4M3pKgs/MAAAAldEVYdGRhdGU6Y3JlYXRlADIwMjEtMDMtMTdUMDE6MjU6MTUrMDM6" +
                "    MDAtSZx6AAAAJXRFWHRkYXRlOm1vZGlmeQAyMDIxLTAzLTE3VDAxOjI1OjE1KzAzOjAwXBQkxgAA" +
                "    AABJRU5ErkJggg==' />" +
                "    </svg><br>PWPost</div>" +
                "    </div>" +
                "    </div>" +
                "    <div class='divTableBody'>" +
                "    <div class='divTableRow'>" +
                "    <div class='divTableCell'><br>Gestión del talento Humano<br></div>" +
                "    </div>" +
                "    <div class='divTableRow'>" +
                "    <div class='divTableCell'><br>Tu registro se ha completado exitosamente.<br>" +
                "en las cuales se evidencia que se necesita un envío de correo a tu dirección y por eso recibes esta comunicación.<br>Puedes borrarla.</div>" +
                "    </div>" +
                "    <div class='divTableRow'>" +
                "    <div class='divTableCell'><br>CORREO INFORMATIVO ÚNICAMENTE<br></div>" +
                "    </div>" +
                "    <div class='divTableRow'>" +
                "    <div class='divTableCell'><br>Correo objetivo:" +dest+"<br />Si usted no es el destinatario final y se trata de una equivocaci&oacute;n, por favor hacer caso omiso de este mensaje y eliminarlo.<br /><br />Universidad Falsa<br />2023</div>" +
                "    </div>" +
                "    </div>" +
                "    </div>";
    }
*/
}
