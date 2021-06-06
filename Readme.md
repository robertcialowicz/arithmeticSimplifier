# Języki formalne i kompilatory

## Projekt
Program do upraszczania wyrażeń algebraicznych

## Autorzy

Ciałowicz Robert <robcial@student.agh.edu.pl>

Szpila Magdalena <mszpila@student.agh.edu.pl>

## Opis
Program służy do upraszczania wyrażeń algebraicznych. Obsługuje operacje `+, -, *, /, (, )` oraz dowolną symboliczną nazwę zmiennej. Domyślnym zachowaniem programu jest pobieranie wyrażeń z pliku wsadowego `/example/example.txt` linia po linii oraz zwracanie wyników do `example/example_result.txt`. Lokalizację pliku wsadowego można zmienić poprzez zmianę marametru `inputFilePath` w klasie `main`.

## Uruchamianie

1. Uruchom projekt w IntelliJ
2. Zainstaluj plugin Antlr4
3. Uruchom mvn clean package
4. Uruchom metodę main() klasy main

## Architektura i implementacja

### Wykorzystane technologie:
- Java 8
- Antrl4 i Antlr4 plugin

### Etapy przetwarzania wyrażeń algebraicznych:
#### tokenizacja

----------TO BE DONE (grammar.g4)

#### ewaluacja wyrażenia

----------TO BE DONE (listener -> Polynomial Sum)

#### drukowanie wyniku

----------TO BE DONE (Polynomial Sum -> console output)

