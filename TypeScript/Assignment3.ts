let nums: Array<number>;
nums = [23, 34, 100, 14, 44]; 

let calAvg = (numArr: Array<number>) : number =>{
    
    var totalNum = numArr.length;
    var sumOfNumbers=0;
    numArr.forEach(element => {
        sumOfNumbers+=element;
    });
    if(totalNum >0){
        return sumOfNumbers/totalNum;

    }else{
        console.log("Array is empty !!");
    }
    return 0;
};
console.log(calAvg(nums));