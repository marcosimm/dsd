var mongo = require('mongodb');

var Server = mongo.Server,
    Db = mongo.Db,
    BSON = mongo.BSONPure;

var server = new Server('localhost', 27017, {auto_reconnect: true});
db = new Db('sunatdb', server);

console.log("Inicio");

// Conexión a la bas de datos
db.open(function(err, db) {
            if(!err) {
                console.log("Conectando a la base de datos 'sunatdb'.");
                db.collection('sunat', {strict:true},
                    function(err, collection) {
                        if (err) {
                            console.log("La colección 'sunat' no existe. Se crea con datos de muestra...");
                            populateDB();
                        }
                    });
            }
        });

// Buscar un registro, en este coso por el campo RUC
exports.findById = function(req, res) {
                        var id = req.params.id;
                        console.log('Recuperando datos: ' + id);
                        db.collection('sunat', function(err, collection) {
                            collection.findOne({'ruc':id},
                            function(err, item) {
                                res.send(item);
                            });
                        });
                    };

// Listar todos los elementos de la colexión
exports.findAll =   function(req, res) {
                        console.log('Recuperando todos los registros');
                        db.collection('sunat', function(err, collection) {
                            collection.find().toArray(function(err, items) {
                                res.send(items);
                            });
                        });
                    };

