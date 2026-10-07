# SistemaRural-PE

Registro rapido para brigadas de vacunacion en zonas rurales del Peru.
Caso aplicado: Brigada de Vacunacion Rural, Red de Salud San Ignacio, Cajamarca.

Curso: Lenguajes de Programacion (UAIN1288P) - UPN. Examen Final.

## Requerimientos principales
- RF01 Registrar datos de la persona y la vacuna aplicada
- RF03 Marcar como vacunada sin duplicar registros
- RF04 Conteo de dosis disponibles
- RF05 Reporte detallado de la jornada
- RF07 Validar los datos ingresados

## Restricciones de diseno
- Paradigmas: POO + funcional + eventos, con manejo de excepciones
- Java (OpenJDK) y Eclipse
- El DNI nunca se muestra completo (Ley N.o 29733)
- No se guarda historial clinico

## Patrones de diseno
- Singleton: JornadaVacunacion
- Factory: ReporteFactory

## Como ejecutar
1. Importar en Eclipse: File > Import > Existing Projects into Workspace.
2. Ejecutar Menu.java como Java Application.
3. Pruebas: clic derecho en la carpeta test > Run As > JUnit Test (JUnit 5).

## Integrantes
- Jonathan Sebastian Obregon Quintanilla
- Fabricio Ronald Huaman Sanchez
- Manuel Jordan Taro Calderon Perez
