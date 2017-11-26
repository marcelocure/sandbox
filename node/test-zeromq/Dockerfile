FROM node
COPY . /app
WORKDIR /app
RUN rm -rf node_modules && \ 
    apt-get update -qq && \
    apt-get install -y -qq libzmq-dev && \
    npm install --silent
EXPOSE 3000
CMD ["node", "/app/index.js"]