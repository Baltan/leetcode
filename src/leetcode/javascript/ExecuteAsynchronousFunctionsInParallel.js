// 2721. Execute Asynchronous Functions in Parallel
/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 * 参考：<a href="https://leetcode.cn/problems/execute-asynchronous-functions-in-parallel/solutions/2310660/promise-all-by-alex-pang-1q61/">
 */
var promiseAll = async function (functions) {
    return new Promise((resolve, reject) => {
        var result = [];
        var count = 0;
        /**
         * 闭包，用let声明循环变量
         */
        for (let i = 0; i < functions.length; i++) {
            functions[i]()
                .then(response => {
                    result[i] = response;
                    count++;

                    if (count === functions.length) {
                        resolve(result);
                    }
                })
                .catch(error => reject(error));
        }
    });
};

promiseAll([() => new Promise(resolve => setTimeout(() => resolve(5), 200))]);