
## 🎯 **README v2.0.1_Stable (ACTUALIZADO)**

```markdown
# 🏍️ RutiWay v2.0.1_Stable

**La app definitiva para crear rutas en moto**

[![Android](https://img.shields.io/badge/Android-7.0%2B-green)](https://developer.android.com)
[![Version](https://img.shields.io/badge/version-2.0.1-blue)](https://github.com/LeydenWolf/RutiWay_V2.0.1)
[![License](https://img.shields.io/badge/license-Private-red)](LICENSE)

---

## 📱 Información General

- **Versión:** 2.0.2_Stable
- **Fecha:** 08/02/2026
- **Plataforma:** Android (WebView) + Web
- **Desarrollador:** Leyden
- **Contacto:** [leydenwho.app@gmail.com](mailto:leydenwho.app@gmail.com)

---
## ✨ Novedades v2.0.2

### 🎨 **SPLASH SCREEN ANIMADO**
- Pantalla bienvenida con logo de 66vw
- Título "RutiWay" con efecto pulsación (sincronizado con menú)
- "By Leyden Ver.2.0.2" con pulsación azul ↔ blanco
- Logo flotante con animación vertical
- Botón degradado "🏍️ ¡Comenzamos!"
- Cierre con clic en cualquier parte

### ✅ **VALIDACIÓN INPUTS MEJORADA**
- Aviso visual rojo cuando no encuentra ubicación
- Mensaje específico: "❌ Revise País/Comunidad (Todas)"
- Sugerencias desplegables sin ocultar celda de escritura
- Placeholder paradas: "Escribe o pulsa en mapa"

### 🐛 **CORRECCIONES**
- Error sintaxis `autoGeo()` corregido
- Código duplicado eliminado
- Estabilidad general mejorada

## ✨ Novedades v2.0.1

### 🎯 **FUNCIONALIDAD PRINCIPAL: BÚSQUEDA DE POIs POR KM/TIEMPO**

#### 📍 **Búsqueda por Kilómetros**
- Introduce KM específicos en tu ruta
- Localiza punto exacto con geolocalización inversa
- **Copia ubicación al portapapeles** (Android + Web)
- Busca **gasolineras, restaurantes y hoteles** cercanos
- Abre directamente en Google Maps

#### ⏱️ **Búsqueda por Tiempo**
- Introduce minutos de viaje
- Calcula distancia según velocidad media configurada
- Encuentra ubicación equivalente en la ruta
- Mismas funciones que búsqueda por KM

#### 🔍 **Sistema de Búsqueda POI**
- 3 categorías: ⛽ Gasolinera | 🍴 Restaurante | 🏨 Hotel
- Coordenadas guardadas automáticamente
- Integración con Google Maps
- Compatible con Android Bridge

### 📂 **GESTIÓN DE ARCHIVOS AVANZADA**
- **Exportar GPX:** Descarga con timestamp en carpeta `/RutiWay/`
- **Importar GPX:** Validación XML + visualización
- **Generar PDF:** Informe completo con:
  - Cronología ordenada por kilómetros
  - Incidencias (radares, peajes, gasolineras)
  - Clima del destino
  - Configuración de la ruta

### 🌦️ **CLIMA CADA 50KM**
- Pronóstico automático en ruta
- Iconos visuales en mapa
- Datos: temperatura, precipitación, viento
- Integrado en PDF

### 🗺️ **66 REGIONES EUROPEAS**
- **España:** 17 comunidades autónomas + Ceuta + Melilla
- **Francia:** 13 regiones
- **Italia:** 20 regiones
- **Portugal:** 7 regiones
- **Andorra:** 7 parroquias

---

## 🛠️ Estructura del Proyecto

```
RutiWay_V2.0.1/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── assets/
│   │   │   │   ├── index.html          # App principal (116KB)
│   │   │   │   ├── places.js           # BD lugares guardados (23KB)
│   │   │   │   └── rutiwaylogo.png     # Logo oficial
│   │   │   ├── java/.../
│   │   │   │   ├── MainActivity.java       # Activity principal
│   │   │   │   └── AndroidBridge.java      # JS ↔ Android
│   │   │   ├── res/
│   │   │   │   ├── drawable/           # Iconos y recursos
│   │   │   │   └── values/             # Strings, colores
│   │   │   └── AndroidManifest.xml     # Configuración
│   │   └── build.gradle.kts
├── gradle/
├── build.gradle.kts                    # Configuración Gradle
├── README.md                           # Este archivo
├── CHANGELOG.md                        # Historial versiones
└── .gitignore
```

---

## 🚀 Instalación

### **Opción 1: Android Studio (Desarrollo)**

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/LeydenWolf/RutiWay_V2.0.1.git
   cd RutiWay_V2.0.1
   ```

