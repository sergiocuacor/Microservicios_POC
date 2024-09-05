# Prueba de concepto - Microservicios

## Descripción
Este proyecto es una prueba de concepto de una arquitectura de microservicios cuyo único objetivo es el aprendizaje de las 
diferentes tecnologías utilizadas en este campo del desarrollo de software.

## Tecnologías utilizadas
- Spring Boot
- Spring Cloud Eureka Server
- Circuit breaker
- OpenFeign
- Docker
- RabbitMQ
- Micrometer Tracing
- Kubernetes

## Estructura del Proyecto
El proyecto consta de los siguientes microservicios:

1. **Service Discovery: (eureka-server)**: Maneja el registro y descubrimiento de servicios.
2. **Servicio de Clientes (customer)**: Gestiona el registro de clientes.
3. **Servicio de Verificación de clientes**: Se comunica con customer y verifica que el cliente no es fraudulento (bots) (Work in progress).
4. **Servicio de Notificaciones**: Encargada de notificar sobre lo que ocurre entre los distintos microservicios.
5. **API Gateway**: Centraliza el punto de entrada para todos los microservicios.
