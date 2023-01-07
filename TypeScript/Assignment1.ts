let nums: Array<number>;
nums = [23, 34, 100, 14, 9,8,12,8,8,8]; 
let minumumNum = (numArr: Array<number>) => {
  var minNum=0;
  for(var i=0;i<numArr.length; i++){
    for(var j=i+1;j<numArr.length; j++){
      if(numArr[i] < numArr[j]){
      minNum = numArr[i];
    }else if(numArr[i] > numArr[j]){
      minNum =numArr[j];
    }
  }}
  return minNum;
};
console.log(minumumNum(nums));