# 🏍️ RutiWay v2.0.4

**La app definitiva para crear rutas en moto**

[![Android](https://img.shields.io/badge/Android-7.0%2B-green)](https://developer.android.com)
[![Version](https://img.shields.io/badge/version-2.0.4-blue)](https://github.com/LeydenWolf/RutiWay_V2.0.1)
[![License](https://img.shields.io/badge/license-Private-red)](LICENSE)

---

## 📱 Información General

- **Versión:** 2.0.4
- **Fecha:** 12/02/2026
- **Plataforma:** Android (WebView) + Web
- **Desarrollador:** Leyden
- **Contacto:** [leydenwho.app@gmail.com](mailto:leydenwho.app@gmail.com)

---

## 📋 Índice

- [✨ Novedades v2.0.4](#-novedades-v204)
- [✨ Novedades v2.0.3](#-novedades-v203)
- [✨ Novedades v2.0.2](#-novedades-v202)
- [✨ Novedades v2.0.1](#-novedades-v201)
- [🛠️ Estructura del Proyecto](#️-estructura-del-proyecto)
- [🚀 Instalación](#-instalación)
- [📖 Funciones Principales](#-funciones-principales)
- [🔧 Tecnologías](#-tecnologías)
- [📝 Requisitos](#-requisitos)
- [🐛 Solución de Problemas](#-solución-de-problemas)
- [🐞 Problemas Conocidos v2.0.4](#-problemas-conocidos-v204)
- [🤝 Contribuir](#-contribuir)
- [📄 Licencia](#-licencia)
- [💰 Soporte](#-soporte)
- [📧 Contacto](#-contacto)
- [📅 Roadmap](#-roadmap)
- [📚 Documentación Adicional](#-documentación-adicional)
- [🙏 Agradecimientos](#-agradecimientos)

---

## ✨ Novedades v2.0.4

### 🎨 **OPTIMIZACIÓN UI MENÚ LATERAL**
- **Botón idioma más compacto:** Reducido de 140px a 90px de ancho
- **Font-size optimizado:** De 0.8rem a 0.65rem para mejor legibilidad
- **Container controlado:** Añadido `max-width: 105px` en `.lang-container`
- **Fix crítico:** Versión "Ver. 2.0.4" ahora **visible sin arrastrar menú**
- **Espaciado refinado:**
    - `gap: 2px` entre elementos (antes 3px)
    - `padding: 4px 7px` en botón (antes 6px 10px)
    - `border-radius: 4px` (antes 6px)
- **Bandera reducida:** 16x12px (antes 20x15px)
- **Resultado:** Menú más limpio, profesional y sin scroll horizontal

### ✅ **MEJORAS DE UX**
- Mejor aprovechamiento del espacio en sidebar
- Header del menú completamente visible al abrir
- País, idioma y versión alineados correctamente
- Sin necesidad de desplazamiento para ver información básica

---

## ✨ Novedades v2.0.3

### 🔃 **BOTÓN DE INTERCAMBIO ORIGEN ⇄ DESTINO**
- **Botón compacto** con solo el icono 🔃
- **Ubicación estratégica:** Junto al botón +Parada: `[🔃] [🗺️ + Parada]`
- **5 validaciones inteligentes:**
    - ⚠️ Detecta si ambos campos están vacíos
    - ⚠️ Verifica que origen tenga contenido
    - ⚠️ Verifica que destino tenga contenido
    - ⚠️ Comprueba que origen tenga coordenadas válidas
    - ⚠️ Comprueba que destino tenga coordenadas válidas
- **Avisos emergentes informativos** con soluciones paso a paso
- **Intercambio completo:** Textos, coordenadas y estados de validación

### ✅ **SISTEMA DE VALIDACIÓN VISUAL**
- **Borde verde** 🟢 cuando el campo tiene coordenadas válidas
- **Borde gris** ⚪ mientras se está escribiendo o vacío
- **Funciona en:** Origen, Destino y todas las Paradas intermedias
- **Feedback instantáneo** al seleccionar una sugerencia
- **Persistencia:** Mantiene el estado verde al cargar historial
- **Reset automático:** Borde se resetea al empezar a escribir de nuevo

### 🔍 **BÚSQUEDA MEJORADA**
- **Visualización contextual:** Muestra 3 partes en sugerencias
    - Ejemplo: "Sevilla, Barcelona, Catalunya"
    - Ayuda a distinguir ubicaciones ambiguas (ciudad vs calle)
    - Contexto geográfico completo
- **Guardado inteligente:** Almacena 2 partes óptimas
    - Ejemplo: "Sevilla, Barcelona"
    - Diferencia claramente entre entidades
    - Evita ambigüedades en historial
- **Mejor geocodificación:** Resultados más precisos de Nominatim

### 🎨 **MEJORAS DE UI/UX**
- **Botones en línea horizontal:** `[🔃] [🗺️ + Parada]`
- **Alineación perfecta:** Botones alineados con inicio de campos de texto
- **Espaciado consistente:** `gap: 8px` entre elementos
- **Margin-left:** 30px para alinear después de iconos
- **Diseño limpio:** Interfaz más ordenada y profesional

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

---

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

