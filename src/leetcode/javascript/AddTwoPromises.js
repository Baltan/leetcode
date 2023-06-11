// 2723. Add Two Promises
/**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
var addTwoPromises = async function (promise1, promise2) {
    var sum = 0;
    await promise1.then(result => sum += result);
    await promise2.then(result => sum += result);
    return sum;
};

addTwoPromises(
    new Promise(resolve => setTimeout(() => resolve(2), 20)),
    new Promise(resolve => setTimeout(() => resolve(5), 60)))
    .then(result => console.log(result));

addTwoPromises(
    new Promise(resolve => setTimeout(() => resolve(10), 50)),
    new Promise(resolve => setTimeout(() => resolve(-12), 30)))
    .then(result => console.log(result));