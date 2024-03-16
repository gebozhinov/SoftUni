function browserHistory(browser, arr) {


    for (const command of arr) {
        if (command.includes("Open")) {

            let site = command.split("Open ")[1];
            browser["Open Tabs"].push(site);
            browser["Browser Logs"].push(command);

        } else if (command.includes("Close")) {

            let site = command.split("Close ")[1];
            let index = browser["Open Tabs"].indexOf(site);
            if (index !== -1) {
                browser["Open Tabs"].splice(index, 1);
                browser["Recently Closed"].push(site);
                browser["Browser Logs"].push(command);
            }

        } else {
            browser["Open Tabs"] = [];
            browser["Recently Closed"] = [];
            browser["Browser Logs"] = [];
        }
    }

    console.log(browser["Browser Name"]);
    console.log(`Open Tabs: ${browser["Open Tabs"].join(", ")}`);
    console.log(`Recently Closed: ${browser["Recently Closed"].join(", ")}`);
    console.log(`Browser Logs: ${browser["Browser Logs"].join(", ")}`);

}