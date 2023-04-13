// 2625. Flatten Deeply Nested Array
/**
 * @param {any[]} arr
 * @param {number} depth
 * @return {any[]}
 */
var flat = function (arr, n) {
    if (n === 0) {
        return arr;
    }
    var result = [];

    arr.forEach((item, index, array) => {
        if (Array.isArray(item)) {
            var subArr = flat(item, n - 1);
            subArr.forEach((subItem, subIndex, subArray) => result.push(subItem));
        } else {
            result.push(item);
        }
    });
    return result;
};

console.log(flat([1, 2, 3, [4, 5, 6], [7, 8, [9, 10, 11], 12], [13, 14, 15]], 0));
console.log(flat([1, 2, 3, [4, 5, 6], [7, 8, [9, 10, 11], 12], [13, 14, 15]], 1));
console.log(flat([[1, 2, 3], [4, 5, 6], [7, 8, [9, 10, 11], 12], [13, 14, 15]], 2));