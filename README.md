# EjemploClase

Aplicación Android sencilla que muestra cómo crear una primera pantalla con Jetpack Compose: una cabecera con imagen y una lista de tarjetas alimentada desde un `ViewModel`.

## Qué muestra la pantalla

- **Cabecera con imagen** con un icono de favorito (izquierda) y un icono de compartir (derecha).
- **Lista de tarjetas** (`LazyColumn`), cada una con título, descripción y los botones **Borrar** y **Ver más**.
- Las acciones de los botones se registran en Logcat (etiqueta `PantallaPrincipalVM`).

## Tecnologías

- Kotlin
- Jetpack Compose + Material 3
- `ViewModel` con `StateFlow` (arquitectura de estado unidireccional)
- Gradle (Kotlin DSL) con catálogo de versiones

## Requisitos

- Android Studio (versión reciente con soporte para SDK 37)
- JDK 11 o superior
- Dispositivo o emulador con Android 14 (API 34) o superior

## Cómo ejecutarlo

1. Clona el repositorio y ábrelo en Android Studio.
2. Espera a que termine la sincronización de Gradle.
3. Selecciona un emulador o dispositivo y pulsa **Run ▶**.

También desde la línea de comandos:

```bash
./gradlew installDebug
```

## Estructura del proyecto

```
app/src/main/java/com/permuta/ejemploclase/
├── MainActivity.kt                  # Punto de entrada; aplica el tema y muestra la pantalla
├── ui/
│   ├── page/PantallaPrincipal.kt    # Pantalla: compone cabecera y lista de tarjetas
│   ├── component/
│   │   ├── CabeceraImagen.kt        # Componente de cabecera con imagen e iconos
│   │   └── TarjetaItem.kt           # Componente de tarjeta con acciones
│   └── theme/                       # Colores, tipografía y tema
└── viewmodel/PantallaPrincipalVM.kt # Estado de la pantalla y acciones (cargar, borrar, ver más)
```

## Conceptos que ilustra

- Separar la **pantalla**, los **componentes** reutilizables y el **ViewModel**.
- Pasar datos y callbacks a los componentes mediante clases de datos (`TarjetaItemData`, `CabeceraImagenData`).
- Exponer el estado de la UI con `StateFlow` y consumirlo con `collectAsState()`.
- Previsualizar componentes con `@Preview`.
