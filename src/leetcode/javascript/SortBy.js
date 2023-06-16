// 2724. Sort By
/**
 * @param {Array} arr
 * @param {Function} fn
 * @return {Array}
 */
var sortBy = function (arr, fn) {
    arr.sort((x, y) => fn(x) - fn(y));
    return arr;
};

console.log(sortBy([5, 4, 1, 2, 3], x => x));
console.log(sortBy([{"x": 1}, {"x": 0}, {"x": -1}], d => d.x));
console.log(sortBy([[3, 4], [5, 2], [10, 1]], x => x[1]));