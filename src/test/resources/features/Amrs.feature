#Author: danielagarcia1309@gmail.com
@RegresionEcommerce
Feature: Ingresar a la pagina AMRS
  COMO tester 
  QUIERO validar el ingreso 
  PARA validar su correcto funcionamiento

  
  Scenario Outline: Ingresar a la pagina AMRS
    Given Ingreso a la pagina
    And verifico que <Elemento> sea visible
    And espero 2 segundos

    Examples: 
      | Elemento       |
      | "Txt Buscador" |
