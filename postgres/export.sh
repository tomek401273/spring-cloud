#!/usr/bin/env bash
 pg_dump \
  -h localhost \
  -p 5431 \
  -U docker \
  -d docker \
  -n public \
  > biblio.sql
