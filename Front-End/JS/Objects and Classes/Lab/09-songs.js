function printSongs(arr) {

    class Song {
        constructor(type, name, time) {
            this.type = type;
            this.name = name;
            this.time = time;
        }
    }

    let songs = [];

    for (let i = 1; i < arr.length - 1; i++) {
        let type = arr[i].split("_")[0];
        let name = arr[i].split("_")[1];
        let time = arr[i].split("_")[2];

        songs.push(new Song(type, name, time));
    }

    let typeList = arr[arr.length - 1];

    songs.forEach((song) => {
        if (typeList === "all") {
            console.log(song.name);
        } else if (song.type === typeList) {
            console.log(song.name);
        }
    })

}