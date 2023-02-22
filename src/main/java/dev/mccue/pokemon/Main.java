package dev.mccue.pokemon;

import dev.mccue.json.Json;
import dev.mccue.json.JsonDecoder;
import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.rendering.template.JavalinJte;
import org.apache.commons.text.similarity.LevenshteinDistance;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class Main {
    static void listPokemon(List<Pokemon> pokemon, Context ctx) {
        var pokemonName = ctx.queryParam("pokemon-name");

        List<Pokemon> toRender;
        if (pokemonName == null || pokemonName.isBlank()) {
            toRender = pokemon;
        }
        else {
            toRender = pokemon
                    .stream()
                    .filter(p -> p.name().toLowerCase(Locale.US).startsWith(pokemonName.toLowerCase(Locale.US)))
                    .toList();
        }
        ctx.render("pokemonlist.jte", Map.of("pokemon", toRender));
    }
    public static void main(String[] args) throws IOException {
        List<Pokemon> pokemon;
        try (var stream = Objects.requireNonNull(Main.class.getResourceAsStream("/pokemon.json"))) {
            var pokemonString = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
            var pokemonJson = Json.readString(pokemonString);

            pokemon = JsonDecoder.array(pokemonJson, Pokemon::fromJson);
            System.out.println(pokemon);
        }

        JavalinJte.init();
        Javalin app = Javalin.create().start(7000);

        app.get("/", ctx -> ctx.render("pokemon.jte", Map.of("pokemon", pokemon)));
        app.get("/list", ctx -> Main.listPokemon(pokemon, ctx));
        app.get("/tailwind.css", ctx -> ctx.result(
                Objects.requireNonNull(Main.class.getResourceAsStream("/tailwind.css"))
                        .readAllBytes())
        );
    }
}