import 'dart:convert';
import 'package:logger/logger.dart';
import 'package:module_wan_flutter/net/base_page_res.dart';
import 'package:flutter/material.dart';
import 'package:module_wan_flutter/bean/banner_bean.dart';
import 'package:module_wan_flutter/bean/article_bean.dart';
import 'package:module_wan_flutter/net/api.dart';
import 'package:module_wan_flutter/net/http_request.dart';
import 'package:sprintf/sprintf.dart';

class HomeModel with ChangeNotifier {
  //banner数据
  List<BannerBean> _bannerData = [];

  List<BannerBean> get bannerData => _bannerData;

  //list数据
  List<ArticleBean> _itemData = [];

  List<ArticleBean> get itemData => _itemData;

  int _curPage = 1;

  HomeModel() {
    _getBannerData();
    _getListData();
    _getTopData();
  }

  void _getBannerData() {
    Net.getInstance().get(Api.homeBanner, success: (data) {
      _bannerData =
          (data as List).map((item) => BannerBean.fromJson(item)).toList();
      notifyListeners();
    }, error: () {});
  }

  void _getListData() {
    Net.getInstance().get(sprintf(Api.homeArticle, [_curPage]),
        success: (data) {
      List<ArticleBean> list =
          (data["datas"] as List).map((e) => ArticleBean.fromJson(e)).toList();
      _itemData.addAll(list);
      notifyListeners();
    }, error: () {});
  }

  void _getTopData() {
    Net.getInstance().get(Api.homeTop, success: (data) {
      Logger().d(data);
    }, error: () {});
  }
}