2. **Abre con Android Studio:**
    - File → Open → Selecciona carpeta del proyecto

3. **Verifica assets:**
    - `index.html` debe estar en `app/src/main/assets/`

4. **Compila:**
   ```bash
   ./gradlew assembleDebug
   ```

5. **Instala en dispositivo:**
   ```bash
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```

### **Opción 2: Web (Navegador)**

1. Abre `index.html` directamente en tu navegador
2. **Nota:** Funciones Android (GPS, almacenamiento) limitadas

---

## 📖 Funciones Principales

### 🗺️ **Planificación de Rutas**
- Origen, Destino y múltiples paradas ilimitadas
- Soporte 5 países: 🇪🇸 España | 🇫🇷 Francia | 🇮🇹 Italia | 🇦🇩 Andorra | 🇵🇹 Portugal
- Modo "Revirado" (prioriza carreteras con curvas)
- Evitar peajes con cálculo de coste
- Pulsación larga en mapa añade paradas

### 🎨 **Configuración Rider**
- Gasolina x2 (divide ruta en tramos automáticos)
- Velocidad media ajustable (10-140 km/h)
- Radio gasolineras configurable (1-99 km)
- Activar/desactivar:
    - Escanear radares
    - Info detalles POI
    - Clima cada 50km
    - Ver gasolineras

### 📊 **Información en Ruta**
- **Estadísticas flotantes:** KM | Tiempo | Peajes | Avisos
- Clima cada 50km con iconos animados
- Detalles de POIs al hacer clic
- Avisos de radares (Scdb.info)
- Leyenda dinámica de elementos

### 💾 **Gestión de Archivos**
- **GPX:** Import/Export con validación
- **PDF:** Informe completo con cronología
- **Compartir:** Integración apps externas
- **Google Maps:** Apertura directa de rutas

### 🌍 **Multiidioma**
- **Disponibles:** Castellano, Catalán, Francés, Portugués, Inglés
- **En desarrollo:** Valenciano, Gallego, Euskera, Aragonés, Bretón, Occitano

### 🎭 **Interfaz**
- Panel lateral desplegable
- Modo mapa completo / menú
- Historial de rutas con iconos
- 3 capas de mapa: Oscuro | Estándar | Satélite
- Animaciones suaves y transiciones

---

## 🔧 Tecnologías

| Componente | Tecnología |
|------------|------------|
| **Frontend** | HTML5, CSS3 (Variables), JavaScript ES6+ |
| **Mapas** | Leaflet.js v1.9.4 |
| **Routing** | OpenRouteService API |
| **Clima** | OpenMeteo API |
| **Geocoding** | Nominatim (OpenStreetMap) |
| **Radares** | Scdb.info (base de datos) |
| **Android** | WebView + JavaScriptInterface |
| **Build** | Gradle 8.4, Android SDK 24+ |

---

## 📝 Requisitos

### **Android**

#### **AndroidManifest.xml**
```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" 
                 android:maxSdkVersion="28" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" 
                 android:maxSdkVersion="32" />
```

#### **Gradle**
```gradle
android {
    compileSdk 34
    defaultConfig {
        minSdk 24
        targetSdk 34
        versionCode 2
        versionName "2.0.1"
    }
}
```

### **APIs Externas**
- **OpenRouteService:** Requiere API Key (editar en `index.html`)
- **Nominatim:** Sin autenticación (rate limit: 1 req/s)
- **OpenMeteo:** Gratuito sin límite

---

## 🐛 Solución de Problemas

### **Error: "Cannot read property 'copyToClipboard'"**
**Causa:** AndroidBridge no vinculado correctamente  
**Solución:**
```java
// MainActivity.java
webView.addJavascriptInterface(new AndroidBridge(this), "Android");
```

### **Ruta no se genera**
**Posibles causas:**
1. API Key incorrecta → Edita `const KEY` en `index.html`
2. Sin conexión → Verifica Internet
3. Coordenadas inválidas → Usa formato "Ciudad, País"

### **POIs no aparecen**
**Checklist:**
- [x] Ruta generada previamente
- [x] "Ver Gasolineras" activado en configuración
- [x] Radio > 2 km configurado
- [x] Internet disponible

