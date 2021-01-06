#Author: h.andresc1127@gmail.com.com
@ejemplo
Feature: Busqueda en google
  COMO automation tester
  QUIERO crear un ejemplo de automatizacion
  PARA que sea la base del proyecto

  @elemplo @google
  Scenario: Busqueda en google
    Given Navego a la url "google.com"
    When Ingreso "henry andres correa correa" en el campo "busqueda Google"
    And Doy click en "Búscar"
    Then El campo "Resultados" contiene "Senior QA Automation"

  @ejemplo2
  Scenario Outline: Busqueda con parametros google
    Given Navego a la url "google.com"
    When Ingreso <valor> en el campo "busqueda Google"
    And Doy click en "Búscar"
    Then El campo "Resultados" contiene <resultado>

    Examples: 
      | case  | valor   | resultado |
      | name1 | "henry" | "futbol"  |
      | name2 | "panda" | "animal"  |
