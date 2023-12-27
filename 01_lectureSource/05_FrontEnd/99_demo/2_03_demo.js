const num1 = 10;
const num2 = 20;

// let a = function (num1,num2){
//            let minNumber = Math.min(num1,num2);
//            let maxNumber = Math.max(num1,num2);

//             return `최소값 ${minNumber} 최대값 ${maxNumber}`;
//     }

//     console.log(a(num1, num2));
const MinMax = (num1, num2) => {
    let minNumber = num1 < num2 ? num1:num2;
    let maxNumber = num1 > num2 ? num1:num2;

    return `최소값 ${minNumber} 최대값 ${maxNumber}`
}
console.log(MinMax(num1,num2));



    