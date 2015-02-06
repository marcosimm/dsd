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
            }];

        db.collection('sunat', function(err, collection) {
            collection.insert(sunat, {safe:true}, function(err, result) {});
        });
    };
