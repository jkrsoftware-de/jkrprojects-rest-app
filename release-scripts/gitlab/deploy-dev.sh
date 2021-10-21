#!/bin/bash

readonly SSH_DEPLOYMENT_HOST=${1}
readonly SSH_DEPLOYMENT_USER=${2}
readonly SSH_DEPLOYMENT_PASS=${3}
readonly SSH_DEPLOYMENT_LOCATION=${4}

if [ -z ${SSH_DEPLOYMENT_HOST} ]; then
  echo "You don't have provided a SSH-Host for Deployment."
  echo "Please check your configuration and try again."
  exit 1
fi

if [ -z ${SSH_DEPLOYMENT_USER} ]; then
  echo "You don't have provided a SSH-User for Deployment."
  echo "Please check your configuration and try again."
  exit 1
fi

if [ -z ${SSH_DEPLOYMENT_PASS} ]; then
  echo "You don't have provided a SSH-Password for Deployment."
  echo "Please check your configuration and try again."
  exit 1
fi

if [ -z ${SSH_DEPLOYMENT_LOCATION} ]; then
  echo "You don't have provided a SSH-Password for Deployment."
  echo "Please check your configuration and try again."
  exit 1
fi

echo "Will execute a deployment-script on Host \"${SSH_DEPLOYMENT_HOST}\" with user: ${SSH_DEPLOYMENT_USER}"
SSHPASS=${SSH_DEPLOYMENT_PASS} sshpass -e ssh -oStrictHostKeyChecking=no -tt ${SSH_DEPLOYMENT_USER}@${SSH_DEPLOYMENT_HOST} << ENDSSH

# shellcheck disable=SC2164
cd ${SSH_DEPLOYMENT_LOCATION}

git reset --hard
git checkout development
git reset --hard origin/development
git pull

./compose-dev.sh up -d --build

exit # logout from ssh-shell
ENDSSH