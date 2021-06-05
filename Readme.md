# Języki formalne i kompilatory

## Projekt
Program do upraszczania wyrażeń algebraicznych

## Authors

Ciałowicz Robert <robcial@student.agh.edu.pl>

Szpila Magdalena <mszpila@student.agh.edu.pl>

## Architektura




## Uruchamianie

- Pobieranie wartości z pliku zdefiniowanego w klasie Main
- Pisanie wyników na konsolę i do pliku




1. Install ANTLR v4 ([manual](https://github.com/antlr/antlr4/blob/master/doc/getting-started.md#installation))
1. Generate ANTLR files `antlr4 Calculator.g4 -no-listener -visitor -o app`
1. Copy visitor implementation `cp *.java app`
1. Compile `javac app/*.java`


