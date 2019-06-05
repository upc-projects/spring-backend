Feature: Mantenimiento de Categoría
  Como jefe de almacen necesito realizar la gestión de Categorias

  Scenario: Registrar Categoría
    Given despues de iniciar sesion en la aplicacion
    When    hago click en el enlace de Mantenimiento de Categoria
    And    luego hago click en el boton de Nuevo
    And    en la nueva pantalla escribo en campo Nombre el valor de "Lacteos"
    And    presiono el boton de Guardar
    Then    el sistema me muestra el mensaje de: "Se guardo correctamente la Categoría"

  Scenario: Actualizar Categoría
    Given despues de iniciar sesion en la aplicacion
    When    hago click en el enlace de Mantenimiento de Categoria
    And    busco la categoria "Lacteos" para seleccionarlo de la tabla de Categorias
    And    luego hago click en el boton de Editar
    And    en la nueva pantalla escribo en campo Nombre el valor de "Cigarros"
    And    presiono el boton de Actualizar
    Then    el sistema me muestra el mensaje de: "Se actualizo correctamente la Categoría"

  Scenario: Eliminar Categoría
    Given despues de iniciar sesion en la aplicacion
    When    hago click en el enlace de Mantenimiento de Categoria
    And    busco la categoria "Cigarros" para seleccionarlo de la tabla de Categorias
    And    luego hago click en el boton de Eliminar
    Then    el sistema me muestra el mensaje de: "Se elimino correctamente la Categoría"
  
 