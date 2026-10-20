# Proyecto 10 – Arquitectura por capas y Patrón DAO

Programación de Computadoras II · Semana 10  
API REST de productos con Spring Boot, Spring Data JPA y MySQL.

## Estructura de paquetes

```
src/main/java/com/example/proyecto10/
├── controller/
│   └── ProductoController.java       # Presentación: recibe HTTP y responde JSON
├── service/
│   ├── ProductoService.java          # Lógica de negocio (interfaz)
│   └── impl/ProductoServiceImpl.java # Reglas: precio no negativo, 404 si no existe
├── dao/
│   ├── ProductoDao.java              # Patrón DAO (contrato)
│   ├── ProductoDaoImpl.java          # Implementación del DAO
│   └── ProductoRepository.java       # JpaRepository (CRUD generado por Spring)
├── model/
│   └── Producto.java                 # Entidad JPA + validaciones
└── Proyecto10Application.java
```

Flujo: `Cliente → Controller → Service → DAO → Repository → MySQL`

## Configuración

Base de datos `bdsemana10` en MySQL (se crea sola con `createDatabaseIfNotExist=true`).
Usuario `root`, sin contraseña (ver `src/main/resources/application.properties`).

## Endpoints

| Método | Ruta                  | Descripción                          | Respuesta        |
|--------|-----------------------|--------------------------------------|------------------|
| GET    | `/api/productos`      | Lista todos los productos            | 200 OK           |
| GET    | `/api/productos/{id}` | Busca un producto por id             | 200 / 404        |
| POST   | `/api/productos`      | Registra un producto (JSON)          | 201 / 400        |

Ejemplo de body para POST:

```json
{ "nombre": "Teclado", "precio": 59.90 }
```

Validaciones: `nombre` obligatorio y `precio` mayor o igual a 0.

## Ejecutar

```bash
./mvnw spring-boot:run
```

## Flujo de Git usado (ver `GUIA_GIT.md`)

Rama de trabajo `feature/reorganizacion-capas` → un commit por capa → merge a `main`.
