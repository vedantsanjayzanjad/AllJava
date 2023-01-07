var prices: [number, number][] = [[56,60],[100,60],[46,60]];

let calProfitOrLoss=(prices: [number, number][]) =>{
   
    for(let i=0;i<prices.length;i++){
       console.log(i);      
        if( prices[i][0]!= prices[i][1]){
        if(prices[i][0] > prices[i][1]){
            console.log("loss of "+(prices[i][0] -  prices[i][1]));
        }
        if(prices[i][0] < prices[i][1]){
            console.log("profit of "+(prices[i][1] - prices[i][0]));
        }
    }else{
        console.log("No profit No Loss !!");
    }
    
    }
}

calProfitOrLoss(prices);
