#!/bin/bash
###### π ###### π¬ ######
# All my public-accessible Software-Content aren't underlying any Software-License. It's Free-Software.
# You can use my Code as you want β my only Wish is: mark me as Original-Creator of your Derivation. But you mustn't. :)
#
# My Intention of creating/publishing Free-Software is to help our Public Society.
# In this particular Case our newly-created "Computer-World". I mean everything regarding complex IT-Systems.
#
# made with β€ by Jeremy KrΓΌger (jkr.one). π
###### π ###### π¬ ######
source ../service-configurations/development-service-configuration.conf

export COMPOSE_PROJECT_NAME="${SERVICE_NAME}"
# shellcheck disable=SC2086
docker-compose $1 $2 $3 $4 $5
