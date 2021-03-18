import 'package:flutter/material.dart';
import 'package:flutter_swiper/flutter_swiper.dart';
import 'package:module_wan_flutter/bean/article_bean.dart';
import 'package:module_wan_flutter/widgets/search_head.dart';
import 'package:provider/provider.dart';

import 'home_model.dart';

/// 主页面
class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider<HomeModel>(
        create: (_) => HomeModel(),
        builder: (context, child) {
          HomeModel model = Provider.of(context);
          return Scaffold(
            body: Column(
              children: [
                Container(
                    height: 200,
                    child: model.bannerData.length != 0
                        ? Swiper(
                            autoplayDelay: 3000,
                            itemHeight: 200,
                            itemCount: model.bannerData.length,
                            itemBuilder: (context, index) {
                              return Image.network(
                                model.bannerData[index].imagePath,
                                fit: BoxFit.fill,
                              );
                            },
                          )
                        : SizedBox(
                            width: 0,
                            height: 0,
                          )),
                Expanded(
                  child: ListView.builder(
                      itemCount: model.itemData.length,
                      itemBuilder: (context, index) {
                        return _getItem(model.itemData[index]);
                      }),
                )
              ],
            ),
          );
        });
  }

  Card _getItem(ArticleBean bean) {
    return Card(
      margin: EdgeInsets.only(left: 16, right: 16, top: 8, bottom: 8),
      elevation: 3,
      child: Column(
        children: [
          Row(
            children: [
              Text(bean.author),
              _getRedFrameText("置顶"),
              _getRedFrameText("新"),
              //todo 是否还有其他方式中间撑开？
              Expanded(child: SizedBox()),
              Text(
                bean.publishTime.toString(),
              )
            ],
          ),
          Text(
            bean.title,
            textAlign: TextAlign.left,
          ),
          MyView().getText()
        ],
      ),
    );
  }

  ///带红框框的Text
  Container _getRedFrameText(String content) {
    return Container(
      alignment: Alignment.center,
      decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.all(Radius.circular(2)),
          //背景颜色
          border: Border.all(width: 1, color: Color(0xffF85959))),
      child: Text(
        content,
        style: TextStyle(color: Color(0xffF85959)),
      ),
    );
  }
}
