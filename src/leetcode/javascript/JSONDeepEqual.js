// 2628. JSON Deep Equal
/**
 * @param {any} o1
 * @param {any} o2
 * @return {boolean}
 */
var areDeeplyEqual = function (o1, o2) {
    if (o1 === o2) {
        return true;
    }

    if (Object.prototype.toString.call(o1) !== Object.prototype.toString.call(o2)) {
        return false;
    }

    if (typeof o1 === 'object') {
        if (Array.isArray(o1)) {
            if (o1.length != o2.length) {
                return false;
            }

            for (var i = 0; i < o1.length; i++) {
                if (!areDeeplyEqual(o1[i], o2[i])) {
                    return false;
                }
            }
        } else {
            var o1Keys = Object.keys(o1);
            var o2Keys = Object.keys(o2);

            if (o1Keys.length != o2Keys.length) {
                return false;
            }

            for (var key of o1Keys) {
                var o1Value = o1[key];
                var o2Value = o2[key];

                if (!areDeeplyEqual(o1Value, o2Value)) {
                    return false;
                }
            }
        }
    } else {
        if (o1 !== o2) {
            return false;
        }
    }
    return true;
};

console.log(areDeeplyEqual({"x": 1, "y": 2}, {"x": 1, "y": 2}));
console.log(areDeeplyEqual({"y": 2, "x": 1}, {"x": 1, "y": 2}));
console.log(areDeeplyEqual({"x": null, "L": [1, 2, 3]}, {"x": null, "L": ["1", "2", "3"]}));
console.log(areDeeplyEqual(true, false));
console.log(areDeeplyEqual(null, undefined));
console.log(areDeeplyEqual(1, 1));
console.log(areDeeplyEqual(1, "1"));