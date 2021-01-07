#Author: danielagarcia1309@gmail.com
Feature: Ingresar a la pagina AMRS
  COMO tester 
  QUIERO validar el crear una ciudad
  PARA validar su correcto funcionamiento

  Scenario Outline: Ingresar a la pagina y crear la ciudad
    Given Ingreso a la pagina
    And espero 10 segundos
    And realizo el login
    And espero 5 segundos
    And ingreso a la opción de <Menu> y <Submenu>
    And espero 5 segundos
    And doy clic en <boton1>
    And espero 10 segundos
    And doy clic en <boton1>
    And espero 10 segundos
    And doy clic en <boton1>
    And espero 10 segundos
    And doy clic en <editar>
    And en el campo de texto "campoid" escribo "41"
    And en el campo de texto "pais" escribo "Argentina"
    And doy clic en <tablero>
    And doy clic en <guardar>
    And verifico que "success" sea visible
 

    Examples: 
      | Menu       | Submenu    | boton1   | editar   | tablero   | guardar   |
      | "Location" | "Contries" | "boton1" | "editar" | "tablero" | "guardar" |
