# ⚽ Sistema de Gestión de Fútbol (CRUD)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Swing](https://img.shields.io/badge/Java_Swing-orange?style=for-the-badge)

Este es un proyecto integral desarrollado durante mi **1º año de DAW**. Consiste en una aplicación de escritorio para gestionar la base de datos de una liga de fútbol, permitiendo el control total sobre jugadores y equipos.

## 🎯 Objetivos del Proyecto
* Implementar una arquitectura **MVC (Modelo-Vista-Controlador)** para separar la lógica de negocio de la interfaz.
* Gestionar la persistencia de datos en **MySQL** mediante conectores JDBC.
* Crear una interfaz de usuario intuitiva y funcional utilizando **Java Swing**.

## 🚀 Funcionalidades Actuales (6/9)
- [x] **Ver Jugadores:** Listado dinámico en JTable desde la BD.
- [x] **Agregar Jugador:** Inserción de nuevos registros con validación.
- [x] **Buscar Jugador por DNI:** Consulta filtrada rápida.
- [x] **Ver Equipos:** Visualización de la tabla de clubes.
- [x] **Agregar Equipo:** Gestión de nuevas entidades deportivas.
- [x] **Salir:** Cierre controlado con confirmación de usuario.
- [ ] *Próximamente:* Modificación de registros y búsqueda avanzada de equipos.

## 🛠️ Detalles Técnicos
* **Patrón de Diseño:** MVC para un código escalable y mantenible.
* **Seguridad:** Uso de `PreparedStatement` para prevenir inyección SQL.
* **UX/UI:** Diseño de botones con códigos de colores para facilitar la navegación y diálogos de confirmación `JOptionPane`.

## 📂 Estructura del Proyecto
```text
├── src/
│   ├── controller/  # Lógica de eventos y control de flujo
│   ├── model/       # Clases de entidad y conexión a DB
│   └── view/        # Ventanas y componentes Swing
├── database/        # Script .sql para replicar la base de datos
└── lib/             # Conector MySQL JDBC
