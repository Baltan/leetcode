// 2634. Filter Elements from Array
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function (arr, fn) {
    var result = [];

    for (var i = 0; i < arr.length; i++) {
        if (fn(arr[i], i)) {
            result.push(arr[i]);
        }
    }
    return result;
};

console.log(filter([0, 10, 20, 30], n => n > 10));
console.log(filter([1, 2, 3], (n, i) => i === 0));
console.log(filter([-2, -1, 0, 1, 2], n => n + 1));