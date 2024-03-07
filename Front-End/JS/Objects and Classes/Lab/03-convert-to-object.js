function convertToObj(json) {

    const obj = JSON.parse(json);

    for (const [key, value] of Object.entries(obj)) {
        console.log(`${key}: ${value}`)
    }

}