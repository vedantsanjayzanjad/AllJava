var Student = /** @class */ (function () {
    function Student(rollno, name, totalmarks, classname) {
        this.rollno = rollno;
        this.name = name;
        this.totalmarks = totalmarks;
        this.classname = classname;
    }
    return Student;
}());
var sortStudDtls = function (allStud) {
    for (var i = 0; i < allStud.length; i++) {
        for (var j = i + 1; j < allStud.length; j++) {
            if (allStud[i].totalmarks > allStud[j].totalmarks) {
                var temp = allStud[i];
                allStud[i] = allStud[j];
                allStud[j] = temp;
            }
        }
    }
    for (var i = 0; i < allStud.length; i++) {
        console.log("student " + i + " : ");
        console.log("Student roll number : " + allStud[i].rollno);
        console.log("Student Name : " + allStud[i].name);
        console.log("Student Marks : " + allStud[i].totalmarks);
        console.log("Student classname : " + allStud[i].classname);
        console.log("\n");
    }
};
var stud1 = new Student(101, 'abhay', 86, '5th');
var stud2 = new Student(102, 'amol', 69, '6th');
var stud3 = new Student(103, 'abhilash', 56, '5th');
var stud4 = new Student(104, 'abhijit', 90, '7th');
var stud5 = new Student(105, 'abhinav', 96, '8th');
var studArr;
studArr = [stud1, stud2, stud3, stud4, stud5];
sortStudDtls(studArr);
