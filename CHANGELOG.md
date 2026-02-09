# 📝 Historial de Cambios - RutiWay

---
## [2.0.2] - 2026-02-09

### 🎨 **NUEVAS FUNCIONALIDADES**

#### 🌟 **Splash Screen Animado**
- **[NUEVO]** Pantalla de bienvenida al arrancar la app
    - Logo de 66vw (2/3 de pantalla) con efecto flotante
    - Título "RutiWay" con pulsación (sincronizado con menú)
    - Subtítulo "La app de crear rutas"
    - "By Leyden Ver.2.0.2" con pulsación azul ↔ blanco lenta
    - Botón degradado "🏍️ ¡Comenzamos!" con hover
    - Texto "Toca en cualquier lugar para continuar"
    - Fade in/out animado con CSS
    - Cierre al hacer clic en cualquier parte
    - Menú lateral se despliega automáticamente tras cerrar

#### ✅ **Validación de Inputs Mejorada**
- **[MEJORA]** Feedback visual cuando no encuentra ubicación
    - Aviso rojo con texto tachado: "❌ Revise País/Comunidad (Todas)"
    - Fondo `rgba(255,68,68,0.1)` + borde izquierdo rojo
    - Auto-desaparece tras 3 segundos
    - Aplica tanto a origen como destino

#### 📝 **Sugerencias Desplegables Mejoradas**
- **[MEJORA]** Dropdown de sugerencias no oculta celda de escritura
    - Posición `top: 100%` (justo debajo del input)
    - Ancho `calc(100% - 30px)` para alinear con texto
    - `left: 30px` después del icono
    - `box-shadow` para mejor visibilidad
    - Z-index 6000 para estar sobre otros elementos

#### 🏷️ **Placeholder Paradas Actualizado**
- **[MEJORA]** Texto más claro en inputs de parada
    - Cambio: ~~"Escribe o pulsación larga en punto de..."~~
    - Nuevo: **"Escribe o pulsa en mapa"**
    - Más conciso y directo para usuarios

### 🐛 **CORRECCIONES**

#### 🔧 **Fix Crítico: Error Sintaxis `autoGeo()`**
- **[FIX]** Aplicación no cargaba por código incompleto
    - Problema: Línea `fetch()` sin cerrar + código duplicado
    - Línea rota: `const res = await fetch(\`https://nominatim...` (truncada)
    - Solución: Función `autoGeo()` completa reescrita
    - Incluye ahora feedback visual de error
    - Validación correcta de respuestas vacías

#### 🧹 **Limpieza de Código Duplicado**
- **[FIX]** Código residual eliminado
    - Líneas duplicadas después de `// FIN` en `autoGeo()`
    - Variables `country`, `region` repetidas fuera de función
    - `function getWIcon()` aparecía mal posicionada

### 🎨 **MEJORAS VISUALES**

#### 💅 **Animaciones CSS Nuevas**
- `@keyframes splashFadeIn` - Aparición suave del splash
- `@keyframes splashFadeOut` - Desaparición suave del splash
- `@keyframes logoFloat` - Logo flotante vertical (0px → -10px)
- `@keyframes byPulse` - Pulsación azul ↔ blanco para firma

#### 🎨 **Estilos Splash Screen**
- Fondo degradado: `linear-gradient(135deg, #0a0a0c 0%, #1a1b26 50%, #0a0a0c 100%)`
- Botón degradado: `linear-gradient(135deg, var(--r1) 0%, var(--r2) 100%)`
- Logo con sombra: `0 10px 40px rgba(91, 192, 222, 0.3)`
- Animación `titlePulse` reutilizada del menú

### 🔧 **MEJORAS TÉCNICAS**

#### 📜 **JavaScript**
- Nueva función `closeSplash()` para gestionar cierre animado
- `window.onload` modificado para mostrar splash primero
- Delay 500ms antes de abrir menú tras splash
- Event listener en todo el splash para cerrar con clic
- `document.body.classList.add('menu-active')` solo post-splash

#### 🗂️ **Estructura HTML**
- Nuevo bloque `<div id="splash-screen">` con z-index 10000
- Splash aparece antes que sidebar/mapa
- Logo usa ruta: `assets/rutiwaylogo.png` con fallback `rutiwaylogo.png`
- Jerarquía: `splash-content > título > logo > firma > botón`

---

## [2.0.2] - 2026-02-08


### ✨ **NUEVAS FUNCIONALIDADES**

#### 📂 **Carpeta RutiWay Visible en Descargas**
- **[NUEVO]** Los archivos GPX ahora se guardan en `/Descargas/RutiWay/`
    - Carpeta visible desde "Mis Archivos" del móvil
    - Compatible con Android 5.0 - 14+ (API 21+)
    - Usa MediaStore para Android 10+ (Scoped Storage)
    - Fallback a carpeta pública para Android 9 y anteriores
    - Toast muestra ruta completa: `Descargas/RutiWay/archivo.gpx`

