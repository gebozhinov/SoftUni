function flightSchedule(input) {

    let flights = [];

    for (let i = 0; i < input[0].length; i++) {

        let flightNumber = input[0][i].match(/[^\s]+/gm)[0];
        let destination = input[0][i].match(/\w+\s(.*)/)[1];

        let flight = {
            flightNumber,
            destination,
            status: "",
        }
        flights.push(flight);
    }

    for (let i = 0; i < input[1].length; i++) {
        let currentFlightNumber = input[1][i].match(/[^\s]+/gm)[0];
        let status = input[1][i].match(/\w+\s(.*)/)[1];

        flights.forEach(flight => {
            if (flight["flightNumber"].includes(currentFlightNumber)) {
                flight["status"] = status;
            }
        })

    }

    let flightStatus = input[2][0];

    if (flightStatus === "Ready to fly") {
        flights.forEach(flight => {
            if (flight.status === "") {
                flight["status"] = "Ready to fly";
                let flightInfoToPrint = {
                    Destination: flight.destination,
                    Status: flight.status,
                }
                console.log(flightInfoToPrint)
            }
        })
    } else {
        flights.forEach(flight => {
            if (flight.status === flightStatus) {
                let flightInfoToPrint = {
                    Destination: flight.destination,
                    Status: flight.status,
                }
                console.log(flightInfoToPrint)
            }
        })
    }
}