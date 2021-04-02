# gestao_eventos

## Sistema de Gestão de Eventos

## Breve descrição:
Este sistema visa facilitar o dia a dia de instituições na gestão dos seus eventos.
É possível cadastrar pessoas, salas de eventos e espaços de café. As pessoas são vinculadas nas salas e espaços planejados e as consultas podem ser realizadas conforme filtro desejado, por pessoa, por sala de evento ou por espaço de café. 

## Requisitos básicos:
- JDK e JRE 1.8;
- Banco de dados MySQL para persistência das informações (utilizado Workbench 8.0);
- IDE para desenvolvimento (utilizado Eclipse 12-2020);
- JUnit 4;
- Libraries: JGoodies 1.8 e MySQL Conector 5.1.

## Execução:
Realize o download da aplicação nesta pasta do GitHub e importe o projeto em sua IDE de prefência.
Utilizando o Eclipse como referência, siga os seguintes passos: 
- Clique em "Files";
- Em seguida em "Export";
- Em "Select an export wizard", selecione o "Runnable Jar File (na pasta Java)" e clique em "Next";
- Em "Launch configuration" selecione a nossa "TelaInicial";
- Em "Export destination", configure a pasta onde o arquivo será salvo e defina o nome "Sistema de Gestão de Eventos" para o mesmo;
- Por fim, em "Library Handling", mantenha a opção "extract required libraries into generated JAR" selecionada e clique em "Finish";
- O sistema estará disponível para execução no local configurado.

![image](https://user-images.githubusercontent.com/61321914/109397360-ed271380-7914-11eb-8daa-3c5cf650039b.png)

![image](https://user-images.githubusercontent.com/61321914/109397389-16e03a80-7915-11eb-95ff-89a552ea6f45.png)


## Features:
O projeto oferece o cadastro de informações para gestão de eventos. Cadastre pessoas, sala de evento e espaços de café. Pesquise a qualquer momento os dados desejados persistidos em banco de dados. Visualize as pessoas cadastradas por código (ID) ou por nome e suas respectivas salas de eventos e espaços de café conforme etapa do evento. Ao acessar as telas de consulta das salas de eventos ou espaços de café, visualize todas as pessoas cadastradas com suas respectivas alocações, para mais detalhes, pesquise por sala/espaço por meio de sua ID ou nome e etapa em que a mesma será utilizada, assim, a lista de pessoas vinculadas será apresentada em uma tabela. Todas essas funcionalidades através de uma interface leve e amigável para o usuário.

## Configuração:
Para iniciar a utilização do Sistema de Gestão de Eventos, é necessário configurar as informações do seu banco de dados: URL, usuário e senha na classe Conexão do projeto (SistemaGestaoEventos\src\connection\Conexao.java). Utilize a IDE de sua preferência para configurar estes dados.

## Autora:
- Nome: Sarah Neuburger Brito
- LinkedIn - linkedin.com/in/sarahneuburger
- E-mail - sarah-n.b@hotmail.com

## Observação:
Favor desconsiderar o commit "GestaoDeTarefas" (em 02/04/2021), trata-se de outro sistema, realizado indevidamente o commit neste link.
Para mais informações do mesmo acessar: https://github.com/sarahneuburger/gestao_de_tarefas.
