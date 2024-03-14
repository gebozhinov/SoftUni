function schoolRegister(input) {

    let studentsRegister = {};
     
    for (const studentInfo of input) {
        let [studentName, grade, averageScore] = studentInfo.split(", ");
        studentName = studentName.split("Student name: ")[1];
        grade = Number(grade.split("Grade: ")[1]) + 1;
        averageScore = Number(averageScore.split("Graduated with an average score: ")[1]).toFixed(2);

        

        if (averageScore >= 3) {
            if (!studentsRegister[grade]) {
                studentsRegister[grade] = {students: [], score: 0};
            }
            studentsRegister[grade].students.push(studentName);
            studentsRegister[grade].score += Number(averageScore);
        };
 
    }

    

    let sortedStudentRegister = Object.keys(studentsRegister).sort((a, b) => a - b);

    sortedStudentRegister.forEach(grade => {
        let {students, score} = studentsRegister[grade];
        let averageScore = (score / students.length).toFixed(2);


        console.log(`${grade} Grade`);
        console.log(`List of students: ${students.join(", ")}`);
        console.log(`Average annual score from last year: ${averageScore}`);
        console.log()
    })

}