#### 📝 **Formato de Nombre GPX Restaurado**
- **[MEJORA]** Formato de nombre mejorado: `RutiWay_YYYYMMDD_HHMMSS.gpx`
    - Ejemplo: `RutiWay_20260208_163651.gpx`
    - Incluye fecha y hora completa para mejor organización
    - Compatible con ordenación cronológica

#### 🔍 **Sistema de Logs Detallados**
- **[NUEVO]** Logs completos en Console (Chrome Inspect) para debugging
    - Indica cada paso de la función `saveGPX()`
    - Detecta si Android Bridge está disponible
    - Verifica tipo de funciones JavaScript Interface
    - Facilita diagnóstico de problemas
    - Formato visual con líneas separadoras

### 🐛 **CORRECCIONES**

#### 🔧 **Fix Botón "GESTIÓN GPX"**
- **[FIX]** Botón "GESTIÓN GPX" ahora responde al primer clic
    - Problema: No respondía en el primer toque
    - Solución: Uso de `window.getComputedStyle()` en lugar de `element.style.display`
    - Afecta también a botón "MAPS"
    - Función `togSubExcl()` completamente reescrita

### 🔧 **MEJORAS TÉCNICAS**

#### 🗂️ **AndroidBridge.java**
- Nuevo método `saveGPX()` con soporte de carpetas
- Nuevo método `saveGPXWithMediaStore()` para Android 10+
- Usa `Environment.DIRECTORY_DOWNLOADS + "/RutiWay"`
- Escaneo de archivos para que aparezcan inmediatamente
- Intent `ACTION_MEDIA_SCANNER_SCAN_FILE` para refrescar galería
- Logs detallados con `android.util.Log.d()`

#### 📱 **Compatibilidad Android**
- Android 5.0 (API 21): Carpeta pública con permisos legacy
- Android 6-9 (API 23-28): Carpeta pública estándar
- Android 10+ (API 29+): MediaStore con `RELATIVE_PATH`
- Manejo de excepciones con Toast informativos

---

## [2.0.1] - 2026-02-01

### ✨ **NUEVAS FUNCIONALIDADES**

#### 🎯 **Sistema de Búsqueda POI por KM/Tiempo**
- **[NUEVO]** Búsqueda de ubicación por kilómetros recorridos
    - Introduce KM específicos (ej: 150 km)
    - Calcula punto exacto en geometría de ruta
    - Geolocalización inversa para obtener dirección
    - Marcador visual en el mapa

- **[NUEVO]** Búsqueda de ubicación por tiempo de viaje
    - Introduce minutos de viaje (ej: 120 min)
    - Conversión automática a distancia según velocidad media
    - Mismas capacidades que búsqueda por KM

- **[NUEVO]** Copiar ubicación al portapapeles
    - Formato: `latitud,longitud`
    - Compatible con Android Bridge (`Android.copyToClipboard`)
    - Fallback para navegadores web (Clipboard API)
    - Confirmación visual con icono ✓

- **[NUEVO]** Búsqueda de POIs cercanos
    - 3 categorías: ⛽ Gasolinera, 🍴 Restaurante, 🏨 Hotel
    - Abre Google Maps con búsqueda específica
    - Radio de búsqueda inteligente
    - Compatible con Android (`Android.openBrowser`)

#### 🔧 **Mejoras Técnicas**
- Variable global `savedTargetCoords` para almacenar coordenadas
- Función `copyLocationToClipboard(lat, lon, mode)`
- Función `searchNearbyWithCoords(category, mode)`
- Integración completa con modales existentes
- Gestión de estados entre modos `km` y `time`

---

## [2.0.0] - 2026-01-30

### ✨ **CARACTERÍSTICAS PRINCIPALES**

#### 🗺️ **Sistema de Rutas**
- Planificación con origen, destino y paradas múltiples
- Soporte multi-país: España, Francia, Andorra, Portugal
- Integración con OpenRouteService API
- Modo "Revirado" (prioriza carreteras con curvas)
- Opción "Evitar peajes"

#### 📊 **Panel de Estadísticas Flotante**
- **KM**: Distancia total de la ruta
- **VIAJE**: Tiempo estimado
- **PEAJES**: Coste aproximado
- **AVISOS**: Contador de incidencias (radares, peajes)
- **DESTINO**: Clima del punto final

#### 🎨 **Interfaz de Usuario**
- Sidebar deslizable con menú completo
- Botones flotantes circulares (centrar, limpiar, ciclo mapa)
- Leyenda fija en esquina inferior izquierda
- Interruptor MAPA/MENU fijo en lateral derecho
- Diseño dark mode optimizado

#### 🌍 **Sistema Multiidioma**
- Castellano (por defecto)
- Catalán, Francés, Portugués, Inglés
- Idiomas regionales: Valenciano, Gallego, Euskera, Aragonés, Bretón, Occitano
- Selector de país con bandera emoji
- Traducción dinámica de UI

