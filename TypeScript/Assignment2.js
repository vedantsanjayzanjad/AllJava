var fruits;
fruits = ['Apple', 'Orange', 'Banana'];
var printStrLength = function (fruits) {
    for (var i = 0; i < fruits.length; i++) {
        console.log("String is " + fruits[i] + " and its length is : " + fruits[i].length);
    }
};
printStrLength(fruits);
