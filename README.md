# DOO-Tarea-2

## Integrantes:

- Alonso Ignacio Vergara Olivari
- Cristobal Benjamin Chavez Sandoval
- Francisca Belen Hidalgo Pezo

## Cambios Realizados:

- Se agregó una lista de Empleados en la clase 'Departamento' para conocer la cantidad de empleados y así poder calcular las ausencias en las reuniones.

- En la clase 'Invitacion' se añadió la variable Invitable invitado, permitiendo comparar los invitados con los asistentes para determinar las ausencias.

- En la clase 'Reunion' se añadieron listas de notas, asistencias e invitaciones para mantener un registro de la informacion asociada a cada reunion.

## Nuevas Funcionalidades:

- Para permitir la invitación y asistencia de invitados externos que no sean empleados, se creó la clase 'Externos' que implementa la interfaz 'Invitable' y contiene un nombre y correo asociados.

- Para la elaboración de un informe de la reunion, se creó la clase 'Informe' que utiliza 'PrintWriter' y 'FileWriter' para escribir archivos .txt y IOException para manejar posibles errores en la creación del archivo.