// 2621. Sleep
/**
 * @param {number} millis
 */
async function sleep(millis) {
    // resolve就是then()调用的函数，reject就是catch()调用的函数
    await new Promise(resolve => setTimeout(resolve, millis));
}

var t = Date.now();
sleep(100).then(() => {
    console.log(Date.now() - t);
}).catch(() => {
    console.log("error");
});