# Open-Weather
## Prueba Técnica Finvivir
Api para consultar información del clima, mediante el Api de OpenWeather

# Tecnologías
* Spring boot
    * JPA
    * RestTemplate
    * OpenApi
* Gradle 7.6
* Docker
*

# Instalación

## Clonar Repositorio
```sh
git clone https://github.com/marco181818/open-weather.git
```

## Ejecuatar aplicación en local
* Nos colocamos en la raiz del repositorio
* Ejecutamos
    * ``` gradle bootRun ```

## Ejecutar aplicación en Docker
* Nos colocamos en la raiz del repositorio
* Construimos el archivo jar
    * ``` gradle clean build ```
* Creamos la imagen en docker
    *  ``` docker build -t finvivir:weather . ```
* Corremos un nuevo contenedor
    * ``` docker run -d -p 8080:8080 finvivir:weather ```
    *
## Validar despliegue de la aplicación
* http://localhost:8080/swagger-ui/index.html