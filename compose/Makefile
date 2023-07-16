.PHONY: help traefik portainer ldap prometheus destroy
.DEFAULT_GOAL := help

COMPOSE_CLI := docker compose
COMPOSE_DIR := $(shell pwd)

# define a function to start a stack
define start_stack
    @$(COMPOSE_CLI) -f $(COMPOSE_DIR)/$(1)/compose.yml -p $(1) up -d --force-recreate
endef

# define a function to stop a stack
define stop_stack
    @if [ $$(docker compose -f $(COMPOSE_DIR)/$(1)/compose.yml ps -q | wc -l) -gt 0 ]; then \
        $(COMPOSE_CLI) -f $(COMPOSE_DIR)/$(1)/compose.yml down; \
    fi
endef

# Start traefik
traefik:
    $(call start_stack,traefik)

# Start portainer
portainer:
	$(call start_stack,portainer)

# Start ldap
ldap:
    $(call start_stack,ldap)

# Start Prometheus
prometheus:
	$(call start_stack,prometheus)

# Start all stacks
start: traefik portainer ldap prometheus

# Stop all stacks
stop:
	$(call stop_stack,prometheus)
	$(call stop_stack,ldap)
	$(call stop_stack,portainer)
	@docker compose -f traefik/self-signed/compose.yml down

# Show help
help:
	@echo ""
	@echo "Usage:"
	@echo "    make [target]"
	@echo ""
	@echo "Targets:"
	@awk '/^[a-zA-Z\-_0-9]+:/ \
	{ \
		helpMessage = match(lastLine, /^# (.*)/); \
		if (helpMessage) { \
			helpCommand = substr($$1, 0, index($$1, ":")-1); \
			helpMessage = substr(lastLine, RSTART + 2, RLENGTH); \
			printf "\033[36m%-22s\033[0m %s\n", helpCommand,helpMessage; \
		} \
	} { lastLine = $$0 }' $(MAKEFILE_LIST)
