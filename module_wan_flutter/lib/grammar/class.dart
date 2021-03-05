void main() {
  final p = Person("海淀", name: "xu", age: 52);
}

class Person {
  String name;
  int age;

  ///方式1
  // Person(String name, int age) {
  //   this.name = name;
  //   this.age = age;
  // }

  ///方式2
  Person(String address, {this.name, this.age});
}
