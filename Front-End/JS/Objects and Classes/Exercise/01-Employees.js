function employees(employeesList) {

    for (let i = 0; i < employeesList.length; i++) {
        let currentEmployee = employeesList[i];
        console.log(`Name: ${currentEmployee} -- Personal Number: ${currentEmployee.length}`)
    }

}