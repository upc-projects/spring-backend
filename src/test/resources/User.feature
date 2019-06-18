# INICIO REGISTRAR USUARIO

Feature: Registrar usuario
  As a user I need to register in order to manage my tasks

  Scenario: Registrar usuario1
    Given user name is "empty"
    When post method save user is "executed"
    Then the user recieves the message "name is compulsory"

  Scenario: Registrar usuario2
    Given user password is "empty"
    When post method save users is "executed"
    Then the user recieves the messagesito "password is compulsory"

# Scenario: Registrar usuario
#     Given contraseña contiene menos de 8 caracteres y/o no contenga un numero 
#     When se ejecuta metodo post "guardar usuario"  
#     Then recibe el mensaje de error "La contrasena debe contener al menos un número y 8 caracteres"

# Scenario: Registrar usuario
#     Given correo electronico es vacio 
#     When se ejecuta metodo post "guardar usuario"
#     Then recibe el mensaje de error "Correo electronico es obligatorio"

# Scenario: Registrar usuario
#     Given ingresa los 3 campos correctamente
#     When se ejecuta metodo post "guardar usuario"
#     Then recibe response status 201 "created"

# # FIN REGISTRAR USUARIO

# # INICIO ELIMINAR USUARIO

# Feature: Eliminar usuario
#     As a user I need to delete my account in order to stop using the application

# Scenario: Eliminar usuario
#     Given un usuario existente 1
#     When hace click en "eliminar"
#     Then se muestra mensaje "¿Seguro que desea eliminar su cuenta?"
    
# Scenario: Eliminar usuario
#     Given mensaje "¿Seguro que desea eliminar su cuenta"
#     When hace click en "confirmar"
#     And se ejecuta metodo delete "eliminar usuario"
#     Then recibe response status 200 "cuenta eliminada"

# # FIN ELIMINAR USUARIO

# # INICIO RESGISTRAR TAREA

# Feature: Registrar tarea
#     As a user I need to register a task in order to manage my tasks

# Scenario: Eliminar usuario
#     Given nombre de tarea es vacio 
#     When se ejecuta metodo post "guardar tarea"
#     Then recibe el mensaje de error "Nombre de tarea es obligatorio"

# Scenario: Eliminar usuario
#     Given nombre de tarea tenga valor diferente a vacio 
#     When se ejecuta metodo post "guardar tarea"
#     Then recibe response status 201 "tarea guardada"

# # FIN REGISTRAR TAREA

# # INICIO ACTUALIZAR TAREA

# Feature: Actualizar tarea
#     As a user I need to update a task in order to manage my tasks

# Scenario: Actualizar tarea
#     Given estado de tarea ha cambiado
#     When se ejecuta metodo put "Actualizar tarea"
#     Then  recibe response status 201 "se guardo tarea"

# # FIN ACTUALIZAR TAREA

# # INICIO LISTAR TAREA

# Feature: Listar tarea
#     As a user I need to list a task in order to manage my tasks

# Scenario: Listar tarea
#     Given usuario existente con tareas asignadas
#     When se ejecuta metodo get "Listar tareas"
#     Then  recibe response status 200 "tareas obtenidas"

# Scenario: Listar tarea
#     Given usuario existente sin tareas asignadas
#     When se ejecuta metodo get "Listar tareas"
#     Then  recibe response status 200 "No hay tareas disponibles"

# # FIN LISTAR TAREA

# # INICIO ELIMINAR TAREAS

# Feature: Elimninar tareas
#     As a user I need to delete a task in order to manage my tasks

# Scenario: Elimninar tareas
#     Given usuario existente con tareas asignadas 
#     When hace click en "eliminar tarea"
#     Then recibe mensaje "¿Desea eliminar esta tarea?"

# Scenario: Elimninar tareas
#     Given mensaje "¿Desea eliminar esta tarea?""
#     When hace click en confirmar
#     And se ejecute metodo delete "eliminar tarea"
#     Then recibe response status 200 "tarea eliminada"

# # FIN ELIMINAR TAREAS