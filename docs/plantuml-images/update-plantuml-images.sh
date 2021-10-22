#!/bin/bash

if [[ ! -f "plantuml.jar" ]]; then
    wget https://sourceforge.net/projects/plantuml/files/plantuml.1.2021.12.jar/download -O plantuml.jar
fi

java -jar plantuml.jar */*.puml
