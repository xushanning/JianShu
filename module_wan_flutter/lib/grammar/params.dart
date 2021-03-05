/// 用于测试两种参数：[]{}
void main() {
  fun1("xu", 31, "海淀");
  fun2("xu", address: "钢研");
  fun3(fun4);

  Function fun = fun5();
  fun("fun4被调用了");
  
}



void fun1(String name, [int age = 31, String address]) {
  print(name + age.toString() + address);
}

void fun2(String name, {int age = 32, String address}) {
  print(name + age.toString() + address);
}

void fun3(Function fun) {
  fun("fun4被调用了");
}

void fun4(String s) {
  print(s);
}

Function fun5() {
  return fun4;
}
