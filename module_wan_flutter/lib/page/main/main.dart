import 'package:flutter/material.dart';
import 'package:module_wan_flutter/page/home/home.dart';
import 'package:module_wan_flutter/page/project/project.dart';

class MainPage extends StatefulWidget {
  final index;

  MainPage({Key key, this.index = 0}) : super(key: key);

  @override
  State<StatefulWidget> createState() {
    return _MainPageState(curIndex: index);
  }
}

class _MainPageState extends State<MainPage> {
  int curIndex;

  List pageList = [
    HomePage(),
    ProjectPage(),
    HomePage(),
    HomePage(),
    HomePage()
  ];

  _MainPageState({this.curIndex = 0});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: this.pageList[this.curIndex],
      bottomNavigationBar: new BottomNavigationBar(
        currentIndex: this.curIndex,
        onTap: (index) {
          setState(() {
            this.curIndex = index;
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
