/*
    클래스 상속을 하면 클래스를 다른 클래스로 확장할 수 있다.
 */

    //상속 기본 문법

    //Animal 클래스 선언
    class Animal {
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
    }

    let animal = new Animal('동물', 30);
    animal.eat(1);
    animal.move(1);

    //Animal을 상속 받는 Human 클래스 선언 --> 선언 시에는 extends 키워드를 사용한다.
    class Human extends Animal {

        develop(language){
            console.log(`${this.name}(은)는 ${language}로 개발을 합니다. 정말 즐겁습니다. ^^;`);
        }
    }

    let human = new Human('수강생', 80);
    human.eat(3);
    human.move(6);

    human.develop('JavaScript');

    /**키워드 extends는 프로토타입을 기반으로 동작한다. 
    */