class BaseRes {
  Object data;
  int errorCode;
  String errorMessage;

  BaseRes.fromJson(Map<String, dynamic> json) {
    data = json["data"];
    errorCode = json["errorCode"];
    errorMessage = json["errorMessage"];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map();
    data["data"] = this.data;
    data["errorCode"] = this.errorCode;
    data["errorMessage"] = this.errorMessage;
    return data;
  }
}
