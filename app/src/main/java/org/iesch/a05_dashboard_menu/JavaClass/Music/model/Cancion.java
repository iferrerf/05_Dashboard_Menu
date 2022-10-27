package org.iesch.a05_dashboard_menu.JavaClass.Music.model;

public class Cancion {

    private int id;
    private String name;
    private String autor;
    private String date;
    private Type type;
    private int soundId;
    private int imageId;

    public enum Type {
        POP, ELECTRONIC, ROCK, FLAMENCO, JAZZ
    }

    public Cancion(int id, String name, String autor, String date, Type type, int soundId, int imageId) {
        this.id = id;
        this.name = name;
        this.autor = autor;
        this.date = date;
        this.type = type;
        this.soundId = soundId;
        this.imageId = imageId;


    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAutor() {
        return autor;
    }

    public String getDate() {
        return date;
    }

    public Type getType() {
        return type;
    }

    public int getSoundId() {
        return soundId;
    }

    public int getImageId() {
        return imageId;
    }


}
