#!/bin/bash
###### 🌏 ###### 💬 ######
# All my public-accessible Software-Content aren't underlying any Software-License. It's Free-Software.
# You can use my Code as you want — my only Wish is: mark me as Original-Creator of your Derivation. But you mustn't. :)
#
# My Intention of creating/publishing Free-Software is to help our Public Society.
# In this particular Case our newly-created "Computer-World". I mean everything regarding complex IT-Systems.
#
# made with ❤ by Jeremy Krüger (jkr.one). 😊
###### 🌏 ###### 💬 ######
readonly SSH_DEPLOYMENT_HOST=${1}
readonly SSH_DEPLOYMENT_USER=${2}
readonly SSH_DEPLOYMENT_PASS=${3}
readonly SSH_DEPLOYMENT_LOCATION=${4}
readonly BRANCH_TO_DEPLOY=${5}
readonly DEPLOYMENT_ENVIRONMENT=${6}

if [ -z ${SSH_DEPLOYMENT_HOST} ]; then
  echo "You don't provide a SSH-Host for Deployment."
  exit 1
fi

if [ -z ${SSH_DEPLOYMENT_USER} ]; then
  echo "You don't provide a SSH-User for Deployment."
  exit 1
fi

if [ -z ${SSH_DEPLOYMENT_PASS} ]; then
  echo "You don't provide a SSH-Password for Deployment."
  exit 1
fi

if [ -z ${SSH_DEPLOYMENT_LOCATION} ]; then
  echo "You don't provide a SSH-Password for Deployment."
  exit 1
fi

if [ -z ${BRANCH_TO_DEPLOY} ]; then
  echo "You don't provide a Branch you'd like to deploy."
  exit 1
fi

if [ -z ${DEPLOYMENT_ENVIRONMENT} ]; then
  echo "You don't provide an Environment-Identifier, for what you'd like to start a Deployment for."
  exit 1
fi

echo "Deploy on Host \"${SSH_DEPLOYMENT_HOST}\" with User: \"${SSH_DEPLOYMENT_USER}\"."
echo "Deployment is for \"${DEPLOYMENT_ENVIRONMENT}\". Use Branch: \"${BRANCH_TO_DEPLOY}\"."
SSHPASS=${SSH_DEPLOYMENT_PASS} sshpass -e ssh -oStrictHostKeyChecking=no -tt "${SSH_DEPLOYMENT_USER}"@"${SSH_DEPLOYMENT_HOST}" << ENDSSH
cd "${SSH_DEPLOYMENT_LOCATION}"

git reset --hard
git checkout "${BRANCH_TO_DEPLOY}"
git reset --hard origin/"${BRANCH_TO_DEPLOY}"
git pull

deployment-utils/service-stack/compose-${DEPLOYMENT_ENVIRONMENT}.sh up -d --build

exit # logout from ssh-shell
ENDSSH
