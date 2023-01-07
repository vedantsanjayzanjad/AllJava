//DataTypes In JS

// console.log("Welcome To The Vs code");
// var a = null;
// var b = true;
// var c = "Harry";
// var d = 345;
// var e  = BigInt("556");
// var f = Symbol("This Is Vedant");
// var g = undefined;
// console.log(a);
// console.log(b)
// console.log(c)
// console.log(d)
// console.log(e)
// console.log(f)
// console.log(g)
// console.log(a,b,c,d);

//Object In JS

// const item =
// {
//     "Vedant" : true,
//     "Shubh" : false,
//     "Akshay" : 67

// }
// console.log(item["Vedant"])
// console.log(typeof b)

//Practice Set 1

//1
// let a = "Ved";
// let b = 23;
// console.log((a+b))
//Output = ved23

//2
//  const item =
// {
//     name  : "vedant",
//     section : "A",
//     isPricipal : false
// }


//3
// //item = 45 cant do
// //but we can
// item['name'] = "Akki"
// console.log(item)

//5
// const dic = 
// {
//     word1 : "Meaning",
//     word2 : "Meaning",
//     word3 : "Meaning",
// }

// console.log(dic['word1'])

//promt
// let a = prompt("What Is Your Age")
// a = Number.parseInt(a);
// console.log(typeof a)

//LOOPS
//For In Loop  - It Will Loop thorugh key of an object and also works in array

// let obj = 
// {
//     "Ved" : 23,
//     "Akshay" : 55,
//     "Salman" : 52
// }

// for(let a in obj)
// {
//     console.log("Marks of " + a + "Are " + obj[a])
// }


//For In Loops - It will loop thorugh values of an object iterate ds like String and Array
// for(let b of "Ved")
// {
//     console.log(b)
// }
//version problem is here So Output should be like
//V
//e
//d

//Function IN JS

// function myFunc()
// {
//     console.log("OKOK")
// }

// console.log(myFunc)


// function myFunc(para1 ,para2)
// {
//     console.log("OKOK");
//     let c = (para1+para2);
//     return c;
// }
// console.log(myFunc(3,4))
//let v = myFunct(2,4)
//console.log(v)


//WAP To Print Out The Marks Using For Loop

// let marks = 
// {
//     "akki":324,
//     "Ved" : 234,
//     "Sal" : 23
// }

// for(let i = 0; i < Object.keys(marks).length;i++)
// {
//     console.log("Marks of " + Object.keys(marks)[i] + " Are " + marks[Object.keys(marks)[i]])
// }

// for(let a in marks)
// {
//     console.log("Marks of " + a + " are " + marks[a])
// }

//taking const let and var variable

// const sum = (p,q) =>
// {
// return (p + q);
// }
// console.log(sum(2,3))

//Strings 
//it can be created using double quote and single quote also
//let a = "Ved"
//let a = 'Ved'

//Template Literals
// let a = "Ved"
// let b = "Akki"

// let sent = `${b} is a frnd of ${a}`;
// console.log(sent)

//Array
//In This Arrya Return an Object
// let a = [2,34,5,45]
// a.push[9]
// console.log(a)

//It Sort Alphabetically
// let a = [34,45,,4235,43643,213,2332,43,32]
// console.sort()
// console.log(a)

//Adjacent insertion
// let first = document.querySelector("#first");
// first.insertAdjacentHTML('beforebegin','<div id = "test"> Test </div>');
// first.insertAdjacentHTML('beforeend','<div id = "test"> Test </div>');
// first.insertAdjacentHTML('afterbegin','<div id = "test"> Test </div>');
// first.insertAdjacentHTML('afterend','<div id = "test"> Test </div>');
// first.remove();

