package com.liubz.androidtea.cherish.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class SerializationTest {

    public static void main(String[] args) {
        Bed bed = new Bed();
        bed.size = 1;
        bed.brand = "big";
        bed.color = "red";
        Room<Bed> room = new Room<>();
        room.setT(bed);

        Type roomType = new TypeToken<Room<Bed>>() {}.getType();
        String json = new Gson().toJson(room, roomType);
        System.out.println(json);

        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().excludeFieldsWithModifiers(Modifier.STATIC).create();
        String jsonOutput = gson.toJson(room, roomType);
        System.out.println(jsonOutput);
    }
}
