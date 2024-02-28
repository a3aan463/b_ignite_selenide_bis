# b_ignite_selenide_bis

Opdracht selenide

**Algemeen:**

* Focus was tests werkend krijgen
* Refactoring/stroomlijning van de code is nog niet gebeurd
* Tests starten door rechts te klikken op testng.xml en dan Run....
* Een html summary testrapport vind je na de test in de directory test-output (rechts kliklen op de html-file en openen in Browser)
* BisTest genereert foute code wegens leeftijd < 18
* BisTest_2 genereert een bisnummer zonder geboortedatum
* BisTest_3 genereert een geldige bisCode
* BisTest_4 genereert meerdere bisCodes, bisCodes worden gecontroleerd door het clipboard te gebruiken (knop "copy")

Bevindingen:

* Validatie op geboortedatum ontbreekt waardoor een nummer gegenereerd wordt dat niet geldig/valide is
* Bij meer dan 2 te genereren nummers worden er ongeldige nummers gegenereerd
