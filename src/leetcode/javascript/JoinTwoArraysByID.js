// 2722. Join Two Arrays by ID
/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function (arr1, arr2) {
    var result = [];
    var map1 = new Map();
    var map2 = new Map();
    arr1.forEach(obj => map1.set(obj['id'], obj));
    arr2.forEach(obj => map2.set(obj['id'], obj));

    for (var id of map2.keys()) {
        if (!map1.has(id)) {
            result.push(map2.get(id));
        } else {
            var obj1 = map1.get(id);
            var obj2 = map2.get(id);
            var mergedObj = {};
            Object.keys(obj1).forEach(key => mergedObj[key] = obj1[key]);
            Object.keys(obj2).forEach(key => mergedObj[key] = obj2[key]);
            result.push(mergedObj);
        }
    }

    for (var id of map1.keys()) {
        if (!map2.has(id)) {
            result.push(map1.get(id));
        }
    }
    result.sort((x, y) => x['id'] - y['id']);
    return result;
};

console.log(join([{"id": 1, "x": 1}, {"id": 2, "x": 9}], [{"id": 3, "x": 5}]));
console.log(join([{"id": 1, "x": 2, "y": 3}, {"id": 2, "x": 3, "y": 6}],
    [{"id": 2, "x": 10, "y": 20}, {"id": 3, "x": 0, "y": 0}]));
console.log(join([{"id": 1, "b": {"b": 94}, "v": [4, 3], "y": 48}], [{"id": 1, "b": {"c": 84}, "v": [1, 3]}]));
console.log(join([{"id": 1, "a": 21, "t": 95, "y": 51}], [{"id": 1, "k": 51, "u": 30, "s": 61}]));