import 'package:flutter/material.dart';
import 'package:module_wan_flutter/routes/route.dart';
import 'package:provider/provider.dart';

///代码千万行，注释第一行，代码不规范，同事两行泪
void main() => runApp(new MaterialApp(
      //去掉debug图标
      debugShowCheckedModeBanner: false,
      title: 'title',
      theme: ThemeData(primarySwatch: Colors.blue),
      initialRoute: '/main',
      onGenerateRoute: onGenerateRoute,
    ));
