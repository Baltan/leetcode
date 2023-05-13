// 2677. Chunk Array
/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array[]}
 */
var chunk = function (arr, size) {
    var result = [];
    var start = 0;

    while (start < arr.length) {
        var end = Math.min(start + size, arr.length);
        result.push(arr.slice(start, end));
        start += size;
    }
    return result;
};

console.log(chunk([1, 2, 3, 4, 5], 1));
console.log(chunk([1, 9, 6, 3, 2], 3));
console.log(chunk([8, 5, 3, 2, 6], 6));
console.log(chunk([], 1));