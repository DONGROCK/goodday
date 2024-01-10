//다양한 사용법
let shirts = {
    productName: '망사베이직셔츠'
}

let{productName: productName2 = "어떤 상품", color: color2 = '어떤 색상', price: price2 = 0} = shirts;

console.log(`productName2 : ${productName2}`);
console.log(`color2 : ${color2}`);
console.log(`price2 : ${price2}`);
console.log('---------------------------');

//프로퍼티가 많은 복잡합 객체에서 원하는 정보만 뽑아오기
let pants = {
    productName: "똥싼바지",
    color: "똥색",
    price: "1000",
};

let {productName: prductName3} = pants; //pants에서 productName만 변수로 뽑아내기

console.log(`productName3 : ${prductName3}`);

let{productName: productName4, ...rest} = pants;

console.log('---------------------------');
console.log(`productName4 : ${productName4}`);
console.log(`rest.color : ${rest.color}`);
console.log(`rest.price : ${rest.price}`);
console.log('---------------------------');

//let 없이 사용하는 예시
let productName5, color5, price5;

// {productName: productName5, color: color5, price:price5} = pants; //코드블럭으로 인식해서 오류가 발생한다.
({productName: productName5, color: color5, price:price5} = pants);
console.log(`productName5 : ${productName5}`);
console.log(`color5 : ${color5}`);
console.log(`price5 : ${price5}`);



