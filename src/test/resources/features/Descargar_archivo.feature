#Author: danielagarcia1309@gmail.com
Feature: Ingresar a la pagina AMRS
  COMO tester 
  QUIERO validar descargar el archivo
  PARA validar su correcto funcionamiento

  Scenario Outline: Ingresar a la pagina y descargar el archivo
    Given Ingreso a la pagina
    And espero 10 segundos
    And realizo el login
    And espero 5 segundos
    And ingreso a la opción de <Menu> y <Submenu>
    And espero 5 segundos
    And doy clic en <boton2>
    And espero 20 segundos

    Examples: 
      | Menu       | Submenu    | boton2 |
      | "Location" | "Contries" | "cvs"  |
