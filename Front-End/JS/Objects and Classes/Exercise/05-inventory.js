function heroRegister(arr) {

    let heroes = [];

    for (const row of arr) {
        let [name, level, items] = row.split(" / ");

        let hero = {
            name,
            level: Number(level),
            items,
        }

        heroes.push(hero);
    }

    heroes.sort((a, b) => a.level - b.level);
    heroes.forEach(hero => {
        console.log(`Hero: ${hero.name}`);
        console.log(`level => ${hero.level}`);
        console.log(`items => ${hero.items}`)
    });

}