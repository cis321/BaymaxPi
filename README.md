# Aplicación móvil Ionic

Si quiere correrlo necesitará tener Node.js, una vez tenga node puede instalar Cordova e Ionic así:

`npm install -g cordova ionic@1.3`

Después de eso clona el repo y va dentro del proyecto \pruebaConexion y ejecuta el proyecto usando

`ionic serve` (correr de manera local)

`ionic run android` (correr en su dispositivo conectado o emulador)

### Probar la aplicación en de manera local
Y si llegara a estar en mi red, al no ser un build para celular necesita correr Chrome así:
1. Por consola, va al directorio donde esta chrome.exe
2. Lo ejecuta: `chrome.exe --disable-web-security --user-data-dir`

# Servidor central

## Automatización de la ejecución del proyecto:
Me conecto a la raspberry por ssh (contraseña: raspberry)
`ssh pi@IP`
Una vez conectado, debería estar en `/home/pi` , luego puedo ejecutar el script:
`sudo ./tesisRun.sh`
Puede verificar la correcta ejecución de varias formas:
1. Ver que se creen todos los Screen necesarios con el comando `sudo ls laR /var/run/screen/`
2. Verificar que los servicios estén disponibles ( http://IP:4000/m2m/ , http://IP:9051/server-sensor/api/COMANDO )


