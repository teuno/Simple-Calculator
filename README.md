# Simple-Calculator

Dit is een full-stack applicatie met een angular frontend en spring-boot backend. Het idee was een feature te kiezen en
in de volgende volgorde te werken:

- repository laag
- service laag
- rest laag
- component angular
- service angular

Het angular testen ging wat stroef en dit stuk van de feature is helaas niet af. Hierdoor was er ook geen tijd om met
het overzicht van de berekeningen aan de gang te gaan.

## Backend (folder simple-calculator)

De applicatie heeft java 11 nodig. De applicatie wordt opgestart door middel van het commando ```./mvnw boot:run``` in
de root van de simple-calculator folder. Integratie testen van de gehele service ontbreken. Er zijn unittestsen voor
elke laag.

## Frontend (folder calculator-frontend)

De applicatie kan worden opgestart door middel van ```ng serve``` in de root van de calculator-frontend folder. Deze is
afhankelijk van de backend applicatie. Met ```ng test``` worden de unittests gerunt. Er zijn geen aparte e2e tests
geschreven. De default angular e2e test zit er nog in maar werkt niet. 
