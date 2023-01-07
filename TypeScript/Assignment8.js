var prices = [[56, 60], [100, 60], [46, 60]];
var calProfitOrLoss = function (prices) {
    for (var i = 0; i < prices.length; i++) {
        console.log(i);
        if (prices[i][0] != prices[i][1]) {
            if (prices[i][0] > prices[i][1]) {
                console.log("loss of " + (prices[i][0] - prices[i][1]));
            }
            if (prices[i][0] < prices[i][1]) {
                console.log("profit of " + (prices[i][1] - prices[i][0]));
            }
        }
        else {
            console.log("No profit No Loss !!");
        }
    }
};
calProfitOrLoss(prices);
