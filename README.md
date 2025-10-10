# SOPLADOS S.A.

Sistema de gestión integral para talleres mecánicos desarrollado en Java, que permite administrar clientes, vehículos, mecánicos y órdenes de servicio.

## Descripción

SOPLADOS S.A. es una aplicación de consola que facilita la gestión completa de un taller mecánico, desde el registro de clientes y sus vehículos hasta la creación y seguimiento de órdenes de servicio con mecánicos especializados.

## Funcionalidades Principales

### Gestión de Clientes
- Registrar nuevos clientes con información personal
- Consultar clientes por cédula
- Listar todos los clientes registrados
- Eliminar clientes del sistema
- Registrar vehículos asociados a cada cliente

### Gestión de Mecánicos
- Registrar mecánicos con especialidad
- Asignar servicios que puede realizar cada mecánico
- Consultar información de mecánicos
- Listar todos los mecánicos disponibles
- Eliminar mecánicos del sistema

### Gestión de Vehículos
- Registrar vehículos con detalles completos (marca, modelo, placa, año, kilometraje)
- Asociar múltiples vehículos a un cliente
- Listar vehículos de un cliente específico

### Gestión de Órdenes de Servicio
- Crear órdenes de servicio vinculando cliente, vehículo y mecánico
- Generar número de orden único automáticamente
- Registrar fechas de ingreso y entrega estimada
- Buscar órdenes por número
- Listar todas las órdenes de un cliente
- Eliminar órdenes de servicio

##  Cómo Usar
- Se debe ejecutar la clase Main para dar inicio al programa.

### Flujo típico de uso
1. **Registrar un mecánico** con su especialidad y servicios
2. **Registrar un cliente** con su información personal
3. **Agregar vehículos** al cliente registrado
4. **Crear orden de servicio** seleccionando cliente, vehículo y mecánico
5. **Consultar y gestionar** las órdenes creadas

## Relaciones entre Clases

### 1. **Herencia**
- `Cliente` y `Mecanico` heredan de `Persona`
- Implementa reutilización de código para atributos comunes (cédula, nombre, teléfono, correo)

### 2. **Composición**
- `Cliente` contiene listas de `Vehiculo` y `OrdenServicio`
- `Mecanico` contiene lista de `Servicio`

### 3. **Agregación**
- `OrdenServicio` referencia a `Cliente`, `Vehiculo` y `Mecanico`
- `Servicio` referencia a `Mecanico` asignado

### 4. **Dependencia**
- Clases `ui` dependen de `controlador`
- Clases `controlador` dependen de `modelos`

### 5. **Asosiacion**
- Si bien `OrdenServicio` presenta agregacion con `Cliente`, `Vehiculo` y `Mecanico`, tambien permite la asociacion entre estas 3. 

## Estructura de Datos

### Almacenamiento en Memoria
El sistema utiliza `BaseDatos` como almacenamiento temporal con:
- `ArrayList<Cliente>` para clientes
- `ArrayList<Mecanico>` para mecánicos
- Las órdenes se almacenan dentro de cada cliente

### Modelos Principales
- **Persona**: Clase base con datos personales
- **Cliente**: Persona con vehículos y órdenes
- **Mecanico**: Persona con especialidad y servicios
- **Vehiculo**: Información del vehículo
- **OrdenServicio**: Orden de trabajo con fechas y asignaciones
- **Servicio**: Tipo de servicio que ofrece un mecánico

## Notas Importantes

- Los datos se almacenan en memoria (se pierden al cerrar el programa)
- Los números de orden se generan aleatoriamente entre 1000-9999
- La fecha de entrega estimada es automáticamente 1 mes después del ingreso
- No hay validaciones para verificar las entradas, el tipo de entrada, etc.
- Tratar de ingresar la informacion tal y como se solicita para evitar caidas!

