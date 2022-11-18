# Dockerfile Best Practices

- Avoid unnecessary privileges
    - Rootless containers
    - Don’t bind to a specific UID
    - Make executables owned by root and not writable
- Reduce attack surface
    - Multistage builds
    - Distroless, from scratch
    - Use trusted base images
    - Update your images frequently
    - Exposed ports
- Prevent confidential data leaks
    - Credentials and confidentiality
    - ADD, COPY
    - Build context and dockerignore
- Others
    - Layer sanity
    - Metadata labels
    - Linting
    - Locally scan images during development
- Beyond image building
    - Docker port socket and TCP protection
    - Sign images and verify signatures
    - Tag mutability
    - Run as non-root
    - Include health / liveness checks
    - Drop capabilities

[Referenced from](https://sysdig.com/blog/dockerfile-best-practices/)
