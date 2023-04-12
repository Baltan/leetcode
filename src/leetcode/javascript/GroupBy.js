// 2631. Group By
/**
 * @param {Function} fn
 * @return {Array}
 */
Array.prototype.groupBy = function (fn) {
    var result = {};

    for (var item of this) {
        var key = fn(item);

        if (!result.hasOwnProperty(key)) {
            result[key] = [];
        }
        result[key].push(item);
    }
    return result;
};

console.log([{"id": "1"}, {"id": "1"}, {"id": "2"}].groupBy(item => item.id));
console.log([[1, 2, 3], [1, 3, 5], [1, 5, 9]].groupBy(list => String(list[0])));
console.log([1, 2, 3, 4, 5, 6, 7, 8, 9, 10].groupBy(n => String(n > 5)));

