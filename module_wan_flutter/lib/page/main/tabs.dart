import 'package:flutter/material.dart';
import 'package:module_wan_flutter/page/home/home.dart';

class Tabs extends StatefulWidget {
  final index;

  Tabs({Key key, this.index = 0}) : super(key: key);

  @override
  State<StatefulWidget> createState() {
    return _TabsState(index);
  }
}

class _TabsState extends State<Tabs> {
  int _curIndex = 0;

  List _pageList = [HomePage(), HomePage(), HomePage(), HomePage(), HomePage()];

  _TabsState(index) {
    this._curIndex = index;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: this._pageList[this._curIndex],
      bottomNavigationBar: new BottomNavigationBar(
        currentIndex: this._curIndex,
        onTap: (index) {
          setState(() {
            this._curIndex = index;
          });
        },
        //选中颜色
        selectedItemColor: Color(0xFFF85959),
        type: BottomNavigationBarType.fixed,
        items: [
          BottomNavigationBarItem(icon: Icon(Icons.home), label: "首页"),
          BottomNavigationBarItem(icon: Icon(Icons.computer), label: "项目"),
          BottomNavigationBarItem(icon: Icon(Icons.crop_square), label: "广场"),
          BottomNavigationBarItem(icon: Icon(Icons.chat), label: "公众号"),
          BottomNavigationBarItem(icon: Icon(Icons.person), label: "我的")
        ],
      ),
    );
  }
}
