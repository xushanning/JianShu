import 'package:flutter/material.dart';
import 'package:module_wan_flutter/page/main/tabs.dart';

///StatefulWidget的createState要接收一个State去管理状态
class MainPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return _MainPageState();
  }
}

class _MainPageState extends State<MainPage> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(primarySwatch: Colors.blue),
      home: Tabs(),
    );
  }
}
