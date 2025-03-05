# Avaliacao3
Repositório da terceira avaliação da disciplina de Padrões de Projeto

# Padrões de Projeto: Chain of Responsibility e Template Method

## Introdução

Neste projeto, os padrões de design **Chain of Responsibility** e **Template Method** foram aplicados para resolver o problema de processar diferentes tipos de eventos, com ações distintas dependendo da prioridade e da data do evento.

Observou-se que, dependendo da prioridade e do tempo do evento, ações diferentes precisariam ser tomadas. Para acomodar essa necessidade, seria necessário utilizar muitas estruturas condicionais, o que poderia tornar o código excessivamente complexo e difícil de manter a longo prazo.

Assim, as condições de verificação (como prioridade e data) foram chamadas de **regras**, e cada uma dessas regras foi separada em uma classe distinta. Isso facilita o processamento e a manutenção do código, pois as regras são tratadas individualmente, e o fluxo é delegado de uma classe para a próxima até que uma regra seja satisfeita.

O fluxo de verificação e processamento das regras foi modelado com o padrão **Chain of Responsibility**. Além disso, quando métodos comuns foram identificados nas classes de regra, o padrão **Template Method** foi implementado para centralizar o comportamento compartilhado entre as classes concretas.

## Chain of Responsibility

A seguir, estão os componentes principais do padrão **Chain of Responsibility**:

- **Handler (RegraHandler)**  
  Define a interface para o tratamento das regras.  
  Implementa o link para a próxima regra, caso a atual não consiga processar a solicitação.

- **ConcreteHandler (RegraAltaPrioridade, RegraMediaPrioridade, RegraBaixaPrioridade)**  
  Cada classe concreta trata as solicitações que atendem suas respectivas condições de prioridade e limitação temporal.

- **Cliente (Notificador)**  
  Inicia a solicitação para um objeto do tipo **RegraHandler**, acionando a cadeia de responsabilidade.

## Template Method

O padrão **Template Method** foi utilizado para estabelecer uma estrutura comum entre as classes concretas de regra. A seguir estão os componentes principais:

- **AbstractClass (AbstractRegraHandler)**  
  Define as operações primitivas abstratas, como `verificarRegra()`, `formatarMensagem()` e `adicionarAoCalendario()`, que devem ser implementadas pelas subclasses concretas.  
  Implementa um método template, chamado `processar()`, que define o esqueleto do algoritmo de processamento.  
  Define um método hook (`enviarMensagem()`), permitindo que as classes concretas implementem esse método se necessário.

- **ConcreteClass (RegraAltaPrioridade, RegraMediaPrioridade, RegraBaixaPrioridade)**  
  Cada classe concreta implementa as operações primitivas para executar os passos específicos do algoritmo da subclasse, conforme necessário.

## Fluxo de Execução

1. O cliente (**Notificador**) inicia uma solicitação de evento.
2. A solicitação é passada para o **RegraHandler**.
3. O **RegraHandler** verifica a prioridade e a data do evento, e se a solicitação não atender aos critérios da classe atual, ela é passada para a próxima regra na cadeia.
4. O processo continua até que uma classe de regra concreta processe a solicitação e execute as operações necessárias.
5. Caso haja métodos comuns entre as classes de regra, o **Template Method** centraliza essas operações em uma estrutura compartilhada.


***A execução deve ser feita a partir da classe Simulacao.***

## Conclusão

A combinação dos padrões **Chain of Responsibility** e **Template Method** permitiu criar uma solução flexível e escalável para o processamento de eventos com diferentes prioridades e datas. O código ficou mais modular, e o uso de uma cadeia de responsabilidade evitou o crescimento descontrolado de estruturas condicionais, enquanto o **Template Method** centralizou comportamentos comuns entre as classes de regra.


