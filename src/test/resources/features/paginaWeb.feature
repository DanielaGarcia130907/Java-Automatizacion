#Author: danielagarcia1309@gmail.com
@paginaWeb
Feature: Pagina web 
  COMO tester
  QUIERO validar ingresar a la pagina web
  PARA validar su correcto funcionamiento

 
  Scenario Outline: Ingresar a la pagina web
    Given Ingreso a la pagina web
    And verifico que <Elemento> sea visible
    And realizo el login
    And espero 2 segundos
    

    Examples: 
      | Elemento   |
      | "txtlogin" |
