Fuse Features API
=================

*A public, harvester.js-based API for feature management*

What
----

This API provides basic CRUD and advanced query functionality for Fuse Feature (for activations, renewals, upgrades of fuse services).

Its purpose is to serve as a logical entry point (a gateway) for a deeper, on-premise middleware system, in charge of integrating diverse regional and vendor back-ends.

How
---

There are multiple ways to running this API:

* *full docker:* this repo provides a docker-compose.yml file, allowing the spinning of the API and all its dependencies. So running a `docker-compose up` (consider using the `-d` for running in daemon mode) will do the trick;
* *dockerized infra:* use the docker-compose-local.yml file to have docker compose bring up all the infrastructure you need (only mongo at this first moment) while keeping the node API local to your host environment. Useful for debugging;
* *full local:* on this scenarios, you are on your own, kiddo. You will need to install the full stack (node and mongo). Please do consider using nvm for your node installation, though.

And the not so fancy part: in order to play with SSE, you will need replicasets configured in your mongo instance. The `replSet.sh` script will finish the configuration of the dockerized mongo database.
