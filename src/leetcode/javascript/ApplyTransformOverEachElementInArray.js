// 2635. Apply Transform Over Each Element in Array
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function (arr, fn) {
    var result = [];

    for (var i = 0; i < arr.length; i++) {
        result.push(fn(arr[i], i));
    }
    return result;
};

console.log(map([1, 2, 3], n => n + 1));
console.log(map([1, 2, 3], (n, i) => n + i));
console.log(map([10, 20, 30], () => 42));