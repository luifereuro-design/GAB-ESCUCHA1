# Guía Completa de Compilación y Publicación - GAB Escucha

## Requisitos Previos

- Java JDK 11+
- Android SDK (API 34)
- Git
- Gradle 8.0+

## Paso 1: Generar Keystore para Firma de APK

```bash
mkdir -p keystores
keytool -genkey -v -keystore keystores/gab-escucha.jks \
  -keyalg RSA \
  -keysize 2048 \
  -validity 10000 \
  -alias gab_escucha
```

**Datos que debes ingresar:**
- Contraseña de keystore: `gab2024secure`
- Nombre completo: Tu nombre
- Unidad organizativa: GAB Escucha
- Organización: GAB Escucha Dev
- Ciudad: Tu ciudad
- Estado: Tu estado
- País: Tu país (código 2 letras)
- Contraseña clave: `gab2024secure`

## Paso 2: Configuración Local

Crea `local.properties`:
```properties
sdk.dir=/ruta/a/android/sdk
```

## Paso 3: Compilación

### Debug APK (para pruebas)
```bash
./gradlew assembleDebug
```
Resultado: `app/build/outputs/apk/debug/app-debug.apk`

### Release APK (para Play Store)
```bash
./gradlew assembleRelease
```
Resultado: `app/build/outputs/apk/release/app-release.apk`

## Paso 4: Instalar en Dispositivo

```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

## Paso 5: Publicar en Google Play Store

### 5.1 Crear Cuenta de Desarrollador
- Ve a https://play.google.com/console
- Crea una cuenta ($25 USD de pago único)

### 5.2 Preparar Activos
- **Icono**: 512x512px PNG
- **Capturas de pantalla**: 2-8 imágenes de 1080x1920px
- **Descripción**: Máx 4000 caracteres
- **Política de privacidad**: URL

### 5.3 Crear Nueva Aplicación
1. En Play Console, haz clic en "Crear aplicación"
2. Nombre: "GAB Escucha"
3. Categoría: Medicina o Accesibilidad

### 5.4 Subir APK
1. Ve a "Release Management" → "Releases"
2. Crea nueva versión en "Internal Testing"
3. Sube `app-release.apk`

### 5.5 Completa la Información
- Descripción, capturas, icono
- Contacto de soporte
- Política de privacidad

### 5.6 Enviar para Revisión
- Google revisará en 24-72 horas
- Aprobada → Disponible en Play Store

## Troubleshooting

### Error: "Permission denied"
```bash
chmod +x gradlew
```

### Error: "Build failed"
```bash
./gradlew clean build
```

### JAVA_HOME no configurado
```bash
export JAVA_HOME=/ruta/a/jdk
```

## Contacto

- GitHub: https://github.com/luifereuro-design/gab-escucha1
- Issues: https://github.com/luifereuro-design/gab-escucha1/issues

---

**GAB Escucha - Haciendo la tecnología accesible 🎧**
