function carWash(commands) {

    let cleanPercent = 0;

    for (const command of commands) {
        switch (command) {
            case "soap":
                cleanPercent += 10;
                break;
            case "water":
                cleanPercent *= 1.2;
                break;
            case "vacuum cleaner":
                cleanPercent *= 1.25;
                break;
            case "mud":
                cleanPercent *= 0.9;
                break;
        }
    }

    console.log( `The car is ${cleanPercent.toFixed(2)}% clean.`)
}