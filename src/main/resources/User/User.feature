Feature: Mantenimiento de Usuario
  Como usuario necesito realizar la gestiÃ³n de Tareas

  Scenario: Registrar Usuario
    Given   Ingreso en la aplicacion
    When    hago click en el boton crear cuenta
    And    en la nueva pantalla escribo en el campo correo electronico el valor de "miguel@gmai.com"
    And    en la nueva pantalla escribo en el campo contraseña el valor de "********"
    And    presiono el boton de Guardar usuario
    Then    el sistema me muestra el mensaje de: "Se creo correctamente tu cuenta" y muestra la pantalla home


  Scenario: Eliminar Usuario
    Given   despues de iniciar sesion en la aplicacion con el usuario que eliminare
    When    hago click sobre administrar usuario
    And     hago click en la opcion eliminar usuario
    And     hago click en aceptar en la ventana de confirmacion
    Then    el sistema muestra el mensaje de: "Se elimino correctamente tu cuenta"

  Scenario: Iniciar Sesion
    Given   ingreso a la aplicación web
    When    ingreso mi correo electrónico
    And     ingreso mi Contraseña
    And     hago click en el boton iniciar sesión
    Then    el sistema accede a mi cuenta y muestra la pantalla con mis tareas