#### 🔍 **POIs y Mapas**
- Visualización de radares (🔴 rojo)
- Gasolineras en ruta (🟠 naranja)
- Peajes (🟢 verde)
- Paradas personalizadas (📍 azul)
- Ciclo de capas de mapa (oscuro, callejero, satélite)

#### ⚙️ **Configuración Rider**
- Toggle "Revirado" (curvas)
- "Gasolina x2" (divide ruta en segmentos)
- "Evitar peajes"
- Radio de gasolineras (1-99 km)
- Velocidad media ajustable (10-140 km/h)

#### 📂 **Gestión de Archivos**
- **GPX**: Importar/Exportar trazas
- **PDF**: Generación de informe de ruta
- **Compartir**: Integración con apps externas
- **Google Maps**: Abrir ruta directamente
- **Lector de enlaces**: Importar desde URLs

#### 🌦️ **Información Meteorológica**
- Clima del destino (modal detallado)
- Pronóstico de 3 días
- Datos por hora
- Iconos visuales (☀️ sol, ☁️ nubes, 🌧️ lluvia, 🌫️ niebla)
- Marcadores de clima cada 50km en ruta

#### 📜 **Sistema de Historial**
- Almacenamiento local de rutas generadas
- Contador de rutas totales
- Iconos de configuración por ruta
- Selección visual (borde dorado)
- Eliminación individual
- Persistencia entre sesiones

#### 🎁 **Easter Eggs y Animaciones**
- Moto animada en sidebar (🏍️ viaja de derecha a izquierda)
- Moto en modal después de 6 rutas
- Humo de moto con partículas CSS
- Café animado tras 6+ rutas generadas
- Pulso en título "RUTIWAY"
- Botón "GENERAR RUTA" parpadea cuando hay cambios

#### 🤝 **Integración Android**
- AndroidBridge con JavaScriptInterface
- `copyToClipboard()` - Portapapeles nativo
- `shareText()` - Compartir con apps
- `openBrowser()` - Abrir URLs externas
- `openGoogleMaps()` - Navegación directa
- `saveFile()` - Guardar GPX en almacenamiento
- `getCurrentLocation()` - GPS del dispositivo
- `vibrate()` - Feedback háptico

#### 🔒 **Legal y Soporte**
- Sección "Legal/Ayuda" con acordeón
- Instrucciones de uso (Panel + Mapa)
- Política de privacidad
- Botón "Invítame a gasolina" (PayPal)
- Contacto: [leydenwho.app@gmail.com](mailto:leydenwho.app@gmail.com)

---

## [1.x.x] - Versiones anteriores

### Historial previo no documentado
- Versiones 1.0 - 1.9: Desarrollo inicial
- Versión 3.14 (branch experimental): Rediseño completo

---

## 🔮 Próximas Versiones

### [2.0.3] - Planificado
- [ ] Selector de tema oscuro/claro
- [ ] Mejoras en importación de GPX
- [ ] Optimización de rendimiento en rutas largas
- [ ] Soporte para rutas circulares (mismo origen/destino)

### [2.1.0] - En Desarrollo
- [ ] Temas visuales de marcas de motos (Suzuki, Ducati, Kawasaki, KTM, Yamaha)
- [ ] Splash screen animado con logo pulsante
- [ ] Mejoras en selector multiidioma
- [ ] Más regiones y provincias

### [2.2.0] - En Roadmap
- [ ] Modo offline con mapas precargados
- [ ] Sincronización en la nube
- [ ] Cuenta de usuario
- [ ] Favoritos y colecciones de rutas

### [3.0.0] - Visión Futura
- [ ] App nativa Android (Kotlin)
- [ ] Versión iOS
- [ ] Alertas de tráfico en tiempo real
- [ ] Comunidad de riders
- [ ] Compartir rutas públicamente

---

## 📌 Convenciones de Versionado

Seguimos [Semantic Versioning](https://semver.org/):

- **MAJOR** (X.0.0): Cambios incompatibles en la API
- **MINOR** (0.X.0): Nuevas funcionalidades compatibles
- **PATCH** (0.0.X): Corrección de bugs

**Formato de cambios:**
- ✨ [NUEVO]: Funcionalidad nueva
- 🔧 [MEJORA]: Mejora de funcionalidad existente
- 🐛 [FIX]: Corrección de bug
- 🔥 [BREAKING]: Cambio no compatible con versiones anteriores
- 📝 [DOCS]: Cambios en documentación
- ⚡ [PERF]: Mejoras de rendimiento
- 🎨 [STYLE]: Cambios visuales/CSS

---

**Última actualización:** 08/02/2026  
**Versión actual:** 2.0.2  
**Desarrollador:** Leyden  
**Repositorio:** [github.com/LeydenWolf/RutiWay_V2.0.1](https://github.com/LeydenWolf/RutiWay_V2.0.1)
