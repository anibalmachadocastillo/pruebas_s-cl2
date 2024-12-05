@Test
Feature: Consultar posts

  Scenario: Obtener post sin parametros
    Given el post sin parametros
    When se envia solicitud de post
    Then debería devolver el codigo 200
    And validar el post de la lista de esquemas json

  Scenario Outline: Obtener post con parametro de id
    Given el post con id <id>
    When se envia solicitud de post
    Then debería devolver el codigo 200
    And validar el id del post el cual debe ser <id>
    Examples:
      | id  |
      | 181163   |

  Scenario Outline: Obtener post con parametro de user_id
    Given el post con user_id <user_id>
    When se envia solicitud de post
    Then debería devolver el codigo 200
    And validar el user_id de post debe contener <user_id>
    Examples:
      | user_id |
      | 7568346 |

  Scenario Outline: Obtener post con parametro de title
    Given el post con title "<title>"
    When se envia solicitud de post
    Then debería devolver el codigo 200
    And validar el title del post debe ser "<title>"
    Examples:
      | title |
      | lorem |

  Scenario Outline: Obtener post con parametro de body
    Given el post con body "<body>"
    When se envia solicitud de post
    Then debería devolver el codigo 200
    And validar el body del post debe contener "<body>"
    Examples:
      | body             |
      | Absens vulgivagus ager |
