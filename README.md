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

## Compilação e execução:
Devido a utilização da IDE Eclipse, a compilação do programa ocorre de forma simultânea com o desenvolvimento do mesmo. Logo, sua execução pode ser realizada via prompt de comando, seguindo os seguintes passos:
- Realizar o download da aplicação nesta pasta do GitHub;
- Extrair os arquivos na pasta desejada;
- Via prompt, realizar o seguinte comando "java -classpath C:Local-Onde-Foi-Extraído\SistemaGestaoEventos\bin\ view.TelIncial".

## Features:
O projeto oferece o cadastro de informações para gestão de eventos. Cadastre pessoas, sala de evento e espaços de café. Pesquise a qualquer momento os dados desejados persistidos em banco de dados. Visualize as pessoas cadastradas por código (ID) ou por nome e suas respectivas salas de eventos e espaços de café conforme etapa do evento. Ao acessar as telas de consulta das salas de eventos ou espaços de café, visualize todas as pessoas cadastradas com suas respectivas alocações, para mais detalhes, pesquise por sala/espaço por meio de sua ID ou nome e etapa em que a mesma será utilizada, assim, a lista de pessoas vinculadas será apresentada em uma tabela. Todas essas funcionalidades através de uma interface leve e amigável para o usuário.

## Configuração:
Para iniciar a utilização do Sistema de Gestão de Eventos, é necessário configurar as informações do seu banco de dados: URL, usuário e senha na classe Conexão do projeto (SistemaGestaoEventos\src\connection\Conexao.java). Utilize a IDE de sua preferência para configurar estes dados.

## Licença:
Não se aplica.

## Autora:
- Nome: Sarah Neuburger Brito.
- LinkedIn - linkedin.com/in/sarahneuburger
- E-mail - sarah-n.b@hotmail.com
