package data;

import java.io.*;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;

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
     *@return レシピデータ
     */
    public ArrayList<String> readRecipes() {
        ArrayList<String> recipes = new ArrayList<>();
        
        // ファイルを読み込む処理
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // ファイルを1行ずつ読み込み
            while ((line = reader.readLine()) != null) {
                recipes.add(line);  // レシピをリストに追加
            }
        } catch (IOException e) {
            // エラーが発生した場合の処理
            System.out.println("Main Ingredients: " + String.join(", ", Arrays.copyOfRange(parts, 1, parts.length)).trim());

        }
        
        return recipes;  // レシピデータのリストを返す
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
    public void addRecipe(String recipeName, String ingredients) {
        // try {

        // } catch (IOException e) {

        // }
    }
}
