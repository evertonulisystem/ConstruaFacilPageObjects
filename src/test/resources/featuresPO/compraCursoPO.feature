Feature: Comprar curso papito

  Scenario Outline: Pesquisar curso
    When que acesso o site papito
    Given pesquiso por "<arg0>"
    Then confirmo o nome do curso "<arg0>"
    Examples:
      | arg0    |
      | cypress |
