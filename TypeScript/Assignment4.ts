let nums: Array<number>;
nums = [23, 34, 100, 14, 44]; 

let sortNumbers = (nums: Array<number>) => {
    for (let i = 0; i < nums.length; i++) {
        
        for (let j = i+1; j < nums.length; j++) {
           
            if(nums[i] > nums[j]){
                var temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            
        }
        
    }
    console.log("Printing sorted numbers : "+nums);
     
};

sortNumbers(nums);