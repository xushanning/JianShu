void main() {
  /**
   * map操作符的三种使用方式
   */
  List<String> nameList = ['xiaoming', 'xiaohong', 'xiaogang'];
  final result = nameList.map((item) => item + "  hahaha");
  print(result);
  //List.form或者toList会将("a","b","c")转换为数组["a","b","c"]
  final result2 = List.from(nameList.map((item) => item + "hahaha"));
  print(result2);

  final result3 = nameList.map((e) => e + "hahaha").toList();
  print(result3);


}
