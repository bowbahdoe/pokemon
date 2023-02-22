package dev.mccue.pokemon;

import dev.mccue.json.Json;
import dev.mccue.json.JsonDecoder;

import java.util.List;

public record Pokemon(
        String name,
        String number,
        List<String> type,
        String image
) {
    static Pokemon fromJson(Json json) {
        var name = JsonDecoder.field(json, "name", JsonDecoder::string);
        var number = JsonDecoder.field(json, "num", JsonDecoder::string);
        var type = JsonDecoder.field(json, "type", JsonDecoder.array(JsonDecoder::string));
        var image = JsonDecoder.field(json, "img", JsonDecoder::string);

        return new Pokemon(
                name,
                number,
                type,
                image
        );
    }
}