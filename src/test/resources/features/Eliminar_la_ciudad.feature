#Author: danielagarcia1309@gmail.com

Feature: Ingresar a la pagina AMRS
  COMO tester 
  QUIERO validar el eliminar una ciudad
  PARA validar su correcto funcionamiento
  
  Scenario Outline: Ingresar a la pagina y remover la ciudad
    Given Ingreso a la pagina
    And espero 10 segundos
    And realizo el login
    And espero 5 segundos
    And ingreso a la opción de <Menu> y <Submenu>
    And espero 5 segundos
    And doy clic en <borrar>
   

    Examples: 
      | Menu       | Submenu    | borrar   |
      | "Location" | "Contries" | "borrar" |