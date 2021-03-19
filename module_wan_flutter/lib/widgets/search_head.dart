import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:module_wan_flutter/theme/color_theme.dart';

///搜索head
class SearchHead extends StatelessWidget {
  final String content;

  SearchHead(this.content);

  @override
  Widget build(BuildContext context) {
    return Container(
      color: ThemeColor.colorRed,
      width: double.infinity,
      height: 100,
      child: Container(
          decoration: BoxDecoration(
              color: Colors.white,
              borderRadius: BorderRadius.all(Radius.circular(30)),
              //背景颜色
              border: Border.all(width: 1, color: ThemeColor.colorRed)),
          margin: EdgeInsets.fromLTRB(20, 40, 20, 10),
          child: Align(
            alignment: Alignment.centerLeft,
            child: Row(
              children: [
                Padding(
                  padding: EdgeInsets.fromLTRB(20, 0, 0, 0),
                ),
                Text(content)
              ],
            ),
          )),
    );
  }
}
