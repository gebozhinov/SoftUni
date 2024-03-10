function movieObjInfo(arr) {

    let movies = [];

    arr.forEach(element => {
        
        if (element.includes("addMovie")) {
            let movieName = element.split("addMovie ")[1];
            
            let movie = {
                name: movieName,
            }

            movies.push(movie);
        } else if (element.includes("directedBy")) {
            let movieName = element.split(" directedBy ")[0];
            let director = element.split(" directedBy ")[1];
            
            movies.forEach(movie => {
                if (Object.values(movie).includes(movieName)) {
                    movie["director"] = director;
                }
            })
        } else if (element.includes("onDate")) {
            let movieName = element.split(" onDate ")[0];
            let date = element.split(" onDate ")[1];

            movies.forEach(movie => {
                if (Object.values(movie).includes(movieName)) {
                    movie["date"] = date;
                }
            })
        }
    });

    movies.forEach(movie => {
        if (movie.hasOwnProperty("name") && 
            movie.hasOwnProperty("director") && 
            movie.hasOwnProperty("date")) {

                console.log(JSON.stringify(movie));

            }
    })
}