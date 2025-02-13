
package com.ray_application; 
import com.ray_application.ui.MainUI; 
import com.ray_application.sceneCreater.JsonWriter; 
import com.ray_application.sceneCreater.Scene; 

public class Main
{
    public static void main(String[] args)
    {

        try { 
            Scene scene = JsonWriter.getExampleScene(); 
            JsonWriter.write(scene, "resources/scene.json");
            MainUI.main();
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }
}
