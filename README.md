# API Employee
### Se desarrollaron dos proyectos:
1 - Servicio soap - conecta a la base de datos mysql e inserta un empleado <br>
2 - Servicios rest - consume el soap y valida los datos del empleado con los siguientes parametros. <br>
    * Validar campos vacios <br>
    * Validar el formato de fecha en este caso debe ser asi yyyy-MM-dd <br>
    * Validar que sea mayor de edad <br>
    * La respuesta retornara el tiempo de vinculacion y edad actual desglosado por años - meses - dias
### Nota
1- En las imagenes subidas dejo evidencias del funcionamiento de los servicios con postman y soapUI <br> <br>
2- EndPoint del servicio Rest <br>
http://localhost:9000/employee?name=Pepe&lastname=Perez&typeDocument=CC&document=1024648&dateOfBirth=2025-04-10&dateOfAffiliation=2050-05-25&cargo=Estudiante&salary=3000 <br><br>
3- EndPoint del servicio Soap <br>
http://localhost:8080/ws Method: getEmployee Body: Objeto de Empleado <br>
SoapUi importar el wsdl http://localhost:8080/ws/employees?wsdl