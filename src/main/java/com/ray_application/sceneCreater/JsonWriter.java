
package com.ray_application.sceneCreater; 

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.Arrays; 
import java.util.ArrayList; 

public class JsonWriter {

    public void write(Scene scene, String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(scene);
        try (FileWriter writer = new FileWriter(filePath)) { 
            writer.write(json);
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
    }

    public static Scene getExampleScene() { 
        // Camera
        ViewTransform viewTransform = new ViewTransform(
                Arrays.asList(1.0, 3.0, -5.0),
                Arrays.asList(-1.0, 1.0, 0.0),
                Arrays.asList(0.0, 1.0, 0.0)
        );
        Camera camera = new Camera(1500, 1000, 1.0471975511965976, viewTransform);

        // Objects
        SceneObject sphere = new SceneObject(
                "Sphere",
                Arrays.asList(new Transformation("translation", -0.5, 1.0, 3.0)),
                new Material(0.3, 0.8, 0.4, 1.0, Arrays.asList(1.0, 0.0, 1.0), 2.0, null)
        );

        SceneObject plane1 = new SceneObject(
                "Plane",
                new ArrayList<>(),
                new Material(0.2, 0.8, null, null, null, null,
                        new Pattern("Checkers", Arrays.asList(1.0, 1.0, 1.0), Arrays.asList(0.0, 0.0, 0.0), null))
        );

        SceneObject plane2 = new SceneObject(
                "Plane",
                Arrays.asList(
                        new Transformation("translation", 0.0, 0.0, 10.0),
                        new Transformation("rotation_x", 1.578)
                ),
                new Material(0.2, 0.8, null, null, null, null,
                        new Pattern("Checkers", Arrays.asList(1.0, 1.0, 1.0), Arrays.asList(0.0, 0.0, 0.0), null))
        );

        SceneObject cube = new SceneObject(
                "Cube",
                Arrays.asList(
                        new Transformation("translation", -1.5, 0.33, -0.5),
                        new Transformation("scaling", 0.33, 0.33, 0.33)
                ),
                new Material(0.3, 0.7, 0.3, null, null, null,
                        new Pattern("Gradient", Arrays.asList(1.0, 0.0, 0.0), Arrays.asList(0.0, 0.0, 1.0),
                                Arrays.asList(new Transformation("scaling", 2.0, 2.0, 2.0))))
        );

        // Light
        Light light = new Light("Light", Arrays.asList(-10.0, 10.0, -10.0), Arrays.asList(1.0, 1.0, 1.0));

        // World
        World world = new World(Arrays.asList(sphere, plane1, plane2, cube), Arrays.asList(light), 10);

        // Scene
        Scene scene = new Scene(camera, world);
        return scene; 
    }
}

