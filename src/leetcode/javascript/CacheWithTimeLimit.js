// 2622. Cache With Time Limit
var TimeLimitedCache = function () {
    this.data = {};
    this.expiredTimes = {};
    this.index = 1;
};

/**
 * @param {number} key
 * @param {number} value
 * @param {number} time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function (key, value, duration) {
    var isExisted = this.expiredTimes.hasOwnProperty(key) && this.expiredTimes[key] >= new Date().getTime();
    this.data[key] = value;
    this.expiredTimes[key] = new Date().getTime() + duration;
    this.index++;
    return isExisted;
}
;

/**
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function (key) {
    this.index++;
    return this.data.hasOwnProperty(key) && this.expiredTimes[key] >= new Date().getTime() ? this.data[key] : -1;
};

/**
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function () {
    this.index++;
    return Object.keys(this.data)
        .filter((item, index, array) => this.expiredTimes[item] >= new Date().getTime())
        .length;
};

var time1 = 0;
var cache1 = new TimeLimitedCache([0, 0, 50, 50, 150]);
time1 += 0;
setTimeout(() => console.log(cache1.set(1, 42, 100)), time1);
time1 += 50;
setTimeout(() => console.log(cache1.get(1)), time1);
time1 += 50;
setTimeout(() => console.log(cache1.count()), time1);
time1 += 150;
setTimeout(() => console.log(cache1.get(1)), time1);

console.log("--------------------------------------------")

var time2 = 0;
var cache2 = new TimeLimitedCache([0, 0, 40, 50, 120, 200, 250]);
time2 += 0;
setTimeout(() => console.log(cache2.set(1, 42, 50)), time2);
time2 += 40;
setTimeout(() => console.log(cache2.set(1, 50, 100)), time2);
time2 += 50;
setTimeout(() => console.log(cache2.get(1)), time2);
time2 += 120;
setTimeout(() => console.log(cache2.get(1)), time2);
time2 += 200;
setTimeout(() => console.log(cache2.get(1)), time2);
time2 += 250;
setTimeout(() => console.log(cache2.count()), time2);