/*--------------------------------------------------------------------------------------------------------------------*/
// Llenar la base de datos con los datos de la muestra - Sólo se utiliza una vez: la primera vez que se inicia la aplicación.
var populateDB = function() {
    var sunat = [
            {
                ruc : "12345678901",
                razonsocial: "Empresa Exportadora de Papas S.A.",
                tipo: "SOCIEDAD ANONIMA",
                fechains: "08/03/1996",
                condicion: "HABIDO",
                estado: "ACTIVO",
                direccion: "Av. Sin nombre No.9999 - Urb. Las Praderas - San Juan de Luirgancho",
                telefono1: "99999999",
                anexo1: "1234",
                represetantes: [
                {documento: "DNI", numero: "10453112", nombre: "Ana Morales", cargo: "Director Ejecutivo", fechadesde: "10/10/2005"},
                {documento: "DNI", numero: "10453113", nombre: "Luisa San Martin", cargo: "Gerente General", fechadesde: "11/10/2008"}
                ]
            },
            {
                ruc : "12345678902",
                razonsocial: "American Import S.A.",
                tipo: "SOCIEDAD ANONIMA",
                fechains: "08/03/1996",
                condicion: "HABIDO",
                estado: "ACTIVO",
                direccion: "Av. Con Nombre No.888 - Urb. Los Pino - Comas",
                telefono1: "8888888",
                anexo1: "5678",
                represetantes: [
                {documento: "DNI", numero: "10453112", nombre: "Ana Morales", cargo: "Director Ejecutivo", fechadesde: "10/10/2005"},
                {documento: "DNI", numero: "10453113", nombre: "Luisa San Martin", cargo: "Gerente General", fechadesde: "11/10/2008"}
                ]
            },
            {
                ruc : "12345678903",
                razonsocial: "Empresa de Transporte El Rapido S.R.L.",
                tipo: "SOCIEDAD RESPONSABILIDAD LIMITADA",
                fechains: "08/03/1996",
                condicion: "HABIDO",
                estado: "ACTIVO",
                direccion: "Av. Con nombre No.888 - Urb. Dulanto - Callao",
                telefono1: "8888888",
                anexo1: "5678",
                represetantes: [
                {documento: "DNI", numero: "10453114", nombre: "Miguel Cordova", cargo: "Gerente General", fechadesde: "10/10/2005"},
                {documento: "DNI", numero: "10453115", nombre: "Pablo Rodriguez", cargo: "Administrador", fechadesde: "11/10/2008"}
                ]
            },
            {
                ruc : "12345678904",
                razonsocial: "Empresa Exportadora de Mangos E.I.R.L.",
                tipo: "EMPRESA INDIVIDUAL DE RESPONSABILIDAD LIMITADA",
                fechains: "08/03/1996",
                condicion: "HABIDO",
                estado: "ACTIVO",
                direccion: "Av. Los Constructores No.777 - San Luis",
                telefono1: "44444444",
                anexo1: "89777",
                represetantes: [
                {documento: "DNI", numero: "10453116", nombre: "Victor Gomez", cargo: "Apoderado", fechadesde: "10/10/2005"},
                {documento: "DNI", numero: "10453117", nombre: "Julio Enriquez", cargo: "Presidente de Directorio", fechadesde: "11/10/2008"}
                ]
            },
            {
                ruc : "12345678905",
                razonsocial: "IMPLAST S.A.C.",
                tipo: "SOCIEDAD ANONIMA CERRADA",
                fechains: "08/03/1996",
                condicion: "HABIDO",
                estado: "ACTIVO",
                direccion: "Av. Las Flores No.1450 - Urb. Los Nogales - Miraflores",
                telefono1: "879711111",
                anexo1: "121545",
                represetantes: [
                {documento: "DNI", numero: "10453118", nombre: "Manuel Caceres", cargo: "Gerente General", fechadesde: "10/10/2005"},
                {documento: "DNI", numero: "10453119", nombre: "Oscar Villar", cargo: "Administrador", fechadesde: "11/10/2008"}
                ]
            },
            {
                ruc : "20295798140",
                razonsocial: "IMPORTADORA Y EXPORTADORA YOU TOO S.A.",
                tipo: "SOCIEDAD ANONIMA",
                fechains: "08/11/1995",
                condicion: "HABIDO",
                estado: "ACTIVO",
                direccion: "CAL. ARQUIMEDES NRO. 159 URB. LA CAMPIÑA (ALT CUADRA 7 AV GUARDIA CIVIL) LIMA - LIMA - CHORRILLOS",
                telefono1: "(511)4250102",
                anexo1: "",
                represetantes: [
                {documento: "DNI", numero: "08266803", nombre: "VANDERVELDE MIRANDA AUREA JUANA", cargo: "GERENTE GENERAL", fechadesde: "01/12/1995"},
                {documento: "DNI", numero: "08273549", nombre: "MIRANDA NUNEZ NORMA BEATRIZ", cargo: "DIRECTORA", fechadesde: "01/12/1995"},
                {documento: "DNI", numero: "09335813", nombre: "MIRANDA NUNEZ ANA ISABEL", cargo: "GTE. ADMINISTRATIVO", fechadesde: "01/12/1995"}
                ]
            },
            {
                ruc : "20100047056",
                razonsocial: "TOPY TOP S A",
                tipo: "SOCIEDAD ANONIMA",
                fechains: "09/10/1992",
                condicion: "HABIDO",
                estado: "ACTIVO",
                direccion: "AV. SANTUARIO NRO. 1323 URB. ZARATE (1323-1325 ALT CDRA 12 DE LA AVDA CHIMU) LIMA - LIMA - SAN JUAN DE LURIGANCHO",
                telefono1: "(511)3501030",
                anexo1: "",
                represetantes: [
                {documento: "DNI", numero: "06165905", nombre: "FLORES CONISLLA ROSAURO", cargo: "APODERADO", fechadesde: "14/03/2002"},
                {documento: "DNI", numero: "06221995", nombre: "FLORES CONISLLA AQUILINO", cargo: "APODERADO", fechadesde: "14/03/2002"},
                {documento: "DNI", numero: "07384826", nombre: "RAU JACAY MARIA ELENA", cargo: "APODERADO", fechadesde: "13/02/2013"},
                {documento: "DNI", numero: "09322990", nombre: "FLORES CONISLLA MANUEL ISMAEL", cargo: "APODERADO", fechadesde: "14/03/2002"},
                {documento: "C.EXT.", numero: "000618104", nombre: "KLAUA SCHNEIDER MARTIN", cargo: "GERENTE GENERAL", fechadesde: "02/01/2010"}
                ]
            },
            {
                ruc : "20101362702",
                razonsocial: "CONFECCIONES TEXTIMAX S A",
                tipo: "SOCIEDAD ANONIMA",
                fechains: "27/01/1993",
                condicion: "HABIDO",
                estado: "ACTIVO",
                direccion: "AV. HUAROCHIRI NRO. 151 Z.I. ZONA INDUSTRIAL STA ANITA LIMA - LIMA - SANTA ANITA",
                telefono1: "(511)2535668",
                anexo1: "1735",
                represetantes: [
                {documento: "DNI", numero: "07211486", nombre: "CHAVEZ PARRA ANA MARIA", cargo: "GERENTE GENERAL", fechadesde: "30/09/1991"},
                {documento: "DNI", numero: "08081335", nombre: "NOVOA CACEDA HECTOR GUILLERMO", cargo: "APODERADO", fechadesde: "07/03/2006"},
                {documento: "DNI", numero: "08272342", nombre: "ISOLA DE LA PEÑA JUAN BAUTISTA", cargo: "DIRECTOR EJECUTIVO", fechadesde: "06/04/1991"},
                {documento: "DNI", numero: "25609935", nombre: "CHUNGA CASTRO JAIME AUGUSTO", cargo: "GERENTE", fechadesde: "21/02/2013"}
                ]
            },
            {
                ruc : "20486209063",
                razonsocial: "AGROINDUSTRIAS DEL MANTARO S.A.C.",
                tipo: "SOCIEDAD ANONIMA CERRADA",
                fechains: "08/07/2004",
                condicion: "HABIDO",
                estado: "ACTIVO",
                direccion: "PROLONG DEL JIRON MANTARO NRO. 196 (A 3 CDRAS DE LA PLANTA LECHERA) JUNIN - CONCEPCION - CONCEPCION",
                telefono1: "01-97573783",
                anexo1: "",
                represetantes: [
                {documento: "DNI", numero: "07783527", nombre: "FERNANDINI FRIAS AUGUSTO CESAR", cargo: "GERENTE GENERAL", fechadesde: "08/07/2004"}
                ]
            },
            {
                ruc : "20126542608",
                razonsocial: "BRANOE SA",
                tipo: "SOCIEDAD ANONIMA",
                fechains: "30/04/1993",
                condicion: "HABIDO",
                estado: "ACTIVO",
                direccion: "AV. JAVIER PRADO NRO. 1812 INT. 501 (ALT.CD.24 AV.AVIACION) LIMA - LIMA - SAN BORJA",
                telefono1: "(511)2254065",
                anexo1: "",
                represetantes: [
                {documento: "DNI", numero: "06022027", nombre: "HUAITA BERNAOLA DALMACIO PLUTARCO", cargo: "GERENTE ADJUNTO", fechadesde: "28/12/1998"},
                {documento: "DNI", numero: "07953011", nombre: "HUISA BERNAOLA NAHUM FREDDY", cargo: "GERENTE GENERAL", fechadesde: "08/03/1991"}
                ]
            }];

        db.collection('sunat', function(err, collection) {
            collection.insert(sunat, {safe:true}, function(err, result) {});
        });
    };
