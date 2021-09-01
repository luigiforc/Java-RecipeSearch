/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luigi
 */
import java.util.ArrayList;
public class Recipe {
    private String name;
    private int cookingTime;
    private ArrayList<String> ingredients;

    
    

    public Recipe(String name, int cookingTime,ArrayList<String>ingredients) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
    }
    
    public void addIngredient(String ingredient){
        if(ingredient.isEmpty()){
            return;
        }
        this.ingredients.add(ingredient);
    }

    public String getName() {
        return name;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }
    
    public boolean ingredientIsFound(String searched){
        for(String ingredient:ingredients){
            if(ingredient.equals(searched)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.name+", cooking time: "+this.cookingTime; //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
    
}
