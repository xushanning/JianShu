import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class ProjectPage extends StatefulWidget {
  final String name;

  ProjectPage({this.name = "这是project页面"});

  @override
  State<StatefulWidget> createState() {
    return _ProjectState();
  }
}

class _ProjectState extends State<ProjectPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      //可以直接通过widget获取属性值
      body: Column(
        children: [
          Text(widget.name),
          Text(widget.name),
          Text(widget.name),
          Text(widget.name),
          Text(widget.name),
          Text(widget.name),
        ],
      ),
    );
  }
}
