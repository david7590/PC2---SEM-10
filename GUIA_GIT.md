# Guía Git – Proyecto 10

## 1. Flujo básico

```bash
git init                      # Inicializa el repositorio local en la carpeta raíz
git add .                     # Prepara todos los archivos modificados (staging)
git commit -m "mensaje"       # Guarda una captura del estado actual del código
git push                      # Sube el repositorio local a GitHub
```

## 2. Estrategia para reorganizar el código (regla de oro: nunca en `main`)

```bash
# Paso 1: crear rama de refactorización y verificar estado
git checkout -b feature/reorganizacion-capas
git status

# Paso 2: un commit por cada capa
git add src/main/java/com/example/proyecto10/model/
git commit -m "feat: crear modelo e entidad JPA Producto"
git add src/main/java/com/example/proyecto10/dao/
git commit -m "feat: implementar capa DAO y Repository"
git add src/main/java/com/example/proyecto10/service/
git commit -m "feat: implementar capa de servicio con reglas de negocio"
git add src/main/java/com/example/proyecto10/controller/
git commit -m "feat: crear controlador REST de productos"

# Paso 3: publicar la rama en GitHub
git push -u origin feature/reorganizacion-capas

# Paso 4: fusionar con la rama principal
git checkout main
git merge feature/reorganizacion-capas
git push origin main
```

## 3. Conectar con tu repositorio de GitHub (una sola vez)

1. Crea un repositorio **vacío** en GitHub (sin README).
2. Ejecuta, cambiando la URL por la tuya:

```bash
git remote add origin https://github.com/TU_USUARIO/proyecto10.git
git branch -M main
git push -u origin main
git push -u origin feature/reorganizacion-capas
```

## 4. Convención de commits (Conventional Commits)

| Prefijo  | Uso                                  |
|----------|--------------------------------------|
| `feat:`  | Nueva funcionalidad                  |
| `fix:`   | Corrección de errores                |
| `docs:`  | Documentación                        |
| `chore:` | Configuración, dependencias, limpieza|
| `refactor:` | Reorganizar código sin cambiar su comportamiento |
