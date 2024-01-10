//function parameters

//함수의 매개변수가 많거나 매개변수의 기본값이 필요한 경우 등에 활용된다.

//function displayProduct(producer = "코로나", width = 0, height = 0, items = []){}

function displayProduct({producer = "covid",width = 10, height = 20, items = []}){

    console.log(`${producer}  ${width}  ${height}`);
    console.log(items);
}

    let exampleProduct = {
     items : ['Coffee', 'Donut'],
     producer: '갈리오',   
    
    };

    // displayProduct(exampleProduct);
    let {producer = '아무개', width = 10, height = 20, items = []} = exampleProduct;
    console.log(`${producer}`);
    
    
    