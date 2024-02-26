function resourceRequiredToBuildAPyramid(base, increment) {

    let pyramidHigh = 0;
    let stone = 0;
    let marble = 0;
    let lapis = 0;
    let gold = 0;
    while (true) {
        pyramidHigh++;

        if (base - 2 <= 0) {
            gold = base * base * increment;
            break;
        }

        base -= 2;
        stone += base * base * increment;
        if (pyramidHigh % 5 == 0) {
            lapis += ((base + 2) * (base + 2) * increment) - ((base * base) * increment);
        } else {
            marble += ((base + 2) * (base + 2) * increment) - ((base * base) * increment);
        }

    }

    console.log(`Stone required: ${Math.ceil(stone)}`);
    console.log(`Marble required: ${Math.ceil(marble)}`);
    console.log(`Lapis Lazuli required: ${Math.ceil(lapis)}`);
    console.log(`Gold required: ${Math.ceil(gold)}`);
    console.log(`Final pyramid height: ${Math.floor(pyramidHigh * increment)}`);
}