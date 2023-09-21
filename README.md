# Padrões de Projeto usando Spring Boot

Este projeto teve como objetivo o desenvolvimento dos conceitos de padrões de projetos criacionais, estruturais e comportamentais.

De exemplo foram aplicados: Singleton (criacional), Facade (estrutural) e Strategy (comportamental).

O Spring Boot é uma convenção popular e já implementa, a partir de Annotations (@Autowired, etc) alguns conceitos vistos durante o aprendizado.

Fora adicionado no código alguns comentários exemplificando o raciocínio de padrões de projeto. Os mesmos estão compilados aqui:

Utilizando o padrão de projeto de estrutural "facade" é possível fazer simplificações de objetos e abstrações para facilitar e enxutar o desenvolvimento e entendimento do projeto e da regra de negócio. Por exemplo, nesse projeto não é necessário pedir explicitamente o endereço ao usuário pois ao preencher automaticamente a partir do CEP, criamos uma fachada simplificada sobre o usuário e também evita-se digitalção inccoreta dis dados e traz facilidade à verificação do dado real e armazenamento.
* Usar o JPA, que é uma especificação do Hibernate, que otimizou a forma que o Java tratava os Bancos de Dados
* Utilizar Annotations para determinar o que é Repository, AutoWired, Service, Requisições Rest
* Usar o ViaCep para preencher o endereço

Utilizando o padrão de projeto de criação "singleton" é possível utilizar instâncias estáticas e economizar recursos computacionais, bem como garantir o uso do mesmo objeto e evitar algumas falhas de segurança por abuso de stack overflow.
* Toda entidade que contiver o Autowired é singleton

Utilizando padrão de projeto de comportamento "strategy" é possível trazer múltiplas abordagens para uma interface a depender da necessidade de diferentes fornecedores ou consumidores. Por exemplo, nesse projeto, poderia ser utilizado para diferenciar tipos de usuários e serviços.
 
 Identificação de Usuários:
    Natural brasileiro (possui CPF)
    Estrangeiro (passaporte)
 Tipo de fonte de dados do usuário:
    API ViaCep
    API Correios
 
 Independente da forma que o dado chega, ou da forma que ele é discriminado, existem diversas ações em comuns que devem ser mantidas iguais, para essas usamos interface.
