import 'package:dio/dio.dart';
import 'package:retrofit/http.dart';
import 'package:json_annotation/json_annotation.dart';
import 'package:retrofit/retrofit.dart';

///api 类
class Api {
  ///登陆
  static const String login = "user/login";

  ///登出
  static const String logout = "user/logout/json";

  ///首页banner数据
  static const String homeBanner = "banner/json";

  ///首页文章列表
  static const String homeArticle = "article/list";

  ///获取公众号列表
  static const String publicAccountList = "wxarticle/chapters/json";
}

// @RestApi(baseUrl: "xxx")
// abstract class RestClient {
//
//   factory RestClient(Dio dio, {String baseUrl}) =xxx;
//
// // @GET("xx")
// // Future <List<Task>> getList();
// }
//
// @JsonSerializable()
// class Task {
// }
