# NaeverStore
### チーム名 : NAEVER 
### プロジェクト名 : NAEVER STORE
### プロジェクト紹介 : ユーザーがショップを作って商品を販売したり、他の商品を購入するサービス
### プロジェクトのきっかけ : チームメンバー全員が最も多く接したサイトを直接作ってみようと思いました
---
### 技術スタック
 * 言語: <img src="https://img.shields.io/badge/kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white">
 * フレームワーク: <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
 * ライブラリー.: <img src="https://img.shields.io/badge/SpringSecurity-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white">
 * データベース <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
 * 配布: <img src="https://img.shields.io/badge/Amazon Aws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white">
### ERD 
 ![image](https://github.com/NaeverStore/NaeverStore/assets/149165093/3796ff9d-515c-41c9-9d4b-b9c788091659)

---
### ワイヤフレーム 
![image](https://github.com/NaeverStore/NaeverStore/assets/149165093/464f6409-79af-472c-a9ed-e2187797a9b5)

---

### プロジェクト機能
 * ユーザー認証機能
 * プロフィール管理
 * 注文CRUD機能
 * レビューCRUD機能
 * バックオフィス機能(注文管理)
 * AWSを利用したサービスの配布
 * カート機能
 * 商店、商品機能
---

### 僕の担当パート
 * カート機能
 * 3回以内のパスワード使用禁止機能
 * AWSを利用した配布
#### AWSを利用した配布
 * プリティアでのメモリ不足のためビルドが遅く、ほとんど不可能だった。
##### ビルドファイルをEC2内に転送
 * CI/CDの煩わしさの増加
##### スワップメモリの活用
 * ディスクの一部をRAMのように使ってビルド成功
#### Enversの活用
 * 最初は3回以内に使用した暗証番号使用禁止のための暗証番号記録エンティティを使用していた。
 * ところが、パスワード記録エンティティの管理が困難で改善が必要だと感じた。
 * アップデートの内訳を自動的に記録するEnversを活用してこれを改善した。
![revision](https://github.com/tlsgkdns/NaeverStore/assets/24753709/fe62f020-873d-40b0-b58b-c7b4bfaf7d1e)
> RevisionRepositoryを相続して

![3회](https://github.com/tlsgkdns/NaeverStore/assets/24753709/0fe62144-f07f-4e8d-ba22-3a300d114d85)
> パスワード履歴を自動的に記録する 
