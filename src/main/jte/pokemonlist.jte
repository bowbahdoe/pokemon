@param java.util.List<dev.mccue.pokemon.Pokemon> pokemon

<ul role="list" class="grid grid-cols-1 gap-6 sm:grid-cols-2 lg:grid-cols-3">
    @for(var p : pokemon)
        <li class="col-span-1 divide-y divide-gray-200 rounded-lg bg-white shadow">
            <div class="flex w-full items-center justify-between space-x-6 p-6">
                <div class="flex-1 truncate">
                    <div class="flex items-center space-x-3">
                        <h3 class="truncate text-sm font-medium text-gray-900">${p.name()}</h3>
                        <span class="inline-block flex-shrink-0 rounded-full bg-green-100 px-2 py-0.5 text-xs font-medium text-green-800">${p.number()}</span>
                    </div>
                    <p class="mt-1 truncate text-sm text-gray-500">
                        @if(p.type().size() == 1)
                            ${p.type().get(0)} type
                        @else
                            ${p.type().get(0) + " and " + p.type().get(1)} type
                        @endif
                    </p>
                </div>
                <img class="h-10 w-10 flex-shrink-0 rounded-full bg-gray-300" src="${p.image()}" alt="">
            </div>
        </li>
    @endfor
</ul>