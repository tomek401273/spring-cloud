FROM ubuntu:18.04
RUN apt update
RUN apt install -y apache2 apache2-utils
RUN apt install -y nginx
COPY ./default /etc/nginx/sites-available/default
COPY ./.htpasswd /etc/nginx/.htpasswd

CMD ["nginx", "-g", "daemon off;"]
