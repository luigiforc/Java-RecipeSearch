
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.Arrays;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Recipe> recipes=new ArrayList<>();        
        System.out.print("File to read: ");
        String file=scanner.nextLine();
        loadingFile(recipes,file);         
        System.out.println("Commands: ");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searched recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
        System.out.println(" ");
        while(true){
            System.out.print("Enter command: ");
            String command=scanner.nextLine();
            if(command.equals("list")){
                list(recipes);
            } else if(command.equals("stop")){
                break;
            } else if(command.equals("find name")){
                System.out.print("Searched word: ");
                String name=scanner.nextLine();
                System.out.println("Recipes:");
                findName(recipes,name);
            } else if(command.equals("find ingredient")){
                System.out.print("Ingredient: ");
                String name=scanner.nextLine();
                findIngredient(recipes,name);
            } else if(command.equals("find cooking time")){
                System.out.print("Max cooking time: ");
                int cookingTime=Integer.valueOf(scanner.nextLine());
                findCookingTime(recipes,cookingTime);    
            }    
        }                
    }
        
    public static void list(ArrayList<Recipe> recipes){
        for(Recipe recipe:recipes){
            System.out.println(recipe.getName()+", cooking time: "+recipe.getCookingTime());      
        }
    }
    
    public static void findName(ArrayList<Recipe> recipes, String searched){       
        for(Recipe recipe:recipes){
            if(recipe.getName().contains(searched)){
                System.out.println(recipe.getName()+", cooking time: "+recipe.getCookingTime()); 
            }
            
            
        }        
    }
    
    public static void findCookingTime(ArrayList<Recipe> recipes, int searched){
        for(Recipe recipe:recipes){
            if(recipe.getCookingTime()<=searched){
                System.out.println(recipe.getName()+", cooking time: "+recipe.getCookingTime());
            }
        }
    }
    
    public static void findIngredient(ArrayList<Recipe> recipes, String searched){
        for(Recipe recipe:recipes){
            if(recipe.ingredientIsFound(searched)){
                System.out.println(recipe.getName()+", cooking time: "+recipe.getCookingTime());
            }
        }
    }
    
    public static void loadingFile(ArrayList<Recipe> recipes,String fileName){
        try(Scanner fileScan=new Scanner(Paths.get(fileName))){
            while(fileScan.hasNextLine()){                
                String name=fileScan.nextLine(); 
                if(name.isEmpty()){
                    continue;
                }
                int time=Integer.valueOf(fileScan.nextLine());
                ArrayList<String> ingredients= new ArrayList<>();
                while(fileScan.hasNextLine()){
                    String ingredient=fileScan.nextLine();
                    if(ingredient.isEmpty()){
                        break;
                    }
                    ingredients.add(ingredient);                 
                }
                recipes.add(new Recipe(name, time, ingredients));                                                                                                                                                                                                                                                             
            }            
        } catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    
    

}
