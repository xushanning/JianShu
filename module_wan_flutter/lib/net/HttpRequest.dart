import 'dart:convert';

import 'package:cookie_jar/cookie_jar.dart';
import 'package:dio/dio.dart';
import 'package:dio_cookie_manager/dio_cookie_manager.dart';
import 'package:module_wan_flutter/net/BaseRes.dart';

class HttpRequest {
  Dio dio;
  static HttpRequest instance;
  static String baseUrl = "xxx";
  BaseOptions options;

  static HttpRequest getInstance() {
    if (instance == null) {
      instance = new HttpRequest();
    }
    return instance;
  }

  HttpRequest() {
    options = BaseOptions(
        baseUrl: baseUrl,
        connectTimeout: 5000,
        receiveTimeout: 5000,
        responseType: ResponseType.plain);
    dio = new Dio(options);
    dio.interceptors.add(CookieManager(CookieJar()));
  }

  ///get请求
  get(url, {data, Function success, Function error}) async {
    Response res;
    try {
      res = await dio.get(url, queryParameters: data);
    } on DioError catch (e) {}
    if (res.data != null) {
      BaseRes baseRes = BaseRes.fromJson(json.decode(res.data));
      switch (baseRes.errorCode) {
        case 0:
          success(jsonEncode(baseRes.data));
          break;
        case -1001:

          ///跳转登陆

          break;
        default:
          error(baseRes.errorCode, baseRes.errorMessage);
          break;
      }
    }
  }

  ///post请求
  post(url, {data, Function success, Function error}) async {
    Response res;
    try {
      res = await dio.post(url, queryParameters: data);
    } on DioError catch (e) {}
  }
}
