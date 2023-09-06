FROM postgres:11.8

COPY create-multiple-postgresql-databases.sh / docker-entrypoint-init.d/
COPY init.sql / docker-entrypoint-init.d/
CMD ["docker-entrypoint.sh", "postgres"]