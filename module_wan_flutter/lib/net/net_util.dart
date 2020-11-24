import 'package:module_wan_flutter/model/public_account.dart';
import 'package:module_wan_flutter/net/http_request.dart';

class NetUtil {
  NetUtil._internal();

  static NetUtil instance = new NetUtil._internal();

  Future<List<PublicAccount>> getPublicAccount() async {
    var datas = await HttpRequest.instance
        .get("https://wanandroid.com/wxarticle/chapters/json");
    return datas == null
        ? null
        : datas.map((item) => PublicAccount.fromJson(item)).toList();
  }
}
