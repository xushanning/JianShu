import 'package:flutter/material.dart';
import 'package:module_wan_flutter/bean/banner_bean.dart';
import 'package:module_wan_flutter/net/api.dart';
import 'package:module_wan_flutter/net/http_request.dart';
import 'package:sprintf/sprintf.dart';

class HomeModel with ChangeNotifier {
  //banner数据
  List<BannerBean> _bannerData = [];

  List<BannerBean> get bannerData => _bannerData;

  List<String> _listData = [];

  int _curPage = 0;

  HomeModel() {
    _getBannerData();
    _getListData();
  }

  void _getBannerData() {
    Net.getInstance().get(Api.homeBanner, success: (data) {
      _bannerData.clear();
      _bannerData.addAll(
          (data as List).map((item) => BannerBean.fromJson(item)).toList());
      notifyListeners();
    }, error: () {});
  }

  void _getListData() {
    Net.getInstance()
        .get(sprintf(Api.homeArticle, [_curPage]), success: (data) {}, error: () {});
  }
}
