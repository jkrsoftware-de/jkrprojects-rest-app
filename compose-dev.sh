#!/bin/bash
###### 🌏 ###### 💬 ######
# All my public-accessible Software-Content aren't underlying any Software-License. It's Free-Software.
# You can use my Code as you want — my only Wish is: mark me as Original-Creator of your Derivation. But you mustn't. :)
#
# My Intention of creating/publishing Free-Software is to help our Public Society.
# In this particular Case our newly-created "Computer-World". I mean everything regarding complex IT-Systems.
#
# made for jkrsoftware.de as Versioning- and Deployment-System.
# made with ❤ by Jeremy Krüger (jkr.one). 😊
###### 🌏 ###### 💬 ######
export SERVICE_NAME=jkrprojects-rest-app-development
export SERVICE_HOST=dev.rest-app.jkrprojects.de
export CURRENT_ENVIRONMENT=development

source development-service-configuration.conf

export COMPOSE_PROJECT_NAME=${SERVICE_NAME}
docker-compose $1 $2 $3 $4 $5
