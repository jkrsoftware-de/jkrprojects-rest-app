# 💬 Informations about the Service-Configurations.

> **Don't be scared**:<br />
> I don't store sensitive Informations in the Configuration-Files.<br />
> There are just Templates, I adjust on my Deployment-Server-Side. 😊<br />
 
## 📃 How it works?
The Configuration-Files will be sourced by the `compose.sh` and `compose-dev.sh`-Scripts.

In Common-Case, these Bash-Scripts will be executed by the Deployment-Jobs via GitLab-CI, when committing on the `production` or the
`development`-Branches.

Of course, they can also be executed manually.