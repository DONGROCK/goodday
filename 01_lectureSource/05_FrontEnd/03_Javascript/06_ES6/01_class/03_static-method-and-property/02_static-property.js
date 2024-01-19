


class Animal {

    static planet = '지구';
    constructor(name, weight){
        this.name = name;
        this.weight = weight;
    }

    eat(foodWeight){
        this.weight += foodWeight;
        console.log(`${this.name}(은)는 ${foodWeight}kg의 식사를 하고 ${this.weight}kg이 되었씁니다.`);
    }

    move(lostWeight){
        if(this.weight > lostWeight){
            this.weight -= lostWeight;
        }
        console.log(`${this.name}(은)는 움직임으로 인해 ${lostWeight}kg 감량되어 ${this.weight}kg이 되었습니다.`);
        
    }
    static compare(animalA, animalB){
        return animalA.weight - animalB.weight;
    }
}
Animal.staticProperty = 'static을 사용한 선언은 기술적으론 클래스 자체에 직접 할당하는 것과 동일하다.';

class Human extends Animal{

    develop(language){
        
        if(language == 'html'){
            
            return console.log("html은 프로그래밍언어가 아닙니다.");
            
        } else{
        console.log(`${this.name}(은)는 ${language}로 개발을 합니다. 정말 즐겁네요.`);
    }
    }
}

let humans = [new Human('나루토', 80),
             new Human('사스케', 50),
              new Human('사쿠라')];

console.log(humans);
humans.sort(Human.compare);
console.log(humans);

humans[0].develop('JavaScript');
humans[1].develop('html');
humans[2].develop('c++')

console.log(Human.planet);          //정적 프로퍼티가 상속되었다.
console.log(Human.staticProperty);  //직접 할당한 경우도 동일하게 동작한다.


