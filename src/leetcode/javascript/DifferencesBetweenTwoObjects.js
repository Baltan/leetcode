// 2700. Differences Between Two Objects
/**
 * @param {object} obj1
 * @param {object} obj2
 * @return {object}
 */
function objDiff(obj1, obj2) {
    return compareObject(obj1, obj2);

    function compareArray(arr1, arr2) {
        var result = {};
        var len = Math.min(arr1.length, arr2.length);

        for (var i = 0; i < len; i++) {
            var value1 = arr1[i];
            var value2 = arr2[i];
            var diff;

            if (isEqual(value1, value2)) {
                continue;
            }

            if (!maybeDeepEqual(value1, value2)) {
                result[i] = [value1, value2];
                continue;
            }

            if (value1 instanceof Array && value2 instanceof Array) {
                diff = compareArray(value1, value2);
            } else {
                diff = compareObject(value1, value2);
            }

            if (Object.keys(diff).length !== 0) {
                result[i] = diff;
            }
        }
        return result;
    }

    function compareObject(obj1, obj2) {
        var result = {};
        var keys1 = Object.keys(obj1);
        var keys2 = Object.keys(obj2);

        for (var key of keys1) {
            if (!keys2.includes(key)) {
                continue;
            }
            var value1 = obj1[key];
            var value2 = obj2[key];
            var diff;

            if (isEqual(value1, value2)) {
                continue;
            }

            if (!maybeDeepEqual(value1, value2)) {
                result[key] = [value1, value2];
                continue;
            }

            if (value1 instanceof Array && value2 instanceof Array) {
                diff = compareArray(value1, value2);
            } else {
                diff = compareObject(value1, value2);
            }

            if (Object.keys(diff).length !== 0) {
                result[key] = diff;
            }
        }
        return result;
    }

    function isEqual(obj1, obj2) {
        return obj1 === obj2;
    }

    function maybeDeepEqual(obj1, obj2) {
        if (!(obj1 instanceof Object) && !(obj2 instanceof Object)) {
            return obj1 === obj2;
        }

        if ((obj1 === null && obj2 !== null) || (obj1 !== null && obj2 === null)) {
            return false;
        }

        if ((obj1 === undefined && obj2 !== undefined) || (obj1 !== undefined && obj2 === undefined)) {
            return false;
        }

        if ((obj1 instanceof Object && !(obj2 instanceof Object)) || (!(obj1 instanceof Object) && obj2 instanceof Object)) {
            return false;
        }

        if ((obj1 instanceof Array && !(obj2 instanceof Array)) || (!(obj1 instanceof Array) && obj2 instanceof Array)) {
            return false;
        }
        return true;
    }
};

var obj1 = {}
var obj2 = {
    "a": 1,
    "b": 2
}
console.log(objDiff(obj1, obj2));

console.log("-----------------------------------------");

var obj1 = {
    "a": 1,
    "v": 3,
    "x": [],
    "z": {
        "a": null
    }
}
var obj2 = {
    "a": 2,
    "v": 4,
    "x": [],
    "z": {
        "a": 2
    }
}
console.log(objDiff(obj1, obj2));

console.log("-----------------------------------------");

var obj1 = {
    "a": 5,
    "v": 6,
    "z": [1, 2, 4, [2, 5, 7]]
}
var obj2 = {
    "a": 5,
    "v": 7,
    "z": [1, 2, 3, [1]]
}
console.log(objDiff(obj1, obj2));

console.log("-----------------------------------------");

var obj1 = {
    "a": {"b": 1},
}
var obj2 = {
    "a": [5],
}
console.log(objDiff(obj1, obj2));

console.log("-----------------------------------------");

var obj1 = {
    "a": [1, 2, {}],
    "b": false
}
var obj2 = {
    "b": false,
    "a": [1, 2, {}]
}
console.log(objDiff(obj1, obj2));

console.log("-----------------------------------------");

var obj1 = {"m": "f", "c": [0, true], "v": false}
var obj2 = {"m": "f", "c": [0, false], "v": 0}
console.log(objDiff(obj1, obj2));