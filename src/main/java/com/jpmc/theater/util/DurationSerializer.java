package com.jpmc.theater.util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class DurationSerializer implements JsonSerializer<Duration> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss");

    @Override
    public JsonElement serialize(Duration duration, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(duration.toMillis());
    }
}