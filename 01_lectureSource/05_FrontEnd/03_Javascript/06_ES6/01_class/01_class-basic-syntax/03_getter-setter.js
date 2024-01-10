//03. getter, setter
class Product {
    constructor(name, price) {
        this.name = name;  // 내부 속성을 직접 할당
        this.price = price;
    }

    // getter 함수
    get name() {
        console.log('get name 동작');
        return this._name;
    }
    
    get price() {
        console.log('get price 동작');
        return this._price;
    }

    // setter 함수
    set name(value) {
        console.log("set name 동작");
        this._name = value;  // 내부 속성에 할당
    }

    set price(value) {
        console.log('set price 동작');
        if (value <= 0) {
            console.log('가격은 음수일 수 없습니다.');
            this._price = 0;
            return;
        }

        this._price = value;
    }
}
let phone = new Product('전화기', 230000);
console.log(phone.name + ', ' + phone.price);

let computer = new Product('컴퓨터', -150000000);
console.log(computer.name + ', ' + computer.price);

