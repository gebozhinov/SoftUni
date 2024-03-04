function crystals(arr) {
    let targetThickness = arr[0];
    for (let i = 1; i < arr.length; i++) {
        let chunkThickness = arr[i];
        console.log(`Processing chunk ${chunkThickness} microns`)


        let cutCount = 0;
        let lapCount = 0;
        let grindCount = 0;
        let etchCount = 0;
        while (targetThickness != chunkThickness) {

            
            while (chunkThickness / 4 >= targetThickness) {
                chunkThickness /= 4;
                cutCount++;
            }
            
            if (cutCount > 0) {
                console.log(`Cut x${cutCount}`);
                console.log("Transporting and washing");
                chunkThickness = Math.floor(chunkThickness);
            }

            while (chunkThickness * 0.8 >= targetThickness) {
                chunkThickness *= 0.8;
                lapCount++;
            }

            if (lapCount > 0) {
                console.log(`Lap x${lapCount}`);
                console.log("Transporting and washing");
                chunkThickness = Math.floor(chunkThickness);
            }

            while (chunkThickness - 20 >= targetThickness) {
                chunkThickness -= 20;
                grindCount++;
            }

            if (grindCount > 0) {
                console.log(`Grind x${grindCount}`);
                console.log("Transporting and washing");
                chunkThickness = Math.floor(chunkThickness);
            }
            
            while (chunkThickness - 2 >= targetThickness) {
                chunkThickness -= 2;
                etchCount++;
            }

            if (etchCount > 0) {
                console.log(`Etch x${etchCount}`);
                console.log("Transporting and washing");
                chunkThickness = Math.floor(chunkThickness);
            }

            if (chunkThickness != targetThickness) {
                chunkThickness++;
                console.log("X-ray x1")
            }
        }

        
        console.log(`Finished crystal ${targetThickness} microns`)
    }
}