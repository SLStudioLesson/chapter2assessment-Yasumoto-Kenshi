package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br> 
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes() { //メソッドの宣言
    ArrayList<String> recipes = new ArrayList<>(); //レシピデータを格納するリストを作成する
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line; //ファイルを1行ずつ読む準備
        while ((line = reader.readLine()) != null) { // ファイルを1行ずつ読み込む
            recipes.add(line); // 読み込んだ行をリストに追加
        }
    } catch (IOException e) { //例外が発生した場合の処理
        System.out.println("Error reading file: " + e.getMessage()); // エラーメッセージを表示する
    }
    return recipes; // 読み込んだレシピデータを返す
}

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName レシピ名
     * @param ingredients 材料名
     */
     //
    public void addRecipe(String recipeName, String ingredients) { //メソッドの宣言
        String newRecipe = recipeName + "," + ingredients; // レシピをカンマ区切り形式で作成
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(newRecipe); //レシピデータを書き込む
            writer.newLine(); // 改行を追加する
        } catch (IOException e) { //例外が発生した場合の処理
            System.out.println("Error writing to file: " + e.getMessage()); //エラーメッセージを表示する
        }
    }
}