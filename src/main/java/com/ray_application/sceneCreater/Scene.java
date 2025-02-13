
package com.ray_application.sceneCreater; 

import java.util.ArrayList;
import java.util.List;

class Camera {
    int horizontal_pixels;
    int vertical_pixels;
    double field_of_view;
    ViewTransform view_transform;

    public Camera(int h, int v, double fov, ViewTransform vt) {
        this.horizontal_pixels = h;
        this.vertical_pixels = v;
        this.field_of_view = fov;
        this.view_transform = vt;
    }
}

class ViewTransform {
    List<Double> from;
    List<Double> to;
    List<Double> up;

    public ViewTransform(List<Double> from, List<Double> to, List<Double> up) {
        this.from = from;
        this.to = to;
        this.up = up;
    }
}

class Transformation {
    String type;
    Double x, y, z;
    Double radians;
    Double x_y, x_z, y_x, y_z, z_x, z_y;

    public Transformation(String type, Double x, Double y, Double z) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Transformation(String type, Double radians) {
        this.type = type;
        this.radians = radians;
    }

    public Transformation(String type, Double x_y, Double x_z, Double y_x, Double y_z, double z_x, double z_y) {
        // For shearing transformation 
        this.type = type;
        this.x_y = x_y; 
        this.x_z = x_z; 
        this.y_x = y_x; 
        this.y_z = y_z;
        this.z_x = z_x; 
        this.z_y = z_y; 
    }
}

class Material {
    Double ambient;
    Double diffuse;
    Double specular;
    Double transparency;
    List<Double> color;
    Double refractive_index;
    Pattern pattern;

    public Material(Double ambient, Double diffuse, Double specular, Double transparency, 
                    List<Double> color, Double refractive_index, Pattern pattern) {
        this.ambient = ambient;
        this.diffuse = diffuse;
        this.specular = specular;
        this.transparency = transparency;
        this.color = color;
        this.refractive_index = refractive_index;
        this.pattern = pattern;
    }
}

class Pattern {
    String type;
    List<Double> first_color;
    List<Double> second_color;
    ArrayList<Transformation> transformations;

    public Pattern(String type, List<Double> first_color, List<Double> second_color, List<Transformation> transformations) {
        this.type = type;
        this.first_color = first_color;
        this.second_color = second_color;
    }

    public void addTransformation(Transformation trans) {
        this.transformations.add(trans);
    }
}

class SceneObject {
    String type;
    ArrayList<Transformation> transformations;
    Material material;

    public SceneObject(String type, Material material) {
        this.type = type;
        this.material = material;
    }

    public void addTransformation(Transformation trans) { 
        this.transformations.add(trans);
    }
}

class Light {
    String type;
    List<Double> position;
    List<Double> intensity;

    public Light(String type, List<Double> position, List<Double> intensity) {
        this.type = type;
        this.position = position;
        this.intensity = intensity;
    }
}

class World {
    ArrayList<SceneObject> objects;
    ArrayList<Light> lights;
    int reflection_limit;

    public World(int reflection_limit) {
        this.reflection_limit = reflection_limit;
    }

    public void addObject(SceneObject object) { 
        this.objects.add(object);
    }

    public void addLight(Light light) { 
        this.lights.add(light);
    }
}

public class Scene {
    Camera camera;
    World world;

    public Scene(Camera camera, World world) {
        this.camera = camera;
        this.world = world;
    }
}

