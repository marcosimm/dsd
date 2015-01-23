var mongo = require('mongodb');
 
var Server = mongo.Server,
    Db = mongo.Db,
    BSON = mongo.BSONPure;
 
var server = new Server('localhost', 27017, {auto_reconnect: true});
db = new Db('sunatdb', server);
 
console.log("Inicio");
 
db.open(function(err, db) {
            if(!err) {
                console.log("Connected to 'sunatdb' database");
                db.collection('sunat', {strict:true}, 
                    function(err, collection) {
                        if (err) {
                            console.log("The 'sunat' collection doesn't exist. Creating it with sample data...");
                            populateDB();
                        }
                    });
            }
        });
 
exports.findById = function(req, res) {
                        var id = req.params.id;
                        console.log('Recuperando datos: ' + id);
                        db.collection('sunat', function(err, collection) {
                            collection.findOne({'_id':new BSON.ObjectID(id)}, 
                            function(err, item) {
                                res.send(item);
                            });
                        });
                    };
 
exports.findAll =   function(req, res) {
                        console.log('Recuperando todos');
                        db.collection('sunat', function(err, collection) {
                            collection.find().toArray(function(err, items) {
                                res.send(items);
                            });
                        });
                    };
 
/*--------------------------------------------------------------------------------------------------------------------*/
// Populate database with sample data -- Only used once: the first time the application is started.
// You'd typically not find this code in a real-life app, since the database would already exist.
var populateDB = function() { 
    var sunat = [
            {
                razonsocial: "Empresa Exportadora de Papas S.A.",
                tipo: "SOCIEDAD ANONIMA",
                fechains: "08/03/1996",
                condicion: "HABIDO",
                estado: "ACTIVO",
                direccion: "Av. Sin nombre No.9999 - Urb. Las Praderas - San Juan de Luirgancho",
                telefono1: "99999999",
                anexo1: "1234"
            },
            {
                razonsocial: "American Import S.A.",
                tipo: "SOCIEDAD ANONIMA",
                fechains: "08/03/1996",
                condicion: "HABIDO",
                estado: "ACTIVO",
                direccion: "Av. Con Nombre No.888 - Urb. Los Pino - Comas",
                telefono1: "8888888",
                anexo1: "5678"
            },
            {
                razonsocial: "Empresa de Transporte El Rapido S.R.L.",
                tipo: "SOCIEDAD RESPONSABILIDAD LIMITADA",
                fechains: "08/03/1996",
                condicion: "HABIDO",
                estado: "ACTIVO",
                direccion: "Av. Con nombre No.888 - Urb. Dulanto - Callao",
                telefono1: "8888888",
                anexo1: "5678"
            }];
 
        db.collection('sunat', function(err, collection) {
            collection.insert(sunat, {safe:true}, function(err, result) {});
        });
    }; 