### **PDF no descarga**
**Android 10+:** Requiere permisos storage  
**Solución:** Otorga permisos en Ajustes → Apps → RutiWay

---

## 🐞 Problemas Conocidos v2.0.1

- [ ] Splash screen inicial ausente → **Resuelto en v2.0.2**
- [ ] Validación inputs sin feedback visual → **Resuelto en v2.0.2**
- [ ] Placeholder paradas genérico → **Resuelto en v2.0.2**
- [ ] Límite 1000 radares en visualización (optimización pendiente)

---

## 🤝 Contribuir

1. Fork el proyecto
2. Crea tu rama: `git checkout -b feature/nueva-funcionalidad`
3. Commit: `git commit -m 'Add: nueva funcionalidad'`
4. Push: `git push origin feature/nueva-funcionalidad`
5. Abre Pull Request con descripción detallada

**Guía de estilo código:**
- Bloques marcados con `// INICIO - FIN`
- Variables CSS para colores
- Comentarios en castellano
- Formato ES6+ (const, let, arrow functions)

---

## 📄 Licencia

**Proyecto privado** - Uso personal y educativo  
© 2026 Leyden - Todos los derechos reservados

---

## 💰 Soporte

Si RutiWay te ayuda a disfrutar de tus rutas, ¡invítame a gasolina! ⛽

[![PayPal](https://img.shields.io/badge/PayPal-Donar-00457C?logo=paypal&logoColor=white)](https://paypal.me/leydenruben)

**¿Te gusta el proyecto?** Dale una ⭐ en GitHub

---

## 📧 Contacto

- **Email:** [leydenwho.app@gmail.com](mailto:leydenwho.app@gmail.com)
- **GitHub:** [@LeydenWolf](https://github.com/LeydenWolf)
- **Versión Web:** [Próximamente]

---

## 📅 Roadmap

### **v2.0.2 (En desarrollo - Feb 2026)**
- [x] Splash screen animado con efectos
- [x] Validación inputs con feedback visual rojo
- [x] Placeholder mejorado "Escribe o pulsa en mapa"
- [ ] Traducción completa multilíngüe splash

### **v2.1.0 (Planificado - Mar 2026)**
- [ ] Temas visuales personalizados (Suzuki, Ducati, Kawasaki, BMW)
- [ ] Sistema de favoritos en la nube
- [ ] Compartir rutas vía QR
- [ ] Notificaciones push para alertas

### **v2.2.0 (Planificado - Abr 2026)**
- [ ] Modo offline con mapas descargados
- [ ] Integración Telegram para compartir
- [ ] Alertas tráfico en tiempo real (Google Traffic)
- [ ] Puntos de interés personalizados

### **v3.0.0 (Futuro)**
- [ ] Backend propio con base de datos
- [ ] Sincronización multi-dispositivo
- [ ] Comunidad de usuarios
- [ ] Rutas compartidas públicamente

---

## 📚 Documentación Adicional

- **CHANGELOG.md:** Historial completo de cambios
- **API_DOCS.md:** Documentación de integración Android
- **CONTRIBUTING.md:** Guía para colaboradores

---

## 🙏 Agradecimientos

- **OpenRouteService** - API de rutas
- **OpenStreetMap/Nominatim** - Geocoding
- **OpenMeteo** - Datos climáticos
- **Scdb.info** - Base de datos radares
- **Leaflet.js** - Librería de mapas
- **Font Awesome** - Iconos
- **Google Fonts (Poppins)** - Tipografía

---

**¡Disfruta de tus rutas! 🏍️💨**

**RutiWay** - *Where every road is an adventure*
```

***

## 📋 **ESTRUCTURA ESTÁNDAR PARA FUTURAS VERSIONES**

**Mantén siempre este orden:**

1. **Header** (Título + Badges)
2. **Información General** (Versión, fecha, contacto)
3. **Novedades vX.X.X** (Features específicas de la versión)
4. **Estructura del Proyecto**
5. **Instalación** (Paso a paso)
6. **Funciones Principales** (Categorías claras)
7. **Tecnologías** (Tabla)
8. **Requisitos** (Android + APIs)
9. **Solución de Problemas** (FAQ)
10. **Problemas Conocidos** (Lista con checkboxes)
11. **Contribuir** (Guía)
12. **Licencia**
13. **Soporte** (Donaciones)
14. **Contacto**
15. **Roadmap** (Versiones futuras)
16. **Documentación Adicional**
17. **Agradecimientos**
18. **Footer** (Frase inspiradora)

***

