var checkStrIsPallingrom = function (str) {
    for (var i = 0, j = str.length - 1; i < str.length / 2; i++, j--) {
        if (str.charAt(i) != str.charAt(j)) {
            console.log("char " + str[i] + " at position " + i + " does not matched char " + str[j] + " at position " + j);
            console.log("Stirng is not palindrome.");
            break;
        }
        else {
            console.log("char " + str[i] + " at position " + i + " matched char " + str[j] + " at position " + j);
            if (i == (str.length / 2) - 1) {
                console.log("Stirng is not palindrome.");
            }
        }
    }
};
checkStrIsPallingrom("madam");
