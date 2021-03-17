import 'dart:convert';
import 'package:cookie_jar/cookie_jar.dart';
import 'package:dio/dio.dart';
import 'package:dio_cookie_manager/dio_cookie_manager.dart';
import 'package:logger/logger.dart';
import 'package:module_wan_flutter/net/base_res.dart';
import 'package:module_wan_flutter/net/api.dart';

class Net {
  Dio _dio;
  static Net _instance;
  var logger = Logger();

  static Net getInstance() {
    if (_instance == null) {
      _instance = Net();
    }
    return _instance;
  }

  Net() {
    BaseOptions options = BaseOptions(
        baseUrl: Api.baseUrl,
        connectTimeout: 5000,
        receiveTimeout: 5000,
        responseType: ResponseType.plain);
    _dio = Dio(options);

    _dio.interceptors.add(CookieManager(CookieJar()));
  }

  ///get请求
  get(url, {params, Function success, Function error}) async {
    Response res;
    try {
      logger.d("请求地址:" + Api.baseUrl + url);
      res = await _dio.get(url, queryParameters: params);
      logger.d("请求返回" + res.data);

      if (res.data != null) {
        //decode可以将json字符串转换成Map<String,dynamic>类型
        BaseRes baseRes = BaseRes.fromJson(json.decode(res.data));
        switch (baseRes.errorCode) {
          case 0:
            //序列化成json字符串
            success(baseRes.data);
            break;
          case -1001:

            ///跳转登陆

            break;
          default:
            break;
        }
      }
    } on DioError catch (e) {
      print(e);
    }
  }

  ///post请求
  post(url, {data, Function success, Function error}) async {
    Response res;
    try {
      res = await _dio.post(url, queryParameters: data);
    } on DioError catch (e) {}
  }
}
