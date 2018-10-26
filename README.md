# Parcial 2 corte ARSW

[![Heroku link](https://www.herokucdn.com/deploy/button.png)](https://secure-river-96770.herokuapp.com/)

## Corre localmente

Para correr el proyecto localmente, primero hay que asegurarse de que el proyecto esta corriendo en netbeans, o en consola en la carpeta raiz del proyecto con el siguiente comando:

```sh
$ mvn spring-boot:run
```

La aplicacion deberia estar corriendo en [localhost:5000](http://localhost:5000/).

## Documentacion arquitectura

- Para este parcial teniamos que utilizar un api el cual con la key correcta de activacion y el link correcto se pueden obtener los datos climaticos dependiendo la ciudad que se quiera buscar, en este caso, tuvimos que implementar mediante Spring, maven y heroku, una aplicacion web la cual permitiera ingresar el nombre de la ciudad la cual se quiere conocer su informacion de clima y mostrarla en pantalla de una manera amigable y entendible hacia el usuario. En este caso, mi desarrollo de la aplicacion fue el siguiente:

![alt text](https://github.com/ARSWCamiloLopez/ARSWParcial2.1/blob/master/screenshots/Screenshot%20from%202018-10-25%2018-08-39.png)

- Si se quiere saber el clima de una ciudad determinada, se puede ingresar el nombre en el campo que esta habilitado para ingresar texto y dar click en el boton de buscar, cuando esto ocurre se mostrar una tabla con la informacion del clima de esta ciudad como se ve en la siguiente imagen: 

![alt text](https://github.com/ARSWCamiloLopez/ARSWParcial2.1/blob/master/screenshots/Screenshot%20from%202018-10-25%2018-10-19.png)

- En caso de que el usuario deje en blanco el espacio se le avisara con un campo de informacion que debe ingresar un dato como se ve en la siguiente imagen:

![alt text](https://github.com/ARSWCamiloLopez/ARSWParcial2.1/blob/master/screenshots/Screenshot%20from%202018-10-25%2018-14-28.png)

- En el caso que el usuario ingrese un nombre de una ciudad que no se encuentra registrada por el api, la aplicacion mostrara una tabla vacia, lo cual quiere decir que no existen datos para esta ciudad que el usuario esta intentando ingresar, se puede observar en la siguiente imagen:

![alt text](https://github.com/ARSWCamiloLopez/ARSWParcial2.1/blob/master/screenshots/Screenshot%20from%202018-10-25%2018-10-34.png)

- Para este parcial usamos la arquitectura de paquetes denominada MVC como se puede observar en la siguiente imagen, se observa la correcta modularizacion y empaquetado del codigo del parcial, ademas que los nombres son concretos y los nombres de las funciones y su documentacion son concisos y se encunetran disponibles: 

![alt text](https://github.com/ARSWCamiloLopez/ARSWParcial2.1/blob/master/screenshots/Screenshot%20from%202018-10-25%2018-15-06.png)
![alt text](https://github.com/ARSWCamiloLopez/ARSWParcial2.1/blob/master/screenshots/Screenshot%20from%202018-10-25%2018-15-40.png)

- El cache se implemento de la siguiente manera, no se tuvo en cuenta un cache global, solo por usuario, si se hacia una busqueda a una ciudad dada se añadia el nombre de la ciudad y su respectivo JSon y ademas se agregaba la hora en la que se hacia la busqueda, cuando se veia que el usuario hacia una nueva peticion a la misma ciudad se comparaban las horas en las que se hacian y si la fecha actual era mayor a la anterior se hacia una nueva peticion al api, si no, se retornaba el Json que se habia guardado en el map: 

![alt text](https://github.com/ARSWCamiloLopez/ARSWParcial2.1/blob/master/screenshots/Screenshot%20from%202018-10-25%2018-56-41.png)

- En conclusion el correcto manejo de las tecnologias que se ofrecen hoy en dia, en este caso heroku, spring, maven, axios y bootstrap se pueden construir aplciaciones amigables para el usuario, y ademas, de una manera organizada y concreta, esto aplicando el patron de MVC. Y con el correcto uso de las API's gratuitas que nos ofrecen se puede obtener y organizar la informacion de una manera adecuada.
