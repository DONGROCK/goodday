package com.ohgiraffers.section01.object.book;

public class Book {
    private int number;
    private String title;
    private String author;
    private int price;

    public Book() {
    }

    public Book(int number, String title, String author, int price) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                number +
                ", " + title + '\'' +
                ", " + author + '\'' +
                ", " + price +
                '}';
    }

    /*equals() 오버라이딩
     *
     * 대상객체주소.equals(비교객체주소)*/
    @Override
    public boolean equals(Object obj) {

        if (this == obj) { //같다 면 동일객체
            return true;
        }
        /*
         * this. <-- 없을 수 없다. (인스턴스가 생성되면 주소값이 저장되어서 없을 수 없다.)
         * */
        if (obj == null) {
            return false;
        }
        /*
         * 객체의 각각의 필드값을 체크
         * */
        Book other = (Book) obj;
        /* != 같지않으면 true 아래의 조건식이 성립했다고 하면 두개는 서로 다른인스턴스다.
        * 10 != 10 : 맞으면 false //아닌게 true
        * 10 != 9 : true
        * if(member != null) //맴버가 비어있나 확인 비어있으면 false
        *
        * == 같기를 원하는 것
        * 10 == 10 : true
        * 10 == 9 : false
        *
        * */
        if (this.number != other.number) {
            return false;
        }

        /*title 필드의 경우*/
        if (this.title == null) {

            if (other.title != null){
                return false;
            }
        } else if (!this.title.equals(other.title)) {
            /*
            * title필드가 null이 아닌 경우
            * 두 인스턴스의 title 필드값이 같아야한다.
            * 그렇지 않은 경우 false 발생*/
            return false;
        }

        if(this.author == null){

            if (other.author != null){
                return false;
            }
        } else if (!this.author.equals(other.author)) {
            return false;
        }

        if(this.price != other.price){
            return false;
        }

        return true;
    }
    /*hashcode() 오버라이딩*/

    public int hashcode(){
        /*곱셈 연산을 누적시키기 위해서 0이 아닌값으로 초기화*/
        int result = 1;

        /*
        * 필드마다 곱해줄 소수값을 선언
        * 31은 소수이기 때문에 연산 시 동일한 hashCode 값이 나오지 않을 확률을 증가시킨다.
        *
        * */
        final int PRIME = 31;
        result = PRIME * result + this.number;
        result = PRIME * result + this.title.hashCode();
        result = PRIME * result + this.author.hashCode();
        result = PRIME * result + this.price;

        return result;
    }
}
