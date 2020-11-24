class PublicAccount {
  String name;
  int id;

  PublicAccount.fromJson(Map<String, dynamic> json) {
    name = json["name"];
    id = json["id"];
  }
}
