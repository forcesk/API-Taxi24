db.conductores.insertMany( [
      {id: "21A", nombre: "Juan",apellido: "Perez",mail: "juan@mail.com", disponible: true},
      {id: "22B", nombre: "Jorge",apellido: "Dominguez",mail: "mail@mail.com", disponible: true},
      {id: "25D", nombre: "Juan",apellido: "Rodriguez",mail: "mail2@mail.com", disponible: true},
      {id: "33F", nombre: "Luis",apellido: "Hernandez",mail: "mail3@mail.com", disponible: false}
   ] );

db.pasajeros.insertMany( [
      {id: "55G", nombre: "Jose",apellido: "Montes",mail: "jose@mail.com", enViaje: false},
      {id: "77F", nombre: "Salma",apellido: "Carrasco",mail: "salma@mail.com", enViaje: true},
      {id: "22R", nombre: "Sheila",apellido: "Capetillo",mail: "shei@mail.com", enViaje: false},
      {id: "11D", nombre: "Mirna",apellido: "May",mail: "mirna@mail.com", enViaje: false}
      ] );

db.viajes.insertMany( [
        {id: "V001", pasajeroId: "21A", conductorId: "55G", fecha: "09/08/2021", partida: "55,77", destino: "102,21", enCurso: false},
        {id: "V002", pasajeroId: "77F", conductorId: "33F", fecha: "11/08/2021", partida: "12,22", destino: "99,32", enCurso: true}
            ] );

db.facturas.insertMany( [
        {id: "F001", viajeId: "V001",conductorId: "55G", pasajeroId: "21A", fecha: "09/08/2021", tarifa: "30.00"},

                        ] );
