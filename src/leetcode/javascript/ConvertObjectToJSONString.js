// 2633. Convert Object to JSON String
/**
 * @param {any} object
 * @return {string}
 */
var jsonStringify = function (object) {
    if (typeof object === 'object') {
        if (object === null) {
            return String(null);
        } else if (Array.isArray(object)) {
            var result = "[";

            for (var item of object) {
                result += jsonStringify(item);
                result += ",";
            }
            return (object.length === 0 ? result : result.slice(0, result.length - 1)) + "]";
        } else {
            var result = "{";

            for (var key of Object.keys(object)) {
                var value = object[key];
                result += jsonStringify(key);
                result += ":";
                result += jsonStringify(value);
                result += ",";
            }
            return (Object.keys(object).length === 0 ? result : result.slice(0, result.length - 1)) + "}";
        }
    } else {
        return typeof object === 'string' ? "\"" + String(object) + "\"" : object;
    }
};

console.log(jsonStringify([]));
console.log(jsonStringify({"y": 1, "x": 2}));
console.log(jsonStringify({"a": "str", "b": -12, "c": true, "d": null}));
console.log(jsonStringify({"key": {"a": 1, "b": [{}, null, "Hello"]}}));