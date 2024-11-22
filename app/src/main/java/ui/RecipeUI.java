package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        // 一覧表示機能
                        displayRecipes(); //メソッド呼び出す構文
                        break;
                    case "2":
                        // 新規登録機能
                        addNewRecipe(); //メソッドを呼び出す構文
                        break;
                    case "3":
                        // 検索機能
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /**
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     */
    private void displayRecipes() {
        try { //レシピデータを取得する際に例外が発生した場合はエラーメッセージを表示する仕様にしたいのでtry
            ArrayList<String> recipes = fileHandler.readRecipes();//レシピデータをリストとして読み込む
            if (recipes.isEmpty()) { //レシピが空の場合
                System.out.println("No recipes available."); //if文でリストが空かどうかを確認する
            } else { //条件判定（レシピが空ではない場合）
                System.out.println("Recipes:");
                System.out.println("---------------------------------");
                for (String recipe : recipes) { //リスト内の各レシピをループ処理
                    String[] parts = recipe.split(","); //レシピをカンマで分割する
                    if (parts.length < 2) { // データが不完全な場合の処理
                        System.out.println("Invalid recipe format: " + recipe);
                        continue; //エラーメッセージを出力し、処理をスキップする
                    }
                    System.out.println("Recipe Name: " + parts[0]); //レシピ名を出力する
                    System.out.println("Main Ingredients: " + String.join(", ", Arrays.copyOfRange(parts, 1, parts.length))); //材料を出力する
                    System.out.println("---------------------------------"); //区切線を出力する
                }
            }
        } catch (Exception e) { // 予期しないエラー（例外）をキャッチ（処理）
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException { //新しいレシピを追加するメソッド
        System.out.print("Enter recipe name: "); //レシピ名の入力
        String recipeName = reader.readLine(); // レシピ名を受け取る

        System.out.print("Enter main ingredients (comma separated): "); //材料の入力
        String ingredients = reader.readLine(); // 材料を受け取る

        fileHandler.addRecipe(recipeName, ingredients); // ファイルにレシピを追加する
        System.out.println("Recipe added successfully."); // 成功メッセージ
    }

    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void searchRecipe() throws IOException {

    }

}