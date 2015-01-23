var express = require('express'),
consultaruc = require('./consultas/consultaruc');
 
var app = express();
 
//app.get('/sunat/ruc', consultaruc.findAll);
//app.get('/sunat/ruc/:id', consultaruc.findById); 

app.get('/sunat/ruc', consultaruc.findAll);
app.get('/sunat/ruc/:id', consultaruc.findById);
//app.post('/sunat/ruc', wine.addWine);
//app.put('/sunat/ruc/:id', wine.updateWine);
//app.delete('/sunat/ruc/:id', wine.deleteWine); 
 
app.listen(3000);
console.log('Servidor en el puerto 3000...'); 