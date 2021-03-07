import 'package:flutter/material.dart';
import 'package:flutter_swiper/flutter_swiper.dart';
import 'package:module_wan_flutter/bean/banner_bean.dart';
import 'package:module_wan_flutter/net/api.dart';
import 'package:module_wan_flutter/net/http_request.dart';

/// 主页面
class HomePage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _HomePageState();
  }
}

class _HomePageState extends State<HomePage> {
  //banner数据
  List<BannerBean> bannerData = List();

  //首页数据
  List<String> homeListData = List();

  @override
  void initState() {
    super.initState();
    getBannerData();
  }

  getBannerData() async {
    Net.getInstance().get(Api.homeBanner, success: (data) {
      setState(() {
        bannerData.clear();
        bannerData.addAll(
            (data as List).map((item) => BannerBean.fromJson(item)).toList());
      });
    }, error: () {});
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: [

          Container(
              height: 200,
              child: bannerData.length != 0
                  ? Swiper(
                      autoplayDelay: 3000,
                      itemHeight: 200,
                      itemCount: bannerData.length,
                      itemBuilder: (context, index) {
                        return Image.network(
                          bannerData[index].imagePath,
                          fit: BoxFit.fill,
                        );
                      },
                    )
                  : SizedBox(
                      width: 0,
                      height: 0,
                    )),
          // ListView.builder(
          //   itemBuilder: (context, index) {
          //     return Text("ddd");
          //   },
          // ),
        ],
      ),
    );
  }
}
