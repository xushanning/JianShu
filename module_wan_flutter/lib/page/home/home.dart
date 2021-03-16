import 'package:flutter/material.dart';
import 'package:flutter_swiper/flutter_swiper.dart';
import 'package:provider/provider.dart';

import 'home_model.dart';

/// 主页面
class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider<HomeModel>(
      create: (_) => HomeModel(),
      builder: (context, child) {
        HomeModel bannerModel = Provider.of(context);

        return Scaffold(
          body: Column(
            children: [
              Container(
                  height: 200,
                  child: bannerModel.bannerData.length != 0
                      ? Swiper(
                          autoplayDelay: 3000,
                          itemHeight: 200,
                          itemCount: bannerModel.bannerData.length,
                          itemBuilder: (context, index) {
                            return Image.network(
                              bannerModel.bannerData[index].imagePath,
                              fit: BoxFit.fill,
                            );
                          },
                        )
                      : SizedBox(
                          width: 0,
                          height: 0,
                        )),
            ],
          ),
        );
      },
    );
  }
}
