# Invocación a métodos remotos 

El objetivo de esta sesión práctica es aplicar los conceptos relacionados con el paradigma
cliente/servidor desde el punto de vista de la comunicación entre procesos.

El objetivo de esta práctica es utilizar el API de Java para la implementación de 
llamadas a métodos remotos (Java RMI).

El mecanismo de invocación de métodos remotos permite hacer algo que parece sencillo.  
Si se tiene acceso a un objeto en una máquina distinta, se podrá llamar a los métodos 
de ese objeto remoto. 
Esto implica: 

  * que los parámetros del método deben, de algún modo, pasarse a la otra máquina, 
  * que el objeto debe ser informado para que ejecute el método y 
  * que el valor obtenido debe ser devuelto. 

Java RMI *Remote Method Invocation* manipula todos estos detalles. 


Se usarán las siguientes definiciones en Java RMI: 

  * el objeto cuyos métodos efectúan la llamada remota recibe el nombre de 'objeto cliente', 
  * mientras que el objeto remoto es el 'objeto servidor'. 

Esta definición se usa para una única llamada a un método. 
Es posible invertir los papeles en algún punto del camino. 
Por tanto, el servidor de una llamada previa puede convertirse en cliente cuando llame 
a un método remoto de un objeto que reside en otra máquina. 

Cuando un objeto cliente quiere invocar a un método de un objeto 
remoto, llama a un método ordinario Java que está encapsulado 
en un objeto denominado 'stub'. 

El objeto 'stub' reside en la máquina del cliente, no en el servidor. 
El 'stub' empaqueta como un bloque de bytes los parámetros utilizados 
en el método remoto (usando el mecanismo de serialización). 
El proceso de codificación de los parámetros recibe el nombre de 
'empaquetado de parámetros' (parameter marshaling). 
El objetivo de esta operación es convertir los parámetros a un formato 
suceptible de ser enviado de una JVM a otra. 

El método 'stub' en el cliente construye un bloque con la siguiente 
información y la envía al servidor: 

  * Una descripción del método que será llamado. 
  * Los parámetros codificados. 

En el servidor el objeto receptor realiza las siguientes acciones por cada 
método remoto invocado: 

  * Decodifica los parámetros. 
  * Localiza al objeto que ha sido llamado. 
  * Encuentra el método requerido. 
  * Captura y ordena los valores devueltos, o la excepción de la llamada. 
  * Envía un paquete con los datos del resultado codificados al 'stub' del cliente. 

El 'stub' del cliente decodifica el valor de retorno, o la excepción, 
procedente del servidor. 
Este valor se convierte en el valor de retorno de la llamada al 'stubr'. 
Si el método remoto lanza un excepción, el 'stub' la propaga en el ambiente 
en que tuvo lugar la llamada. 

Este proceso aunque complejo es completamente transparente para el programador. 
Además, los diseñadores de objetos remotos en Java trataron de darles el mismo 
aspecto y funcionamiento que los locales. 

## Ejercicio.

1.  Implementar una aplicación cliente/servidor usando *Java RMI* 
    en la cual el servicio que ofrece el objeto remoto es un método 
    que suma los elementos de dos arrays. 
    El cliente ha de instanciar dos arrays de enteros e invocar 
    al método remoto para que realice la suma y devuelva el array resultado. 

2. Utilizar el método *currentTimeMillis()* de la clase System para establecer un
   cronómetro en el cliente del ejercicio anterior ¿Cuánto tiempo consume la implementación?
