@param java.util.List<dev.mccue.pokemon.Pokemon> pokemon

<html>
    <head>
        <link rel="stylesheet" href="/tailwind.css">
        <script src="https://unpkg.com/htmx.org@1.8.3"></script>
    </head>
    <body>
        <div>
            <div>
                <label for="email" class="block text-sm font-medium text-gray-700">Name</label>
                <div class="mt-1">
                    <input hx-get="/list"
                           hx-target="#pokemon-list"
                           hx-swap="innerHTML"
                           hx-trigger="keyup changed delay:250ms"
                           type="text"
                           name="pokemon-name"
                           id="pokemon-name"
                           class="block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm">
                </div>
            </div>
        </div>

        <div id="pokemon-list">
            @template.pokemonlist(pokemon = pokemon)
        </div>
    </body>
</html>

