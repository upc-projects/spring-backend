Feature: Mantenimiento de Tarea
  Como usuario necesito realizar la gestiÃ³n de Tareas

  Scenario: Registrar Tarea
    Given   despues de iniciar sesion en la aplicacion
    When    hago click en el boton agregar tarea
    And    en la nueva pantalla escribo en el campo Nombre el valor de "Login"
    And    en la nueva pantalla escribo en el campo Descripcion el valor de "Realizar un login"
    And    en la nueva pantalla escribo en el campo Fecha LÃ­mite el valor de "05/05/2019"
    And    presiono el boton de Guardar
    Then    el sistema me muestra el mensaje de: "Se creo correctamente la Tarea"

  Scenario: Actualizar Tarea
    Given   despues de iniciar sesion en la aplicacion
    When    hago click sobre la tarea existente "Login"
    And     hago click en la opciÃ³n actualizar tarea
    And    en la nueva pantalla escribo en el campo Fecha LÃ­mite el valor de "10/05/2019"
    And    presiono el boton de Actualizar
    Then    el sistema me muestra el mensaje de: "Se actualizo correctamente la Tarea"

  Scenario: Listar Tarea
    Given   despues de iniciar sesion en la aplicacion
    When    se muestra la pantalla de inicio
    Then    el sistema me muestra un listado con las tareas existentes

  Scenario: Eliminar Tarea
    Given   despues de iniciar sesion en la aplicacion
    When    hago click sobre la tarea existente "Login"
    And     hago click en la opciÃ³n eliminar tarea
    Then    el sistema me muestra el mensaje de: "Se elimino correctamente la Tarea"
 