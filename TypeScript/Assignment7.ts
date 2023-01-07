class Student {
    rollno: number;
    name: string;
    totalmarks: number;
    classname: string;
    
    constructor(rollno: number, name: string,totalmarks: number,classname: string) {
            this.rollno = rollno;
            this.name = name;
            this.totalmarks = totalmarks;
            this.classname = classname;
    }

}

let sortStudDtls=(allStud: Array<Student>) => {
       for(let i=0;i<allStud.length; i++){
        for(let j=i+1;j<allStud.length; j++){
            if(allStud[i].totalmarks > allStud[j].totalmarks){
                let temp:Student = allStud[i];
                allStud[i] = allStud[j];
                allStud[j] = temp;
            }
        }
       }
       for(let i=0;i<allStud.length; i++){
        console.log("student "+i+" : ");
        console.log("Student roll number : "+allStud[i].rollno);
        console.log("Student Name : "+allStud[i].name);
        console.log("Student Marks : "+allStud[i].totalmarks);
        console.log("Student classname : "+allStud[i].classname);
        console.log("\n");

       }
}

let stud1 = new Student(101,'abhay',86,'5th');
let stud2 = new Student(102,'amol',69,'6th');
let stud3 = new Student(103,'abhilash',56,'5th');
let stud4 = new Student(104,'abhijit',90,'7th');
let stud5 = new Student(105,'abhinav',96,'8th');
let studArr:Array<Student> ;
studArr=[stud1,stud2,stud3,stud4,stud5];

sortStudDtls(studArr);