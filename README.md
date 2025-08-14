# Java Pattern Search Demo

このプロジェクトは、文字列パターンマッチング（文字探索）アルゴリズムを学習するためのサンプルコードです。
配列に格納された文字列から特定のパターン（部分文字列）を検索し、見つかった位置と比較回数を表示します。

## 概要

- 対象文字列: "HIPOPOTAMUS"

- 探索パターン: "AMU"

### 実装アルゴリズム

- 総当たり法（Brute-Force）

- Boyer-Moore 法（悪い文字ルールのみ実装）

## 動作環境

- Java 17 以降（OpenJDK など）

- VS Code + Java Extension Pack

- Git Bash（Windows ターミナルでも可）

## セットアップ

1. Java インストール

Adoptium などから JDK をダウンロード・インストールし、

```bash
java -version
javac -version
```

でバージョンが表示されれば OK。

2. リポジトリ取得

```bash
git clone https://github.com/sadao1202/SerchChar.git
cd java-pattern-search
```

3. ビルド＆実行

- VS Code を使う場合

VS Code でフォルダを開く

F5 または右上の ▶ Run ボタン
※文字化け対策済み（.vscode/launch.json 参照）

- コマンドラインで実行

```bash
javac -encoding UTF-8 App.java
java -Dfile.encoding=UTF-8 App
```

- 実行結果例

H と A の比較をする

```bash
...
8 番目の位置で合致しました。
比較回数は 20 です。
8 番目の位置で合致しました。
```

プロジェクト構成

```txt
.
├── src
│ └── App.java # メインソース
├── .vscode
│ └── launch.json # VS Code 実行設定（UTF-8 対応）
└── README.md # このファイル
```
