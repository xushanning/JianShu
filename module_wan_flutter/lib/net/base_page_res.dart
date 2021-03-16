class BasePageRes {
  List<dynamic> datas;
  int total;
  int pageCount;

  BasePageRes.fromJson(Map<String, dynamic> json) {
    datas = json["datas"];
    total = json["total"];
    pageCount = json["pageCount"];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map();
    data["datas"] = this.datas;
    data["total"] = this.total;
    data["pageCount"] = this.pageCount;
    return data;
  }
}