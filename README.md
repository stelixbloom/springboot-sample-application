# springboot-sample-application

## アプリ起動手順

### spring-boot 起動
```
/spring-boot-sample-application/src/main/java/com/example/springbootsample/SpringBootSampleApplication
```

### Vue.js 起動
```
npm run build
npm run serve
```

### DB 起動・接続
```
docker-compose up -d --build
```
http://localhost:18080/browser/  
上記に接続。  
メールアドレス：admin@example.com  
パスワード：admin  
Serverを右クリックし、以下を設定。  
General：postgres  
接続：  
ホスト名/アドレス：postgres  
ユーザ名：stelixbloom  
パスワード：stelixbloom  

### URL 接続
・画面(Vue.js)  
http://localhost:8082/menu  
・spring-boot  
http://localhost:8081
