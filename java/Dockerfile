FROM openjdk:15

WORKDIR /app

ADD ./wait /wait

RUN chmod +x /wait&&\
    apt-get update&&\
    cp  /usr/share/zoneinfo/Asia/Tokyo /etc/localtime

EXPOSE 80
EXPOSE 443

CMD ["java","Main"]