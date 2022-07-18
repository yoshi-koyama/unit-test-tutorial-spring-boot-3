# unit-test-tutorial
## 概要
このプロジェクトはアニメのデータの登録、検索、更新、削除をするレポジトリです。

## 前提

- Java 17
- Spring Boot 2.7.1
- Docker 20.10.13

## 起動手順
`$ git clone https://github.com/reytech-co-jp/unit-test-tutorial.git`

`$ cd unit-test-tutorial`

`$ docker-compose up -d`

`$ ./gradlew bootRun`

起動成功時のイメージ
![image](https://user-images.githubusercontent.com/97335620/179455637-4e0f537d-7ad8-444d-b2b8-d2dbd5b0d6d1.png)

## 使用方法
Postmanを使用した画面とcurlコマンドを記載

### 全件検索
![image](https://user-images.githubusercontent.com/97335620/179456104-c209c4bc-c5f9-4364-8882-59b72e045cd6.png)

```
curl 'http://localhost:8080/api/anime'
```
## 一件検索
![image](https://user-images.githubusercontent.com/97335620/179456451-710f3f26-2046-429f-a781-838aba8fc07c.png)


## 登録
![image](https://user-images.githubusercontent.com/97335620/179456660-19bc9071-4ba3-4351-9681-74aeb8450e43.png)

## 更新
![image](https://user-images.githubusercontent.com/97335620/179457166-6edd62d6-5d83-4ab0-a8d1-b0eb98e7976a.png)

## 削除
![image](https://user-images.githubusercontent.com/97335620/179457411-ef256421-df27-4c9e-bac2-3dd7a6a10951.png)

## バリデーションエラー
![image](https://user-images.githubusercontent.com/97335620/179457641-89280304-ce73-493d-a391-5e9c350b9d20.png)

## 更新及び削除で指定したIDのデータが存在しない時
![image](https://user-images.githubusercontent.com/97335620/179457706-be115bff-9ddd-488a-b88c-a888da14a986.png)

## 終了手順
（`./gradlew bootRun`コマンドで実行している場合）`ctrl + c`で終了する

`$ docker-compose down`
