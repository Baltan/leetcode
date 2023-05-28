// 2705. Compact Object
/**
 * @param {Object} obj
 * @return {Object}
 */
var compactObject = function (obj) {
    if (!(obj instanceof Object)) {
        return obj;
    }

    if (obj instanceof Array) {
        var result = [];

        for (var element of obj) {
            var value = compactObject(element);

            if (value) {
                result.push(value);
            }
        }
        return result;
    } else {
        var result = {};

        for (var key of Object.keys(obj)) {
            var value = compactObject(obj[key]);

            if (value) {
                result[key] = value;
            }
        }
        return result;
    }
};

console.log(compactObject([null, 0, false, 1]));
console.log(compactObject({"a": null, "b": [false, 1]}));
console.log(compactObject([null, 0, 5, [0], [false, 16]]));