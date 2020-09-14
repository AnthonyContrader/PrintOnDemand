

[TOC]



# Esempio di microservizi in .NET

Nella solution sono stati implementati due servizi in .NET CORE

- Project1 
- Project2



## Primo servizio

**Project1** è il servizio di interfaccia con il database. L' ORM utilizzato è EF CORE. Esistono due entità persistenti:

- User
- Product

in relazione 0 - N (user può avere zero o più prodotti associati). Il pattern utilizzato è DAO (repository), Model, DTO.
**JWT** viene usato come servizio di autenticazione.



## Secondo servizio

**Project2** espone un unico metodo REST per l'inizializzazione degli users nel database; il metodo chiama semplicemente il metodo REST user/create di Project1. La resilienza è gestita grazie alla **libreria Polly**.



## Docker

I progetti Project1 e Project2 sono stati messi nei rispettivi container **Docker** ed orchestrati tramite **docker-compose** (vedere la solution directory docker-compose). Al docker-compose è stata aggiunta anche una immagine **docker con sqlserver express**.



## Frontend

Nella solution folder "**fronted**" troviamo due progetti di esempio:

- **Project1Form** (Winforms .NET framework)
- **Project1WPF** (WPF .NET framework)

Entrambi i progetti contengono una semplice form di login e una form con elenco degli users registrati nel database. La comunicazione con il database avviene tramite i metodi REST esposti di Project1.



## Shared

In aggiunta è stato introdotto anche un terzo progetto **Shared** scritto in .NET standard che contiene una libreria condivisa. Nel progetto Shared troviamo **Project1Service** (astrazione delle chiamate client verso i metodo REST di Project1) e **CommonDefine** (contiene la configurazione degli indirizzi web di Project1 e Project2).



## Esecuzione

Per eseguire i progetti, lanciare i servizi REST con docker, cliccare con il secondo tasto su Docker-Compose quindi Debug -> Avvia nuova istanza. Avviati i servizi, cliccare con il secondo tasto sul progetto frontend che si desidera debuggare e ripetere Debug -> Avvia nuova istanza.

