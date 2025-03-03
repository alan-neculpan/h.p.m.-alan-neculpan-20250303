# h.p.m.-alan-neculpan-20250303

### Tarea correspondiente a la 7 semana Herramientas de Programacion Movil

1- El nombre del proyecto debe ser su nombre_apellido_fecha_seccioncurso (la fecha en formato yyyymmdd).
2- La aplicación debe ser desarrollada en lenguaje Kotlin (aplicativo en lenguaje Java no será considerado).
3- La aplicación debe iniciar con una pantalla de bienvenida (SplashScreen) alusiva a las farmacias.
4- Al ingresar a la aplicación, esta debe solicitar el nombre y las pantallas siguientes deben mostrar el mensaje “Bienvenido: <NOMBRE>”, el cual debe ser obtenido desde las preferencias de usuario.
5- Luego de cerrada la aplicación, si el usuario ya ingresó su nombre, esta no debe solicitarlo al volver abrir la aplicación.
6- La aplicación debe contar con un botón que permita cerrar la sesión.
7- La aplicación debe obtener los datos de las farmacias de turno desde la siguiente API https://midas.minsal.cl/farmacia_v2/WS/getLocalesTurnos.php y para invocar a la API debes utilizar hilos y/o AsyncTask.
8- Los datos conseguidos desde la API tienen que ser desplegados en forma de lista (debes deserializar la respuesta de la API para obtener los elementos por separado).
