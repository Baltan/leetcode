// 2675. Array of Objects to Matrix
/**
 * @param {Array} arr
 * @return {Matrix}
 */
var jsonToMatrix = function (arr) {
    var result = [];
    var objs = [];
    var keys = [];

    for (var i = 0; i < arr.length; i++) {
        var obj = {};
        var loop = true;

        for (var key in arr[i]) {
            obj[key] = arr[i][key];
        }

        while (loop) {
            loop = false;

            for (var outerKey in obj) {
                if (!(obj[outerKey] instanceof Object)) {
                    continue;
                }

                for (var innerKey in obj[outerKey]) {
                    obj[outerKey + "." + innerKey] = obj[outerKey][innerKey];
                    loop ||= obj[outerKey][innerKey] instanceof Object;
                }
                delete obj[outerKey];
            }
        }
        objs.push(obj);
        keys.push(...Object.keys(obj));
    }
    keys = Array.from(new Set(keys)).sort();
    result.push(keys);

    for (var obj of objs) {
        var values = [];

        for (var ele of keys) {
            values.push(obj[ele] === undefined ? "" : obj[ele]);
        }
        result.push(values);
    }
    return result;
}

// console.log(jsonToMatrix([
//     {"b": 1, "a": 2},
//     {"b": 3, "a": 4}
// ]));
// console.log(jsonToMatrix([
//     {"a": 1, "b": 2},
//     {"c": 3, "d": 4},
//     {}
// ]));
// console.log(jsonToMatrix([
//     {"a": {"b": 1, "c": 2}},
//     {"a": {"b": 3, "d": 4}}
// ]));
// console.log(jsonToMatrix([
//     [{"a": null}],
//     [{"b": true}],
//     [{"c": "x"}]
// ]));
// console.log(jsonToMatrix([
//     {},
//     {},
//     {},
// ]));
console.log(jsonToMatrix([
    {
        "_id": "64265e18f4596ed5b53673c1",
        "index": 0,
        "guid": "bf29f675-5742-43a5-b667-d7158aa9cca4",
        "isActive": true,
        "balance": "$1,216.03",
        "picture": "http://placehold.it/32x32",
        "age": 34,
        "eyeColor": null,
        "name": "Roberts West",
        "gender": "male",
        "company": "GEEKY",
        "email": "robertswest@geeky.com",
        "phone": "+1 (918) 600-2564",
        "address": "584 Logan Street, Whitewater, Alaska, 1691",
        "registered": "2022-12-24T06:42:37 +06:00",
        "latitude": 82.029314,
        "longitude": 88.713256,
        "tags": [
            "et",
            true,
            "velit",
            "velit",
            "ullamco",
            "qui",
            "nostrud"
        ],
        "friends": [
            {
                "id": 0,
                "name": "Manuela Hart"
            },
            {
                "id": 1,
                "name": "Janice Sykes"
            },
            {
                "id": 2,
                "name": "Beasley Bonner"
            }
        ],
        "greeting": "Hello, Roberts West! You have 6 unread messages.",
        "favoriteFruit": "apple"
    },
    {
        "_id": "64265e18f4596ed5b53673c1",
        "index": 0,
        "guid": "bf29f675-5742-43a5-b667-d7158aa9cca4",
        "isActive": "0.8871513657363088",
        "balance": "$1,216.03",
        "picture": "http://placehold.it/32x32",
        "age": 34,
        "eyeColor": null,
        "name": "Roberts West",
        "gender": "male",
        "company": "GEEKY",
        "email": "0.06347493782339186",
        "phone": "+1 (918) 600-2564",
        "address": "584 Logan Street, Whitewater, Alaska, 1691",
        "registered": "2022-12-24T06:42:37 +06:00",
        "latitude": 82.029314,
        "longitude": 88.713256,
        "tags": [
            "et",
            true,
            "0.845383682084023",
            "0.50810702880834",
            "ullamco",
            "0.6063844661474282",
            "nostrud"
        ],
        "friends": [
            {
                "id": 0,
                "name": "Manuela Hart"
            },
            {
                "id": 1,
                "name": "Janice Sykes"
            },
            {
                "id": 2,
                "name": "Beasley Bonner"
            }
        ],
        "greeting": "0.4870171947182176",
        "favoriteFruit": "apple"
    },
    {
        "_id": "64265e18f4596ed5b53673c1",
        "index": 0,
        "guid": "bf29f675-5742-43a5-b667-d7158aa9cca4",
        "isActive": "0.8871513657363088",
        "balance": "$1,216.03",
        "picture": "http://placehold.it/32x32",
        "age": 34,
        "eyeColor": null,
        "name": "Roberts West",
        "gender": "male",
        "company": "GEEKY",
        "email": "0.06347493782339186",
        "phone": "0.42726858726084616",
        "address": "584 Logan Street, Whitewater, Alaska, 1691",
        "registered": "2022-12-24T06:42:37 +06:00",
        "latitude": 82.029314,
        "longitude": 88.713256,
        "tags": [
            "et",
            "0.7133385229103999",
            "0.845383682084023",
            "0.50810702880834",
            "ullamco",
            "0.6063844661474282",
            "nostrud"
        ],
        "friends": [
            {
                "id": 0,
                "name": {
                    "x": true
                }
            },
            {
                "id": 1,
                "name": "Janice Sykes"
            },
            {
                "id": 2,
                "name": "Beasley Bonner"
            }
        ],
        "greeting": "0.4870171947182176",
        "favoriteFruit": "apple"
    },
    {
        "_id": "64265e18f4596ed5b53673c1",
        "index": 0,
        "guid": "bf29f675-5742-43a5-b667-d7158aa9cca4",
        "isActive": {
            "x": true
        },
        "balance": "$1,216.03",
        "picture": "http://placehold.it/32x32",
        "age": 34,
        "eyeColor": "0.7425889518652591",
        "name": "Roberts West",
        "gender": "male",
        "company": "GEEKY",
        "email": "0.6107816745338521",
        "phone": "0.42726858726084616",
        "address": "584 Logan Street, Whitewater, Alaska, 1691",
        "registered": "2022-12-24T06:42:37 +06:00",
        "latitude": 82.029314,
        "longitude": 88.713256,
        "tags": [
            "et",
            "0.7133385229103999",
            "0.9779057236668114",
            "0.50810702880834",
            "ullamco",
            "0.6063844661474282",
            "0.7280202320074816"
        ],
        "friends": [
            {
                "id": 0,
                "name": {
                    "x": true
                }
            },
            {
                "id": "0.18043356034259816",
                "name": "0.826500377015936"
            },
            {
                "id": "0.8341446867741065",
                "name": "Beasley Bonner"
            }
        ],
        "greeting": "0.4870171947182176",
        "favoriteFruit": "apple"
    },
    {
        "_id": "64265e18f4596ed5b53673c1",
        "index": 0,
        "guid": "bf29f675-5742-43a5-b667-d7158aa9cca4",
        "isActive": {
            "x": true
        },
        "balance": "$1,216.03",
        "picture": "http://placehold.it/32x32",
        "age": 34,
        "eyeColor": "0.7425889518652591",
        "name": "Roberts West",
        "gender": {
            "x": true
        },
        "company": "GEEKY",
        "email": "0.6107816745338521",
        "phone": "0.42726858726084616",
        "address": {
            "x": true
        },
        "registered": "2022-12-24T06:42:37 +06:00",
        "latitude": 82.029314,
        "longitude": 88.713256,
        "tags": [
            "et",
            {
                "x": true
            },
            "0.9779057236668114",
            "0.50810702880834",
            "ullamco",
            "0.6063844661474282",
            "0.7280202320074816"
        ],
        "friends": [
            {
                "id": 0,
                "name": {
                    "x": true
                }
            },
            {
                "id": "0.18043356034259816",
                "name": "0.826500377015936"
            },
            {
                "id": "0.8341446867741065",
                "name": "Beasley Bonner"
            }
        ],
        "greeting": "0.3190183283489223",
        "favoriteFruit": "apple"
    }
]));