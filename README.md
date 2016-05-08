Projeto que salva, lista e mostra a previsão do tempo de cidades utilizando a api http://openweathermap.org/

# Bibliotecas Utilizadas Backend
- jersey
- gson

# Bibliotecas Utilizadas Frontend
- Bootstrap 
- AngularJS
- jQUery

#Servidor de Aplicação
- TomEE Plume (apache-tomee-1.7.4-plume)

#Automação de Compilação 
- maven

# Ferramenta para desenvolvimento
- Eclipse Mars JavaEE Version: Mars.2 Release (4.5.2) 

# Instalação
- 1 - Baixe o projeto do github e importe-o para o eclipse.
- 2 - Instale as dependências do maven (Botão direito no projeto > Maven > Update Project)
- 3 - Em seguida verificaremos se as dependências estão corretas, clique com o botão direito no projeto > run as.. > maven install.. (6º opção), digite em Goal "clean install" e clique em Run.
Se aparecer a mensagem "[INFO] BUILD SUCCESS" está tudo certo
- 4 - Para executar o projeto, clique com o botão direito no projeto > run as > run on server. Nas opções, escolha Apache e em seguida Tomcat v7.0 Server (servirá para startar o TomEE do eclipse, lembrando que pode ser gerado um WAR para ser inserido diretamente no TomEE) > Next > escolha o local root onde o tomEE foi descompacatado > Next > Finish.

- O sistema abrirá na seguinte URL: http://localhost:8080/prova/
