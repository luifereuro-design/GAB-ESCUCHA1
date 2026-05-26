# GAB Escucha 🎧

Aplicación Android diseñada para personas con problemas auditivos o sordera, con una interfaz accesible, fresca y dinámica.

## Características principales

- 🔊 Control de volumen
- 🎯 Reducción de ruido ambiental
- 👂 Control independiente de volumen izquierdo y derecho
- 🔵 Conectividad Bluetooth
- ♿ Interfaz accesible con botones grandes y claros
- 🎨 Diseño moderno y dinámico

## Requisitos

- Android SDK 21 (API 21) o superior
- Android 5.0 (Lollipop) o superior
- Java 8 o superior
- Gradle 7.0+

## Instalación y Compilación

### 1. Clonar el repositorio

```bash
git clone https://github.com/luifereuro-design/gab-escucha1.git
cd gab-escucha1
```

### 2. Configurar Android SDK

Asegúrate de tener Android SDK instalado y las variables de entorno configuradas:

```bash
export ANDROID_HOME=~/Android/Sdk
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
```

### 3. Generar el keystore (para firma de APK)

```bash
keytool -genkey -v -keystore keystores/gab-escucha.jks -keyalg RSA -keysize 2048 -validity 10000 -alias gab_escucha
```

Guarda los datos de entrada de forma segura.

### 4. Crear archivo local.properties

Crea un archivo `local.properties` en la raíz del proyecto:

```properties
sdk.dir=/path/to/android/sdk
```

### 5. Compilar la APK

**Debug APK:**
```bash
./gradlew assembleDebug
```

**Release APK (recomendado para Play Store):**
```bash
./gradlew assembleRelease
```

La APK se encontrará en:
- Debug: `app/build/outputs/apk/debug/app-debug.apk`
- Release: `app/build/outputs/apk/release/app-release.apk`

### 6. Instalar en dispositivo

```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

## Configuración de Play Store

Para publicar en Google Play Store:

1. Crea una cuenta de desarrollador en [Google Play Console](https://play.google.com/console)
2. Genera una APK Release firmada
3. Completa el formulario de la aplicación con:
   - Nombre: GAB Escucha
   - Descripción: Aplicación accesible para personas con problemas auditivos
   - Capturas de pantalla (mínimo 2)
   - Icono de aplicación (512x512px)
4. Sube la APK Release y publica

## Estructura del Proyecto

```
gab-escucha1/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/gabescucha/
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── BluetoothService.java
│   │   │   │   └── AudioProcessor.java
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   ├── drawable/
│   │   │   │   ├── values/
│   │   │   │   └── mipmap/
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   ├── build.gradle
│   └── proguard-rules.pro
├── build.gradle
├── gradle.properties
├── settings.gradle
├── keystores/ (crear después de generar keystore)
└── README.md
```

## Permisos requeridos

- BLUETOOTH
- BLUETOOTH_ADMIN
- BLUETOOTH_SCAN
- BLUETOOTH_CONNECT
- RECORD_AUDIO
- MODIFY_AUDIO_SETTINGS

## Desarrollo

### Componentes principales

1. **MainActivity**: Interfaz principal con controles de audio
2. **BluetoothService**: Gestión de conexiones Bluetooth
3. **AudioProcessor**: Procesamiento de audio y reducción de ruido

### Dependencias

- AndroidX
- Material Design Components
- Bluetooth Stack

## Licencia

MIT License - Ver LICENSE.md

## Contacto

- Autor: luifereuro-design
- GitHub: https://github.com/luifereuro-design/gab-escucha1

## Contribuciones

Las contribuciones son bienvenidas. Por favor:

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/amazing-feature`)
3. Commit tus cambios (`git commit -m 'Add amazing feature'`)
4. Push a la rama (`git push origin feature/amazing-feature`)
5. Abre un Pull Request

---

**GAB Escucha** - Haciendo la tecnología accesible para todos 🎧
