package com.crud.crud.services.utils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

//Clase que permite deserializar una fecha con diferente formarto y convertirla en el formato deseado
public class CustomLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    
    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String dateTimeString = p.getText();
        //Si la fecha viene vacia retrona null
        if (dateTimeString == null || dateTimeString.isEmpty()) {
            return null; // Devuelve null si la cadena es vacía o nula
        }
        //Si no esta vacia asigna el formato año, mes, dia, hora, segundos
        return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
