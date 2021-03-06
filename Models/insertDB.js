
// db taxi24

/*
Collection - conductores
{
_id: STRING
nombre: STRING
apellido: STRING
mail: STRING
disponible: Boolean
}
*/
db.conductores.insertMany( [
      {_id: "21A", nombre: "Juan",apellido: "Perez",mail: "juan@mail.com", disponible: true},
      {_id: "22B", nombre: "Jorge",apellido: "Dominguez",mail: "mail@mail.com", disponible: true},
      {_id: "25D", nombre: "Juan",apellido: "Rodriguez",mail: "mail2@mail.com", disponible: true},
      {_id: "33F", nombre: "Luis",apellido: "Hernandez",mail: "mail3@mail.com", disponible: false},
      {_id: "ZZ3", nombre: "Pedro",apellido: "Romero",mail: "mail4@mail.com", disponible: true},
      {_id: "xx2", nombre: "Manuel",apellido: "Campirano",mail: "mail5@mail.com", disponible: true},
      {_id: "pw2", nombre: "Arturo",apellido: "Bosque",mail: "mail6@mail.com", disponible: true}
   ] );



/*
Collection - pasajeros
{
_id: STRING
nombre: STRING
apellido: STRING
mail: STRING
enViaje: Boolean
 }
*/
db.pasajeros.insertMany( [
      {_id: "55G", nombre: "Jose",apellido: "Montes",mail: "jose@mail.com", enViaje: false},
      {_id: "77F", nombre: "Salma",apellido: "Carrasco",mail: "salma@mail.com", enViaje: true},
      {_id: "22R", nombre: "Sheila",apellido: "Capetillo",mail: "shei@mail.com", enViaje: false},
      {_id: "11D", nombre: "Mirna",apellido: "May",mail: "mirna@mail.com", enViaje: false}
      ] );



/*
Collection - viajes
{
_id: STRING
pasajeroId: STRING
fecha: STRING
partida: STRING
destino: STRING
enCurso: Boolean
}
*/
db.viajes.insertMany( [
        {_id: "V001", pasajeroId: "21A", conductorId: "55G", fecha: "2021-08-09", partida: "55,77", destino: "102,21", enCurso: false},
        {_id: "V002", pasajeroId: "77F", conductorId: "33F", fecha: "2021-08-11", partida: "12,22", destino: "99,32", enCurso: true}
            ] );



/*
Collection - facturas
{
_id: STRING
viajeId: STRING
conductorId: STRING
pasajeroId: STRING
fecha: STRING
tarifa: DOUBLE
}
*/
db.facturas.insertMany( [
        {_id: "F001", viajeId: "V001",conductorId: "55G", pasajeroId: "21A", fecha: "2021-08-10", tarifa: 30.00},

                        ] );
