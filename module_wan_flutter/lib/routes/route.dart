import 'package:flutter/material.dart';
import 'package:module_wan_flutter/page/home/home.dart';
import 'package:module_wan_flutter/page/main/main.dart';

final routes = {
  '/main': (context) => MainPage(),
  "/home": (context) => HomePage(),
};

// ignore: top_level_function_literal_block
final onGenerateRoute = (RouteSettings settings) {
  final String name = settings.name;
  final Function pageContentBuilder = routes[name];
  if (pageContentBuilder != null) {
    if (settings.arguments != null) {
      final Route route = MaterialPageRoute(
          builder: (context) =>
              pageContentBuilder(context, argumens: settings.arguments));
      return route;
    } else {
      final Route route =
          MaterialPageRoute(builder: (context) => pageContentBuilder(context));
      return route;
    }
  }
  return null;
};
